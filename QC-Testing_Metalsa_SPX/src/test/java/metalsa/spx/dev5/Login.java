package metalsa.spx.dev5;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Login {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Antes de Test 001");
	}

	@Test
	public void TC001_Login() {
		Reporter.log("Step 1 - Launch Browser and maximize SPX dev5");
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOpt);

		driver.get("http://gpmtest2-app6:9203/SPX/");
		driver.manage().window().maximize();

		Reporter.log("Step 2 - Enter username and password");
		// id="formLogin:idUsuario"
		// id="formLogin:pass"
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("formLogin:idUsuario")));
		driver.findElement(By.id("formLogin:idUsuario")).sendKeys("edna.garza@metalsa.com");
		driver.findElement(By.id("formLogin:pass")).sendKeys("1234");

		Reporter.log("Step 3 - Click button Entrar");
		// id="formLogin:btnForm"
		driver.findElement(By.id("formLogin:btnForm")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-bars gn-icon-menu']")));

		Reporter.log("Step 4 - Validate acces to spx");
		//// i[@class="fa fa-bars gn-icon-menu"]
		boolean profilePictureIsDisplayed = driver.findElement(By.xpath("//i[@class='fa fa-bars gn-icon-menu']"))
				.isDisplayed();
		Assert.assertEquals(profilePictureIsDisplayed, true);
		
		driver.close();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Despues Test 001");
	}

}
