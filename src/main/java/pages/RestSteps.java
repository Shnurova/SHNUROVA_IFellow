//package pages;
//
//import io.restassured.response.Response;
//
//import static io.restassured.RestAssured.given;
//
//public class RestSteps {
//    public Response getApi(String baseUri, int statusCode){
//        return given()
//                .baseUri(baseUri)
//                .get()
//                .then()
//                .log().all()
//                .assertThat()
//                .statusCode(statusCode)
//                .extract().response();
//    }
//}