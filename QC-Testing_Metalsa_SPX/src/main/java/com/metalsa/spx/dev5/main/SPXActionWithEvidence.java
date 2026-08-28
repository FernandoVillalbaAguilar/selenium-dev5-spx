package com.metalsa.spx.dev5.main;

import java.io.File;
import java.time.Duration;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ====================================================================================
 * Class Name: SPXActionWithEvidence
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de ejecutar acciones "documentadas" del
 *              framework de automatizacion SPX, es decir, acciones de negocio
 *              (click, escritura, carga de archivo) acompanadas de logging
 *              estandarizado y captura de evidencia antes/despues.
 *
 *              Esta clase centraliza: - Clicks documentados con evidencia. -
 *              Escritura documentada con evidencia. - Carga de archivos
 *              documentada con evidencia y validacion posterior.
 *
 *              Objetivo: Ofrecer a los Page Objects un unico punto de entrada
 *              "corporativo" para ejecutar acciones trazables, combinando
 *              SPXElementActions (interaccion), SPXSyncUtils (sincronizacion) y
 *              SPXEvidenceManager (evidencia) sin que cada Page Object tenga
 *              que orquestar esas tres clases por su cuenta.
 *              ====================================================================================
 */
public class SPXActionWithEvidence {

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
	 *                        con AJAX tras ejecutar un click.
	 * @param elementActions  instancia de SPXElementActions utilizada para clicks,
	 *                        escritura y esperas de presencia.
	 * @param evidenceManager instancia de SPXEvidenceManager utilizada para
	 *                        capturar evidencia antes y despues de cada accion.
	 */
	public SPXActionWithEvidence(WebDriver driver, SPXLogger logger, SPXSyncUtils syncUtils,
			SPXElementActions elementActions, SPXEvidenceManager evidenceManager) {
		this.driver = driver;
		this.logger = logger;
		this.syncUtils = syncUtils;
		this.elementActions = elementActions;
		this.evidenceManager = evidenceManager;
	}

	// =========================================================================
	// Click With Evidence
	// =========================================================================

	/**
	 * @name: clickWithEvidence
	 *
	 * @date: 12/Jun/2026
	 *
	 * @param: By     locator
	 * @param: String businessAction
	 *
	 * @return: TreeMap<String,String>
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description:
	 *
	 *               Metodo corporativo para ejecutar clics documentados.
	 *
	 *               Flujo QA:
	 *
	 *               1. Espera presencia del elemento. 2. Captura evidencia PREVIA.
	 *               3. Ejecuta click robusto. 4. Espera finalizacion AJAX
	 *               PrimeFaces. 5. (Evidencia POSTERIOR deshabilitada temporalmente
	 *               — ver comentario en el codigo original).
	 *
	 *               Beneficios:
	 *
	 *               - Trazabilidad uniforme. - Evidencia antes/despues. -
	 *               Reutilizable en todos los PageObjects. - Menor duplicidad.
	 */
	public TreeMap<String, String> clickWithEvidence(By locator, String businessAction) throws InterruptedException {

		TreeMap<String, String> evidence = new TreeMap<>();

		logger.reporterLog("[ACTION] " + businessAction);

		elementActions.waitForElementPresent(locator);

		// Estado inicial
		evidence.putAll(evidenceManager.safeEvidence(locator, businessAction + " - Before"));

		// Accion
		elementActions.click(locator);

		// Sincronizacion
		syncUtils.waitForPrimefacesAjax();

		// Estado final (deshabilitado en el codigo original — se conserva
		// comentado para respetar el comportamiento fuente)
		// evidence.putAll(evidenceManager.safeEvidence(locator, businessAction + "
		// - After"));

		logger.reporterLog("[SUCCESS] " + businessAction);

		return evidence;
	}

	// =========================================================================
	// Type With Evidence
	// =========================================================================

	/*
	 * @name: typeWithEvidence
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, String value, String businessAction
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ingresa texto en un campo objetivo registrando el flujo en la
	 * bitacora y recopilando captura de evidencia visual antes y despues de la
	 * interaccion.
	 */
	public TreeMap<String, String> typeWithEvidence(By locator, String value, String businessAction) {

		TreeMap<String, String> evidence = new TreeMap<>();

		logger.reporterLog("[ACTION] " + businessAction);

		elementActions.waitForElementPresent(locator);

		evidence.putAll(evidenceManager.safeEvidence(locator, businessAction + " - Before"));

		elementActions.type(locator, value);

		evidence.putAll(evidenceManager.safeEvidence(locator, businessAction + " - After"));

		logger.reporterLog("[SUCCESS] " + businessAction);

		return evidence;
	}

	// =========================================================================
	// Upload With Evidence
	// =========================================================================

	/*
	 * @name: uploadWithEvidence
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String filePath, By uploadLocator, By validationLocator, String
	 * businessAction
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Realiza la carga de un archivo en el sistema recopilando
	 * evidencia previa, verificando la visibilidad del elemento de validacion
	 * posterior al envio y capturando evidencia del resultado exitoso.
	 */
	public TreeMap<String, String> uploadWithEvidence(String filePath, By uploadLocator, By validationLocator,
			String businessAction) {

		TreeMap<String, String> evidence = new TreeMap<>();

		logger.reporterLog("[ACTION] " + businessAction);

		evidence.putAll(evidenceManager.safeEvidence(uploadLocator, businessAction + " - Before Upload"));

		uploadFile(filePath, uploadLocator);

		if (!elementActions.elementExistsAndVisible(validationLocator)) {

			throw new RuntimeException(businessAction + " - Upload completed but validation element not found.");
		}

		evidence.putAll(evidenceManager.safeEvidence(validationLocator, businessAction + " - After Upload"));

		logger.reporterLog("[SUCCESS] " + businessAction);

		return evidence;
	}

	/*
	 * @name: uploadFile
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String path, By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Upload robusto para PrimeFaces usando presenceOfElementLocated
	 * + validacion de estabilizacion post-upload. Envia la ruta absoluta del
	 * archivo directamente al input (aunque este oculto) y aplica una espera corta
	 * de estabilizacion configurada en GlobalVariablesSPX.UPLOAD_STABILIZATION.
	 */
	public void uploadFile(String path, By locator) {

		try {
			logger.reporterLog("Uploading file: " + path);

			File file = new File(path);
			String absolutePath = file.getAbsolutePath();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// 1. Obtener input aunque este oculto
			WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

			// 2. Enviar archivo
			uploadElement.sendKeys(absolutePath);
			logger.reporterLog("[SUCCESS] File sent to input.");

			// 3. Espera corta de estabilizacion (NO AJAX generico)
			Thread.sleep(GlobalVariablesSPX.UPLOAD_STABILIZATION);

			// 5. Evidencia del upload (a cargo del llamador via uploadWithEvidence)

		} catch (TimeoutException e) {
			logger.logFrameworkError("> Upload input NOT present: " + locator, e);
			throw e;

		} catch (Exception e) {
			logger.logFrameworkError("> Unable to upload file.", e);
			throw new RuntimeException(e);
		}
	}
}