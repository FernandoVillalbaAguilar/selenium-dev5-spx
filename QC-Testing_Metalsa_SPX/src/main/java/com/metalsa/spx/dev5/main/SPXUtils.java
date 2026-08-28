package com.metalsa.spx.dev5.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;

/**
 * ====================================================================================
 * Class Name: SPXUtils
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase de utilidades varias del framework de automatizacion SPX
 *              que no encajan dentro de una responsabilidad especifica (fecha,
 *              lectura de JSON, desencriptado, nombre de caso de prueba,
 *              identificacion de elementos, UEN e idioma).
 *
 *              Objetivo: Agrupar helpers de proposito general reutilizados por
 *              varias clases del framework (SPXDriverManager,
 *              SPXEvidenceManager, SPXWordReportGenerator, etc.) sin duplicar
 *              su implementacion.
 *              ====================================================================================
 */
public class SPXUtils {

	// =========================================================================
	// Dependencies
	// =========================================================================

	private final WebDriver driver;
	private final SPXLogger logger;

	// =========================================================================
	// Constructor
	// =========================================================================

	/**
	 * Constructor principal de la clase.
	 *
	 * @param driver instancia activa del WebDriver, provista por SPXDriverManager.
	 * @param logger instancia de SPXLogger utilizada para registrar errores y
	 *               trazas de ejecucion.
	 */
	public SPXUtils(WebDriver driver, SPXLogger logger) {
		this.driver = driver;
		this.logger = logger;
	}

	// =========================================================================
	// Date / Time
	// =========================================================================

	/*
	 * @name: date
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener la fecha y hora actuales
	 * formateadas ("MMM dd yyyy, hh mm ss a"), utilizadas principalmente para
	 * nombrar archivos de evidencia y documentos generados por el framework.
	 */
	public String date() {
		try {
			String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh mm ss a").format(LocalDateTime.now());
			return dateTime;
		} catch (NoSuchElementException e) {
			logger.logFrameworkError("> It was not possible to generate the date...", e);
			e.printStackTrace();
			return null;
		}
	}

	// =========================================================================
	// JSON / Encryption
	// =========================================================================

	/*
	 * @name: getJSONValue
	 * 
	 * @date: 23/Feb/2023
	 * 
	 * @param: String jsonFileObj, String jsonKey
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite leer la informacion de un archivo JSON
	 * ubicado en la ruta de datos del framework, retornando el valor
	 * correspondiente a la clave solicitada. Si el archivo no existe, marca el caso
	 * de prueba como fallido mediante Assert.fail().
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariablesSPX.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValueString = (String) jsonObject.get(jsonKey);
			return jsonValueString;
		} catch (FileNotFoundException e) {
			Assert.fail("***** ERROR *****");
			Assert.fail("> JSON file is not found ");
			Assert.fail("> Because: " + e.getMessage());
			return null;
		}
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
	 * @description: Este metodo permite decodificar en Base64 un dato almacenado de
	 * forma encriptada (por ejemplo, una URL guardada en el JSON), retornando su
	 * valor en texto plano.
	 */
	public String getEncrypted(String encrypted) {
		try {
			byte[] decodedBytes = Base64.decodeBase64(encrypted);
			return new String(decodedBytes);
		} catch (IllegalArgumentException e) {
			logger.logFrameworkError("> It was not possible to obtain the encryption...", e);
			e.printStackTrace();
			return null;
		}
	}

	// =========================================================================
	// Test Case / Element Identification
	// =========================================================================

	/*
	 * @name: getTestCaseName
	 * 
	 * @date: 21/Nov/2023
	 * 
	 * @param: ITestResult result
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite obtener el nombre de un caso de prueba a
	 * partir del resultado de ejecucion de TestNG, utilizado principalmente para
	 * nombrar evidencias y documentos generados.
	 */
	public String getTestCaseName(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		return methodName;
	}

	/*
	 * @name: displayElementName
	 * 
	 * @date: 03/Nov/2023
	 * 
	 * @param: WebDriver driver, By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite mostrar el nombre (atributo "name") de un
	 * elemento en consola, utilizado como apoyo de debugging cuando una validacion
	 * de campo obligatorio falla.
	 */
	public static void displayElementName(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			String elementName = element.getAttribute("name");

			if (elementName != null && !elementName.isEmpty()) {
				System.out.println("Element Name: " + elementName);
			} else {
				System.out.println("***** ERROR *****");
				System.out.println("> Element: " + locator + " does not have a name attribute.");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("***** ERROR *****");
			System.out.println("> Element: " + locator + " not found. ");
			System.out.println("> Because: " + e.getMessage());
		}
	}

	// =========================================================================
	// Business Catalogs (UEN / Language)
	// =========================================================================

	/*
	 * @name: assignUEN
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener el nombre de la UEN correspondiente
	 * al numero de UEN configurado en las variables globales, validando contra cada
	 * uno de los catalogos de plantas disponibles (San Antonio, SAC, Saltillo,
	 * Guanajuato, Apodaca, Argentina, Owensboro, Novi, Roanoke, Elizabethtown).
	 */
	public static String assignUEN() {
		String uenNumber = GlobalVariablesSPX.SPX_DEV5_NUM_UEN; // Obtener el numero de UEN de UENData
		String uenName = "Valor por defecto";

		if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_SAN_ANTONIO)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_SAN_ANTONIO;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_SAC)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_SAC;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_SALTILLO)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_SALTILLO;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_GUANAJUATO)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_GUANAJUATO;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_APODACA)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_APODACA;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_ARGENTINA)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_ARGENTINA;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_OWENSBORO)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_OWENSBORO;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_NOVI)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_NOVI;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_ROANOKE)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_ROANOKE;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_ELIZABETHTOWN)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_ELIZABETHTOWN;
		}
		return uenName;
	}

	/*
	 * @name: detectLanguage
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: WebDriver driver
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Consulta el idioma configurado en el navegador o en la etiqueta
	 * HTML raiz mediante JavaScript y retorna el codigo estandarizado del idioma
	 * ("PT", "EN" o "ES"), utilizado para validaciones multilenguaje dentro de la
	 * aplicacion SPX.
	 */
	public static String detectLanguage(WebDriver driver) {
		String lang = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.documentElement.lang || navigator.language || navigator.userLanguage || '';");

		lang = lang.toLowerCase();

		if (lang.startsWith("pt"))
			return "PT";
		if (lang.startsWith("en"))
			return "EN";
		return "ES";
	}
}