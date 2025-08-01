package testapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

//Verify if Sum of all Course prices matches with Purchase Amount
public class SumValidation {

	
	@Test
	public void sumOfCourse() {
		int sum = 0;

		JsonPath js = new JsonPath(Payload.CoursePrice());
		int count = js.getInt("courses.size()");

		for (int i = 0; i < count; i++) {
			int priceValue = js.getInt("courses[" + i + "].price");
			int copiesCount = js.getInt("courses[" + i + "].copies");

			int amount = priceValue * copiesCount;
			System.out.println(amount);
			sum = sum + amount;

		}

		System.out.println(sum);

		int totalAmount = js.getInt("dashboard.purchaseAmount");

		Assert.assertEquals(sum, totalAmount);
			
		}
	}
