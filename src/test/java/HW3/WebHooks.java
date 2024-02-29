package HW3;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    public static final JiraLoginPage jiraLoginPage = new JiraLoginPage();
    public static final JiraTopPanel jiraTopPanel = new JiraTopPanel();
    public static final JiraOpenTasks jiraOpenTasks = new JiraOpenTasks();
    public static final JiraSearchTask jiraSearchTask = new JiraSearchTask();
    public static final JiraPageVerifier jiraPageVerifier = new JiraPageVerifier();
    public static final JiraCreateProject jiraCreateProject = new JiraCreateProject();

    public static final String LOGIN = "AT15";
    public static final String PASSWORD = "Qwerty123";

    final String TASK_SUMMARY = "TEST AT15";
    final String TASK_DESCRIPTION = "SUPER PUPER DUPER NIGHTMARE FURIOUS DESCRIPTION";

    @BeforeEach
    public void initBrowser() {
        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
