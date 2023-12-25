package com.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtils {
	private static String CONFIG_PATH ;

	
	public static String getProperty(String key,String util) {
		if (util.equals("configs")) {
			CONFIG_PATH = "./configuration/configs.properties";
		}
		else if (util.equals("locator")) {
			CONFIG_PATH = "./configuration/locator.properties";
		}

		Properties properties = new Properties();
		String value = null;
		FileInputStream fileInputStream =null;
		try {
			fileInputStream =new FileInputStream(CONFIG_PATH);
			properties.load(fileInputStream);
			value =  properties.getProperty(key);
			return value;
		} catch (Exception e) {
			System.out.println("khong lay duoc gia tri cua "+key);
			e.printStackTrace();
		}finally {
			if (fileInputStream !=null) {
				try {
					fileInputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		}
		return value;
	}
	
	
}
