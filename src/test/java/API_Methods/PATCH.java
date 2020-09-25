package API_Methods;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PATCH { 

	//PUT - is used for modifying existing resource (Previously POSTED). 
	//On the other hand the PATCH request is used to update some portion of existing resource.
	//The difference between PATCH and PUT, is that a PATCH request is non-idempotent (like a POST request).
	//Now PATCH request is intended to update just selective fields, it is not expected to GET the resource representation. 
	//So multiple calls to PATCH request could end up in undesirable change in the resource state. 
	
	
	//An idempotent HTTP method is a HTTP method that can be called many times without different outcomes. 
	/*It would not matter if the method is called only once, or ten times over. The result should be the same. 
	Again, this only applies to the result, not the resource itself. */
	
	//Methods GET, PUT & DELETE are idempotent - same response after every request
	
	@Test
	void Patch_01()
	{
		JSONObject request = new JSONObject();

		request.put("name", "Monika");
		request.put("job", "Trainer_UPD_patch");

		System.out.println(request); 
		System.out.println(request.toJSONString());

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
	}

}
