package com.api.auto.testcase;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.serial.SerialJavaObject;

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

public class TC_API_Login {
	private String account;
	private String password ;
	private Response response;
	private ResponseBody responseBody;
	private JsonPath jsonBody;
	private String token;
	private PropertiesFileUtils pFileUtils;
	private String baseUrl;
	private String loginPath;

	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String b) {
		this.baseUrl = b;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String t) {
		this.token = t;
	}
	@BeforeClass
	public void init() {
		
		pFileUtils=new PropertiesFileUtils();
		baseUrl=pFileUtils.getProperty("baseurl");
		loginPath= pFileUtils.getProperty("loginPath");
		account=pFileUtils.getProperty("account");
		password=pFileUtils.getProperty("password");
		
		RestAssured.baseURI= baseUrl;
		RestAssured.basePath=loginPath;
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("account", account);
		body.put("password", password);
		
		RequestSpecification requestSpecification = RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.body(body);
		
		response=requestSpecification.post();
		responseBody=response.getBody();
		jsonBody=responseBody.jsonPath();

		PropertiesFileUtils pFileUtils=new PropertiesFileUtils(); 
		pFileUtils.saveToken("token", jsonBody.getString("token"));
		System.out.println(jsonBody.getString("token"));
		
		token = jsonBody.getString("token");
		System.out.println(response.asPrettyString());
		//System.out.println(jsonBody.getString("message"));
	}
	@Test (priority = 0)
	public void TC01_Status() {
		assertEquals(response.getStatusCode(), 200,"Status sai");
	}
	@Test (priority = 1)
	public void TC02_ValidateMessage() {
        assertTrue(responseBody.asString().contains("message"));
        assertEquals(jsonBody.getString("message"),"??ng nh?p th�nh c�ng");     
}
	@Test(priority = 2)
	public void TC03_ValidateToken() {
           // kiểm chứng response body có chứa trường token hay không  
		assertTrue(responseBody.asString().contains("token"));
	}
	@Test(priority = 3)
	public void TC05_ValidateUserType() {
         // kiểm chứng response body có chứa thông tin user và trường type hay không
		assertTrue(responseBody.asString().contains("user"));
		assertTrue(responseBody.asString().contains("type"));
		assertEquals(jsonBody.get("user.type"), "UNGVIEN");
         // kiểm chứng trường type có phải là “UNGVIEN”
                  
	}
	@Test(priority = 4)
	public void TC06_ValidateAccount() {
          // kiểm chứng response chứa thông tin user 
		assertTrue(responseBody.asString().contains("user"));
		assertTrue(responseBody.asString().contains("id"));
		assertTrue(responseBody.asString().contains("name"));
		assertTrue(responseBody.asString().contains("email"));
		assertTrue(responseBody.asString().contains("account"));
		assertTrue(responseBody.asString().contains("password"));
		assertTrue(responseBody.asString().contains("avatar"));
		assertTrue(responseBody.asString().contains("sex"));
		assertTrue(responseBody.asString().contains("birthday"));
		assertTrue(responseBody.asString().contains("experience"));
		assertTrue(responseBody.asString().contains("skill"));
		assertTrue(responseBody.asString().contains("nation"));
		assertTrue(responseBody.asString().contains("description"));
		assertTrue(responseBody.asString().contains("foreiginLanguage"));
		assertTrue(responseBody.asString().contains("education"));
		assertTrue(responseBody.asString().contains("careerGoals"));
		assertTrue(responseBody.asString().contains("Certificate"));
          // Kiểm chứng trường account có khớp với account đăng nhập
		assertEquals(jsonBody.getString("user.account"), account);
          // Kiểm chứng trường password có khớp với password đăng nhập
		assertEquals(jsonBody.getString("user.password"), password);
	}



	@AfterClass
	public void afterClass() {
		RestAssured.baseURI=null;
		RestAssured.basePath=null;
		System.out.println("xoa roi");
		
	}

}
