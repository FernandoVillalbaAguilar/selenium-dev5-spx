package com.metalsa.spx.dev5.poc;

import java.util.Map;

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
	By btnBack = By.id("formFAD:j_idt527");
	By btnSave = By.id("formFAD:j_idt528");
	By txtSingleScourseFormat = By.xpath("//div[@class='spx-card-header__title']");
	// First section
	By txtDescription = By.id("formFAD:desc_1");
	By txtSupplierName = By.id("formFAD:suppliers_input");
	By slctSupplierName = By.id("formFAD:suppliers_panel");
	By txtAmount = By.id("formFAD:j_idt546_input");
	By lblCurrency = By.id("formFAD:j_idt548_label");
	By txtCurrency = By.id("formFAD:j_idt548_filter");
	By slctCurrency = By.xpath(GlobalVariablesSPX.SELECT_CURRENCY);
	// Second section
	By rdbtnSingleSourceFormatReasonQuality = By.xpath("/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]");
	By rdbtnSingleSourceFormatReasonNegotiatedPrice = By.xpath("/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/span[1]");
	By rdbtnSingleSourceFormatReasonSingleSource = By.xpath("/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[2]/span[1]");
	By rdbtnSingleSourceFormatReasonProuctionMaterial = By.xpath("/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[4]/td[1]/div[1]/div[2]/span[1]");
	By rdbtnSingleSourceFormatReasonLackOfScheduleAvailability = By.xpath("/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[5]/td[1]/div[1]/div[2]/span[1]");
	By rdbtnSingleSourceFormatReasonOtherReason = By.xpath("/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[3]/div[2]/div[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[6]/td[1]/div[1]/div[2]/span[1]");
	By txtDetails = By.id("formFAD:fad_razon_otrox");
	// Third section
	By txtComments = By.id("formFAD:j_idt557");
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
	 * @description: Este metodo permite verificar que el elemento está disponible
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
	public Map<String, String> captureDataSingleSourceFormat(String description, String supplierName, String amount, String details,
			String comments, String pathFileSpot) throws InterruptedException {
		type(txtDescription, description);
		type(txtSupplierName, supplierName);
		waitForElementPresent(slctSupplierName);
		click(slctSupplierName);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		type(txtAmount, amount);
		click(lblCurrency);
		waitForElementPresent(txtCurrency);
		click(slctCurrency);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		//waitForElementPresent(rdbtnSingleSourceFormatReasonSingleSource);
		click(rdbtnSingleSourceFormatReasonSingleSource);
		type(txtDetails, details);
		type(txtComments, comments);
		uploadFile(pathFileSpot, btnChooseFiles);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
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
	 * @description: Este metodo permite dar clic en el botón "Save"
	 */
	public Map<String, String> clickSave() throws InterruptedException {
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
	 * @description: Este metodo permite dar clic en el botón "Back"
	 */
	public Map<String, String> clickBack() throws InterruptedException {
		waitForElementPresent(btnBack);
		click(btnBack);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnBack);
	}
}
