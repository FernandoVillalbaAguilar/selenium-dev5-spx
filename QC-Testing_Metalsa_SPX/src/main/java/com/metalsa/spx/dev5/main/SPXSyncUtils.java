package com.metalsa.spx.dev5.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ====================================================================================
 * Class Name: SPXSyncUtils
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de la sincronizacion del framework con las
 *              peticiones asincronas de PrimeFaces (AJAX) y con las capas de
 *              bloqueo (BlockUI) generadas por la aplicacion SPX.
 *
 *              Esta clase centraliza: - Espera de finalizacion de la cola AJAX
 *              de PrimeFaces. - Espera de desaparicion del overlay BlockUI. -
 *              Sincronizacion combinada tras cargas de archivos y apertura de
 *              dropdowns.
 *
 *              Objetivo: Aislar toda la logica de sincronizacion especifica de
 *              PrimeFaces para que el resto del framework (SPXElementActions,
 *              SPXPrimefacesDropdown, etc.) la reutilice sin duplicar el
 *              JavaScript de polling.
 *              ====================================================================================
 */
public class SPXSyncUtils {

	// =========================================================================
	// Dependencies
	// =========================================================================

	private final WebDriver driver;
	private final SPXLogger logger;

	/**
	 * Localizador del contenedor de bloqueo (BlockUI) utilizado por PrimeFaces
	 * mientras procesa una peticion AJAX en segundo plano.
	 */
	private final By blockUI = By.cssSelector(".pe-blockui-content");

	// =========================================================================
	// Constructor
	// =========================================================================

	/**
	 * Constructor principal de la clase.
	 *
	 * @param driver instancia activa del WebDriver, provista por SPXDriverManager.
	 * @param logger instancia de SPXLogger utilizada para registrar trazas y
	 *               advertencias de sincronizacion.
	 */
	public SPXSyncUtils(WebDriver driver, SPXLogger logger) {
		this.driver = driver;
		this.logger = logger;
	}

	// =========================================================================
	// PrimeFaces AJAX Synchronization
	// =========================================================================

	/*
	 * @name: waitForPrimefacesAjax
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite esperar de forma explicita a que finalicen
	 * todas las peticiones AJAX ejecutadas por PrimeFaces antes de continuar con la
	 * automatizacion.
	 * 
	 * Objetivo: - Evitar uso de Thread.sleep(). - Mejorar sincronizacion Selenium +
	 * PrimeFaces. - Reducir errores intermitentes. - Esperar correctamente recargas
	 * parciales AJAX.
	 * 
	 * Funcionamiento: Selenium ejecuta continuamente un script JavaScript que
	 * valida:
	 * 
	 * PrimeFaces.ajax.Queue.isEmpty()
	 * 
	 * Cuando la cola AJAX queda vacia: -> retorna TRUE -> Selenium continua la
	 * ejecucion.
	 * 
	 * Si AJAX sigue trabajando: -> retorna FALSE -> Selenium continua esperando.
	 */
	public void waitForPrimefacesAjax() {
		try {

			// Explicit Wait: Esperara maximo 20 segundos antes de lanzar
			// TimeoutException.
			WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(20));

			// until(): Ejecuta repetidamente la funcion lambda hasta que esta retorne
			// TRUE.
			localWait.until(d -> {
				try {

					// Permite ejecutar JavaScript directamente en el navegador.
					JavascriptExecutor js = (JavascriptExecutor) d;

					// JavaScript ejecutado:
					//
					// window.PrimeFaces -> valida que PrimeFaces exista.
					// PrimeFaces.ajax -> valida que exista el manejador AJAX.
					// PrimeFaces.ajax.Queue.isEmpty() -> retorna TRUE cuando NO existen
					// peticiones AJAX pendientes.
					Object ajaxComplete = js.executeScript("return (window.PrimeFaces " + "&& PrimeFaces.ajax "
							+ "&& PrimeFaces.ajax.Queue.isEmpty());");

					// Validacion segura: confirmamos que JavaScript realmente retorno un
					// Boolean.
					if (ajaxComplete instanceof Boolean) {

						// TRUE -> AJAX finalizo FALSE -> AJAX sigue ejecutandose
						return (Boolean) ajaxComplete;
					}

					// Si el resultado no es Boolean, continuar esperando. Esto evita falsos
					// positivos de sincronizacion.
					return false;
				} catch (Exception ex) {

					// Si ocurre error: - DOM reconstruyendose - PrimeFaces aun cargando -
					// AJAX actualizando componentes - Pagina parcialmente renderizada
					// Selenium debe seguir esperando.
					logger.reporterLog("[INFO] Waiting PrimeFaces AJAX...");
					return false;
				}
			});

			// Log exitoso: Todas las peticiones AJAX finalizaron.
			logger.reporterLog("PrimeFaces AJAX requests completed successfully.");
		} catch (TimeoutException e) {

			// Si despues de 20 segundos AJAX sigue ejecutandose:
			// - No se detiene la prueba - Solo se registra advertencia
			logger.reporterLog("[WARNING] Timeout waiting for PrimeFaces AJAX queue.");
		} catch (Exception e) {

			// Captura cualquier error inesperado durante el proceso de
			// sincronizacion.
			logger.logFrameworkError("> Unexpected error waiting for PrimeFaces AJAX.", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: safeWaitForPrimefacesAjaxAfterUpload
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Variante tolerante de la espera AJAX, pensada especificamente
	 * para el flujo posterior a la carga de un archivo; con timeout reducido (5s) y
	 * sin bloquear el flujo de upload si PrimeFaces no esta disponible o la
	 * validacion falla.
	 */
	public void safeWaitForPrimefacesAjaxAfterUpload() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			wait.until(d -> {
				try {
					JavascriptExecutor js = (JavascriptExecutor) d;

					Object result = js.executeScript(
							"return (window.PrimeFaces && PrimeFaces.ajax && PrimeFaces.ajax.Queue.isEmpty());");

					return result instanceof Boolean && (Boolean) result;
				} catch (Exception e) {
					return true; // IMPORTANTE: no bloquear upload
				}
			});

		} catch (TimeoutException e) {
			logger.reporterLog("[WARNING] AJAX after upload not stable, continuing test...");
		}
	}

	/*
	 * @name: waitForAjaxAndBlockUiToFinish
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Sincroniza la ejecucion esperando la finalizacion de peticiones
	 * asincronas de PrimeFaces y la desaparicion de capas de bloqueo (blockUI);
	 * incluye monitoreo e impresion de metricas si el tiempo de espera excede el
	 * umbral de rendimiento aceptable (3000ms).
	 */
	public void waitForAjaxAndBlockUiToFinish() throws InterruptedException {
		long start = System.currentTimeMillis();
		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
		long elapsed = System.currentTimeMillis() - start;
		if (elapsed > 3000) {
			logger.reporterLog("[PERF] waitForAjaxAndBlockUiToFinish tardo " + elapsed + "ms");
		}
	}

	// =========================================================================
	// BlockUI Synchronization
	// =========================================================================

	/*
	 * @name: waitForBlockUIToDisappear
	 * 
	 * @date: 27/Abr/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite esperar a que desaparezca el overlay de
	 * bloqueo (BlockUI) generado por PrimeFaces, asegurando que los elementos de la
	 * pantalla esten disponibles para interaccion antes de ejecutar cualquier
	 * accion como click o escritura.
	 */
	public void waitForBlockUIToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(blockUI));
	}

	// =========================================================================
	// Dropdown Synchronization
	// =========================================================================

	/*
	 * @name: waitForDropdownToLoad
	 * 
	 * @date: 25/Nov/2025
	 * 
	 * @param: By optionLocator
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo espera a que un menu desplegable termine de cargar
	 * sus opciones. Primero sincroniza con las operaciones AJAX de PrimeFaces y
	 * luego verifica, con una espera explicita autocontenida en esta clase, que el
	 * elemento indicado se encuentre visible en la pagina (evita depender de
	 * SPXElementActions para no generar una dependencia circular entre ambas
	 * clases).
	 */
	public void waitForDropdownToLoad(By optionLocator) {
		waitForPrimefacesAjax();
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
		} catch (Exception e) {
			logger.reporterLog("[WARNING] Dropdown option not visible after wait: " + optionLocator);
		}
	}
}