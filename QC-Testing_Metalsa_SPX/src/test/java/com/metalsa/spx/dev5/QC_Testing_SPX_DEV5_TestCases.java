package com.metalsa.spx.dev5;

import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
import com.metalsa.spx.dev5.poc.SingleSourceFormatSPXPage;
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
	SingleSourceFormatSPXPage singleSourceFormatSPXPage;

	// TestDataCalling
	String url, usernameCC, usernameP, password, description = GlobalVariablesSPX.SPX_DEV5_DESCRIPTION_SPOT_PAGE,
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
			costCenter = GlobalVariablesSPX.SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE,
			descriptionFAD = GlobalVariablesSPX.DESCRIPTION_FAD, supplierNameFAD = GlobalVariablesSPX.SUPPLIER_NAME_FAD,
			amountFAD = GlobalVariablesSPX.AMOUNT_FAD, detailsFAD = GlobalVariablesSPX.AMOUNT_FAD,
			commentsFAD = GlobalVariablesSPX.COMMENTS_FAD,
			project = GlobalVariablesSPX.SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE;

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
		singleSourceFormatSPXPage = new SingleSourceFormatSPXPage(driver);

		// Test Data
		this.usernameCC = spxBase.getJSONValue("TestDataLoginSPX", "usernameCC");
		this.usernameP = spxBase.getJSONValue("TestDataLoginSPX", "usernameP");
		this.password = spxBase.getJSONValue("TestDataLoginSPX", "password");
		this.url = spxBase.getJSONValue("TestDataLoginSPX", "url");
	}

	@Test
	public void tc001_SPX_Dev5_Crear_Requisicion_Spot_Tipo_Cobro_CC() throws InterruptedException {
		Map<String, String> listaScreenShots = new HashedMap<>();
		// Step 1 - Launch Browser
		spxBase.launchBrowser(url);

		// Step 2 - Enter username and password and click to button "Enter"
		listaScreenShots.putAll(loginSPXPage.login(usernameCC, password));

		// Step 4 - Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Step 5 - Select to UEN
		listaScreenShots.putAll(homeSPXPage.selectToUenFromHome());

		// Step 6 - Access to Spot Buy Requisitions
		listaScreenShots.putAll(homeSPXPage.accesToSpotBuyRequisitions());
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity,
				category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.addtoCart());

		// Step 8 - Select to Requisition
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShots.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShots.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());

		// Step 9 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.putAll(accountConfigurationSPXPage.selectTypeAccountForRequisitionCC(costCenter));

		// Step 10 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.putAll(previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		spxBase.saveWordDocument(listaScreenShots);
	}

	@Test
	public void tc002_SPX_Dev5_Crear_Nueva_Linea_Requisicion_Spot_Tipo_Cobro_CC() throws InterruptedException {
		Map<String, String> listaScreenShots = new HashedMap<>();
		// Step 1 - Launch Browser
		spxBase.launchBrowser(url);

		// Step 2 - Enter user name and password and click to button "Enter"
		listaScreenShots.putAll(loginSPXPage.login(usernameCC, password));

		// Step 4 - Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Step 5 - Select to UEN
		listaScreenShots.putAll(homeSPXPage.selectToUenFromHome());

		// Step 6 - Access to Spot Buy Requisitions
		listaScreenShots.putAll(homeSPXPage.accesToSpotBuyRequisitions());
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity,
				category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));

		// Step 8 - Add new line and data capture second line
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.addNewLine());
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity,
				category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.addtoCart());

		// Step 9 - Select to Requisition
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShots.putAll(shoppingCartSPXPage.DoubleCheckSpotRequisitionShoppingCart());
		listaScreenShots.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());

		// Step 10 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.putAll(accountConfigurationSPXPage.selectTypeAccountForRequisitionCC(costCenter));

		// Step 11 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.putAll(previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		spxBase.saveWordDocument(listaScreenShots);
	}

	@Test
	public void tc003_SPX_Dev5_Crear_Requisicion_Spot_Con_FAD_Tipo_Cobro_CC() throws InterruptedException {
		Map<String, String> listaScreenShots = new HashedMap<>();
		// Step 1 - Launch Browser
		spxBase.launchBrowser(url);

		// Step 2 - Enter username and password and click to button "Enter"
		listaScreenShots.putAll(loginSPXPage.login(usernameCC, password));

		// Step 4 - Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Step 5 - Select to UEN
		listaScreenShots.putAll(homeSPXPage.selectToUenFromHome());

		// Step 6 - Access to Spot Buy Requisitions
		listaScreenShots.putAll(homeSPXPage.accesToSpotBuyRequisitions());
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Add FAD to Requisition
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.addFADToRequisition());
		singleSourceFormatSPXPage.textSingleSourceFormatPageIsDisplayed();
		listaScreenShots.putAll(singleSourceFormatSPXPage.captureDataSingleSourceFormat(descriptionFAD, supplierNameFAD,
				amountFAD, detailsFAD, commentsFAD, pathFileSpot));
		listaScreenShots.putAll(singleSourceFormatSPXPage.clickSave());

		// Step 8 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity,
				category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.addtoCart());

		// Step 9 - Select to Requisition
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShots.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShots.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());

		// Step 10 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.putAll(accountConfigurationSPXPage.selectTypeAccountForRequisitionCC(costCenter));

		// Step 11 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.putAll(previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		spxBase.saveWordDocument(listaScreenShots);
	}

	@Test
	public void tc004_SPX_Dev5_Crear_Requisicion_Spot_Tipo_Cobro_CC_Urgent()
			throws InterruptedException, InvalidFormatException {
		Map<String, String> listaScreenShots = new HashedMap<>();
		// Step 1 - Launch Browser
		spxBase.launchBrowser(url);

		// Step 2 - Enter username and password and click to button "Enter"
		listaScreenShots.putAll(loginSPXPage.login(usernameCC, password));

		// Step 4 - Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Step 5 - Select to UEN
		listaScreenShots.putAll(homeSPXPage.selectToUenFromHome());

		// Step 6 - Access to Spot Buy Requisitions
		listaScreenShots.putAll(homeSPXPage.accesToSpotBuyRequisitions());
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity,
				category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.checkUrgent());
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.addtoCart());

		// Step 8 - Select to Requisition
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShots.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShots.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());

		// Step 9 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.putAll(accountConfigurationSPXPage.selectTypeAccountForRequisitionCC(costCenter));

		// Step 10 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.putAll(previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		spxBase.saveWordDocument(listaScreenShots);

	}

	@Test
	public void tc005_SPX_Dev5_Crear_Requisicion_Spot_Tipo_Cobro_Project() throws InterruptedException {
		Map<String, String> listaScreenShots = new HashedMap<>();
		// Step 1 - Launch Browser
		spxBase.launchBrowser(url);

		// Step 2 - Enter username and password and click to button "Enter"
		listaScreenShots.putAll(loginSPXPage.login(usernameP, password));

		// Step 4 - Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Step 5 - Select to UEN
		listaScreenShots.putAll(homeSPXPage.selectToUenFromHome());

		// Step 6 - Access to Spot Buy Requisitions
		listaScreenShots.putAll(homeSPXPage.accesToSpotBuyRequisitions());
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(quantity,
				category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.putAll(spotBuyRequisitionsSPXPage.addtoCart());

		// Step 8 - Select to Requisition
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShots.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShots.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());

		// Step 9 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.putAll(accountConfigurationSPXPage.selectTypeAccountForRequisitionProject(project));

		// Step 10 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.putAll(previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		spxBase.saveWordDocument(listaScreenShots);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
