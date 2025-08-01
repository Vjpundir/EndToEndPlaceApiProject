package files;

public class Payload {

    public static String AddPlace() {

        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Jack Miller\",\n" +
                "  \"phone_number\": \"(+91) 9930303070\",\n" +
                "  \"address\": \"29, Downtown Area hayes street new Castle, cohen 09\",\n" +
                "  \"types\": [\"shoe park\", \"shop\"],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"british-English\"\n" +
                "}";
    }
    
    public static String CoursePrice()
    {
    	return "{\r\n"
    			+ "\r\n"
    			+ "\"dashboard\": {\r\n"
    			+ "\r\n"
    			+ "\"purchaseAmount\": 910,\r\n"
    			+ "\r\n"
    			+ "\"website\": \"rahulshettyacademy.com\"\r\n"
    			+ "\r\n"
    			+ "},\r\n"
    			+ "\r\n"
    			+ "\"courses\": [\r\n"
    			+ "\r\n"
    			+ "{\r\n"
    			+ "\r\n"
    			+ "\"title\": \"Selenium Python\",\r\n"
    			+ "\r\n"
    			+ "\"price\": 50,\r\n"
    			+ "\r\n"
    			+ "\"copies\": 6\r\n"
    			+ "\r\n"
    			+ "},\r\n"
    			+ "\r\n"
    			+ "{\r\n"
    			+ "\r\n"
    			+ "\"title\": \"Cypress\",\r\n"
    			+ "\r\n"
    			+ "\"price\": 40,\r\n"
    			+ "\r\n"
    			+ "\"copies\": 4\r\n"
    			+ "\r\n"
    			+ "},\r\n"
    			+ "\r\n"
    			+ "{\r\n"
    			+ "\r\n"
    			+ "\"title\": \"RPA\",\r\n"
    			+ "\r\n"
    			+ "\"price\": 45,\r\n"
    			+ "\r\n"
    			+ "\"copies\": 10\r\n"
    			+ "\r\n"
    			+ "}\r\n"
    			+ "\r\n"
    			+ "]\r\n"
    			+ "\r\n"
    			+ "}";
    	
    }
}
