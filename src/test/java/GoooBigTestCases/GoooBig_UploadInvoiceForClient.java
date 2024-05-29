package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.UploadInvoiceForClient;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class GoooBig_UploadInvoiceForClient extends TestBase {
    UploadInvoiceForClient cashierScreen;

    @Test(priority = 1)
    public void testcase1() {
        cashierScreen = new UploadInvoiceForClient();
        cashierScreen.ClickOnCashier();
        cashierScreen.smallNonTaxInvoice();
        cashierScreen.navigateBack();
        cashierScreen.navigateBack();
    }

    @Test(priority = 2)
    public void testcase2() throws InterruptedException {
        cashierScreen = new UploadInvoiceForClient();
        cashierScreen.clickOnCartEmpty();
        Thread.sleep(2000);
        System.out.println("There is no products in cart.");
    }

    @Test(priority = 3)
    public void testcase3() {
        cashierScreen = new UploadInvoiceForClient();
        cashierScreen.clickOnPhoneCategory();
        cashierScreen.clickOnAppleDepartment();
        cashierScreen.hideKeyboard();
        cashierScreen.clickOnProduct1();
        cashierScreen.goToCart();
        System.out.println("Cart contains a products");
    }

    @Test(priority = 4)
    public void testcase4() throws InterruptedException {
        cashierScreen = new UploadInvoiceForClient();
        cashierScreen.clickOnNextBasket();
        Allure.step("select client for invoice.");
        cashierScreen.clickOnNoticeCreditorButton();
        Thread.sleep(1000);
        cashierScreen.clickOnSelectClientForInvoice();
        Thread.sleep(2000);
        cashierScreen.selectClientName();
        Thread.sleep(1000);
        cashierScreen.clickOnSelection();
        cashierScreen.navigateBack();
        Allure.step("click on PostPaid Button.");
        cashierScreen.clickOnPostPaidButton();
        cashierScreen.clickOnConfirmationButton();
        Thread.sleep(4000);
        Allure.addAttachment("Screenshot for invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        cashierScreen.navigateBack();
        cashierScreen.navigateBack();
    }

}