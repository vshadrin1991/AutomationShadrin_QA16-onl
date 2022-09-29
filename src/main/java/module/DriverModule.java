package module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import driver.SimpleDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.SimpleDriver.getWebDriver;

public class DriverModule implements Module {
    @Override
    public void configure(Binder binder) {

    }

    @Provides
    public WebDriver getDrivers() {
        new SimpleDriver();
        return getWebDriver();
    }
}
