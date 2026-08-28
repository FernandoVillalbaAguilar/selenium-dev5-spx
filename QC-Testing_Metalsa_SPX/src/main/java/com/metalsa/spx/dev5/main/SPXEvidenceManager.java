package com.metalsa.spx.dev5.main;

import java.io.File;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;

/**
 * ====================================================================================
 * Class Name: SPXEvidenceManager
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de la captura, almacenamiento y gestion de
 *              evidencia visual (screenshots) generada durante la ejecucion de
 *              las pruebas automatizadas del framework SPX.
 *
 *              Esta clase centraliza: - Captura de pantallas completas mediante
 *              AShot. - Registro logico de evidencias (nombre -> ruta fisica).
 *              - Limpieza de evidencias entre casos de prueba.
 *
 *              Objetivo: Aislar por completo la logica de evidencia visual para
 *              que pueda ser reutilizada tanto por las clases de interaccion
 *              (SPXElementActions) como por las de reporte
 *              (SPXWordReportGenerator).
 *              ====================================================================================
 */
public class SPXEvidenceManager {

	// =========================================================================
	// Dependencies
	// =========================================================================

	private final WebDriver driver;
	private final SPXLogger logger;
	private final SPXUtils utils;

	/**
	 * Estructura utilizada para almacenar la relacion entre el nombre logico de la
	 * captura y la ruta fisica del screenshot.
	 *
	 * Uso comun: - Evidencias de ejecucion - Reportes HTML/PDF - Integracion con
	 * ExtentReports o Allure
	 */
	private TreeMap<String, String> listaScreenShots = new TreeMap<>();

	// =========================================================================
	// Constructor
	// =========================================================================

	/**
	 * Constructor principal de la clase.
	 *
	 * @param driver instancia activa del WebDriver, provista por SPXDriverManager.
	 * @param logger instancia de SPXLogger utilizada para registrar errores y
	 *               trazas de ejecucion.
	 * @param utils  instancia de SPXUtils utilizada para obtener el nombre del caso
	 *               de prueba actual (getTestCaseName).
	 */
	public SPXEvidenceManager(WebDriver driver, SPXLogger logger, SPXUtils utils) {
		this.driver = driver;
		this.logger = logger;
		this.utils = utils;
	}

	// =========================================================================
	// Screenshot Capture
	// =========================================================================

	/*
	 * @name: takeScreenshot
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite tomar una captura de pantalla utilizando la
	 * libreria AShot y almacenarla:
	 * 
	 * - fisicamente en disco (.png) - logicamente en un TreeMap
	 * 
	 * El TreeMap almacena: key -> nombre imagen value -> ruta imagen
	 * 
	 * Beneficios: - Evidencia automatica de ejecucion - Integracion con Word/PDF -
	 * Soporte para reportes QA
	 */
	public TreeMap<String, String> takeScreenshot() {
		try {
			Screenshot screenshot = new AShot().takeScreenshot(driver);

			// Obtiene nombre actual del testcase.
			String testCaseName = utils.getTestCaseName(Reporter.getCurrentTestResult());

			// Genera nombre unico para evitar: - overwrite - colisiones - duplicados
			String uniqueId = String.valueOf(System.currentTimeMillis());
			String fileName = "QC_Testing-" + testCaseName + "-" + uniqueId;
			String pathFileName = GlobalVariablesSPX.SPX_DEV5_PATH_SCREENSHOTS + fileName + ".png";
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			listaScreenShots.put(fileName, pathFileName);
			logger.reporterLog("Screenshot captured successfully: " + fileName);
		} catch (Exception e) {
			logger.logFrameworkError("> I could not take the screenshot...", e);
			e.printStackTrace();
		}
		return listaScreenShots;
	}

	/*
	 * @name: returnSaveImage
	 * 
	 * @date: 21/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite guardar las imagenes mediante un
	 * screenshot, valida previamente (sin lanzar excepcion) si el elemento indicado
	 * existe en el DOM y registra un log informativo si no existe, pero SIEMPRE
	 * toma la captura de pantalla, exista o no el elemento.
	 */
	public TreeMap<String, String> returnSaveImage(By locator) {

		try {
			logger.reporterLog("Taking Screenshot (element may or may not exist): " + locator);

			if (!driver.findElements(locator).isEmpty()) {
				// System.out.println("Element exists: " + locator);
			} else {
				logger.logFrameworkErrorSimple("Element does not exist: " + locator);
			}

		} catch (Exception e) {
			logger.logFrameworkError("Error validating locator: " + locator, e);
			e.printStackTrace();
		}

		// SIEMPRE toma screenshot, exista o no el elemento
		return takeScreenshot();
	}

	/*
	 * @name: safeEvidence
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, String stepName
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Envoltura segura sobre returnSaveImage() que evita que un fallo
	 * en la captura de evidencia interrumpa el flujo principal de la prueba; en
	 * caso de error solo se registra una advertencia y se retorna un mapa vacio.
	 */
	public TreeMap<String, String> safeEvidence(By locator, String stepName) {
		TreeMap<String, String> map = new TreeMap<>();
		try {
			logger.reporterLog("Evidence: " + stepName);
			map.putAll(returnSaveImage(locator));
		} catch (Exception e) {
			logger.reporterLog("[WARNING] Evidence failed for: " + stepName);
		}
		return map;
	}

	// =========================================================================
	// Evidence Housekeeping
	// =========================================================================

	/*
	 * @name: clearScreenshotList
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite limpiar la coleccion de screenshots
	 * almacenados en memoria durante la ejecucion del testcase.
	 * 
	 * Recomendado usar: - Antes de iniciar un nuevo Test Case. - Despues de generar
	 * evidencias Word/PDF. - Para liberar memoria.
	 * 
	 * Beneficios: - Evita acumulacion innecesaria de imagenes. - Reduce consumo de
	 * memoria. - Evita mezclar screenshots entre testcases.
	 */
	public void clearScreenshotList() {
		try {

			// Limpia completamente el TreeMap donde se almacenan:
			// key -> nombre imagen value -> ruta imagen
			listaScreenShots.clear();
			logger.reporterLog("Screenshot list cleared successfully.");
		} catch (Exception e) {
			logger.logFrameworkError("> Unable to clear screenshot list.", e);
			e.printStackTrace();
		}
	}

	// =========================================================================
	// Getters
	// =========================================================================

	/*
	 * @name: getScreenshotList
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Expone la coleccion actual de evidencias capturadas (nombre ->
	 * ruta fisica) para que otras clases, como SPXWordReportGenerator, puedan
	 * consumirla al momento de generar el documento final.
	 */
	public TreeMap<String, String> getScreenshotList() {
		return listaScreenShots;
	}
}