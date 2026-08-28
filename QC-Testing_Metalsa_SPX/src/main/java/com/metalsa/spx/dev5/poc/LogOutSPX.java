package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.metalsa.spx.dev5.main.SPXBase;

public class LogOutSPX extends SPXBase {

	public LogOutSPX(WebDriver driver) {
		super(driver);
	}

	// Objects
	By elmntAvalible = By.xpath("//div[@class='spx-main-logo']");
	By btnLogout = By
			.xpath("//div[contains(@class,'header-top')]//div[contains(@class,'h-logout')]//i[contains(@class,'out')]");

	/*
	 * @name: logout
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: String username, String password
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite hacer logout al sistema
	 */
	public TreeMap<String, String> logout() throws InterruptedException {
		reporterLog("LogOut to SPX ...");
		TreeMap<String, String> evidence = returnSaveImage(btnLogout);
		click(btnLogout);
		return evidence;
	}

	/*
	 * @name: mainPageIsDisplayed
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(menuHeaderHome);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento est� disponible
	 */
	public boolean mainPageIsDisplayed() {
		reporterLog("Access to SPX ...");
		waitForElementPresent(elmntAvalible);
		return isDisplayed(elmntAvalible);
	}
}
