package pages;

import java.util.List;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
public class JiraSearchTask {

    private final SelenideElement statusVal =$x("//span[@id='status-val']/child::span").as("Статус задачи");
    private final SelenideElement fixVersions =$x("//span[@id='fixVersions-field']/child::a").as("Версия задачи");
    private final SelenideElement actionInWork =$x("//a[@id='action_id_21']").as("Кнопка в работе");
    private final SelenideElement businessProcess =$x("//a[@id='opsbar-transitions_more']").as("Кнопка 'Бизнес-процесс'");
    private final SelenideElement accomplishedWork =$x("//span[text()='Выполнено']/parent::a[@role='menuitem']").as("Бизнес-процесс 'Выполнено'");
    private final SelenideElement readyStatusVal = $x("//span[contains(@class, 'jira-issue-status') and text()='Готово']").as("Статус Готово");


    @Step("Проверка статуса Задачи")
    public List<String> statusCheck() {
        String statusText = statusVal.shouldBe(Condition.visible).getText();
        String fixVersionsText = fixVersions.shouldBe(Condition.visible).getText();
        return List.of(statusText, fixVersionsText);
    }
    @Step("Цикл выполнения Задачи")
    public void changeStatus() {
        actionInWork.click();
        businessProcess.click();
        accomplishedWork.click();
    }

    @Step("Получение статуса Задачи")
    public String getReadyStatus() {
        return readyStatusVal.getText();
    }
}

