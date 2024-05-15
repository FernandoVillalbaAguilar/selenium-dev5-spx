package com.metalsa.spx.dev5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
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

public class QC_Testing_SPX_DEV5_TestCases_Requisiciones_Alternos {

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
			category = GlobalVariablesSPX.SPX_DEV5_CATEGORY_SPOT_PAGE_ESP,
			family = GlobalVariablesSPX.SPX_DEV5_FAMILY_SPOT_PAGE_ESP,
			subFamily = GlobalVariablesSPX.SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP,
			quantity = GlobalVariablesSPX.SPX_DEV5_QUANTITY_SPOT_PAGE,
			genericItem = GlobalVariablesSPX.SPX_DEV5_GENERIC_ITEM_SPOT_PAGE,
			unitOfMeasure = GlobalVariablesSPX.SPX_DEV5_UNIT_OF_MEASURE_SPOT_PAGE,
			commentsToBuyer = GlobalVariablesSPX.SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE,
			pathFileSpot = GlobalVariablesSPX.SPX_DEV5_PATH_FILES,
			commentsShoppingCart = GlobalVariablesSPX.SPX_DEV5_COMMENTS_SHOPPING_CART,
			costCenter = GlobalVariablesSPX.SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE,
			accountingAccount = GlobalVariablesSPX.SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE,
			descriptionFAD = GlobalVariablesSPX.DESCRIPTION_FAD, supplierNameFAD = GlobalVariablesSPX.SUPPLIER_NAME_FAD,
			amountFAD = GlobalVariablesSPX.AMOUNT_FAD, detailsFAD = GlobalVariablesSPX.DETAILS_FAD,
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
	public void runTestMultipleTimes() throws InterruptedException, InvalidFormatException {
		int numberOfRuns = 1; // You can adjust this based on the number of times you want to run the test

		for (int i = 0; i < numberOfRuns; i++) {
			tc001_SPX_Dev5_Crear_Nueva_Linea_Requisicion_Spot_Tipo_Cobro_CC();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			tc002_SPX_Dev5_Crear_Requisicion_Spot_Con_FAD_Tipo_Cobro_CC();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			tc003_SPX_Dev5_Crear_Requisicion_Spot_Tipo_Cobro_CC_Urgent();
		}
//		afterTest();
//		beforeTest();
//		for (int i = 0; i < numberOfRuns; i++) {
//			tc004_SPX_Dev5_Crear_Nueva_Linea_Requisicion_Spot_Tipo_Cobro_Project();
//		}
//		afterTest();
//		beforeTest();
//		for (int i = 0; i < numberOfRuns; i++) {
//			tc005_SPX_Dev5_Crear_Requisicion_Spot_Con_FAD_Tipo_Cobro_Project();
//		}
	}

	@Test
	public void tc001_SPX_Dev5_Crear_Nueva_Linea_Requisicion_Spot_Tipo_Cobro_CC() throws InterruptedException {
		TreeMap<String, TreeMap<String, String>> listaScreenShots = new TreeMap<>();
		TreeMap<String, String> listaScreenShotsAux;
		List<String> steps = new ArrayList<>();
		List<String> values = new ArrayList<>();

		// Launch Browser
		spxBase.launchBrowser(url);

		// Enter username and password and click to button "Enter"
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
				quantity, category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Data Capture Spot Buy Requisition");
		values.add("Data captured correctly");

		// Add new line and data capture second line
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addNewLine());
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(
				quantity, category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addtoCart(description, material, color, brand,
				measurements, modelPartNumber, genericName, quantity, category, family, subFamily, unitOfMeasure));
		listaScreenShots.put("Step4", listaScreenShotsAux); // Add all list
		steps.add("Step 4 - Add new line and data capture second line");
		values.add("Line add correctly");

		// Select to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShotsAux.putAll(shoppingCartSPXPage.DoubleCheckSpotRequisitionShoppingCart());
		listaScreenShotsAux.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());
		listaScreenShots.put("Step5", listaScreenShotsAux); // Add all list
		steps.add("Step 5 - Select to Requisition");
		values.add("Requisition Correctly selected");

		// Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.put("Step6",
				accountConfigurationSPXPage.selectTypeAccountForRequisitionCC(costCenter, accountingAccount));
		steps.add("Step 6 - Select Type Account For Requisition");
		values.add("Type Account Correctly selected");

		// Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.put("Step7", previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		steps.add("Step 7 - Accept to Requisition");
		values.add("Requisition Accepted");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc002_SPX_Dev5_Crear_Requisicion_Spot_Con_FAD_Tipo_Cobro_CC() throws InterruptedException {
		TreeMap<String, TreeMap<String, String>> listaScreenShots = new TreeMap<>();
		TreeMap<String, String> listaScreenShotsAux;
		List<String> steps = new ArrayList<>();
		List<String> values = new ArrayList<>();

		// Launch Browser
		spxBase.launchBrowser(url);

		// Enter username and password and click to button "Enter"
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

		// Add FAD to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addFADToRequisition());
		singleSourceFormatSPXPage.textSingleSourceFormatPageIsDisplayed();
		listaScreenShotsAux.putAll(singleSourceFormatSPXPage.captureDataSingleSourceFormat(descriptionFAD,
				supplierNameFAD, amountFAD, detailsFAD, commentsFAD, pathFileSpot));
		listaScreenShotsAux.putAll(singleSourceFormatSPXPage.clickSave());
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Add FAD to Requisition");
		values.add("FAD Successfully Added");

		// Data Capture Spot Buy Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(
				quantity, category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.put("Step4", listaScreenShotsAux); // Add all list
		steps.add("Step 4 - Data Capture Spot Buy Requisition");
		values.add("Data captured correctly");

		// Select to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShotsAux.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShotsAux.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());
		listaScreenShots.put("Step5", listaScreenShotsAux); // Add all list
		steps.add("Step 5 - Select to Requisition");
		values.add("Requisition Correctly selected");

		// Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.put("Step6",
				accountConfigurationSPXPage.selectTypeAccountForRequisitionCC(costCenter, accountingAccount));
		steps.add("Step 6 - Select Type Account For Requisition");
		values.add("Type Account Correctly selected");

		// Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.put("Step7", previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		steps.add("Step 7 - Accept to Requisition");
		values.add("Requisition Accepted");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc003_SPX_Dev5_Crear_Requisicion_Spot_Tipo_Cobro_CC_Urgent()
			throws InterruptedException, InvalidFormatException {
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

		// Step 6 - Data Capture Spot Buy Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(
				quantity, category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.checkUrgent());
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addtoCart(description, material, color, brand,
				measurements, modelPartNumber, genericName, quantity, category, family, subFamily, unitOfMeasure));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Data Capture Spot Buy Requisition");
		values.add("Data captured correctly");

		// Step 7 - Select to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShotsAux.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShotsAux.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());
		listaScreenShots.put("Step4", listaScreenShotsAux); // Add all list
		steps.add("Step 4 - Select to Requisition");
		values.add("Requisition Correctly selected");

		// Step 8 - Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.put("Step5",
				accountConfigurationSPXPage.selectTypeAccountForRequisitionCC(costCenter, accountingAccount));
		steps.add("Step 5 - Select Type Account For Requisition");
		values.add("Type Account Correctly selected");

		// Step 9 - Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.put("Step6", previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		steps.add("Step 6 - Accept to Requisition");
		values.add("Requisition Accepted");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);

	}

	@Test
	public void tc004_SPX_Dev5_Crear_Nueva_Linea_Requisicion_Spot_Tipo_Cobro_Project() throws InterruptedException {
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
				quantity, category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Data Capture Spot Buy Requisition");
		values.add("Data captured correctly");

		// Add new line and data capture second line
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addNewLine());
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(
				quantity, category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addtoCart(description, material, color, brand,
				measurements, modelPartNumber, genericName, quantity, category, family, subFamily, unitOfMeasure));
		listaScreenShots.put("Step4", listaScreenShotsAux); // Add all list
		steps.add("Step 4 - Add new line and data capture second line");
		values.add("Line add correctly");

		// Select to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShotsAux.putAll(shoppingCartSPXPage.DoubleCheckSpotRequisitionShoppingCart());
		listaScreenShotsAux.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());
		listaScreenShots.put("Step5", listaScreenShotsAux); // Add all list
		steps.add("Step 5 - Select to Requisition");
		values.add("Requisition Correctly selected");

		// Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.put("Step6", accountConfigurationSPXPage.selectTypeAccountForRequisitionProject(project));
		steps.add("Step 6 - Select Type Account For Requisition");
		values.add("Type Account Correctly selected");

		// Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.put("Step7", previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		steps.add("Step 7 - Accept to Requisition");
		values.add("Requisition Accepted");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc005_SPX_Dev5_Crear_Requisicion_Spot_Con_FAD_Tipo_Cobro_Project() throws InterruptedException {
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

		// Add FAD to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addFADToRequisition());
		singleSourceFormatSPXPage.textSingleSourceFormatPageIsDisplayed();
		listaScreenShotsAux.putAll(singleSourceFormatSPXPage.captureDataSingleSourceFormat(descriptionFAD,
				supplierNameFAD, amountFAD, detailsFAD, commentsFAD, pathFileSpot));
		listaScreenShotsAux.putAll(singleSourceFormatSPXPage.clickSave());
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Add FAD to Requisition");
		values.add("FAD Successfully Added");

		// Data Capture Spot Buy Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(
				quantity, category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShots.put("Step4", listaScreenShotsAux); // Add all list
		steps.add("Step 4 - Data Capture Spot Buy Requisition");
		values.add("Data captured correctly");

		// Select to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShotsAux.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShotsAux.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());
		listaScreenShots.put("Step5", listaScreenShotsAux); // Add all list
		steps.add("Step 5 - Select to Requisition");
		values.add("Requisition Correctly selected");

		// Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.put("Step6", accountConfigurationSPXPage.selectTypeAccountForRequisitionProject(project));
		steps.add("Step 6 - Select Type Account For Requisition");
		values.add("Type Account Correctly selected");

		// Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.put("Step7", previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		steps.add("Step 7 - Accept to Requisition");
		values.add("Requisition Accepted");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc006_SPX_Dev5_Crear_Requisicion_Spot_Tipo_Cobro_Proyect_Urgent()
			throws InterruptedException, InvalidFormatException {
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

		// Step 6 - Data Capture Spot Buy Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.captureInformationSpotBuyRequisitionsSecondSection(
				quantity, category, family, subFamily, genericItem, unitOfMeasure));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage
				.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot));
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.checkUrgent());
		listaScreenShotsAux.putAll(spotBuyRequisitionsSPXPage.addtoCart(description, material, color, brand,
				measurements, modelPartNumber, genericName, quantity, category, family, subFamily, unitOfMeasure));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Data Capture Spot Buy Requisition");
		values.add("Data captured correctly");

		// Step 7 - Select to Requisition
		listaScreenShotsAux = new TreeMap<>(); // List clear
		Assert.assertEquals(shoppingCartSPXPage.textShoppingCartPageIsDisplayed(), true);
		listaScreenShotsAux.putAll(shoppingCartSPXPage.CheckSpotRequisitionShoppingCart());
		listaScreenShotsAux.putAll(shoppingCartSPXPage.clickSetupPurchaseSpotRequisitionShoppingCart());
		listaScreenShots.put("Step4", listaScreenShotsAux); // Add all list
		steps.add("Step 4 - Select to Requisition");
		values.add("Requisition Correctly selected");

		// Select Type Account For Requisition
		Assert.assertEquals(accountConfigurationSPXPage.textAccountConfigurationPageIsDisplayed(), true);
		listaScreenShots.put("Step5", accountConfigurationSPXPage.selectTypeAccountForRequisitionProject(project));
		steps.add("Step 5 - Select Type Account For Requisition");
		values.add("Type Account Correctly selected");

		// Accept to Requisition
		Assert.assertEquals(previewConfirmationSPXPage.textPreviewConfirmationPageIsDisplayed(), true);
		listaScreenShots.put("Step6", previewConfirmationSPXPage.acceptToRequisitionPreviewConfirmationPage());
		steps.add("Step 6 - Accept to Requisition");
		values.add("Requisition Accepted");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);

	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}
}
