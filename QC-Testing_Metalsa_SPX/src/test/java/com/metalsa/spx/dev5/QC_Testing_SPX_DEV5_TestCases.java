package com.metalsa.spx.dev5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;
import com.metalsa.spx.dev5.poc.AccountConfigurationSPXPage;
import com.metalsa.spx.dev5.poc.HomeSPX;
import com.metalsa.spx.dev5.poc.LoginSPX;
import com.metalsa.spx.dev5.poc.PreviewConfirmationSPXPage;
import com.metalsa.spx.dev5.poc.ShoppingCartSPXPage;
import com.metalsa.spx.dev5.poc.SpotBuyRequisitionsSPXPage;

public class QC_Testing_SPX_DEV5_TestCases {
	WebDriver driver;
	SPXBase spxBase;
	LoginSPX loginSPXPage;
	HomeSPX homeSPXPage;
	SpotBuyRequisitionsSPXPage spotBuyRequisitionsSPXPage;
	ShoppingCartSPXPage shoppingCartSPXPage;
	AccountConfigurationSPXPage accountConfigurationSPXPage;
	PreviewConfirmationSPXPage previewConfirmationSPXPage;

	// TestDataCalling
	String url, username, password, description = GlobalVariablesSPX.SPX_DEV5_DESCRIPTION_SPOT_PAGE,
			material = GlobalVariablesSPX.SPX_DEV5_MATERIAL_SPOT_PAGE,
			color = GlobalVariablesSPX.SPX_DEV5_COLOR_SPOT_PAGE, brand = GlobalVariablesSPX.SPX_DEV5_BRAND_SPOT_PAGE,
			measurements = GlobalVariablesSPX.SPX_DEV5_MEASUREMENTS_SPOT_PAGE,
			modelPartNumber = GlobalVariablesSPX.SPX_DEV5_MODELPARTNUMBER_SPOT_PAGE,
			genericName = GlobalVariablesSPX.SPX_DEV5_GENERICNAME_SPOT_PAGE,
			category = GlobalVariablesSPX.SPX_DEV5_CATEGORY_SPOT_PAGE,
			family = GlobalVariablesSPX.SPX_DEV5_FAMILY_SPOT_PAGE,
			subFamily = GlobalVariablesSPX.SPX_DEV5_SUBFAMILY_SPOT_PAGE,
			quantity = GlobalVariablesSPX.SPX_DEV5_QUANTITY_SPOT_PAGE,
			genericItem = GlobalVariablesSPX.SPX_DEV5_GENERIC_ITEM_SPOT_PAGE,
			unitOfMeasure = GlobalVariablesSPX.SPX_DEV5_UNIT_OF_MEASURE_SPOT_PAGE,
			commentsToBuyer = GlobalVariablesSPX.SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE,
			pathFileSpot = GlobalVariablesSPX.SPX_DEV5_PATH_FILES,
			commentsShoppingCart = GlobalVariablesSPX.SPX_DEV5_COMMENTS_SHOPPING_CART,
			costCenter = GlobalVariablesSPX.SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE;

	@BeforeTest
	public void beforeTest() {
		// Instanciar valores de conexión con Chrome
		spxBase = new SPXBase(driver);
		driver = spxBase.chromeDriverConection();
		loginSPXPage = new LoginSPX(driver);
		homeSPXPage = new HomeSPX(driver);
		spotBuyRequisitionsSPXPage = new SpotBuyRequisitionsSPXPage(driver);
		shoppingCartSPXPage = new ShoppingCartSPXPage(driver);
		accountConfigurationSPXPage = new AccountConfigurationSPXPage(driver);
		previewConfirmationSPXPage = new PreviewConfirmationSPXPage(driver);

		// Test Data
		this.username = spxBase.getJSONValue("TestDataLoginSPX", "username");
		this.password = spxBase.getJSONValue("TestDataLoginSPX", "password");
		this.url = spxBase.getJSONValue("TestDataLoginSPX", "url");
	}

	@Test
	public void tc001QCTestingSPXDev5CrearRequisicionSpotTipoCobroCC() throws InterruptedException {
		// Step 1 - Launch Browser
		spxBase.launchBrowser(url);

		// Step 2 - Enter username and password and click to button "Enter"
		loginSPXPage.login(username, password);

		// Step 4 - Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Step 5 - Select to UEN
		homeSPXPage.selectToUenFromHome();

		// Step 6 - Access to Spot Buy Requisitions
		homeSPXPage.accesToSpotBuyRequisitions();
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity, category, family,
				subFamily, genericItem, unitOfMeasure);
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot);
		spotBuyRequisitionsSPXPage.addtoCart();

		// Step 8 - Select to Requisition
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		shoppingCartSPXPage.CheckSpotRequisitionShoppingCart();
		shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart();

		// Step 9 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		accountConfigurationSPXPage.selectTypeAccountForRequisition(costCenter);

		// Step 10 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage();
	}

	@Test
	public void tc002QCTestingSPXDev5CrearNuevaLineasRequisicionSpotTipoCobroCC() throws InterruptedException {
		// Step 1 - Launch Browser
		spxBase.launchBrowser(url);

		// Step 2 - Enter user name and password and click to button "Enter"
		loginSPXPage.login(username, password);

		// Step 4 - Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Step 5 - Select to UEN
		homeSPXPage.selectToUenFromHome();

		// Step 6 - Access to Spot Buy Requisitions
		homeSPXPage.accesToSpotBuyRequisitions();
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity, category, family,
				subFamily, genericItem, unitOfMeasure);
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot);

		// Step 8 - Add new line and data capture second line
		spotBuyRequisitionsSPXPage.addNewLine();
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity, category, family,
				subFamily, genericItem, unitOfMeasure);
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot);
		spotBuyRequisitionsSPXPage.addtoCart();

		// Step 9 - Select to Requisition
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		shoppingCartSPXPage.DoubleCheckSpotRequisitionShoppingCart();
		shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart();

		// Step 10 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		accountConfigurationSPXPage.selectTypeAccountForRequisition(costCenter);

		// Step 11 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage();
	}
	
	@Test
	public void tc003QCTestingSPXDev5CrearRequisicionSpotConFADTipoCobroCC() throws InterruptedException {
		// Step 1 - Launch Browser
		spxBase.launchBrowser(url);

		// Step 2 - Enter username and password and click to button "Enter"
		loginSPXPage.login(username, password);

		// Step 4 - Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Step 5 - Select to UEN
		homeSPXPage.selectToUenFromHome();

		// Step 6 - Access to Spot Buy Requisitions
		homeSPXPage.accesToSpotBuyRequisitions();
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity, category, family,
				subFamily, genericItem, unitOfMeasure);
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot);
		spotBuyRequisitionsSPXPage.addtoCart();

		// Step 8 - Select to Requisition
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		shoppingCartSPXPage.CheckSpotRequisitionShoppingCart();
		shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart();

		// Step 9 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		accountConfigurationSPXPage.selectTypeAccountForRequisition(costCenter);

		// Step 10 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
