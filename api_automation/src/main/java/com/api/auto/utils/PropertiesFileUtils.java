package com.api.auto.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFileUtils {
private static String CONFIG_PATH="./configuration/configs.properties" ;
private static String TOKEN_PATH ="./configuration/token.properties";

	
	public static String getProperty(String key ) {
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
	public static void saveToken(String key, String value) {
		Properties properties=new Properties();
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(TOKEN_PATH);
			properties.setProperty(key, value); 
			properties.store(fileOutputStream, "them gia tri moi vao property");
			System.out.println("them oke");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fileOutputStream!=null) {
				try {
					fileOutputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}
	public static String getToken(String key ) {
		Properties properties = new Properties();
		String value = null;
		FileInputStream fileInputStream =null;
		try {
			fileInputStream =new FileInputStream(TOKEN_PATH);
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
