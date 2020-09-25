package API_Methods;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;


public class DELETE {
	
	//Delete method doesn't has any body
	
	@Test
	void Delete_01()
	{
		given().
		delete("https://reqres.in/api/users/2").
		then().
		statusCode(204).
		log().all();
	}


}
