package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleDriver {
    private static WebDriver webDriver;

    {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            //WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            //WebDriverManager.getInstance("chrome").setup();
            webDriver = new ChromeDriver(getChromeOptions());
            //without WebDriverManager
            //setWebDriver()
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    private static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver(getChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver = driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}
