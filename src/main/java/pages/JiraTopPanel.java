package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class JiraTopPanel {
    private final SelenideElement projectDropDawn =$x("//a[@id='browse_link']").as("Ссылка на 'Проекты'");
    private final SelenideElement testButton =$x("//a[@id='admin_main_proj_link_lnk']").as("Ссылка на вкладку 'Test' у 'Проекты'");
    private final SelenideElement quickSearchInput =$x("//input[@id='quickSearchInput']").as("Ссылка на 'Поиск'");
    private final SelenideElement createLink =$x("//a[@id='create_link']").as("Кнопка 'Создать'");
    private final SelenideElement issuesSideItem = $x("//span[@title='Задачи']/parent::a[@class='aui-nav-item ']").as("Кнопка 'Задачи' на боковой панели");


    @Step("Открыть проект \"TEST\"")
    public void chooseProject() {
        projectDropDawn.click();
        testButton.click();
        issuesSideItem.click();
    }

    @Step("Ввод в поиск задачи")
    public void searchText(String text){
        quickSearchInput.sendKeys(text);
        quickSearchInput.pressEnter();
    }

    @Step("Создать проект")
    public void createProject() {
        createLink.click();
    }
}
