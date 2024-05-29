package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.Invoices;
import GoooBigScreens.PendingIInvoiceScreen;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class GoooBig_PendingInvoice extends TestBase {
    PendingIInvoiceScreen pendingIInvoiceScreen;
    @Test(priority = 11)
    @Description("This test attempts to Small Non Tax Invoice with discount over Product level and make it Pending invoice")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void PendingInvoiceTestCase() throws InterruptedException {
        pendingIInvoiceScreen = new PendingIInvoiceScreen();
        Allure.step("verify to select Invoice Type.");
        pendingIInvoiceScreen.smallNonTaxInvoicePendingInvoice();
        pendingIInvoiceScreen.navigateBack();
        pendingIInvoiceScreen.navigateBack();
        Allure.step("verify to search for a product and add it in cart.");
        pendingIInvoiceScreen.sendKeysToSearchProduct("iphone 13");
        pendingIInvoiceScreen.hideKeyboard();
        pendingIInvoiceScreen.clickOnProduct();
        pendingIInvoiceScreen.clickOnClearSearch();
        Allure.step("verify to search for a product and add it in cart.");
        pendingIInvoiceScreen.sendKeysToSearchProduct("Galaxy 10");
        pendingIInvoiceScreen.hideKeyboard();
        pendingIInvoiceScreen.clickOnProduct1();
        pendingIInvoiceScreen.clickOnClearSearch();
        pendingIInvoiceScreen.hideKeyboard();
        pendingIInvoiceScreen.goToCart();
        Thread.sleep(3000);
        Allure.step("verify to Do discount over product.");
        pendingIInvoiceScreen.clickOnEditProduct();
        pendingIInvoiceScreen.sendKeysToDiscount("750");
        System.out.println("Discount Amount Is: " + pendingIInvoiceScreen.getDiscountAmount());
        Allure.addAttachment("Test Output", "text/plain", "Discount Amount Is: " + pendingIInvoiceScreen.getDiscountAmount());
        pendingIInvoiceScreen.clickOnSubmitButton();
        pendingIInvoiceScreen.clickOnNextBasket();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        String details = pendingIInvoiceScreen.getDetailsOfInvoice();
        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;

        String text = " " +
                "إجمالى الضريبة";
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
        pendingIInvoiceScreen.navigateBack();
        pendingIInvoiceScreen.hideKeyboard();
        pendingIInvoiceScreen.goToCart();
        Allure.step("verify to hold the invoice.");
        pendingIInvoiceScreen.clickOnHoldInvoice();
        pendingIInvoiceScreen.goToInvoices();
        Thread.sleep(1000);
        pendingIInvoiceScreen.clickOnInvoicePending();
        Allure.addAttachment("Screenshot for Pending Invoices.", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        Allure.step("verify to get the price of pending invoice");
        String TotalPrice = pendingIInvoiceScreen.getTotalPendingInvoicePrice();
        //System.out.println(TotalPrice);
        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number
        if (!lastNumber.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(lastNumber);
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        pendingIInvoiceScreen.navigateBack();
        pendingIInvoiceScreen.hideKeyboard();
        System.out.println("A4Invoice with discount over invoice level Added Successfully");
    }
}
