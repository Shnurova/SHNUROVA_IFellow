package test;

import hooks.WebHooks;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import config.PropertiesConfig;

@DisplayName("EduJira")
public class EduJiraTest extends WebHooks {

    @Epic(value = "EduJiraTest")
    @Test
    @DisplayName("Логирование")
    public void loginTest() {
        jiraLoginPage.signIn(PropertiesConfig.config.login(), PropertiesConfig.config.password());
        Assertions.assertTrue(jiraPageVerifier.isProfileItemDisplayed());
    }

    @Epic(value = "EduJiraTest")
    @Test
    @DisplayName("Выбор проекта Test")
    public void chooseProjectTest() {
        jiraLoginPage.signIn(PropertiesConfig.config.login(), PropertiesConfig.config.password());
        jiraTopPanel.chooseProject();
        Assertions.assertTrue(jiraPageVerifier.isTitleExists("Открытые задачи"));
    }

    @Epic(value = "EduJiraTest")
    @Test
    @DisplayName("Проверка полей задачи TestSelenium")
    public void fieldsTaskCheckTest() {
        jiraLoginPage.signIn(PropertiesConfig.config.login(), PropertiesConfig.config.password());
        jiraPageVerifier.waitSignIn();
        jiraTopPanel.searchText("TestSelenium_bug");
        List<String> projectStatus = jiraSearchTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", projectStatus.get(0));
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }

    @Epic(value = "EduJiraTest")
    @Test
    @DisplayName("Создание задачи и изменение статуса")
    public void createTaskAndStatusCheck() {
        jiraLoginPage.signIn(PropertiesConfig.config.login(), PropertiesConfig.config.password());
        jiraTopPanel.chooseProject();
        int taskCount = jiraOpenTasks.getTaskCount();
        jiraTopPanel.createProject();
        jiraCreateProject.fillProjectData(PropertiesConfig.config.taskSummary(), PropertiesConfig.config.taskDescription());
        int newTaskCount = jiraOpenTasks.getTaskCount();
        Assertions.assertFalse(taskCount != newTaskCount);
        jiraTopPanel.searchText(PropertiesConfig.config.taskSummary());
        jiraSearchTask.changeStatus();
        String projectStatusCompleted = jiraSearchTask.getReadyStatus();
        Assertions.assertEquals("ГОТОВО", projectStatusCompleted);
    }
}
