package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class JiraPageVerifier {
    private final SelenideElement profileItem = $x("//a[@id='header-details-user-fullname']");
    private final SelenideElement subNavigationTitle = $x("//h1/span[@id='issues-subnavigation-title']");

    public Boolean isProfileItemDisplayed() {
        waitSignIn();
        return profileItem.isDisplayed();
    }

    public void waitSignIn() {
        profileItem.shouldBe(Condition.visible);
    }

    public Boolean isTitleExists(String title) {
        return subNavigationTitle.getText().equals(title);
    }
}
