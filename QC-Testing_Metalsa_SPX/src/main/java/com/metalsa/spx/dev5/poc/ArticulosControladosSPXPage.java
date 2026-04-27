package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class ArticulosControladosSPXPage extends SPXBase {

	public ArticulosControladosSPXPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By txtFielSetPage = By.id("formTable");
	By lblUEN = By.id("formTable:uen");
	By txtUEN = By.id("formTable:uen_filter");
	By slstUEN = By.xpath("//div[@id='formTable:uen_panel']//li[@data-label='"
			+ GlobalVariablesSPX.SPX_DEV5_UEN_ARTICULOS_CONTROLADOS_PAGE + "']");
	By lblLocalizacion = By.id("formTable:localizacion_label");
	By txtLocalizacion = By.id("formTable:localizacion_filter");
	By slstLocalizacion = By.xpath("//div[@id='formTable:localizacion_panel']//li[@data-label='"
			+ GlobalVariablesSPX.SPX_DEV5_LOCALIZACION_ARTICULOS_CONTROLADOS_PAGE + "']");
	By txtCodProducto = By.id("formTable:codProducto");
	By txtNombreFabricante = By.id("formTable:nombreFabricante");
	By txtNumPartFabricante = By.id("formTable:numPartFabricante");
	By txtNumPartProveedor = By.id("formTable:numPartProveedor");
	By txtDescripcion = By.id("formTable:descripcion");
	By btnBuscar = By.id("formTable:btnBuscar");
	By chkResult = By.xpath(

			"//td[normalize-space()='" + GlobalVariablesSPX.SPX_DEV5_DESCRIPCION_ARTICULOS_CONTROLADOS_PAGE + "']");

	By slstArticulo = By.xpath(
			"//body[1]/div[3]/div[1]/div[4]/form[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]");
	By btnAdd = By.xpath("//button[@title='Add']");
	By slstArticulosControlados = By.xpath(
			"//body[1]/div[3]/div[1]/div[4]/form[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]");
	By btnRemove = By.xpath("//button[@title='Remove']");
	By btnAddAll = By.xpath("//button[@title='Add All']");
	By btnRemoveAll = By.xpath("//button[@title='Remove All']");
	By txtPickListSource = By.id("formTable:picklist_source_filter");
	By txtPickListTarget = By.id("formTable:picklist_target_filter");

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
	public boolean textArticulosControladosPageIsDisplayed() {
		reporterLog("Access to Articulos Controlados Page ...");
		waitForElementPresent(txtFielSetPage);
		return isDisplayed(txtFielSetPage);
	}

	/*
	 * @name: validacionCamposArticulosControlados
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String menuName
	 * 
	 * @return: isDisplayed(btnBuscar);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite la validaci�n de campos
	 */
	public TreeMap<String, String> validacionCamposArticulosControlados(String uenAC, String localizacionAC,
			String codProductoAC, String nombreFabricanteAC, String numPartFabricanteAC, String numPartProveedorAC,
			String descripcionAC) throws InterruptedException {
		reporterLog("Realizar validaci�n de campos de b�squeda Articulos Controlados ...");
		waitForElementPresent(lblUEN);
		click(lblUEN);
		waitForElementPresent(txtUEN);
		type(txtUEN, uenAC);
		waitForElementPresent(slstUEN);
		click(slstUEN);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);

		waitForElementPresent(lblLocalizacion);
		click(lblLocalizacion);
		waitForElementPresent(txtLocalizacion);
		type(txtLocalizacion, localizacionAC);
		waitForElementPresent(slstLocalizacion);
		click(slstLocalizacion);

		waitForElementPresent(txtCodProducto);
		type(txtCodProducto, codProductoAC);

//		waitForElementPresent(txtNombreFabricante);
//		type(txtNombreFabricante, nombreFabricanteAC);
//		
//		
//		waitForElementPresent(txtNumPartFabricante);
//		type(txtNumPartFabricante, numPartFabricanteAC);
//		
//		
//		waitForElementPresent(txtNumPartProveedor);
//		type(txtNumPartProveedor, numPartProveedorAC);

		waitForElementPresent(txtDescripcion);
		type(txtDescripcion, descripcionAC);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		return returnSaveImage(btnBuscar);
	}

	/*
	 * @name: chkResultPageIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(chkResult);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento est� disponible
	 */
	public boolean chkResultPageIsDisplayed() {
		reporterLog("Check Result Search ...");
		waitForElementPresent(chkResult);
		return isDisplayed(chkResult);
	}

	/*
	 * @name: validarAgregarRemoverArticulosControlados
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String menuName
	 * 
	 * @return: isDisplayed(btnSearch);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite validar los campos y/o botones
	 */
	public TreeMap<String, String> validarAgregarRemoverArticulosControlados(String uenAC, String descripcionAC,
			String pickListSource, String pickListTarget) throws InterruptedException {
		reporterLog("Realizar validaci�n de campos de b�squeda Articulos Controlados ...");
		waitForElementPresent(lblUEN);
		click(lblUEN);
		waitForElementPresent(txtUEN);
		type(txtUEN, uenAC);
		waitForElementPresent(slstUEN);
		click(slstUEN);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.DEFAULT_TIMEOUT);
		waitForElementPresent(slstArticulo);
		click(slstArticulo);
		waitForElementPresent(btnAdd);
		click(btnAdd);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(slstArticulosControlados);
		click(slstArticulosControlados);
		waitForElementPresent(btnRemove);
		click(btnRemove);
		waitForElementPresent(txtDescripcion);
		type(txtDescripcion, descripcionAC);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnAddAll);
		click(btnAddAll);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnRemoveAll);
		click(btnRemoveAll);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtDescripcion);
		typeClear(txtDescripcion);
		waitForElementPresent(btnBuscar);
		click(btnBuscar);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtPickListSource);
		type(txtPickListSource, pickListSource);
		waitForElementPresent(btnAddAll);
		click(btnAddAll);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(txtPickListTarget);
		type(txtPickListTarget, pickListTarget);
		waitForElementPresent(btnRemoveAll);
		click(btnRemoveAll);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnRemoveAll);
	}
}
