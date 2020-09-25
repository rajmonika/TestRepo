package Naveen_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test2 { //Test using hard coded Country value as input
	
	String country_name = "japan";
	 @Test
     public void CountryParameter() {

RestAssured.baseURI ="https://restcountries.eu/rest/v2/name/"+country_name; 
RequestSpecification request = RestAssured.given();

Response response = request.queryParam("fields", "name;capital").get();

String jsonString = response.asString();
System.out.println("Status Code: "+response.getStatusCode()); 
System.out.println("Searched Country & its Capital: "+jsonString);


//Assert.assertEquals(jsonString.contains("London"), true);

}
}
