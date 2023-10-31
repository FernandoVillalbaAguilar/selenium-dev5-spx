package com.metalsa.spx.dev5.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class SpotBuyRequisitionsPage extends SPXBase {

	public SpotBuyRequisitionsPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By spanSpotBuyRequisitionsPage = By.xpath("//span[@class='spx-card-header__title']");
	By txtDescription = By.id("formSpot:desc_1");
	By txtMaterial = By.id("formSpot:j_idt388");
	By txtColor = By.id("formSpot:j_idt392");
	By txtBrand = By.id("formSpot:j_idt396");
	By txtMeasurements = By.id("formSpot:j_idt400");
	By txtModelPartNumber = By.id("formSpot:j_idt404");
	By txtGenericName = By.id("formSpot:j_idt408");
	By lblCategory = By.id("formSpot:nwcboCategorias0_label");
	By txtSearchCategory = By.id("formSpot:nwcboCategorias0_filter");
	By selectOptionCategory = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE);
	By lblFamily = By.id("formSpot:nwcboFamilias0_label");
	By txtSearchFamily = By.id("formSpot:nwcboFamilias0_filter");
	By selectOptionFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE);
	By lblSubFamily = By.id("formSpot:nwcboSubFamilias0_label");
	By txtSearchSubFamily = By.id("formSpot:nwcboSubFamilias0_filter");
	By selectOptionSubFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE);
	By txtGenericItem = By.id("formSpot:j_idt464");
	By txtQuantity = By.id("formSpot:cantidadReq_input");
	By lblUnitOfMeasure = By.id("formSpot:comboUDM_label");
	By txtSearchUnitOfMeasure = By.id("formSpot:comboUDM_filter");
	By selectOptionUnitOfMeasure = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_UNIT_OF_MEASURE_OPTION_SPOT_PAGE);
	By fieldNeedByDate = By.id("formSpot:fechaNecesidad_input");
	By clssMonthNeedByDate = By.xpath("//select[@class='ui-datepicker-month']");
	By selectMonthNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_MONTH_NEED_BY_DATE_SPOT_PAGE);
	By clssYearNeedByDate = By.xpath("//select[@class='ui-datepicker-year']");
	By selectYearNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_YEAR_NEED_BY_DATE_SPOT_PAGE);
	By selectDayNeedByDate = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_DAY_NEED_BY_DATE_SPOT_PAGE);
	By txtCommentsToBuyer = By.id("formSpot:j_idt483");
	By btnChooseFiles = By.id("formSpot:fileUpload_input");
	By btnAddToCart=By.id("formSpot:add-cart-btn");

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
		try {
			reporterLog("Access to Spot Buy Requisitions Page ...");
			waitForElementPresent(spanSpotBuyRequisitionsPage);
			return isDisplayed(spanSpotBuyRequisitionsPage);
		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;

		}
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
			String Brand, String measurements, String modelPartNumber, String genericName) {
		try {
			reporterLog("Capture Information to Spot Buy Requisitions First Section");
			type(txtDescription, description);
			type(txtMaterial, material);
			type(txtColor, color);
			type(txtBrand, Brand);
			type(txtMeasurements, measurements);
			type(txtModelPartNumber, modelPartNumber);
			type(txtGenericName, genericName);

		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @name: captureInformationSpotBuyRequisitionsSecondSection
	 * 
	 * @date: 31/Oct/2023
	 * 
	 * @param: String cantidad, String category, String family, String subFamily,
	 * String itemGenerico, String unidadMedida
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite capturar los datos de la segunda sección de
	 * la pagina
	 */
	public void captureInformationSpotBuyRequisitionsSecondSection(String quantity, String category, String family,
			String subFamily, String genericItem, String unitOfMeasure) throws InterruptedException {
		try {
			reporterLog("Capture Information to Spot Buy Requisitions Second Section");
			click(lblCategory);
			waitForElementPresent(txtSearchCategory);
			type(txtSearchCategory, category);
			waitForElementPresent(selectOptionCategory);
			click(selectOptionCategory);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

			waitForElementPresent(lblFamily);
			click(lblFamily);
			waitForElementPresent(txtSearchFamily);
			type(txtSearchFamily, family);
			waitForElementPresent(selectOptionFamily);
			click(selectOptionFamily);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

			waitForElementPresent(lblSubFamily);
			click(lblSubFamily);
			waitForElementPresent(txtSearchSubFamily);
			type(txtSearchSubFamily, subFamily);
			waitForElementPresent(selectOptionSubFamily);
			click(selectOptionSubFamily);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

			type(txtGenericItem, genericItem);
			type(txtQuantity, quantity);

			click(lblUnitOfMeasure);
			// Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			click(lblUnitOfMeasure);

			waitForElementPresent(txtSearchUnitOfMeasure);
			type(txtSearchUnitOfMeasure, unitOfMeasure);
			waitForElementPresent(selectOptionUnitOfMeasure);
			click(selectOptionUnitOfMeasure);

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

		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @name: captureInformationSpotBuyRequisitionsThirdSection
	 * 
	 * @date: 31/Oct/2023
	 * 
	 * @param: String cantidad, String category, String family, String subFamily,
	 * String itemGenerico, String unidadMedida
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite capturar los datos de la tercera sección de
	 * la pagina
	 */
	public void captureInformationSpotBuyRequisitionsThirdSection(String commentsToBuyer, String pathFileSpot) throws InterruptedException {
		try {
			type(txtCommentsToBuyer, commentsToBuyer);
			uploadFile(pathFileSpot, btnChooseFiles);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			click(btnAddToCart);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}
}
