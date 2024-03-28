package hooks;

import io.cucumber.java.Before;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class WebHooks {
    @Before
    public static void setFilters() {
        RestAssured.filters(new AllureRestAssured());
    }
}
