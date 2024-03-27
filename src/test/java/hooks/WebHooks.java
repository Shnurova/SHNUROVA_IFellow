package hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.CustomAllureSelenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
import config.PropertiesConfig;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    public static final JiraLoginPage jiraLoginPage = new JiraLoginPage();
    public static final JiraTopPanel jiraTopPanel = new JiraTopPanel();
    public static final JiraOpenTasks jiraOpenTasks = new JiraOpenTasks();
    public static final JiraSearchTask jiraSearchTask = new JiraSearchTask();
    public static final JiraPageVerifier jiraPageVerifier = new JiraPageVerifier();
    public static final JiraCreateProject jiraCreateProject = new JiraCreateProject();

    @BeforeEach
    @Step("Открытие браузера и сайта Education Jira")
    public void initBrowser() {
        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide(Allure.getLifecycle()));
        Selenide.open(PropertiesConfig.config.site());
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
