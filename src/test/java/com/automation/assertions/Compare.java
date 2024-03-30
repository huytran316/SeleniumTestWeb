package com.automation.assertions;

import org.openqa.selenium.WebDriver;

import freemarker.core.ReturnInstruction.Return;

public class Compare {

		public static boolean validatePageURL(WebDriver driver, String expURL) {
			
			boolean flag = false;
			if(driver.getCurrentUrl().equalsIgnoreCase(expURL)){
				flag = true;
			}
			
			return flag;
		}
		
		public static boolean validatePageTitle(WebDriver driver, String expTitle) {
			
			boolean flag = false;
			if(driver.getTitle().equalsIgnoreCase(expTitle)){
				flag = true;
			}
			
			return flag;
		}
}
