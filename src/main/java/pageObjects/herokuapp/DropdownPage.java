package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class DropdownPage extends BasePage {
    private By dropdown = By.id("dropdown");
    private By title = By.tagName("h3");

    public DropdownPage verifyPageTitle(String text) {
        Assert.assertEquals(getText(title), text);
        return this;
    }

    public DropdownPage select(Integer index) {
        super.select(dropdown, index);
        return this;
    }

    public DropdownPage verifySelectedValue(String value) {
        Select select = new Select(findElement(dropdown));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), value);
        return this;
    }
}
