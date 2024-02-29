package HW3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.DisplayName;

import pages.*;

public class EduJiraTest extends WebHooks {
    private final JiraLoginPage jiraLoginPage = new JiraLoginPage();
    private final JiraTopPanel jiraTopPanel = new JiraTopPanel();
    private final JiraOpenTasks jiraOpenTasks = new JiraOpenTasks();
    private final JiraSearchTask jiraSearchTask = new JiraSearchTask();
    private final JiraPageVerifier jiraPageVerifier = new JiraPageVerifier();
    private final JiraCreateProject jiraCreateProject = new JiraCreateProject();

    private final String login = "AT15";
    private final String password = "Qwerty123";


    @Test
    @DisplayName("Авторизация")
    public void loginTest() {
        jiraLoginPage.signIn(login, password);
        Assertions.assertTrue(jiraPageVerifier.isProfileItemDisplayed());
    }

    @Test
    @DisplayName("Выбор проекта Test")
    public void chooseProjectTest() {
        jiraLoginPage.signIn(login, password);
        jiraTopPanel.chooseProject();
        Assertions.assertTrue(jiraPageVerifier.isTitleExists("Открытые задачи"));
    }

    @Test
    @DisplayName("Проверка полей задачи")
    public void fieldsTaskCheckTest() {
        jiraLoginPage.signIn(login, password);
        jiraPageVerifier.waitSignIn();
        jiraTopPanel.searchText("TestSelenium");
        List<String> projectStatus = jiraSearchTask.statusCheck();
        Assertions.assertEquals("СДЕЛАТЬ", projectStatus.get(0));
        Assertions.assertEquals("Version 2.0", projectStatus.get(1));
    }

    @Test
    @DisplayName("Создание задачи и изменение статуса")
    public void createTaskAndStatusCheck() {

        final String summary = "TEST AT15";
        final String description = "SUPER PUPER DUPER NIGHTMARE FURIOUS DESCRIPTION";

        jiraLoginPage.signIn(login, password);
        jiraTopPanel.chooseProject();
        int taskCount = jiraOpenTasks.getTaskCount();
        jiraTopPanel.createProject();
        jiraCreateProject.fillProjectData(summary, description);
        int newTaskCount = jiraOpenTasks.getTaskCount();
        Assertions.assertFalse(taskCount != newTaskCount);
        jiraTopPanel.searchText(summary);
        jiraSearchTask.changeStatus();
        List<String> projectStatus = jiraSearchTask.statusCheck();
        Assertions.assertEquals("ГОТОВО", projectStatus.get(0));
    }
}
