package Naveen_Tests;

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test3 { //Test using only Country as input

	Scanner input = new Scanner(System.in);
	String country_name;

	@Test
	public void CountryParameter() {

		System.out.print("Enter Country: ");
		country_name = input.next();
		
		RestAssured.baseURI ="https://restcountries.eu/rest/v2/name/"+country_name; 
		RequestSpecification request = RestAssured.given();

		Response response = request.queryParam("fields", "name;capital").get();

		String jsonString = response.asString();
		System.out.println("Status Code: "+response.getStatusCode()); 
		System.out.println("Searched Country & its Capital: "+jsonString);

	}
}
