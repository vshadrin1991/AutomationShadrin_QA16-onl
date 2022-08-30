package pageObjects.saucedemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");

    public LoginPage open() {
        getWebDriver().get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn);
        return this;
    }
}
