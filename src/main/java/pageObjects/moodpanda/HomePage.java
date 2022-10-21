package pageObjects.moodpanda;

import org.openqa.selenium.By;

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
