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
import com.metalsa.spx.dev5.poc.ArticulosPorProcesarSPXPage;
import com.metalsa.spx.dev5.poc.CapturadeCotizacionesSPXPage;
import com.metalsa.spx.dev5.poc.HomeSPX;
import com.metalsa.spx.dev5.poc.LoginSPX;

public class QC_Testing_SPX_DEV5_TestCases_ProcesoDeNuevoArticuloDeAlmacen {

	WebDriver driver;
	SPXBase spxBase;
	LoginSPX loginSPXPage;
	HomeSPX homeSPXPage;
	ArticulosPorProcesarSPXPage articulosPorProcesarSPXPage;
	CapturadeCotizacionesSPXPage capturadeCotizacionesSPXPage;

	// TestDataCalling
	String url, usernameCC, usernameP, usernamePNAA, password,
			requisicion = GlobalVariablesSPX.SPX_DEV5_REQUISICION_ARTICULOS_POR_PROCESAR_PAGE,
			estatus = GlobalVariablesSPX.SPX_DEV5_ESTATUS_ARTICULOS_POR_PROCESAR_PAGE,
			requisitor = GlobalVariablesSPX.SPX_DEV5_REQUISITOR_ARTICULOS_POR_PROCESAR_PAGE,
			comprador = GlobalVariablesSPX.SPX_DEV5_COMPRADOR_ARTICULOS_POR_PROCESAR_PAGE,
			fechaInicio = GlobalVariablesSPX.SPX_DEV5_FECHA_INICIO_ARTICULOS_POR_PROCESAR_PAGE,
			fechaFin = GlobalVariablesSPX.SPX_DEV5_FECHA_FIN_ARTICULOS_POR_PROCESAR_PAGE,
			centroCostos = GlobalVariablesSPX.SPX_DEV5_CENTRO_COSTOS_ARTICULOS_POR_PROCESAR_PAGE,
			busquedaPorPalabra = GlobalVariablesSPX.SPX_DEV5_BUSQUEDA_POR_PALABRA_ARTICULOS_POR_PROCESAR_PAGE,
			rfqCC = GlobalVariablesSPX.SPX_DEV5_RFQ_CAPTURA_DE_COTIZACIONES_PAGE,
			requisicionCC = GlobalVariablesSPX.SPX_DEV5_REQUISICION_CAPTURA_DE_COTIZACIONES_PAGE,
			proveedorCC = GlobalVariablesSPX.SPX_DEV5_PROVEEDOR_CAPTURA_DE_COTIZACIONES_PAGE,
			cotizacionCC = GlobalVariablesSPX.SPX_DEV5_COTIZACION_CAPTURA_DE_COTIZACIONES_PAGE,
			fechaInicioCC = GlobalVariablesSPX.SPX_DEV5_FECHA_INICIO_CAPTURA_DE_COTIZACIONES_PAGE,
			fechaFinCC = GlobalVariablesSPX.SPX_DEV5_FECHA_FIN_CAPTURA_DE_COTIZACIONES_PAGE,
			requisitorCC = GlobalVariablesSPX.SPX_DEV5_REQUISITOR_CAPTURA_DE_COTIZACIONES_PAGE,
			compradorCC = GlobalVariablesSPX.SPX_DEV5_COMPRADOR_CAPTURA_DE_COTIZACIONES_PAGE,
			busquedaPorPalabraCC = GlobalVariablesSPX.SPX_DEV5_BUSQUEDA_POR_PALABRA_CAPTURA_DE_COTIZACIONES_PAGE;

	@BeforeTest
	public void beforeTest() {
		// Instanciar valores de conexi�n con Chrome
		spxBase = new SPXBase(driver);
		driver = spxBase.chromeDriverConnection();
		loginSPXPage = new LoginSPX(driver);
		homeSPXPage = new HomeSPX(driver);
		articulosPorProcesarSPXPage = new ArticulosPorProcesarSPXPage(driver);
		capturadeCotizacionesSPXPage = new CapturadeCotizacionesSPXPage(driver);

		// Test Data
		this.usernameCC = spxBase.getJSONValue("TestDataLoginSPX", "usernameCC");
		this.usernameP = spxBase.getJSONValue("TestDataLoginSPX", "usernameP");
		this.usernamePNAA = spxBase.getJSONValue("TestDataLoginSPX", "usernamePNAA");
		this.password = spxBase.getJSONValue("TestDataLoginSPX", "password");
		this.url = spxBase.getJSONValue("TestDataLoginSPX", "url");
	}

	@Test
	public void runTestMultipleTimes() throws InterruptedException, InvalidFormatException {
		int numberOfRuns = 1; // You can adjust this based on the number of times you want to run the test

		for (int i = 0; i < numberOfRuns; i++) {
			tc001_SPX_Dev5_Validar_Campos_Proceso_Nuevo_Articulos_Almacen();
		}
		afterTest();
		beforeTest();
		for (int i = 0; i < numberOfRuns; i++) {

			tc002_SPX_Dev5_Validar_Campos_Captura_Cotizaciones();

		}
	}

	// Articulos por Procesar
	@Test
	public void tc001_SPX_Dev5_Validar_Campos_Proceso_Nuevo_Articulos_Almacen() throws InterruptedException {
		TreeMap<String, TreeMap<String, String>> listaScreenShots = new TreeMap<>();
		TreeMap<String, String> listaScreenShotsAux;
		List<String> steps = new ArrayList<>();
		List<String> values = new ArrayList<>();

		// Launch Browser
		spxBase.launchBrowser(url);

		// Enter user-name and password and click to button "Enter"
		listaScreenShots.put("Step1", loginSPXPage.login(usernamePNAA, password));
		steps.add("Step 1 - Enter username and password and click to button Enter ");
		values.add("Credentials Entered");

		// Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Select to UEN and Access to Articulos por Procesar
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToArticulosPorProcesar());
		Assert.assertEquals(articulosPorProcesarSPXPage.textArticulosPorProcesarPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Articulos por Procesar");
		values.add("UEN Correctly selected and Correct access");

		// Validate search fields
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(articulosPorProcesarSPXPage.validacionCamposArticulosPorProcesar(requisicion,
				estatus, requisitor, comprador, fechaInicio, fechaFin));
		listaScreenShotsAux.putAll(articulosPorProcesarSPXPage
				.validacionCamposBusquedaAvanzadaArticulosPorProcesar(centroCostos, busquedaPorPalabra));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Validate search fields");
		values.add("Validated fields");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	// Captura de Cotizaciones
	@Test
	public void tc002_SPX_Dev5_Validar_Campos_Captura_Cotizaciones() throws InterruptedException {
		TreeMap<String, TreeMap<String, String>> listaScreenShots = new TreeMap<>();
		TreeMap<String, String> listaScreenShotsAux;
		List<String> steps = new ArrayList<>();
		List<String> values = new ArrayList<>();

		// Launch Browser
		spxBase.launchBrowser(url);

		// Enter user-name and password and click to button "Enter"
		listaScreenShots.put("Step1", loginSPXPage.login(usernamePNAA, password));
		steps.add("Step 1 - Enter username and password and click to button Enter ");
		values.add("Credentials Entered");

		// Validate access to SPX
		Assert.assertEquals(homeSPXPage.menuHeaderHomeIsDisplayed(), true);

		// Select to UEN and Access to Captura de Cotizaciones
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(homeSPXPage.selectToUenFromHome());
		listaScreenShotsAux.putAll(homeSPXPage.accesToCapturadeCotizaciones());
		Assert.assertEquals(capturadeCotizacionesSPXPage.textCapturadeCotizacionesPageIsDisplayed(), true);
		listaScreenShots.put("Step2", listaScreenShotsAux); // Add all list
		steps.add("Step 2 - Select to UEN and Access to Captura de Cotizaciones");
		values.add("UEN Correctly selected and Correct access");

		// Validate search fields
		listaScreenShotsAux = new TreeMap<>(); // List clear
		listaScreenShotsAux.putAll(
				capturadeCotizacionesSPXPage.validacionCamposCapturadeCotizaciones(rfqCC, requisicionCC, proveedorCC,
						cotizacionCC, fechaInicioCC, fechaFinCC, requisitorCC, compradorCC, busquedaPorPalabraCC));
//			listaScreenShotsAux.putAll(articulosPorProcesarSPXPage
//					.validacionCamposBusquedaAvanzadaArticulosPorProcesar(centroCostos, busquedaPorPalabra));
		listaScreenShots.put("Step3", listaScreenShotsAux); // Add all list
		steps.add("Step 3 - Validate search fields");
		values.add("Validated fields");

		// Pass steps and values to saveWordDocument
		spxBase.saveWordDocument(listaScreenShots, steps, values);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
