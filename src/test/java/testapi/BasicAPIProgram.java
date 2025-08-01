package testapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import files.Payload;
import files.ResuableMethods;

public class BasicAPIProgram {

	public static void main(String[] args) {

		// AddPlace API to add the place in maps

		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.AddPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).extract().response().asString();

		System.out.println("The API response is:" + response);

		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		String status = js.getString("status");

		System.out.println("The place_id is : " + placeId);
		System.out.println("the status of api is : " + status);

		// Add place --> Update Place with new Address ->> Get Place to validate if New
		// address is present in response

		String newAddress = "70 Summer Lake, Indiana";

		given().log().all().queryParam("key", "qaclick123").header("Content_Type", "application/json")
				.body("{\r\n" + "  \"place_id\": \"" + placeId + "\",\r\n" + "  \"address\": \"" + newAddress
						+ "\",\r\n" + "  \"key\": \"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));
		// .extract().response().asString();

		// Get Place API response

		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
				.when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract()
				.response().asString();

//	JsonPath jss = new JsonPath(getPlaceResponse);

		JsonPath js1 = ResuableMethods.rawToJson(getPlaceResponse); // Create Reusable class
		String actualAdress = js1.getString("address");
		System.out.println("Updated Address is : " + actualAdress);

		Assert.assertEquals(actualAdress, newAddress);  // Import TestNG and used assertion class

		// Delete the Add Place API from server

		String deleteMessage = given().log().all().queryParam("key", "qaclick")
				.header("Content-Type", "application/json")
				.body("{\r\n" + "    \"place_id\":\"" + placeId + "\"\r\n" + "}").when()
				.delete("maps/api/place/delete/json").then().assertThat().log().all().statusCode(200).extract()
				.response().asString();

		JsonPath js2 = ResuableMethods.rawToJson(deleteMessage);
		String successMsg = js2.get("status");
		System.out.println(successMsg);
		
		Assert.assertEquals(successMsg, "OK");
		
		System.out.println("Test scenario is executed end to end successfully");

	}

}
