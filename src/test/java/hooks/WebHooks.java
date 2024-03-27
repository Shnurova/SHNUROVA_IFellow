package hooks;

import io.cucumber.java.BeforeAll;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class WebHooks {
    @BeforeAll
    public void setFilters() {
        if (RestAssured.filters().isEmpty()) {
            RestAssured.filters(new AllureRestAssured());
        }
    }

}
