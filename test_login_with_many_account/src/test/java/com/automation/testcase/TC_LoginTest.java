package com.automation.testcase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.PropertiesFileUtils;
import com.automation.utils.dataGenerator;

public class TC_LoginTest extends DriverInstance{
	@Test (dataProvider = "excel",dataProviderClass = dataGenerator.class)
	public void TC01_LoginFirstAccount(String email, String pass) {
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
	//	LoginPage loginPage= new LoginPage(driver);
		String url =PropertiesFileUtils.getProperty("url", "configs");
		driver.get(url);
		loginPage.checkIconLogin(driver);
		loginPage.enterEmail(driver,email);
		loginPage.enterPassword(driver,pass);
		loginPage.clickSignIn(driver);  
		loginPage.checkIconLogout(driver);
		loginPage.clickLogout(driver);
	}



}

