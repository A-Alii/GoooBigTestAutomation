package GoooBigListener;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        AppiumDriver driver = ((TestBase) testClass).getDriver();
        System.out.println("Test failed: " + result.getName());
        // Setting the context attribute to indicate a failure
        result.getTestContext().setAttribute("haltExecution", true);
        // Take a screenshot
        if (driver != null) {
            Allure.addAttachment("Screenshot on failure", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onStart(ITestContext context) {
        // Do nothing
    }

    @Override
    public void onFinish(ITestContext context) {
        // Do nothing
    }
}
