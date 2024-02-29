package HW3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.DisplayName;

public class EduJiraTest extends WebHooks {

    @Test
    @DisplayName("Авторизация")
    public void loginTest() {
        jiraLoginPage.signIn(LOGIN, PASSWORD);
        Assertions.assertTrue(jiraPageVerifier.isProfileItemDisplayed());
    }

    @Test
    @DisplayName("Выбор проекта Test")
    public void chooseProjectTest() {
        jiraLoginPage.signIn(LOGIN, PASSWORD);
        jiraTopPanel.chooseProject();
        Assertions.assertTrue(jiraPageVerifier.isTitleExists("Открытые задачи"));
    }

    @Test
    @DisplayName("Проверка полей задачи TestSelenium")
    public void fieldsTaskCheckTest() {
        jiraLoginPage.signIn(LOGIN, PASSWORD);
        jiraPageVerifier.waitSignIn();
        jiraTopPanel.searchText("TestSelenium");
        List<String> projectStatus = jiraSearchTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", projectStatus.get(0));
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }

    @Test
    @DisplayName("Создание задачи и изменение статуса")
    public void createTaskAndStatusCheck() {
        jiraLoginPage.signIn(LOGIN, PASSWORD);
        jiraTopPanel.chooseProject();
        int taskCount = jiraOpenTasks.getTaskCount();
        jiraTopPanel.createProject();
        jiraCreateProject.fillProjectData(TASK_SUMMARY, TASK_DESCRIPTION);
        int newTaskCount = jiraOpenTasks.getTaskCount();
        Assertions.assertFalse(taskCount != newTaskCount);
        jiraTopPanel.searchText(TASK_SUMMARY);
        jiraSearchTask.changeStatus();
        String projectStatusCompleted = jiraSearchTask.getReadyStatus();
        Assertions.assertEquals("ГОТОВО", projectStatusCompleted);
    }
}
