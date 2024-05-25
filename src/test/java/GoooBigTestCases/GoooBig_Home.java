package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigListener.OCRHelper;
import GoooBigListener.TestListener;
import GoooBigScreens.HomeScreen;
import GoooBigScreens.Login;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_Home extends TestBase {
    HomeScreen homeScreen;

    @Test(priority = 1)
    @Description("This test attempts to verify logo is displayed.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void IsLogoExistInHomeScreen(){
        homeScreen = new HomeScreen(driver);
        Allure.step("Check Logo in home screen are display.");
        Assert.assertTrue(homeScreen.isLogoDisplay());
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println("Logo Is Exist In Home Page.");
        Allure.addAttachment("Test Output", "text/plain", "Output Of testcase: " + "TEST CASE PASSED and Logo Is Exist In Home Page.");
    }

    @Test(priority = 2)
    @Description("This test attempts to verify switched between options home screen.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void switchedRunManageOptionsHomeScreen() throws InterruptedException {
        homeScreen = new HomeScreen(driver);
        Allure.step("switch to Run Management.");
        homeScreen.clickOnRunManage();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        Allure.step("switch to Another Services.");
        homeScreen.clickOnAnotherServices();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        Allure.step("switch to Daily Transactions.");
        homeScreen.clickOnDailyTransactions();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        Allure.addAttachment("Test Output", "text/plain", "Output of the testcase is: " + "TEST CASE PASSED and user can switched between all options.");
    }


    @Test(priority = 3)
    @Description("This test attempts to verify the Search bar on the home screen.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifySearchBar() {
        homeScreen = new HomeScreen(driver);
        Allure.step("Verify search with valid data.");
        homeScreen.sendKeysAndPressEnterSearchBar("الكاشير");
        boolean searchResult = homeScreen.isClientsExist();
        Assert.assertFalse(searchResult, "Search results found when none were expected");
    }
}































/*

    @Test(priority = 3)
    public void checkForBranch(){
        homeScreen = new HomeScreen();
        homeScreen.clickOnHamburgerMenu();
        String Text = homeScreen.getTextOfElement();
        System.out.println(Text);
        String result = "not contain";
        if (Text != null && Text.contains("فرع")) {
            result = "success";
        }

        // Print the result
        System.out.println("Result: " + result);
        // Check if the word "الرياض" is present in the content-desc attribute
        boolean isWordPresent = homeScreen.isWordPresentInContentDesc();
        // Print the result
        if (isWordPresent) {
            System.out.println("The word 'الرياض' is present in the content-desc attribute.");
        } else {
            System.out.println("The word 'الرياض' is not present in the content-desc attribute.");
        }
        homeScreen.BackForward();
    }*/

