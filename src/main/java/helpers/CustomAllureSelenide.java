package helpers;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.LogEvent;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.util.Optional;

import static io.qameta.allure.util.ResultsUtils.getStatus;
import static io.qameta.allure.util.ResultsUtils.getStatusDetails;

public class CustomAllureSelenide extends AllureSelenide {
    private final AllureLifecycle lifecycle;

    public CustomAllureSelenide(final AllureLifecycle lifecycle) {
        super(lifecycle);
        this.lifecycle = lifecycle;
    }

    @Override
    public void afterEvent(final LogEvent event) {
        lifecycle.getCurrentTestCaseOrStep().flatMap(parentUuid -> getScreenshotBytes()).ifPresent(bytes -> lifecycle.addAttachment("Screenshot", "image/png", "png", bytes));

        lifecycle.getCurrentTestCaseOrStep().ifPresent(parentUuid -> {
            switch (event.getStatus()) {
                case PASS:
                    lifecycle.updateStep(step -> step.setStatus(Status.PASSED));
                    break;
                case FAIL:
                    lifecycle.updateStep(stepResult -> {
                        stepResult.setStatus(getStatus(event.getError()).orElse(Status.BROKEN));
                        stepResult.setStatusDetails(getStatusDetails(event.getError()).orElse(new StatusDetails()));
                    });
                    break;
                default:
                    break;
            }
            lifecycle.stopStep();
        });
    }

    private static Optional<byte[]> getScreenshotBytes() {
        try {
            return WebDriverRunner.hasWebDriverStarted()
                    ? Optional.of(((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES))
                    : Optional.empty();
        } catch (WebDriverException e) {
            return Optional.empty();
        }
    }
}
