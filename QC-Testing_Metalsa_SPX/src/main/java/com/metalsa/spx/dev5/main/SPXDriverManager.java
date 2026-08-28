package com.metalsa.spx.dev5.main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * ====================================================================================
 * Class Name: SPXDriverManager
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de gestionar el ciclo de vida del WebDriver
 *              dentro del framework de automatizacion SPX.
 *
 *              Esta clase centraliza: - Inicializacion y configuracion del
 *              navegador Chrome. - Navegacion inicial hacia la URL bajo prueba.
 *              - Cierre controlado de la sesion del navegador.
 *
 *              Objetivo: Aislar la responsabilidad de creacion, configuracion y
 *              destruccion del WebDriver, separandola de la logica de
 *              interaccion con elementos y validaciones de negocio.
 *
 *              Compatibilidad: - Selenium 4+ - Chrome moderno - Jenkins / CI-CD
 *              - Frameworks Page Object Model (POM)
 *              ====================================================================================
 */
public class SPXDriverManager {

	// =========================================================================
	// WebDriver Instance
	// =========================================================================

	/**
	 * Instancia activa del WebDriver administrada por esta clase. Se expone via
	 * getDriver() para que el resto de las clases del framework (element actions,
	 * sync utils, evidence, etc.) puedan operar sobre la misma sesion de navegador.
	 */
	protected WebDriver driver;

	// =========================================================================
	// WebDriver Initialization
	// =========================================================================

	/*
	 * @name: chromeDriverConnection
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: WebDriver
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Inicializa una instancia de Google Chrome utilizando Selenium
	 * WebDriver, aplicando la configuracion estandar del framework (ventana
	 * maximizada, notificaciones y popups deshabilitados, flags de estabilidad para
	 * ambientes Linux/CI/Docker) y estableciendo los timeouts de carga de pagina y
	 * de ejecucion de scripts. Si ocurre un error durante la inicializacion, se
	 * registra el detalle en el log del framework y se retorna null.
	 */
	public WebDriver chromeDriverConnection() {

		try {

			ChromeOptions chromeOptions = new ChromeOptions();

			// Permite compatibilidad entre Selenium y versiones recientes de Chrome.
			chromeOptions.addArguments("--remote-allow-origins=*");

			// Inicia el navegador maximizado.
			chromeOptions.addArguments("--start-maximized");

			// Deshabilita notificaciones del navegador.
			chromeOptions.addArguments("--disable-notifications");

			// Deshabilita ventanas emergentes.
			chromeOptions.addArguments("--disable-popup-blocking");

			// Oculta mensajes informativos de automatizacion.
			chromeOptions.addArguments("--disable-infobars");

			// Mejora estabilidad en ambientes Linux/CI.
			chromeOptions.addArguments("--disable-dev-shm-usage");

			// Requerido comunmente en Docker/Linux.
			chromeOptions.addArguments("--no-sandbox");

			// Configura automaticamente la version compatible de ChromeDriver.
			WebDriverManager.chromedriver().setup();

			// Inicializa navegador Chrome.
			driver = new ChromeDriver(chromeOptions);

			// Timeout maximo para carga completa de paginas.
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));

			// Timeout maximo para ejecucion de scripts.
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

			reporterLog("ChromeDriver initialized successfully.");

			return driver;

		} catch (Exception exception) {

			logFrameworkError("> Error initializing ChromeDriver connection.", exception);

			exception.printStackTrace();

			return null;
		}
	}

	/*
	 * @name: launchBrowser
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String url
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Inicializa la navegacion hacia la URL desencriptada
	 * especificada y maximiza la ventana del navegador, capturando y registrando
	 * posibles excepciones de tiempo de espera o ejecucion de WebDriver.
	 */
	public void launchBrowser(String url) {
		try {
			reporterLog("Launching ... " + url);
			driver.get(getEncrypted(url));
			driver.manage().window().maximize();
		} catch (TimeoutException e) {
			logFrameworkError("> Timeout while loading the URL: " + url, e);
			e.printStackTrace();
		} catch (WebDriverException e) {
			logFrameworkError("> WebDriver encountered an error while launching the browser: ", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: driverClose
	 * 
	 * @date: 22/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite cerrar la ventana del navegador y finalizar
	 * la sesion activa del WebDriver, validando previamente que la instancia no sea
	 * nula para evitar excepciones innecesarias.
	 */
	public void driverClose() {

		if (driver != null) {

			driver.quit();
		}
	}

	// =========================================================================
	// Auxiliary Methods (dependencias temporales de otras clases del framework)
	// =========================================================================

	/*
	 * @name: reporterLog
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String log
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Agrega un mensaje o traza personalizada en el reporte de
	 * ejecucion del caso de prueba (TestNG Reporter) manejando posibles excepciones
	 * durante el registro. NOTA: Metodo temporal incluido aqui solo como soporte
	 * interno; una vez creada la clase SPXLogger, este metodo debe eliminarse de
	 * SPXDriverManager y delegarse mediante inyeccion de dependencia.
	 */
	public void reporterLog(String log) {
		try {
			Reporter.log(log);
		} catch (TimeoutException e) {
			logFrameworkError("> The report was not made correctly...", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: logFrameworkError
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: String message, Exception e
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo centralizado para registrar errores criticos ocurridos
	 * durante la inicializacion, navegacion o cierre del WebDriver. Incluye clase,
	 * metodo y linea de origen del error, ademas de la URL/titulo actuales cuando
	 * el driver se encuentra disponible. NOTA: Metodo temporal incluido aqui solo
	 * como soporte interno; una vez creada la clase SPXLogger, este metodo debe
	 * eliminarse de SPXDriverManager y delegarse mediante inyeccion de dependencia.
	 */
	public void logFrameworkError(String message, Exception e) {

		System.out.println("\n=================================================");

		try {

			StackTraceElement stackTrace = getCallerMethod();

			System.out.println("CLASS: " + this.getClass().getName());
			System.out.println("METHOD: " + stackTrace.getMethodName());
			System.out.println("LINE: " + stackTrace.getLineNumber());

		} catch (Exception stackException) {

			System.out.println("Unable to get method information.");
		}

		System.out.println("ERROR: " + message);

		try {

			System.out.println("URL: " + driver.getCurrentUrl());
			System.out.println("TITLE: " + driver.getTitle());

		} catch (Exception driverException) {

			System.out.println("Unable to get URL/TITLE");
		}

		if (e != null) {

			System.out.println("CAUSE: " + e.getClass().getSimpleName());
			System.out.println("DETAIL: " + e.getMessage());

			if (e.getStackTrace().length > 0) {

				StackTraceElement rootError = e.getStackTrace()[0];

				System.out.println("ERROR CLASS: " + rootError.getClassName());
				System.out.println("ERROR METHOD: " + rootError.getMethodName());
				System.out.println("ERROR LINE: " + rootError.getLineNumber());
			}
		}

		System.out.println("=================================================\n");
	}

	/*
	 * @name: getCallerMethod
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: StackTraceElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo auxiliar utilizado para obtener informacion del metodo
	 * que invoco internamente al logger de esta clase, filtrando metodos internos
	 * del logger y clases del sistema Thread para identificar el origen real de la
	 * llamada. NOTA: Metodo temporal incluido aqui solo como soporte interno; una
	 * vez creada la clase SPXLogger, este metodo debe eliminarse de
	 * SPXDriverManager.
	 */
	private StackTraceElement getCallerMethod() {

		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		for (StackTraceElement element : stackTrace) {

			if (!element.getMethodName().contains("logFrameworkError")
					&& !element.getMethodName().contains("getCallerMethod")
					&& !element.getClassName().equals(Thread.class.getName())) {

				return element;
			}
		}

		return stackTrace[stackTrace.length - 1];
	}

	/*
	 * @name: getEncrypted
	 * 
	 * @date: 23/Feb/2023
	 * 
	 * @param: String encrypted
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Decodifica en Base64 la URL almacenada de forma encriptada
	 * antes de que el navegador navegue hacia ella. NOTA: Metodo temporal incluido
	 * aqui solo como soporte interno de launchBrowser(); una vez creada la clase
	 * SPXUtils, este metodo debe eliminarse de SPXDriverManager y delegarse
	 * mediante inyeccion de dependencia.
	 */
	private String getEncrypted(String encrypted) {
		try {
			byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encrypted);
			return new String(decodedBytes);
		} catch (IllegalArgumentException e) {
			logFrameworkError("> It was not possible to obtain the encryption...", e);
			e.printStackTrace();
			return null;
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
	 * @description: Expone la instancia activa del WebDriver administrada por esta
	 * clase para que otras clases del framework (element actions, sync utils,
	 * evidence manager, etc.) puedan operar sobre la misma sesion de navegador sin
	 * necesidad de crear una nueva instancia.
	 */
	public WebDriver getDriver() {
		return driver;
	}
}