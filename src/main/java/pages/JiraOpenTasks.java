package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class JiraOpenTasks {
    private final SelenideElement showTask =$x("//div[@class='showing']/child::span");

    public int getTaskCount(){
       String tasksText = showTask.getText();
       String[] splitText = tasksText.split(" ");
       return Integer.parseInt(splitText[2]);
    }

}
