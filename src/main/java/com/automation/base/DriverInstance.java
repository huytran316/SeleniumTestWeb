package com.automation.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.automation.utils.PropertiesFileUtils;

public class DriverInstance {
	public WebDriver driver;
	
	@BeforeClass
	public void initiateDriverInstance() throws Exception {
		if(PropertiesFileUtils.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drive/chromedriver.exe");
			driver =  new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}else {
			System.setProperty("webdriver.chrome.driver", "./drive/chromedriver.exe");
			driver =  new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		 
		driver.get(PropertiesFileUtils.fetchPropertyValue("base_url").toString());
	}
	
	@AfterClass
	public void closeDriverInstance() {
		System.out.println("Finish testing");
		driver.quit();
	}
}
