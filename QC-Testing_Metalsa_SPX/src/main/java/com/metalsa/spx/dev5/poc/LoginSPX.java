package com.metalsa.spx.dev5.poc;

import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class LoginSPX extends SPXBase {

	public LoginSPX(WebDriver driver) {
		super(driver);
	}

	// Objects
	By txtUsername = By.id("formLogin:idUsuario");
	By txtPassword = By.id("formLogin:pass");
	By btnLogin = By.id("formLogin:btnForm");

	/*
	 * @name: login
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: String username, String password
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite capturar usuario y contraseña, así como dar
	 * click en el botón login
	 */
	public void login(String username, String password) throws InterruptedException {
		reporterLog("Logging to SPX ...");
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		waitForElementPresent(btnLogin);
		type(txtUsername, getEncrypted(username));
		type(txtPassword, getEncrypted(password));
		click(btnLogin);
	}
}
