package RestAssuredAPI;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

	@Test
	public void CreateEmployeeDetails() {

		// specify base URI
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		// Request Object
		RequestSpecification httprequest = RestAssured.given();
		// Request PayLoad sendding along with Post request
		JSONObject requestparms = new JSONObject();

		requestparms.put("name", "John");
		requestparms.put("salary", "55000");
		requestparms.put("age", "27");
		
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparms.toJSONString());// attach above data to the request

		// Response Object
		Response response = httprequest.request(Method.POST, "/create");

		// response body

		String responseBody = response.getBody().asString();

		System.out.println("The Response Body is: " + responseBody);

		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("StausCode is: " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// Status validation from json data
		String status = response.jsonPath().get("status");
		System.out.println("Staus is:"+status);
		Assert.assertEquals(status, "success");

	}

}
