package RestAssuredAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Print_All_Headers {
	@Test
	public void getStoreDetails() {
		RestAssured.baseURI="https://www.storemapper.co/";
		RequestSpecification httprequest=RestAssured.given();
		
	Response response=	httprequest.request(Method.GET,"/api/v2/stores/search?user_id=1&access_token=a5ea23b59797169a24cdb743c266518f&near=New+York&radius=3&unit=k");
	String responseBody=response.getBody().asString();
	System.out.println("responsebody is: "+responseBody);
	
	//capture All The Headers from Response
Headers allHeaders=	response.headers();

	for(Header headers:allHeaders) {
	System.out.println(headers.getName()+"    "+headers.getValue());
		
	}
	}

}
