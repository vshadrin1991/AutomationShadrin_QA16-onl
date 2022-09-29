package pageObjects.google;

import module.BaseDriverModule;
import org.openqa.selenium.By;

public class GooglePage extends BaseDriverModule {

    private final By search = By.name("q");

    public GooglePage goTo() {
        super.driver.get("https://www.google.com/");
        return this;
    }

    public GooglePage enterSearch(String key) {
        super.driver.findElement(search).sendKeys(key);
        return this;
    }
}
