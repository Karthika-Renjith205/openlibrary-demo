package stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.junit.runner.Request;
import static org.hamcrest.Matchers.*;

public class OpenLibrarySteps {
    String baseURI;
    Request request;
    Response response;

    public OpenLibrarySteps() {

    }

    @Given("^I set the OpenLibrary API endpoint$")
    public void iSetTheOpenlibraryApiEndpoint() throws IOException {
        Properties prop = new Properties();

        InputStream fis = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties");

        if (fis == null) {
            throw new RuntimeException("config.properties NOT found in classpath");
        }

        prop.load(fis);
        baseURI = prop.getProperty("baseURI");
        System.out.println("Base URI: " + baseURI);

    }

    @When("^I send a GET request$")
    public void iSendAGetRequest() {

        response = RestAssured.get(baseURI + "/authors/OL1A.json");
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe200(int status) {
        response.then().statusCode(status);
    }

    @Then("the response should contain author details:")
    public void theResponseShouldContain(DataTable dataTable) {
        // System.out.println("Response Body: " + response.body().asString());
        for (Map<String, String> author : dataTable.asMaps()) {

            response.then().body("personal_name", equalTo(author.get("personal name")));
            response.then().body("alternate_names", hasItem(author.get("alternate name")));
        }
    }

}
