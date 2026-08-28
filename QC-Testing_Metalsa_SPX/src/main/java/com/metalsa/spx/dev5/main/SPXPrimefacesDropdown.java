package com.metalsa.spx.dev5.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ====================================================================================
 * Class Name: SPXPrimefacesDropdown
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de la interaccion especifica con componentes
 *              SelectOneMenu (dropdowns) de PrimeFaces dentro del framework de
 *              automatizacion SPX.
 *
 *              Esta clase centraliza: - Seleccion de la primera opcion
 *              disponible entre varias alternativas. - Seleccion aleatoria de
 *              opciones (omitiendo el valor por defecto). - Scroll interno de
 *              contenedores de dropdown con listas largas. - Deteccion de
 *              dropdowns sin seleccion valida (placeholders multi-idioma).
 *
 *              Objetivo: Aislar la complejidad especifica de los SelectOneMenu
 *              de PrimeFaces (paneles flotantes, listas virtuales, scroll
 *              interno) del resto de las interacciones genericas de
 *              SPXElementActions.
 *              ====================================================================================
 */
public class SPXPrimefacesDropdown {

	// =========================================================================
	// Dependencies
	// =========================================================================

	private final WebDriver driver;
	private final SPXLogger logger;
	private final SPXSyncUtils syncUtils;
	private final SPXElementActions elementActions;
	private final SPXEvidenceManager evidenceManager;

	// =========================================================================
	// Constructor
	// =========================================================================

	/**
	 * Constructor principal de la clase.
	 *
	 * @param driver          instancia activa del WebDriver, provista por
	 *                        SPXDriverManager.
	 * @param logger          instancia de SPXLogger utilizada para registrar trazas
	 *                        y errores.
	 * @param syncUtils       instancia de SPXSyncUtils utilizada para sincronizar
	 *                        con AJAX antes de leer las opciones.
	 * @param elementActions  instancia de SPXElementActions utilizada para clicks,
	 *                        esperas de visibilidad y validaciones de existencia
	 *                        sobre las opciones del dropdown.
	 * @param evidenceManager instancia de SPXEvidenceManager utilizada para
	 *                        capturar evidencia tras el scroll/click sobre una
	 *                        opcion.
	 */
	public SPXPrimefacesDropdown(WebDriver driver, SPXLogger logger, SPXSyncUtils syncUtils,
			SPXElementActions elementActions, SPXEvidenceManager evidenceManager) {
		this.driver = driver;
		this.logger = logger;
		this.syncUtils = syncUtils;
		this.elementActions = elementActions;
		this.evidenceManager = evidenceManager;
	}

	// =========================================================================
	// Option Selection
	// =========================================================================

	/*
	 * @name: selectPrimefacesOption
	 * 
	 * @date: 21/Nov/2025
	 * 
	 * @param: By lblDropdown, By panel, By... options
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando
	 * 
	 * @description: Este metodo abre un dropdown de PrimeFaces y selecciona la
	 * primera opcion disponible entre las enviadas, validando visibilidad,
	 * presencia y manejando errores controlados.
	 */
	public void selectPrimefacesOption(By lblDropdown, By panel, By... options) {
		try {
			logger.reporterLog("Select Primefaces Option...");

			// 1. Click en el label para abrir el dropdown
			elementActions.click(lblDropdown);

			// 2. Esperar el panel visible
			elementActions.waitForElementVisible(panel, 30);

			// 3. Buscar la primera opcion disponible
			for (By option : options) {

				if (elementActions.isElementPresent(option)) {

					elementActions.waitForElementVisible(option, 30);
					elementActions.click(option);

					logger.reporterLog("Opcion seleccionada: " + option.toString());
					return; // Seleccion exitosa
				}
			}

			// Si llego aqui, no encontro ninguna opcion
			logger.logFrameworkErrorSimple("> Ninguna de las opciones enviadas existe en el dropdown.");

		} catch (TimeoutException te) {
			logger.logFrameworkError("> No fue posible encontrar el panel o las opciones del dropdown.", te);
			te.printStackTrace();

		} catch (Exception e) {
			logger.logFrameworkError("> Ocurrio un error inesperado en selectPrimefacesOption.", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: selectRandomPrimefacesOption
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By label, By panel, By options, String fieldName
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Despliega un componente desplegable de PrimeFaces, omite la
	 * opcion inicial por defecto, selecciona una de las opciones validas restantes
	 * al azar de forma dinamica y reporta la seleccion realizada.
	 */
	public void selectRandomPrimefacesOption(By label, By panel, By options, String fieldName) {
		elementActions.click(label);
		WebElement panelElement = elementActions.waitForVisibility(panel);
		syncUtils.waitForPrimefacesAjax();

		List<WebElement> optionElements = driver.findElements(options);
		List<String> optionLabels = new ArrayList<>();

		// Comenzamos en i = 1 para omitir la primera opcion (default)
		for (int i = 1; i < optionElements.size(); i++) {
			optionLabels.add(optionElements.get(i).getAttribute("data-label"));
		}

		// Validacion por si la lista solo tenia la opcion por defecto
		if (optionLabels.isEmpty()) {
			throw new RuntimeException("No hay opciones validas para seleccionar en: " + fieldName);
		}

		String randomLabel = optionLabels.get(new Random().nextInt(optionLabels.size()));

		String panelId = panelElement.getAttribute("id");
		By optSelected = By.xpath("//div[@id='" + panelId + "']//li[@data-label='" + randomLabel + "']");
		WebElement optionToClick = driver.findElement(optSelected);
		elementActions.scrollIntoView(optionToClick);
		optionToClick.click();

		logger.reporterLog(fieldName + " seleccionado aleatoriamente: " + randomLabel);
	}

	// =========================================================================
	// Internal Scroll Dropdown
	// =========================================================================

	/*
	 * @name: scrollIntoDropdownAndClick
	 *
	 * @date: 08/Jun/2026
	 *
	 * @param: By containerLocator, By itemLocator
	 *
	 * @return: void
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description: Resuelve el problema de dropdowns PrimeFaces (ui-selectonemenu)
	 * donde el elemento destino esta fuera del viewport interno del contenedor.
	 *
	 * El problema raiz: - scrollIntoView() hace scroll de la PAGINA, no del
	 * contenedor interno. - waitForElementClickable() falla porque el <li> nunca es
	 * visible dentro del contenedor aunque exista en el DOM.
	 *
	 * Solucion: 1. Espera que el contenedor sea visible (dropdown abierto). 2.
	 * Localiza el <li> via presenceOfElementLocated (no visibilityOf). 3. Hace
	 * scroll INTERNO del contenedor hasta el <li> usando JS. 4. Ejecuta JS click
	 * directo — evita re-validacion de clickability que volveria a fallar por el
	 * mismo problema de viewport.
	 *
	 * Uso tipico: PrimeFaces SelectOneMenu con listas largas donde la opcion
	 * deseada queda fuera del area visible del dropdown.
	 */
	public void scrollIntoDropdownAndClick(By containerLocator, By itemLocator) {
		try {
			logger.reporterLog("scrollIntoDropdownAndClick -> container: " + containerLocator);
			logger.reporterLog("scrollIntoDropdownAndClick -> item: " + itemLocator);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			// 1. Esperar que el contenedor del dropdown este visible (panel abierto)
			WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerLocator));
			logger.reporterLog("[SUCCESS] Contenedor del dropdown visible.");

			// 2. Localizar el <li> por presencia en DOM — NO por visibilidad, ya que
			// puede estar fuera del viewport interno del contenedor.
			WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(itemLocator));
			logger.reporterLog("[SUCCESS] Item localizado en DOM: " + itemLocator);

			// 3. Scroll INTERNO: desplaza el contenedor hasta que el <li> sea visible
			// scrollTop del contenedor = offsetTop del item relativo al contenedor.
			// Esto mueve el scroll del contenedor, NO el de la pagina.
			js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", container, item);
			logger.reporterLog("[SUCCESS] Scroll interno ejecutado sobre el contenedor.");

			// 4. Pequena pausa para que PrimeFaces estabilice el render tras el
			// scroll. No usar Thread.sleep — usar wait explicito sobre visibilidad
			// del item
			wait.until(ExpectedConditions.visibilityOf(item));
			logger.reporterLog("[SUCCESS] Item visible tras scroll interno.");

			// 5. JS click directo — evita que waitForElementClickable vuelva a
			// ejecutar scrollIntoView sobre la pagina y pierda el scroll interno
			js.executeScript("arguments[0].click();", item);
			logger.reporterLog("[SUCCESS] JS click ejecutado sobre item: " + itemLocator);

			evidenceManager.takeScreenshot();

		} catch (TimeoutException e) {
			logger.logFrameworkError("> Timeout en scrollIntoDropdownAndClick. Item: " + itemLocator, e);
			throw e;
		} catch (Exception e) {
			logger.logFrameworkError("> Error en scrollIntoDropdownAndClick. Item: " + itemLocator, e);
			throw new RuntimeException("scrollIntoDropdownAndClick failed for: " + itemLocator, e);
		}
	}

	// =========================================================================
	// Dropdown State Validation
	// =========================================================================

	/*
	 * @name: isDropdownWithoutSelection
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description:
	 * 
	 * Este metodo valida si un dropdown de PrimeFaces continua mostrando un valor
	 * por defecto y aun NO tiene una seleccion valida.
	 * 
	 * Se utiliza principalmente para:
	 * 
	 * 1. Validaciones previas antes de capturar informacion. 2. Evitar
	 * re-seleccionar valores ya capturados. 3. Detectar placeholders multilenguaje.
	 * 4. Validaciones de campos obligatorios.
	 * 
	 * Ejemplos de valores default:
	 * 
	 * - "Seleccione" - "Select One" - "Selecione" - "Categorias" - "Categories" -
	 * "Familias" - "Subfamilias"
	 * 
	 * Compatible con:
	 * 
	 * - PrimeFaces SelectOneMenu - Labels - Spans - Dropdowns renderizados
	 * dinamicamente
	 */
	public boolean isDropdownWithoutSelection(By locator) {
		try {

			// =========================================================
			// VALIDAR EXISTENCIA
			// =========================================================
			if (!elementActions.isElementPresent(locator)) {
				return true;
			}

			// =========================================================
			// OBTENER TEXTO ACTUAL DEL DROPDOWN
			// =========================================================
			String value = elementActions.getText(locator).trim().toLowerCase();

			// =========================================================
			// VALIDAR TEXTO VACIO
			// =========================================================
			if (value.isEmpty()) {
				return true;
			}

			// =========================================================
			// LISTA DE PLACEHOLDERS / VALORES DEFAULT
			// =========================================================
			Set<String> defaultValues = Set.of("subfamilias", "subfamilies", "subfamílias", "familias", "families",
					"famílias", "categorías", "categories", "categorias", "seleccione", "select one", "selecione",
					"seleccionar", "select", "selecionar");

			// =========================================================
			// VALIDAR SI EL TEXTO ES UN PLACEHOLDER
			// =========================================================
			return defaultValues.contains(value);
		} catch (Exception e) {
			logger.logFrameworkErrorSimple("[WARNING] Error validating dropdown selection state: " + locator);
			return true;
		}
	}
}