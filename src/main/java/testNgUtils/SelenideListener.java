package testNgUtils;

import com.codeborne.selenide.Configuration;
import org.testng.ITestContext;
import org.testng.ITestListener;
import propertyHelper.PropertyReader;

import static propertyHelper.PropertyReader.getProperties;

public class SelenideListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        String propertyName = context.getSuite().getParameter("config") == null ? System.getProperty("config") : context.getSuite().getParameter("config");
        new PropertyReader(propertyName);
        setUpSelenideConfigs();
    }

    public void setUpSelenideConfigs() {
        Configuration.baseUrl = getProperties().getProperty("url");
        Configuration.browser = getProperties().containsKey("browser") ? getProperties().getProperty("browser") : Configuration.browser;
    }
}
