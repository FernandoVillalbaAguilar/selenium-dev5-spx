package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
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
	By btnAccept = By.xpath("//button[contains(@class,'spx--btn__success')]");
	By txtRequisitionGenerate = By.xpath("//label[@style='color: #028EEF;']");
	By txtDescription = By.xpath("//td[contains(@class,'CellWithComment')]//span");

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
	 * @description: Este metodo permite verificar que el elemento est� disponible
	 */
	public boolean textPreviewConfirmationPageIsDisplayed() throws InterruptedException {
		reporterLog("Access to Preview & Confirmation Page ...");
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
	 * @description: Este metodo permite verificar que el elemento est� disponible
	 */
	public TreeMap<String, String> acceptToRequisitionPreviewConfirmationPage() throws InterruptedException {
	    reporterLog("Accept to Requisition");

	    // Espera y clic en el botón Aceptar
	    waitForElementPresent(btnAccept);
	    click(btnAccept);

	    Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

	    // Espera a que aparezca el ID de requisición generado
	    waitForElementPresent(txtRequisitionGenerate);
	    String requisitionID = getText(txtRequisitionGenerate);
	    
	    // Espera a que aparezca la descripción del ítem y extrae solo el primer "token" (ID)
	    waitForElementPresent(txtDescription);
	    String fullDescription = getText(txtDescription);
	    String itemRequisitionID = fullDescription.split(" ")[0]; // REQUI-TEST-AUTO-xxxx
	    
	    System.out.println("Requisition generated with ID: " + requisitionID);
	    System.out.println("Description: " + itemRequisitionID);

	    // Guarda evidencia
	    return returnSaveImage(txtDescription);
	}
}
