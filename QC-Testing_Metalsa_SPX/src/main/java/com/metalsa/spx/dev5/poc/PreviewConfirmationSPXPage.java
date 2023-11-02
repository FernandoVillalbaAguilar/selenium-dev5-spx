package com.metalsa.spx.dev5.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

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
	By btnAccept=By.id("formCarroCompras:j_idt360");

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
	public boolean textPreviewConfirmationPageIsDisplayed() {
		try {
			reporterLog("Access to Preview & Confirmation Page ...");
			waitForElementPresent(btnAccept);
			return isDisplayed(btnAccept);
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;
		}
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
	public void acceptToRequisitionPreviewConfirmationPage() {
		try {
			reporterLog("Accept to Requisition");
			click(btnAccept);
		} catch (TimeoutException e) {
			e.printStackTrace();
			
		}
	}
}
