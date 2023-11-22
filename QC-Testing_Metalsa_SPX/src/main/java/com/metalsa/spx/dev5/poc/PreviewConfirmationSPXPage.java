package com.metalsa.spx.dev5.poc;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class PreviewConfirmationSPXPage extends SPXBase {

	public PreviewConfirmationSPXPage(WebDriver driver) {
		super(driver);
	}

// Objects
	By txtPreviewConfirmation = By.id("carro-compras-steps--name");
	By btnBack = By.id("formCarroCompras:goBack1");
	By iconTypeRequisition = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/i[1]");
	By btnAccept = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/div[4]/button[1]/span[1]");
	By txtRequisitionGenerate = By.id("formCarroCompras:j_idt413:0:j_idt418");
	By txtDescription = By.id("formCarroCompras:j_idt413:0:j_idt448:0:panel_no_warning_content");

	/*
	 * @name: textPreviewConfirmationPageIsDisplayed
	 * 
	 * @date: 01/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtPreviewConfirmation);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean textPreviewConfirmationPageIsDisplayed() throws InterruptedException {
		reporterLog("Access to Preview & Confirmation Page ...");
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnAccept);
		return isDisplayed(btnAccept);
	}

	/*
	 * @name: acceptToRequisitionPreviewConfirmationPage
	 * 
	 * @date: 01/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public Map<String, String> acceptToRequisitionPreviewConfirmationPage() throws InterruptedException {
		reporterLog("Accept to Requisition");
		click(btnAccept);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtRequisitionGenerate);
		System.out.print("Requisition generated with ID: ");
		getText(txtRequisitionGenerate);
		System.out.println("Description:");
		getText(txtDescription);
		return returnSaveImage(txtDescription);
	}
}
