package com.automation.base;


import java.util.concurrent.TimeUnit;

import com.automation.utils.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	protected WebDriver driver;
	protected int n;
	@BeforeClass
	public void initDriverInstance() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void takeScreenShot(ITestResult result) {
		if (ITestResult.FAILURE==result.getStatus()) {
			try {
				new CaptureScreenshot().takeScreenShot(driver, result.getName()+n);
				n++;
			} catch (Exception e) {
				System.out.println("khong chup duoc");
			}
		}
	}
	@AfterClass
	public void closeDriverInstance() {
		n=0;
		driver.close();
	}

}
