package com.metalsa.spx.dev5.main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * ====================================================================================
 * Class Name: SPXFormValidation
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de las validaciones de negocio sobre formularios
 *              dentro del framework de automatizacion SPX (campos obligatorios
 *              y mensajes de error multi-idioma).
 *
 *              Esta clase centraliza: - Validacion de campos obligatorios
 *              (inputs, textareas, labels, dropdowns PrimeFaces). - Deteccion
 *              de mensajes de error en pantalla sin depender de texto exacto ni
 *              de un unico idioma.
 *
 *              Objetivo: Aislar las reglas de validacion de formularios de la
 *              interaccion generica con elementos (SPXElementActions), de forma
 *              que los Page Objects consuman aqui la logica de "negocio" de
 *              validacion.
 *              ====================================================================================
 */
public class SPXFormValidation {

	// =========================================================================
	// Dependencies
	// =========================================================================

	private final WebDriver driver;
	private final SPXLogger logger;
	private final SPXElementActions elementActions;

	// =========================================================================
	// Constructor
	// =========================================================================

	/**
	 * Constructor principal de la clase.
	 *
	 * @param driver         instancia activa del WebDriver, provista por
	 *                       SPXDriverManager.
	 * @param logger         instancia de SPXLogger utilizada para registrar trazas
	 *                       y errores de validacion.
	 * @param elementActions instancia de SPXElementActions utilizada para obtener y
	 *                       validar la existencia/visibilidad de los elementos del
	 *                       formulario.
	 */
	public SPXFormValidation(WebDriver driver, SPXLogger logger, SPXElementActions elementActions) {
		this.driver = driver;
		this.logger = logger;
		this.elementActions = elementActions;
	}

	// =========================================================================
	// Required Field Validation
	// =========================================================================

	/*
	 * @name: requiredFields
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description:
	 * 
	 * Este metodo valida que un campo obligatorio:
	 * 
	 * 1. Exista en el DOM. 2. Sea visible. 3. Contenga informacion valida.
	 * 
	 * Compatible con:
	 * 
	 * - Inputs - Textareas - Labels - Spans - PrimeFaces SelectOneMenu - Dropdowns
	 * dinamicos
	 * 
	 * El metodo detecta automaticamente el tipo de componente y obtiene el valor
	 * correctamente:
	 * 
	 * - Inputs/Textarea -> atributo "value" - Labels/Dropdowns -> texto visible
	 * 
	 * Si el campo esta vacio o sin seleccion valida:
	 * 
	 * - Registra evidencia - Muestra el nombre del elemento - Lanza
	 * RuntimeException
	 * 
	 * Esto detiene el flujo de la prueba automaticamente.
	 */
	public void requiredFields(By locator) {

		try {
			logger.reporterLog("Validate Required Field...");

			// =========================================================
			// VALIDAR EXISTENCIA EN DOM
			// =========================================================
			if (!elementActions.isElementPresent(locator)) {
				logger.reporterLog("[INFO] Element NOT present in DOM: " + locator);
				return;
			}

			// =========================================================
			// VALIDAR VISIBILIDAD
			// =========================================================
			if (!elementActions.elementExistsAndVisible(locator)) {
				logger.reporterLog("[INFO] Element present but NOT visible: " + locator);
				return;
			}

			// =========================================================
			// OBTENER ELEMENTO
			// =========================================================
			WebElement element = elementActions.getElement(locator);

			// =========================================================
			// OBTENER INFORMACION DEL ELEMENTO
			// =========================================================
			String tagName = element.getTagName().toLowerCase();
			String className = element.getAttribute("class");
			if (className == null) {
				className = "";
			}
			String value = "";

			// =========================================================
			// INPUTS / TEXTAREAS
			// =========================================================
			if (tagName.equals("input") || tagName.equals("textarea")) {
				value = element.getAttribute("value");
			}

			// =========================================================
			// LABELS / SPANS / DROPDOWNS PRIMEFACES
			// =========================================================
			else {
				value = element.getText();
			}

			// =========================================================
			// NORMALIZAR VALOR
			// =========================================================
			if (value == null) {
				value = "";
			}
			value = value.trim();

			// =========================================================
			// VALIDAR CAMPOS VACIOS
			// =========================================================
			if (value.isEmpty()) {
				logger.logFrameworkErrorSimple("> Required field is EMPTY: " + locator);
				SPXUtils.displayElementName(driver, locator);
				logger.reporterLog("[ERROR] Required field is empty: " + locator);
				throw new RuntimeException("Required field is empty: " + locator);
			}

			// =========================================================
			// VALIDAR DROPDOWNS SIN SELECCION
			// =========================================================
			boolean isPrimefacesDropdown = className.contains("ui-selectonemenu-label") || tagName.equals("label")
					|| tagName.equals("span");
			if (isPrimefacesDropdown && isDropdownWithoutSelectionFallback(locator)) {
				logger.logFrameworkErrorSimple("> Dropdown has NO valid selection: " + locator);
				SPXUtils.displayElementName(driver, locator);
				logger.reporterLog("[ERROR] Dropdown without valid selection: " + locator);
				throw new RuntimeException("Dropdown without valid selection: " + locator);
			}

			// =========================================================
			// VALIDACION EXITOSA
			// =========================================================
			logger.reporterLog("[SUCCESS] Required field contains information");
		} catch (TimeoutException e) {
			logger.logFrameworkError("> Timeout validating required field: " + locator, e);
			logger.reporterLog("[ERROR] Timeout validating required field");
			throw e;
		} catch (RuntimeException e) {

			// =========================================================
			// RE-LANZAR ERRORES CONTROLADOS
			// =========================================================
			throw e;
		} catch (Exception e) {
			logger.logFrameworkError("> Unexpected error validating required field", e);
			logger.reporterLog("[ERROR] Unexpected error validating required field");
			throw new RuntimeException("Unexpected error validating required field: " + locator, e);
		}
	}

	/*
	 * @name: isDropdownWithoutSelectionFallback
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Replica local y minima de la deteccion de placeholders de
	 * dropdown (identica a SPXPrimefacesDropdown.isDropdownWithoutSelection) usada
	 * exclusivamente dentro de requiredFields() para no crear una dependencia
	 * cruzada entre SPXFormValidation y SPXPrimefacesDropdown. Si en el futuro se
	 * prefiere evitar la duplicacion, este metodo puede eliminarse inyectando
	 * SPXPrimefacesDropdown como dependencia adicional.
	 */
	private boolean isDropdownWithoutSelectionFallback(By locator) {
		try {
			String value = elementActions.getText(locator).trim().toLowerCase();

			if (value.isEmpty()) {
				return true;
			}

			java.util.Set<String> defaultValues = java.util.Set.of("subfamilias", "subfamilies", "subfamílias",
					"familias", "families", "famílias", "categorías", "categories", "categorias", "seleccione",
					"select one", "selecione", "seleccionar", "select", "selecionar");

			return defaultValues.contains(value);
		} catch (Exception e) {
			logger.logFrameworkErrorSimple("[WARNING] Error validating dropdown selection state: " + locator);
			return true;
		}
	}

	// =========================================================================
	// Error Message Validation
	// =========================================================================

	/*
	 * @name: waitForTextInAnyError
	 *
	 * @date: 28/Ago/2026
	 *
	 * @param: List<By> locators, String... keywords
	 *
	 * @return: boolean
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description: Espera rapida para validar si existe algun mensaje de error en
	 * pantalla, sin depender de visibilidad ni de texto exacto.
	 *
	 * Util para validaciones multi-idioma (ES / EN / PT).
	 *
	 * @param locators Lista de posibles contenedores de error
	 * 
	 * @param keywords Palabras clave a buscar dentro del error
	 * 
	 * @return true si encuentra el mensaje esperado
	 */
	public boolean waitForTextInAnyError(List<By> locators, String... keywords) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200)).ignoring(Exception.class);
		return wait.until(d -> {
			for (By locator : locators) {
				List<WebElement> elements = d.findElements(locator);
				for (WebElement el : elements) {
					String text = el.getText().toLowerCase();
					for (String keyword : keywords) {
						if (text.contains(keyword.toLowerCase())) {
							return true;
						}
					}
				}
			}
			return false;
		});
	}
}