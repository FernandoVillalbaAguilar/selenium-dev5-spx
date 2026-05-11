package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class AccountConfigurationSPXPage extends SPXBase {

	public AccountConfigurationSPXPage(WebDriver driver) {
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
			"//label[contains(@class,'ui-selectonemenu-label') and normalize-space(text())='Selecciona proyecto']");
	By slctSelectProject = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_PROJECT_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectTask = By
			.xpath("//label[contains(@class,'ui-selectonemenu-label') and normalize-space(text())='Selecciona tarea']");
	By slctSelectTask = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_TASK_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectResource = By.xpath(
			"//label[contains(@class,'ui-selectonemenu-label') and normalize-space(text())='Selecciona recurso']");
	By slctSelectResource = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_RESOURSE_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectBuyer = By.xpath(
			"//label[contains(@class,'ui-selectonemenu-label') and normalize-space(text())='Selecciona comprador']");
	By slctSelectBuyer = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_BUYER_ACCOUNT_CONFIGURATION_PAGE);
	// CC
	By btnCC = By.xpath("//table//tr[1]/td[3]//span[contains(@class,'ui-radiobutton-icon')]");
	By lblCostCenter = By.xpath("//*[contains(@id,'cbmCC_label')]");
	By txtCostCenter = By.xpath("//*[contains(@id,'cbmCC_label')]");
	By slctCostCenter = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE);
	By txtSelectAccount = By.xpath("//*[contains(@id,'cbmCuenta')]//div[contains(@class,'ui-selectonemenu-trigger')]");
	By slctSelectAccount = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE);

	By btnAddCC = By.id("formCarroCompras:carroCompra0:0:j_idt237");
	By btnRequisition = By.id("formCarroCompras:crearRequiButton");
	By scrollPage = By.xpath("//div[@id='lyoBdy']//div[@class='ui-layout-unit-content ui-widget-content']");
	By chkSegmentProduct = By.xpath("//span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']");
	By lblSelectAccount = By.xpath(
			"//div[@class='cart-line__cuenta']//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all']");

	// Second Line CC
	By btnCCNewLine = By
			.xpath("//*[@id=\"formCarroCompras:carroCompra0:1:radioTipoCuentas\"]/tbody/tr/td[3]/div/div[2]/span");
	By lblCostCenterNewLine = By
			.xpath("(//div[contains(@id,'cbmCC')]//span[contains(@class,'ui-icon-triangle-1-s')])[2]");
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
	By lblSelectResourceNewLine = By.id("formCarroCompras:carroCompra0:1:j_idt248:0:j_idt258_label");
	By slctSelectResourceNewLine = By
			.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_RESOURSE_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE);
	By lblSelectBuyerNewLine = By.id("formCarroCompras:carroCompra0:1:j_idt248:0:j_idt264_label");
	By slctSelectBuyerNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_BUYER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE);
	By lblCantidad = By.id("formCarroCompras:carroCompra0:0:iNCantidad_input");

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
	 * @description: Este metodo permite verificar que el elemento est� disponible
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
		waitForBlockUIToDisappear();
		waitForElementClickable(btnCC);
		click(btnCC);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		if (!isElementDisabled(btnRequisition)) {
			clickBtnRequisition();
		} else {
			waitForBlockUIToDisappear();
			waitForElementClickable(lblCostCenter);
			click(lblCostCenter);
			waitForBlockUIToDisappear();
			waitForElementClickable(slctCostCenter);
			click(slctCostCenter);
		}
		waitForBlockUIToDisappear();
		if (isElementDisabled(btnRequisition)) {
			reporterLog("Botón deshabilitado, seleccionando cuenta...");
			waitForBlockUIToDisappear();
			click(txtSelectAccount);
			click(slctSelectAccount);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		} else {
			reporterLog("Botón habilitado, no se requiere acción.");
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
	 * @name: selectAndCheckRequisition
	 * 
	 * @date: 11/May/2026
	 * 
	 * @param: By label By option
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método selecciona un valor dentro de un campo desplegable
	 * y posteriormente valida si el botón Requisition queda habilitado.
	 * 
	 * Si el botón está habilitado:
	 * 
	 * - Ejecuta clic sobre Requisition - Retorna true
	 * 
	 * Si el botón continúa deshabilitado:
	 * 
	 * - No ejecuta ninguna acción adicional - Retorna false
	 */
	private boolean selectAndCheckRequisition(By label, By option) {

		waitForBlockUIToDisappear();

		waitForElementClickable(label);
		click(label);

		waitForElementClickable(option);
		click(option);

		waitForBlockUIToDisappear();

		if (!isElementDisabled(btnRequisition)) {
			clickBtnRequisition();
			return true;
		}

		return false;
	}

	/*
	 * @name: processRequisitionLine
	 * 
	 * @date: 11/May/2026
	 * 
	 * @param: By btnLine By lblProject By slctProject By lblTask By slctTask By
	 * lblResource By slctResource By lblBuyer By slctBuyer
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método procesa una línea de requisición.
	 * 
	 * Realiza la selección secuencial de:
	 * 
	 * - Proyecto - Task - Resource - Buyer
	 * 
	 * Después de cada selección valida si el botón Requisition queda habilitado.
	 * 
	 * Si el botón se habilita, ejecuta el clic sobre Requisition y retorna true.
	 * 
	 * Si después de completar todos los campos el botón continúa deshabilitado,
	 * retorna false.
	 */
	private boolean processRequisitionLine(By btnLine, By lblProject, By slctProject, By lblTask, By slctTask,
			By lblResource, By slctResource, By lblBuyer, By slctBuyer) throws InterruptedException {

		click(btnLine);
		waitForBlockUIToDisappear();
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		if (selectAndCheckRequisition(lblProject, slctProject))
			return true;
		if (selectAndCheckRequisition(lblTask, slctTask))
			return true;
		if (selectAndCheckRequisition(lblResource, slctResource))
			return true;
		if (selectAndCheckRequisition(lblBuyer, slctBuyer))
			return true;

		return false;
	}

	/*
	 * @name: selectTypeAccountForRequisitionProject
	 * 
	 * @date: 11/May/2026
	 * 
	 * @param: String project
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método permite seleccionar el tipo de cuenta Proyecto para
	 * una requisición.
	 * 
	 * El flujo valida progresivamente si el botón de Requisition queda habilitado
	 * después de seleccionar:
	 * 
	 * 1. Proyecto 2. Task 3. Resource 4. Buyer
	 * 
	 * Si el botón no se habilita en la primera línea, intenta realizar el mismo
	 * proceso en una segunda línea.
	 * 
	 * Si después de ambas líneas el botón continúa deshabilitado, el método detiene
	 * la ejecución marcando error.
	 */

	public TreeMap<String, String> selectTypeAccountForRequisitionProject(String project) throws InterruptedException {
		reporterLog("Select Type Account For Requisition ...");

		boolean requisitionClicked = processRequisitionLine(btnProject, lblSelectProject, slctSelectProject,
				lblSelectTask, slctSelectTask, lblSelectResource, slctSelectResource, lblSelectBuyer, slctSelectBuyer);

		if (!requisitionClicked) {
			if (isElementPresent(btnProjectNewLine)) {
				scrollDown(btnProjectNewLine);
				Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

				requisitionClicked = processRequisitionLine(btnProjectNewLine, lblSelectProjectNewLine,
						slctSelectProjectNewLine, lblSelectTaskNewLine, slctSelectTaskNewLine, lblSelectResourceNewLine,
						slctSelectResourceNewLine, lblSelectBuyerNewLine, slctSelectBuyerNewLine);
			} else {
				String errorMessage = "No se habilitó Requisition y no existe segunda línea para intentar nuevamente.";
				reporterLog(errorMessage);
				throw new AssertionError(errorMessage);
			}
		}

		if (!requisitionClicked) {
			String errorMessage = "No se habilitó Requisition ni con la primera ni con la segunda línea.";
			reporterLog(errorMessage);
			throw new AssertionError(errorMessage);
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
	 * @description: Este metodo permite verificar que el elemento est� disponible
	 */
	public TreeMap<String, String> clickBtnRequisition() {

		reporterLog("Click to Requisition ...");

		// Validamos si el bot�n existe realmente
		if (!elementExistsAndVisible(btnRequisition)) {
			reporterLog("[ERROR] The button 'Crear Requisición' is NOT available.");
			return returnSaveImage(btnRequisition);
		}

		waitForElementClickable(btnRequisition);

		click(btnRequisition);

		return returnSaveImage(btnRequisition);
	}

}
