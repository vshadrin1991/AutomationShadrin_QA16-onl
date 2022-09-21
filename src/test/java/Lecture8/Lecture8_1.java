package Lecture8;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class Lecture8_1 extends BaseTest {

    @Test
    public void login() {

        new LoginPage()
                .open()
                .enterUsername(System.getProperty("username"))
                .enterPassword(System.getProperty("password"))
                .clickLogin()
                .verifyThatLoginPageIsClosed();
        new ProductPage().verifyPageTitle();
    }
}

