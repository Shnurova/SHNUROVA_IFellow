package pages;

import static org.apache.commons.lang3.StringUtils.SPACE;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class JiraOpenTasks {
    private final SelenideElement showTask =$x("//div[@class='showing']/child::span").as("Колличество задач");

    @Step("Определение колличества задач")
    public int getTaskCount(){
        String tasksText = showTask.getText();
        String[] splitText = tasksText.split(SPACE);
        return Integer.parseInt(splitText[2]);
    }

}
