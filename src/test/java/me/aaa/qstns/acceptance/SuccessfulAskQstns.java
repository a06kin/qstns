package me.aaa.qstns.acceptance;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

public class SuccessfulAskQstns {

    private String q;

    @Given("^Mr.Duke want to ask a question \"([^\"])*\"$")
    public void mrDuke_have_qstn(String qstn){
        this.q = qstn;
    }

    @When("^Mr.Duke ask question with status (\\d+)$")
    public void mrDuke_ask_qstn(Integer statusCode){
        given()
                .param("question", q)
        .expect()
                .statusCode(statusCode)
        .when()
                .post("/qstn").then();
    }

    @Then("^Mr.Duke has question in history")
    public void mrDuke_has_qstn_in_history() {
        when()
                .get("/qstn")
                .then()
                .body("[0]", CoreMatchers.not(CoreMatchers.nullValue()));
    }
}
