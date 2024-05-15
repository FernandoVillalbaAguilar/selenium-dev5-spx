package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class ArticulosPorProcesarSPXPage extends SPXBase {

	public ArticulosPorProcesarSPXPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	// Articulos por procesar
	By txtFielSetPage = By.id("field");
	By lblUEN = By.id("formSearch:accorSearch:uenDefault_label");
	By slstUEN = By.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_UEN_ARTICULOS_POR_PROCESAR_PAGE + "']");
	By btnBuscar = By.id("formSearch:accorSearch:search1");
	By txtRequisicion = By.id("formSearch:accorSearch:requisitions");
	By lblRequisitor = By.id("formSearch:accorSearch:requisitors");
	By txtRequisitor = By.xpath("//body[1]/div[27]/div[1]/div[2]/input[1]");
	By slstRequisitor = By.xpath("(//label[contains(text(),'"
			+ GlobalVariablesSPX.SPX_DEV5_REQUISITOR_ARTICULOS_POR_PROCESAR_PAGE + "')])[3]");
	By btnCloseRequisitor = By.xpath("//body[1]/div[27]/div[1]/a[1]/span[1]");
	By lblComprador = By.id("formSearch:accorSearch:buyers");
	By txtComprador = By.xpath("//body[1]/div[28]/div[1]/div[2]/input[1]");
	By slstComprador = By.xpath("(//label[contains(text(),'"
			+ GlobalVariablesSPX.SPX_DEV5_COMPRADOR_ARTICULOS_POR_PROCESAR_PAGE + "')])[2]");
	By btnCloseComprador = By.xpath("//body[1]/div[28]/div[1]/a[1]/span[1]");
	By lblEstatus = By.id("formSearch:accorSearch:status");
	By txtEstatus = By.xpath("//body[1]/div[25]/div[1]/div[2]/input[1]");
	By slstEstatus = By.xpath(
			"(//label[contains(text(),'" + GlobalVariablesSPX.SPX_DEV5_ESTATUS_ARTICULOS_POR_PROCESAR_PAGE + "')])[2]");
	By btnCloseEstatus = By.xpath("//body[1]/div[25]/div[1]/a[1]/span[1]");
	By txtFechaInicio = By.id("formSearch:accorSearch:dates_input");
	By txtFechaFin = By.id("formSearch:accorSearch:dates2_input");
	// Búsqueda Avanzada
	By btnBusquedaAvanzada = By.id("formSearch:accorSearch:j_idt141");
	By btnBusquedaSimple = By.id("formSearch:accorSearch:j_idt142");
	By lblProceso = By.id("formSearch:accorSearch:process_label");
	By slstProceso = By.xpath("//li[@data-label='VL APO.- PURCHASING']");
	By lblCentroCostos = By.xpath("//label[normalize-space()='Centro de Costos']");
	By txtCentroCostos = By.xpath("(//input[@role='textbox'])[9]");
	By slstCentroCostos = By.xpath("(//label[contains(text(),'A001 - Metalsa Coordination')])[2]");
	By lblCategoria = By.id("formSearch:accorSearch:categories_label");
	By slstCategoria = By.xpath("//li[@data-label='50 - Administrativo y Profesional']");
	By lblFamilia = By.xpath(
			"//body[1]/div[3]/div[1]/fieldset[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/label[1]");
	By slstFamilia = By.xpath("//li[@data-label='02 - Consultoría']");
	By lblSubFamilia = By.id("formSearch:accorSearch:subfamilies_label");
	By slstSubFamilia = By.xpath("//li[@data-label='01 - Consultoría']");
	By lblTipo = By.id("formSearch:accorSearch:selTipos_label");
	By slstTipo = By.xpath("//li[@data-label='Refacción']");
	By lblPrioridad = By.id("formSearch:accorSearch:selPrioridad_label");
	By slstPrioridad = By.xpath("//li[@data-label='Refacción Normal']");
	By lblJustificacion = By.id("formSearch:accorSearch:selJustif_label");
	By slstJustificacion = By.xpath("//li[@data-label='Calidad']");
	By txtBusquedaPorPalabra = By.id("formSearch:accorSearch:lines");
	// Navegación
	By btnNavigation = By.xpath("//div[@role='navigation']//span//span[contains(text(),'1')]");

	/*
	 * @name: textArticulosControladosPageIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtFielSetPage);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean textArticulosPorProcesarPageIsDisplayed() {
		reporterLog("Access to Articulos por Procesar Page ...");
		waitForElementPresent(txtFielSetPage);
		return isDisplayed(txtFielSetPage);
	}

	/*
	 * @name: validacionCamposArticulosPorProcesar
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String menuName
	 * 
	 * @return: returnSaveImage(btnBuscar);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite la validación de campos
	 */
	public TreeMap<String, String> validacionCamposArticulosPorProcesar(String requisicion, String estatus,
			String requisitor, String comprador, String fechaInicio, String fechaFin) throws InterruptedException {
		reporterLog("Realizar validación de campos de búsqueda Articulos por Procesar ...");
		waitForElementPresent(lblUEN);
		click(lblUEN);
		waitForElementPresent(slstUEN);
		click(slstUEN);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(txtRequisicion);
		type(txtRequisicion, requisicion);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		typeClear(txtRequisicion);
		waitForElementPresent(lblRequisitor);
		click(lblRequisitor);
		waitForElementPresent(txtRequisitor);
		type(txtRequisitor, requisitor);
		waitForElementPresent(slstRequisitor);
		click(slstRequisitor);
		waitForElementPresent(btnCloseRequisitor);
		click(btnCloseRequisitor);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(lblComprador);
		click(lblComprador);
		waitForElementPresent(txtComprador);
		type(txtComprador, comprador);
		waitForElementPresent(slstComprador);
		click(slstComprador);
		waitForElementPresent(btnCloseComprador);
		click(btnCloseComprador);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(lblEstatus);
		click(lblEstatus);
		waitForElementPresent(txtEstatus);
		type(txtEstatus, estatus);
		waitForElementPresent(slstEstatus);
		click(slstEstatus);
		waitForElementPresent(btnCloseEstatus);
		click(btnCloseEstatus);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(txtFechaInicio);
		typeClear(txtFechaInicio);
		type(txtFechaInicio, fechaInicio);
		waitForElementPresent(txtFechaFin);
		typeClear(txtFechaFin);
		type(txtFechaFin, fechaFin);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		return returnSaveImage(btnBuscar);
	}

	/*
	 * @name: validacionCamposBusquedaAvanzadaArticulosPorProcesar
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String menuName
	 * 
	 * @return: returnSaveImage(btnBuscar)
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite la validación de campos
	 */
	public TreeMap<String, String> validacionCamposBusquedaAvanzadaArticulosPorProcesar(String centroCostos,
			String busquedaPorPalabra) throws InterruptedException {
		reporterLog("Realizar validación de campos de búsqueda avanzada Articulos por Procesar ...");
		waitForElementPresent(btnBusquedaAvanzada);
		click(btnBusquedaAvanzada);
		waitForElementPresent(lblProceso);
		click(lblProceso);
		waitForElementPresent(slstProceso);
		click(slstProceso);
		waitForElementPresent(lblCentroCostos);
		click(lblCentroCostos);
		waitForElementPresent(txtCentroCostos);
		type(txtCentroCostos, centroCostos);
		waitForElementPresent(slstCentroCostos);
		click(slstCentroCostos);
		waitForElementPresent(lblCategoria);
		click(lblCategoria);
		waitForElementPresent(slstCategoria);
		click(slstCategoria);
		waitForElementPresent(lblFamilia);
		click(lblFamilia);
		waitForElementPresent(slstFamilia);
		click(slstFamilia);
		waitForElementPresent(lblSubFamilia);
		click(lblSubFamilia);
		waitForElementPresent(slstSubFamilia);
		click(slstSubFamilia);
		waitForElementPresent(lblTipo);
		click(lblTipo);
		waitForElementPresent(slstTipo);
		click(slstTipo);
		waitForElementPresent(lblPrioridad);
		click(lblPrioridad);
		waitForElementPresent(slstPrioridad);
		click(slstPrioridad);
		waitForElementPresent(lblJustificacion);
		click(lblJustificacion);
		waitForElementPresent(slstJustificacion);
		click(slstJustificacion);
		waitForElementPresent(txtBusquedaPorPalabra);
		type(txtBusquedaPorPalabra, busquedaPorPalabra);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(btnBusquedaSimple);
		click(btnBusquedaSimple);
		return returnSaveImage(btnBuscar);
	}
}
