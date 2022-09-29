package module;

import com.google.inject.Injector;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import testNgUtils.InvokedMethodListener;
import testNgUtils.Listener;

import static driver.SimpleDriver.closeWebDriver;

@Listeners({Listener.class, InvokedMethodListener.class})
@Guice(modules = {DriverModule.class})
public class BaseTestModule {

    protected <T> T get(Class<T> page) {
        Injector injector = com.google.inject.Guice.createInjector(new DriverModule());
        return injector.getInstance(page);
    }

    @AfterTest(alwaysRun = true)
    public void postcondition() {
        closeWebDriver();
    }

}
