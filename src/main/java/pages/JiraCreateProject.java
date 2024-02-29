package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class JiraCreateProject {

    private final SelenideElement createIssueSubmit =$x("//input[@id='create-issue-submit']");
    private final SelenideElement summaryInput =$x("//input[@id='summary']");
    private final SelenideElement descriptionField = $x("//textarea[@id='description']");

    public void fillProjectData(String summaryText, String descriptionText) {
        summaryInput.shouldBe(Condition.visible).sendKeys(summaryText);
        descriptionField.sendKeys(descriptionText);
        createIssueSubmit.click();

    }


}
