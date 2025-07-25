package testapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;



public class BasicAPIProgram {
	
	
	@Test
	public void getUser()
	{
	
	RestAssured.baseURI = "https://reqres.in";
	
	
	String response = RestAssured. given()
	.when().get("/api/users?page=2")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js = new JsonPath(response);

    // Example: Print first user's email from data array
    String email = js.getString("data[0].email");
    System.out.println("First user's email: " + email);
	
	}	
	
}
