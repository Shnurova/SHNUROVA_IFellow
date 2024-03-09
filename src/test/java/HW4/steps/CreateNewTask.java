package HW4.steps;

import HW4.TestBase;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class CreateNewTask extends TestBase {

    @Когда("запомнить количесво созданных задач в переменную {string}")
    public void saveTaskCount(String var) {
        variableContainer.setVar(var, jiraOpenTasks.getTaskCount());
    }

    @Когда("создать новую задачу")
    public void createProject() {
        jiraTopPanel.createProject();
    }

    @Когда("заполнить карточку задачи")
    public void fillTheme() {
        jiraCreateProject.fillProjectData(TASK_SUMMARY, TASK_DESCRIPTION);
    }

    @Когда("Сравнить переменную {string} и переменную {string}")
    public void compareTask(String var, String newVar) {
        int oldVarValue = variableContainer.getVar(var);
        int newVarValue = variableContainer.getVar(newVar);
        assertNotSame(oldVarValue, newVarValue);
    }

    @Когда("перевести задачу по статусам до закрытого")
    public void transferByStatus() {
        jiraTopPanel.searchText(TASK_SUMMARY);
        jiraSearchTask.changeStatus();

    }

    @Тогда("статус отображается \"ГОТОВО\"")
    public void checkStatusTask() {
        String projectStatusCompleted = jiraSearchTask.getReadyStatus();
        Assertions.assertEquals("ГОТОВО", projectStatusCompleted);
    }
}