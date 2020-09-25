package API_Methods;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class GET_02 {
	
	@Test
	void test01()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("StatusCode: "+response.getStatusCode());
		System.out.println("Header: "+response.getHeader("content-type"));
		System.out.println("StatusLine: "+response.getStatusLine());
		System.out.println("Time: "+response.getTime());
		System.out.println("Response: "+response.asString());
		System.out.println("ResponseBody: "+response.getBody().asString());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	
	}
	

	@Test
	void test02()
	{
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7))
		.body("data.first_name", hasItems("Michael","Lindsay","Tobias"))
		.log().all();
	}
}
