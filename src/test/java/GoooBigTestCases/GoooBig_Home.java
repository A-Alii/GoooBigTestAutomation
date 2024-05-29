package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.HomeScreen;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_Home extends TestBase {
    private HomeScreen homeScreen;
    @Test(priority = 1)
    @Description("This test attempts to verify the warehouse name is consistent across different screens.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyWarehouseName() {
        homeScreen = new HomeScreen();

        // Retrieve warehouse name from home screen
        String warehouseNameInHomeScreen = homeScreen.getTextOfWarehouseInHomeScreen();
        System.out.println("اسم الفرع فى الصفحة الرئيسية : " + warehouseNameInHomeScreen);

        // Navigate to Warehouses screen and retrieve warehouse name
        homeScreen.NavigateToWarehouses();
        String WarehouseName = homeScreen.getTextOfWarehouseName();
        System.out.println("اسم الفرع فى صفحة الفروع : " + WarehouseName);
        homeScreen.NavigateBack();

        // Assert that the warehouse names contain each other
        Allure.step("Verify warehouse name in home screen contains warehouse name from warehouse screen");
        Assert.assertTrue(
                warehouseNameInHomeScreen.contains(WarehouseName) || WarehouseName.contains(warehouseNameInHomeScreen),
                "The warehouse names do not contain each other!"
        );

        // Retrieve warehouse name from hamburger menu
        homeScreen.clickOnHamburgerMenu();
        String warehouseNameInHamburgerMenu = homeScreen.getTextOfWarehouseInHamburgerMenu();
        System.out.println("اسم الفرع فى صفحة المنيو : " + warehouseNameInHamburgerMenu);

        // Extract the text between parentheses
        String extractedName = extractTextBetweenParentheses(warehouseNameInHamburgerMenu);
        System.out.println("Debug - Extracted Name: " + extractedName);

        Allure.step("Verify warehouse name in home screen contains warehouse name from hamburger menu");

        // Normalize names for comparison
        String normalizedHomeScreenName = warehouseNameInHomeScreen.trim();
        String normalizedHamburgerMenu = extractedName.trim();
        System.out.println("Normalized Home Screen Name: " + normalizedHomeScreenName);
        System.out.println("Normalized Hamburger Menu: " + normalizedHamburgerMenu);

        Assert.assertTrue(
                normalizedHamburgerMenu.contains(normalizedHomeScreenName) || normalizedHomeScreenName.contains(normalizedHamburgerMenu),
                "The warehouse names do not contain each other!"
        );

        // Final navigation back and attach output to Allure report
        homeScreen.NavigateBack();
        System.out.println("Assertion Done Successfully.");
        Allure.addAttachment("Test Output for Verify Warehouse Name", "text/plain", "Output of testcase: TEST CASE PASSED and Logo Is Exist In Home Page and Warehouse Name is displayed.");
    }
    @Test(priority = 2)
    @Description("This test attempts to verify the logo is displayed.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void IsLogoExistInHomeScreen() {
        homeScreen = new HomeScreen();
        Allure.step("Check Logo in home screen is displayed.");
        Assert.assertTrue(homeScreen.isLogoDisplay(), "Logo is not displayed on Home Page.");
        System.out.println("Logo Is Exist In Home Page.");
        Allure.addAttachment("Test Output", "text/plain", "Output of testcase: TEST CASE PASSED and Logo Is Exist In Home Page.");
    }
    @Test(priority = 3)
    @Description("This test attempts to verify switching between options on the home screen.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void switchedRunManageOptionsHomeScreen() throws InterruptedException {
        homeScreen = new HomeScreen();
        Allure.step("Switch to Run Management.");
        homeScreen.clickOnRunManage();
        addScreenshotToAllure();
        Thread.sleep(2000);

        Allure.step("Switch to Another Services.");
        homeScreen.clickOnAnotherServices();
        addScreenshotToAllure();
        Thread.sleep(2000);

        Allure.step("Switch to Daily Transactions.");
        homeScreen.clickOnDailyTransactions();
        addScreenshotToAllure();
        Thread.sleep(2000);

        Allure.addAttachment("Test Output", "text/plain", "Output of testcase: TEST CASE PASSED and user can switch between all options.");
    }
    @Test(priority = 4)
    @Description("This test attempts to verify the Search bar on the home screen.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifySearchBar() {
        homeScreen = new HomeScreen();
        Allure.step("Verify search with valid data.");
        homeScreen.sendKeysAndPressEnterSearchBar("الكاشير");
        boolean searchResult = homeScreen.isClientsExist();
        homeScreen.hideKeyboard();
        Assert.assertFalse(searchResult, "Search results found when none were expected");
    }
    @Test(priority = 5)
    @Description("This test attempts to verify the Search bar on the home screen.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyUpdateFunctionality() {
        homeScreen = new HomeScreen();
        Allure.step("Verify Update Functionality.");
        homeScreen.clickOnCancelIcon();
        boolean UpdateResult = homeScreen.UpdateSectionIsDisplay();
        Assert.assertFalse(UpdateResult, "Update results found when none were expected");
    }
    @Test(priority = 6)
    @Description("This test attempts to verify switching between navbar options on the home screen.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void switchedNavbarHomeScreen() throws InterruptedException {
        homeScreen = new HomeScreen();
        Allure.step("Switch to Favorites.");
        homeScreen.clickOnFavoriteIcon();
        addScreenshotToAllure();
        Thread.sleep(1000);

        Allure.step("Switch to Categories.");
        homeScreen.clickOnCategoriesIcon();
        addScreenshotToAllure();
        Thread.sleep(1000);

        Allure.step("Switch to More.");
        homeScreen.clickOnMoreIcon();
        addScreenshotToAllure();
        homeScreen.NavigateBack();
        Thread.sleep(1000);

        Allure.step("Switch to Home.");
        homeScreen.clickOnHomeIcon();
        Allure.addAttachment("Test Output", "text/plain", "Output of testcase: TEST CASE PASSED and user can switch between all options.");
    }
    // Helper method to extract text between parentheses
    private String extractTextBetweenParentheses(String text) {
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
    // Helper method to add screenshot to Allure report
    private void addScreenshotToAllure() {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
