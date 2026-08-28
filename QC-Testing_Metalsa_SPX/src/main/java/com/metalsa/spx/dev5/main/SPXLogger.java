package com.metalsa.spx.dev5.main;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * ====================================================================================
 * Class Name: SPXLogger
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de centralizar el logging y reporte de ejecucion
 *              del framework de automatizacion SPX.
 *
 *              Esta clase centraliza: - Registro de trazas en el reporte de
 *              TestNG. - Registro detallado de errores criticos (clase, metodo,
 *              linea, URL, titulo). - Registro de mensajes simples de
 *              advertencia/validacion.
 *
 *              Objetivo: Ser la unica fuente de logging del framework para que
 *              el resto de las clases (ElementActions, SyncUtils,
 *              EvidenceManager, etc.) deleguen aqui en lugar de duplicar logica
 *              de impresion/registro.
 *              ====================================================================================
 */
public class SPXLogger {

	// =========================================================================
	// WebDriver Instance
	// =========================================================================

	/**
	 * Referencia al WebDriver activo, utilizada unicamente para obtener la URL y el
	 * titulo de la pagina al momento de registrar un error.
	 */
	private final WebDriver driver;

	// =========================================================================
	// Constructor
	// =========================================================================

	/**
	 * Constructor principal de la clase.
	 *
	 * @param driver instancia activa del WebDriver, provista por SPXDriverManager,
	 *               utilizada para enriquecer los logs con URL/titulo actuales.
	 */
	public SPXLogger(WebDriver driver) {
		this.driver = driver;
	}

	// =========================================================================
	// Reporting Methods
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
	 * durante el registro.
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
	 * @description: Metodo centralizado para registrar errores criticos del
	 * framework de automatizacion.
	 * 
	 * Este metodo imprime informacion detallada del error ocurrido durante la
	 * ejecucion de pruebas automatizadas, facilitando el analisis, debugging y
	 * trazabilidad de fallos.
	 * 
	 * Incluye:
	 * 
	 * 1. Clase donde ocurrio el error. 2. Metodo que origino la excepcion. 3. Linea
	 * aproximada del fallo. 4. Mensaje personalizado del framework. 5. URL actual
	 * del navegador. 6. Titulo actual de la pagina. 7. Tipo de excepcion
	 * Selenium/Java. 8. Detalle tecnico del error. 9. Metodo y linea origen de la
	 * excepcion.
	 * 
	 * Beneficios:
	 * 
	 * - Centralizacion de logs del framework. - Facilita debugging en Jenkins/Azure
	 * DevOps. - Ayuda en analisis de fallos automatizados. - Mejora trazabilidad de
	 * ejecucion QA. - Compatible con Selenium y PrimeFaces. - Reduce tiempo de
	 * analisis de incidencias.
	 */
	public void logFrameworkError(String message, Exception e) {

		System.out.println("\n=================================================");

		try {

			// Obtiene informacion del metodo que invoco el logger.
			StackTraceElement stackTrace = getCallerMethod();

			System.out.println("CLASS: " + this.getClass().getName());
			System.out.println("METHOD: " + stackTrace.getMethodName());
			System.out.println("LINE: " + stackTrace.getLineNumber());

		} catch (Exception stackException) {

			System.out.println("Unable to get method information.");
		}

		// Mensaje personalizado enviado desde el framework.
		System.out.println("ERROR: " + message);

		try {

			// Obtiene informacion actual del navegador.
			System.out.println("URL: " + driver.getCurrentUrl());
			System.out.println("TITLE: " + driver.getTitle());

		} catch (Exception driverException) {

			System.out.println("Unable to get URL/TITLE");
		}

		// Informacion detallada de excepcion.
		if (e != null) {

			System.out.println("CAUSE: " + e.getClass().getSimpleName());
			System.out.println("DETAIL: " + e.getMessage());

			// Obtiene el punto exacto donde se origino la excepcion.
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
	 * @name: logFrameworkErrorSimple
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: String message
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo centralizado para registrar mensajes de error simples
	 * dentro del framework de automatizacion.
	 * 
	 * Este metodo se utiliza principalmente para:
	 * 
	 * - Validaciones controladas. - Advertencias funcionales. - Mensajes de
	 * debugging. - Errores sin excepcion Java/Selenium.
	 * 
	 * Incluye:
	 * 
	 * 1. Clase donde ocurrio el evento. 2. Metodo que ejecuto el logger. 3. Linea
	 * aproximada de ejecucion. 4. Mensaje personalizado. 5. URL actual del
	 * navegador. 6. Titulo actual de la pagina.
	 * 
	 * Beneficios:
	 * 
	 * - Estandarizacion de logs QA. - Mejor trazabilidad de ejecucion. - Soporte
	 * para debugging rapido. - Facilita analisis funcional. - Compatible con
	 * ambientes CI/CD.
	 */
	public void logFrameworkErrorSimple(String message) {

		System.out.println("\n=================================================");

		try {

			// Obtiene informacion del metodo que invoco el logger.
			StackTraceElement stackTrace = getCallerMethod();

			System.out.println("CLASS: " + this.getClass().getName());
			System.out.println("METHOD: " + stackTrace.getMethodName());
			System.out.println("LINE: " + stackTrace.getLineNumber());

		} catch (Exception stackException) {

			System.out.println("Unable to get method information.");
		}

		// Mensaje personalizado enviado desde el framework.
		System.out.println("ERROR: " + message);

		try {

			// Obtiene informacion actual del navegador.
			System.out.println("URL: " + driver.getCurrentUrl());
			System.out.println("TITLE: " + driver.getTitle());

		} catch (Exception ex) {

			System.out.println("Unable to get URL/TITLE");
		}

		System.out.println("=================================================\n");
	}

	// =========================================================================
	// Private Helpers
	// =========================================================================

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
	 * que invoco internamente al logger del framework.
	 * 
	 * Este metodo analiza el stacktrace actual del hilo de ejecucion para
	 * identificar el origen real de la llamada.
	 * 
	 * El objetivo principal es mejorar la trazabilidad y debugging de errores
	 * durante la ejecucion de pruebas automatizadas.
	 * 
	 * El metodo filtra automaticamente:
	 * 
	 * - Metodos internos del logger. - Metodos auxiliares del framework. - Clases
	 * internas del sistema Thread.
	 * 
	 * Informacion obtenida:
	 * 
	 * 1. Nombre de la clase. 2. Nombre del metodo. 3. Linea aproximada de
	 * ejecucion.
	 * 
	 * Beneficios:
	 * 
	 * - Mayor precision en logs QA. - Evita dependencias de indices fijos del
	 * stacktrace. - Compatible con multiples niveles de llamadas. - Mejora analisis
	 * de errores en CI/CD. - Facilita debugging avanzado en Selenium. - Permite
	 * generar logs mas profesionales.
	 * 
	 * Uso principal:
	 * 
	 * - logFrameworkError() - logFrameworkErrorSimple()
	 */
	private StackTraceElement getCallerMethod() {

		// Obtiene el stacktrace actual del hilo en ejecucion.
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		// Recorre todos los elementos del stacktrace para identificar el metodo
		// llamador real.
		for (StackTraceElement element : stackTrace) {

			// Ignora metodos internos del framework y clases del sistema.
			if (!element.getMethodName().contains("logFrameworkError")
					&& !element.getMethodName().contains("getCallerMethod")
					&& !element.getClassName().equals(Thread.class.getName())) {

				return element;
			}
		}

		// Retorna el ultimo elemento disponible como fallback en caso de no
		// encontrar coincidencias validas.
		return stackTrace[stackTrace.length - 1];
	}
}