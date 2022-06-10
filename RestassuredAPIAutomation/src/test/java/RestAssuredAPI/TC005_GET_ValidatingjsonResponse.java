package RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ValidatingjsonResponse {
	@Test
	public void getStoreDetails() {
		RestAssured.baseURI="https://www.storemapper.co/";
		RequestSpecification httprequest=RestAssured.given();
		
	Response response=	httprequest.request(Method.GET,"/api/v2/stores/search?user_id=1&access_token=a5ea23b59797169a24cdb743c266518f&near=New+York&radius=3&unit=k");
	String responseBody=response.getBody().asString();
	System.out.println("responsebody is: "+responseBody);
	
	//validating JsonResponse
	Assert.assertEquals(responseBody.contains("Whole Foods Market - Tribeca"), true);

		
	}
	}




