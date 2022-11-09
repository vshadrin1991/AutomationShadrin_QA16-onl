package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.testng.Assert;

import java.util.Optional;
import java.util.Properties;

import static propertyHelper.PropertyReader.getProperties;

@Log4j
public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        Properties properties = getProperties();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(properties.getProperty("browser.configs").split(";"));
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        if (properties.containsKey("interceptor") && !properties.get("interceptor").toString().isEmpty() && Boolean.parseBoolean(properties.getProperty("interceptor")))
            creteDevToolListeners(driver);
        webDriver.set(driver);
    }

    private void creteDevToolListeners(ChromeDriver driver) {
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            if (responseReceived.getResponse().getUrl().contains(getProperties().getProperty("api"))) {
                Assert.assertTrue(responseReceived.getResponse().getStatus().toString().startsWith("2"), "Ops... Something was wrong with request " + responseReceived.getResponse().getUrl());
                log.debug("URL :: " + responseReceived.getResponse().getUrl());
                log.debug("Status Code :: " + responseReceived.getResponse().getStatus());
                log.debug("Response Time :: " + responseReceived.getResponse().getResponseTime().get());
            }
        });
    }
}
