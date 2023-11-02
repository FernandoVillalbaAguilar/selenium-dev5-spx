package com.metalsa.spx.dev5.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
	By txtCommentsShoppingCart = By.id("formCarroCompras:carroCompra0:0:txtObservaciones");
	By btnSetupPurchase = By.id("formCarroCompras:j_idt823");
	By textValidateSameLine = By.xpath("//div[@class='ui-growl-message']");

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
		try {
			reporterLog("Access to Shopping Page ...");
			if (isDisplayed(textValidateSameLine)) {
				System.out.println("The Same Name Line Exist");
				Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
				click(btnShoppingCart);
				waitForElementPresent(textShoppingCart);
				return isDisplayed(textShoppingCart);
			} else {
				System.out.println("The Name Line is New");
				click(btnShoppingCart);
				waitForElementPresent(textShoppingCart);
				return isDisplayed(textShoppingCart);
			}

		} catch (TimeoutException e) {
			e.printStackTrace();
			return false;

		}
	}

	/*
	 * @name: selectRequisitionShoppingCart
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
	public void selectSpotRequisitionShoppingCart() throws InterruptedException {
		try {
			reporterLog("Select Requisition of Shopping Cart");
			waitForElementPresent(checkRequisitionShoppingCart);
			click(checkRequisitionShoppingCart);
			Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
			waitForElementPresent(btnSetupPurchase);
			click(btnSetupPurchase);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
