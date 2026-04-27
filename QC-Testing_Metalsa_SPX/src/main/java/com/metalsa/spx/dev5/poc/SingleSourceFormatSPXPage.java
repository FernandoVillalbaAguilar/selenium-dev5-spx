package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class SingleSourceFormatSPXPage extends SPXBase {

	public SingleSourceFormatSPXPage(WebDriver driver) {
		super(driver);
	}

//Objects
	// Header Objects
	By btnBack = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/span[2]");
	By btnSave = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[2]/span[2]");
	By txtSingleScourseFormat = By.xpath("/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[1]/div[1]/h3[1]");
	By msgStatusFAD = By.id("formFAD:mensageStatus");
	// First section
	By txtDescription = By.id("formFAD:desc_1");
	By txtSupplierName = By.id("formFAD:suppliers_input");
	By slctSupplierName = By.id("formFAD:suppliers_panel");
	By txtAmount = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/fieldset[1]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]/input[1]");
	By lblCurrency = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/fieldset[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/label[1]");
	By txtCurrency = By.xpath("/html[1]/body[1]/div[23]/div[1]/input[1]");
	By slctCurrency = By.xpath(GlobalVariablesSPX.SELECT_CURRENCY);
	// Second section
	By rdbtnSingleSourceFormatReason = By.xpath(GlobalVariablesSPX.SINGLE_SOURCE_FORMAT_REASON);
	By txtDetails = By.id("formFAD:fad_razon_otro");
	// Third section
	By txtComments = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[2]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]");
	By btnChooseFiles = By.id("formFAD:fileUpload_input");

	/*
	 * @name: textSingleSourceFormatPageIsDisplayed
	 * 
	 * @date: 16/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtSingleScourseFormat);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento est� disponible
	 */
	public boolean textSingleSourceFormatPageIsDisplayed() {
		reporterLog("Access to Single Source Format Page ...");
		waitForElementPresent(txtSingleScourseFormat);
		return isDisplayed(txtSingleScourseFormat);
	}

	/*
	 * @name: captureDataSingleSourceFormat
	 * 
	 * @date: 16/Nov/2023
	 * 
	 * @param: String description, String supplierName, String amount, String
	 * details, String commments
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite realizar la captura de datos dentro de la
	 * pagina
	 */
	public TreeMap<String, String> captureDataSingleSourceFormat(String description, String supplierName, String amount,
			String details, String comments, String pathFileSpot) throws InterruptedException {
		type(txtDescription, description);
		type(txtSupplierName, supplierName);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(slctSupplierName);
		click(slctSupplierName);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		type(txtAmount, amount);
		click(lblCurrency);
		waitForElementPresent(txtCurrency);
		click(slctCurrency);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		click(rdbtnSingleSourceFormatReason);
		type(txtDetails, details);	
		type(txtComments, comments);
		uploadFile(pathFileSpot, btnChooseFiles);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		// validate are fields mandatory
		requiredFields(txtDescription);
		requiredFields(txtSupplierName);
		requiredFields(txtAmount);
		requiredFields(lblCurrency);
		requiredFields(txtComments);

		// Validate if all radio buttons are not selected
		if (isDisplayed(msgStatusFAD)) {
			System.out.println(
					"No radio button is selected, in this section it is mandatory to have a radio button selected...");
			driverClose();
		}
		return returnSaveImage(btnChooseFiles);
	}

	/*
	 * @name: clickSave
	 * 
	 * @date: 16/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite dar clic en el bot�n "Save"
	 */
	public TreeMap<String, String> clickSave() throws InterruptedException {
		waitForElementPresent(btnSave);
		click(btnSave);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnSave);
	}

	/*
	 * @name: clickBack
	 * 
	 * @date: 16/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite dar clic en el bot�n "Back"
	 */
	public TreeMap<String, String> clickBack() throws InterruptedException {
		waitForElementPresent(btnBack);
		click(btnBack);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnBack);
	}
}
