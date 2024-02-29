package pages;

import java.util.List;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
public class JiraSearchTask {

    private final SelenideElement statusVal =$x("//span[@id='status-val']/child::span");
    private final SelenideElement fixVersions =$x("//span[@id='fixVersions-field']/child::a");
    private final SelenideElement actionInWork =$x("//a[@id='action_id_21']");
    private final SelenideElement businessProcess =$x("//a[@id='opsbar-transitions_more']");
    private final SelenideElement accomplishedWork =$x("//span[text()='Выполнено']/parent::a[@role='menuitem']");


    public List<String> statusCheck() {
        String statusText = statusVal.shouldBe(Condition.visible).getText();
        String fixVersionsText = fixVersions.shouldBe(Condition.visible).getText();
        return List.of(statusText, fixVersionsText);
    }

    public void changeStatus() {
        actionInWork.click();
        businessProcess.click();
        accomplishedWork.shouldBe(Condition.visible).click();
    }
}

