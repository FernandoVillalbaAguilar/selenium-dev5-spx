package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class HomeSPX extends SPXBase {

	public HomeSPX(WebDriver driver) {
		super(driver);
	}

	// Objects
	By selectUEN = By.xpath("//select[@name='uens']");
	By optUEN = By.xpath(GlobalVariablesSPX.SPX_DEV5_UEN_HOME);
	// Menu's
	By iconMenu = By.id("sidebarCollapse");
	// Administraci�n del sistema
	By iconMenuAdministracionDelSistema = By.xpath("//a[@href='#_menu_182']");
	By iconMenuAdministradorTI = By.xpath("//a[@href='#_menu_183']");
	By iconMenuAdministradorRolesMenu = By
			.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL + "pages/administracion/rolesMenu/index.xhtml']");
	By iconMenuAdministradorMenu = By
			.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL + "pages/administracion/menu/index.xhtml']");
	By iconMenuArticulosControlados = By
			.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL + "pages/administracion/itemsControlados.xhtml']");
	// Proceso de Nuevo Articulo de Almacen
	By iconMenuProcesoNuevoArticuloAlmacen = By.xpath("//a[@href='#_menu_445']");
	By iconMenuArticulosPorProcesar = By.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL
			+ "pages/almacen/solicitud/cotizaciones/solicitudesPorCotizar.xhtml']");
	By iconMenuCapturadeCotizaciones = By.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL
			+ "pages/almacen/solicitud/cotizaciones/capturaCotizacion.xhtml']");
	// Requisiciones
	By iconMenuRequisitions = By.xpath("//a[@href='#_menu_191']");
	By iconMenuRequisitionsCreateRequisition = By.xpath("//a[@href='#_menu_192']");
	By iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions = By
			.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL + "/pages/spot/index.xhtml']");
	By iconMenuRequisitionCreateNewArticleAlmacen = By
			.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL + "pages/almacen/solicitud/nuevoArticulo.xhtml']");

	// Compras Globales
	By iconMenuAdministradorComprasGlobales = By.xpath("//li[.//a[@href='#_menu_222']]");
	By iconMenuAdministracionPorUENElearning = By
			.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL + "pages/administracion/AdminMantElearning.xhtml']");
	By iconMenuAdministracionAccesos = By
			.xpath("//a[@href='" + GlobalVariablesSPX.SPX_DEV5_URL + "pages/administracion/adminAccesos.xhtml']");
	By iconMainPageSPX = By.xpath("//img[@title='HOME']");

	/*
	 * @name: menuHeaderHomeIsDisplayed
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Confirma el acceso a SPX verificando la visibilidad del icono
	 * principal del menu en el encabezado de la pantalla de inicio.
	 */
	public boolean menuHeaderHomeIsDisplayed() {
		reporterLog("Access to SPX ...");
		waitForElementPresent(iconMenu);
		return isDisplayed(iconMenu);
	}

	/*
	 * @name: selectUenFromHome
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Despliega el selector de UEN desde la pantalla principal,
	 * selecciona la opcion correspondiente y captura la evidencia visual de la
	 * seleccion.
	 */
	public TreeMap<String, String> selectUenFromHome() {
		reporterLog("Selecting UEN from Home...");

		click(selectUEN);
		waitForElementPresent(optUEN);
		click(optUEN);

		return returnSaveImage(optUEN);
	}

	// Access to Menu's
	/*
	 * @name: accesToAdministradorRolesMenu
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Navega a traves del menu lateral pasando por Administracion del
	 * Sistema y Administrador TI hasta acceder al modulo Administrador de Roles,
	 * retornando la evidencia visual.
	 */
	public TreeMap<String, String> accesToAdministradorRolesMenu() {
		reporterLog("Access to Administrador Roles Menu ...");
		waitForElementPresent(iconMenu);
		click(iconMenu);
		waitForElementPresent(iconMenuAdministracionDelSistema);
		click(iconMenuAdministracionDelSistema);
		waitForElementPresent(iconMenuAdministradorTI);
		click(iconMenuAdministradorTI);
		waitForElementPresent(iconMenuAdministradorRolesMenu);
		click(iconMenuAdministradorRolesMenu);
		return returnSaveImage(iconMenuAdministradorRolesMenu);
	}

	/*
	 * @name: accesToAdministradorMenu
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Navega jerarquicamente en el menu lateral hasta la opcion
	 * Administrador dentro de la seccion Administrador TI y guarda captura de
	 * evidencia.
	 */
	public TreeMap<String, String> accesToAdministradorMenu() {
		reporterLog("Access to Administrador Menu ...");
		click(iconMenu);
		waitForElementPresent(iconMenuAdministracionDelSistema);
		click(iconMenuAdministracionDelSistema);
		waitForElementPresent(iconMenuAdministradorTI);
		click(iconMenuAdministradorTI);
		waitForElementPresent(iconMenuAdministradorMenu);
		click(iconMenuAdministradorMenu);
		return returnSaveImage(iconMenuAdministradorMenu);
	}

	/*
	 * @name: accesToArticulosControlados
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Navega jerarquicamente en el menu principal hasta acceder al
	 * modulo de Articulos Controlados, capturando la evidencia del acceso.
	 */
	public TreeMap<String, String> accesToArticulosControlados() {
		reporterLog("Access to Administrador Menu ...");
		click(iconMenu);
		waitForElementPresent(iconMenuAdministracionDelSistema);
		click(iconMenuAdministracionDelSistema);
		waitForElementPresent(iconMenuAdministradorTI);
		click(iconMenuAdministradorTI);
		waitForElementPresent(iconMenuArticulosControlados);
		click(iconMenuArticulosControlados);
		return returnSaveImage(iconMenuArticulosControlados);
	}

	/*
	 * @name: accesToArticulosPorProcesar
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Accede a la vista de Articulos por Procesar ingresando mediante
	 * la seccion Proceso Nuevo Articulo Almacen y retorna la evidencia capturada.
	 */
	public TreeMap<String, String> accesToArticulosPorProcesar() {
		reporterLog("Access to Articulos por Procesar ...");
		click(iconMenu);
		waitForElementPresent(iconMenuProcesoNuevoArticuloAlmacen);
		click(iconMenuProcesoNuevoArticuloAlmacen);
		waitForElementPresent(iconMenuArticulosPorProcesar);
		click(iconMenuArticulosPorProcesar);
		return returnSaveImage(iconMenuArticulosPorProcesar);
	}

	/*
	 * @name: accesToCapturadeCotizaciones
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Navega a la seccion de Captura de Cotizaciones dentro de la
	 * ruta Proceso Nuevo Articulo Almacen en el menu principal y recopila la
	 * evidencia del paso.
	 */
	public TreeMap<String, String> accesToCapturadeCotizaciones() {
		reporterLog("Access to Caputa de cotizaciones ...");
		click(iconMenu);
		waitForElementPresent(iconMenuProcesoNuevoArticuloAlmacen);
		click(iconMenuProcesoNuevoArticuloAlmacen);
		waitForElementPresent(iconMenuCapturadeCotizaciones);
		click(iconMenuCapturadeCotizaciones);
		return returnSaveImage(iconMenuCapturadeCotizaciones);
	}

	/*
	 * @name: accesToSpotBuyRequisitions
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Navega a traves de las subsecciones de Requisiciones hasta
	 * ingresar a la pantalla Spot Buy Requisitions, capturando evidencia de la
	 * navegacion.
	 */
	public TreeMap<String, String> accesToSpotBuyRequisitions() {
		reporterLog("Access to Spot Buy Requisitions ...");
		click(iconMenu);
		waitForElementPresent(iconMenuRequisitions);
		click(iconMenuRequisitions);
		waitForElementPresent(iconMenuRequisitionsCreateRequisition);
		click(iconMenuRequisitionsCreateRequisition);
		waitForElementPresent(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
		click(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
		return returnSaveImage(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
	}

	// Access to Menu's
	/*
	 * @name: accesToAdministracionPorUENElearning
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Accede a la seccion Administracion por UEN Elearning bajo la
	 * ruta Administrador Compras Globales y genera captura del modulo.
	 */
	public TreeMap<String, String> accesToAdministracionPorUENElearning() {
		reporterLog("Access to Administrador por UEN Elearning ...");
		click(iconMenu);
		waitForElementPresent(iconMenuAdministradorComprasGlobales);
		click(iconMenuAdministradorComprasGlobales);
		waitForElementPresent(iconMenuAdministracionPorUENElearning);
		click(iconMenuAdministracionPorUENElearning);
		return returnSaveImage(iconMenuAdministracionPorUENElearning);
	}

	// Access to Menu's
	/*
	 * @name: accesToAdministracionAccesos
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Navega al modulo Administracion de Accesos desde el menu
	 * Administrador Compras Globales y registra la evidencia correspondiente.
	 */
	public TreeMap<String, String> accesToAdministracionAccesos() {
		reporterLog("Access to Administracion de Accesos ...");
		click(iconMenu);
		waitForElementPresent(iconMenuAdministradorComprasGlobales);
		click(iconMenuAdministradorComprasGlobales);
		waitForElementPresent(iconMenuAdministracionAccesos);
		click(iconMenuAdministracionAccesos);
		return returnSaveImage(iconMenuAdministracionAccesos);

	}

	/*
	 * @name: accesMainPageSPX
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Regresa a la pagina principal de SPX previa sincronizacion con
	 * overlays de bloqueo (blockUI), retorna al dashboard de inicio y recopila
	 * evidencia visual.
	 */
	public TreeMap<String, String> accesMainPageSPX() throws InterruptedException {
		reporterLog("Access to Main Page SPX ...");
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForBlockUIToDisappear();
		isDisplayed(iconMainPageSPX);
		TreeMap<String, String> evidence = returnSaveImage(iconMainPageSPX);
		click(iconMainPageSPX);
		return evidence;
	}

	/*
	 * @name: accesToCreateNewArticleAlmacen
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Navega a traves del menu Requisiciones para ingresar a la
	 * pantalla de Creacion de Nuevo Articulo de Almacen y retorna la captura de
	 * pantalla generada.
	 */
	public TreeMap<String, String> accesToCreateNewArticleAlmacen() {
		reporterLog("Access to Spot Buy Requisitions ...");
		click(iconMenu);
		waitForElementPresent(iconMenuRequisitions);
		click(iconMenuRequisitions);
		waitForElementPresent(iconMenuRequisitionsCreateRequisition);
		click(iconMenuRequisitionsCreateRequisition);
		waitForElementPresent(iconMenuRequisitionCreateNewArticleAlmacen);
		click(iconMenuRequisitionCreateNewArticleAlmacen);
		return returnSaveImage(iconMenuRequisitionCreateNewArticleAlmacen);
	}
}
