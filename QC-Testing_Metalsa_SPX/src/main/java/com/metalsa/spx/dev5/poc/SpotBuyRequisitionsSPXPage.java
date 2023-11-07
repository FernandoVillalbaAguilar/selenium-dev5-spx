package com.metalsa.spx.dev5.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class SpotBuyRequisitionsSPXPage extends SPXBase {

	public SpotBuyRequisitionsSPXPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By spanSpotBuyRequisitionsPage = By.xpath("//span[@class='spx-card-header__title']");
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
	By lblCategory = By.id("formSpot:nwcboCategorias0_label");
	By txtSearchCategory = By.id("formSpot:nwcboCategorias0_filter");
	By selectOptionCategory = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE);
	By lblFamily = By.id("formSpot:nwcboFamilias0_label");
	By txtSearchFamily = By.id("formSpot:nwcboFamilias0_filter");
	By selectOptionFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE);
	By lblSubFamily = By.id("formSpot:nwcboSubFamilias0_label");
	By txtSearchSubFamily = By.id("formSpot:nwcboSubFamilias0_filter");
	By selectOptionSubFamily = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE);
	By txtGenericItem = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/div[1]/div[1]/fieldset[1]/div[1]/div[4]/div[1]/div[2]/input[1]");
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
	By txtCommentsToBuyer = By.xpath(
			"/html[1]/body[1]/div[3]/div[1]/span[2]/form[1]/div[4]/span[1]/div[2]/div[1]/div[2]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]");
	By btnChooseFiles = By.id("formSpot:fileUpload_input");
	By btnAddToCart = By.id("formSpot:add-cart-btn");
	By textValidateSameLine = By.xpath("//div[@class='ui-growl-message']");
	By btnNewLine=By.id("formSpot:newLineButton");

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
			String Brand, String measurements, String modelPartNumber, String genericName) {
		reporterLog("Capture Information to Spot Buy Requisitions First Section");
		type(txtDescription, description);
		type(txtMaterial, material);
		type(txtColor, color);
		type(txtBrand, Brand);
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
	public void captureInformationSpotBuyRequisitionsSecondSection(String quantity, String category, String family,
			String subFamily, String genericItem, String unitOfMeasure) throws InterruptedException {
		reporterLog("Capture Information to Spot Buy Requisitions Second Section");
		// Category
		click(lblCategory);
		waitForElementPresent(txtSearchCategory);
//		type(txtSearchCategory, category);
		waitForElementPresent(selectOptionCategory);
		click(selectOptionCategory);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		// Family
		waitForElementPresent(lblFamily);
		click(lblFamily);
//		waitForElementPresent(txtSearchFamily);
//		type(txtSearchFamily, family);
		waitForElementPresent(selectOptionFamily);
		click(selectOptionFamily);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		// SubFamily
		waitForElementPresent(lblSubFamily);
		click(lblSubFamily);
//		waitForElementPresent(txtSearchSubFamily);
//		type(txtSearchSubFamily, subFamily);
		waitForElementPresent(selectOptionSubFamily);
		click(selectOptionSubFamily);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);

		// Rest Fields
		type(txtGenericItem, genericItem);
		type(txtQuantity, quantity);

		click(lblUnitOfMeasure);
		click(lblUnitOfMeasure);
		waitForElementPresent(txtSearchUnitOfMeasure);
		type(txtSearchUnitOfMeasure, unitOfMeasure);
		waitForElementPresent(selectOptionUnitOfMeasure);
		click(selectOptionUnitOfMeasure);

		// Need By Date
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

		// Required Fields Validate
		requiredFields(txtSearchCategory);
		requiredFields(txtSearchFamily);
		requiredFields(txtSearchSubFamily);
		requiredFields(txtQuantity);
		requiredFields(txtSearchUnitOfMeasure);
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
	public void captureInformationSpotBuyRequisitionsThirdSection(String commentsToBuyer, String pathFileSpot)
			throws InterruptedException {
		reporterLog("Capture Information to Spot Buy Requisitions Third Section");
		type(txtCommentsToBuyer, commentsToBuyer);
		uploadFile(pathFileSpot, btnChooseFiles);
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
	public void addtoCart() throws InterruptedException {
		click(btnAddToCart);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		if (isDisplayed(textValidateSameLine)) {
			System.out.print("The error message is: ");
			getText(textValidateSameLine);
			String randomId = generateRandomId();
			type(txtDescription, " WITH ID: " + randomId);
			System.out.print("The name of requisition is ");
			getText(txtDescription);
			System.out.println("WITH ID: " + randomId);
			click(btnAddToCart);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		} else {
			reporterLog("The Name Line is New");
		}
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
	public void addNewLine() {
		click(btnNewLine);
		System.out.println("New Line");
	}
}
