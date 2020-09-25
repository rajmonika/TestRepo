package API_Methods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_01 {
	
	@Test
	void test01()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println("StatusCode: "+response.getStatusCode());
		System.out.println("Header: "+response.getHeader("content-type"));
		System.out.println("StatusLine: "+response.getStatusLine());
		System.out.println("Time: "+response.getTime());
		System.out.println("Response: "+response.asString());
		System.out.println("ResponseBody: "+response.getBody().asString());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
	}

}
