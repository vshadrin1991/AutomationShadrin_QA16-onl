package Lecture4;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleDriver.getWebDriver;

public class Lecture4_2 {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @BeforeMethod
    public void beforeMethod() {
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void test1() {
        WebElement zipCode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//*[@value='Continue']"));
        zipCode.sendKeys("1111");
        continueButton.click();
        pause(2);
        WebElement updatedZipCode = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertTrue(updatedZipCode.isDisplayed());
    }

    @Test
    public void test2() {
        WebElement zipCode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//*[@value='Continue']"));
        zipCode.clear();
        zipCode.sendKeys("11111");
        continueButton.click();
        pause(2);
        WebElement updatedZipCode = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertFalse(updatedZipCode.isDisplayed());
    }

    @Test
    public void test3() {
        WebElement zipCode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//*[@value='Continue']"));
        zipCode.clear();
        zipCode.sendKeys("111111");
        continueButton.click();
        pause(2);
        WebElement updatedZipCode = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertTrue(updatedZipCode.isDisplayed());
    }

    @AfterTest
    public void postconditions(){
        getWebDriver().close();
    }

    private void pause(Integer timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
