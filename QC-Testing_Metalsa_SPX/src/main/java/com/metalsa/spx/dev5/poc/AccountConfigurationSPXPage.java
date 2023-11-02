package com.metalsa.spx.dev5.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class AccountConfigurationSPXPage extends SPXBase {

	public AccountConfigurationSPXPage(WebDriver driver) {
		super(driver);
	}

// Objects
	By txtAccountConfiguration = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[2]/span[1]");
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
	By btnProject = By.xpath(
			"//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default ui-state-hover']//span[@class='ui-radiobutton-icon ui-icon ui-icon-blank']");
	By lblSelectProject = By.id("formCarroCompras:carroCompra0:0:j_idt247:0:j_idt251_label");
	By slctSelectProject = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_PROJECT_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectTask = By.id("formCarroCompras:carroCompra0:0:j_idt247:0:j_idt254_label");
	By slctSelectTask = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_TASK_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectResourse = By.id("formCarroCompras:carroCompra0:0:j_idt247:0:j_idt257_label");
	By slctSelectResourse = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_RESOURSE_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectBuyer = By.id("formCarroCompras:carroCompra0:0:j_idt247:0:j_idt263_label");
	By slctSelectBuyer = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_BUYER_ACCOUNT_CONFIGURATION_PAGE);
	By btnCC = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[2]/span[1]");
	By lblCostCenter = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/div[4]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/label[1]");
	By txtCostCenter = By.id("formCarroCompras:carroCompra0:0:j_idt247:0:cbmCC_filter");
	By slctCostCenter = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE);
	By chkSegmentProduct = By.xpath("//span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']");
	By lblSelectAccount = By.id("formCarroCompras:carroCompra0:0:j_idt247:0:cbmCuenta_label");
	By slctSelectAccount = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE);
	By btnAddCC = By.id("formCarroCompras:carroCompra0:0:j_idt237");
	By btnRequisition = By.id("formCarroCompras:crearRequiButton");

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
		try {
			reporterLog("Access to Account Configuration Page ...");
			waitForElementPresent(txtAccountConfiguration);
			return isDisplayed(txtAccountConfiguration);
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;

		}
	}

	/*
	 * @name: textAccountConfigurationPageIsDisplayed
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: String costCenter
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */

	public void selectTypeAccountForRequisition(String costCenter) throws InterruptedException {
		try {
			reporterLog("Select Type Account For Requisition ...");
			click(btnCC);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			waitForElementPresent(lblCostCenter);
			click(lblCostCenter);
			waitForElementPresent(txtCostCenter);
			type(txtCostCenter, costCenter);
			waitForElementPresent(slctCostCenter);
			click(slctCostCenter);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			click(btnRequisition);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		} catch (TimeoutException e) {
			e.printStackTrace();

		}
	}
}
