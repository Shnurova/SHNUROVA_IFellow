package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class JiraLoginPage {

     private final SelenideElement loginFormUsername =$x("//input[@id='login-form-username']");
    private final SelenideElement loginFormPassword =$x("//input[@id='login-form-password']");
    private final SelenideElement loginButton =$x("//input[@value='Войти']");

    public void signIn(String loginText, String passwordText){
        loginFormUsername.shouldBe(Condition.visible).sendKeys(loginText);
        loginFormPassword.shouldBe(Condition.visible).sendKeys(passwordText);
        loginButton.click();
    }
}
