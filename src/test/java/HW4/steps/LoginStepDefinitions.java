package HW4.steps;

import HW4.TestBase;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;

public class LoginStepDefinitions extends TestBase {

    @Дано("перейти на сайт {string}")
    public void openUrl(String url) {
        open(url);
    }

    @Когда("залогиниться под пользователем {string} с паролем {string}")
    public void loginTest(String login, String password) {
        jiraLoginPage.signIn(login, password);
        jiraPageVerifier.waitSignIn();
    }

    @Тогда("отображается профиль")
    public void profileItemDisplayed() {

        Assertions.assertTrue(jiraPageVerifier.isProfileItemDisplayed());
    }

}
