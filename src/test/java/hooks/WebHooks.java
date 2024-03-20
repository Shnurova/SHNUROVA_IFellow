package hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    public static final JiraLoginPage jiraLoginPage = new JiraLoginPage();
    public static final JiraTopPanel jiraTopPanel = new JiraTopPanel();
    public static final JiraOpenTasks jiraOpenTasks = new JiraOpenTasks();
    public static final JiraSearchTask jiraSearchTask = new JiraSearchTask();
    public static final JiraPageVerifier jiraPageVerifier = new JiraPageVerifier();
    public static final JiraCreateProject jiraCreateProject = new JiraCreateProject();

    public static Properties config = new Properties();

    @BeforeAll
    public static void readConfig() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream resourceStream = loader.getResourceAsStream("not.properties")) {
            config.load(resourceStream);
        }
    }

    @BeforeEach
//    @Step("Открытие браузера и сайта \"{config.getProperty(\"site\")}\"")
    @Step("Открытие браузера и сайта")
    public void initBrowser() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false)
        );
        Selenide.open(config.getProperty("site"));
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
