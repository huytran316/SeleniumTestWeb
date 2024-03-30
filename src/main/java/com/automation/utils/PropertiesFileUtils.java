package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
	
	public static Object fetchPropertyValue(String key) throws IOException {
		FileInputStream file = new FileInputStream("./configuration/configs.properties");
		Properties property = new Properties();
		property.load(file);
		return property.get(key);
	}
	
	public static String fetchLocatorValue(String key) throws IOException {
		FileInputStream file = new FileInputStream("./configuration/Elements.properties");
		Properties property = new Properties();
		property.load(file);
		return property.get(key).toString();
	}
}
