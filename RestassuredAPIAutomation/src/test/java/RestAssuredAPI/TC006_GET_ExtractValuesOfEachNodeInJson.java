package RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_ExtractValuesOfEachNodeInJson {
	@Test
	public void getStoreDetails() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest=RestAssured.given();
		
	Response response=	httprequest.request(Method.GET,"/employees/1");
	JsonPath jsonpath=response.jsonPath();
String status=	jsonpath.get("[0].employee_name");
System.out.println(status);
	
	}
}
