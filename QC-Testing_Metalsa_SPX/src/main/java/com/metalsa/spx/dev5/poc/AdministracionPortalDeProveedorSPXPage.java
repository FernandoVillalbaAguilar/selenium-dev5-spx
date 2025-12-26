package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class AdministracionPortalDeProveedorSPXPage extends SPXBase {

	public AdministracionPortalDeProveedorSPXPage(WebDriver driver) {
		super(driver);
	}

// Objects
	By txtAccountConfiguration = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[2]/span[1]");
	By btnBack = By.id("formCarroCompras:goBack1");
	By chkMultiCheck = By.id("multiCheck");
	By iconExpandColapse = By.id("//i[@class='fa fa-chevron-down chevron-icon fa-2x']");
	By iconCursorHelp = By.id("formCarroCompras:carroCompra0:asignaCtaHelp");
	By btnAssignAccountToGroupOfLines = By.id("formCarroCompras:carroCompra0:btnviewAsignaCuentas");
	By iconTypeRequisition = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/i[1]");
	By hrefEditRequisition = By.xpath("//div[@class='cart-container__header--name']");
	By btnLineDiscarded = By.id("formCarroCompras:carroCompra0:0:j_idt182");
	By txtQuantity = By.id("formCarroCompras:carroCompra0:0:iNCantidad_input");
	// Project
	By btnProject = By.xpath(
			"//body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/span[1]");
	By lblSelectProject = By.xpath(
			"//tbody/tr[@role='row']/td[@role='gridcell']/div/div/div/div/div/div/div/div/div/div/div/div[1]/label[1]");
	By slctSelectProject = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_PROJECT_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectTask = By.id("formCarroCompras:carroCompra0:0:j_idt248:0:j_idt255_label");
	By slctSelectTask = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_TASK_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectResourse = By.id("formCarroCompras:carroCompra0:0:j_idt248:0:j_idt258_label");
	By slctSelectResourse = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_RESOURSE_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectBuyer = By.id("formCarroCompras:carroCompra0:0:j_idt248:0:j_idt264_label");
	By slctSelectBuyer = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_BUYER_ACCOUNT_CONFIGURATION_PAGE);
	// CC
	By btnCC = By.xpath(
			"//body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[2]/span[1]");
	By lblCostCenter = By.xpath("//label[text()='Selecciona centro de costo']/parent::div");
	By txtCostCenter = By.id("//label[text()='Selecciona centro de costo']/parent::div");
	By slctCostCenter = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE);
	By txtSelectAccount = By.xpath("//label[contains(@id,'cbmCuenta_label')]");
	By slctSelectAccount = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE);

	By btnAddCC = By.id("formCarroCompras:carroCompra0:0:j_idt237");
	By btnRequisition = By.id("formCarroCompras:crearRequiButton");
	By scrollPage = By.xpath("//div[@id='lyoBdy']//div[@class='ui-layout-unit-content ui-widget-content']");
	By chkSegmentProduct = By.xpath("//span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']");
	By lblSelectAccount = By.xpath(
			"//div[@class='cart-line__cuenta']//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all']");

	// Second Line CC
	By btnCCNewLine = By.xpath(
			"//*[@id=\"formCarroCompras:carroCompra0:1:radioTipoCuentas\"]/tbody/tr/td[3]/div/div[2]/span");
	By lblCostCenterNewLine = By.xpath(
			"(//div[contains(@id,'cbmCC')]//span[contains(@class,'ui-icon-triangle-1-s')])[2]");
	By txtCostCenterNewLine = By.xpath("//div[contains(@id,'cbmCC_panel') and contains(@style,'display')]\r\n"
			+ "     //input[contains(@id,'cbmCC_filter')]");
	By slctCostCenterNewLine = By
			.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_COST_CENTER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE);
	By txtSelectAccountNewLine = By.id("");
	By slctSelectAccountNewLine = By
			.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_ACCOUNT_CC_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE);
	// Second Line Project
	By btnProjectNewLine = By.xpath(
			"//input[@id='formCarroCompras:carroCompra0:1:radioTipoCuentas:0']/ancestor::div[contains(@class,'ui-radiobutton')][1]//span[contains(@class,'ui-radiobutton-icon')]");
	By lblSelectProjectNewLine = By.id("formCarroCompras:carroCompra0:1:j_idt248:0:j_idt252_label");
	By slctSelectProjectNewLine = By
			.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_PROJECT_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectTaskNewLine = By.id("formCarroCompras:carroCompra0:1:j_idt248:0:j_idt255_label");
	By slctSelectTaskNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_TASK_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectResourseNewLine = By.id("formCarroCompras:carroCompra0:1:j_idt248:0:j_idt258_label");
	By slctSelectResourseNewLine = By
			.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_RESOURSE_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectBuyerNewLine = By.id("formCarroCompras:carroCompra0:1:j_idt248:0:j_idt264_label");
	By slctSelectBuyerNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_BUYER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE);
	By lblCantidad   = By.id("formCarroCompras:carroCompra0:0:iNCantidad_input");

	/*
	 * @name: textAccountConfigurationPageIsDisplayed
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtAccountConfiguration);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean textAccountConfigurationPageIsDisplayed() {
		reporterLog("Access to Account Configuration Page ...");
		waitForElementPresent(txtAccountConfiguration);
		return isElementPresent(txtAccountConfiguration);
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

	public TreeMap<String, String> selectTypeAccountForRequisitionCC(String costCenter, String accountingAccount)
			throws InterruptedException {

		reporterLog("Select Type Account For Requisition ...");

		click(btnCC);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		if (isElementDisabled(btnRequisition) == false) {
			clickBtnRequisition();
		} else {
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			waitForElementPresent(lblCostCenter);
			click(lblCostCenter);
			waitForElementPresent(slctCostCenter);
			click(slctCostCenter);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		}
		if (isElementDisabled(btnRequisition) == false) {
			clickBtnRequisition();
		} else {
			click(txtSelectAccount);
			click(slctSelectAccount);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		}

		if (isElementPresent(btnCCNewLine)) {
			// Second Line
			scrollDown(lblCantidad);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			click(btnCCNewLine);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			waitForElementPresent(lblCostCenterNewLine);
			click(lblCostCenterNewLine);
			waitForElementPresent(txtCostCenterNewLine);
			type(txtCostCenterNewLine, costCenter);
			waitForElementPresent(slctCostCenterNewLine);
			click(slctCostCenterNewLine);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			if (isElementDisabled(btnRequisition) == false) {
				clickBtnRequisition();
			} else {
				click(txtSelectAccountNewLine);
				type(slctSelectAccountNewLine, accountingAccount);
				Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			}
			clickBtnRequisition();
		} else {
			System.out.println("I could not find the CC button on the second line...");
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			clickBtnRequisition();
		}
		return returnSaveImage(btnCC);
	}
	/*
	 * @name: selectTypeAccountForRequisitionProject
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: String costCenter
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite seleccionar el tipo de cobro Proyecto
	 */

	public TreeMap<String, String> selectTypeAccountForRequisitionProject(String project) throws InterruptedException {

		reporterLog("Select Type Account For Requisition ...");

		click(btnProject);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		click(lblSelectProject);
		click(slctSelectProject);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		if (isElementDisabled(btnRequisition) == false) {
			clickBtnRequisition();
		} else {
			click(lblSelectTask);
			click(slctSelectTask);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			if (isElementDisabled(btnRequisition) == false) {
				clickBtnRequisition();
			} else {
				click(lblSelectResourse);
				click(slctSelectResourse);
				Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			}
			if (isElementDisabled(btnRequisition) == false) {
				clickBtnRequisition();
			} else {
				click(lblSelectBuyer);
				click(slctSelectBuyer);
			}
		}

		if (isElementPresent(btnProjectNewLine)) {
			// Second Line
			scrollDown(btnProjectNewLine);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			click(btnProjectNewLine);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			click(lblSelectProjectNewLine);
			click(slctSelectProjectNewLine);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			if (isElementDisabled(btnRequisition) == false) {
				clickBtnRequisition();
			} else {
				click(lblSelectTaskNewLine);
				click(slctSelectTaskNewLine);
				Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
				if (isElementDisabled(btnRequisition) == false) {
					clickBtnRequisition();
				} else {
					click(lblSelectResourseNewLine);
					click(slctSelectResourseNewLine);
					Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
					if (isElementDisabled(btnRequisition) == false) {
						clickBtnRequisition();
					} else {
						click(lblSelectBuyerNewLine);
						click(slctSelectBuyerNewLine);
						Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
					}
				}

			}
			clickBtnRequisition();
		} else {
			System.out.println("I could not find the Proyect button on the second line...");
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			clickBtnRequisition();
		}
		return returnSaveImage(btnProject);
	}

	/*
	 * @name: clickBtnRequisition
	 * 
	 * @date: 07/Nov/2023
	 * 
	 * @param: String costCenter
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> clickBtnRequisition() {

	    reporterLog("Click to Requisition ...");

	    // Validamos si el botón existe realmente
	    if (!elementExistsAndVisible(btnRequisition)) {
	        reporterLog("[ERROR] The button 'Crear Requisición' is NOT available.");
	        return returnSaveImage(btnRequisition);
	    }

	    waitForElementClickable(btnRequisition);

	    click(btnRequisition);

	    return returnSaveImage(btnRequisition);
	}

}
