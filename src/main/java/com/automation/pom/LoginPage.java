package com.automation.pom;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.PropertiesFileUtils;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}
	public void enterMST() throws Exception{
		WebElement inputMST = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mst1")));
		inputMST.sendKeys("adb");
	}
	
	public void clickButton() throws Exception{
		WebElement clickButon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value class='subBtn']")));
		clickButon.click();
	}
	public void clickIconSignin() throws Exception{
		
		WebElement iconSignin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFileUtils.fetchLocatorValue("icon_signin_xpath"))));
		iconSignin.click();
//		Thread.sleep(2000);
	}
	public void enterEmail(String email) throws Exception {
		
		WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFileUtils.fetchLocatorValue("login_email_xpath"))));
		inputEmail.sendKeys(email);
//		Thread.sleep(2000);
	}
	
	public void enterPassword(String password) throws Exception {
		
		WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFileUtils.fetchLocatorValue("login_password_xpath"))));
		inputPassword.sendKeys(password);
//		Thread.sleep(2000);
	}
	
	public void clickSignin() throws Exception {
		
		WebElement btnSignIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFileUtils.fetchLocatorValue("login_signin_xpath"))));
		btnSignIn.click();
//		Thread.sleep(2000);
	}
	
	public void clickIconSignout() throws Exception{
		
		WebElement iconSignOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFileUtils.fetchLocatorValue("icon_signout_xpath"))));
		iconSignOut.click();
//		Thread.sleep(2000);
	}
}
