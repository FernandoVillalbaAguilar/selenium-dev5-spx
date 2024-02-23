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
	// Administración del sistema
	By iconMenuAdministracionDelSistema = By.xpath("//a[@href='#_menu_182']");
	By iconMenuAdministradorTI = By.xpath("//a[@href='#_menu_183']");
	By iconMenuAdministradorRolesMenu = By.xpath("//a[@href='http://gpmtest2-app6:9203/SPX/pages/administracion/rolesMenu/index.xhtml']");
	By iconMenuAdministradorMenu = By.xpath("//a[@href='http://gpmtest2-app6:9203/SPX/pages/administracion/menu/index.xhtml']");
	By iconMenuArticulosControlados = By.xpath("//a[@href='http://gpmtest2-app6:9203/SPX/pages/administracion/itemsControlados.xhtml']");
	// Requisiciones
	By iconMenuRequisitions = By.xpath("//a[@href='#_menu_191']");
	By iconMenuRequisitionsCreateRequisition = By.xpath("//a[@href='#_menu_192']");
	By iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions = By
			.xpath("//a[@href='http://gpmtest2-app6:9203/SPX//pages/spot/index.xhtml']");

	/*
	 * @name: menuHeaderHomeIsDisplayed
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(menuHeaderHome);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean menuHeaderHomeIsDisplayed() {
		reporterLog("Access to SPX ...");
		waitForElementPresent(iconMenu);
		return isDisplayed(iconMenu);
	}

	/*
	 * @name: selectToUenFromHome
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite seleccionar una UEN
	 */

	public TreeMap<String, String> selectToUenFromHome() throws InterruptedException {
		reporterLog("Access to Spot Buy Requisitions ...");
		waitForElementPresent(selectUEN);
		click(selectUEN);
		waitForElementPresent(optUEN);
		click(optUEN);
		return returnSaveImage(optUEN);
	}

	// Access to Menu's
	/*
	 * @name: accesToAdministradorRolesMenu
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite acceder a la pagina indicada
	 */
	public TreeMap<String, String> accesToAdministradorRolesMenu() {
		reporterLog("Access to Administrador Roles Menu ...");
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
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite acceder a la pagina indicada
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
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite acceder a la pagina indicada
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
	 * @name: accesToSpotBuyRequisitions
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite acceder a la pagina indicada
	 */
	public TreeMap<String, String> accesToSpotBuyRequisitions() {
		reporterLog("Access to Spot Buy Requisitions ...");
		click(iconMenu);
		waitForElementPresent(iconMenuRequisitions);
		click(iconMenuRequisitions);
		waitForElementPresent(iconMenuAdministradorTI);
		click(iconMenuRequisitionsCreateRequisition);
		waitForElementPresent(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
		click(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
		return returnSaveImage(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
	}
}
