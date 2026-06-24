package com.metalsa.spx.dev5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;
import com.metalsa.spx.dev5.poc.AccountConfigurationSPXPage;
import com.metalsa.spx.dev5.poc.HomeSPX;
import com.metalsa.spx.dev5.poc.LogOutSPX;
import com.metalsa.spx.dev5.poc.LoginSPX;
import com.metalsa.spx.dev5.poc.PreviewConfirmationSPXPage;
import com.metalsa.spx.dev5.poc.ShoppingCartSPXPage;
import com.metalsa.spx.dev5.poc.SingleSourceFormatSPXPage;
import com.metalsa.spx.dev5.poc.SpotBuyRequisitionsSPXPage;

public class QC_Testing_SPX_DEV5_TestCases_Requisiciones {

	WebDriver driver;
	SPXBase spxBase;
	LoginSPX loginSPXPage;
	LogOutSPX logOutSPXPage;
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
			category = GlobalVariablesSPX.SPX_DEV5_CATEGORY_SPOT_PAGE_ESP,
			family = GlobalVariablesSPX.SPX_DEV5_FAMILY_SPOT_PAGE_ESP,
			subFamily = GlobalVariablesSPX.SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP,
			quantity = GlobalVariablesSPX.SPX_DEV5_QUANTITY_SPOT_PAGE,
			genericItem = GlobalVariablesSPX.SPX_DEV5_GENERIC_ITEM_SPOT_PAGE,
			commentsToBuyer = GlobalVariablesSPX.SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE,
			pathFileSpot = GlobalVariablesSPX.SPX_DEV5_PATH_FILES,
			commentsShoppingCart = GlobalVariablesSPX.SPX_DEV5_COMMENTS_SHOPPING_CART,
			costCenter = GlobalVariablesSPX.SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE,
			accountingAccount = GlobalVariablesSPX.SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE,
			descriptionFAD = GlobalVariablesSPX.DESCRIPTION_FAD, supplierNameFAD = GlobalVariablesSPX.SUPPLIER_NAME_FAD,
			amountFAD = GlobalVariablesSPX.AMOUNT_FAD, detailsFAD = GlobalVariablesSPX.DETAILS_FAD,
			commentsFAD = GlobalVariablesSPX.COMMENTS_FAD,
			project = GlobalVariablesSPX.SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE;

	@BeforeMethod
	public void beforeTest() {
		// Instanciar valores de conexión con Chrome
		spxBase = new SPXBase(driver);
		spxBase.clearScreenshotList();
		driver = spxBase.chromeDriverConnection();
		loginSPXPage = new LoginSPX(driver);
		logOutSPXPage = new LogOutSPX(driver);
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
		this.url = spxBase.getJSONValue("TestDataLoginSPX", "urlTest");
	}

	@Test(invocationCount = 4)
	public void tc001_SPX_Dev5_Crear_Requisicion_Spot_Tipo_Cobro_CC() throws InterruptedException {
		TreeMap<String, TreeMap<String, String>> listaScreenShots = new TreeMap<>();
		TreeMap<String, String> listaScreenShotsAux;
		List<String> steps = new ArrayList<>();
		List<String> values = new ArrayList<>();

		// Launch Browser
		spxBase.launchBrowser(url);

		// Enter user-name and password and click to button "Enter"
		listaScreenShots.put("Step1", loginSPXPage.login(usernameCC, password));
		steps.add("Step 1 - Enter username and password and click to button Enter ");
		values.add("Credentials Entered");

		// Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Select to UEN and Access to Spot Buy Requisitions
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToSpotBuyRequisitions());
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Spot Buy Requisitions ");
		values.add("UEN Correctly selected and Correct access");

		// Data Capture Spot Buy Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(
				quantity, category, family, subFamily, genericItem));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addtoCart(description, material, color, brand,
				measurements, modelPartNumber, genericName, quantity, category, family, subFamily));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Data Capture Spot Buy Requisition ");
		values.add("Data captured correctly");

//		// Select to Requisition
//		listaScreenShotsAux = new TreeMap<>(); // List clear
//		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
//		listaScreenShotsAux.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
//		listaScreenShotsAux.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());
//		listaScreenShots.put("Step4", listaScreenShotsAux); // Add all list
//		steps.add("Step 4 - Select to Requisition ");
//		values.add("Requisition Correctly selected");
//
//		// Select Type Account For Requisition
//		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
//		listaScreenShots.put("Step5",
//				accountConfigurationSPXPage.selectTypeAccountForRequisitionCC());
//		steps.add("Step 5 - Select Type Account For Requisition ");
//		values.add("Type Account Correctly selected");
//
//		// Accept to Requisition
//		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
//		listaScreenShots.put("Step6", previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
//		steps.add("Step 6 - Accept to Requisition ");
//		values.add("Requisition Accepted");

		// Return to Main Page SPX
		listaScreenShots.put("Step7", homeSPXPage.accesMainPageSPX());
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);
		steps.add("Step 7 - Return to Main Page SPX ");
		values.add("Return to Main Page SPX");

		// Log Out
		listaScreenShots.put("Step8", logOutSPXPage.logout());
		steps.add("Step 8 - Log Out ");
		values.add("Log Out SPX");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc002_SPX_Dev5_Crear_Requisicion_Spot_Tipo_Cobro_Project() throws InterruptedException {
		TreeMap<String, TreeMap<String, String>> listaScreenShots = new TreeMap<>();
		TreeMap<String, String> listaScreenShotsAux;
		List<String> steps = new ArrayList<>();
		List<String> values = new ArrayList<>();

		// Launch Browser
		spxBase.launchBrowser(url);

		// Enter user-name and password and click to button "Enter"
		listaScreenShots.put("Step1", loginSPXPage.login(usernameP, password));
		steps.add("Step 1 - Enter username and password and click to button Enter");
		values.add("Credentials Entered");

		// Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Select to UEN and Access to Spot Buy Requisitions
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToSpotBuyRequisitions());
		Assert.assertEquals(spotBuyRequisitionsSPXPage.textSpotBuyRequisitionsPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Spot Buy Requisitions ");
		values.add("UEN Correctly selected and Correct access");

		// Data Capture Spot Buy Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(
				quantity, category, family, subFamily, genericItem));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addtoCart(description, material, color, brand,
				measurements, modelPartNumber, genericName, quantity, category, family, subFamily));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Data Capture Spot Buy Requisition");
		values.add("Data captured correctly");

		// Select to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShotsAux.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShotsAux.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());
		listaScreenShots.put("Step4", listaScreenShotsAux); // Add all list
		steps.add("Step 4 - Select to Requisition");
		values.add("Requisition Correctly selected");

		// Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.put("Step5", accountConfigurationSPXPage.selectTypeAccountForRequisitionProject());
		steps.add("Step 5 - Select Type Account For Requisition");
		values.add("Type Account Correctly selected");

		// Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.put("Step6", previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		steps.add("Step 6 - Accept to Requisition");
		values.add("Requisition Accepted");

		// Return to Main Page SPX
		listaScreenShots.put("Step7", homeSPXPage.accesMainPageSPX());
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);
		steps.add("Step 7 - Return to Main Page SPX ");
		values.add("Return to Main Page SPX");

		// Log Out
		listaScreenShots.put("Step8", logOutSPXPage.logout());
		steps.add("Step 8 - Log Out ");
		values.add("Log Out SPX");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@AfterMethod
	public void afterTest() {
		spxBase.clearScreenshotList();
		if (driver != null) {
			driver.quit();
		}
	}
}
