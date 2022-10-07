package pageObjects.moodpanda;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class HomePage extends MoodPandaBasePage {

    private By getStartedBtn = By.partialLinkText("Get started");
    private By title = By.cssSelector("[class^=container] > p[class^='title ']");

    public HomePage open() {
        load();
        isPageOpened();
        return this;
    }

    public HomePage clickGetStarted() {
        click(getStartedBtn);
        return this;
    }

    @Override
    public void isPageOpened() {
        waitVisibilityOfElement(title);
        verifyElementClickable(getStartedBtn);
    }
}
