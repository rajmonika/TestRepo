package Naveen_Tests;

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DisplayCountryCapital {  //Test using both Country & Country Code as input

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
		System.out.println("Status Code: "+response.getStatusCode()); 
		System.out.println("Searched Country & its Capital: "+jsonString);

	}
}
