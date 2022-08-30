package com.qa.TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.PageLayer.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	public static LoginPage login;
	public TestBase() {
		PageFactory.initElements(driver, this);
	}

	@BeforeMethod
	public void setUp() {

		String browser="chrome";

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}

		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver= new EdgeDriver();
		}

		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver= new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.apps.dalalstreet.ai/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		login=new LoginPage();
		login.enterUserName("amarwaghmare573@gmail.com");
		login.enterPassword("Test@1234");
		login.clickLoinButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
