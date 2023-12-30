package com.automation.step;

import com.automation.base.DriverInstance;
import com.automation.ulti.CaptureScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends DriverInstance{
	protected int n=1;
	@After(order = 1)
	public void takeScraenshotOnFailure(Scenario scenario) {
	if (scenario.isFailed()) {
		try {
			
			new CaptureScreenshot().takeScreenShot(driver, scenario.getName()+n);
			n++;
			
		} catch (Exception e) {
			System.out.println("khong chup duoc");
			
		}
		
	}

	}

	@After(order = 2)
	public void tearDown()  {
		
		driver.close();

	}
}
