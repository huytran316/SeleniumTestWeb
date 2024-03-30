package com.automation.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CaptureScreenshot {
	
	public static String takeScreenshot(WebDriver driver, String name) {
		String filePath = "";
		
		try {
			BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); 
			String imageName = name + ".png";
			filePath = "./screenshots/" + imageName;
			File destiny = new File(filePath);
			ImageIO.write(img, "png", destiny);
		}catch(Exception ex) {
			System.out.println("Da xay ra loi khi chup man hinh");
			ex.printStackTrace();
		}
		
		return filePath;
	}
	
	public static void attachScreenshotToReport(String filePath) {
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			File f = new File(filePath);
			f.getName();
			
			Reporter.log(
					" <a title= \"snapshot\" href=\"" +f.getAbsolutePath()+"\">" +
							"<img width=\"418\" height=\"240\" alt='"+f.getName()+"' title=\"title\" src='D:\\Huy_study_documents\\Mon4\\Lab\\ASSIGNMENT_2_SELENIUM\\screenshots\\"+f.getName()+"' </a>");
			
		}catch(Exception e){
			System.out.println("Not able to take screenshot");
		}
	}
}
