package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class AdministradorMenuSPXPage extends SPXBase {

	public AdministradorMenuSPXPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By txtFielSetPage = By.id("fFilter");
	By inputMenuName = By.id("fFilter:j_idt65");
	By inputURLPath = By.id("fFilter:j_idt67");
	By btnSearch = By.id("fFilter:j_idt73");
	By nameResult = By
			.xpath("//td[normalize-space()='" + GlobalVariablesSPX.SPX_DEV5_MENU_NAME_ADMINISTRATION_MENU_PAGE + "']");
	By urlPathResult = By
			.xpath("//td[normalize-space()='" + GlobalVariablesSPX.SPX_DEV5_URL_PATH_ADMINISTRATION_MENU_PAGE + "']");
	By btnAddNewMenu = ById.id("j_idt151:j_idt153");
	By esaMenuAddNewMenu = By.xpath("(//td[@role='gridcell'])[3]");
	By iconEditMenu = By.xpath("//div[@id='fList:j_idt81:0:j_idt147']//span[@class='ui-icon ui-icon-pencil']");
	By txtNameMenu = By.id("fList:j_idt81:0:j_idt98");
	By txtDescrESA = By.id("fList:j_idt81:0:j_idt99:0:j_idt109");
	By txtDescrUS = By.id("fList:j_idt81:0:j_idt99:1:j_idt109");
	By txtDescrPTB = By.id("fList:j_idt81:0:j_idt99:2:j_idt109");
	By lblCategory = By.id("fList:j_idt81:0:j_idt113_label");
	By slstCategory = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_CATEGORY_ADMINISTRATION_MENU_PAGE);
	By txtOrder = By.id("fList:j_idt81:0:j_idt119");
	By txtCssClass = By.id("fList:j_idt81:0:j_idt123");
	By txtFaces = By.id("fList:j_idt81:0:j_idt127");
	By lblParent = By.id("fList:j_idt81:0:j_idt131_label");
	By txtParent = By.id("fList:j_idt81:0:j_idt131_filter");
	By slstParent = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_PARENT_ADMINISTRATION_MENU_PAGE);
	By lblActive = By.id("fList:j_idt81:0:j_idt137_label");
	By slstActive = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_ACTIVE_ADMINISTRATION_MENU_PAGE);
	By slstInactive = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_INACTIVE_ADMINISTRATION_MENU_PAGE);
	By lblMenuRoot = By.id("fList:j_idt81:0:j_idt143_label");
	By slstMenuRoot = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_MENU_ROOT_ADMINISTRATION_MENU_PAGE);
	By slstMenuSimple = By.xpath(GlobalVariablesSPX.SPX_DEV5_SELECT_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE);
	By btnCheck = By.xpath("//div[@id='fList:j_idt81:0:j_idt147']//span[@class='ui-icon ui-icon-check']");
	By btnClose = By.xpath("//div[@id='fList:j_idt81:0:j_idt147']//span[@class='ui-icon ui-icon-close']");
	By msgMessage=By.id("fList:j_idt80");
	By btnRemove = By.id("fList:j_idt81:0:j_idt149");

	/*
	 * @name: textAdministradorMenuPageIsDisplayed
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
	public boolean textAdministradorMenuPageIsDisplayed() {
		reporterLog("Access to Administrador Menu Page ...");
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
	 * @return: isDisplayed(nameResult);
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
	 * @param: String urlPath
	 * 
	 * @return: isDisplayed(btnSearch);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> filterURLPath(String urlPath) {
		reporterLog("Realizar Búsqueda con el Filtro URL Path ...");
		waitForElementPresent(inputMenuName);
		type(inputURLPath, urlPath);
		waitForElementPresent(btnSearch);
		click(btnSearch);
		return returnSaveImage(btnSearch);
	}

	/*
	 * @name: validationResultSearchURLPathIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(urlPathResult);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean validationResultSearchURLPathIsDisplayed() {
		reporterLog("Validate Result Search Is Displayed ...");
		waitForElementPresent(urlPathResult);
		return isDisplayed(urlPathResult);
	}

	/*
	 * @name: clickbtnAddNewMenu
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String urlPath
	 * 
	 * @return: isDisplayed(btnAddNewMenu);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> clickbtnAddNewMenu() throws InterruptedException {
		reporterLog("Agregar Nuevo Menu ...");
		waitForElementPresent(btnAddNewMenu);
		click(btnAddNewMenu);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnAddNewMenu);
	}

	/*
	 * @name: validationResultSearchAddNewMneuIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(nameMenuAddNewMenu);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean validationResultSearchAddNewMneuIsDisplayed() {
		reporterLog("Validate Result Search Is Displayed ...");
		waitForElementPresent(esaMenuAddNewMenu);
		return isDisplayed(esaMenuAddNewMenu);
	}

	/*
	 * @name: editMenus
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String urlPath
	 * 
	 * @return: isDisplayed(btnAddNewMenu);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> editMenus(String nameMenuText, String descriptionESA, String descriptionUS,
			String descriptionPTB, String order, String cssClass, String faces, String parent)
			throws InterruptedException {
		reporterLog("Agregar Nuevo Menu ...");
		waitForElementPresent(iconEditMenu);
		click(iconEditMenu);
		waitForElementPresent(txtNameMenu);
		type(txtNameMenu, nameMenuText);
		waitForElementPresent(txtDescrESA);
		type(txtDescrESA, descriptionESA);
		waitForElementPresent(txtDescrUS);
		type(txtDescrUS, descriptionUS);
		waitForElementPresent(txtDescrPTB);
		type(txtDescrPTB, descriptionPTB);
		waitForElementPresent(lblCategory);
		click(lblCategory);
		waitForElementPresent(slstCategory);
		click(slstCategory);
		waitForElementPresent(txtOrder);
		type(txtOrder, order);
		waitForElementPresent(txtCssClass);
		type(txtCssClass, cssClass);
		waitForElementPresent(txtFaces);
		type(txtFaces, faces);
		waitForElementPresent(lblParent);
		click(lblParent);
		waitForElementPresent(txtParent);
		type(txtParent, parent);
		waitForElementPresent(slstParent);
		click(slstParent);
		waitForElementPresent(lblActive);
		click(lblActive);
		waitForElementPresent(slstActive);
		click(slstActive);
		waitForElementPresent(lblMenuRoot);
		click(lblMenuRoot);
		waitForElementPresent(slstMenuRoot);
		click(slstMenuRoot);
		waitForElementPresent(btnCheck);
		click(btnCheck);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnCheck);
	}
	
	/*
	 * @name: validationMessagesIsDisplayed
	 * 
	 * @date: 15/Feb/2024
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(msgMessage);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean validationMessagesIsDisplayed() {
		reporterLog("Validate Message Is Displayed ...");
		waitForElementPresent(msgMessage);
		return isDisplayed(msgMessage);
	}

	/*
	 * @name: clickRemoveMenu
	 * 
	 * @date: 16/Feb/2024
	 * 
	 * @param: String urlPath
	 * 
	 * @return: isDisplayed(btnRemove);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public TreeMap<String, String> clickRemoveMenu() {
		reporterLog("Agregar Nuevo Menu ...");
		waitForElementPresent(btnRemove);
		click(btnRemove);
		return returnSaveImage(btnRemove);
	}
}
