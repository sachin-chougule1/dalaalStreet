package com.qa.TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	public TestBase() {
		PageFactory.initElements(driver, this);
	}

	@BeforeMethod
	public void setUp() {
		String browser="chrome";
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.apps.dalalstreet.ai/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
