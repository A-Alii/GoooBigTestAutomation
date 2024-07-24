package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.PriceOffer;
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

public class GoooBig_PriceOffer extends TestBase {
    PriceOffer priceOffer;

    @Test(priority = 1)
    @Description("This test attempts to Small Non Tax Invoice with discount over Product level to display Price.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallTaxInvoiceToDisplayThePriceWithDiscountOverProduct() throws InterruptedException {
        priceOffer = new PriceOffer();
        priceOffer.smallNonTaxInvoiceDisplayPrice();
        priceOffer.navigateBack();
        priceOffer.navigateBack();
        priceOffer.sendKeysToSearchProduct("iphone 13");
        priceOffer.hideKeyboard();
        priceOffer.clickOnProduct();
        priceOffer.clickOnClearSearch();
        priceOffer.sendKeysToSearchProduct("Galaxy 10");
        priceOffer.hideKeyboard();
        priceOffer.clickOnProduct1();
        priceOffer.clickOnClearSearch();
        priceOffer.hideKeyboard();
        priceOffer.goToCart();
        Thread.sleep(2000);
        priceOffer.clickOnEditProduct();
        priceOffer.sendKeysToDiscount("600");
        System.out.println("Discount Amount Is: " + priceOffer.getDiscountAmount());
        priceOffer.clickOnSubmitButton();
        priceOffer.clickOnNextBasket();
        Thread.sleep(2000);
        String details = priceOffer.getDetailsOfInvoice();
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
        priceOffer.clickOnDisplayPriceButton();
        Thread.sleep(4000);
        Allure.addAttachment("Screenshot for Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        priceOffer.navigateBack();
        priceOffer.clickOnCashier();
        Thread.sleep(2000);
        priceOffer.goToInvoices();
        Thread.sleep(2000);
        priceOffer.clickOnInvoiceDisplayPrice();
        String TotalPrice = priceOffer.getTotalInvoicePrice();
        System.out.println(TotalPrice);
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");

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

        priceOffer.navigateBack();
        priceOffer.hideKeyboard();
        System.out.println("Invoice Small Non Tax Added Successfully");
    }
}
