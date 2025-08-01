package testapi;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(Payload.CoursePrice());

		// Print No of courses returned by API

		int count = js.getInt("courses.size()");

		System.out.println(count);

		// Print Purchase Amount

		int psAmount = js.getInt("dashboard.purchaseAmount");

		System.out.println(psAmount);

		String wbName = js.getString("dashboard.website");

		System.out.println(wbName);

		// Print Title of the first course

		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println(firstCourseTitle);

		// Print All course titles and their respective Prices

		for (int i = 0; i < count; i++) {
			System.out.println(js.get("courses[" + i + "].title").toString());
			System.out.println(js.get("courses[" + i + "].price").toString());

		}
		// Print no of copies sold by RPA Course

		System.out.println("Print no of copies sold by RPA Course");

		for (int i = 0; i < count; i++) {

			String titleExp = js.get("courses[" + i + "].title").toString();

			if (titleExp.equalsIgnoreCase("RPA")) {

				int copiesCount = js.get("courses[" + i + "].copies");

				System.out.println("Total copies count is : " + copiesCount);

				break;
			}

		}

		System.out.println("Verify if Sum of all Course prices matches with Purchase Amount");
		
		for (int i=0;i<count;i++)
		{
			int priceValue=js.get("courses["+ i +"].price");
		}

	}

}
