package Lecture12;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.ProductPage;

public class Lecture12_Test extends BaseTest {


    @Test
    public void test() {
        String productName = "Sauce Labs Backpack";
        get(ProductPage.class)
                .verifyPageTitle()
                .addProductToBasket(productName);
    }

}
