package Lecture17;

import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.rw.HomePage;
import pageObjects.rw.SearchResultPage;

public class RW_Test extends SelenideBaseTest {

    @Test
    public void checkResultSearch_Test() {
        get(HomePage.class)
                .enterFrom("Витебск")
                .enterTo("Минск")
                .enterMiddleCalendar("1")
                .clickSearch();

        get(SearchResultPage.class).checkResultCount(5);
    }

}
