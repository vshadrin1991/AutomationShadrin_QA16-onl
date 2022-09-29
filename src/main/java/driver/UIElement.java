package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class UIElement implements WebElement {
    private final WebElement webElement;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public UIElement(WebElement webElement) {
        this.webElement = webElement;
        this.driver = getWebDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    @Override
    public void click() {
        try {
            System.out.println("click from wrapper!");
            webElement.click();
        } catch (ElementClickInterceptedException e) {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }
    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
