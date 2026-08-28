package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class SolicitudNuevoArticuloAlmacenSPXPage extends SPXBase {

	public SolicitudNuevoArticuloAlmacenSPXPage(WebDriver driver) {
		super(driver);
	}

	// =========================================================
	// OBJECTS -SOLICITUD NUEVO ARTICULO ALMACEN PAGE
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
	By btnBack = By.id("formSolicitudArticulo:j_idt341");
	By btnNewLine = By.id("formSolicitudArticulo:newLineButton");
	By btnSolicitar = By.id("formSolicitudArticulo:add-cart-btn");

	// =========================================================
	// ADDITIONAL HEADER PARAMETERS
	// =========================================================
	By chkProductServiceReceivedWithoutRequisition = By.id("");
	By chkIncludeSingleSourceFormat = By.id("");
	By txtValidateSameLine = By.xpath("");
	By txtValidateFields = By.xpath("");

	// =========================================================
	// LINE HEADER OBJECTS
	// =========================================================
	By chkLine = By.xpath(
			"//div[@id='header-for-each1']//div[contains(@id, 'formSolicitudArticulo')]//div[contains(@class, 'ui-chkbox-box')]");
	By btnExpandCollapse = By.xpath("(//button[contains(@onclick, 'togleLine')])[last()]");
	By btnDeleteLine = By.id("formSolicitudArticulo:j_idt350");

	// =========================================================
	// FIRST SECTION OBJECTS
	// =========================================================
	By optYesAsk = By.xpath(
			"(//table[contains(@class, 'radio-cuestionario')]//input[@value='true']/ancestor::div[contains(@class, 'ui-radiobutton')]//div[contains(@class, 'ui-radiobutton-box')])[1]");
	By optNoAsk = By.xpath(
			"(//table[contains(@class, 'radio-cuestionario')]//input[@value='false']/ancestor::div[contains(@class, 'ui-radiobutton')]//div[contains(@class, 'ui-radiobutton-box')])[1]");
	By btnNext = By.xpath("//button[contains(@id, 'btn_preg')]");
	By btnNextLast = By.xpath("//button[contains(@id, 'formSolicitudArticulo:for-each-cuestionario')]");
	By txtDescription = By.xpath("//textarea[contains(@id, 'formSolicitudArticulo:for-each-cuestionario:5:j_idt') "
			+ "or contains(@id, 'formSolicitudArticulo:for-each-cuestionario:10:j_idt') "
			+ "or contains(@id, 'formSolicitudArticulo:for-each-cuestionario:15:j_idt') "
			+ "or contains(@id, 'formSolicitudArticulo:for-each-cuestionario:11:j_idt')]");
	

	// =========================================================
	// SECTION LOCATION AND POSITION
	// =========================================================
	By lblUEN = By.id("formSolicitudArticulo:comboUens0_label");
	By txtSearchUEN = By.id("formSolicitudArticulo:comboUens0_filter");
	By pnlUEN = By.id("formSolicitudArticulo:comboUens0_panel");
	By optUEN = By.xpath("//div[@id='formSolicitudArticulo:comboUens0_panel']//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_NAME_UEN + "')]");

	By lblCostCenter = By.id("formSolicitudArticulo:comboCcs0_label");
	By txtSearchCostCenter = By.id("formSolicitudArticulo:comboCcs0_filter");
	By pnlCostCenter = By.id("formSolicitudArticulo:comboCcs0_panel");
	By optCostCenter = By.xpath("//div[@id='formSolicitudArticulo:comboCcs0_panel']//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_COST_CENTER_NEW_ITEM_PAGE + "')]");

	// =========================================================
	// DESCRIPTION AND SPECIFICATIONS
	// =========================================================
	By txtSuggestedCode = By.id("formSolicitudArticulo:txtCodigoSugerido0");
	By txtEquipmentMachineryTool = By.id("formSolicitudArticulo:txtEquipoMaquinariaHerramienta0");
	By txtMeasures = By.id("formSolicitudArticulo:txtMedida0");
	By txtArticle = By.id("formSolicitudArticulo:txtArticulo0");
	By txtBrand = By.id("formSolicitudArticulo:txtMarca0");
	By txtPhysicalAndChemical = By.id("formSolicitudArticulo:txtAtributo0");
	By txtReference = By.id("formSolicitudArticulo:txtReferencia0");
	By txtManufacturer = By.id("formSolicitudArticulo:txtManufacturer0");
	By txtPartNumber = By.id("formSolicitudArticulo:txtPartNumber0");

	// ---------------------------------------------------------
	// SECTION TITLE
	// ---------------------------------------------------------
	By lblTittlePage = By.xpath("//div[@class='spx-card-header__title']");

	// =========================================================
	// CATEGORY DROPDOWN
	// =========================================================
	By lblCategory = By.id("formSolicitudArticulo:nwcboCategorias0_label");
	By txtSearchCategory = By.id("formSolicitudArticulo:nwcboCategorias0_filter");
	By pnlCategory = By.id("formSolicitudArticulo:nwcboCategorias0_panel");
	By optCategory = By.xpath("//div[@id='formSolicitudArticulo:nwcboCategorias0_panel']//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_CATEGORY_SPOT_PAGE_ESP + "') or contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_CATEGORY_SPOT_PAGE_ENG + "') or contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_CATEGORY_SPOT_PAGE_PT + "')]");

	// =========================================================
	// FAMILY DROPDOWN
	// =========================================================
	By lblFamily = By.id("formSolicitudArticulo:nwcboFamilias0");
	By txtSearchFamily = By.id("formSolicitudArticulo:nwcboFamilias0_filter");
	By pnlFamily = By.id("formSolicitudArticulo:nwcboFamilias0_panel");
	By optFamily = By.xpath("//div[@id='formSolicitudArticulo:nwcboFamilias0_panel']//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_FAMILY_SPOT_PAGE_ESP + "') or contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_FAMILY_SPOT_PAGE_ENG + "') or contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_FAMILY_SPOT_PAGE_PT + "')]");

	// =========================================================
	// SUB FAMILY DROPDOWN
	// =========================================================
	By lblSubFamily = By.id("formSolicitudArticulo:nwcboSubFamilias0_label");
	By txtSearchSubFamily = By.id("formSolicitudArticulo:nwcboSubFamilias0_filter");
	By pnlSubFamily = By.id("formSolicitudArticulo:nwcboSubFamilias0_panel");
	By optSubFamily = By.xpath("//div[@id='formSolicitudArticulo:nwcboSubFamilias0_panel']//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP + "') or contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_SUBFAMILY_SPOT_PAGE_ENG + "') or contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_SUBFAMILY_SPOT_PAGE_PT + "')]");

	// =========================================================
	// UNIT OF MEASURE (UDM)
	// =========================================================
	By lblUnitOfMeasure = By.id("formSolicitudArticulo:comboUDM0_label");
	By txtSearchUnitOfMeasure = By.id("formSolicitudArticulo:comboUDM0_filter");
	By pnlUnitOfMeasure = By.id("formSolicitudArticulo:comboUDM0_panel");
	By optUnitOfMeasure = By
			.xpath("//div[@id='formSolicitudArticulo:comboUDM0_panel']//li[contains(@class,'ui-selectonemenu-item')]");

	// =========================================================
	// SECTION INSTRUCTIONS AND COMMENTS
	// =========================================================
	By lblRotation = By.id("formSolicitudArticulo:comborotacion0_label");
	By txtRotation = By.id("formSolicitudArticulo:comborotacion0_filter");
	By pnlRotation = By.id("formSolicitudArticulo:comborotacion0_panel");
	By optRotation = By.xpath(
			"//div[@id='formSolicitudArticulo:comborotacion0_panel']//li[contains(@class,'ui-selectonemenu-item')]");
	By txtPurchaseSpotID = By.id("formSolicitudArticulo:j_idt439");
	By txtComments = By.id("formSolicitudArticulo:j_idt441");
	By txtEstimated = By.id("formSolicitudArticulo:j_idt433");
	By txtSuggestedMin = By.id("formSolicitudArticulo:j_idt435");
	By txtSuggestedMax = By.id("formSolicitudArticulo:j_idt437");
	By btnChooseFiles = By.id("formSolicitudArticulo:fileUpload_input");

	// =========================================================
	// SECTION REQUEST
	// =========================================================
	By btnRequest = By.id("formSolicitudArticulo:add-cart-btn");
	By btnAccept = By.id("formSolicitudArticulo:btnCreaSolicitud");
	By lblRequisition = By
			.xpath("//div[contains(@class,'col-md-2')]//label[contains(@id,'formSolicitudArticulo:j_idt') and @style]");

	/*
	 * @name: textSolicitudNuevoArticuloAlmacenPageIsDisplayed
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Verifica que la pantalla de Solicitud de Nuevo Articulo de
	 * Almacen este desplegada correctamente mediante la confirmacion de visibilidad
	 * de su titulo principal.
	 */
	public boolean textSolicitudNuevoArticuloAlmacenPageIsDisplayed() {
		reporterLog("Access to Spot Buy Requisitions Page ...");
		waitForElementPresent(lblTittlePage);
		return isDisplayed(lblTittlePage);
	}

	/*
	 * @name: captureInformationRequestNewArticleItemFirstSection
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String description_NewItem
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Completa el cuestionario dinámico inicial seleccionando de
	 * forma aleatoria una de las 6 rutas válidas que conducen al cuadro de texto,
	 * ingresa la descripción del nuevo artículo y retorna la evidencia visual.
	 */
	public TreeMap<String, String> captureInformationRequestNewArticleItemFirstSection(String description_NewItem) {
		reporterLog("Capture Information to Spot Buy Requisitions First Section");
		TreeMap<String, String> evidence = returnSaveImage(btnNextLast);

		int option = new java.util.Random().nextInt(6) + 1;

		switch (option) {
		case 1:
			// Ruta 1: SI -> NO -> NO -> SI
			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();
			break;

		case 2:
			// Ruta 2: SI -> NO -> NO -> NO -> NO -> SI -> SI
			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();
			break;

		case 3:
			// Ruta 3: SI -> NO -> NO -> NO -> NO -> SI -> NO -> SI -> SI
			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();
			break;

		case 4:
			// Ruta 4: SI -> NO -> NO -> NO -> NO -> SI -> NO -> NO -> NO
			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();
			break;

		case 5:
			// Ruta 5: SI -> NO -> NO -> NO -> NO -> NO -> SI -> NO
			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();
			break;

		case 6:
			// Ruta 6: SI -> NO -> NO -> NO -> NO -> NO -> NO -> SI
			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optNoAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();

			click(optYesAsk);
			waitForPrimefacesAjax();
			click(btnNext);
			waitForPrimefacesAjax();
			break;
		}

		// Paso final común para todas las rutas válidas (Llegada al Cuadro de Texto)
		type(txtDescription, description_NewItem);
		waitForPrimefacesAjax();
		click(btnNextLast);
		waitForPrimefacesAjax();

		return evidence;
	}

	/*
	 * @name: captureInformationRequestNewArticleItemLocationAndPosition
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Selecciona los datos correspondientes a la ubicacion y posicion
	 * presupuestal (UEN y Centro de Costos) en el formulario y retorna la evidencia
	 * recopilada.
	 */
	public TreeMap<String, String> captureInformationRequestNewArticleItemLocationAndPosition() {
		reporterLog("Capture Information to Location and Position");
		TreeMap<String, String> evidence = returnSaveImage(lblCostCenter);
		click(lblUEN);
		waitForPrimefacesAjax();
		click(txtSearchUEN);
		waitForPrimefacesAjax();
		click(optUEN);
		waitForPrimefacesAjax();

		click(lblCostCenter);
		waitForPrimefacesAjax();
		click(txtSearchCostCenter);
		waitForPrimefacesAjax();
		click(optCostCenter);
		waitForPrimefacesAjax();

		return evidence;
	}

	/*
	 * @name: captureInformationRequestNewArticleItemDescriptionAndSpecifications
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String SuggestedCode, String EquipmentMachineryTool, String Measures,
	 * String Article, String Brand, String PhysicalAndChemical, String Reference,
	 * String Manufacturer, String PartNumber
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Captura los detalles tecnicos y especificaciones detalladas del
	 * articulo (codigo sugerido, equipo, medidas, marca, referencia, fabricante,
	 * etc.) retornando la evidencia visual generada.
	 */
	public TreeMap<String, String> captureInformationRequestNewArticleItemDescriptionAndSpecifications(
			String SuggestedCode, String EquipmentMachineryTool, String Measures, String Article, String Brand,
			String PhysicalAndChemical, String Reference, String Manufacturer, String PartNumber) {
		reporterLog("Capture Information to Description and Specifications");
		TreeMap<String, String> evidence = returnSaveImage(txtPartNumber);
		type(txtSuggestedCode, SuggestedCode);
		waitForPrimefacesAjax();
		type(txtEquipmentMachineryTool, EquipmentMachineryTool);
		waitForPrimefacesAjax();
		type(txtMeasures, Measures);
		waitForPrimefacesAjax();
		type(txtArticle, Article);
		waitForPrimefacesAjax();
		type(txtBrand, Brand);
		waitForPrimefacesAjax();
		type(txtPhysicalAndChemical, PhysicalAndChemical);
		waitForPrimefacesAjax();
		type(txtReference, Reference);
		waitForPrimefacesAjax();
		type(txtManufacturer, Manufacturer);
		waitForPrimefacesAjax();
		type(txtPartNumber, PartNumber);
		waitForPrimefacesAjax();
		return evidence;
	}

	/*
	 * @name: captureInformationRequestNewArticleItemRaiting
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Realiza la clasificacion del articulo seleccionando Categoria,
	 * Familia, Subfamilia y una Unidad de Medida aleatoria en los desplegables de
	 * PrimeFaces, retornando la evidencia recopilada.
	 */
	public TreeMap<String, String> captureInformationRequestNewArticleItemRaiting() {
		reporterLog("Capture Information to Description and Specifications");
		TreeMap<String, String> evidence = returnSaveImage(optUnitOfMeasure);
		selectPrimefacesOption(lblCategory, txtSearchCategory, optCategory);
		waitForPrimefacesAjax();
		selectPrimefacesOption(lblFamily, txtSearchFamily, optFamily);
		waitForPrimefacesAjax();
		selectPrimefacesOption(lblSubFamily, txtSearchSubFamily, optSubFamily);
		waitForPrimefacesAjax();
		selectRandomPrimefacesOption(lblUnitOfMeasure, pnlUnitOfMeasure, optUnitOfMeasure, "Unit of Measure");
		waitForPrimefacesAjax();
		return evidence;
	}

	/*
	 * @name: captureInformationRequestNewArticleItemInstructionsAndComments
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String purchasesSpotID, String comments, String estimated, String
	 * suggestedMin, String suggestedMax, String pathFileSpot
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Captura las instrucciones, rotacion, montos/cantidades
	 * estimadas, comentarios y realiza la carga de un archivo adjunto de soporte,
	 * retornando la evidencia visual del proceso.
	 */
	public TreeMap<String, String> captureInformationRequestNewArticleItemInstructionsAndComments(
			String purchasesSpotID, String comments, String estimated, String suggestedMin, String suggestedMax,
			String pathFileSpot) {
		reporterLog("Capture Information to Instructions and Comments");
		TreeMap<String, String> evidence = returnSaveImage(btnChooseFiles);
		selectRandomPrimefacesOption(lblRotation, pnlRotation, optRotation, "Rotation");
		waitForPrimefacesAjax();
		type(txtPurchaseSpotID, purchasesSpotID);
		waitForPrimefacesAjax();
		type(txtComments, comments);
		waitForPrimefacesAjax();
		type(txtEstimated, estimated);
		waitForPrimefacesAjax();
		type(txtSuggestedMin, suggestedMin);
		waitForPrimefacesAjax();
		type(txtSuggestedMax, suggestedMax);
		waitForPrimefacesAjax();
		uploadFile(pathFileSpot, btnChooseFiles);
		waitForPrimefacesAjax();
		return evidence;
	}

	/*
	 * @name: requestNewItem
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ejecuta la solicitud final de creacion del nuevo articulo,
	 * confirma los dialogos de confirmacion, obtiene y reporta el ID de requisicion
	 * generado y retorna la evidencia de confirmacion.
	 */
	public TreeMap<String, String> requestNewItem() {
		reporterLog("Request");
		click(btnRequest);
		waitForPrimefacesAjax();
		click(btnAccept);
		waitForPrimefacesAjax();
		waitForElementPresent(lblRequisition);
		TreeMap<String, String> evidence = returnSaveImage(lblRequisition);
		String requisitionID = getText(lblRequisition);
		reporterLog("Requisition generated with ID: " + requisitionID);
		return evidence;
	}
}
