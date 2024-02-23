package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class AdministradorRolesMenuSPXPage extends SPXBase {

	public AdministradorRolesMenuSPXPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By txtFielSetPage = By.id("fRolesMenu:j_idt64");
	// All Roles Buttons
	By btnViewMenusSPX_ReporteInterUEN = By.id("fRolesMenu:dtRoles:0:j_idt71");
	By btnViewMenusPreAprobacionProyectos = By.id("fRolesMenu:dtRoles:1:j_idt71");
	// Menus of Rol: SPX - Reporte InterUEN
	By btnRemove = By.id("fRolesMenu:dtMenus:0:j_idt99");
	By txtAdd = By.xpath("//tbody[@id='fRolesMenu:dtMenus_data']//td[contains(text(),'"
			+ GlobalVariablesSPX.SPX_DEV5_MENU_NAME_ADMINISTRATION_ROLES_MENU_PAGE + "')]");
	By txtRemove = By.xpath("//tbody[@id='fRolesMenu:dtMenus_data']//td[contains(text(),'"
			+ GlobalVariablesSPX.SPX_DEV5_MENU_NAME_ADMINISTRATION_ROLES_MENU_PAGE + "')]");
	// Available Menus to Rol: SPX - Reporte InterUEN
	By inputMenuName = By.id("fRolesMenu:j_idt103");
	By inputURLPath = By.id("fRolesMenu:j_idt105");
	By btnShowAll = By.id("fRolesMenu:j_idt111");
	By btnSearch = By.id("fRolesMenu:j_idt114");
	By nameResult = By.xpath(
			"//td[normalize-space()='" + GlobalVariablesSPX.SPX_DEV5_MENU_NAME_ADMINISTRATION_ROLES_MENU_PAGE + "']");
	By urlPathResult = By.xpath(
			"//td[normalize-space()='" + GlobalVariablesSPX.SPX_DEV5_URL_PATH_ADMINISTRATION_ROLES_MENU_PAGE + "']");
	By btnAdd = By.id("fRolesMenu:dtMenusDisponibles:0:j_idt142");

	/*
	 * @name: textAdministradorRolesMenuPageIsDisplayed
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
	public boolean textAdministradorRolesMenuPageIsDisplayed() {
		reporterLog("Access to Administrador Role Menu Page ...");
		waitForElementPresent(txtFielSetPage);
		return isDisplayed(txtFielSetPage);
	}

	/*
	 * @name: filterMenuName
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String menuName
	 * 
	 * @return: isDisplayed(btnSearch);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> filterMenuName(String menuName) {
		reporterLog("Realizar Búsqueda con el Filtro Menu Name ...");
		waitForElementPresent(btnViewMenusSPX_ReporteInterUEN);
		click(btnViewMenusSPX_ReporteInterUEN);
		waitForElementPresent(btnShowAll);
		click(btnShowAll);
		waitForElementPresent(inputMenuName);
		type(inputMenuName, menuName);
		waitForElementPresent(btnSearch);
		click(btnSearch);
		return returnSaveImage(btnSearch);
	}

	/*
	 * @name: validationResultSearchNameResultIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(menuHeaderHome);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean validationResultSearchNameResultIsDisplayed() {
		reporterLog("Validate Result Search Is Displayed ...");
		waitForElementPresent(nameResult);
		return isDisplayed(nameResult);
	}

	/*
	 * @name: filterURLPath
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String menuName
	 * 
	 * @return: isDisplayed(urlPath);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> filterURLPath(String urlPath) {
		reporterLog("Realizar Búsqueda con el Filtro URL Path ...");
		waitForElementPresent(btnViewMenusSPX_ReporteInterUEN);
		click(btnViewMenusSPX_ReporteInterUEN);
		waitForElementPresent(btnShowAll);
		click(btnShowAll);
		waitForElementPresent(inputURLPath);
		type(inputURLPath, urlPath);
		waitForElementPresent(btnSearch);
		click(btnSearch);
		return returnSaveImage(btnSearch);
	}

	/*
	 * @name: validationResultSearchURLPathResultIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(menuHeaderHome);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean validationResultSearchURLPathResultIsDisplayed() {
		reporterLog("Validate Result Search Is Displayed ...");
		waitForElementPresent(urlPathResult);
		return isDisplayed(urlPathResult);
	}

	/*
	 * @name: btnAdd
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(btnAdd);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> btnAdd() throws InterruptedException {
		reporterLog("Realizar Búsqueda con el Filtro Menu Name ...");
		waitForElementPresent(btnAdd);
		click(btnAdd);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnAdd);
	}

	/*
	 * @name: validationAddIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtAdd);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean validationAddIsDisplayed() {
		reporterLog("Validar el agregar registro de manera correcta ...");
		waitForElementPresent(txtAdd);
		return isDisplayed(txtAdd);
	}

	/*
	 * @name: btnRemove
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(btnRemove);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> btnRemove() {
		reporterLog("Realizar Búsqueda con el Filtro Menu Name ...");
		waitForElementPresent(btnRemove);
		click(btnRemove);
		return returnSaveImage(btnRemove);
	}

	/*
	 * @name: validationRemoveIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtRemove);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean validationRemoveIsDisplayed() {
		reporterLog("Validar el remover registro de manera correcta ...");
		waitForElementPresent(txtRemove);
		return isDisplayed(txtRemove);
	}
}
