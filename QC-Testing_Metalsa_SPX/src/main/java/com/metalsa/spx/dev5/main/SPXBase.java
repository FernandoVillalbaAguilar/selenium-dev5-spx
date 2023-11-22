package com.metalsa.spx.dev5.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.map.HashedMap;
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

public class SPXBase {
	private WebDriver driver;
	Map<String, String> listaScreenShots = new HashedMap<>();

	public SPXBase(WebDriver driver) {
		this.driver = driver;
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
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("The connection was not made correctly...");
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
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("Unable to access the url:");
			System.out.println(url);
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
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("The report was not made correctly...");
		}
	}

	/*
	 * @name: waitForElementPresent
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
	public void waitForElementPresent(By locator) {
		try {
			reporterLog("Wait for Element Present...");
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariablesSPX.DEFAULT_TIMEOUT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			takeScreenshot();
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("The element" + locator + "is not present...");
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
			takeScreenshot();
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("The element" + locator + "is not present...");
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
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("It was not possible to capture data in the element: " + locator);
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
			driver.findElement(locator).click();
			takeScreenshot();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("It was not possible to click on the item: " + locator + " because " + e);
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

	public Map<String, String> returnSaveImage(By locator) {
		try {
			reporterLog("Return Click for Saved Image");
			driver.findElement(locator).getTagName();
			return takeScreenshot();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("It was not possible to save image: " + locator + " because " + e);
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
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("It was not possible to generate the date...");
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
			if (driver.findElement(locator).isDisplayed()) {
				reporterLog("Validate if Element is Displayed");
				takeScreenshot();
				return driver.findElement(locator).isDisplayed();
			} else {
				System.out.println(this.getClass().getName());
				System.out.println("Element " + locator + " was not found...");
				takeScreenshot();
				return driver.findElement(locator).isDisplayed();
			}

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("Element " + locator + " was not found...");
			return false;
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
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("It was not possible to upload the file...");
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
			Assert.fail("JSON file is not found");
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
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println("It was not possible to obtain the encryption...");
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
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("No text found to display...");
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
	public void requiredFields(By locator) {
		try {
			reporterLog("Validate Required Fields...");

			if (isElementNull(driver, locator)) {
				reporterLog("The required field contains information... ");
			} else {
				System.out.println(this.getClass().getName());
				displayElementName(driver, locator);
				System.out.println("The" + locator + " field is mandatory and cannot be empty...");
				driver.close();
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println(this.getClass().getName());
			System.out.println("The" + locator + " field is mandatory and cannot be empty...");
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
	public void saveWordDocument(Map<String, String> word) {
		// Save screenshot in Word document
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		String testCaseName = getTestCaseName(Reporter.getCurrentTestResult());
		run.setText("Test Case: " + testCaseName);
		FileInputStream in;
		File image;

		try {

			Iterator<String> itr = word.keySet().iterator();
			// Count types images saved
			// System.out.println("Map Types: " + word.size());
			while (itr.hasNext()) {
				String key = itr.next();
				String value = word.get(key);
				// Print to name image and path image
				// System.out.println(key + "=" + value);
				image = new File(value);
				in = new FileInputStream(image);
				int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
				String imageFileName = key;
				int width = 450;
				int height = 400;

				// add picture
				paragraph = document.createParagraph();
				run = paragraph.createRun();
				run.addPicture(in, imageType, imageFileName, Units.toEMU(width), Units.toEMU(height));

				// add text below the picture
				run.setText("Image file-name: " + imageFileName);
				paragraph = document.createParagraph();
				run = paragraph.createRun();

				// add page break
				paragraph = document.createParagraph();
				run = paragraph.createRun();
				run.addBreak(BreakType.PAGE);
			}
			FileOutputStream out = new FileOutputStream(GlobalVariablesSPX.SPX_DEV5_PATH_SCREENSHOTS + "Test Case-"
					+ testCaseName + "-" + date() + ".docx");
			document.write(out);
			out.close();
			document.close();
		} catch (Exception e) {

			System.out.println(this.getClass().getName());
			System.out.println(e.getMessage());
			System.out.println("I could not save Word Document..." + e.getMessage());
		}
	}

	/*
	 * @name: takeScreenshotAndSavedWord
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator, String requiredField
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite tomar una captura de pantalla y guardar en
	 * un documento de word
	 */
	public Map<String, String> takeScreenshot() {
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
			System.out.println(this.getClass().getName());
			System.out.println(e.getMessage());
			System.out.println("I could not take the screenshot...");
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
			System.out.println("The" + locator + " is empty...");
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
				System.out.println("Element" + locator + " does not have a name attribute.");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Element" + locator + " not found.");
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
	public static String generateRandomId() {
		UUID uuid = UUID.randomUUID();
		String randomId = uuid.toString();

		// Remove any hyphens to get a valid HTML ID
		randomId = randomId.replace("-", "");

		return randomId;
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
			System.out.println(this.getClass().getName());
			System.out.println("No realice Scroll. " + e.getMessage());
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
}