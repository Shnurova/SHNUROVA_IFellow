package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class JiraCreateProject {

    private final SelenideElement createIssueSubmit =$x("//input[@id='create-issue-submit']").as("Кнопка создать");
    private final SelenideElement summaryInput =$x("//input[@id='summary']").as("Тема Задачи");
    private final SelenideElement iframe = $x("//iframe[@id='mce_0_ifr']").as("Iframe");
    private final SelenideElement bodyOfIframe = $x("//body[@id='tinymce']").as("Описание Задачи");

    @Step("Создание новой задачи")
    public void fillProjectData(String summaryText, String descriptionText) {
        summaryInput.shouldBe(Condition.visible).sendKeys(summaryText);
        driver().switchTo().frame(iframe);
        bodyOfIframe.setValue(descriptionText);
        driver().switchTo().parentFrame();
        createIssueSubmit.click();
    }


}
