package com.automation.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.utils.PropertiesFileUtils;

public class LoginPage  {
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		wait=new WebDriverWait(driver, 30);
	}
	
	public void  enterEmail( WebDriver driver,String email) {
		String locator = PropertiesFileUtils.getProperty("email_xpath","locator");
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(email);
			
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}

	}
	public void   enterPassword( WebDriver driver,String pass) {
		String locator = PropertiesFileUtils.getProperty("pass_xpath","locator");
	
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(pass);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	public void clickSignIn(WebDriver driver) {
		String locator = PropertiesFileUtils.getProperty("btn_login_xpath","locator");

		try {
			WebElement element = driver.findElement(By.xpath(locator));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	public void checkIconLogin(WebDriver driver) {
		String locator = PropertiesFileUtils.getProperty("icon_signup","locator");
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			Assert.assertEquals(true, element.isDisplayed());
			Assert.assertEquals(true, element.getText().contains("Login"));
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
		
		
	}
	public void checkIconLogout(WebDriver driver) {
		String locator = PropertiesFileUtils.getProperty("icon_logout","locator");
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			Assert.assertEquals(true, element.isDisplayed());
			Assert.assertEquals(true, element.getText().contains("Logout"));
		
		} catch (Exception e) {
			
			Assert.fail();
			e.printStackTrace();
		}
		}

	public void clickLogout(WebDriver driver) {
		String locator = PropertiesFileUtils.getProperty("icon_logout","locator");
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			element.click();
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
;
	}
	
}
