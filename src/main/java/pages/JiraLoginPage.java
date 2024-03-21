package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;


public class JiraLoginPage {
    private final SelenideElement loginFormUsername =$x("//input[@id='login-form-username']").as("Окно ввода логина");
    private final SelenideElement loginFormPassword =$x("//input[@id='login-form-password']").as("Окно ввода пароля");
    private final SelenideElement loginButton =$x("//input[@value='Войти']").as("Кнопка 'Войти'");

    @Step("Ввод логина и пароля")
    public void signIn(String loginText, String passwordText){
        loginFormUsername.shouldBe(Condition.visible).sendKeys(loginText);
        loginFormPassword.shouldBe(Condition.visible).sendKeys(passwordText);
        loginButton.click();
    }
}
