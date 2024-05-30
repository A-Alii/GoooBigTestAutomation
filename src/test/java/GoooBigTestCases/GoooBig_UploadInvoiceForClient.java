package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.UploadInvoiceForClient;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoooBig_UploadInvoiceForClient extends TestBase {
    public String numberOnly = "";
    public int totalPostPaid = 0;
    public String numberOnlyPostPaid = "";
    public int amountPostPaid = 0;
    public int amountLast;
    UploadInvoiceForClient cashierScreen;
    private String test = "";
    private String test1 = "";

    @Test(priority = 1)
    public void testcase1() {
        cashierScreen = new UploadInvoiceForClient();
        cashierScreen.ClickOnCashier();
        cashierScreen.smallNonTaxInvoice();
        cashierScreen.navigateBack();
        cashierScreen.navigateBack();
        cashierScreen.hideKeyboard();
    }

    @Test(priority = 2)
    public void testcase2() throws InterruptedException {
        cashierScreen = new UploadInvoiceForClient();
        cashierScreen.clickOnCartEmpty();
        Thread.sleep(1000);
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
        cashierScreen.clickOnPayment();
        Thread.sleep(2000);
        String clientAmount = cashierScreen.getAmount();
        System.out.println(clientAmount);

        // Define the pattern for extracting numbers
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(clientAmount);

        // Find and print the numerical part
        if (matcher.find()) {
            numberOnly = matcher.group();
            test = numberOnly.replaceAll("\\..*$", "");
            System.out.println("total number of postpaid invoices for client: " + test); // Output: 66000.0
        }

        amountPostPaid = Integer.parseInt(test);
        System.out.println("Integer Number is: " + amountPostPaid);

        cashierScreen.navigateBack();
        cashierScreen.clickOnClientPanel();
        cashierScreen.clickOnClientFirst();
        cashierScreen.clickOnSelection();
        cashierScreen.navigateBack();
        Allure.step("click on PostPaid Button.");
        cashierScreen.clickOnPostPaidButton();
        cashierScreen.clickOnConfirmationButton();
        Thread.sleep(4000);
        Allure.addAttachment("Screenshot for invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        cashierScreen.navigateBack();
        cashierScreen.clickOnUploadInvoice();
        Assert.assertTrue(cashierScreen.isSuccessUpload(), "Invoice is not uploaded");
        System.out.println("Invoice is uploaded");
    }

    @Test(priority = 5)
    public void testcase5() throws InterruptedException {
        cashierScreen = new UploadInvoiceForClient();
        cashierScreen.updateClients();
        Thread.sleep(6000);
        //Assert.assertFalse(cashierScreen.isLoadingUpdateDisplay(), "Loading is not finished");
        cashierScreen.navigateBack();
        cashierScreen.ClickOnCashier();
        cashierScreen.clickOnInvoices();
        String invoiceAmount = cashierScreen.getInvoiceAmount();

        int endIndex = invoiceAmount.indexOf('.');
        String invoiceNumberOnly = invoiceAmount.substring(0, endIndex);
        System.out.println("Invoice Amount Is: " + invoiceNumberOnly);

        amountLast = Integer.parseInt(invoiceNumberOnly);
        System.out.println("Integer Number of Invoice is: " + amountLast);

        cashierScreen.navigateBack();
        cashierScreen.hideKeyboard();
        cashierScreen.navigateBack();

        cashierScreen.clickOnClientsOption();
        cashierScreen.selectClientName();
        cashierScreen.clickOnPayment();
        String clientAmountLast = cashierScreen.getAmount();
        System.out.println(clientAmountLast);
        // Define the pattern for extracting numbers
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(clientAmountLast);

        // Find and print the numerical part
        if (matcher.find()) {
            numberOnlyPostPaid = matcher.group();
            test1 = numberOnlyPostPaid.replaceAll("\\..*$", "");
            System.out.println("All Postpaid Amount: " + test1);
        }


        totalPostPaid = Integer.parseInt(test1);
        System.out.println("Integer Number of Total Postpaid amount is: " + totalPostPaid);

        int finalAmount = amountPostPaid + amountLast;
        System.out.println("sum of postpaid amount and invoice amount: " + finalAmount);

        Assert.assertEquals(totalPostPaid, finalAmount);
        System.out.println("total amount of postpaid of client is equal");
        cashierScreen.navigateBack();
        cashierScreen.navigateBack();
    }

}