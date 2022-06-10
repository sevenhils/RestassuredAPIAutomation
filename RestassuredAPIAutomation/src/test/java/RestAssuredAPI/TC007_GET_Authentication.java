package RestAssuredAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Authentication {

	@Test
	public void getAuthentication() {
		RestAssured.baseURI = "https://postman-echo.com";
		// Basic Authentication
		PreemptiveBasicAuthScheme authschme = new PreemptiveBasicAuthScheme();
		authschme.setUserName("postman");
		authschme.setPassword("password");
		RestAssured.authentication = authschme;
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/basic-auth");
		String responsebody = response.getBody().asString();
		System.out.println("ResonseBody is: " + responsebody);

	}
}
