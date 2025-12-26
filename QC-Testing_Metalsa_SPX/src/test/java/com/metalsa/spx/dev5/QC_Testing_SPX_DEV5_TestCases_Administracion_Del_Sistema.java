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
import com.metalsa.spx.dev5.poc.AdministradorMenuSPXPage;
import com.metalsa.spx.dev5.poc.AdministradorRolesMenuSPXPage;
import com.metalsa.spx.dev5.poc.ArticulosControladosSPXPage;
import com.metalsa.spx.dev5.poc.HomeSPX;
import com.metalsa.spx.dev5.poc.LoginSPX;

public class QC_Testing_SPX_DEV5_TestCases_Administracion_Del_Sistema {

	WebDriver driver;
	SPXBase spxBase;
	LoginSPX loginSPXPage;
	HomeSPX homeSPXPage;
	AdministradorRolesMenuSPXPage administradorRolesMenuSPXPage;
	AdministradorMenuSPXPage administradorMenuSPXPage;
	ArticulosControladosSPXPage articulosControladosSPXPage;

	// TestDataCalling
	String url, usernameCC, usernameP, password,
			menuNameARM = GlobalVariablesSPX.SPX_DEV5_MENU_NAME_ADMINISTRATION_ROLES_MENU_PAGE,
			urlPathARM = GlobalVariablesSPX.SPX_DEV5_URL_PATH_ADMINISTRATION_ROLES_MENU_PAGE,
			menuNameAM = GlobalVariablesSPX.SPX_DEV5_MENU_NAME_ADMINISTRATION_MENU_PAGE,
			urlPathAM = GlobalVariablesSPX.SPX_DEV5_URL_PATH_ADMINISTRATION_MENU_PAGE,
			nameMenuText = GlobalVariablesSPX.SPX_DEV5_NAME_MENU_ADMINISTRATION_MENU_PAGE,
			descriptionESA = GlobalVariablesSPX.SPX_DEV5_DESCRIPTION_ESA_ADMINISTRATION_MENU_PAGE,
			descriptionUS = GlobalVariablesSPX.SPX_DEV5_DESCRIPTION_US_ADMINISTRATION_MENU_PAGE,
			descriptionPTB = GlobalVariablesSPX.SPX_DEV5_DESCRIPTION_PTB_ADMINISTRATION_MENU_PAGE,
			order = GlobalVariablesSPX.SPX_DEV5_ORDER_ADMINISTRATION_MENU_PAGE,
			cssClass = GlobalVariablesSPX.SPX_DEV5_CSSCLASS_ADMINISTRATION_MENU_PAGE,
			faces = GlobalVariablesSPX.SPX_DEV5_FACES_ADMINISTRATION_MENU_PAGE,
			parent = GlobalVariablesSPX.SPX_DEV5_PARENT_ADMINISTRATION_MENU_PAGE,
			uenAC = GlobalVariablesSPX.SPX_DEV5_UEN_ARTICULOS_CONTROLADOS_PAGE,
			localizacionAC = GlobalVariablesSPX.SPX_DEV5_LOCALIZACION_ARTICULOS_CONTROLADOS_PAGE,
			codProductoAC = GlobalVariablesSPX.SPX_DEV5_CODIGO_PRODUCTO_ARTICULOS_CONTROLADOS_PAGE,
			nombreFabricanteAC = GlobalVariablesSPX.SPX_DEV5_NOMBRE_FABRICANTE_ARTICULOS_CONTROLADOS_PAGE,
			numPartFabricanteAC = GlobalVariablesSPX.SPX_DEV5_NUM_PARTE_FABRICANTE_ARTICULOS_CONTROLADOS_PAGE,
			numPartProveedorAC = GlobalVariablesSPX.SPX_DEV5_NUM_PARTE_PROVEEDOR_ARTICULOS_CONTROLADOS_PAGE,
			descripcionAC = GlobalVariablesSPX.SPX_DEV5_DESCRIPCION_ARTICULOS_CONTROLADOS_PAGE,
			pickListSource = GlobalVariablesSPX.SPX_DEV5_PICKLIST_SOURCE_ARTICULOS_CONTROLADOS_PAGE,
			pickListTarget = GlobalVariablesSPX.SPX_DEV5_PICKLIST_TARGET_ARTICULOS_CONTROLADOS_PAGE;

	@BeforeTest
	public void beforeTest() {
		// Instanciar valores de conexi�n con Chrome
		spxBase = new SPXBase(driver);
		driver = spxBase.chromeDriverConection();
		loginSPXPage = new LoginSPX(driver);
		homeSPXPage = new HomeSPX(driver);
		administradorRolesMenuSPXPage = new AdministradorRolesMenuSPXPage(driver);
		administradorMenuSPXPage = new AdministradorMenuSPXPage(driver);
		articulosControladosSPXPage = new ArticulosControladosSPXPage(driver);

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
			tc001_SPX_Dev5_Validar_Filtro_Campo_MenuName_Administrador_Roles_Menu();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			tc002_SPX_Dev5_Validar_Filtro_Campo_URLPath_Administrador_Roles_Menu();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			tc003_SPX_Dev5_Validar_Funcionalidad_Botones_Add_Remove_Administrador_Roles_Menu();
		}
		afterTest();
		beforeTest();
		// Administrador Menu
		for (int i = 0; i < numberOfRuns; i++) {
			tc004_SPX_Dev5_Validacion_Filtro_Campo_MenuName_Administrador_Menu();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			tc005_SPX_Dev5_Validacion_Filtro_Campo_URLPath_Administrador_Menu();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			tc006_SPX_Dev5_Validacion_Boton_AddNewMenu_Administrador_Menu();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			tc007_SPX_Dev5_Validacion_Boton_Edit_Administrador_Menu();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {
			tc008_SPX_Dev5_Validacion_Boton_Remove_Administrador_Menu();
		}
	}

	// Administrador Roles Menu
	@Test
	public void tc001_SPX_Dev5_Validar_Filtro_Campo_MenuName_Administrador_Roles_Menu() throws InterruptedException {
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
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministradorRolesMenu());
		Assert.assertEquals(administradorRolesMenuSPXPage.textAdministradorRolesMenuPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administrador Roles Menu");
		values.add("UEN Correctly selected and Correct access");

		// Click to Buttons View Menu and Search Filter with Menu Name
		listaScreenShots.put("Step3", administradorRolesMenuSPXPage.filterMenuName(menuNameARM));
		Assert.assertEquals(administradorRolesMenuSPXPage.validationResultSearchNameResultIsDisplayed(), true);
		steps.add("Step 3 - Click to Buttons View Menu and Search Filter with Menu Name");
		values.add("Correct Search");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc002_SPX_Dev5_Validar_Filtro_Campo_URLPath_Administrador_Roles_Menu() throws InterruptedException {
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
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministradorRolesMenu());
		Assert.assertEquals(administradorRolesMenuSPXPage.textAdministradorRolesMenuPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administrador Roles Menu");
		values.add("UEN Correctly selected and Correct access");

		// Click to Buttons View Menu and Search Filter with Menu Name
		listaScreenShots.put("Step3", administradorRolesMenuSPXPage.filterURLPath(urlPathARM));
		Assert.assertEquals(administradorRolesMenuSPXPage.validationResultSearchURLPathResultIsDisplayed(), true);
		steps.add("Step 3 - Click to Buttons View Menu and Search Filter with Menu Name");
		values.add("Correct Search");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc003_SPX_Dev5_Validar_Funcionalidad_Botones_Add_Remove_Administrador_Roles_Menu()
			throws InterruptedException {
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
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministradorRolesMenu());
		Assert.assertEquals(administradorRolesMenuSPXPage.textAdministradorRolesMenuPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administrador Roles Menu");
		values.add("UEN Correctly selected and Correct access");

		// Click to Buttons View Menu and Search Filter with Menu Name and Add new
		// record and Delete Record
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(administradorRolesMenuSPXPage.filterMenuName(menuNameARM));
		Assert.assertEquals(administradorRolesMenuSPXPage.validationResultSearchNameResultIsDisplayed(), true);
		listaScreenShotsAux.putAll(administradorRolesMenuSPXPage.btnAdd());
		Assert.assertEquals(administradorRolesMenuSPXPage.validationAddIsDisplayed(), true);
		listaScreenShotsAux.putAll(administradorRolesMenuSPXPage.btnRemove());
		// Assert.assertEquals(administradorRolesMenuSPXPage.validationRemoveIsDisplayed(),
		// false);
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add(
				"Step 3 - Click to Buttons View Menu and Search Filter with Menu Name and Add new record and Delete Record");
		values.add("Correct Search and Record successfully added and Record successfully deleted");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	// Administrador Menu
	@Test
	public void tc004_SPX_Dev5_Validacion_Filtro_Campo_MenuName_Administrador_Menu() throws InterruptedException {
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

		// Select to UEN and Access to Administrador Menu
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministradorMenu());
		Assert.assertEquals(administradorMenuSPXPage.textAdministradorMenuPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administrador Roles Menu");
		values.add("UEN Correctly selected and Correct access");

		// Perform a search with the Menu Name filter
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(administradorMenuSPXPage.filterMenuName(menuNameAM));
		Assert.assertEquals(administradorMenuSPXPage.validationResultSearchNameResultIsDisplayed(), true);
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Perform a search with the Menu Name filter");
		values.add("Successful search");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc005_SPX_Dev5_Validacion_Filtro_Campo_URLPath_Administrador_Menu() throws InterruptedException {
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

		// Select to UEN and Access to Administrador Menu
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministradorMenu());
		Assert.assertEquals(administradorMenuSPXPage.textAdministradorMenuPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administrador Roles Menu");
		values.add("UEN Correctly selected and Correct access");

		// Perform a search with the URL Path filter
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(administradorMenuSPXPage.filterURLPath(urlPathAM));
		Assert.assertEquals(administradorMenuSPXPage.validationResultSearchURLPathIsDisplayed(), true);
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Perform a search with the URL Path filter");
		values.add("Successful search");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc006_SPX_Dev5_Validacion_Boton_AddNewMenu_Administrador_Menu() throws InterruptedException {
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

		// Select to UEN and Access to Administrador Menu
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministradorMenu());
		Assert.assertEquals(administradorMenuSPXPage.textAdministradorMenuPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administrador Roles Menu");
		values.add("UEN Correctly selected and Correct access");

		// Perform a search with the URL Path filter
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(administradorMenuSPXPage.clickbtnAddNewMenu());
		Assert.assertEquals(administradorMenuSPXPage.validationResultSearchAddNewMneuIsDisplayed(), true);
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Perform a search with the URL Path filter");
		values.add("Successful search");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc007_SPX_Dev5_Validacion_Boton_Edit_Administrador_Menu() throws InterruptedException {
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

		// Select to UEN and Access to Administrador Menu
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministradorMenu());
		Assert.assertEquals(administradorMenuSPXPage.textAdministradorMenuPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administrador Roles Menu");
		values.add("UEN Correctly selected and Correct access");

		// Add new menu and edit fields
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(administradorMenuSPXPage.clickbtnAddNewMenu());
		Assert.assertEquals(administradorMenuSPXPage.validationResultSearchAddNewMneuIsDisplayed(), true);
		listaScreenShotsAux.putAll(administradorMenuSPXPage.editMenus(nameMenuText, descriptionESA, descriptionUS,
				descriptionPTB, order, cssClass, faces, parent));
		Assert.assertEquals(administradorMenuSPXPage.validationMessagesIsDisplayed(), true);
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Add new menu and edit fields");
		values.add("New menu successfully registered");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc008_SPX_Dev5_Validacion_Boton_Remove_Administrador_Menu() throws InterruptedException {
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

		// Select to UEN and Access to Administrador Menu
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToAdministradorMenu());
		Assert.assertEquals(administradorMenuSPXPage.textAdministradorMenuPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Administrador Roles Menu");
		values.add("UEN Correctly selected and Correct access");

		// Delete record
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(administradorMenuSPXPage.clickbtnAddNewMenu());
		Assert.assertEquals(administradorMenuSPXPage.validationResultSearchAddNewMneuIsDisplayed(), true);
		listaScreenShotsAux.putAll(administradorMenuSPXPage.clickRemoveMenu());
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Delete record");
		values.add("Record successfully deleted");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

//Articulos Controlados
	@Test
	public void tc009_SPX_Dev5_Validacion_Campos_Busqueda_Articulos_Controlados() throws InterruptedException {
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

		// Select to UEN and Access to Articulos Controlados
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToArticulosControlados());
		Assert.assertEquals(articulosControladosSPXPage.textArticulosControladosPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Articulos Controlados");
		values.add("UEN Correctly selected and Correct access");

		// Validation of filter fields
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux
				.putAll(articulosControladosSPXPage.validacionCamposArticulosControlados(uenAC, localizacionAC,
						codProductoAC, nombreFabricanteAC, numPartFabricanteAC, numPartProveedorAC, descripcionAC));
		Assert.assertEquals(articulosControladosSPXPage.chkResultPageIsDisplayed(), true);
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Validation of filter fields");
		values.add("Correct field validation");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@Test
	public void tc010_SPX_Dev5_Validacion_Agregar_Remover_Articulos_Controlados() throws InterruptedException {
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

		// Select to UEN and Access to Articulos Controlados
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToArticulosControlados());
		Assert.assertEquals(articulosControladosSPXPage.textArticulosControladosPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Articulos Controlados");
		values.add("UEN Correctly selected and Correct access");

		// Validation buttons Add & Remove
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(articulosControladosSPXPage.validarAgregarRemoverArticulosControlados(uenAC,
				descripcionAC, pickListSource, pickListTarget));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Validation buttons Add & Remove");
		values.add("Correct buttons validation");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@AfterTest
	public void afterTest() {
//		driver.close();
	}
}
