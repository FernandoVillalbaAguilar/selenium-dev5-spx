package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class AdministracionAccesosSPXPage extends SPXBase {

	public AdministracionAccesosSPXPage(WebDriver driver) {
		super(driver);
	}

// Objects
	By txtTittlePage = By.xpath("//form[@id='formTable']//div[contains(@class,'spx-card-header__title')]");
	By lblUEN = By.xpath("//label[@id='formTable:uen_label']");
	By slctUEN = By.xpath("//div[@id='formTable:uen_panel']//li[@data-label='Metalsa Argentina']");
	By lblProceso = By.xpath("//label[@id='formTable:tipoProceso_label']");
	// Aprobaci�n de Catalogos
	By slctProcesoAP = By.xpath("//div[@id='formTable:tipoProceso_panel']//li[@data-label='Aprobación de catálogos']");
	// Administraci�n de Compradores
	By slctProcesoAC = By
			.xpath("//div[@id='formTable:tipoProceso_panel']//li[@data-label='Administración de compradores']");
	// Contralor
	By slctProcesC = By.xpath("//div[@id='formTable:tipoProceso_panel']//li[@data-label='Contralor']");
	// Administraci�n de Transferencias
	By slctProcesoAT = By
			.xpath("//div[@id='formTable:tipoProceso_panel']//li[@data-label='Administrador de transferencias']");

	By lblAdministrador = By.xpath("//label[@id='formTable:aprobador_label']");
	By txtAdministrador = By.xpath("");
	By slctAdministrador = By.xpath("");
	By lblDelegado = By.xpath("//label[@id='formTable:delegados']");
	By txtDelegado = By.xpath("//div[@id='formTable:delegados_panel']//input[@role='textbox']");
	By slctDelegado = By.xpath(
			"//div[@id='formTable:delegados_panel']//div[@class='ui-selectcheckboxmenu-items-wrapper']//label[text()='"
					+ GlobalVariablesSPX.SPX_DEV5_DELEGADO + "']");

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
	public boolean textAdministracionAccesosPageIsDisplayed() throws InterruptedException {
		reporterLog("Access to Admon acces...");
		waitForElementPresent(txtTittlePage);
		return isDisplayed(txtTittlePage);
	}

	/*
	 * @name: consultaInformacionGeneral
	 * 
	 * @date: 19/Dec/2025
	 * 
	 * @param: String costCenter
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite consultar información de la pantalla
	 */
	public TreeMap<String, String> consultaInformacionGeneral() throws InterruptedException {

		reporterLog("Consulta información de una UEN para el proceso Aprobación de Catalogos ...");
		// Select UEN
		waitForElementPresent(lblUEN);
		click(lblUEN);
		waitForElementPresent(slctUEN);
		click(slctUEN);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		// Select Process Aprobación Catalogos
		waitForElementPresent(lblProceso);
		click(lblProceso);
		waitForElementPresent(slctProcesoAP);
		click(slctProcesoAP);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		// Select Process Administración de Compradores
		waitForElementPresent(lblProceso);
		click(lblProceso);
		waitForElementPresent(slctProcesoAC);
		click(slctProcesoAC);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		// Select Process Contralor
		waitForElementPresent(lblProceso);
		click(lblProceso);
		waitForElementPresent(slctProcesC);
		click(slctProcesC);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		// Select Process Administrador de Transferencias
		waitForElementPresent(lblProceso);
		click(lblProceso);
		waitForElementPresent(slctProcesoAT);
		click(slctProcesoAT);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		// Volver al título y guardar imagen como antes
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
	 * @description: Este metodo permite verificar que el elemento esté disponible
	 */
	public boolean textActivateOrDesactivateIsDisplayed() {
		reporterLog("The UEN Elearning Activated or Desactivated ...");
		waitForElementPresent(txtTittlePage);
		return isDisplayed(txtTittlePage);
	}

}
