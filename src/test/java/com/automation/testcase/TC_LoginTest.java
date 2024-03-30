package com.automation.testcase;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.CaptureScreenshot;
import com.automation.utils.PropertiesFileUtils;

public class TC_LoginTest extends DriverInstance{

    @Test(dataProvider= "Excel")
	public void TC01_LoginFirstAccount(String email, String password) throws Exception{
    	WebDriverWait wait = new WebDriverWait(driver, 5);
		
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		loginPage.clickIconSignin();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSignin();

		
		WebElement iconSignOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFileUtils.fetchLocatorValue("icon_signout_xpath"))));
		Assert.assertEquals(true, iconSignOut.getText().contains("Logout"), "Login failed!");
		
		loginPage.clickIconSignout();
	}
    
    @DataProvider(name= "Excel")
    public Object[][] testDataGenerator() throws Exception {
    	FileInputStream file = new FileInputStream("./data/assignment2_data_test.xlsx");
    	XSSFWorkbook workBook = new XSSFWorkbook(file);
    	XSSFSheet loginSheet = workBook.getSheet("Login");
    	int numberOfRows = loginSheet.getPhysicalNumberOfRows();
    	
    	Object [][] data = new Object[numberOfRows][2];
    	
    	for(int i=0;i<numberOfRows;i++) {
    		XSSFRow row = loginSheet.getRow(i);
    		XSSFCell mail = row.getCell(0);
    		XSSFCell pass= row.getCell(1);
    		data[i][0] = mail.getStringCellValue();
    		data[i][1] = pass.getStringCellValue();
    	}
    	return data;
    }
    
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws InterruptedException {
    	
    	Thread.sleep(1000);
    	if(ITestResult.FAILURE == result.getStatus()) {
    		try {
    			String email = (String) result.getParameters()[0];
    			int index = email.indexOf("@");
    			String accountName = email.substring(0, index);
    			String filePath = CaptureScreenshot.takeScreenshot(driver, accountName);
    			System.out.println("Da chup man hinh: " + accountName);
    			CaptureScreenshot.attachScreenshotToReport(filePath);
    		}catch(Exception e) {
    			System.out.println("Loi xay ra screenshot" + e.getMessage());
    		}
    	}
    }
}
