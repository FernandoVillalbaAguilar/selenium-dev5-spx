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
import com.metalsa.spx.dev5.poc.AdministracionAccesosSPXPage;
import com.metalsa.spx.dev5.poc.AdministracionPorUenElearningSPXPage;
import com.metalsa.spx.dev5.poc.HomeSPX;
import com.metalsa.spx.dev5.poc.LoginSPX;

public class QC_Testing_SPX_DEV5_TestCases_Administracion_Compras_Globales {

	WebDriver driver;
	SPXBase spxBase;
	LoginSPX loginSPXPage;
	HomeSPX homeSPXPage;
	AdministracionPorUenElearningSPXPage administracionPorUenElearningSPXPage;
	AdministracionAccesosSPXPage administracionAccesosSPXPage;

	// TestDataCalling
	String url, usernameCC, usernameP, password,
			menuNameARM = GlobalVariablesSPX.SPX_DEV5_MENU_NAME_ADMINISTRATION_ROLES_MENU_PAGE;

	@BeforeTest
	public void beforeTest() {
		// Instanciar valores de conexi�n con Chrome
		spxBase = new SPXBase(driver);
		driver = spxBase.chromeDriverConnection();
		loginSPXPage = new LoginSPX(driver);
		homeSPXPage = new HomeSPX(driver);
		administracionPorUenElearningSPXPage = new AdministracionPorUenElearningSPXPage(driver);
		administracionAccesosSPXPage = new AdministracionAccesosSPXPage(driver);

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
			// Administrador Roles Menu
			tc001_SPX_Dev5_Activar_Status_UEN_Administracion_Por_UEN_Elearning();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			// tc002_SPX_Dev5_Validar_Filtro_Campo_URLPath_Administrador_Roles_Menu();
		}
	}

	// Administracion Por UEN Elearning
	@Test
	public void tc001_SPX_Dev5_Activar_Status_UEN_Administracion_Por_UEN_Elearning() throws InterruptedException {
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

		// Select to UEN and Access to Administrador Roles Menu
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministracionPorUENElearning());
		Assert.assertEquals(administracionPorUenElearningSPXPage.textAdministracionPorUenElearningPageIsDisplayed(),
				true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administraci�n Por UEN Elearning");
		values.add("UEN Correctly selected and Correct access");

		// Click to Button Status to Activate UEN Elearning
		listaScreenShots.put("Step3", administracionPorUenElearningSPXPage.verificationUenEstatus());
		Assert.assertEquals(administracionPorUenElearningSPXPage.textActivateOrDesactivateIsDisplayed(), true);
		steps.add("Step 3 - Click to Buttons View Menu and Search Filter with Menu Name");
		values.add("Correct Search");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	// Administracion de Accesos
	@Test
	public void tc001_SPX_Dev5_Consulta_Administracion_Accesos() throws InterruptedException {
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

		// Select to UEN and Access to Administración de Accesos
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministracionAccesos());
		Assert.assertEquals(administracionAccesosSPXPage.textAdministracionAccesosPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administraci�n de Accesos");
		values.add("UEN Correctly selected and Correct access");

		// Consulta de información por Aprobacioón de Catalogos
		listaScreenShots.put("Step3", administracionAccesosSPXPage.consultaInformacionGeneral());
		steps.add("Step 3 - Review information on Aprobaci�n Catalogos");
		values.add("Correct Data");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@AfterTest
	public void afterTest() {
//		driver.close();
	}
}
