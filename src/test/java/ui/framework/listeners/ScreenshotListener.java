package ui.framework.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.framework.drivermanager.DriverManager;
import ui.framework.util.Utils;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        Utils.captureScreenShot(DriverManager.getDriver(), result.getName(), true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Utils.captureScreenShot(DriverManager.getDriver(), result.getName(), false);
    }
}
