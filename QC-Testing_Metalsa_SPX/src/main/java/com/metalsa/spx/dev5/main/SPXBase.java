package com.metalsa.spx.dev5.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import org.openqa.selenium.interactions.Actions;

public class SPXBase {
	private WebDriver driver;
	private TreeMap<String, String> listaScreenShots = new TreeMap<>();

	// Random Variables
	static String[] singleSourceFormatReason = {
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]",
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[2]/span[1]",
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[4]/td[1]/div[1]/div[2]/span[1]",
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[5]/td[1]/div[1]/div[2]/span[1]",
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[6]/td[1]/div[1]/div[2]/span[1]",
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/span[1]" };

	static Random rand = new Random();

	public static String getRandomValue(String[] array) {
		return array[rand.nextInt(array.length)];
	}

	public SPXBase(WebDriver driver) {
		this.driver = driver;
	}

	public static String[] generateNumbers() {
		String[] numbers = new String[1000];
		for (int i = 0; i < 1000; i++) {
			numbers[i] = String.valueOf(i + 1);
		}
		return numbers;
	}

	// --------------------
	// Helper: obtener valor aleatorio de cualquier arreglo
	// Uso: randomFrom(GlobalVariablesSPX.MATERIAL)
	// --------------------
	public static String randomFrom(String[] arr) {
		if (arr == null || arr.length == 0)
			return "";
		int idx = ThreadLocalRandom.current().nextInt(arr.length);
		return arr[idx];
	}

	// Métodos auxiliares específicos (opcionales)
	public static String randomMaterial() {
		return randomFrom(GlobalVariablesSPX.MATERIAL);
	}

	public static String randomColor() {
		return randomFrom(GlobalVariablesSPX.COLOR);
	}

	public static String randomMarca() {
		return randomFrom(GlobalVariablesSPX.MARCA);
	}

	public static String randomMedida() {
		return randomFrom(GlobalVariablesSPX.MEDIDAS);
	}

	public static String randomProveedor() {
		return randomFrom(GlobalVariablesSPX.PROVEEDORES);
	}

	public static String randomUnidadDeMedida() {
		return randomFrom(GlobalVariablesSPX.UNIDAD_DE_MEDIDA);
	}

	public static String randomNumRand() {
		return randomFrom(GlobalVariablesSPX.NUM_RAND);
	}

	public static String randomQuantity() {
		return randomFrom(GlobalVariablesSPX.QUANTITY);
	}

	public static String randomMoneda() {
		return randomFrom(GlobalVariablesSPX.MONEDA);
	}

	public static String randomRazonUrgencia() {
		return randomFrom(GlobalVariablesSPX.RAZON_URGENCIA);
	}

	public static String randomRazonUrgenciaENG() {
		return randomFrom(GlobalVariablesSPX.RAZON_URGENCIA_ENG);
	}

	public static String randomGenericName() {
		return randomFrom(GlobalVariablesSPX.GENERIC_NAME);
	}

	public static String randomGenericItem() {
		return randomFrom(GlobalVariablesSPX.GENERIC_ITEM);
	}
	public static String randomComentarios() {
		return randomFrom(GlobalVariablesSPX.COMENTARIOS);
	}

	/*
	 * @name: chromeDriverConection
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: chromeDriverConection
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite realizar la conexión con el navegador de
	 * Chrome y WebDriver
	 */
	public WebDriver chromeDriverConection() {
		try {
			ChromeOptions chromeOpt = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOpt);
			return driver;
		} catch (TimeoutException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> The connection was not made correctly...");
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @name: launchBrowser
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: String url
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite ingresar a la URL de la pagina y maximiza
	 * la ventana
	 */

	public void launchBrowser(String url) {
		try {
			reporterLog("Launching ... " + url);
			driver.get(getEncrypted(url));
			driver.manage().window().maximize();
		} catch (TimeoutException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> Timeout while loading the URL: " + url);
			e.printStackTrace();
		} catch (WebDriverException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> WebDriver encountered an error while launching the browser:");
			e.printStackTrace();
		}
	}

	/*
	 * @name: reporterLog
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: String log
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite generar un reporte de cada paso del
	 * testcase
	 */
	public void reporterLog(String log) {
		try {
			Reporter.log(log);
		} catch (TimeoutException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("> ***** ERROR *****");
			System.out.println("> The report was not made correctly...");
			e.printStackTrace();
		}
	}

	/*
	 * @name: waitForElementPresent
	 * 
	 * @date: 22/Nov/2025
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método que permite generar un Explicit Wait hasta que el
	 * elemento exista dentro del DOM. A diferencia de visibilityOfElementLocated,
	 * este método utiliza presenceOfElementLocated para mejorar la estabilidad en
	 * componentes dinámicos como listas, paneles o dropdowns (PrimeFaces).
	 */
	public void waitForElementPresent(By locator) {
		try {
			reporterLog("Wait for Element Present (DOM Presence)...");
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariablesSPX.DEFAULT_TIMEOUT);

			// Se espera a que el elemento esté presente en el DOM
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		} catch (TimeoutException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> The element: " + locator + " is NOT present in DOM...");
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR (Unexpected) *****");
			System.out.println("> Unexpected error while waiting for element: " + locator);
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * @name: waitForElementVisible
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite generar un Explicit Wait o tiempo de espera
	 * hasta que se muestre el elemento requerido con un valor de segundos por
	 * default
	 */
	public void waitForElementVisible(By locator) {
		try {
			reporterLog("Wait for Element Visible...");
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariablesSPX.DEFAULT_TIMEOUT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> The element: " + locator + " is not present...");
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * @name: waitForElementPresent
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: By locator, int seconds
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite generar un Explicit Wait o tiempo de espera
	 * hasta que se muestre el elemento requerido con un valor de segundos variable
	 */
	public void waitForElementPresent(By locator, int seconds) {
		try {
			reporterLog("Wait for Element Present...");
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> The element: " + locator + " is not present...");
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * @name: type
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: By locator, String inputText
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite capturar un dato en un campo de texto
	 */
	public void type(By locator, String inputText) {
		try {
			reporterLog("Input Text to Field");
			driver.findElement(locator).sendKeys(inputText);
			takeScreenshot();
		} catch (NoSuchElementException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> It was not possible to capture data in the element: " + locator);
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();
		}

	}

	/*
	 * @name: typeClear
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: By locator, String inputText
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite borrar un dato en un campo de texto
	 */
	public void typeClear(By locator) {
		try {
			reporterLog("Input Text to Field");
			driver.findElement(locator).clear();
			takeScreenshot();
		} catch (NoSuchElementException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> It was not possible to clear data in the element: " + locator);
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();
		}

	}

	/*
	 * @name: click
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite dar un click
	 */
	public void click(By locator) {
		try {
			reporterLog("Click to Field or Button");
			// Espera adicional para que el elemento sea clickable
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariablesSPX.DEFAULT_TIMEOUT);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			takeScreenshot();
		} catch (NoSuchElementException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> It was not possible to click on the item: " + locator);
			System.out.println("> because: " + e.getMessage());
			e.printStackTrace();
		}

	}

	/*
	 * @name: returnSaveImage
	 * 
	 * @date: 21/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: takeScreenshot("QC-Testing_SaveImage_" + date());
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite guardar las imagenes mediante un return
	 * hacia un word
	 */

	public TreeMap<String, String> returnSaveImage(By locator) {
		try {
			reporterLog("Return Click for Saved Image");
			driver.findElement(locator).getTagName();
			return takeScreenshot();
		} catch (NoSuchElementException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> It was not possible to save image: " + locator);
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();
		}
		return takeScreenshot();
	}

	/*
	 * @name: date
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite dar la fecha y hora actuales
	 */
	public String date() {
		try {
			String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh mm ss a").format(LocalDateTime.now());
			return dateTime;
		} catch (NoSuchElementException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> It was not possible to generate the date...");
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @name: isDisplayed
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: driver.findElement(locator).isDisplayed(); / false
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar si el elemento se encuentra
	 * disponible
	 */
	public boolean isDisplayed(By locator) {
		try {
			// Buscar el elemento en la página usando el locator proporcionado
			WebElement element = driver.findElement(locator);

			// Verificar si el elemento está visible en la pantalla
			boolean visible = element.isDisplayed();

			// Si el elemento es visible
			if (visible) {
				// Registrar en el reporte que el elemento está visible
				reporterLog("Element displayed: " + locator);
			} else {
				// Aviso en consola si el elemento existe pero no es visible
				System.out.println("[WARNING] Element found but NOT visible: " + locator);
			}

			// Devolver el estado de visibilidad (true si es visible, false si no)
			return visible;

		} catch (NoSuchElementException e) {
			// Captura cuando el elemento NO está presente en el DOM
			System.out.println("[INFO] Element NOT present in DOM: " + locator);
			return false;

		} catch (Exception e) {
			// Captura cualquier otro error inesperado al verificar la visibilidad
			System.out.println("[ERROR] Unexpected error checking visibility of: " + locator);
			return false;

		} finally {
			// Tomar una captura de pantalla siempre, independientemente del resultado
			takeScreenshot();
		}
	}

	/*
	 * @name: uploadFile
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: String path, By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite cargar archivos del sistema a SPX
	 */
	public void uploadFile(String path, By locator) {
		try {
			File file = new File(path);
			String absolutePath = file.getAbsolutePath();
			driver.findElement(locator).sendKeys(absolutePath);
		} catch (NoSuchElementException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> It was not possible to upload the file...");
			e.printStackTrace();
		}
	}

	/*
	 * @name: getJSONValue
	 * 
	 * @date: 23/Feb/2023
	 * 
	 * @param: String jsonFileObj, String jsonKey
	 * 
	 * @return: jsonValue / null
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite leer la información de un archivo JSON
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
	 * @return: String(decodedBytes)
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite decodificar un dato almacenado en el JSON
	 */
	public String getEncrypted(String encrypted) {
		try {
			byte[] decodedBytes = Base64.decodeBase64(encrypted);
			return new String(decodedBytes);
		} catch (IllegalArgumentException e) {
			System.out.println("***** ERROR *****");
			System.out.println("> It was not possible to obtain the encryption...");
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @name: getText
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener el texto de un elemento
	 */
	public void getText(By locator) {
		try {
			String nameProduct;
			nameProduct = driver.findElement(locator).getText();
			System.out.println(nameProduct);
		} catch (TimeoutException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> No text found to display...");
			e.printStackTrace();
		}
	}

	/*
	 * @name: getText
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener el texto de un elemento
	 */
	public static String assignUEN() {
		String uenNumber = GlobalVariablesSPX.SPX_DEV5_NUM_UEN; // Obtener el número de UEN de UENData
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
	 * @name: requiredFields
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite validar campos obligatorios
	 */
	public void requiredFields(By locator) {
		try {
			reporterLog("Validate Required Fields...");

			// 1. Verificar si el elemento existe en el DOM
			if (!isElementPresent(locator)) {
				// Campo no existe > NO debe validarse como requerido
				System.out.println("### INFO ### El elemento no existe en la pantalla: " + locator);
				return;
			}

			// 2. Si existe, validar si está vacío o nulo
			if (isElementNull(driver, locator)) {
				reporterLog("The required field contains information...");
			} else {
				System.out.println("###-----  " + this.getClass().getName() + "  -----###");
				displayElementName(driver, locator);
				System.out.println("***** ERROR *****");
				System.out.println("> The: " + locator + " field is mandatory and cannot be empty...");
				// NO CERRAR EL DRIVER AQUÍ
				throw new RuntimeException("Required field is empty: " + locator);
			}

		} catch (TimeoutException e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> Timeout validating required field: " + locator);
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * @name: saveWordDocument
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: Map<String, String> word
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permita guardar en un documento de word una captura
	 * de pantalla
	 */
	public void saveWordDocument(TreeMap<String, TreeMap<String, String>> word, List<String> steps,
			List<String> values) {
		// Save screenshot in Word document
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		String testCaseName = getTestCaseName(Reporter.getCurrentTestResult());
		run.setBold(true);
		run.setFontSize(14);
		run.setText("Test Case: " + testCaseName);
		int count = 0;
		FileInputStream in;
		File image;

		try {

			Iterator<String> itr = word.keySet().iterator();

			// Count types images saved
			// System.out.println("Map Types: " + word.size());

			while (itr.hasNext()) {
				// Add steps and values
				paragraph = document.createParagraph();
				run = paragraph.createRun();
				run.setBold(true);
				run.setFontSize(12);
				run.setText(steps.get(count) + ": " + values.get(count));
				String key = itr.next();
				TreeMap<String, String> value = word.get(key);

				Iterator<String> itrAux = value.keySet().iterator();

				while (itrAux.hasNext()) {
					// Print to name image and path image
					// System.out.println(key + "=" + value);

					String keyAux = itrAux.next();
					String valueAux = value.get(keyAux);
					image = new File(valueAux);
					in = new FileInputStream(image);
					int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
					String imageFileName = keyAux;
					int width = 450;
					int height = 400;

					// add picture
					paragraph = document.createParagraph();
					run = paragraph.createRun();
					run.addPicture(in, imageType, imageFileName, Units.toEMU(width), Units.toEMU(height));

					// add text below the picture
					run.setItalic(true);
					run.setFontSize(8);
					run.setText("Image file-name: " + imageFileName);
					paragraph = document.createParagraph();
					run = paragraph.createRun();

					// add page break
					paragraph = document.createParagraph();
					run = paragraph.createRun();
					run.addBreak(BreakType.PAGE);
				}
				count++;
			}

			FileOutputStream out = new FileOutputStream(GlobalVariablesSPX.SPX_DEV5_PATH_SCREENSHOTS + "Test Case-"
					+ testCaseName + "-" + date() + ".docx");

			document.write(out);
			out.close();
			document.close();

		} catch (Exception e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> I could not save Word Document... ");
			System.out.println("> Because: " + e.getMessage());
		}
	}

	/*
	 * @name: takeScreenshot
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite tomar una captura de pantalla y guardar en
	 * un documento de word
	 */
	public TreeMap<String, String> takeScreenshot() {
		try {
			String testCaseName = getTestCaseName(Reporter.getCurrentTestResult());
			String fileName = "QC_Testing-" + testCaseName + "-" + date();

			// Take screenshot
			Screenshot screenshot = new AShot().takeScreenshot(driver);

			// Save screenshot as PNG file
			String pathFileName = GlobalVariablesSPX.SPX_DEV5_PATH_SCREENSHOTS + fileName + ".png";
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));

			listaScreenShots.put(fileName, pathFileName);

		} catch (Exception e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> I could not take the screenshot... ");
			System.out.println("> Because: " + e.getMessage());
		}
		return listaScreenShots;
	}

	/*
	 * @name: isElementNull
	 * 
	 * @date: 03/Nov/2023
	 * 
	 * @param: WebDriver driver, By locator
	 * 
	 * @return: element != null
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite validar si un elemento es null o no
	 */
	public static boolean isElementNull(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element != null;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("***** ERROR *****");
			System.out.println("> The: " + locator + " is empty... ");
			System.out.println("> Because: " + e.getMessage());
			return false;
		}
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
	 * @description: Este metodo permite mostrar el nombre de un elemento
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

	/*
	 * @name: generateRandomId
	 * 
	 * @date: 06/Nov/2023
	 * 
	 * @param:N/A
	 * 
	 * @return:randomId
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite generar un ID Random
	 */
	public static String generateRandomId(int length) {
		// Genera un UUID y remueve guiones
		String randomId = UUID.randomUUID().toString().replace("-", "");

		// Si la longitud solicitada es mayor a 32, generamos UUID extra hasta completar
		while (randomId.length() < length) {
			randomId += UUID.randomUUID().toString().replace("-", "");
		}

		// Recorta exactamente a la longitud pedida
		return randomId.substring(0, length);
	}

	/*
	 * @name: scrollDown
	 * 
	 * @date: 07/Nov/2023
	 * 
	 * @param:int pixels
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Scroll down the webpage to a specified pixel position
	 */
	public void scrollDown(By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement flag = driver.findElement(locator);
			js.executeScript("arguments[0].scrollIntoView();", flag);
		} catch (Exception e) {
			System.out.println("###----- " + this.getClass().getName() + " -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> No realice Scroll. ");
			System.out.println("> Because: " + e.getMessage());
		}
	}

	/*
	 * @name: scrollUp
	 * 
	 * @date: 07/Nov/2023
	 * 
	 * @param:int pixels
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Scroll down the webpage to a specified locator
	 */
	public void scrollUp(By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement flag = driver.findElement(locator);
			js.executeScript("arguments[0].scrollIntoView(true);", flag);
		} catch (Exception e) {
			System.out.println("###----- " + this.getClass().getName() + " -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> No realice Scroll. ");
			System.out.println("> Because: " + e.getMessage());
		}
	}

	/*
	 * @name: getTestCaseName
	 * 
	 * @date: 21/Nov/2023
	 * 
	 * @param: ITestResult result
	 * 
	 * @return: methodName
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite obtener el nombre de un caso de prueba
	 */
	public String getTestCaseName(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		return methodName;
	}

	/*
	 * @name: driverClose
	 * 
	 * @date: 22/Nov/2023
	 * 
	 * @param:N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite cerrar la ventana
	 */
	public void driverClose() {
		driver.close();
	}

	/*
	 * @name: isElementContainingText
	 * 
	 * @date: 14-05-2024
	 * 
	 * @param:By locator
	 * 
	 * @return: elementText != null && !elementText.trim().isEmpty()
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite validar si un elemento cuenta con
	 * información o no.
	 */
	public boolean isElementContainingText(By locator) {
		try {
			// Encuentra el elemento
			WebElement element = driver.findElement(locator);

			// Obtiene el texto del elemento
			String elementText = element.getText();

			// Verifica si el texto no está vacío
			return elementText != null && !elementText.trim().isEmpty();
		} catch (Exception e) {
			// Maneja excepciones, por ejemplo, si el elemento no se encuentra
			System.out.println("> El elemento no se encontró o ocurrió un error: " + e.getMessage());
			return false;
		}
	}

	/*
	 * @name: isElementDisabled
	 * 
	 * @date: 13-05-2024
	 * 
	 * @param: By locator
	 * 
	 * @return: !isEnabled;
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite validar si un elemento está habilitano o
	 * deshabilitado
	 */

	public boolean isElementDisabled(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			boolean isEnabled = element.isEnabled();
			reporterLog("Validando si el elemento está habilitado: " + locator);
			takeScreenshot(); // Tomar una captura de pantalla para referencia, independientemente de si el
								// elemento está habilitado o no.
			return !isEnabled; // Devuelve true si el elemento está deshabilitado, de lo contrario, false.
		} catch (NoSuchElementException e) {
			String errorMessage = String.format("> Elemento no encontrado o no habilitado: %s. Error: %s", locator,
					e.getMessage());
			System.out.println(errorMessage);
			reporterLog(errorMessage);
			return false;
		}
	}

	/*
	 * @name: selectPrimefacesOption
	 * 
	 * @date: 21/Nov/2025
	 * 
	 * @param: By lblDropdown -> Elemento que abre el listado de opciones
	 * 
	 * @param: By panel -> Panel flotante del Primefaces SelectOneMenu
	 * 
	 * @param: By... options -> Opciones posibles que se intentarán seleccionar (en
	 * orden)
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando
	 * 
	 * @description: Este método abre un dropdown de PrimeFaces y selecciona la
	 * primera opción disponible entre las enviadas, validando visibilidad,
	 * presencia y manejando errores controlados.
	 */
	public void selectPrimefacesOption(By lblDropdown, By panel, By... options) {
		try {
			reporterLog("Select Primefaces Option...");

			// 1. Click en el label para abrir el dropdown
			click(lblDropdown);

			// 2. Esperar el panel visible
			waitForElementVisible(panel);

			// 3. Buscar la primera opción disponible
			for (By option : options) {

				if (isElementPresent(option)) {

					waitForElementVisible(option);
					click(option);

					reporterLog("Opción seleccionada: " + option.toString());
					return; // Selección exitosa
				}
			}

			// Si llegó aquí, no encontró ninguna opción
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR *****");
			System.out.println("> Ninguna de las opciones enviadas existe en el dropdown.");
			System.out.println("> Revisar localizadores o contenido dinámico del menú.");

		} catch (TimeoutException te) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** TIMEOUT *****");
			System.out.println("> No fue posible encontrar el panel o las opciones del dropdown.");
			System.out.println("> Because: " + te.getMessage());
			te.printStackTrace();

		} catch (Exception e) {
			System.out.println("###-----  " + this.getClass().getName() + "  -----###");
			System.out.println("***** ERROR GENERAL *****");
			System.out.println("> Ocurrió un error inesperado en selectPrimefacesOption.");
			System.out.println("> Because: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * @name: isElementPresent
	 * 
	 * @date: 21/Nov/2025
	 * 
	 * @param: locator > Localizador del elemento que se desea validar.
	 * 
	 * @return: boolean > true si el elemento existe en el DOM, false si no existe.
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método que permite verificar si un elemento está presente en el
	 * DOM sin lanzar excepción. Se utiliza principalmente para validar opciones
	 * dinámicas o elementos que pueden o no existir.
	 */
	public boolean isElementPresent(By locator) {
		try {
			return driver.findElements(locator).size() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * @name: clickSupr
	 * 
	 * @date: 22/Nov/2023
	 * 
	 * @param:N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite cerrar la ventana
	 */
	public void clickSupr(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).sendKeys("\u007F").perform(); // \u007F es el código de la tecla Supr
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}