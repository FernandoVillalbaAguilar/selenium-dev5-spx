package com.metalsa.spx.dev5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;
import com.metalsa.spx.dev5.poc.HomeSPX;
import com.metalsa.spx.dev5.poc.LoginSPX;
import com.metalsa.spx.dev5.poc.SpotBuyRequisitionsPage;

public class QC_Testing_SPX_DEV5_TestCases {
	WebDriver driver;
	SPXBase spxBase;
	LoginSPX loginSPXPage;
	HomeSPX homeSPXPage;
	SpotBuyRequisitionsPage spotBuyRequisitionsPage;

	// TestDataCalling
	String url = GlobalVariablesSPX.SPX_DEV5_URL, username = GlobalVariablesSPX.SPX_DEV5_USERNAME_REQUESTER,
			password = GlobalVariablesSPX.SPX_DEV5_PASSWORD_REQUESTER,
			description = GlobalVariablesSPX.SPX_DEV5_DESCRIPTION_SPOT_PAGE,
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
			pathFileSpot = GlobalVariablesSPX.SPX_DEV5_PATH_FILES;

	int seconds = GlobalVariablesSPX.SHORT_TIMEOUT;

	@BeforeTest
	public void beforeTest() {
		// Instanciar valores de conexión con Chrome
		spxBase = new SPXBase(driver);
		driver = spxBase.chromeDriverConection();
		loginSPXPage = new LoginSPX(driver);
		homeSPXPage = new HomeSPX(driver);
		spotBuyRequisitionsPage = new SpotBuyRequisitionsPage(driver);
	}

	@Test
	public void tc001QCTestingSPXDev5CrearRequisicionSpot() throws InterruptedException {
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
		Assert.assertEquals(spotBuyRequisitionsPage.textSpotBuyRequisitionsPageIsDisplayed(), true);

		// Step 7 - Data Capture Spot Buy Requisition
		spotBuyRequisitionsPage.captureInformationSpotBuyRequisitionFirstSection(description, material, color, brand,
				measurements, modelPartNumber, genericName);
		spotBuyRequisitionsPage.captureInformationSpotBuyRequisitionsSecondSection(quantity, category, family,
				subFamily, genericItem, unitOfMeasure);
		spotBuyRequisitionsPage.captureInformationSpotBuyRequisitionsThirdSection(commentsToBuyer, pathFileSpot);

	}

	@AfterTest
	public void afterTest() {
		// driver.close();
	}

}
