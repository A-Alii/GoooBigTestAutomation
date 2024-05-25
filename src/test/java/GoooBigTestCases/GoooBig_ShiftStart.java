package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.BranchesAndWarehouses;
import GoooBigScreens.ShiftStart;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_ShiftStart extends TestBase {
    ShiftStart shiftStart;

    /*@Test(priority = 1)
    @Description("This test attempts to verify click on Apply without enter Box Fund Start.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void clickOnApplyWithoutEnterBoxFundStart() throws InterruptedException {
        shiftStart = new ShiftStart(driver);
        Allure.step("verify to enter Empty Data To Box Fund");
        shiftStart.SendKeysToBox(" ");
        Allure.step("verify to select delivery from");
        shiftStart.clickOnDeliveryFirst();
        Allure.step("verify to click on Apply Button");
        shiftStart.ClickOnApplyButton();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        Allure.step("verify to clear fields");
        shiftStart.clearFields();
        System.out.println("من فضلك ادخل رصيد الصندوق");
    }*/

    @Test(priority = 2)
    @Description("This test attempts to verify click on Apply with valid data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyClickOnApplyWithValidData() throws InterruptedException {
        shiftStart = new ShiftStart(driver);
        Allure.step("verify to enter a valid data to Box Fund");
        shiftStart.SendKeysToBox("5000");
        Allure.step("verify to select delivery from");
        shiftStart.clickOnDeliveryFirst();
        Allure.step("verify to click on Apply Button");
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        shiftStart.ClickOnApplyButton();
        System.out.println("Shift Started Successfully");
        shiftStart.ClickOnCashier();
        shiftStart.hideKeyboard();
    }






























    /*@Test(priority = 3)
    public void testcase3() throws InterruptedException {
        shiftStart = new ShiftStart();
        shiftStart.SendKeysToBox("5000");
        shiftStart.clickOnDeliveryFrom();
        shiftStart.ClickOnApplyButton();
        *//*String TextNav = shiftStart.navbarIsVisible();
        Assert.assertEquals(TextNav, "بداية دوام");*//*
    }*/

    /*@Test(priority = 4)
    public void testcase4() throws InterruptedException {
        shiftStart = new ShiftStart(driver);
        shiftStart.ClickOnShifts();
        shiftStart.navigateBack();
        System.out.println("Shift Is Open And Can Access To Manage Shift");
    }*/

    /*@Test(priority = 4)
    public void testcase5() throws InterruptedException {
        shiftStart = new ShiftStart(driver);
        //shiftStart.ClickOnCashier();
        //shiftStart.hideKeyboard();
        System.out.println("Products Screen Are display");
    }*/





}
