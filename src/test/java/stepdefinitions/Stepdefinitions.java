package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Add_Place;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class Stepdefinitions extends Utils {
	ResponseSpecification resspec;
	RequestSpecification res;
	Response responce;
	TestDataBuild Test_data = new TestDataBuild();

	@Given("Add place Payload with {string} {string}")
	public void add_place_payload(String name, String address) throws IOException {

		res = given().spec(RequestSpecification()).body(Test_data.addPlacePayLoad(name, address));

	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {

		APIResources responseapi = APIResources.valueOf(resource);

		if (method.equalsIgnoreCase("POST")) {
			responce = res.when().post(responseapi.getResource());
		} else if (method.equalsIgnoreCase("GET")) {
			responce = res.when().get(responseapi.getResource());
		}
		
		System.out.println(responseapi.getResource());
	}

	@Then("{string} in responce body is {string}")
	public void in_responce_body_is(String keyValue, String ExpectedValue) {

		String responseString = responce.asString();

		JsonPath js = new JsonPath(responseString);

		assertEquals(ExpectedValue, js.get(keyValue).toString());
	}

//	@Then("the Api call is success with status code {int}")
//	public void the_api_call_is_success_with_status_code(Integer int1) {
//		// Write code here that turns the phrase above into concrete actions
//		assertEquals(responce.getStatusCode(), 200);
//	}

}
