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
	By slstUEN = By.xpath("//div[@id='formSearch:accorSearch:uenDefault_panel']/div/ul/li[@data-label='"
			+ GlobalVariablesSPX.SPX_DEV5_UEN_ARTICULOS_POR_PROCESAR_PAGE + "']");
	By btnBuscar = By.id("formSearch:accorSearch:search1");
	By txtRequisicion = By.id("formSearch:accorSearch:requisitions");
	By lblRequisitor = By.id("formSearch:accorSearch:requisitors");
	By txtRequisitor = By.xpath(
			"//div[@id='formSearch:accorSearch:requisitors_panel']/div/div[@class='ui-selectcheckboxmenu-filter-container']/input[@type='text']");
	By slstRequisitor = By
			.xpath("//div[@id='formSearch:accorSearch:requisitors_panel']/div/ul/li/label[contains(text(),'"
					+ GlobalVariablesSPX.SPX_DEV5_REQUISITOR_ARTICULOS_POR_PROCESAR_PAGE + "')]");
	By btnCloseRequisitor = By.xpath(
			"//div[@id='formSearch:accorSearch:requisitors_panel']/div/a/span[@class='ui-icon ui-icon-circle-close']");
	By lblComprador = By.id("formSearch:accorSearch:buyers");
	By txtComprador = By.xpath("//div[@id='formSearch:accorSearch:buyers_panel']/div/div/input[@type='text']");
	By slstComprador = By.xpath("//div[@id='formSearch:accorSearch:buyers_panel']/div/ul/li/label[contains(text(),'"
			+ GlobalVariablesSPX.SPX_DEV5_COMPRADOR_ARTICULOS_POR_PROCESAR_PAGE + "')]");
	By btnCloseComprador = By.xpath(
			"//div[@id='formSearch:accorSearch:buyers_panel']/div/a/span[@class='ui-icon ui-icon-circle-close']");
	By lblEstatus = By.id("formSearch:accorSearch:status");
	By txtEstatus = By.xpath("//div[@id='formSearch:accorSearch:status_panel']/div/div/input[@type='text']");
	By slstEstatus = By.xpath("//div[@id='formSearch:accorSearch:status_panel']/div/ul/li/label[contains(text(),'"
			+ GlobalVariablesSPX.SPX_DEV5_ESTATUS_ARTICULOS_POR_PROCESAR_PAGE + "')]");
	By btnCloseEstatus = By.xpath(
			"//div[@id='formSearch:accorSearch:status_panel']/div/a/span[@class='ui-icon ui-icon-circle-close']");
	By txtFechaInicio = By.id("formSearch:accorSearch:dates_input");
	By txtFechaFin = By.id("formSearch:accorSearch:dates2_input");
	// B�squeda Avanzada
	By btnBusquedaAvanzada = By
			.xpath("//div[@id='formSearch:accorSearch']/div/div/div/div/a[@class='ui-commandlink ui-widget']");
	By btnBusquedaSimple = By
			.xpath("//div[@id='formSearch:accorSearch']/div/div/div/div/a[@class='ui-commandlink ui-widget']");
	By lblProceso = By.id("formSearch:accorSearch:process_label");
	By slstProceso = By.xpath("//div[@id='formSearch:accorSearch:process']/label[contains(text(),'"
			+ GlobalVariablesSPX.SPX_DEV5_PROCESO_ARTICULOS_POR_PROCESAR_PAGE + "')]");
	By lblCentroCostos = By.xpath("//label[normalize-space()='Centro de Costos']");
	By txtCentroCostos = By.xpath("(//input[@role='textbox'])[9]");
	By slstCentroCostos = By.xpath("(//label[contains(text(),'"
			+ GlobalVariablesSPX.SPX_DEV5_CENTRO_COSTOS_ARTICULOS_POR_PROCESAR_PAGE + "')])[2]");
	By lblCategoria = By.id("formSearch:accorSearch:categories_label");
	By slstCategoria = By
			.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_CATEGORIA_ARTICULOS_POR_PROCESAR_PAGE + "']");
	By lblFamilia = By.id("formSearch:accorSearch:families_label");
	By slstFamilia = By
			.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_FAMILIA_ARTICULOS_POR_PROCESAR_PAGE + "']");
	By lblSubFamilia = By.id("formSearch:accorSearch:subfamilies_label");
	By slstSubFamilia = By
			.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_SUBFAMILIA_ARTICULOS_POR_PROCESAR_PAGE + "']");
	By lblTipo = By.id("formSearch:accorSearch:selTipos_label");
	By slstTipo = By.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_TIPO_ARTICULOS_POR_PROCESAR_PAGE + "']");
	By lblPrioridad = By.id("formSearch:accorSearch:selPrioridad_label");
	By slstPrioridad = By
			.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_PRIORIDAD_ARTICULOS_POR_PROCESAR_PAGE + "']");
	By lblJustificacion = By.id("formSearch:accorSearch:selJustif_label");
	By slstJustificacion = By
			.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_JUSTIFICACION_ARTICULOS_POR_PROCESAR_PAGE + "']");
	By txtBusquedaPorPalabra = By.id("formSearch:accorSearch:lines");
	// Navegaci�n
	By btnNavigation = By.xpath("//div[@role='navigation']//span//span[contains(text(),'1')]");
	// Botones de Acci�n
	By btnExpandMain = By.id("formTable:requisitionsTable:expandbtn");
	By btnExpandFields = By.xpath(
			"//tbody[@id='formTable:requisitionsTable_data']/tr[@class='ui-widget-content ui-datatable-even']/td/div[@class='ui-row-toggler ui-icon ui-icon-circle-triangle-e']");
	By btnReclasificarLineas = By.id("formTable:btnReclasificar");
	By btnReclasificarLineas2 = By.id("formTable:btnReclasificar2");
	By btnSeleccionDeProveedores = By.id("formTable:btnRfq");
	By btnSeleccionDeProveedores2 = By.id("formTable:btnRfq2");
	By btnCancelarRequisicion = By.id("formTable:btnCancelRequi");
	By btnCancelarRequisicion2 = By.id("formTable:btnCancelRequi2");
	By iconExcelReport = By.xpath(
			"//div[@id='formTable:requisitionsTable']/div/table/thead/tr/th/span[@class='ui-column-title']/a[@class='ui-commandlink ui-widget']");
	By iconVerAdjuntos = By.xpath(
			"//tbody[@id='formTable:requisitionsTable_data']/tr/td/button[@id='formTable:requisitionsTable:0:btnAttach']");
	By iconVerDetalle = By.xpath(
			"//tbody[@id='formTable:requisitionsTable_data']/tr/td/button[@id='formTable:requisitionsTable:0:btnExpand']");
	By chkMainRequisicion = By.xpath(
			"//th[@id='formTable:requisitionsTable:0:detalleRequi:j_idt184']/div/div/span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']");
	By chkLineRequisicion = By.xpath("//td[@class='ui-selection-column']/div/div/span[@xpath='1']");

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
	 * @description: Este metodo permite verificar que el elemento est� disponible
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
	 * @description: Este metodo permite la validaci�n de campos
	 */
	public TreeMap<String, String> validacionCamposArticulosPorProcesar(String requisicion, String estatus,
			String requisitor, String comprador, String fechaInicio, String fechaFin) throws InterruptedException {
		reporterLog("Realizar validaci�n de campos de b�squeda Articulos por Procesar ...");
		waitForElementPresent(lblUEN);
		click(lblUEN);
		waitForElementPresent(slstUEN);
		click(slstUEN);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(txtRequisicion);
		type(txtRequisicion, requisicion);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
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
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		// Quitar Check del campo Requisitor
		waitForElementPresent(lblRequisitor);
		click(lblRequisitor);
		waitForElementPresent(txtRequisitor);
		type(txtRequisitor, requisitor);
		waitForElementPresent(slstRequisitor);
		click(slstRequisitor);
		waitForElementPresent(btnCloseRequisitor);
		click(btnCloseRequisitor);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblComprador);
		click(lblComprador);
		waitForElementPresent(txtComprador);
		type(txtComprador, comprador);
		waitForElementPresent(slstComprador);
		click(slstComprador);
		waitForElementPresent(btnCloseComprador);
		click(btnCloseComprador);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		// Quitar Check del campo Comprador
		waitForElementPresent(lblComprador);
		click(lblComprador);
		waitForElementPresent(txtComprador);
		type(txtComprador, comprador);
		waitForElementPresent(slstComprador);
		click(slstComprador);
		waitForElementPresent(btnCloseComprador);
		click(btnCloseComprador);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblEstatus);
		click(lblEstatus);
		waitForElementPresent(txtEstatus);
		type(txtEstatus, estatus);
		waitForElementPresent(slstEstatus);
		click(slstEstatus);
		waitForElementPresent(btnCloseEstatus);
		click(btnCloseEstatus);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		// Quitar Check del campo Estatus
		waitForElementPresent(lblEstatus);
		click(lblEstatus);
		waitForElementPresent(txtEstatus);
		type(txtEstatus, estatus);
		waitForElementPresent(slstEstatus);
		click(slstEstatus);
		waitForElementPresent(btnCloseEstatus);
		click(btnCloseEstatus);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtFechaInicio);
		typeClear(txtFechaInicio);
		type(txtFechaInicio, fechaInicio);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtFechaFin);
		typeClear(txtFechaFin);
		type(txtFechaFin, fechaFin);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
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
	 * @description: Este metodo permite la validaci�n de campos
	 */
	public TreeMap<String, String> validacionCamposBusquedaAvanzadaArticulosPorProcesar(String centroCostos,
			String busquedaPorPalabra) throws InterruptedException {
		reporterLog("Realizar validaci�n de campos de b�squeda avanzada Articulos por Procesar ...");
		waitForElementPresent(btnBusquedaAvanzada);
		click(btnBusquedaAvanzada);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(lblProceso);
		click(lblProceso);
		// Solo se mostrar� informaci�n en este campo si hay catalogos de procesos
		// cargados por parte de PDD.
		if (isDisplayed(slstProceso)) {
			click(slstProceso);
		} else {
			click(lblProceso);
		}
		waitForElementPresent(lblCentroCostos);
		click(lblCentroCostos);
		waitForElementPresent(txtCentroCostos);
		type(txtCentroCostos, centroCostos);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(slstCentroCostos);
		click(slstCentroCostos);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblCategoria);
		click(lblCategoria);
		waitForElementPresent(slstCategoria);
		click(slstCategoria);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblFamilia);
		click(lblFamilia);
		waitForElementPresent(slstFamilia);
		click(slstFamilia);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblSubFamilia);
		click(lblSubFamilia);
		waitForElementPresent(slstSubFamilia);
		click(slstSubFamilia);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblTipo);
		click(lblTipo);
		waitForElementPresent(slstTipo);
		click(slstTipo);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblPrioridad);
		click(lblPrioridad);
		waitForElementPresent(slstPrioridad);
		click(slstPrioridad);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblJustificacion);
		click(lblJustificacion);
		waitForElementPresent(slstJustificacion);
		click(slstJustificacion);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtBusquedaPorPalabra);
		type(txtBusquedaPorPalabra, busquedaPorPalabra);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(btnBusquedaSimple);
		click(btnBusquedaSimple);
		return returnSaveImage(btnBusquedaSimple);
	}

	/*
	 * @name: validacionBotonesDeAccionArticulosPorProcesar
	 * 
	 * @date: 17-05-2024
	 * 
	 * @param: String menuName
	 * 
	 * @return: returnSaveImage(btnBuscar)
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite la validaci�n de campos
	 */
	public TreeMap<String, String> validacionBotonesDeAccionArticulosPorProcesar(String requisicion)
			throws InterruptedException {
		reporterLog("Realizar validaci�n de los botones de acci�n -  Articulos por Procesar ...");
		waitForElementPresent(txtRequisicion);
		type(txtRequisicion, requisicion);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		click(btnExpandMain);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		click(btnExpandMain);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		click(btnExpandFields);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		click(btnExpandFields);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		click(btnReclasificarLineas);
		click(btnSeleccionDeProveedores);
		click(btnCancelarRequisicion);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		scrollDown(btnNavigation);
		click(btnNavigation);
		click(btnReclasificarLineas2);
		click(btnSeleccionDeProveedores2);
		click(btnCancelarRequisicion2);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		scrollUp(txtFielSetPage);
		return returnSaveImage(txtFielSetPage);
	}
}
