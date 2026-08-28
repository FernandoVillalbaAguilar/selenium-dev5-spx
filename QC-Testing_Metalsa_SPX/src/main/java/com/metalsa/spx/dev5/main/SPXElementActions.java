package com.metalsa.spx.dev5.main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ====================================================================================
 * Class Name: SPXElementActions
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de la interaccion basica con elementos web
 *              dentro del framework de automatizacion SPX (obtencion, clicks,
 *              escritura, esperas, scroll y validaciones de
 *              estado/visibilidad).
 *
 *              Esta clase centraliza: - Obtencion sincronizada de elementos
 *              (AJAX + BlockUI + reintentos). - Clicks robustos (nativo con
 *              fallback JavaScript). - Escritura de texto con reintentos. -
 *              Esperas explicitas de presencia/visibilidad/clickabilidad. -
 *              Validaciones de existencia, visibilidad y estado
 *              (habilitado/deshabilitado).
 *
 *              Objetivo: Ser el "wrapper" central de Selenium que consumen el
 *              resto de las clases del framework (SPXPrimefacesDropdown,
 *              SPXFormValidation, SPXActionWithEvidence, Page Objects).
 *              ====================================================================================
 */
public class SPXElementActions {

	// =========================================================================
	// Dependencies
	// =========================================================================

	private final WebDriver driver;
	private final SPXLogger logger;
	private final SPXSyncUtils syncUtils;
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
	 *                        con AJAX/BlockUI antes de interactuar con los
	 *                        elementos.
	 * @param evidenceManager instancia de SPXEvidenceManager utilizada para
	 *                        capturar evidencia visual en validaciones de
	 *                        visibilidad/estado.
	 */
	public SPXElementActions(WebDriver driver, SPXLogger logger, SPXSyncUtils syncUtils,
			SPXEvidenceManager evidenceManager) {
		this.driver = driver;
		this.logger = logger;
		this.syncUtils = syncUtils;
		this.evidenceManager = evidenceManager;
	}

	// =========================================================================
	// Element Retrieval
	// =========================================================================

	/*
	 * @name: getElement
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo centralizado para la obtencion de elementos
	 * interactuables que sincroniza peticiones AJAX y overlays de PrimeFaces,
	 * aplica desplazamiento centrado al elemento y gestiona reintentos por
	 * elementos obsoletos.
	 */
	public WebElement getElement(By locator) {
		int attempts = 0;
		Exception lastException = null;
		while (attempts < 3) {
			try {
				logger.reporterLog("Getting element: " + locator);
				syncUtils.waitForBlockUIToDisappear();
				syncUtils.waitForPrimefacesAjax();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariablesSPX.DEFAULT_TIMEOUT));
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
				logger.reporterLog("[SUCCESS] Element obtained successfully.");
				return element;
			} catch (StaleElementReferenceException e) {
				attempts++;
				lastException = e;
				logger.reporterLog("[WARNING] Stale element detected. Retry: " + attempts);
			} catch (TimeoutException e) {
				logger.logFrameworkError("> Element not visible: " + locator, e);
				logger.reporterLog("[ERROR] Timeout waiting for element: " + locator);
				throw e;
			} catch (Exception e) {
				logger.logFrameworkError("> Unable to obtain element: " + locator, e);
				logger.reporterLog("[ERROR] Unexpected error obtaining element.");
				throw e;
			}
		}
		throw new RuntimeException("Unable to obtain element after retries: " + locator, lastException);
	}

	// =========================================================================
	// Click Actions
	// =========================================================================

	/*
	 * @name: click
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ejecuta una accion de clic sobre un elemento interactuable tras
	 * verificar su estado; incluye manejo de reintentos por elementos obsoletos y
	 * respaldo (fallback) con JavaScript si el clic nativo falla.
	 */
	public void click(By locator) {
		int attempts = 0;
		while (attempts < 3) {
			try {
				logger.reporterLog("Clicking element: " + locator);
				WebElement element = waitForElementClickable(locator);
				try {
					element.click();
					logger.reporterLog("[SUCCESS] Normal click executed.");
				} catch (Exception clickException) {
					logger.reporterLog("[WARNING] Normal click failed. Trying JS click.");
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
					logger.reporterLog("[SUCCESS] JS click executed.");
				}
				return;
			} catch (StaleElementReferenceException e) {
				attempts++;
				logger.reporterLog("[WARNING] Stale element detected. Retry: " + attempts);
			} catch (Exception e) {
				logger.logFrameworkError("Unable to click element: " + locator, e);
				logger.reporterLog("[ERROR] Click failed.");
				throw e;
			}
		}
		throw new RuntimeException("Unable to click element after retries: " + locator);
	}

	/*
	 * @name: jsClick
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite realizar click sobre un elemento utilizando
	 * JavaScriptExecutor. Es util cuando el click tradicional de Selenium no
	 * funciona debido a overlays, elementos no interactuables o problemas de
	 * renderizado (ej. PrimeFaces / AJAX).
	 */
	public void jsClick(By locator) {
		try {
			WebElement el = getElement(locator);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);

		} catch (Exception e) {
			logger.logFrameworkError("> jsClick was not clickable: " + locator, e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: clickJS
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Fuerza la ejecucion de un clic directo en el DOM mediante
	 * JavaScript utilizando un localizador By; util para omitir bloqueos por
	 * overlays o componentes nativos de PrimeFaces no interactuables directamente
	 * por Selenium.
	 */
	public void clickJS(By locator) {

		WebElement element = driver.findElement(locator);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);
	}

	/*
	 * @name: clickJS
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: WebElement element
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Fuerza la ejecucion de un clic directo en el DOM mediante
	 * JavaScript sobre una instancia WebElement previamente localizada.
	 */
	public void clickJS(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);
	}

	/*
	 * @name: clickSupr
	 * 
	 * @date: 22/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite enviar la tecla Suprimir (Delete)
	 * posicionando el cursor sobre el elemento indicado mediante Actions.
	 */
	public void clickSupr(By locator) {
		try {
			WebElement element = getElement(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).sendKeys("\u007F").perform(); // \u007F es el codigo de la tecla Supr
		} catch (Exception e) {
			logger.logFrameworkError("> Element was not clickable: " + locator, e);
			e.printStackTrace();
		}
	}

	// =========================================================================
	// Typing Actions
	// =========================================================================

	/*
	 * @name: type
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, String inputText
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ingresa una cadena de texto en un campo de entrada tras limpiar
	 * su contenido previo, implementando hasta 3 reintentos automaticos ante
	 * excepciones de elementos obsoletos (StaleElementReferenceException).
	 */
	public void type(By locator, String inputText) {
		int attempts = 0;
		while (attempts < 3) {
			try {
				logger.reporterLog("Typing text into field: " + locator);
				WebElement element = getElement(locator);
				element.clear();
				element.sendKeys(inputText);
				return;
			} catch (StaleElementReferenceException e) {
				attempts++;
				logger.reporterLog("[WARNING] Retrying type(): " + attempts);
			} catch (Exception e) {
				logger.logFrameworkError("> Unable to type into element: " + locator, e);
				throw e;
			}
		}
	}

	/*
	 * @name: typeClear
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Realiza la limpieza forzada del contenido de un campo de texto
	 * enviando la combinacion de teclas CONTROL + A y DELETE, finalizando con la
	 * captura de evidencia visual.
	 */
	public void typeClear(By locator) {
		try {
			WebElement element = getElement(locator);
			element.click();
			element.sendKeys(org.openqa.selenium.Keys.CONTROL + "a");
			element.sendKeys(org.openqa.selenium.Keys.DELETE);
			evidenceManager.takeScreenshot();
		} catch (Exception e) {
			logger.logFrameworkError("> Unable to clear element: " + locator, e);
			throw e;
		}
	}

	// =========================================================================
	// Explicit Waits
	// =========================================================================

	/*
	 * @name: waitForElementPresent
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ejecuta una espera explicita hasta que el elemento especificado
	 * por el localizador se encuentre presente en el DOM, utilizando el tiempo de
	 * espera predeterminado del framework.
	 */
	public WebElement waitForElementPresent(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariablesSPX.DEFAULT_TIMEOUT));

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/*
	 * @name: waitForElementPresent
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, int seconds
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ejecuta una espera explicita configurada con un tiempo dinamico
	 * en segundos hasta confirmar la presencia del elemento en el DOM; registra
	 * errores en el reporte si expira el tiempo.
	 */
	public WebElement waitForElementPresent(By locator, int seconds) {
		try {

			logger.reporterLog("Waiting for element presence: " + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			logger.logFrameworkError("> Element NOT present in DOM: " + locator, e);
			logger.reporterLog("[ERROR] Timeout waiting for element presence.");
			throw e;
		}
	}

	/*
	 * @name: waitForElementVisible
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, int seconds
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Evalua la visibilidad de un elemento en el DOM dentro de un
	 * tiempo limite personalizado en segundos, retornando verdadero si se muestra o
	 * falso en caso de timeout o excepcion.
	 */
	public boolean waitForElementVisible(By locator, int seconds) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

			return true;

		} catch (Exception e) {

			return false;
		}
	}

	/*
	 * @name: waitForVisibility
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Aplica una espera explicita de hasta 20 segundos hasta que el
	 * elemento especificado por el localizador sea plenamente visible e
	 * interactuable en el DOM.
	 */
	public WebElement waitForVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/*
	 * @name: waitForElementClickable
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo robusto que espera hasta que un elemento:
	 * 
	 * 1. Exista en el DOM. 2. Sea visible. 3. Sea clickeable. 4. No este bloqueado
	 * por PrimeFaces BlockUI.
	 * 
	 * Incluye: - Reintentos automaticos. - Manejo de
	 * StaleElementReferenceException. - Soporte para paginas dinamicas AJAX. -
	 * Logging para debugging.
	 */
	public WebElement waitForElementClickable(By locator) {
		int attempts = 0;
		while (attempts < 3) {
			try {

				// Espera a que desaparezca cualquier overlay de PrimeFaces o carga AJAX.
				syncUtils.waitForBlockUIToDisappear();

				// Espera explicita para elemento clickeable.
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				logger.reporterLog("Waiting for clickable element: " + locator);

				// Selenium valida: - visible - enabled - interactuable
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

				// Scroll automatico al elemento. Muy util en PrimeFaces.
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

				// Validacion adicional: evitar elementos ocultos por render dinamico.
				if (!element.isDisplayed()) {
					logger.reporterLog("[WARNING] Element found but not visible yet.");
					attempts++;
					continue;
				}
				logger.reporterLog("[SUCCESS] Element clickable: " + locator);
				return element;
			} catch (StaleElementReferenceException e) {

				// Ocurre cuando PrimeFaces reconstruye parcialmente el DOM via AJAX.
				attempts++;
				logger.reporterLog("[WARNING] Stale element detected. Retry: " + attempts);
				logger.logFrameworkError("[WARNING] Stale element detected. Retry: ", e);
			} catch (TimeoutException e) {
				logger.logFrameworkError("> Element was not clickable: " + locator, e);
				logger.reporterLog("[ERROR] Timeout waiting clickable element.");
				throw e;
			}
		}

		// Si despues de varios intentos no fue posible obtener el elemento.
		throw new RuntimeException("Unable to obtain clickable element after retries: " + locator);
	}

	// =========================================================================
	// Text Retrieval
	// =========================================================================

	/*
	 * @name: getText
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener el texto de un elemento.
	 */
	public String getText(By locator) {
		try {
			WebElement element = getElement(locator);
			String text = element.getText();
			logger.reporterLog("Text obtained: " + text);
			return text;
		} catch (Exception e) {
			logger.logFrameworkError("> Unable to obtain text from: " + locator, e);
			return "";
		}
	}

	// =========================================================================
	// Scroll Actions
	// =========================================================================

	/*
	 * @name: scrollDown
	 * 
	 * @date: 07/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Realiza scroll de la pagina hacia el elemento indicado por el
	 * locator mediante JavaScript (scrollIntoView por defecto).
	 */
	public void scrollDown(By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement flag = getElement(locator);
			js.executeScript("arguments[0].scrollIntoView();", flag);
		} catch (Exception e) {
			logger.logFrameworkError("> No realice Scroll. ", e);
		}
	}

	/*
	 * @name: scrollUp
	 * 
	 * @date: 07/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Realiza scroll de la pagina hacia el elemento indicado por el
	 * locator mediante JavaScript, alineando el elemento hacia la parte superior
	 * del viewport (scrollIntoView(true)).
	 */
	public void scrollUp(By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement flag = getElement(locator);
			js.executeScript("arguments[0].scrollIntoView(true);", flag);
		} catch (Exception e) {
			logger.logFrameworkError("> No realice Scroll. ", e);
		}
	}

	/*
	 * @name: scrollIntoView
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: WebElement element
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Desplaza la vista de la ventana del navegador mediante
	 * JavaScript para centrar el elemento objetivo dentro del viewport.
	 */
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	// =========================================================================
	// Existence / Visibility Validations
	// =========================================================================

	/*
	 * @name: isElementPresent
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite validar si un elemento existe dentro del DOM
	 * sin lanzar excepciones.
	 * 
	 * IMPORTANTE:
	 * 
	 * - NO utiliza Explicit Wait. - NO utiliza Implicit Wait. - La validacion es
	 * inmediata.
	 * 
	 * Este metodo es ideal para:
	 * 
	 * - Validaciones rapidas - Elementos opcionales - Dropdowns dinamicos -
	 * Mensajes condicionales - Componentes PrimeFaces
	 * 
	 * Funcionamiento:
	 * 
	 * findElements() devuelve:
	 * 
	 * - Lista vacia -> elemento NO existe - Lista con elementos -> elemento existe
	 * 
	 * A diferencia de findElement():
	 * 
	 * - NO lanza NoSuchElementException - Es mas estable - Mas rapido para
	 * validaciones
	 */
	public boolean isElementPresent(By locator) {
		try {
			List<WebElement> elements = driver.findElements(locator);
			return !elements.isEmpty();
		} catch (Exception e) {
			logger.logFrameworkError("El elemento no se encontro presente...", e);
			return false;
		}
	}

	/*
	 * @name: elementExistsAndVisible
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite validar de forma segura si un elemento:
	 * 
	 * 1. Existe dentro del DOM. 2. Esta visible en pantalla.
	 * 
	 * A diferencia de findElement(), este metodo utiliza findElements() para evitar
	 * NoSuchElementException cuando el elemento no existe.
	 * 
	 * Casos posibles: - El elemento NO existe -> retorna false - El elemento existe
	 * pero esta oculto -> retorna false - El elemento existe y es visible ->
	 * retorna true - Error inesperado -> retorna false
	 */
	public boolean elementExistsAndVisible(By locator) {
		try {

			// Busca TODOS los elementos que coincidan con el locator.
			// IMPORTANTE: findElements() NO lanza excepcion si el elemento no
			// existe. Simplemente devuelve una lista vacia.
			List<WebElement> elements = driver.findElements(locator);

			// Validacion 1: Si la lista esta vacia, significa que el elemento NO
			// existe dentro del DOM.
			if (elements.isEmpty()) {
				logger.reporterLog("[INFO] Element NOT present in DOM: " + locator);
				return false;
			}

			// Obtiene el primer elemento encontrado. En la mayoria de los casos el
			// locator deberia devolver un unico elemento.
			WebElement element = elements.get(0);

			// Validacion 2: Verifica si el elemento existe pero esta oculto.
			// isDisplayed() valida: - visibility - display - tamano visible
			if (!element.isDisplayed()) {
				logger.reporterLog("[INFO] Element present but NOT visible: " + locator);
				return false;
			}

			// Si llego hasta aqui: - El elemento existe - El elemento es visible
			logger.reporterLog("[INFO] Element exists and is visible: " + locator);
			return true;
		} catch (StaleElementReferenceException e) {

			// Ocurre cuando el DOM cambia mientras Selenium intenta usar el elemento.
			logger.reporterLog("[WARNING] Stale element detected: " + locator);
			return false;
		} catch (Exception e) {

			// Captura cualquier error inesperado para evitar que el framework se
			// rompa durante validaciones.
			logger.logFrameworkError("[ERROR] Unexpected error checking element: " + locator, e);
			return false;
		}
	}

	/*
	 * @name: exists
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo auxiliar utilizado para validar si un elemento existe
	 * actualmente dentro del DOM de la pagina, utilizando
	 * driver.findElements(locator) para evitar lanzar NoSuchElementException.
	 * Retorna true si existe al menos un elemento, false si no existen
	 * coincidencias.
	 */
	public boolean exists(By locator) {

		return !driver.findElements(locator).isEmpty();
	}

	/*
	 * @name: isDisplayed
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar si el elemento se encuentra
	 * visible en pantalla, registrando el resultado en el reporte y tomando siempre
	 * una captura de pantalla como evidencia (finally), sin importar el resultado
	 * de la validacion.
	 */
	public boolean isDisplayed(By locator) {
		try {
			// Buscar el elemento en la pagina usando el locator proporcionado
			WebElement element = getElement(locator);

			// Verificar si el elemento esta visible en la pantalla
			boolean visible = element.isDisplayed();

			// Si el elemento es visible
			if (visible) {
				// Registrar en el reporte que el elemento esta visible
				logger.reporterLog("Element displayed: " + locator);
			} else {
				// Aviso en consola si el elemento existe pero no es visible
				logger.logFrameworkErrorSimple("[INFO] Element found but NOT visible: " + locator);
			}

			// Devolver el estado de visibilidad (true si es visible, false si no)
			return visible;

		} catch (NoSuchElementException e) {
			logger.logFrameworkError("[INFO] Element NOT present in DOM: " + locator, e);
			return false;

		} catch (Exception e) {
			logger.logFrameworkError("[ERROR] Unexpected error checking visibility of: " + locator, e);
			return false;

		} finally {
			// Tomar una captura de pantalla siempre, independientemente del resultado
			evidenceManager.takeScreenshot();
		}
	}

	// =========================================================================
	// State Validations
	// =========================================================================

	/*
	 * @name: isElementDisabled
	 * 
	 * @date: 27/Abr/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite validar si un elemento esta deshabilitado
	 * considerando multiples condiciones: atributo HTML 'disabled', propiedad
	 * Selenium 'isEnabled()' y clase CSS 'ui-state-disabled' utilizada por
	 * PrimeFaces. Si ocurre un error durante la validacion (elemento no encontrado,
	 * timeout, etc.), se asume como DESHABILITADO para evitar falsos positivos en
	 * la automatizacion.
	 */
	public boolean isElementDisabled(By locator) {
		try {

			// Espera a que el elemento exista en el DOM (no necesariamente visible o
			// clickable aun)
			WebElement element = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.presenceOfElementLocated(locator));

			// Obtiene el atributo "class" del elemento (util para detectar estados
			// visuales como disabled en PrimeFaces)
			String classAttr = element.getAttribute("class");

			// Obtiene el atributo "disabled" del HTML (si existe, el elemento esta
			// deshabilitado)
			String disabledAttr = element.getAttribute("disabled");

			// Validacion 1: PrimeFaces usa la clase 'ui-state-disabled' para indicar
			// que esta deshabilitado
			boolean isDisabledByClass = classAttr != null && classAttr.contains("ui-state-disabled");

			// Validacion 2: Si el atributo 'disabled' existe en el HTML, el elemento
			// esta deshabilitado
			boolean isDisabledByAttr = disabledAttr != null;

			// Validacion 3: Selenium indica si el elemento esta habilitado o no
			// (fallback general)
			boolean isDisabledBySelenium = !element.isEnabled();

			// Resultado final: si cualquiera de las condiciones indica
			// deshabilitado, se considera como tal
			boolean isDisabled = isDisabledByClass || isDisabledByAttr || isDisabledBySelenium;

			// Log para debugging: muestra el estado final del elemento
			logger.reporterLog("Validando estado del elemento: " + locator + " | disabled=" + isDisabled);

			// Evidencia visual para debugging o reportes
			evidenceManager.takeScreenshot();

			// Retorna true si esta deshabilitado, false si esta habilitado
			return isDisabled;

		} catch (Exception e) {

			// Identificacion de la clase donde ocurrio el error
			logger.logFrameworkError("> No se pudo validar el estado del elemento: %s. Error: %s" + locator, e);

			// Construccion de mensaje de error detallado
			String errorMessage = String.format("> No se pudo validar el estado del elemento: %s. Error: %s", locator,
					e.getMessage());

			// Impresion en consola
			System.out.println(errorMessage);

			// Registro en logs del framework
			logger.reporterLog(errorMessage);

			// Decision importante: si ocurre un error (elemento no encontrado,
			// timeout, etc.), se asume como DESHABILITADO para evitar falsos
			// positivos en la automatizacion
			return true;
		}
	}

	/*
	 * @name: isElementContainingText
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite validar si un input, textarea o elemento
	 * contiene informacion.
	 */
	public boolean isElementContainingText(By locator) {
		try {

			WebElement element = getElement(locator);

			String tagName = element.getTagName();

			String elementText = "";

			// VALIDACION PARA INPUTS Y TEXTAREA
			if (tagName.equalsIgnoreCase("input") || tagName.equalsIgnoreCase("textarea")) {

				elementText = element.getAttribute("value");

			} else {

				elementText = element.getText();
			}

			return elementText != null && !elementText.trim().isEmpty();

		} catch (Exception e) {

			logger.logFrameworkErrorSimple("> El elemento no se encontro o ocurrio un error: ");

			return false;
		}
	}

	/*
	 * @name: hasInputValue
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
	 * Este metodo valida si un elemento tipo input o textarea contiene informacion
	 * capturada.
	 * 
	 * La validacion se realiza sobre el atributo:
	 * 
	 * - value
	 * 
	 * Retorna:
	 * 
	 * - true -> si contiene informacion valida - false -> si esta vacio, no existe
	 * o ocurre un error
	 * 
	 * Compatible con:
	 * 
	 * - input - textarea - componentes PrimeFaces basados en input
	 * 
	 * Uso recomendado:
	 * 
	 * - Validaciones previas antes de capturar informacion - Evitar sobrescribir
	 * datos existentes - Validaciones rapidas de formularios
	 * 
	 * Ejemplo:
	 * 
	 * if (!hasInputValue(txtUserName)) { type(txtUserName, "Fernando"); }
	 */
	public boolean hasInputValue(By locator) {
		try {

			// =========================================================
			// VALIDAR EXISTENCIA EN DOM
			// =========================================================
			if (!isElementPresent(locator)) {
				logger.logFrameworkErrorSimple("[INFO] Element NOT present in DOM: " + locator);
				return false;
			}

			// =========================================================
			// VALIDAR VISIBILIDAD
			// =========================================================
			if (!elementExistsAndVisible(locator)) {
				logger.logFrameworkErrorSimple("[INFO] Element present but NOT visible: " + locator);
				return false;
			}

			// =========================================================
			// OBTENER ELEMENTO
			// =========================================================
			WebElement element = getElement(locator);

			// =========================================================
			// VALIDAR TIPO DE ELEMENTO
			// =========================================================
			String tagName = element.getTagName().toLowerCase();
			if (!tagName.equals("input") && !tagName.equals("textarea")) {
				logger.logFrameworkErrorSimple("[WARNING] Element is not an input/textarea: " + locator);
				return false;
			}

			// =========================================================
			// OBTENER VALOR DEL INPUT
			// =========================================================
			String value = element.getAttribute("value");

			// =========================================================
			// VALIDAR VALOR
			// =========================================================
			return value != null && !value.trim().isEmpty();
		} catch (Exception e) {
			logger.logFrameworkErrorSimple("[WARNING] Error validating input value: " + locator);
			return false;
		}
	}

	// =========================================================================
	// Getters
	// =========================================================================

	/*
	 * @name: getDriver
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: WebDriver
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Expone la instancia del WebDriver utilizada por esta clase para
	 * que otras clases consumidoras (SPXPrimefacesDropdown, SPXFormValidation,
	 * etc.) puedan realizar operaciones puntuales sobre el mismo driver sin
	 * duplicar su referencia.
	 */
	public WebDriver getDriver() {
		return driver;
	}
}