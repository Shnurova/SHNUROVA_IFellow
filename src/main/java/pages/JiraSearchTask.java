package pages;

import java.time.Duration;
import java.util.List;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class JiraSearchTask {

    private final SelenideElement statusVal = $x("//span[@id='status-val']/child::span");
    private final SelenideElement fixVersions = $x("//span[@id='fixVersions-field']/child::a");
    private final SelenideElement actionInWork = $x("//a[@id='action_id_21']");
    private final SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']");
    private final SelenideElement accomplishedWork = $x("//span[text()='Выполнено']");
    private final SelenideElement readyStatusVal = $x("//span[contains(@class, 'jira-issue-status') and text()='Готово']");
    public List<String> statusCheck() {
        String statusText = statusVal.shouldBe(Condition.visible).getText();
        String fixVersionsText = fixVersions.shouldBe(Condition.visible).getText();
        return List.of(statusText, fixVersionsText);
    }

    public void changeStatus() {
        actionInWork.click();
        businessProcess.click();
        businessProcess.parent().shouldHave(Condition.attribute("aria-expanded", "true"));
        accomplishedWork.shouldBe(Condition.editable).click();
    }

    public String getReadyStatus() {
        return readyStatusVal.getText();
    }
}

