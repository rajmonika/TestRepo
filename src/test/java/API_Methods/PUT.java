package API_Methods;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PUT {
	
	@Test
	void Put_01()
	{
		JSONObject request = new JSONObject();
		
		request.put("name", "Monika_UPD");
		request.put("job", "Trainer_UPD");
		
		System.out.println(request); 
		System.out.println(request.toJSONString());
		
		given().
		       header("Content-Type", "application/json").
		       contentType(ContentType.JSON).
		       accept(ContentType.JSON).
		       body(request.toJSONString()).
		when().
		       put("https://reqres.in/api/users/2").
		then().
		       statusCode(200).
		       log().all();
	}

}
