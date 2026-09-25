package com.metalsa.spx.dev5.poc;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class IntercompañiaSolicitudSPXPage extends SPXBase {

	public IntercompañiaSolicitudSPXPage(WebDriver driver) {
		super(driver);
	}

	// =========================================================
	// OBJECTS - INTERCOMPAÑIA REQUISITIONS PAGE
	// =========================================================
	// @author: Fernando Villalba Aguilar
	// @description:
	// Locators organizados por secciones funcionales.
	//
	// Convenciones:
	// - btn -> Buttons
	// - lbl -> Labels / Selected dropdown labels
	// - txt -> Inputs / Filters
	// - chk -> Checkboxes
	// - pnl -> Panels
	// - opt -> Options
	// - slct -> Selectors
	//
	// PrimeFaces:
	// - *_label -> Valor seleccionado REAL del dropdown
	// - *_filter -> Input filtro interno del dropdown
	// - *_panel -> Panel desplegable
	// =========================================================

	// =========================================================
	// HEADER OBJECTS
	// =========================================================
	By btnBack = By.id("formSpot:j_idt341");
	By spanSpotBuyRequisitionsPage = By.xpath("//span[@class='spx-card-header__title']");
	By btnNewLine = By.id("formSpot:j_idt343");
	By btnAddToCart = By.id("formSpot:add-cart-btn");
	By msgErrorDocuments = By.xpath("(//div[contains(@class, 'ui-messages-error') and .//span[contains(@class, 'ui-messages-error-summary')]])[1]");


	// =========================================================
	// LINE HEADER OBJECTS
	// =========================================================
	By btnExpandCollapse = By.id("header-for-each1");
	By btnDeleteLine = By.id("formSpot:j_idt366");

	// =========================================================
	// FIRST SECTION OBJECTS
	// =========================================================
	By txtDescription = By.id("formSpot:desc_1");
	By lblFabricaMetales = By.id("formSpot:listUen1_label");
	By optFabricanteMetales = By.xpath("");
	
	
	// =========================================================
	// SECOND SECTION OBJECTS
	// =========================================================

}
