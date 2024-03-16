package HW_5.steps;

import io.restassured.response.Response;
import HW_5.hooks.WebHooks;

import static io.restassured.RestAssured.given;

public class RestSteps extends WebHooks {
    public Response getApi(String baseUri, String postUri , int statusCode){
        return given()
                .baseUri(baseUri)
                .get(postUri)
                .then()
                .log().all()
                .assertThat()
                .statusCode(statusCode)
                .extract().response();
    }

    public Response postApi(String baseUri, String postUri, String body, int statusCode) {
        return given()
                .header("Content-type", "application/json")
                .header("charset", "utf-8")
                .baseUri(baseUri)
                .body(body)
                .when()
                .post(postUri)
                .then()
                .statusCode(statusCode)
                .log().body()
                .extract().response();
    }
}
