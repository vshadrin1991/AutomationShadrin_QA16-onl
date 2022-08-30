package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class ProductPage extends BasePage {
    private final By title = By.xpath("//span[@class='title']");

    private WebElement getElementProduct(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='inventory_item']"));
    }

    private WebElement getProductPrice(String productName) {
        return getElementProduct(productName).findElement(By.className("inventory_item_price"));
    }

    private WebElement getAddToCartBtn(String productName) {
        return getElementProduct(productName).findElement(By.tagName("button"));
    }

    public ProductPage() {
        verifyPageUri();
    }

    public void verifyPageUri() {
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("inventory.html"));
    }

    public void verifyPageTitle() {
        Assert.assertEquals(getText(title), "PRODUCTS");
    }

    public void addProductToBasket(String productName) {
        click(getAddToCartBtn(productName));
    }

    public String getProductCost(String productName) {
        return getText(getProductPrice(productName));
    }
}
