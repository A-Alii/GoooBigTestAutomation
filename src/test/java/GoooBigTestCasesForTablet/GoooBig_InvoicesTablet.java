package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.Invoices;
import GoooBigScreensForTablet.InvoicesTablet;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_InvoicesTablet extends TestBase {
    InvoicesTablet invoices;
    private String TaxNumber = "";
    private String TotalPriceInvoice = "";

    // Tablet Testing
    @Test(priority = 1)
    @Description("This test attempts to Small Tax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallTaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException {
        invoices = new InvoicesTablet();
        //invoices.clickOnManageShift();
        //String TotalPaymentFirst = invoices.getTotalPayment();
        //System.out.println("Total Payment First: " + TotalPaymentFirst);
        //invoices.navigateBack();
        //Allure.step("verify to select Invoice Type.");
        //invoices.NavigateToSettingsTablet();
        //invoices.checkPrintingSettingsTablet();
        //invoices.checkPrintingSettingsTablet();
        //Thread.sleep(3000);
        //invoices.smallNonTaxInvoiceTablet();
        //invoices.clickOnSubmitButtonTablet();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("باقة رمضان");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        //invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over product.");
        invoices.clickOnEditProductTablet();
        invoices.sendKeysToDiscountTablet("500.00");
        invoices.hideKeyboard();
        String DiscountProductAmount = invoices.getDiscountAmountTablet();
        Assert.assertEquals("500.00", DiscountProductAmount);
        System.out.println("Discount Amount Is: " + DiscountProductAmount);
        Allure.addAttachment("Test Output", "text/plain", "Discount Amount Is: " + invoices.getDiscountAmountTablet());
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.clickOnSubmitButtonTablet();
        invoices.hideKeyboard();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        invoices.hideKeyboard();
        String details = invoices.getDetailsOfInvoiceTablet();

        System.out.println("بيانات الفاتورة الموجودة فى السلة");
        System.out.println("----------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+|\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Define the set of keywords we are interested in
        Set<String> keywords = new HashSet<>(Arrays.asList("الضريبة", "الخصم", "الإجمالى"));

        // Iterate through the matches and print the text and number
        String text = "";
        List<String> numbers = new ArrayList<>();

        while (matcher.find()) {
            String group = matcher.group().trim();
            if (keywords.contains(group)) {
                text = group;
            } else if (group.matches("\\d+\\.\\d+")) {
                if (keywords.contains(text)) {
                    numbers.add(group);
                    System.out.println(text + ": " + group);
                    Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + ": " + group);
                }
            }
        }
        System.out.println("----------------------------------");
        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButtonTablet();
        Thread.sleep(4000);
        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File("invoice_screenshot.png");
        FileUtils.copyFile(screenshot, screenshotFile);
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        try {
            extractedText = tesseract.doOCR(screenshotFile);
            System.out.println("البيانات المستخرجه من الفاتورة كلها");
            System.out.println("----------------------------------");
            System.out.println(extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywordsArray = {
                    "الخصم",
                    "مجموع ضريبة القيمة المضافة",
                    "إجمالى المبلغ المستحق"
            };

            List<String> extractedNumbers = new ArrayList<>();
            for (String line : lines) {
                for (String keyword : keywordsArray) {
                    if (line.contains(keyword)) {
                        // Extract numeric value from the line
                        String numericValue = line.replaceAll("[^0-9.]", "");
                        if (!numericValue.isEmpty()) {
                            extractedNumbers.add(numericValue);
                        }
                        filteredText.append(line).append("\n");
                        break;
                    }
                }
            }

            // Print filtered text
            System.out.println("البيانات المفلترة من الفاتورة:");
            System.out.println(filteredText);
            Allure.addAttachment("Filtered Invoice Text", "text/plain", filteredText.toString());

            // Initialize and extract TaxNumber
            if (extractedNumbers.size() > 1) {
                TaxNumber = extractedNumbers.get(0);
                TotalPriceInvoice = extractedNumbers.get(1);
            } else {
                TaxNumber = "0"; // Assign a default value if extraction fails
                TotalPriceInvoice = "0";
            }

        } catch (TesseractException e) {
            e.printStackTrace();
            return;
        }

        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        invoices.navigateBack();
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");
        invoices.goToInvoicesTablet();
        Thread.sleep(3000);
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        String TotalPrice = invoices.getTotalInvoicePriceTablet();
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الفواتير: " + TotalPrice);
        System.out.println("*****************************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");

        // Compare TotalPrice with the last extracted number
        if (numbers.size() >= 3) {
            String extractedTax = numbers.get(0);
            String extractedDiscount = numbers.get(1);
            String extractedTotal = numbers.get(2);
            System.out.println("إجمالى الضريبة(السلة) : " + extractedTax);
            System.out.println("الخصم(السلة) : " + extractedDiscount);
            System.out.println("المجموع(السلة) : " + extractedTotal);
            try {
                double expectedTotalNum = Double.parseDouble(TotalPriceInvoice);
                double actualTotalNum = Double.parseDouble(extractedTotal);
                Assert.assertEquals(expectedTotalNum, actualTotalNum, "Total values do not match.");
                System.out.println("TotalPrice is equal to the total price number in invoices screen.");

                double expectedTaxNumber = Double.parseDouble(TaxNumber);
                double actualTaxNumber = Double.parseDouble(extractedTax);
                Assert.assertEquals(expectedTaxNumber, actualTaxNumber, "Tax values do not match.");
                System.out.println("TotalPrice is equal to the tax number in invoices screen.");

                double totalInvoiceValue = Double.parseDouble(cleanedTotalPrice);
                double extractedTotalValue = Double.parseDouble(extractedTotal);
                Assert.assertEquals(totalInvoiceValue, extractedTotalValue, "Total invoice values do not match.");
                System.out.println("TotalPrice is equal to the total price number in invoices screen.");

                Allure.addAttachment("Test Output", "text/plain", "Assertion Result: TotalPrice is equal to the total price number in invoices screen.");
            } catch (NumberFormatException e) {
                System.err.println("Error parsing numeric values: " + e.getMessage());
            }
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }

        System.out.println("********************************************");
        invoices.navigateBack();
        /*invoices.clickOnManageShift();
        String TotalPaymentSecond = invoices.getCahPayment();
        String cleanedCashPaymentTotalPrice = TotalPaymentSecond.replaceAll("[^0-9.]", "");
        System.out.println("cleanedCashPaymentTotalPriceFromManageShift: " + cleanedCashPaymentTotalPrice);

        System.out.println("TotalPaymentFirstFromManageShift: " + TotalPaymentFirst);
        System.out.println("TotalPriceInvoiceFromReceipt: " + TotalPriceInvoice);

        double expectedTotalPayment = Double.parseDouble(TotalPaymentFirst + TotalPriceInvoice);
        double actualTotalPayment = Double.parseDouble(cleanedCashPaymentTotalPrice);
        Assert.assertEquals(expectedTotalPayment, actualTotalPayment, "Total payment is not equal.");
        System.out.println("TotalPayment is equal to the total payment number in invoices screen.");
        invoices.navigateBack();*/
        System.out.println("Invoice Small Tax Added Successfully");
    }

}

