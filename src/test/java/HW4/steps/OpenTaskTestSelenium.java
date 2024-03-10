package HW4.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class OpenTaskTestSelenium extends TestBase {

    @Когда("перейти в задачу TestSelenium")
    public void openTaskTestSelenium(){
        jiraTopPanel.searchText("TestSelenium_bug");
    }

    @Тогда("отображается статус задачи \"СДЕЛАТЬ\"")
    public void checkStatusTest() {
        List<String> projectStatus = jiraSearchTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", projectStatus.get(0));
    }
    @Тогда("отображается версия задачи \"Version 2.0\"")
    public void checkVersionTest() {
        List<String> projectStatus = jiraSearchTask.statusCheck();
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }
}
