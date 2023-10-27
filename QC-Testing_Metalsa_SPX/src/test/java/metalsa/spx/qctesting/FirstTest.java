package metalsa.spx.qctesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
  @Test
  public void f() {
	  ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOpt);
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("El titulo de la ventana es "+title);
		Assert.assertEquals(driver.getTitle(), "Google");
  }
}
