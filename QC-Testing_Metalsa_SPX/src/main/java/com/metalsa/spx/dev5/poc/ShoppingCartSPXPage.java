package com.metalsa.spx.dev5.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class ShoppingCartSPXPage extends SPXBase {

	public ShoppingCartSPXPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By textShoppingCart = By.xpath("//div[@class='carro-compras-steps--name']");
	By btnShoppingCart = By.id("spxBusquedaMenu:btn-ir-carro-compra");
	By checkRequisitionShoppingCart = By.id("formCarroCompras:carroCompra0:0:simpleCheck0");
	By checkRequisitionShoppingCartNewLine = By.id("formCarroCompras:carroCompra0:1:simpleCheck0");
	By txtCommentsShoppingCart = By.id("formCarroCompras:carroCompra0:0:txtObservaciones");
	By btnSetupPurchase = By.xpath(
			"//div[@class='col-md-12 crear-req-rail']//button[@type='submit'][@role='button'][@aria-disabled='false']");
	By txtDescription = By.id("formSpot:desc_1");

	/*
	 * @name: textSpotBuyRequisitionsPageIsDisplayed
	 * 
	 * @date: 30/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtSpotBuyRequisitionsPage);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento está disponible
	 */
	public boolean textShoppingCartPageIsDisplayed() throws InterruptedException {
		reporterLog("Access to Shopping Page ...");
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnShoppingCart);
		click(btnShoppingCart);
		waitForElementPresent(textShoppingCart);
		return isDisplayed(textShoppingCart);
	}

	/*
	 * @name: clickSetupPurchaseSpotRequisitionShoppingCart
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite ingresar al carrito de compras y
	 * seleccionar una requisición
	 */
	public void clickSetupPurchaseSpotRequisitionShoppingCart() throws InterruptedException {
		reporterLog("Select Requisition of Shopping Cart");
		waitForElementPresent(btnSetupPurchase);
		click(btnSetupPurchase);
	}

	/*
	 * @name: CheckSpotRequisitionShoppingCart
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite ingresar al carrito de compras y
	 * seleccionar una requisición
	 */
	public void CheckSpotRequisitionShoppingCart() throws InterruptedException {
		reporterLog("Check Requisition of Shopping Cart");
		waitForElementPresent(checkRequisitionShoppingCart);
		click(checkRequisitionShoppingCart);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
	}

	/*
	 * @name: CheckSpotRequisitionShoppingCart
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite ingresar al carrito de compras y
	 * seleccionar una requisición
	 */
	public void DoubleCheckSpotRequisitionShoppingCart() throws InterruptedException {
		reporterLog("Check Requisition of Shopping Cart");
		waitForElementPresent(checkRequisitionShoppingCart);
		click(checkRequisitionShoppingCart);
		waitForElementPresent(checkRequisitionShoppingCartNewLine);
		click(checkRequisitionShoppingCartNewLine);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
	}
}
