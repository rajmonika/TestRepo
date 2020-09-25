package Naveen_Tests;

import java.util.Scanner;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidationTests {

	Scanner input = new Scanner(System.in);
	String country_name;

	@Test
	public void CountryParameter() {

		System.out.print("Enter Country or Country Code: ");
		country_name = input.next();
		int Coun_size = country_name.length();

		if (Coun_size>3)
		{		
			RestAssured.baseURI ="https://restcountries.eu/rest/v2/name/"+country_name; 
		}
		else 
		{
			RestAssured.baseURI ="https://restcountries.eu/rest/v2/alpha/"+country_name;
		}
		RequestSpecification request = RestAssured.given();

		Response response = request.queryParam("fields", "name;capital").get();
		String jsonString = response.asString();

		SoftAssert softassert = new SoftAssert();


		//Validating Response Status Code
		int statusCode = response.getStatusCode();
		softassert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Incorrect input country: Response status"); 

		//Validating Response Status Line
		String statusLine = response.getStatusLine();
		softassert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 " /*expected value*/, "Incorrect status Line returned:");

		//Validating Header Content Type
		String header = response.getHeader("content-type");
		softassert.assertEquals(header, "application/json;charset=utf-8","Incorrect Header Content:");

		//Validating Header Server
		String serverType =  response.header("Server");
		softassert.assertEquals(serverType /* actual value */, "cloudflare" /* expected value */,"Incorrect Header Server: ");

		softassert.assertAll();

		//Printing the Response
		System.out.println("Status Code: "+response.getStatusCode()); 
		System.out.println("Searched Country & its Capital: "+jsonString);  

	}
}
