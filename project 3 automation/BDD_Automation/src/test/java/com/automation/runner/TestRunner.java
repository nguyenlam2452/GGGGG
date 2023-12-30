package com.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFile",
					monochrome = true,dryRun = false, 
						glue = "com.automation.step",
						plugin = {"pretty",
									"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}
)

public class TestRunner {
	@BeforeClass
	public static void setReportConfiguration() {
		ExtentProperties expro = ExtentProperties.INSTANCE;
		expro.setReportPath("./Report/Report.html");
	}
	
	@AfterClass
	public static void setSystemInformation() {
		Reporter.loadXMLConfig("./configuration/extent-config.xml");
	}
}
