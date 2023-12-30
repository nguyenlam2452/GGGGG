package com.automation.step;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.automation.base.DriverInstance;
import com.automation.page.login;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition  {
	
	protected WebDriver driver= DriverInstance.initDriverInstance();
	protected login lgLogin =PageFactory.initElements(driver, login.class);
	protected int n=0;
	
	@Given("^user is on login pages$")
	public void user_is_on_login_pages() throws Throwable {
		lgLogin.access_to_login_page(driver);	
		lgLogin.checkIconLogin(driver);
	}


	@When("^user enter email \"([^\"]*)\"$")
	public void user_enter_email(String arg1) throws Throwable {
	  lgLogin.enterEmail(driver, arg1);
	}

	@When("^user enter password \"([^\"]*)\"$")
	public void user_enter_password(String arg1) throws Throwable {
		lgLogin.enterPassword(driver, arg1);
	}


	@When("^user click signin button$")
	public void user_click_signin_button() throws Throwable {
		lgLogin.clickSignIn(driver);	
	}

	@Then("^user should be logged in$")
	public void user_should_be_logged_in() throws Throwable {
		lgLogin.checkIconLogout(driver);
		lgLogin.checkIconLogout(driver);
		
	}
	@Then("^the status must be visible$")
	public void the_status_must_be_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	

}
