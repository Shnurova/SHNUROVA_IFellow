package rickAndMorty.testClasses;

import io.restassured.response.Response;
import rickAndMorty.hooks.WebHooks;

import static io.restassured.RestAssured.given;

public class BaseTest extends WebHooks {
    public Response getApi(String baseUri, int statusCode){
        return given()
                .baseUri(baseUri)
                .log().all()
                .get()
                .then()
                .log().all()
                .assertThat()
                .statusCode(statusCode)
                .extract().response();
    }
}
