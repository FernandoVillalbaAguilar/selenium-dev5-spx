package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class SpotBuyRequisitionsSPXPage extends SPXBase {

	public SpotBuyRequisitionsSPXPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	// Header Objects
	By btnBack = By.id("formSpot:j_idt327");
	By spanSpotBuyRequisitionsPage = By.xpath("//span[@class='spx-card-header__title']");
	By btnBulkLoad = By.id("formSpot:nwbtnCargaMasivaSpot");
	By btnNewLine = By.id("formSpot:newLineButton");
	By btnAddToCart = By.id("formSpot:add-cart-btn");
	By lblGlobalSourcingRFQ = By.id("formSpot:listrfspxview_label");
	By txtGlobalSourcingRFQ = By.id("formSpot:listrfspxview_filter");
	By slctGlobalSourcingRFQ = By.id("");

	// Additional Header Parameters Objects
	By chkProductServicereceivedwithoutrequisition = By.id("formSpot:servicioMaterialRealizado");
	By chkIncludeSingleSourceFormat = By.id("formSpot:formatoAsignacionDirecta");
	By textValidateSameLine = By.xpath(
			"//div[@id='mesageError']//p[contains(text(),'No se pueden tener líneas con la misma información')]");
	By textValidateFields = By.id("mesageError");
	// Line Header Objects
	By chkLine = By.id("formSpot:j_idt371");
	By btnExpanColapse = By.id("formSpot:j_idt375");
	By btnDeleteLine = By.id("formSpot:j_idt373");

	// First Section Objects
	By txtDescription = By.id("formSpot:desc_1");
	By txtMaterial = By.xpath("//span//div[@class='ui-grid-row']//div[1]//div[1]//div[2]//input[1]"); // formSpot:j_idt386
	By txtColor = By.xpath("//span//div[@class='ui-grid-row']//div[1]//div[2]//div[2]//input[1]");
	By txtBrand = By.xpath("//div[@class='ui-grid-row']//div[1]//div[3]//div[2]//input[1]");
	By txtMeasurements = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/fieldset[1]/div[1]/div[2]/div[2]/div[1]/div[2]/input[1]");
	By txtModelPartNumber = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/fieldset[1]/div[1]/div[2]/div[2]/div[2]/div[2]/input[1]");
	By txtGenericName = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/fieldset[1]/div[1]/div[2]/div[2]/div[3]/div[2]/input[1]");

	// Second Section Objects
	By lblSubTittle = By.xpath("//label[ contains(normalize-space(.), 'Classification, Quantity & Date') "
			+ "or contains(normalize-space(.), 'Clasificación, Cantidad & Fecha') ]");
	By lblCategory = By.id("formSpot:nwcboCategorias0_label");
	By txtSearchCategory = By.id("formSpot:nwcboCategorias0_filter");
	By selectOptionCategory = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE);
	By lblFamily = By.id("formSpot:nwcboFamilias0_label");
	By txtSearchFamily = By.id("formSpot:nwcboFamilias0_filter");
	By txtSearchFamilyNewLine = By.id("formSpot:nwcboFamilias1_filter");
	By selectOptionFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE);
	By selectOptionFamilyNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION__NEW_LINE_SPOT_PAGE);
	By lblSubFamily = By.id("formSpot:nwcboSubFamilias0_label");
	By txtSearchSubFamily = By.id("formSpot:nwcboSubFamilias0_filter");
	By txtSearchSubFamilyNewLine = By.id("formSpot:nwcboSubFamilias1_filter");
	By selectOptionSubFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE);
	By selectOptionSubFamilyNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_NEW_LINE_SPOT_PAGE);
	By txtGenericItem = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/div[1]/div[1]/fieldset[1]/div[1]/div[4]/div[1]/div[2]/input[1]");
	By txtQuantity = By.id("formSpot:cantidadReq_input");
	By lblUnitOfMeasure = By.id("formSpot:comboUDM");
	By txtSearchUnitOfMeasure = By.id("formSpot:comboUDM_filter");
	By selectOptionUnitOfMeasure = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_UNIT_OF_MEASURE_OPTION_SPOT_PAGE);
	By fieldNeedByDate = By.id("formSpot:fechaNecesidad_input");
	By clssMonthNeedByDate = By.xpath("//select[@class='ui-datepicker-month']");
	By selectMonthNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_MONTH_NEED_BY_DATE_SPOT_PAGE);
	By clssYearNeedByDate = By.xpath("//select[@class='ui-datepicker-year']");
	By selectYearNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_YEAR_NEED_BY_DATE_SPOT_PAGE);
	By selectDayNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_DAY_NEED_BY_DATE_SPOT_PAGE);
	// Check Urgent
	By chkUrgent = By.id("formSpot:checkUrgente");
	By lblReasonUrgent = By.id("formSpot:razonUrg_label");
	By slctReasonUrgent = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_REASON_URGENT_SPOT_PAGE);

	// Third Section Objects
	By txtCommentsToBuyer = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/div[1]/div[2]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]");
	By btnChooseFiles = By.id("formSpot:fileUpload_input");

	/*
	 * @name: textSpotBuyRequisitionsPageIsDisplayed
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtSpotBuyRequisitionsPage);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean textSpotBuyRequisitionsPageIsDisplayed() {
		reporterLog("Access to Spot Buy Requisitions Page ...");
		waitForElementPresent(spanSpotBuyRequisitionsPage);
		return isDisplayed(spanSpotBuyRequisitionsPage);
	}

	/*
	 * @name: captureInformationSpotBuyRequisitionFirstSection
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: String description, String material, String color, String Brand,
	 * String measurements, String modelPartNumber, String genericName
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite capturar los datos de la primera sección de
	 * la pagina
	 */
	public void captureInformationSpotBuyRequisitionFirstSection(String description, String material, String color,
			String brand, String measurements, String modelPartNumber, String genericName) {
		reporterLog("Capture Information to Spot Buy Requisitions First Section");
		type(txtDescription, description);
		type(txtMaterial, material);
		type(txtColor, color);
		type(txtBrand, brand);
		type(txtMeasurements, measurements);
		type(txtModelPartNumber, modelPartNumber);
		type(txtGenericName, genericName);
		requiredFields(txtDescription);
	}

	/*
	 * @name: captureInformationSpotBuyRequisitionsSecondSection
	 * 
	 * @date: 31/Oct/2023
	 * 
	 * @param: String quantity, String category, String family, String subFamily,
	 * String genericItem, String unitOfMeasure
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite capturar los datos de la segunda sección de
	 * la pagina
	 */
	public TreeMap<String, String> captureInformationSpotBuyRequisitionsSecondSection(String quantity, String category,
			String family, String subFamily, String genericItem, String unitOfMeasure) throws InterruptedException {

		reporterLog("Capture Information to Spot Buy Requisitions Second Section");

		if (isDisplayed(lblSubTittle)) {
			selectOptionCategory = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE);
			selectOptionFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE);
			selectOptionFamilyNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION__NEW_LINE_SPOT_PAGE);
			selectOptionSubFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE);
			selectOptionSubFamilyNewLine = By
					.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_NEW_LINE_SPOT_PAGE);
			slctReasonUrgent = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_REASON_URGENT_SPOT_PAGE_ENG);
		}

		// CATEGORY
		selectPrimefacesOption(lblCategory, txtSearchCategory, selectOptionCategory);
		waitForPrimefacesAjax();

		// FAMILY
		selectPrimefacesOption(lblFamily, txtSearchFamily, selectOptionFamily, selectOptionFamilyNewLine);
		waitForPrimefacesAjax();

		// SUB FAMILY
		selectPrimefacesOption(lblSubFamily, txtSearchSubFamily, selectOptionSubFamily, selectOptionSubFamilyNewLine);
		waitForPrimefacesAjax();

		// GENERIC ITEM
		type(txtGenericItem, genericItem);

		// QUANTITY
		type(txtQuantity, quantity);

		// UNIT OF MEASURE
		waitForElementClickable(lblUnitOfMeasure);
		click(lblUnitOfMeasure);
		click(lblUnitOfMeasure);
		waitForElementVisible(txtSearchUnitOfMeasure);
		type(txtSearchUnitOfMeasure, unitOfMeasure);

		waitForDropdownToLoad(selectOptionUnitOfMeasure);
		click(selectOptionUnitOfMeasure);
		waitForPrimefacesAjax();

		// NEED BY DATE
		waitForElementClickable(fieldNeedByDate);
		click(fieldNeedByDate);

		waitForElementClickable(clssMonthNeedByDate);
		click(clssMonthNeedByDate);

		waitForElementClickable(selectMonthNeedByDate);
		click(selectMonthNeedByDate);

		waitForElementClickable(clssYearNeedByDate);
		click(clssYearNeedByDate);

		waitForElementClickable(selectYearNeedByDate);
		click(selectYearNeedByDate);

		waitForElementClickable(selectDayNeedByDate);
		click(selectDayNeedByDate);
		waitForPrimefacesAjax();

		// REQUIRED FIELDS
		if (isElementPresent(selectOptionSubFamilyNewLine)) {
			requiredFields(txtSearchCategory);
			requiredFields(txtSearchFamily);
			requiredFields(txtSearchFamilyNewLine);
			requiredFields(txtSearchSubFamily);
			requiredFields(txtSearchSubFamilyNewLine);
			requiredFields(fieldNeedByDate);
			requiredFields(txtQuantity);
			requiredFields(txtSearchUnitOfMeasure);
		} else {
			requiredFields(txtSearchCategory);
			requiredFields(txtSearchFamily);
			requiredFields(txtSearchSubFamily);
			requiredFields(fieldNeedByDate);
			requiredFields(txtQuantity);
			requiredFields(txtSearchUnitOfMeasure);
		}

		return returnSaveImage(selectDayNeedByDate);
	}

	/*
	 * @name: captureInformationSpotBuyRequisitionsThirdSection
	 * 
	 * @date: 31/Oct/2023
	 * 
	 * @param: String commentsToBuyer, String pathFileSpot
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite capturar los datos de la tercera sección de
	 * la pagina
	 */
	public TreeMap<String, String> captureInformationSpotBuyRequisitionsThirdSection(String commentsToBuyer,
			String pathFileSpot) throws InterruptedException {
		reporterLog("Capture Information to Spot Buy Requisitions Third Section");
		type(txtCommentsToBuyer, GlobalVariablesSPX.SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE);
		uploadFile(pathFileSpot, btnChooseFiles);
		return returnSaveImage(btnChooseFiles);
	}

	/*
	 * @name: addtoCart
	 * 
	 * @date: 06/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite agregar la(s) línea(s)
	 */

	public TreeMap<String, String> addtoCart(String description, String material, String color, String brand,
			String measurements, String modelPartNumber, String genericName, String quantity, String category,
			String family, String subFamily, String unitOfMeasure) throws InterruptedException {

		click(btnAddToCart);
		waitForPrimefacesAjax();

		// ---- VALIDACIÓN: MISMA LÍNEA ----
		if (isDisplayed(textValidateSameLine)) {

			System.out.print("The error message is: ");
			getText(textValidateSameLine);

			String randomId = generateRandomId(8);
			type(txtDescription, " WITH ID: " + randomId);

			System.out.print("Create the requisition with the name: ");
			getText(txtDescription);
			System.out.println(randomId);

			click(btnAddToCart);
			waitForPrimefacesAjax();
		}

		// ---- VALIDACIÓN: CAMPOS VACÍOS ----
		else if (isDisplayed(textValidateFields)) {

			System.out.print("The error message is: ");
			getText(textValidateFields);

			// Llenado de datos básicos
			if (!isElementContainingText(txtDescription)) {
				type(txtDescription, description + " WITH ID: " + generateRandomId(8));
			}
			if (!isElementContainingText(txtMaterial)) {
				type(txtMaterial, material);
			}
			if (!isElementContainingText(txtColor)) {
				type(txtColor, color);
			}
			if (!isElementContainingText(txtBrand)) {
				type(txtBrand, brand);
			}
			if (!isElementContainingText(txtMeasurements)) {
				type(txtMeasurements, measurements);
			}
			if (!isElementContainingText(txtModelPartNumber)) {
				type(txtModelPartNumber, modelPartNumber);
			}
			if (!isElementContainingText(txtGenericName)) {
				type(txtGenericName, genericName);
			}

			// -------------------------------
			// Dropdowns: con o sin salto de línea
			// -------------------------------
			boolean hasSubFamilyNewLine = isElementPresent(selectOptionSubFamilyNewLine);

			// --- Categoría ---
			if (!isElementContainingText(txtSearchCategory)) {
				click(lblCategory);
				waitForElementPresent(txtSearchCategory);
				waitForElementPresent(selectOptionCategory);
				click(selectOptionCategory);
				waitForPrimefacesAjax();
			}

			// --- Familia (normal) ---
			if (!isElementContainingText(txtSearchFamily)) {
				waitForElementPresent(lblFamily);
				click(lblFamily);
				waitForElementPresent(selectOptionFamily);
				click(selectOptionFamily);
				waitForPrimefacesAjax();
			}

			// --- Familia (newline) ---
			if (hasSubFamilyNewLine && !isElementContainingText(txtSearchFamilyNewLine)) {
				waitForElementPresent(lblFamily);
				click(lblFamily);
				waitForElementPresent(selectOptionFamilyNewLine);
				click(selectOptionFamilyNewLine);
				waitForPrimefacesAjax();
			}

			// --- Subfamilia normal ---
			if (!isElementContainingText(txtSearchSubFamily)) {
				waitForElementPresent(lblSubFamily);
				click(lblSubFamily);
				waitForElementPresent(selectOptionSubFamily);
				click(selectOptionSubFamily);
				waitForPrimefacesAjax();
			}

			// --- Subfamilia newline ---
			if (hasSubFamilyNewLine && !isElementContainingText(txtSearchSubFamilyNewLine)) {
				waitForElementPresent(lblSubFamily);
				click(lblSubFamily);
				waitForElementPresent(selectOptionSubFamilyNewLine);
				click(selectOptionSubFamilyNewLine);
				waitForPrimefacesAjax();
			}

			// --- Fecha Need By Date ---
			if (!isElementContainingText(fieldNeedByDate)) {
				waitForElementPresent(fieldNeedByDate);
				click(fieldNeedByDate);

				waitForElementPresent(clssMonthNeedByDate);
				click(clssMonthNeedByDate);

				waitForElementPresent(selectMonthNeedByDate);
				click(selectMonthNeedByDate);

				waitForElementPresent(clssYearNeedByDate);
				click(clssYearNeedByDate);

				waitForElementPresent(selectYearNeedByDate);
				click(selectYearNeedByDate);

				click(selectDayNeedByDate);
				waitForPrimefacesAjax();
			}

			// --- Cantidad ---
			if (!isElementContainingText(txtQuantity)) {
				type(txtQuantity, quantity);
				waitForPrimefacesAjax();
			}

			// --- Unidad de medida ---
			if (!isElementContainingText(txtSearchUnitOfMeasure)) {
				waitForElementPresent(txtSearchUnitOfMeasure);
				type(txtSearchUnitOfMeasure, unitOfMeasure);
				waitForElementPresent(selectOptionUnitOfMeasure);
				click(selectOptionUnitOfMeasure);
				waitForPrimefacesAjax();
			}
		}

		// ---- CAMPOS COMPLETOS ----
		else {
			reporterLog("The Name Line is New and Correct Fields'");
		}

		return returnSaveImage(btnAddToCart);
	}

	/*
	 * @name: addNewLine
	 * 
	 * @date: 06/Nov/2023
	 * 
	 * @param:
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite agregar una nueva linea
	 */
	public TreeMap<String, String> addNewLine() throws InterruptedException {
		click(btnNewLine);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		System.out.println("New Line Add");
		return returnSaveImage(btnNewLine);
	}

	/*
	 * @name: addNewLine
	 * 
	 * @date: 06/Nov/2023
	 * 
	 * @param:
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite agregar una nueva linea
	 */
	public TreeMap<String, String> addFADToRequisition() throws InterruptedException {
		waitForElementPresent(chkIncludeSingleSourceFormat);
		click(chkIncludeSingleSourceFormat);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(chkIncludeSingleSourceFormat);
	}

	/*
	 * @name: addNewLine
	 * 
	 * @date: 06/Nov/2023
	 * 
	 * @param:
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite agregar una nueva linea
	 */
	public TreeMap<String, String> checkUrgent() throws InterruptedException {
		click(chkUrgent);
		waitForElementPresent(lblReasonUrgent);
		click(lblReasonUrgent);
		waitForElementPresent(slctReasonUrgent);
		click(slctReasonUrgent);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(slctReasonUrgent);
	}
}
