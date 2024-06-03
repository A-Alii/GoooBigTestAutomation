package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.NoticeCreditorScreen;
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
public class GoooBig_NoticeCreditor extends TestBase {
    NoticeCreditorScreen noticeCreditorScreen;

    @Test(priority = 1)
    @Description("This test attempts to verify Notice Creditor Functionality.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyNoticeCreditorFunctionality() {
        noticeCreditorScreen = new NoticeCreditorScreen();
        Allure.step("Navigate to Invoices Screen.");
        noticeCreditorScreen.NavigateToInvoices();
        Allure.step("Select any invoice and click on Notice Creditor icon for invoice.");
        noticeCreditorScreen.clickOnNoticeCreditorIcon();
        noticeCreditorScreen.hideKeyboard();
        noticeCreditorScreen.goToCart();
    }

    @Step("Try to Remove Product from the Notice Creditor Invoice.")
    public void step2() {
        noticeCreditorScreen = new NoticeCreditorScreen();
        noticeCreditorScreen.clickOnRemoveProductIcon();
        Allure.addAttachment("Screenshot for Result After Try To Remove Product From Notice Creditor Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test(priority = 2)
    @Description("This test attempts to remove product from cart for Notice Creditor Invoice.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyRemoveProductFromNoticeCreditorInvoice() {
        step2();
    }

    @Step("Try to Edit Product from the Notice Creditor Invoice.")
    public void step3() throws InterruptedException {
        noticeCreditorScreen = new NoticeCreditorScreen();
        Thread.sleep(2000);
        noticeCreditorScreen.clickOnEditProductIcon();
        Allure.addAttachment("Screenshot for Result After Try To Edit on Notice Creditor Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test(priority = 3)
    @Description("This test attempts to Edit product from cart for Notice Creditor Invoice.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyEditeProductFromNoticeCreditorInvoice() throws InterruptedException {
        step3();
    }

    @Test(priority = 4)
    @Description("This test attempts to Navigate to Make Notice Creditor invoice.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToCreateANoticeCreditorInvoice() throws InterruptedException {
        noticeCreditorScreen = new NoticeCreditorScreen();
        Thread.sleep(3000);
        Allure.step("click on Next Button.");
        noticeCreditorScreen.clickOnNextBasket();
        System.out.println("----------------------------------------");
        Thread.sleep(3000);
        String details = noticeCreditorScreen.getDetailsOfInvoice();
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;

        String text = " " +
                " إجمالى الضريبة ";
        String number = "";
        String lastNumber = "";

        // Iterate through the matches and print the text and number
        while (matcher.find()) {
            String group = matcher.group();

            // Skip initial texts if needed
            if (skipInitialTexts) {
                if (group.contains("إجمالى الضريبة")) {
                    skipInitialTexts = false;
                }
                continue;
            }
            if (group.contains("SR")) {
                number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                lastNumber = number;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        System.out.println("----------------------------------------");
        //Allure.addAttachment("Screenshot for Result After Try To Edit on Notice Creditor Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.step("verify to do Notice Creditor for Invoice.");
        noticeCreditorScreen.clickOnNoticeCreditorButton();
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.step("verify to select client for the notice creditor invoice.");
        noticeCreditorScreen.clickOnSelectClientForInvoice();
        Thread.sleep(1000);
        noticeCreditorScreen.selectClientName();
        Thread.sleep(2000);
        noticeCreditorScreen.clickOnSelection();
        //Allure.addAttachment("Screenshot for result after select client", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        Allure.step("verify to do Adding total price of Notice Creditor for Payment.");
        noticeCreditorScreen.clickOnAddTotalPriceOfInvoice();
        //Allure.addAttachment("Screenshot for result after add total price to payment", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.step("verify to get Total Price After Adding Payment Method.");
        String actual = noticeCreditorScreen.getPriceAfterAddTotalPrice();
        String price = "0.00";
        Allure.step("verify total price become zero after add all total price.");
        Assert.assertEquals(actual, price);
        Allure.step("verify to Confirm Notice Creditor.");
        noticeCreditorScreen.clickOnConfirmationPaymentButton();
        Thread.sleep(4000);
        Allure.addAttachment("Screenshot for Receipt.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        noticeCreditorScreen.navigateBack();
        //noticeCreditorScreen.NavigateToCashierProduct();
        Allure.step("verify to Navigate to End Shift to check the price of notice creditor was added successfully to his box.");
        noticeCreditorScreen.NavigateToEndShift();
        Thread.sleep(2000);
        noticeCreditorScreen.navigateBack();
        noticeCreditorScreen.navigateBack();
        noticeCreditorScreen.hideKeyboard();
        System.out.println("Notice Creditor Transaction Done Successfully.");
    }
}
