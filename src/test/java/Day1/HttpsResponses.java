package Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class HttpsResponses {
    
    @Test
    void user() {

         //useRelaxedHTTPSValidation();  // FIX

        given()
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all();
    }
    
   @Test
   void createUser() {
	   
	  

	   HashMap data= new HashMap();
	   data.put("name", "Pratik");
	   data.put("job", "QA");
	   
	   
	   given()
	   .contentType("application/json")
	   .body(data)
	   
	   .when()
	   .post("https://reqres.in/api/users")
	   .then()
	  
	    .statusCode(201)
	    .contentType("application/json")
	    .time(lessThan(2000L))
	    .body("name", equalTo("Pratik"))
	    .body("job", equalTo("QA"))
	    .body("id", notNullValue())
	    .body("createdAt", notNullValue())
	    .log().all();
   }
   @Test
   void updateUser() {

       HashMap data = new HashMap();
       data.put("name", "morpheus");
       data.put("job", "zion resident");

       given()
           .contentType("application/json")
           .body(data)
       .when()
           .put("https://reqres.in/api/users/2")     // update user 2
       .then()
           .statusCode(200)                          // PUT returns 200
           .body("name", equalTo("morpheus"))
           .body("job", equalTo("zion resident"))
           .body("updatedAt", notNullValue())
           .log().all();
   }

}
