package Day1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HttpsResponses {
	
	@Test
	void user() {
		
		// get, post,patch,delete
		
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
		
		
		
		
		
		
		
		
		
	}
	
	
	


}
