package metalsa.spx.dev5.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import metalsa.spx.dev5.main.SPXBase;

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
	 * @description: Este metodo permite capturar usuario y contraseña, así como dar click en el botón login
	 */
	public void login(String username, String password) {
		waitForElementPresent(btnLogin);
		type(txtUsername, username);
		type(txtPassword, password);
		click(btnLogin);
		
	}
}
