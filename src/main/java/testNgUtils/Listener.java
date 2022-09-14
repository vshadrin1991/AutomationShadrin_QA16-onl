package testNgUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("on start");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("on test failure");
    }
}
