package Naveen_Tests;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GET_CapitalCity {
	
	@Test
	void test01()
	{                         //  https://restcountries.eu/rest/v2/all?fields=name;capital
		Response response = get("https://restcountries.eu/rest/v2/alpha/col?fields=name;capital");
		
		System.out.println("StatusCode: "+response.getStatusCode());
		System.out.println("Response: "+response.body().asString());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
	//	String country_name = "selectedCountry";
		
	/*	String cou_name = jsonObject.getString("name");
        String cou_cap = jsonObject.getString("capital");
        
        if (cou_name.equalsIgnoreCase(country_name)) {
            Toast.makeText(this, "capital " + cou_cap, Toast.LENGTH_SHORT).show();
            //Here you will get the capital of respected country.
            break;
        }

	*/    
	    
	
	}
	
/*	@Test
	void test02()
	{
		given()
		.get("https://restcountries.eu/rest/v2/name/United States of America")
		.then()
		.statusCode(200);
		//.log().all();
	}*/

}
