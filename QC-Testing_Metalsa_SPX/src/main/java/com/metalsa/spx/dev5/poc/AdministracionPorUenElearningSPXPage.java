package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class AdministracionPorUenElearningSPXPage extends SPXBase {

	public AdministracionPorUenElearningSPXPage(WebDriver driver) {
		super(driver);
	}

// Objects
	By txtTittlePage = By.xpath("//iframe[contains(@src,'AdminUen')]");
	By btnActivar = By.xpath("//tr/td/input[@onclick=" + '"' + "ejecutar('300000871351139', 'activar')'" + '"' + "]");
	By btnInactivar = By.xpath("//tr/td/input[@onclick=\"+'\"'+\"ejecutar('300000871351139', 'inactivar')'\"+'\"'+\"]");
	By txtActivateOrDesactivate = By.xpath("//span[contains(., '300000871351139')]");

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
	public boolean textAdministracionPorUenElearningPageIsDisplayed() throws InterruptedException {
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

		    boolean clicked = false;

		    // Intento con btnActivar
		    if (isElementPresent(btnActivar) && isDisplayed(btnActivar)) {
		        click(btnActivar);
		        clicked = true;
		        reporterLog("Se hizo clic en btnActivar (visible).");
		    } else if (isElementPresent(btnActivar)) {
		        // Est� en DOM pero no visible -> scroll y reintentar
		        scrollDown(btnActivar);
		        Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		        if (isDisplayed(btnActivar)) {
		            click(btnActivar);
		            clicked = true;
		            reporterLog("Se hizo clic en btnActivar (despu�s de scroll).");
		        } else {
		            reporterLog("btnActivar presente en DOM pero sigue sin ser visible tras scroll.");
		        }
		    } else {
		        reporterLog("btnActivar no presente en DOM.");
		    }

		    // Si no se hizo clic en btnActivar, intento con btnInactivar
		    if (!clicked) {
		        if (isElementPresent(btnInactivar) && isDisplayed(btnInactivar)) {
		            click(btnInactivar);
		            clicked = true;
		            reporterLog("Se hizo clic en btnInactivar (visible).");
		        } else if (isElementPresent(btnInactivar)) {
		            scrollDown(btnInactivar);
		            Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		            if (isDisplayed(btnInactivar)) {
		                click(btnInactivar);
		                clicked = true;
		                reporterLog("Se hizo clic en btnInactivar (despu�s de scroll).");
		            } else {
		                reporterLog("btnInactivar presente en DOM pero sigue sin ser visible tras scroll.");
		            }
		        } else {
		            reporterLog("btnInactivar no presente en DOM.");
		        }
		    }

		    if (clicked) {
		        // espera breve para que aparezca el texto de confirmaci�n y lo lea
		        Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		        getText(txtActivateOrDesactivate);
		        reporterLog("Cambio de estatus solicitado (se ley� txtActivateOrDesactivate).");
		    } else {
		        reporterLog("No se encontr� ni btnActivar ni btnInactivar (no se realiz� ninguna acci�n).");
		    }

		    // Volver al t�tulo y guardar imagen como antes
		    click(txtTittlePage);
		    return returnSaveImage(txtTittlePage);
		}

	/*
	 * @name: textActivateOrDesactivateIsDisplayed
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
	public boolean textActivateOrDesactivateIsDisplayed() {
		reporterLog("The UEN Elearning Activated or Desactivated ...");
		waitForElementPresent(txtActivateOrDesactivate);
		return isDisplayed(txtActivateOrDesactivate);
	}

}
