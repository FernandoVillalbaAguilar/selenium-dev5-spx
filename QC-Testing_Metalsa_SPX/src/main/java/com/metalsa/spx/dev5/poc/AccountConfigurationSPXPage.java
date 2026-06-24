package com.metalsa.spx.dev5.poc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	// =========================================================
	// CONSTANTES PRIVADAS — Placeholders multilenguaje
	// =========================================================
	private static final Set<String> CC_PLACEHOLDERS = Set.of("selecciona centro de costo", "select cost center",
			"selecionar centro de custo");

	private static final Set<String> ACCOUNT_PLACEHOLDERS = Set.of("selecciona combinación contable",
			"select account combination", "selecionar conta");

	private static final Set<String> PROJECT_PLACEHOLDERS = Set.of("selecciona proyecto", "select project",
			"selecionar projeto");

	private static final Set<String> TASK_PLACEHOLDERS = Set.of("selecciona tarea", "select task", "selecionar tarefa");

	private static final Set<String> RESOURCE_PLACEHOLDERS = Set.of("selecciona recurso", "select resource",
			"selecionar recurso");

	private static final Set<String> BUYER_PLACEHOLDERS = Set.of("selecciona comprador", "select buyer",
			"selecionar comprador");

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
	 * @date: 12/Jun/2026
	 *
	 * @param: N/A
	 *
	 * @return: TreeMap<String, String>
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description: Selecciona CC y Cuenta Contable para todas las líneas
	 * detectadas dinámicamente hasta habilitar el botón Crear Requisición.
	 *
	 * Flujo: 1. Detecta líneas disponibles. 2. Por cada línea: activa CC,
	 * selecciona CC y Cuenta válidos. 3. Valida btnRequisition tras completar todas
	 * las líneas. 4. Si no se habilita, intenta combinaciones alternativas. 5. Si
	 * se agotan combinaciones → AssertionError con mensaje claro.
	 */
	public TreeMap<String, String> selectTypeAccountForRequisitionCC() throws InterruptedException {

		reporterLog("Iniciando configuración de Centros de Costos (automático)...");
		waitForBlockUIToDisappear();

		List<Integer> lines = getAvailableLines();

		if (lines.isEmpty()) {
			throw new AssertionError("No se detectaron líneas para procesar. "
					+ "Verifique que el carrito tenga líneas con radio button CC disponible.");
		}

		reporterLog("Total de líneas detectadas: " + lines.size());

		boolean requisitionEnabled = processAllLines(lines);

		if (!requisitionEnabled) {
			throw new AssertionError("Se agotaron todas las combinaciones de Centro de Costos y "
					+ "Cuenta Contable disponibles. No fue posible habilitar "
					+ "el botón Crear Requisición para esta requisición.");
		}

		reporterLog("[SUCCESS] Crear Requisición habilitado correctamente.");
		TreeMap<String, String> evidence = returnSaveImage(btnRequisition);
		clickBtnRequisition();
		return evidence;
	}

	/*
	 * @name: selectTypeAccountForRequisitionCCWithData
	 *
	 * @date: 12/Jun/2026
	 *
	 * @param: lineData — Lista de pares {costCenter, accountingAccount} por línea.
	 * Índice 0 = línea 0, índice 1 = línea 1... Si accountingAccount es null o
	 * vacío → busca automáticamente. Si CC o cuenta no se encuentran → cae al
	 * automático.
	 *
	 * @return: TreeMap<String, String>
	 *
	 * @author: Fernando Villalba Aguilar
	 */
	public TreeMap<String, String> selectTypeAccountForRequisitionCCWithData(List<String[]> lineData)
			throws InterruptedException {

		reporterLog("Iniciando configuración de Centros de Costos (datos definidos)...");
		waitForBlockUIToDisappear();

		List<Integer> lines = getAvailableLines();

		if (lines.isEmpty()) {
			throw new AssertionError("No se detectaron líneas para procesar.");
		}

		reporterLog("Total de líneas detectadas: " + lines.size());

		for (int i = 0; i < lines.size(); i++) {
			int lineIndex = lines.get(i);
			reporterLog("Procesando línea: " + lineIndex);

			activateCCForLine(lineIndex);

			String targetCC = (lineData != null && i < lineData.size() && lineData.get(i) != null
					&& lineData.get(i).length > 0) ? lineData.get(i)[0] : null;

			String targetAccount = (lineData != null && i < lineData.size() && lineData.get(i) != null
					&& lineData.get(i).length > 1) ? lineData.get(i)[1] : null;

			boolean resolved = resolveLineWithData(lineIndex, targetCC, targetAccount);

			if (!resolved) {
				throw new AssertionError("No fue posible resolver la línea " + lineIndex + " con CC=[" + targetCC
						+ "] Cuenta=[" + targetAccount + "]. "
						+ "Verifique que el CC y la cuenta existan y tengan fondos disponibles.");
			}
		}

		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();

		if (isElementDisabled(btnRequisition)) {
			throw new AssertionError("Todas las líneas fueron procesadas pero Crear Requisición "
					+ "continúa deshabilitado. Los datos especificados no son "
					+ "suficientes para habilitar la requisición.");
		}

		reporterLog("[SUCCESS] Crear Requisición habilitado correctamente.");
		clickBtnRequisition();
		return returnSaveImage(btnRequisition);
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
//	private boolean selectAndCheckRequisition(By label, By option) {
//
//		waitForBlockUIToDisappear();
//
//		waitForElementClickable(label);
//		click(label);
//
//		waitForElementClickable(option);
//		click(option);
//
//		waitForBlockUIToDisappear();
//
//		if (!isElementDisabled(btnRequisition)) {
//			clickBtnRequisition();
//			return true;
//		}
//
//		return false;
//	}

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
//	private boolean processRequisitionLine(By btnLine, By lblProject, By slctProject, By lblTask, By slctTask,
//			By lblResource, By slctResource, By lblBuyer, By slctBuyer) throws InterruptedException {
//
//		click(btnLine);
//		waitForBlockUIToDisappear();
//		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
//
//		if (selectAndCheckRequisition(lblProject, slctProject))
//			return true;
//		if (selectAndCheckRequisition(lblTask, slctTask))
//			return true;
//		if (selectAndCheckRequisition(lblResource, slctResource))
//			return true;
//		if (selectAndCheckRequisition(lblBuyer, slctBuyer))
//			return true;
//
//		return false;
//	}

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

//	public TreeMap<String, String> selectTypeAccountForRequisitionProject(String project) throws InterruptedException {
//		reporterLog("Select Type Account For Requisition ...");
//
//		boolean requisitionClicked = processRequisitionLine(btnProject, lblSelectProject, slctSelectProject,
//				lblSelectTask, slctSelectTask, lblSelectResource, slctSelectResource, lblSelectBuyer, slctSelectBuyer);
//
//		if (!requisitionClicked) {
//			if (isElementPresent(btnProjectNewLine)) {
//				scrollDown(btnProjectNewLine);
//				Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
//
//				requisitionClicked = processRequisitionLine(btnProjectNewLine, lblSelectProjectNewLine,
//						slctSelectProjectNewLine, lblSelectTaskNewLine, slctSelectTaskNewLine, lblSelectResourceNewLine,
//						slctSelectResourceNewLine, lblSelectBuyerNewLine, slctSelectBuyerNewLine);
//			} else {
//				String errorMessage = "No se habilitó Requisition y no existe segunda línea para intentar nuevamente.";
//				reporterLog(errorMessage);
//				throw new AssertionError(errorMessage);
//			}
//		}
//
//		if (!requisitionClicked) {
//			String errorMessage = "No se habilitó Requisition ni con la primera ni con la segunda línea.";
//			reporterLog(errorMessage);
//			throw new AssertionError(errorMessage);
//		}
//
//		return returnSaveImage(btnProject);
//	}

	public TreeMap<String, String> selectTypeAccountForRequisitionProject() throws InterruptedException {

		reporterLog("Iniciando configuración automática de Proyecto...");

		waitForBlockUIToDisappear();

		List<Integer> lines = getAvailableProjectLines();

		if (lines.isEmpty()) {
			throw new AssertionError("No se detectaron líneas para procesar.");
		}

		boolean requisitionEnabled = processAllProjectLines(lines);

		if (!requisitionEnabled) {
			throw new AssertionError("No fue posible habilitar Crear Requisición "
					+ "con ninguna combinación Proyecto/Task/Resource/Buyer.");
		}

		reporterLog("[SUCCESS] Crear Requisición habilitado.");

		TreeMap<String, String> evidence = returnSaveImage(btnRequisition);

		clickBtnRequisition();

		return evidence;
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

	// =========================================================
	// MÉTODOS PRIVADOS DE SOPORTE
	// =========================================================

	/*
	 * @name: processAllLines
	 *
	 * @date: 12/Jun/2026
	 *
	 * @description: Orquesta el procesamiento de todas las líneas siguiendo el
	 * flujo correcto para múltiples líneas:
	 *
	 * 1. Por cada línea: activa CC y selecciona la primera combinación válida (CC +
	 * Cuenta) disponible — NO espera que el botón se habilite línea por línea. 2.
	 * Tras seleccionar una combinación en todas las líneas, valida btnRequisition.
	 * 3. Si se habilita → termina exitosamente. 4. Si no se habilita → intenta con
	 * la siguiente combinación en cada línea. 5. Si se agotan todas las
	 * combinaciones → retorna false.
	 *
	 * CASO ESPECIAL — Una sola línea: Si solo hay una línea, valida el botón
	 * después de cada combinación CC + Cuenta, ya que no hay otras líneas que
	 * completar antes de la validación.
	 */
	private boolean processAllLines(List<Integer> lines) throws InterruptedException {

		reporterLog("Iniciando configuración de Centros de Costos (automático)...");

		// =====================================================
		// UNA SOLA LÍNEA
		// =====================================================
		if (lines.size() == 1) {

			int lineIndex = lines.get(0);

			activateCCForLine(lineIndex);

			return resolveLineAuto(lineIndex);
		}

		// =====================================================
		// MÚLTIPLES LÍNEAS
		// =====================================================

		for (Integer lineIndex : lines) {

			reporterLog("Activando CC para línea: " + lineIndex);

			activateCCForLine(lineIndex);
		}

		// Configurar todas las líneas
		for (Integer lineIndex : lines) {
			reporterLog("[DEBUG] Iniciando configuración línea " + lineIndex);
			boolean configured = resolveLineAutoWithoutButtonValidation(lineIndex);
			reporterLog("[DEBUG] Resultado línea " + lineIndex + ": " + configured);
			if (!configured) {
				reporterLog("[WARNING] No fue posible configurar línea " + lineIndex);
				return false;
			}
		}
		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();

		if (!isElementDisabled(btnRequisition)) {
			reporterLog("[SUCCESS] btnRequisition habilitado.");
			return true;
		}
		reporterLog("[WARNING] Todas las líneas fueron configuradas " + "pero btnRequisition continúa deshabilitado.");
		return false;
	}

	/*
	 * Detecta dinámicamente los índices de línea disponibles buscando los radio
	 * buttons CC (value index :1 = tipo CC).
	 */
	private List<Integer> getAvailableLines() {
		List<Integer> lines = new ArrayList<>();
		List<WebElement> radios = driver.findElements(By.xpath("//input[contains(@id,'radioTipoCuentas:1')]"));
		for (WebElement radio : radios) {
			String id = radio.getAttribute("id");
			java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("carroCompra0:(\\d+):").matcher(id);
			if (matcher.find()) {
				lines.add(Integer.parseInt(matcher.group(1)));
			}
		}
		return lines;
	}

	/*
	 * Activa el radio button CC para la línea indicada. Usa clickJS porque el input
	 * está en ui-helper-hidden-accessible. Valida existencia ANTES de intentar
	 * interactuar.
	 */
	private boolean activateCCForLine(int lineIndex) throws InterruptedException {
		By radioCC = By.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":radioTipoCuentas')]"
				+ "/tbody/tr/td[3]//span[contains(@class,'ui-radiobutton-icon')]");

		if (!isElementPresent(radioCC)) {
			throw new AssertionError("No se encontró radio CC para línea " + lineIndex);
		}

		clickJS(radioCC);
		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

//		if (!isElementDisabled(btnRequisition)) {
//			reporterLog("[SUCCESS] btnRequisition habilitado antes de seleccionar CC en línea " + lineIndex);
//			clickBtnRequisition();
//			return true;
//		}

		return false;
	}

	/*
	 * Valida si el label de CC de la línea ya tiene un valor seleccionado.
	 */
	private boolean isCCAlreadySelected(int lineIndex) {
		By labelCC = By
				.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') " + "and contains(@id,'cbmCC_label')]");
		List<WebElement> elements = driver.findElements(labelCC);
		if (elements.isEmpty())
			return false;
		String text = elements.get(0).getText().trim().toLowerCase();
		return !text.isEmpty() && !CC_PLACEHOLDERS.contains(text);
	}

	/*
	 * Valida si el label de Cuenta de la línea ya tiene un valor seleccionado.
	 */
	private boolean isAccountAlreadySelected(int lineIndex) {
		By labelCuenta = By
				.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') " + "and contains(@id,'cbmCuenta_label')]");
		List<WebElement> elements = driver.findElements(labelCuenta);
		if (elements.isEmpty())
			return false;
		String text = elements.get(0).getText().trim().toLowerCase();
		return !text.isEmpty() && !ACCOUNT_PLACEHOLDERS.contains(text);
	}

	/*
	 * Resuelve una línea en modo automático iterando todas las combinaciones CC +
	 * Cuenta disponibles hasta habilitar btnRequisition.
	 *
	 * Flujo: 1. Si ya tiene CC y Cuenta → valida botón directamente. 2. Itera todos
	 * los CC disponibles: a. Selecciona CC. b. Valida botón (algunos CC
	 * auto-asignan cuenta y habilitan botón). c. Si no se habilita → itera cuentas
	 * disponibles para ese CC. d. Por cada cuenta → valida botón. 3. Si ninguna
	 * combinación habilita el botón → retorna false.
	 */
	private boolean resolveLineAuto(int lineIndex) throws InterruptedException {

		List<String> ccLabels = getAvailableCostCenterLabels(lineIndex);

		reporterLog("CC disponibles para línea " + lineIndex + ": " + ccLabels.size());

		if (ccLabels.isEmpty()) {

			reporterLog("[WARNING] No hay Centros de Costos disponibles para línea " + lineIndex);

			return false;
		}

		for (String ccLabel : ccLabels) {

			reporterLog("[INFO] Probando CC: " + ccLabel);

			selectCostCenterByLabel(lineIndex, ccLabel);

			waitForPrimefacesAjax();
			waitForBlockUIToDisappear();

			if (!isElementDisabled(btnRequisition)) {

				reporterLog("[SUCCESS] CC habilita botón directamente: " + ccLabel);

				return true;
			}

			List<String> accountLabels = getAvailableAccountLabels(lineIndex);

			if (accountLabels.isEmpty()) {

				continue;
			}

			for (String accountLabel : accountLabels) {

				reporterLog("[INFO] Probando cuenta: " + accountLabel);

				selectAccountByLabel(lineIndex, accountLabel);

				waitForPrimefacesAjax();
				waitForBlockUIToDisappear();

				if (!isElementDisabled(btnRequisition)) {

					reporterLog("[SUCCESS] Combinación válida:" + " CC=[" + ccLabel + "]" + " Cuenta=[" + accountLabel
							+ "]");

					return true;
				}
			}
		}

		reporterLog("[WARNING] Se agotaron todas las combinaciones para línea " + lineIndex);

		return false;
	}

	/*
	 * Resuelve una línea con datos predefinidos. Si el CC o la cuenta especificada
	 * no funciona → cae al automático.
	 */
	private boolean resolveLineWithData(int lineIndex, String targetCC, String targetAccount)
			throws InterruptedException {

		// Validar si ya tiene datos correctos
		if (isCCAlreadySelected(lineIndex) && isAccountAlreadySelected(lineIndex)) {
			reporterLog("[INFO] Línea " + lineIndex + " ya tiene CC y Cuenta seleccionados.");
			if (!isElementDisabled(btnRequisition)) {
				return true;
			}
			reporterLog("[INFO] Datos previos no habilitan botón. " + "Intentando con datos especificados...");
		}

		if (targetCC != null && !targetCC.trim().isEmpty()) {
			List<String> ccLabels = getAvailableCostCenterLabels(lineIndex);
			boolean ccFound = ccLabels.stream().anyMatch(l -> l.trim().equalsIgnoreCase(targetCC.trim()));

			if (ccFound) {
				reporterLog("[INFO] CC especificado encontrado: " + targetCC);
				selectCostCenterByLabel(lineIndex, targetCC.trim());

				// CC habilita directamente
				if (!isElementDisabled(btnRequisition)) {
					reporterLog("[SUCCESS] CC especificado habilita botón: " + targetCC);
					return true;
				}

				if (targetAccount != null && !targetAccount.trim().isEmpty()) {
					// Intentar cuenta especificada
					List<String> accountLabels = getAvailableAccountLabels(lineIndex);
					boolean accountFound = accountLabels.stream()
							.anyMatch(l -> l.trim().equalsIgnoreCase(targetAccount.trim()));

					if (accountFound) {
						selectAccountByLabel(lineIndex, targetAccount.trim());
						if (!isElementDisabled(btnRequisition)) {
							reporterLog("[SUCCESS] Cuenta especificada habilita botón: " + targetAccount);
							return true;
						}
						reporterLog("[WARNING] Cuenta especificada [" + targetAccount
								+ "] no habilita botón. Cayendo al automático...");
					} else {
						reporterLog("[WARNING] Cuenta especificada [" + targetAccount
								+ "] no encontrada. Cayendo al automático...");
					}
				} else {
					// Sin cuenta especificada → buscar primera disponible
					List<String> accountLabels = getAvailableAccountLabels(lineIndex);
					for (String accountLabel : accountLabels) {
						selectAccountByLabel(lineIndex, accountLabel);
						if (!isElementDisabled(btnRequisition)) {
							reporterLog("[SUCCESS] Cuenta automática habilita botón: " + accountLabel);
							return true;
						}
					}
					reporterLog("[WARNING] Ninguna cuenta automática habilitó el botón " + "con CC=[" + targetCC
							+ "]. Cayendo al automático...");
				}
			} else {
				reporterLog("[WARNING] CC especificado [" + targetCC + "] no encontrado. Cayendo al automático...");
			}
		}

		// Fallback — comportamiento completamente automático
		reporterLog("[INFO] Iniciando búsqueda automática para línea: " + lineIndex);
		return resolveLineAuto(lineIndex);
	}

	/*
	 * resolveLineAutoWithoutButtonValidation
	 */

	private boolean resolveLineAutoWithoutButtonValidation(int lineIndex) throws InterruptedException {

		reporterLog("[INFO] Configurando línea " + lineIndex);

		List<String> ccLabels = getAvailableCostCenterLabels(lineIndex);

		if (ccLabels.isEmpty()) {

			reporterLog("[WARNING] No existen Centros de Costos para línea " + lineIndex);

			return false;
		}

		for (String ccLabel : ccLabels) {

			reporterLog("[INFO] Probando CC: " + ccLabel);

			selectCostCenterByLabel(lineIndex, ccLabel);

			waitForPrimefacesAjax();
			waitForBlockUIToDisappear();

			List<String> accountLabels = getAvailableAccountLabels(lineIndex);

			// CC sin cuentas
			if (accountLabels.isEmpty()) {

				reporterLog("[WARNING] No existen cuentas para CC: " + ccLabel);
				continue;
			}

			// Seleccionar primera cuenta disponible
			String accountLabel = accountLabels.get(0);

			selectAccountByLabel(lineIndex, accountLabel);

			waitForPrimefacesAjax();
			waitForBlockUIToDisappear();

			reporterLog("[INFO] Línea " + lineIndex + " configurada con:" + " CC=[" + ccLabel + "]" + " Cuenta=["
					+ accountLabel + "]");
			return true;
		}

		return false;
	}

	/*
	 * Obtiene los data-label válidos del panel CC. Trabaja con Strings — NO
	 * WebElements — para evitar StaleElementReferenceException.
	 */
	private List<String> getAvailableCostCenterLabels(int lineIndex) {

		reporterLog("[DEBUG] Abriendo dropdown CC línea " + lineIndex);
		openCostCenterDropdown(lineIndex);

		By validItems = By.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') "
				+ "and contains(@id,'cbmCC_panel')]" + "//li[contains(@class,'ui-selectonemenu-item')]");

		List<WebElement> items = driver.findElements(validItems);

		reporterLog("[DEBUG] Items CC encontrados línea " + lineIndex + ": " + items.size());
		List<String> labels = items
				.stream().map(item -> item.getAttribute("data-label")).filter(label -> label != null
						&& !label.trim().isEmpty() && !CC_PLACEHOLDERS.contains(label.trim().toLowerCase()))
				.collect(Collectors.toList());

		reporterLog("[DEBUG] CC encontrados línea " + lineIndex + ": " + labels);
		return labels;
	}

	/*
	 * Obtiene los data-label válidos del panel Cuenta. Verifica si cbmCuenta está
	 * deshabilitado antes de intentar abrir el panel.
	 */
	private List<String> getAvailableAccountLabels(int lineIndex) {

		// Verificar si el dropdown de cuenta está habilitado
		By cbmCuenta = By
				.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') " + "and contains(@id,'cbmCuenta') "
						+ "and not(contains(@id,'_panel')) " + "and not(contains(@id,'_label')) "
						+ "and not(contains(@id,'_focus')) " + "and not(contains(@id,'_input'))]");

		List<WebElement> cuentaElements = driver.findElements(cbmCuenta);

		if (!cuentaElements.isEmpty()) {

			String classAttr = cuentaElements.get(0).getAttribute("class");

			if (classAttr != null && classAttr.contains("ui-state-disabled")) {

				reporterLog("[INFO] cbmCuenta deshabilitado para línea: " + lineIndex
						+ ". Este CC no tiene combinaciones contables disponibles.");
				return new ArrayList<>();
			}
		}

		openAccountDropdown(lineIndex);

		By validItems = By.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') "
				+ "and contains(@id,'cbmCuenta_panel')]" + "//li[contains(@class,'ui-selectonemenu-item')]");

		List<String> accountLabels = driver.findElements(validItems).stream()
				.map(item -> item.getAttribute("data-label")).filter(label -> label != null && !label.trim().isEmpty()
						&& !ACCOUNT_PLACEHOLDERS.contains(label.trim().toLowerCase()))
				.collect(Collectors.toList());

		// =========================================================
		// DEBUG
		// =========================================================
		reporterLog("[DEBUG] Línea " + lineIndex + " - Cuentas encontradas: " + accountLabels.size() + " -> "
				+ accountLabels);
		// Verificar si siempre regresa la misma cuenta
		if (!accountLabels.isEmpty()) {

			WebElement panel = driver.findElement(By.xpath(
					"//*[contains(@id,'carroCompra0:" + lineIndex + ":') " + "and contains(@id,'cbmCuenta_panel')]"));

			reporterLog("[DEBUG] Panel Cuenta ID: " + panel.getAttribute("id"));

			reporterLog("[DEBUG] Panel Cuenta Displayed: " + panel.isDisplayed());
		}

		return accountLabels;
	}

	/*
	 * Selecciona un CC por su data-label. Re-localiza el elemento justo antes del
	 * clic para evitar StaleElementReferenceException.
	 */
	private void selectCostCenterByLabel(int lineIndex, String ccLabel) throws InterruptedException {
		reporterLog("Seleccionando Centro de Costos: " + ccLabel);
		openCostCenterDropdown(lineIndex);
		By itemLocator = By.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') "
				+ "and contains(@id,'cbmCC_panel')]" + "//li[@data-label='" + ccLabel.replace("'", "\\'") + "']");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariablesSPX.DEFAULT_TIMEOUT));
		WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(itemLocator));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", item);
		js.executeScript("arguments[0].click();", item);

		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
	}

	/*
	 * Selecciona una Cuenta por su data-label. Re-localiza el elemento justo antes
	 * del clic para evitar StaleElementReferenceException.
	 */
	private void selectAccountByLabel(int lineIndex, String accountLabel) throws InterruptedException {
		reporterLog("Seleccionando Cuenta Contable: " + accountLabel);
		openAccountDropdown(lineIndex);
		By itemLocator = By
				.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') " + "and contains(@id,'cbmCuenta_panel')]"
						+ "//li[@data-label='" + accountLabel.replace("'", "\\'") + "']");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariablesSPX.DEFAULT_TIMEOUT));
		WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(itemLocator));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", item);
		js.executeScript("arguments[0].click();", item);

		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
	}

	/*
	 * Abre el dropdown de Centro de Costos para la línea indicada.
	 */
	private void openCostCenterDropdown(int lineIndex) {
		By triggerCC = By.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') " + "and contains(@id,'cbmCC')]"
				+ "//div[contains(@class,'ui-selectonemenu-trigger')]");
		waitForElementClickable(triggerCC);
		click(triggerCC);
		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
	}

	/*
	 * Abre el dropdown de Cuenta Contable para la línea indicada.
	 */
	private void openAccountDropdown(int lineIndex) {
		By triggerAccount = By.xpath("//*[contains(@id,'carroCompra0:" + lineIndex + ":') "
				+ "and contains(@id,'cbmCuenta')]" + "//div[contains(@class,'ui-selectonemenu-trigger')]");
		waitForElementClickable(triggerAccount);
		click(triggerAccount);
		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
	}

	/*
	 * @name: processAllProjectLines
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: List<Integer> lines
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Orquesta el procesamiento de todas las líneas del flujo
	 * Proyecto. Cada línea se resuelve probando combinaciones Proyecto / Task /
	 * Resource / Buyer hasta habilitar el botón Crear Requisición.
	 */
	private boolean processAllProjectLines(List<Integer> lines) throws InterruptedException {

		for (Integer line : lines) {

			reporterLog("Procesando línea: " + line);

			boolean success = resolveProjectLineAuto(line);

			if (!success) {

				reporterLog("No se encontró combinación válida para línea " + line);

				return false;
			}
		}

		return !isElementDisabled(btnRequisition);
	}

	/*
	 * @name: resolveProjectLineAuto
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Resuelve una línea en modo automático probando todas las
	 * combinaciones disponibles de Proyecto, Task, Resource y Buyer hasta habilitar
	 * el botón Crear Requisición.
	 */
	private boolean resolveProjectLineAuto(int lineIndex) throws InterruptedException {

		List<String> projects = getAvailableProjectLabels(lineIndex);

		reporterLog("Proyectos disponibles para línea " + lineIndex + ": " + projects.size());

		if (projects.isEmpty()) {
			reporterLog("[WARNING] No hay Proyectos disponibles para línea " + lineIndex);
			return false;
		}

		for (String project : projects) {

			reporterLog("[INFO] Probando Proyecto: " + project);
			selectProject(lineIndex, project);

			if (!isElementDisabled(btnRequisition)) {
				reporterLog("[SUCCESS] Proyecto habilita botón directamente: " + project);
				return true;
			}

			List<String> tasks = getAvailableTaskLabels(lineIndex);

			if (tasks.isEmpty()) {
				continue;
			}

			for (String task : tasks) {

				reporterLog("[INFO] Probando Task: " + task);
				selectTask(lineIndex, task);

				if (!isElementDisabled(btnRequisition)) {
					reporterLog("[SUCCESS] Combinación válida: Proyecto=[" + project + "] Task=[" + task + "]");
					return true;
				}

				List<String> resources = getAvailableResourceLabels(lineIndex);

				if (resources.isEmpty()) {
					continue;
				}

				for (String resource : resources) {

					reporterLog("[INFO] Probando Resource: " + resource);
					selectResource(lineIndex, resource);

					if (!isElementDisabled(btnRequisition)) {
						reporterLog("[SUCCESS] Combinación válida: Proyecto=[" + project + "] Task=[" + task
								+ "] Resource=[" + resource + "]");
						return true;
					}

					List<String> buyers = getAvailableBuyerLabels(lineIndex);

					if (buyers.isEmpty()) {
						continue;
					}

					for (String buyer : buyers) {

						reporterLog("[INFO] Probando Buyer: " + buyer);
						selectBuyer(lineIndex, buyer);

						if (!isElementDisabled(btnRequisition)) {
							reporterLog("[SUCCESS] Combinación válida encontrada: Proyecto=[" + project + "] Task=["
									+ task + "] Resource=[" + resource + "] Buyer=[" + buyer + "]");
							return true;
						}
					}
				}
			}
		}

		reporterLog("[WARNING] Se agotaron todas las combinaciones para línea " + lineIndex);
		return false;
	}

	/*
	 * @name: getAvailableProjectLines
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: List<Integer>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Detecta dinámicamente las líneas disponibles del bloque
	 * Proyecto buscando los paneles de combinación existentes en la pantalla.
	 */
	private List<Integer> getAvailableProjectLines() {

		List<Integer> lines = new ArrayList<>();

		List<WebElement> panels = driver.findElements(By.cssSelector("div.panelCombos"));
		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@id,'carroCompra0:')]"));

		reporterLog("Elementos encontrados: " + elements.size());
		System.out.println("Elementos encontrados: " + elements.size());

		for (WebElement panel : panels) {

			String id = panel.getAttribute("id");

			if (id == null || id.trim().isEmpty()) {
				continue;
			}

			java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("carroCompra0:(\\d+):").matcher(id);

			if (matcher.find()) {

				Integer lineIndex = Integer.parseInt(matcher.group(1));

				if (!lines.contains(lineIndex)) {
					lines.add(lineIndex);
				}
			}
		}

		lines.sort(Integer::compareTo);
		return lines;
	}

	/*
	 * @name: getAvailableProjectLabels
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: List<String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene los valores válidos del combo Proyecto para la línea
	 * indicada sin incluir el placeholder.
	 */
	private List<String> getAvailableProjectLabels(int lineIndex) {

		return getAvailableLabels(lineIndex, "j_idt250", PROJECT_PLACEHOLDERS, "Proyecto");
	}

	/*
	 * @name: getAvailableTaskLabels
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: List<String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene los valores válidos del combo Task para la línea
	 * indicada sin incluir el placeholder.
	 */
	private List<String> getAvailableTaskLabels(int lineIndex) {

		return getAvailableLabels(lineIndex, "j_idt253", TASK_PLACEHOLDERS, "Task");
	}

	/*
	 * @name: getAvailableResourceLabels
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: List<String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene los valores válidos del combo Resource para la línea
	 * indicada sin incluir el placeholder.
	 */
	private List<String> getAvailableResourceLabels(int lineIndex) {

		return getAvailableLabels(lineIndex, "j_idt256", RESOURCE_PLACEHOLDERS, "Resource");
	}

	/*
	 * @name: getAvailableBuyerLabels
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: List<String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene los valores válidos del combo Buyer para la línea
	 * indicada sin incluir el placeholder.
	 */
	private List<String> getAvailableBuyerLabels(int lineIndex) {

		return getAvailableLabels(lineIndex, "j_idt259", BUYER_PLACEHOLDERS, "Buyer");
	}

	/*
	 * @name: selectProject
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String project
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Selecciona un Proyecto válido dentro del combo de la línea
	 * indicada.
	 */
	private void selectProject(int lineIndex, String project) throws InterruptedException {

		selectComboValue(lineIndex, "j_idt250", project, "Proyecto");
	}

	/*
	 * @name: selectTask
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String task
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Selecciona una Task válida dentro del combo de la línea
	 * indicada.
	 */
	private void selectTask(int lineIndex, String task) throws InterruptedException {

		selectComboValue(lineIndex, "j_idt253", task, "Task");
	}

	/*
	 * @name: selectResource
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String resource
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Selecciona un Resource válido dentro del combo de la línea
	 * indicada.
	 */
	private void selectResource(int lineIndex, String resource) throws InterruptedException {

		selectComboValue(lineIndex, "j_idt256", resource, "Resource");
	}

	/*
	 * @name: selectBuyer
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String buyer
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Selecciona un Buyer válido dentro del combo de la línea
	 * indicada.
	 */
	private void selectBuyer(int lineIndex, String buyer) throws InterruptedException {

		selectComboValue(lineIndex, "j_idt259", buyer, "Buyer");
	}

	/*
	 * @name: openProjectDropdown
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Abre el combo Proyecto para la línea indicada.
	 */
//	private void openProjectDropdown(int lineIndex) {
//
//		openComboDropdown(lineIndex, "j_idt250");
//	}

	/*
	 * @name: openTaskDropdown
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Abre el combo Task para la línea indicada.
	 */
//	private void openTaskDropdown(int lineIndex) {
//
//		openComboDropdown(lineIndex, "j_idt253");
//	}

	/*
	 * @name: openResourceDropdown
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Abre el combo Resource para la línea indicada.
	 */
//	private void openResourceDropdown(int lineIndex) {
//
//		openComboDropdown(lineIndex, "j_idt256");
//	}

	/*
	 * @name: openBuyerDropdown
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Abre el combo Buyer para la línea indicada.
	 */
//	private void openBuyerDropdown(int lineIndex) {
//
//		openComboDropdown(lineIndex, "j_idt259");
//	}

	/*
	 * @name: openComboDropdown
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String componentId
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método genérico para abrir cualquier combo de Proyecto
	 * reutilizando el mismo patrón de localización.
	 */
	private void openComboDropdown(int lineIndex, String componentId) {

		By trigger = By.xpath("//div[@id='" + buildComboRootId(lineIndex, componentId) + "']"
				+ "//div[contains(@class,'ui-selectonemenu-trigger')]");

		waitForElementClickable(trigger);
		click(trigger);

		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
	}

	/*
	 * @name: getAvailableLabels
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String componentId, Set<String> placeholders, String
	 * friendlyName
	 * 
	 * @return: List<String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene las opciones visibles de un combo, filtrando el
	 * placeholder para evitar selecciones inválidas.
	 */
	private List<String> getAvailableLabels(int lineIndex, String componentId, Set<String> placeholders,
			String friendlyName) {

		reporterLog("[DEBUG] Abriendo dropdown " + friendlyName + " línea " + lineIndex);
		openComboDropdown(lineIndex, componentId);

		By itemsLocator = By.xpath("//div[@id='" + buildComboPanelId(lineIndex, componentId) + "']"
				+ "//li[contains(@class,'ui-selectonemenu-item')]");

		List<WebElement> items = driver.findElements(itemsLocator);

		List<String> labels = items.stream().map(item -> item.getAttribute("data-label")).filter(
				label -> label != null && !label.trim().isEmpty() && !placeholders.contains(label.trim().toLowerCase()))
				.collect(Collectors.toList());

		reporterLog("[DEBUG] " + friendlyName + " encontrados línea " + lineIndex + ": " + labels);
		return labels;
	}

	/*
	 * @name: selectComboValue
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String componentId, String value, String friendlyName
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Selecciona una opción de un combo por su data-label de forma
	 * segura, reubicando el elemento justo antes del clic para evitar stale
	 * element.
	 */
	private void selectComboValue(int lineIndex, String componentId, String value, String friendlyName)
			throws InterruptedException {

		reporterLog("Seleccionando " + friendlyName + ": " + value);

		openComboDropdown(lineIndex, componentId);

		By itemLocator = By.xpath("//div[@id='" + buildComboPanelId(lineIndex, componentId) + "']" + "//li[@data-label="
				+ toXPathLiteral(value) + "]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariablesSPX.DEFAULT_TIMEOUT));
		WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(itemLocator));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", item);
		js.executeScript("arguments[0].click();", item);

		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
	}

	/*
	 * @name: buildComboRootId
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String componentId
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Construye el id base del combo para una línea específica.
	 */
	private String buildComboRootId(int lineIndex, String componentId) {

		return "formCarroCompras:carroCompra0:" + lineIndex + ":j_idt246:0:" + componentId;
	}

	/*
	 * @name: buildComboPanelId
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: int lineIndex, String componentId
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Construye el id del panel desplegable asociado al combo de una
	 * línea específica.
	 */
	private String buildComboPanelId(int lineIndex, String componentId) {

		return buildComboRootId(lineIndex, componentId) + "_panel";
	}

	/*
	 * @name: toXPathLiteral
	 * 
	 * @date: 17/Jun/2026
	 * 
	 * @param: String value
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Convierte un texto en un literal XPath seguro para soportar
	 * comillas simples y dobles dentro del valor.
	 */
	private String toXPathLiteral(String value) {

		if (value == null) {
			return "''";
		}

		if (!value.contains("'")) {
			return "'" + value + "'";
		}

		if (!value.contains("\"")) {
			return "\"" + value + "\"";
		}

		String[] parts = value.split("'");
		StringBuilder sb = new StringBuilder("concat(");

		for (int i = 0; i < parts.length; i++) {
			if (i > 0) {
				sb.append(", \"'\", ");
			}
			sb.append("'").append(parts[i]).append("'");
		}

		sb.append(")");
		return sb.toString();
	}
}
