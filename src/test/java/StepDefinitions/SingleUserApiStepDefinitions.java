package StepDefinitions;

import Utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class SingleUserApiStepDefinitions {
    Response response;
    String SingleUserEndPoint;

    @Given("sets Get single user api service end point")
    public void sets_Get_single_user_api_service_end_point_() {
        SingleUserEndPoint= ConfigurationReader.get("BaseApiUrI")+"users/2";
        System.out.println(SingleUserEndPoint);
    }
    @When("user sends get request to single user end point")
    public void user_sends_get_request_to_single_user_end_point() {
        response = given().accept(ContentType.JSON)
                .and()
                .when().get(SingleUserEndPoint);
    }
    @Then("the status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        response.prettyPrint();
        Assert.assertEquals(statusCode,response.statusCode());
    }
    @Then("first_name should be {string}")
    public void should_be_janet(String first_name) {
       Assert.assertTrue(response.body().asString().contains(first_name));
    }
}
