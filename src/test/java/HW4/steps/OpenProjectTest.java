package HW4.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

public class OpenProjectTest extends TestBase {

    @Когда("перейти в проект TEST")
    public void openProjectTest(){
        jiraTopPanel.chooseProject();
    }

    @Тогда("отображаются открытые задачи")
    public void choosedProjectTest() {
        Assertions.assertTrue(jiraPageVerifier.isTitleExists("Открытые задачи"));
    }

}
