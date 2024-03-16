package rickAndMorty.hooks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {
    @BeforeEach
    public void beforeEach() {
        System.out.println("Hello!!!");
    }
}
