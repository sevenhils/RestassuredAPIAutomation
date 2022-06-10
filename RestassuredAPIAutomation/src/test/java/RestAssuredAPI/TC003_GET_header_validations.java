package RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_header_validations {

	@Test
	public void getStoreDetails() {
		// specify BaseURI
		RestAssured.baseURI = "https://www.storemapper.co/";

		// Request Object
		RequestSpecification httprequest = RestAssured.given();

		// Response Object
		Response response = httprequest.request(Method.GET,
				"/api/v2/stores/search?user_id=1&access_token=a5ea23b59797169a24cdb743c266518f&near=New+York&radius=3&unit=k");

		// print response in console

		String responseBody = response.getBody().asString();
		System.out.println("The ResponseBody is :" + responseBody);

		// validating Headers
		String ContentType = response.header("Content-Type");
		System.out.println("Content-Type is :" + ContentType);
		Assert.assertEquals(ContentType, "application/json; charset=utf-8");

		String Connection = response.header("Connection");
		System.out.println("Connection is:" + Connection);
		Assert.assertEquals(Connection, "keep-alive");
	}

}
