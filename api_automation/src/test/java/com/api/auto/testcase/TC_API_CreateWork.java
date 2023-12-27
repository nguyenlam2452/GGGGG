package com.api.auto.testcase;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.auto.utils.PropertiesFileUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_API_CreateWork {
	private String myWork ;
	private String myExperience ;
	private String myEducation ;
	private Response response;
	private ResponseBody responseBody;
	private JsonPath jsonBody;

	@BeforeClass
	public void init_API_CreateWork() {
		TC_API_Login tc = new TC_API_Login();
		tc.init();
		PropertiesFileUtils pFileUtils;
		pFileUtils=new PropertiesFileUtils();
		String baseUrl=tc.getBaseUrl();
		String loginPath= pFileUtils.getProperty("createWorkPath");
		myWork = pFileUtils.getProperty("nameWork");
		myExperience=pFileUtils.getProperty("experience");
		myEducation=pFileUtils.getProperty("education");
		
		RestAssured.baseURI= baseUrl;
		RestAssured.basePath=loginPath;
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("nameWork", myWork);
		body.put("experience", myExperience);
		body.put("education", myEducation);
		
		RequestSpecification requestSpecification = RestAssured.given()
				.contentType(ContentType.JSON)
//lay token ra		
				.headers("token",pFileUtils.getToken("token"))
				//.header("token",tc.getToken())
				.body(body);
		
		response=requestSpecification.post();
		responseBody=response.getBody();
		jsonBody=responseBody.jsonPath();
		
	
		System.out.println(response.asPrettyString());
	
		
	}
	@Test(priority = 0)
	public void TC01_Validate201Created() {
          assertEquals(response.getStatusCode(), 201);

	}
	@Test(priority = 1)
	public void TC03_ValidateNameOfWorkMatched() {
             assertEquals(jsonBody.getString("nameWork"), myWork);

	}

	@Test(priority = 2)
	public void TC03_ValidateExperienceMatched() {
           assertEquals(jsonBody.getString("experience"), myExperience);

	}

	@Test(priority = 3)
	public void TC03_ValidateEducationMatched() {
              assertEquals(jsonBody.get("education"), myEducation);

	}






}
