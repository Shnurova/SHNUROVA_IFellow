package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class JiraCreateProject {

    private final SelenideElement createIssueSubmit =$x("//input[@id='create-issue-submit']");
    private final SelenideElement summaryInput =$x("//input[@id='summary']");
    private final SelenideElement iframe = $x("//iframe[@id='mce_0_ifr']");
    private final SelenideElement bodyOfIframe = $x("//body[@id='tinymce']");

    public void fillProjectData(String summaryText, String descriptionText) {
        summaryInput.shouldBe(Condition.visible).sendKeys(summaryText);
        driver().switchTo().frame(iframe);
        bodyOfIframe.setValue(descriptionText);
        driver().switchTo().parentFrame();
        createIssueSubmit.click();
        Selenide.refresh();
    }


}
