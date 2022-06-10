package DataDriventesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_AddEmployees_Excel {
	@Test(dataProvider = "Employeedata")
	public void CreateEmployeeDetails(String ename, String esal, String eage) {
		// specify base URI
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		// Request Object
		RequestSpecification httprequest = RestAssured.given();
		// Request PayLoad sendding along with Post request
		JSONObject requestparms = new JSONObject();

		requestparms.put("name", ename);
		requestparms.put("salary", esal);
		requestparms.put("age", eage);

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
		System.out.println("Staus is:" + status);
		Assert.assertEquals(status, "success");
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		Assert.assertEquals(responseBody.contains(eage), true);

	}

	@DataProvider(name = "Employeedata")
	public String[][] getEmpdata() throws IOException {

		String path = System.getProperty("user.dir")+"/src/test/java/DataDriventesting/empdata.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String[][] empdata = new String[rownum][colcount];
		for (int i = 1; i < rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				empdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}
		}

		return (empdata);
	}

}
