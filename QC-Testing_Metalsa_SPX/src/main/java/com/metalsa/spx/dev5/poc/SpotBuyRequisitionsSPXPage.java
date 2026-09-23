package com.metalsa.spx.dev5.poc;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class SpotBuyRequisitionsSPXPage extends SPXBase {

	public SpotBuyRequisitionsSPXPage(WebDriver driver) {
		super(driver);
	}

	// =========================================================
	// OBJECTS - SPOT BUY REQUISITIONS PAGE
	// =========================================================
	// @author: Fernando Villalba Aguilar
	// @description:
	// Locators organizados por secciones funcionales.
	//
	// Convenciones:
	// - btn -> Buttons
	// - lbl -> Labels / Selected dropdown labels
	// - txt -> Inputs / Filters
	// - chk -> Checkboxes
	// - pnl -> Panels
	// - opt -> Options
	// - slct -> Selectors
	//
	// PrimeFaces:
	// - *_label -> Valor seleccionado REAL del dropdown
	// - *_filter -> Input filtro interno del dropdown
	// - *_panel -> Panel desplegable
	// =========================================================

	// =========================================================
	// HEADER OBJECTS
	// =========================================================
	By btnBack = By.id("formSpot:j_idt327");
	By spanSpotBuyRequisitionsPage = By.xpath("//span[@class='spx-card-header__title']");
	By btnBulkLoad = By.id("formSpot:nwbtnCargaMasivaSpot");
	By btnNewLine = By.id("formSpot:newLineButton");
	By btnAddToCart = By.id("formSpot:add-cart-btn");

	// =========================================================
	// GLOBAL SOURCING RFQ
	// =========================================================
	By lblGlobalSourcingRFQ = By.id("formSpot:listrfspxview_label");
	By txtSearchGlobalSourcingRFQ = By.id("formSpot:listrfspxview_filter");
	By pnlGlobalSourcingRFQ = By.id("formSpot:listrfspxview_panel");
	By optGlobalSourcingRFQ = By.xpath("");

	// =========================================================
	// ADDITIONAL HEADER PARAMETERS
	// =========================================================
	By chkProductServiceReceivedWithoutRequisition = By.id("formSpot:servicioMaterialRealizado");
	By chkIncludeSingleSourceFormat = By.id("formSpot:formatoAsignacionDirecta");
	By txtValidateSameLine = By.xpath("//div[@id='mesageErrorNew']");
	By txtValidateFields = By.xpath("//div[@id='mesageError']//p");

	// =========================================================
	// LINE HEADER OBJECTS
	// =========================================================
	By chkLine = By.id("formSpot:j_idt371");
	By btnExpandCollapse = By.id("formSpot:j_idt375");
	By btnDeleteLine = By.id("formSpot:j_idt373");

	// =========================================================
	// FIRST SECTION OBJECTS
	// =========================================================
	By txtDescription = By.id("formSpot:desc_1");
	By txtMaterial = By.xpath("//span//div[@class='ui-grid-row']//div[1]//div[1]//div[2]//input[1]");
	By txtColor = By.xpath("//span//div[@class='ui-grid-row']//div[1]//div[2]//div[2]//input[1]");
	By txtBrand = By.xpath("//div[@class='ui-grid-row']//div[1]//div[3]//div[2]//input[1]");
	By txtMeasurements = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/fieldset[1]/div[1]/div[2]/div[2]/div[1]/div[2]/input[1]");
	By txtModelPartNumber = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/fieldset[1]/div[1]/div[2]/div[2]/div[2]/div[2]/input[1]");
	By txtGenericName = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/fieldset[1]/div[1]/div[2]/div[2]/div[3]/div[2]/input[1]");

	// =========================================================
	// SECOND SECTION OBJECTS
	// =========================================================

	// ---------------------------------------------------------
	// SECTION TITLE
	// ---------------------------------------------------------
	By lblSubTitle = By.xpath("//label[" + "contains(normalize-space(.), 'Classification, Quantity & Date') "
			+ "or contains(normalize-space(.), 'Clasificación, Cantidad & Fecha') "
			+ "or contains(normalize-space(.), 'Classificação, Quantidade e Data')" + "]");

	// =========================================================
	// CATEGORY DROPDOWN
	// =========================================================
	By lblCategory = By.id("formSpot:nwcboCategorias0_label");
	By txtSearchCategory = By.id("formSpot:nwcboCategorias0_filter");
	By pnlCategory = By.id("formSpot:nwcboCategorias0_panel");
	By optCategory = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE);

	// =========================================================
	// FAMILY DROPDOWN
	// =========================================================
	By lblFamily = By.id("formSpot:nwcboFamilias0_label");
	By txtSearchFamily = By.id("formSpot:nwcboFamilias0_filter");
	By pnlFamily = By.id("formSpot:nwcboFamilias0_panel");
	By optFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE);

	// =========================================================
	// FAMILY DROPDOWN - NEW LINE
	// =========================================================
	By lblFamilyNewLine = By.id("formSpot:nwcboFamilias1_label");
	By txtSearchFamilyNewLine = By
			.xpath("//div[@id='formSpot:nwcboFamilias1_panel']//input[contains(@class,'ui-selectonemenu-filter')]");
	By pnlFamilyNewLine = By.id("formSpot:nwcboFamilias1_panel");
	By optFamilyNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION_NEW_LINE_SPOT_PAGE);

	// =========================================================
	// SUB FAMILY DROPDOWN
	// =========================================================
	By lblSubFamily = By.id("formSpot:nwcboSubFamilias0_label");
	By txtSearchSubFamily = By.id("formSpot:nwcboSubFamilias0_filter");
	By pnlSubFamily = By.id("formSpot:nwcboSubFamilias0_panel");
	By optSubFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE);

	// =========================================================
	// SUB FAMILY DROPDOWN - NEW LINE
	// =========================================================
	By lblSubFamilyNewLine = By.id("formSpot:nwcboSubFamilias1_label");
	By txtSearchSubFamilyNewLine = By
			.xpath("//div[@id='formSpot:nwcboSubFamilias1_panel']//input[contains(@class,'ui-selectonemenu-filter')]");
	By pnlSubFamilyNewLine = By.id("formSpot:nwcboSubFamilias1_panel");
	By optSubFamilyNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_NEW_LINE_SPOT_PAGE);

	// =========================================================
	// GENERIC ITEM
	// =========================================================
	By txtGenericItem = By.xpath(
			"//div[@id='formSpot:nwcboItemGenerico0_panel']//input[@role='textbox' and contains(@class, 'ui-selectonemenu-filter')]");
	By lblGenericItemOsasco = By.id("formSpot:nwcboItemGenerico0_label");
	By optGenericItemOsasco = By.xpath(
			"//div[@id='formSpot:nwcboItemGenerico0_panel']//li[contains(@class,'ui-selectonemenu-item') and @data-label='"
					+ GlobalVariablesSPX.SPX_GENERIC_ITEM_SPOT_PAGE + "']");

	// =========================================================
	// QUANTITY
	// =========================================================
	By txtQuantity = By.id("formSpot:cantidadReq_input");

	// =========================================================
	// UNIT OF MEASURE (UDM)
	// =========================================================
	By lblUnitOfMeasure = By.id("formSpot:comboUDM0_label");
	By txtSearchUnitOfMeasure = By.id("formSpot:comboUDM0_filter");
	By pnlUnitOfMeasure = By.id("formSpot:comboUDM0_panel");
	By optUnitOfMeasure = By.xpath("");

	// =========================================================
	// LANGUAGE LABELS
	// =========================================================
	By lblCantidad = By.xpath("//label[contains(normalize-space(.),'Cantidad')]");
	By lblQuantity = By.xpath("//label[contains(normalize-space(.),'Quantity')]");
	By lblQuantidade = By.xpath("//label[contains(normalize-space(.),'Quantidade')]");

	// =========================================================
	// NEED BY DATE
	// =========================================================
	By fieldNeedByDate = By.id("formSpot:fechaNecesidad_input");
	By slctMonthNeedByDate = By.xpath("//select[@class='ui-datepicker-month']");
	By optMonthNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_MONTH_NEED_BY_DATE_SPOT_PAGE);
	By slctYearNeedByDate = By.xpath("//select[@class='ui-datepicker-year']");
	By optYearNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_YEAR_NEED_BY_DATE_SPOT_PAGE);
	By optDayNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_DAY_NEED_BY_DATE_SPOT_PAGE);

	// =========================================================
	// UEN
	// =========================================================
	By optUenSelectedOsasco = By
			.xpath("//label[contains(@id,'som_busquedaAvanzada_label') and normalize-space()='Metalsa Osasco']");

	// =========================================================
	// URGENT SECTION
	// =========================================================
	By chkUrgent = By.id("formSpot:checkUrgente");
	By lblReasonUrgent = By.id("formSpot:razonUrg_label");
//	By optReasonUrgent = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_REASON_URGENT_SPOT_PAGE);

	// =========================================================
	// THIRD SECTION OBJECTS
	// =========================================================
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
	 * @description: Este metodo permite verificar que el elemento est� disponible
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
	 * @description: Este metodo permite capturar los datos de la primera secci�n de
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
	 * String genericItem
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método captura la información de la segunda sección de
	 * Spot Buy Requisitions.
	 * 
	 * Mejoras incluidas: - Espera sincronizada con PrimeFaces AJAX. - Manejo del
	 * cambio de layout con o sin "New Line". - En cantidad, fuerza salida del foco
	 * con TAB para que el valor se procese. - Abre UDM con reintento si el panel no
	 * aparece al primer clic. - Validación final de campos obligatorios.
	 */
	public TreeMap<String, String> captureInformationSpotBuyRequisitionsSecondSection(String quantity, String category,
			String family, String subFamily, String genericItem) throws InterruptedException {
		reporterLog("Capture Information to Spot Buy Requisitions Second Section");
		/*
		 * Si la pantalla es la esperada, se reasignan los localizadores dinámicos. Esto
		 * ayuda cuando cambia el layout o el idioma.
		 */
		if (elementExistsAndVisible(lblSubTitle)) {
			optCategory = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE);
			optFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE);
			optFamilyNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION_NEW_LINE_SPOT_PAGE);
			optSubFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE);
			optSubFamilyNewLine = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_NEW_LINE_SPOT_PAGE);
//			optReasonUrgent = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_REASON_URGENT_SPOT_PAGE);
		}

		// =========================================================
		// CATEGORY
		// =========================================================
		selectPrimefacesOption(lblCategory, txtSearchCategory, optCategory);
		waitForPrimefacesAjax();

		// =========================================================
		// FAMILY / SUBFAMILY
		// Si existe el locador de "new line", usa esa variante.
		// =========================================================
		if (exists(optSubFamilyNewLine)) {
			selectPrimefacesOption(lblFamily, txtSearchFamilyNewLine, optFamilyNewLine);
			waitForPrimefacesAjax();
			selectPrimefacesOption(lblSubFamily, txtSearchSubFamilyNewLine, optSubFamilyNewLine);
			waitForPrimefacesAjax();
		} else {
			selectPrimefacesOption(lblFamily, txtSearchFamily, optFamily);
			waitForPrimefacesAjax();
			selectPrimefacesOption(lblSubFamily, txtSearchSubFamily, optSubFamily, optSubFamilyNewLine);
			waitForPrimefacesAjax();
		}

		// =========================================================
		// GENERIC ITEM
		// En Osasco se selecciona por opción fija; en otros casos se captura texto.
		// =========================================================
		if (isElementPresent(optUenSelectedOsasco)) {
			click(lblGenericItemOsasco);
			click(optGenericItemOsasco);
		} else {
			type(txtGenericItem, genericItem);
		}

		// =========================================================
		// QUANTITY
		// Después de escribir, se manda TAB para disparar blur/change.
		// Esto ayuda a que PrimeFaces procese el valor antes de seguir.
		// =========================================================
		type(txtQuantity, quantity);
		getElement(txtQuantity).sendKeys(Keys.TAB);
		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();

		// =========================================================
		// UNIT OF MEASURE
		// =========================================================
		waitForBlockUIToDisappear();
		click(lblUnitOfMeasure);
		waitForPrimefacesAjax();
		boolean udmPanelOpened = waitForElementVisible(pnlUnitOfMeasure, 5);
		if (!udmPanelOpened) {
			reporterLog("[WARNING] UDM panel did not open on first click. Retrying...");
			jsClick(lblUnitOfMeasure);
			waitForPrimefacesAjax();
			udmPanelOpened = waitForElementVisible(pnlUnitOfMeasure, 5);
		}
		if (!udmPanelOpened) {
			throw new RuntimeException("UDM panel could not be opened: " + pnlUnitOfMeasure);
		}

		selectRandomUnitOfMeasureExcludingFirst();

		// =========================================================
		// NEED BY DATE
		// =========================================================
		click(fieldNeedByDate);
		waitForPrimefacesAjax();
		click(slctMonthNeedByDate);
		click(optMonthNeedByDate);
		click(slctYearNeedByDate);
		click(optYearNeedByDate);
		click(optDayNeedByDate);
		waitForPrimefacesAjax();

		// =========================================================
		// REQUIRED FIELDS
		// Se validan solo los campos que realmente deben tener información.
		// =========================================================
		requiredFields(lblCategory);
		if (exists(lblFamilyNewLine)) {
			requiredFields(lblFamilyNewLine);
			requiredFields(lblSubFamilyNewLine);
		} else {
			requiredFields(lblFamily);
			requiredFields(lblSubFamily);
		}

		requiredFields(fieldNeedByDate);
		requiredFields(txtQuantity);
		requiredFields(lblUnitOfMeasure);
		return returnSaveImage(optDayNeedByDate);
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
	 * @description: Este metodo permite capturar los datos de la tercera secci�n de
	 * la pagina
	 */
	public TreeMap<String, String> captureInformationSpotBuyRequisitionsThirdSection(String commentsToBuyer,
			String pathFileSpot) throws InterruptedException {
		reporterLog("Capture Information to Spot Buy Requisitions Third Section");
		type(txtCommentsToBuyer, GlobalVariablesSPX.SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE);
		uploadFile(pathFileSpot, btnChooseFiles);
		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
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
	 * @description: Este metodo permite agregar la(s) l�nea(s)
	 */

	public TreeMap<String, String> addtoCart(String description, String material, String color, String brand,
			String measurements, String modelPartNumber, String genericName, String quantity, String category,
			String family, String subFamily) throws InterruptedException {

		reporterLog("Add Line To Cart");
		try {
			waitForElementClickable(btnAddToCart);
			click(btnAddToCart);
			waitForPrimefacesAjax();

			// =========================================================
			// VALIDACIÓN: MISMA INFORMACIÓN EN LA LÍNEA
			// =========================================================
			if (elementExistsAndVisible(txtValidateSameLine)) {
				System.out.println("\n=================================================");
				System.out.println("INFO: Validación de unicidad ejecutada.");
				System.out.println("Resultado: Se detectó una descripción previamente utilizada.");
				System.out.println("Acción automática: Generando una nueva descripción única.");
				String randomId = generateRandomId(8);
				String newDescription = description + " WITH ID: " + randomId;
				type(txtDescription, newDescription);
				waitForPrimefacesAjax();
				waitForBlockUIToDisappear();
				System.out.println("Nueva descripción: " + newDescription);
				System.out.println("=================================================\n");
				waitForElementClickable(btnAddToCart);
				click(btnAddToCart);
				waitForPrimefacesAjax();
			}

			// =========================================================
			// VALIDACIÓN: CAMPOS OBLIGATORIOS VACÍOS
			// =========================================================
			else if (elementExistsAndVisible(txtValidateFields)) {
				String errorMessage = getText(txtValidateFields);
				System.out.println("\n=================================================");
				System.out.println("VALIDATION: REQUIRED FIELDS");
				System.out.println("MESSAGE: " + errorMessage);
				System.out.println("=================================================\n");

				// =====================================================
				// FIRST SECTION
				// =====================================================

				if (!hasInputValue(txtDescription)) {
					String newDescription = description + " WITH ID: " + generateRandomId(8);
					type(txtDescription, newDescription);
					System.out.println("FIELD COMPLETED: DESCRIPTION");
				}
				if (!hasInputValue(txtMaterial)) {
					type(txtMaterial, material);
					System.out.println("FIELD COMPLETED: MATERIAL");
				}
				if (!hasInputValue(txtColor)) {
					type(txtColor, color);
					System.out.println("FIELD COMPLETED: COLOR");
				}
				if (!hasInputValue(txtBrand)) {
					type(txtBrand, brand);
					System.out.println("FIELD COMPLETED: BRAND");
				}
				if (!hasInputValue(txtMeasurements)) {
					type(txtMeasurements, measurements);
					System.out.println("FIELD COMPLETED: MEASUREMENTS");
				}
				if (!hasInputValue(txtModelPartNumber)) {
					type(txtModelPartNumber, modelPartNumber);
					System.out.println("FIELD COMPLETED: MODEL PART NUMBER");
				}
				if (!hasInputValue(txtGenericName)) {
					type(txtGenericName, genericName);
					System.out.println("FIELD COMPLETED: GENERIC NAME");
				}

				// =====================================================
				// SECOND SECTION
				// =====================================================

				boolean hasSubFamilyNewLine = exists(optSubFamilyNewLine);

				// CATEGORY
				if (!hasInputValue(txtSearchCategory)) {
					waitForElementClickable(lblCategory);
					click(lblCategory);
					waitForElementVisible(txtSearchCategory, 10);
					waitForElementVisible(optCategory, 10);
					click(optCategory);
					waitForPrimefacesAjax();
					System.out.println("FIELD COMPLETED: CATEGORY");
				}

				// FAMILY NORMAL
				if (isDropdownWithoutSelection(lblFamily)) {
					waitForElementClickable(lblFamily);
					click(lblFamily);
					waitForElementVisible(optFamily, 10);
					click(optFamily);
					waitForPrimefacesAjax();
					System.out.println("FIELD COMPLETED: FAMILY");
				}

				// FAMILY NEW LINE
				if (hasSubFamilyNewLine && isDropdownWithoutSelection(lblFamily)) {
					waitForElementClickable(lblFamily);
					click(lblFamily);
					waitForElementVisible(optFamilyNewLine, 10);
					click(optFamilyNewLine);
					waitForPrimefacesAjax();
					System.out.println("FIELD COMPLETED: FAMILY NEW LINE");
				}

				// SUB FAMILY NORMAL
				if (!hasInputValue(txtSearchSubFamily)) {
					waitForElementClickable(lblSubFamily);
					click(lblSubFamily);
					waitForElementVisible(optSubFamily, 10);
					click(optSubFamily);
					waitForPrimefacesAjax();
					System.out.println("FIELD COMPLETED: SUB FAMILY");
				}

				// SUB FAMILY NEW LINE
				if (hasSubFamilyNewLine && isDropdownWithoutSelection(lblSubFamily)) {
					waitForElementClickable(lblSubFamily);
					click(lblSubFamily);
					waitForElementVisible(optSubFamilyNewLine, 10);
					click(optSubFamilyNewLine);
					waitForPrimefacesAjax();
					System.out.println("FIELD COMPLETED: SUB FAMILY NEW LINE");
				}

				// NEED BY DATE
				if (!hasInputValue(fieldNeedByDate)) {
					waitForElementClickable(fieldNeedByDate);
					click(fieldNeedByDate);
					waitForElementClickable(slctMonthNeedByDate);
					click(slctMonthNeedByDate);
					waitForElementClickable(optMonthNeedByDate);
					click(optMonthNeedByDate);
					waitForElementClickable(slctYearNeedByDate);
					click(slctYearNeedByDate);
					waitForElementClickable(optYearNeedByDate);
					click(optYearNeedByDate);
					waitForElementClickable(optDayNeedByDate);
					click(optDayNeedByDate);
					waitForPrimefacesAjax();
					System.out.println("FIELD COMPLETED: NEED BY DATE");
				}

				// QUANTITY
				if (!hasInputValue(txtQuantity)) {
					type(txtQuantity, quantity);
					getElement(txtQuantity).sendKeys(Keys.TAB);
					waitForPrimefacesAjax();
					System.out.println("FIELD COMPLETED: QUANTITY");
				}

				// =====================================================
				// UNIT OF MEASURE
				// =====================================================

				if (!hasInputValue(txtSearchUnitOfMeasure)) {
					waitForElementClickable(lblUnitOfMeasure);
					waitForBlockUIToDisappear();
					click(lblUnitOfMeasure);
					boolean udmOpened = waitForElementVisible(pnlUnitOfMeasure, 5);

					if (!udmOpened) {
						reporterLog("[WARNING] UDM panel did not open with normal click, trying JS click...");
						jsClick(lblUnitOfMeasure);
						udmOpened = waitForElementVisible(pnlUnitOfMeasure, 5);
					}
					if (!udmOpened) {
						throw new RuntimeException("UDM panel could not be opened: " + pnlUnitOfMeasure);
					}

					selectRandomUnitOfMeasureExcludingFirst();
					System.out.println("FIELD COMPLETED: UNIT OF MEASURE");
				}

				// =====================================================
				// REINTENTO ADD TO CART
				// =====================================================

				waitForElementClickable(btnAddToCart);
				click(btnAddToCart);
				waitForPrimefacesAjax();
			}

			// =========================================================
			// SIN ERRORES
			// =========================================================
			else {
				reporterLog("The Line Was Added Successfully");
			}
		} catch (Exception e) {
			logFrameworkError("Unexpected error in addtoCart()", e);
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
		TreeMap<String, String> evidence = returnSaveImage(chkIncludeSingleSourceFormat);
		click(chkIncludeSingleSourceFormat);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return evidence;
	}

	/*
	 * @name: checkUrgent
	 * 
	 * @date: 06/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Marca la requisición como urgente y selecciona una razón de
	 * urgencia aleatoria, detectando el idioma de la página para usar el catálogo
	 * correcto (ES/EN/PT).
	 *
	 * Mejora: en lugar de confiar únicamente en document.documentElement.lang o
	 * navigator.language (que pueden no reflejar el idioma real renderizado por
	 * SPX), se valida contra las opciones REALMENTE presentes en el panel de
	 * razones — evitando el NoSuchElementException cuando el idioma detectado no
	 * coincide con el idioma mostrado.
	 */
	public TreeMap<String, String> checkUrgent() throws InterruptedException {

		click(chkUrgent);
		waitForElementPresent(lblReasonUrgent);
		click(lblReasonUrgent);

		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();

		By panelItems = By.xpath("//div[@id='formSpot:razonUrg_panel']//li[contains(@class,'ui-selectonemenu-item')]");

		waitForElementPresent(panelItems);

		// Leer las opciones REALMENTE presentes en el panel — fuente de verdad
		List<WebElement> availableOptions = driver.findElements(panelItems);

		List<String> availableLabels = availableOptions.stream().map(item -> item.getAttribute("data-label"))
				.filter(label -> label != null && !label.trim().isEmpty())
				.collect(java.util.stream.Collectors.toList());

		if (availableLabels.isEmpty()) {
			throw new AssertionError("No se encontraron razones de urgencia disponibles en el panel.");
		}

		reporterLog("[INFO] Razones de urgencia disponibles en el panel: " + availableLabels.size());

		// Determinar qué catálogo (ES/EN/PT) coincide con las opciones reales del panel
		String[] matchedCatalog = matchUrgencyCatalog(availableLabels);

		// Seleccionar razón aleatoria DENTRO de las opciones confirmadas en el panel
		List<String> validReasons = availableLabels.stream()
				.filter(label -> java.util.Arrays.stream(matchedCatalog)
						.anyMatch(reason -> reason.equalsIgnoreCase(label.trim())))
				.collect(java.util.stream.Collectors.toList());

		String selectedReason = (!validReasons.isEmpty()) ? validReasons.get(new Random().nextInt(validReasons.size()))
				: availableLabels.get(new Random().nextInt(availableLabels.size()));

		reporterLog("[INFO] Razón seleccionada: " + selectedReason);

		By optReasonUrgent = By.xpath(
				"//div[@id='formSpot:razonUrg_panel']//li[@data-label='" + selectedReason.replace("'", "\\'") + "']");

		waitForElementPresent(optReasonUrgent);
		click(optReasonUrgent);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		return returnSaveImage(optReasonUrgent);
	}

	/*
	 * @name: matchUrgencyCatalog
	 *
	 * @date: 17/Jun/2026
	 *
	 * @description: Determina cuál catálogo de razones de urgencia (ES/EN/PT)
	 * coincide con las opciones realmente mostradas en el panel, comparando cuántas
	 * etiquetas del panel existen en cada catálogo.
	 *
	 * Esto evita depender de document.documentElement.lang o navigator.language,
	 * que pueden no reflejar el idioma real en que SPX renderiza el contenido.
	 */
	private String[] matchUrgencyCatalog(List<String> availableLabels) {

		long matchES = availableLabels.stream().filter(label -> java.util.Arrays
				.stream(GlobalVariablesSPX.RAZON_URGENCIA).anyMatch(r -> r.equalsIgnoreCase(label.trim()))).count();

		long matchEN = availableLabels.stream().filter(label -> java.util.Arrays
				.stream(GlobalVariablesSPX.RAZON_URGENCIA_ENG).anyMatch(r -> r.equalsIgnoreCase(label.trim()))).count();

		long matchPT = availableLabels.stream().filter(label -> java.util.Arrays
				.stream(GlobalVariablesSPX.RAZON_URGENCIA_PT).anyMatch(r -> r.equalsIgnoreCase(label.trim()))).count();

		reporterLog("[INFO] Coincidencias por idioma — ES: " + matchES + " | EN: " + matchEN + " | PT: " + matchPT);

		if (matchES >= matchEN && matchES >= matchPT) {
			reporterLog("[INFO] Idioma detectado por contenido: ES");
			return GlobalVariablesSPX.RAZON_URGENCIA;
		} else if (matchEN >= matchPT) {
			reporterLog("[INFO] Idioma detectado por contenido: EN");
			return GlobalVariablesSPX.RAZON_URGENCIA_ENG;
		} else {
			reporterLog("[INFO] Idioma detectado por contenido: PT");
			return GlobalVariablesSPX.RAZON_URGENCIA_PT;
		}
	}

	/*
	 * @name: selectRandomUnitOfMeasureExcludingFirst
	 * 
	 * @description: Selecciona aleatoriamente cualquier opción del panel de Unit of
	 * Measure REALMENTE presente en el DOM, excluyendo la primera opción (índice
	 * 0). Evita depender del catálogo hardcodeado por idioma.
	 */
	private void selectRandomUnitOfMeasureExcludingFirst() throws InterruptedException {
		By panelItems = By.xpath("//div[@id='formSpot:comboUDM0_panel']//li[contains(@class,'ui-selectonemenu-item')]");

		waitForElementPresent(panelItems);
		List<WebElement> availableOptions = driver.findElements(panelItems);

		if (availableOptions.size() <= 1) {
			throw new AssertionError("No hay suficientes opciones de Unit of Measure (excluyendo la primera).");
		}

		// Excluye índice 0 (primera opción)
		int randomIndex = 1 + new Random().nextInt(availableOptions.size() - 1);
		String selectedLabel = availableOptions.get(randomIndex).getAttribute("data-label");

		reporterLog("[INFO] Unit of Measure seleccionada aleatoriamente: " + selectedLabel);

		By optSelected = By.xpath(
				"//div[@id='formSpot:comboUDM0_panel']//li[@data-label='" + selectedLabel.replace("'", "\\'") + "']");

		waitForElementPresent(optSelected);
		click(optSelected);
		waitForPrimefacesAjax();
	}
}
