package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTopPanel {
    private final SelenideElement projectDropDawn =$x("//a[@id='browse_link']");
    private final SelenideElement testButton =$x("//a[@id='admin_main_proj_link_lnk']");
    private final SelenideElement quickSearchInput =$x("//input[@id='quickSearchInput']");
    private final SelenideElement createLink =$x("//a[@id='create_link']");
    private final SelenideElement issuesSideItem = $x("//span[@title='Задачи']/parent::a[@class='aui-nav-item ']");


    public void chooseProject() {
        projectDropDawn.click();
        testButton.click();
        issuesSideItem.shouldBe(Condition.editable).click();
    }

    public void searchText(String text){
        quickSearchInput.sendKeys(text);
        quickSearchInput.pressEnter();
    }

    public void createProject() {
        createLink.click();
    }
}
