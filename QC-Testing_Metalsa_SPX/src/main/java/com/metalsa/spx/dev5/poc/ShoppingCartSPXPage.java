package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
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
	By checkRequisitionShoppingCart = By
			.xpath("//label[contains(., '" + GlobalVariablesSPX.SPX_DEV5_DESCRIPTION_SPOT_PAGE + "')]"
					+ "/ancestor::tr//input[contains(@id, 'simpleCheck0')]");
	By checkRequisitionShoppingCartNewLine = By.id("formCarroCompras:carroCompra0:1:simpleCheck0");
	By txtCommentsShoppingCart = By.id("formCarroCompras:carroCompra0:0:txtObservaciones");
	By btnSetupPurchase = By.xpath(
			"//div[@class='col-md-12 crear-req-rail']//button[@type='submit'][@role='button'][@aria-disabled='false']");
	By txtDescription = By.id("formSpot:desc_1");

	/*
	 * @name: textShoppingCartPageIsDisplayed
	 *
	 * @date: 30/Oct/2023
	 *
	 * @param: N/A
	 *
	 * @return: boolean
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description:
	 *
	 * Navega al carrito de compras y valida que la pantalla principal del carrito
	 * se encuentre visible.
	 *
	 * El método mantiene compatibilidad con los TestCases existentes retornando
	 * TRUE/FALSE.
	 *
	 * La evidencia se genera internamente para documentar el acceso y la validación
	 * visual del encabezado.
	 */
	public boolean textShoppingCartPageIsDisplayed() throws InterruptedException {

		reporterLog("[ACTION] Open Shopping Cart");

		waitForElementPresent(btnShoppingCart);

		safeEvidence(btnShoppingCart, "Shopping Cart - Before Access");

		click(btnShoppingCart);

		waitForPrimefacesAjax();

		waitForElementPresent(textShoppingCart);

		safeEvidence(textShoppingCart, "Shopping Cart - Page Loaded");

		boolean displayed = isDisplayed(textShoppingCart);

		if (displayed) {

			reporterLog("[SUCCESS] Shopping Cart page displayed.");

		} else {

			logFrameworkErrorSimple("[ERROR] Shopping Cart page NOT displayed.");
		}

		return displayed;
	}

	/*
	 * @name: clickSetupPurchaseSpotRequisitionShoppingCart
	 *
	 * @date: 28/Oct/2023
	 *
	 * @param: N/A
	 *
	 * @return: TreeMap<String,String> evidence
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description:
	 *
	 * Selecciona la opción Setup Purchase asociada a una requisición del carrito.
	 *
	 * Se genera evidencia completa antes y después de la interacción.
	 */
	public TreeMap<String, String> clickSetupPurchaseSpotRequisitionShoppingCart() throws InterruptedException {

		return clickWithEvidence(btnSetupPurchase, "Select Setup Purchase");
	}

	/*
	 * @name: CheckSpotRequisitionShoppingCart
	 *
	 * @date: 28/Oct/2023
	 *
	 * @param: N/A
	 *
	 * @return: TreeMap<String,String> evidence
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description:
	 *
	 * Selecciona una requisición disponible dentro del carrito de compras.
	 *
	 * Se documenta evidencia previa y posterior para garantizar trazabilidad QA.
	 */
	public TreeMap<String, String> CheckSpotRequisitionShoppingCart() throws InterruptedException {

		return clickWithEvidence(checkRequisitionShoppingCart, "Select Shopping Cart Requisition");
	}

	/*
	 * @name: DoubleCheckSpotRequisitionShoppingCart
	 *
	 * @date: 28/Oct/2023
	 *
	 * @param: N/A
	 *
	 * @return: TreeMap<String,String> evidence
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description:
	 *
	 * Ejecuta la doble selección requerida por el flujo funcional de requisiciones.
	 *
	 * Algunas configuraciones PrimeFaces generan una segunda fila dinámica que debe
	 * seleccionarse para completar la acción.
	 *
	 * El método conserva evidencia completa de ambas interacciones.
	 */
	public TreeMap<String, String> DoubleCheckSpotRequisitionShoppingCart() throws InterruptedException {

		TreeMap<String, String> evidence = new TreeMap<>();

		evidence.putAll(clickWithEvidence(checkRequisitionShoppingCart, "First Requisition Selection"));

		evidence.putAll(clickWithEvidence(checkRequisitionShoppingCartNewLine, "Second Requisition Selection"));

		return evidence;
	}
}
