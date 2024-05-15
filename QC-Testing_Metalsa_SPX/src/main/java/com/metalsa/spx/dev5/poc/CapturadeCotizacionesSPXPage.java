package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class CapturadeCotizacionesSPXPage extends SPXBase {

	public CapturadeCotizacionesSPXPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By lblUEN = By.id("formSearch:accorSearch:uenDefault_label");
	By slstUEN = By.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_UEN_CAPTURA_DE_COTIZACIONES_PAGE + "']");
	By btnExpand = By.id("formSearch:rfqTable:expandbtn");
	By txtRFQ = By.id("formSearch:accorSearch:rfq");
	By lblProceso = By.id("formSearch:accorSearch:process_label");
	By slstProceso = By
			.xpath("//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_PROCESO_CAPTURA_DE_COTIZACIONES_PAGE + "']");
	By slstProcesoClear = By.xpath("(//li[@data-label='Seleccione uno...'][normalize-space()='Seleccione uno...'])[2]");
	By txtRequisicion = By.id("formSearch:accorSearch:requisitions");
	By chkLineasPendientes = By.id("formSearch:accorSearch:j_idt108");
	By txtProveedor = By.id("formSearch:accorSearch:suppliers_input");
	By txtCotizacion = By.id("formSearch:accorSearch:quotation");
	By lblCentroCostos = By.id("formSearch:accorSearch:cc_label");
	By slstCentroCostos = By.xpath(
			"//li[@data-label='" + GlobalVariablesSPX.SPX_DEV5_CENTRO_COSTOS_CAPTURA_DE_COTIZACIONES_PAGE + "']");
	By slstCentroCostosClear=By.xpath("(//li[@data-label='Seleccione uno...'][normalize-space()='Seleccione uno...'])[3]");
	By txtFechaInicio = By.id("formSearch:accorSearch:dates_input");
	By txtFechaFin = By.id("formSearch:accorSearch:dates2_input");
	By chkMostrarRFQ=By.id("formSearch:accorSearch:j_idt111");
	By lblRequisitor=By.id("formSearch:accorSearch:requisitors");
	By txtRequisitor=By.xpath("//body[1]/div[19]/div[1]/div[2]/input[1]");
	By slstRequisitor=By.xpath("(//label[contains(text(),'Garza Cantu Edna Melissa')])[3]");
	By btnCloseRequisitor=By.xpath("//body[1]/div[19]/div[1]/a[1]/span[1]");
	By lblComprador=By.id("formSearch:accorSearch:buyers");
	By txtComprador=By.xpath("//body[1]/div[20]/div[1]/div[2]/input[1]");
	By slstComprador=By.xpath("(//label[contains(text(),'Aguirre Elizondo Lemna Cecilia')])[2]");
	By btnCloseComprador=By.xpath("//body[1]/div[20]/div[1]/a[1]/span[1]");
	By btnBuscar = By.id("formSearch:accorSearch:btnSearch");

	/*
	 * @name: textCapturadeCotizacionesPageIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtTittle);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean textCapturadeCotizacionesPageIsDisplayed() {
		reporterLog("Access to Captura de Cotizaciones Page ...");
		waitForElementPresent(btnBuscar);
		return isDisplayed(btnBuscar);
	}

	/*
	 * @name: validacionCamposCapturadeCotizaciones
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
	public TreeMap<String, String> validacionCamposCapturadeCotizaciones(String rfqCC, String requisicionCC,
			String proveedorCC, String cotizacionCC, String fechaInicioCC, String fechaFinCC, String requisitorCC,
			String compradorCC, String busquedaPorPalabraCC) throws InterruptedException {
		reporterLog("Realizar validación de campos de búsqueda Articulos por Procesar ...");
		waitForElementPresent(lblUEN);
		click(lblUEN);
		waitForElementPresent(slstUEN);
		click(slstUEN);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnExpand);
		click(btnExpand);
		waitForElementPresent(txtRFQ);
		type(txtRFQ, rfqCC);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		typeClear(txtRFQ);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblProceso);
		click(lblProceso);
		waitForElementPresent(slstProceso);
		click(slstProceso);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblProceso);
		click(lblProceso);
		waitForElementPresent(slstProcesoClear);
		click(slstProcesoClear);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtRequisicion);
		type(txtRequisicion, requisicionCC);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		typeClear(txtRequisicion);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(chkLineasPendientes);
		click(chkLineasPendientes);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(chkLineasPendientes);
		click(chkLineasPendientes);
		waitForElementPresent(txtProveedor);
		type(txtProveedor, proveedorCC);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		typeClear(txtProveedor);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtCotizacion);
		type(txtCotizacion, cotizacionCC);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		typeClear(txtCotizacion);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblCentroCostos);
		click(lblCentroCostos);
		waitForElementPresent(slstCentroCostos);
		click(slstCentroCostos);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblCentroCostos);
		click(lblCentroCostos);
		waitForElementPresent(slstCentroCostosClear);
		click(slstCentroCostosClear);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtFechaInicio);
		typeClear(txtFechaInicio);
		type(txtFechaInicio, fechaInicioCC);
		waitForElementPresent(txtFechaFin);
		typeClear(txtFechaFin);
		type(txtFechaFin, fechaFinCC);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(chkMostrarRFQ);
		click(chkMostrarRFQ);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(chkMostrarRFQ);
		click(chkMostrarRFQ);
		waitForElementPresent(lblRequisitor);
		click(lblRequisitor);
		waitForElementPresent(txtRequisitor);
		type(txtRequisitor, requisitorCC);
		waitForElementPresent(slstRequisitor);
		click(slstRequisitor);
		waitForElementPresent(btnCloseRequisitor);
		click(btnCloseRequisitor);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(lblRequisitor);
		click(lblRequisitor);
		waitForElementPresent(txtRequisitor);
		type(txtRequisitor, requisitorCC);
		waitForElementPresent(slstRequisitor);
		click(slstRequisitor);
		waitForElementPresent(btnCloseRequisitor);
		click(btnCloseRequisitor);
		waitForElementPresent(lblComprador);
		click(lblComprador);
		waitForElementPresent(txtComprador);
		type(txtComprador, compradorCC);
		waitForElementPresent(slstComprador);
		click(slstComprador);
		waitForElementPresent(btnCloseComprador);
		click(btnCloseComprador);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnBuscar);
	}
}
