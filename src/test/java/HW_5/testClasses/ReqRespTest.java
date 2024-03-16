package HW_5.testClasses;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReqRespTest extends BaseTest {
    @Test
    public void ReqRest() throws IOException {
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/paren.json"))));
        postApi("https://reqres.in", "/api/users", body.toString(), 201);
        body.put("name", "Tomato");
        body.put("job", "Eat maket");
        Response Response = postApi("https://reqres.in", "/api/users", body.toString(), 201);
        String name = Response.jsonPath().getString("name");
        Assertions.assertEquals(body.getString("name"), name);
        String job = Response.jsonPath().getString("job");
        Assertions.assertEquals(body.getString("job"), job);
    }
}
