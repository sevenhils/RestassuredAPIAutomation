package RestAssuredAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	public static Logger log=LogManager.getLogger(Test.class.getName());
	@Test
	public void getEmployeeDetails() {
		//specify BaseURI
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response Object
		Response response=httprequest.request(Method.GET,"/employees");
		
		//print response in console
		
	String responseBody=	response.getBody().asString();
	System.out.println("The ResponseBody is :" +responseBody);	
		
		//Status code validation
int statusCode=	response.getStatusCode();
	System.out.println("Status code is: "+statusCode);	
	Assert.assertEquals(statusCode, 200);
	
	//Status line validation
String Statusline=	response.getStatusLine();
System.out.println("Staus Line is: "+Statusline);
Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");
		
		
	}
	
}
