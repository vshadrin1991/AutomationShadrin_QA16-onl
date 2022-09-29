package wrappers;


import com.google.inject.Inject;
import module.BaseTestModule;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.google.GooglePage;


public class WrapperTests extends BaseTestModule {

    @Inject
    GooglePage googlePage;

    @Parameters("search")
    @Test
    public void test(String value) {
        googlePage
                .goTo()
                .enterSearch(value);
    }
}
