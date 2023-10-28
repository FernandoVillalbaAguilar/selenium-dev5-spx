package metalsa.spx.dev5.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import metalsa.spx.dev5.main.SPXBase;

public class HomeSPX extends SPXBase{

	public HomeSPX(WebDriver driver) {
		super(driver);
	}
	
	//Object
	By iconMenu = By.xpath("//i[@class='fa fa-bars gn-icon-menu']");
	
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
		return isDisplayed(iconMenu);
	}
}
