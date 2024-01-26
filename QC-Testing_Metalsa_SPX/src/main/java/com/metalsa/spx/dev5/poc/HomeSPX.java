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
	By iconMenu = By.id("sidebarCollapse");
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
		waitForElementPresent(iconMenuRequisitionsCreateRequisition);
		click(iconMenuRequisitionsCreateRequisition);
		waitForElementPresent(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
		click(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
		return returnSaveImage(iconMenuRequisitionsCreateRequisitionSpotBuyRequisitions);
	}
}
