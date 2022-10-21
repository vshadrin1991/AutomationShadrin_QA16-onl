package Lecture18;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = "@smoke",
        plugin = {
                "json:target/cucumber.json",
                "html:target/site/cucumber-pretty"
        },
        glue = "cucumberSteps/moodpanda")
public class RunMoodpandaCucumber extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
