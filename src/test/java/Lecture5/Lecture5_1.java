package Lecture5;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class Lecture5_1 {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.google.com/");
    }

    @Test
    public void test1() {
        getWebDriver().findElement(By.name("q")).sendKeys("Привет мир", Keys.ENTER);
        List<WebElement> results = getWebDriver().findElements(By.cssSelector("[lang='ru'] h3"));
        for (WebElement element : results) {
            Assert.assertTrue(element.getText().contains("Мир"));
        }
    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }
}
