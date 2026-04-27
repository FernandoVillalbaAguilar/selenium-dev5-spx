package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class AdministracionPorUenElearning extends SPXBase {

	public AdministracionPorUenElearning(WebDriver driver) {
		super(driver);
	}

// Objects
	By txtTittlePage = By.xpath("//h3[contains(text(),\"Admin\")]");
	By btnActivar = By.xpath("//tr/td/input[@onclick="+'"'+"ejecutar('300000871351178', 'activar')'"+'"'+"]");
	By btnInactivar = By.xpath("//tr/td/input[@onclick=\"+'\"'+\"ejecutar('300000871351178', 'inactivar')'\"+'\"'+\"]");
	By txtActivateOrDesactivate = By.xpath("");

	/*
	 * @name: textAdministracionPorUenElearningPageIsDisplayed
	 * 
	 * @date: 15-05-2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtTittlePage);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento est� disponible
	 */
	public boolean textAdministracionPorUenElearningPageIsDisplayed() {
		reporterLog("Access to Account Configuration Page ...");
		waitForElementPresent(txtTittlePage);
		return isDisplayed(txtTittlePage);
	}

	/*
	 * @name: selectTypeAccountForRequisitionCC
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: String costCenter
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite seleccionar el tipo de cobro CC
	 */
	public TreeMap<String, String> verificationUenEstatus() throws InterruptedException {

		reporterLog("Verification UEN Estatus ...");
		if (isDisplayed(btnActivar)) {
			click(btnInactivar);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			getText(txtActivateOrDesactivate);
			System.out.println("Inactive la UEN");
		}else {
			click(btnActivar);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			getText(txtActivateOrDesactivate);
			System.out.println("Inactive la UEN");
		}
		click(txtTittlePage);
		return returnSaveImage(txtTittlePage);
	}

}
