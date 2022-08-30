package Lecture7;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class Lecture7_1 extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
    }
}
