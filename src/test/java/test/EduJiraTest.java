package test;

import hooks.WebHooks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.DisplayName;

@DisplayName("EduJira")
public class EduJiraTest extends WebHooks {

    @Test
    @DisplayName("Логирование")
    public void loginTest() {
        jiraLoginPage.signIn(config.getProperty("login"), config.getProperty("password"));
        Assertions.assertTrue(jiraPageVerifier.isProfileItemDisplayed());
    }

    @Test
    @DisplayName("Выбор проекта Test")
    public void chooseProjectTest() {
        jiraLoginPage.signIn(config.getProperty("login"), config.getProperty("password"));
        jiraTopPanel.chooseProject();
        Assertions.assertTrue(jiraPageVerifier.isTitleExists("Открытые задачи"));
    }

    @Test
    @DisplayName("Проверка полей задачи TestSelenium")
    public void fieldsTaskCheckTest() {
        jiraLoginPage.signIn(config.getProperty("login"), config.getProperty("password"));
        jiraPageVerifier.waitSignIn();
        jiraTopPanel.searchText("TestSelenium_bug");
        List<String> projectStatus = jiraSearchTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", projectStatus.get(0));
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }

    @Test
    @DisplayName("Создание задачи и изменение статуса")
    public void createTaskAndStatusCheck() {
        jiraLoginPage.signIn(config.getProperty("login"), config.getProperty("password"));
        jiraTopPanel.chooseProject();
        int taskCount = jiraOpenTasks.getTaskCount();
        jiraTopPanel.createProject();
        jiraCreateProject.fillProjectData(config.getProperty("task_summary"), config.getProperty("task_description"));
        int newTaskCount = jiraOpenTasks.getTaskCount();
        Assertions.assertFalse(taskCount != newTaskCount);
        jiraTopPanel.searchText(config.getProperty("task_summary"));
        jiraSearchTask.changeStatus();
        String projectStatusCompleted = jiraSearchTask.getReadyStatus();
        Assertions.assertEquals("ГОТОВО", projectStatusCompleted);
    }
}
