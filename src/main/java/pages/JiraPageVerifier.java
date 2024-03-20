package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class JiraPageVerifier {
    private final SelenideElement profileItem = $x("//a[@id='header-details-user-fullname']").as("Ссылка на пользовательский профиль");
    private final SelenideElement subNavigationTitle = $x("//h1/span[@id='issues-subnavigation-title']").as("Надпись открытые задачи");

    @Step("Отображение профиля")
    public Boolean isProfileItemDisplayed() {
        waitSignIn();
        return profileItem.isDisplayed();
    }

    @Step("Ожидание Логина")
    public void waitSignIn() {
        profileItem.shouldBe(Condition.visible);
    }

    @Step("Запоминание для проверки открытия задач")
    public Boolean isTitleExists(String title) {
        return subNavigationTitle.getText().equals(title);
    }
}
