package com.metalsa.spx.dev5.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class SPXBase {

	private WebDriver driver;

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
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOpt);
		return driver;
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
		Reporter.log(log);
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
		reporterLog("Wait for Element Present...");
		WebDriverWait wait = new WebDriverWait(driver, GlobalVariablesSPX.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
		reporterLog("Wait for Element Present...");
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
		} catch (NoSuchElementException e) {
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
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
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
				return driver.findElement(locator).isDisplayed();
			} else {
				System.out.println("The element " + locator + " is not found");
				return driver.findElement(locator).isDisplayed();
			}

		} catch (NoSuchElementException e) {
			e.printStackTrace();
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
		byte[] decodedBytes = Base64.decodeBase64(encrypted);
		return new String(decodedBytes);
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
		String nameProduct;
		nameProduct = driver.findElement(locator).getText();
		System.out.println("ID Requeriment SPOT is: " + nameProduct);
	}

	/*
	 * @name: getText
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator, String requiredField
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener el texto de un elemento
	 */
	public void requiredFields(By locator, String requiredField) {
		reporterLog("Validate Required Fields...");
		if (requiredField == "") {
			System.out.println("The " + locator + " field is required and cannot be left empty");
			driver.close();
		} else {
			System.out.println("The required field " + locator + " contains information ");
		}
	}

	/*
	 * @name: takeScreenshot
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator, String requiredField
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener el texto de un elemento
	 */
	public String takeScreenshot(String fileName) {
		try {
			String pathFileName = GlobalVariablesSPX.SPX_DEV5_PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			System.out.println("I take a screeshot...");
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
