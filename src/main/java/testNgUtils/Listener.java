package testNgUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        Reporter.log(context.getSuite().getXmlSuite().getTest());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Ohh... this test was failed => " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        Reporter.log(context.getSuite().getXmlSuite().getTest());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Cool... this test was passed => " + result.getName());
    }
}
