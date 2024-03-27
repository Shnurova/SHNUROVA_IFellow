package steps;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import config.PropertiesConfig;

public class Reqres  extends TestBase {
    @Когда("Создать POST запрос для создания пользователя")
    public void userCreationRequest() throws IOException {
        body = new JSONObject(new String(Files.readAllBytes(Paths.get(PropertiesConfig.config.bodyDataPath()))));
        postApi(PropertiesConfig.config.baseUriReqres(), "/api/users", body.toString(), 201);
    }

    @Когда("поменять поле {string} и добавить поле {string} в Body")
    public void changeTheField(String name, String job) {
         body.put("name", name);
         body.put("job", job);
    }

    @Когда("отправить POST запрос для изменения данных пользователя и проверить что получили ответ 201")
    public void requestToChangeUserData(){
        response = postApi(PropertiesConfig.config.baseUriReqres(), "/api/users", body.toString(), 201);
    }

    @Тогда("Свериться, что полученный response имеет валидные данные по значениям key и value")
    public void verifyData() {
        String name = response.jsonPath().getString("name");
        Assertions.assertEquals(body.getString("name"), name);
        String job = response.jsonPath().getString("job");
        Assertions.assertEquals(body.getString("job"), job);
    }
}
