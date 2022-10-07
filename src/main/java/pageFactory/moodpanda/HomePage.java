package pageFactory.moodpanda;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageObjects.baseObjects.BasePage;

public class HomePage extends BasePage {

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Get started")
    WebElement getStartedBtn;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        load();
        return this;
    }

    public HomePage clickGetStarted() {
        click(getStartedBtn);
        return this;
    }
}
