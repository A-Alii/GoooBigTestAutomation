package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
    private String discount = "";
    private String TaxNumber = "";
    private String TotalPriceInvoice = "";
    public String discountAmount = "200.00";

    // Tablet Testing
    @Test(priority = 1)
    @Description("This test attempts to Small Tax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallTaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException {
        invoices = new InvoicesTablet();
        invoices.clickOnSettings();
        invoices.clickOnPrinting();
        invoices.clickOnTaxInvoice();
        invoices.clickOnSubmitButton();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("هواوي 23");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        invoices.clearFieldsTablet();
        invoices.sendKeysToSearchProductTablet("قرنفل مسمار");
        invoices.hideKeyboard();
        invoices.clickOnProductSecondTablet();
        invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over product.");
        invoices.clickOnEditProductTablet();
        invoices.sendKeysToDiscountTablet("100.00");
        invoices.hideKeyboard();
        String DiscountProductAmount = invoices.getDiscountAmountTablet();
        //Assert.assertEquals("500.00", DiscountProductAmount);
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
        Thread.sleep(6000);
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
                    "مجموع ضريبة القيمة المضافة",
                    "الخصم",
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
                TaxNumber = extractedNumbers.get(1);
                TotalPriceInvoice = extractedNumbers.get(2);
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
                double expectedTotalNum = Double.parseDouble(cleanedTotalPrice);
                double actualTotalNum = Double.parseDouble(extractedTotal);
                System.out.println("expectedTotalNum: " + expectedTotalNum);
                System.out.println("actualTotalNum: " + actualTotalNum);
                Assert.assertEquals(expectedTotalNum, actualTotalNum, "Total values do not match.");
                System.out.println("TotalPrice is equal to the total price number in invoices screen.");

                double expectedTaxNumber = Double.parseDouble(TaxNumber);
                double actualTaxNumber = Double.parseDouble(extractedTax);
                System.out.println("expectedTaxNumber: " + expectedTaxNumber);
                System.out.println("actualTaxNumber: " + actualTaxNumber);
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
        System.out.println("Invoice Small Tax Added Successfully");
    }

    @Test(priority = 2)
    @Description("This test attempts to Small Tax Invoice with discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallTaxInvoiceWithDiscountOverInvoiceLevel() throws InterruptedException, IOException {
        invoices = new InvoicesTablet();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("هواوي 23");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        invoices.clearFieldsTablet();
        invoices.sendKeysToSearchProductTablet("قرنفل مسمار");
        invoices.hideKeyboard();
        invoices.clickOnProductSecondTablet();
        invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over product.");
        invoices.clickOnDiscountButton();
        Thread.sleep(1000);
        invoices.SendKeysToDiscountField(discountAmount);
        System.out.println("Discount Amount Is: " + discountAmount);
        Allure.addAttachment("Test Output", "text/plain", "Discount Amount Is: " + discountAmount);
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.clickOnSubmitButtonTablet();
        invoices.hideKeyboard();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        invoices.hideKeyboard();
        String details = invoices.getDetailsOfInvoiceTablet2();

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
        Thread.sleep(6000);
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
                    "مجموع ضريبة القيمة المضافة",
                    "الخصم",
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
                TaxNumber = extractedNumbers.get(1);
                TotalPriceInvoice = extractedNumbers.get(2);
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
                double expectedTotalNum = Double.parseDouble(cleanedTotalPrice);
                double actualTotalNum = Double.parseDouble(extractedTotal);
                System.out.println("expectedTotalNum: " + expectedTotalNum);
                System.out.println("actualTotalNum: " + actualTotalNum);
                Assert.assertEquals(expectedTotalNum, actualTotalNum, "Total values do not match.");
                System.out.println("TotalPrice is equal to the total price number in invoices screen.");

                double expectedTaxNumber = Double.parseDouble(TaxNumber);
                double actualTaxNumber = Double.parseDouble(extractedTax);
                System.out.println("expectedTaxNumber: " + expectedTaxNumber);
                System.out.println("actualTaxNumber: " + actualTaxNumber);
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
        invoices.hideKeyboard();
        System.out.println("Invoice Small Tax Added Successfully");
    }

    private static TextData extractTextData(String extractedText) {
        // Split the text by spaces and new lines
        String[] lines = extractedText.split("\n");
        TextData textData = new TextData();

        for (String line : lines) {
            String[] parts = line.split(" ");

            if (parts.length == 3) {
                textData.total = removeDecimalDigits(parts[2]);
                textData.discount = removeDecimalDigits(parts[1]);
                textData.tax = removeDecimalDigits(parts[0]);
            }
        }

        return textData;
    }

    private static String removeDecimalDigits(String value) {
        if (value.contains(".")) {
            return value.split("\\.")[0];
        }
        return value;
    }

    private static InvoiceData extractInvoiceData(String extractedText) {
        // Split the text by new lines
        String[] lines = extractedText.split("\n");
        InvoiceData invoiceData = new InvoiceData();

        for (String line : lines) {
            if (line.contains("المجموع قبل الخصم")) {
                invoiceData.preDiscount = extractValue(line);
            } else if (line.contains("مجموع الخصومات")) {
                invoiceData.discounts = extractValue(line);
            } else if (line.contains("الاجمالى الخاضع للضريبة")) {
                invoiceData.taxableTotal = extractValue(line);
            } else if (line.contains("مجموع ضريبة القيمة المضافة")) {
                invoiceData.tax = extractValue(line);
            } else if (line.contains("إجمالى المبلغ المستحق")) {
                invoiceData.totalDue = extractValue(line);
            }
        }

        return invoiceData;
    }

    private static String extractValue(String line) {
        // Split the line on the colon and remove "SAR" and non-numeric characters
        String[] parts = line.split(":");
        if (parts.length > 1) {
            String value = parts[1].replace("SAR", "").replaceAll("[^0-9.]", "").trim();
            // Check if the value starts with a dot and handle accordingly
            if (value.startsWith(".")) {
                value = value.substring(1); // Remove the leading dot
            }
            // Remove digits after the decimal point
            if (value.contains(".")) {
                value = value.split("\\.")[0];
            }
            return value;
        }
        return ""; // Return an empty string if the value cannot be extracted
    }

    private static InvoiceDataNonTax extractInvoiceDataNonTax(String extractedText) {
        // Split the text by new lines
        String[] lines = extractedText.split("\n");
        InvoiceDataNonTax invoiceData = new InvoiceDataNonTax();

        for (String line : lines) {
            if (line.contains("الاجمالى")) {
                invoiceData.TotalPreDiscount = extractValueNonTax(line);
            } else if (line.contains("مجموع الخصومات")) {
                invoiceData.discountsNonTax = extractValueNonTax(line);
            } else if (line.contains("إجمالى المبلغ المستحق")) {
                invoiceData.totalDueAfterDiscount = extractValueNonTax(line);
            }
        }

        return invoiceData;
    }

    private static String extractValueNonTax(String line) {
        // Split the line on the colon and remove "SAR" and non-numeric characters
        String[] parts = line.split(":");
        if (parts.length > 1) {
            String value = parts[1].replace("SAR", "").replaceAll("[^0-9.]", "").trim();
            // Check if the value starts with a dot and handle accordingly
            if (value.startsWith(".")) {
                value = value.substring(1); // Remove the leading dot
            }
            // Remove digits after the decimal point
            if (value.contains(".")) {
                value = value.split("\\.")[0];
            }
            return value;
        }
        return ""; // Return an empty string if the value cannot be extracted
    }

    @Test(priority = 3)
    @Description("This test attempts to A4 Tax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void A4TaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException, TesseractException {
        invoices = new InvoicesTablet();
        invoices.clickOnSettings();
        invoices.clickOnPrinting();
        invoices.clickOnTaxInvoice();
        invoices.clickOnLargeTaxInvoice();
        invoices.clickOnSubmitButton();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("هواوي 23");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        invoices.clearFieldsTablet();
        invoices.sendKeysToSearchProductTablet("قرنفل مسمار");
        invoices.hideKeyboard();
        invoices.clickOnProductSecondTablet();
        invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over product.");
        invoices.clickOnEditProductTablet();
        invoices.sendKeysToDiscountTablet("100.00");
        invoices.hideKeyboard();
        String DiscountProductAmount = invoices.getDiscountAmountTablet();
        //Assert.assertEquals("500.00", DiscountProductAmount);
        System.out.println("Discount Amount Is: " + DiscountProductAmount);
        Allure.addAttachment("Test Output", "text/plain", "Discount Amount Is: " + invoices.getDiscountAmountTablet());
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.clickOnSubmitButtonTablet();
        invoices.hideKeyboard();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        invoices.hideKeyboard();

        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX = 135;
        int cropY = 688;
        int cropWidth = 508;
        int cropHeight = 111;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

        // Save the cropped image to a new file
        File screenshotFile = new File("CartData.png");
        ImageIO.write(croppedImg, "png", screenshotFile);

        System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        extractedText = tesseract.doOCR(screenshotFile);
        System.out.println("Extracted Text:\n" + extractedText);
        // Process the extracted text
        TextData textData = extractTextData(extractedText);

        // Output the variables
        System.out.println("الإجمالى : " + textData.total);
        System.out.println("الخصم : " + textData.discount);
        System.out.println("الضريبة : " + textData.tax);


        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButtonTablet();
        Thread.sleep(6000);
        // Capture the screenshot and save it to a file
        File screenshotA4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgA4 = ImageIO.read(screenshotA4);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXA4 = 164;
        int cropYA4 = 1097;
        int cropWidthA4 = 367;
        int cropHeightA4 = 112;
        // Crop the image
        BufferedImage croppedImgA4 = fullImgA4.getSubimage(cropXA4, cropYA4, cropWidthA4, cropHeightA4);

        // Save the cropped image to a new file
        File screenshotFileA4 = new File("A4Invoice.png");
        ImageIO.write(croppedImgA4, "png", screenshotFileA4);

        System.out.println("Cropped screenshot saved: " + screenshotFileA4.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractA4 = new Tesseract();
        tesseractA4.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractA4.setLanguage("Arabic"); // Set the language to Arabic
        String extractedTextA4;
        extractedTextA4 = tesseractA4.doOCR(screenshotFileA4);
        System.out.println(extractedTextA4);

        // Process the extracted text to remove "SAR" and extract values
        InvoiceData invoiceData = extractInvoiceData(extractedTextA4);

        // Output the variables
        System.out.println("المجموع قبل الخصم: " + invoiceData.preDiscount);
        System.out.println("مجموع الخصومات: " + invoiceData.discounts);
        System.out.println("الاجمالى الخاضع للضريبة: " + invoiceData.taxableTotal);
        System.out.println("مجموع ضريبة القيمة المضافة: " + invoiceData.tax);
        System.out.println("إجمالى المبلغ المستحق: " + invoiceData.totalDue);

        Assert.assertEquals(invoiceData.discounts, textData.discount);
        System.out.println("total discount in cart equal to total discount in invoice");
        Assert.assertEquals(invoiceData.tax, textData.tax);
        System.out.println("total tax in cart equal to total tax in invoice");
        Assert.assertEquals(invoiceData.totalDue, textData.total);
        System.out.println("total price in cart equal to total price in invoice");
        invoices.navigateBack();
        invoices.hideKeyboard();
        invoices.goToInvoicesTablet();
        Thread.sleep(2000);
        String TotalPriceInvoice = invoices.getTotalInvoicePriceTablet();
        String TotalPriceInvoice2 = TotalPriceInvoice.replaceAll("SAR", "").replaceAll("[^0-9.]", "").trim();
        TotalPriceInvoice2 = removeDecimalDigits(TotalPriceInvoice2);
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الفواتير: " + TotalPriceInvoice2);
        Assert.assertEquals(TotalPriceInvoice2, textData.total);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Cart");
        Assert.assertEquals(TotalPriceInvoice2, invoiceData.totalDue);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Receipt");
        invoices.navigateBack();
        invoices.hideKeyboard();
        System.out.println("Invoice A4 Tax Added Successfully");
    }

    @Test(priority = 4)
    @Description("This test attempts to A4 Tax Invoice with discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void A4TaxInvoiceWithDiscountOverInvoiceLevel() throws InterruptedException, IOException, TesseractException {
        invoices = new InvoicesTablet();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("هواوي 23");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        invoices.clearFieldsTablet();
        invoices.sendKeysToSearchProductTablet("قرنفل مسمار");
        invoices.hideKeyboard();
        invoices.clickOnProductSecondTablet();
        invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over invoice level.");
        //invoices.clickOnEditProductTablet();
        invoices.clickOnDiscountButton();
        invoices.SendKeysToDiscountField("200.00");
        invoices.hideKeyboard();
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.clickOnSubmitButtonTablet();
        invoices.hideKeyboard();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        invoices.hideKeyboard();
        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX = 135;
        int cropY = 688;
        int cropWidth = 508;
        int cropHeight = 111;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

        // Save the cropped image to a new file
        File screenshotFile = new File("CartData.png");
        ImageIO.write(croppedImg, "png", screenshotFile);

        System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        extractedText = tesseract.doOCR(screenshotFile);
        System.out.println("Extracted Text:\n" + extractedText);
        // Process the extracted text
        TextData textData = extractTextData(extractedText);

        // Output the variables
        System.out.println("الإجمالى : " + textData.total);
        System.out.println("الخصم : " + textData.discount);
        System.out.println("الضريبة : " + textData.tax);


        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButtonTablet();
        Thread.sleep(6000);
        // Capture the screenshot and save it to a file
        File screenshotA4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgA4 = ImageIO.read(screenshotA4);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXA4 = 164;
        int cropYA4 = 1097;
        int cropWidthA4 = 367;
        int cropHeightA4 = 112;
        // Crop the image
        BufferedImage croppedImgA4 = fullImgA4.getSubimage(cropXA4, cropYA4, cropWidthA4, cropHeightA4);

        // Save the cropped image to a new file
        File screenshotFileA4 = new File("A4Invoice.png");
        ImageIO.write(croppedImgA4, "png", screenshotFileA4);

        System.out.println("Cropped screenshot saved: " + screenshotFileA4.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractA4 = new Tesseract();
        tesseractA4.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractA4.setLanguage("Arabic"); // Set the language to Arabic
        String extractedTextA4;
        extractedTextA4 = tesseractA4.doOCR(screenshotFileA4);
        System.out.println(extractedTextA4);

        // Process the extracted text to remove "SAR" and extract values
        InvoiceData invoiceData = extractInvoiceData(extractedTextA4);

        // Output the variables
        System.out.println("المجموع قبل الخصم: " + invoiceData.preDiscount);
        System.out.println("مجموع الخصومات: " + invoiceData.discounts);
        System.out.println("الاجمالى الخاضع للضريبة: " + invoiceData.taxableTotal);
        System.out.println("مجموع ضريبة القيمة المضافة: " + invoiceData.tax);
        System.out.println("إجمالى المبلغ المستحق: " + invoiceData.totalDue);

        Assert.assertEquals(invoiceData.discounts, textData.discount);
        System.out.println("total discount in cart equal to total discount in invoice");
        Assert.assertEquals(invoiceData.tax, textData.tax);
        System.out.println("total tax in cart equal to total tax in invoice");
        Assert.assertEquals(invoiceData.totalDue, textData.total);
        System.out.println("total price in cart equal to total price in invoice");
        invoices.navigateBack();
        invoices.hideKeyboard();
        invoices.goToInvoicesTablet();
        Thread.sleep(2000);
        String TotalPriceInvoice = invoices.getTotalInvoicePriceTablet();
        String TotalPriceInvoice2 = TotalPriceInvoice.replaceAll("SAR", "").replaceAll("[^0-9.]", "").trim();
        TotalPriceInvoice2 = removeDecimalDigits(TotalPriceInvoice2);
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الفواتير: " + TotalPriceInvoice2);
        Assert.assertEquals(TotalPriceInvoice2, textData.total);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Cart");
        Assert.assertEquals(TotalPriceInvoice2, invoiceData.totalDue);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Receipt");
        invoices.navigateBack();
        invoices.hideKeyboard();
        System.out.println("Invoice A4 Tax Added Successfully");
    }

    @Test(priority = 5)
    @Description("This test attempts to Small NonTax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallNonTaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException {
        invoices = new InvoicesTablet();
        invoices.clickOnSettings();
        invoices.clickOnPrinting();
        invoices.clickOnNonTaxInvoice();
        invoices.clickOnSubmitButton();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("هواوي 23");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        invoices.clearFieldsTablet();
        invoices.sendKeysToSearchProductTablet("قرنفل مسمار");
        invoices.hideKeyboard();
        invoices.clickOnProductSecondTablet();
        invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over product.");
        invoices.clickOnEditProductTablet();
        invoices.sendKeysToDiscountTablet("100.00");
        invoices.hideKeyboard();
        String DiscountProductAmount = invoices.getDiscountAmountTablet();
        //Assert.assertEquals("500.00", DiscountProductAmount);
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
        Thread.sleep(6000);
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
            if (extractedNumbers.size() >= 1) {
                discount = extractedNumbers.get(0);
                TotalPriceInvoice = extractedNumbers.get(1);
            } else {
                discount = "0"; // Assign a default value if extraction fails
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
                double expectedTotalNum = Double.parseDouble(cleanedTotalPrice);
                double actualTotalNum = Double.parseDouble(extractedTotal);
                System.out.println("expectedTotalNum: " + expectedTotalNum);
                System.out.println("actualTotalNum: " + actualTotalNum);
                Assert.assertEquals(expectedTotalNum, actualTotalNum, "Total values do not match.");
                System.out.println("TotalPrice is equal to the total price number in invoices screen.");

                double expectedDiscountNumber = Double.parseDouble(discount);
                double actualDiscountNumber = Double.parseDouble(DiscountProductAmount);
                System.out.println("expectedDiscountNumber: " + expectedDiscountNumber);
                System.out.println("actualDiscountNumber: " + actualDiscountNumber);
                Assert.assertEquals(expectedDiscountNumber, actualDiscountNumber, "Discount values do not match.");
                System.out.println("Discount Number in cart is equal to the Discount number in invoices screen.");

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
        invoices.hideKeyboard();
        System.out.println("Invoice Small Tax Added Successfully");
    }

    @Test(priority = 6)
    @Description("This test attempts to Small NonTax Invoice with discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallNonTaxInvoiceWithDiscountOverInvoiceLevel() throws InterruptedException, IOException {
        invoices = new InvoicesTablet();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("هواوي 23");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        invoices.clearFieldsTablet();
        invoices.sendKeysToSearchProductTablet("قرنفل مسمار");
        invoices.hideKeyboard();
        invoices.clickOnProductSecondTablet();
        invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over product.");
        invoices.clickOnDiscountButton();
        invoices.SendKeysToDiscountField(discountAmount);
        invoices.hideKeyboard();
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        invoices.clickOnSubmitButtonTablet();
        invoices.hideKeyboard();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        invoices.hideKeyboard();
        String details = invoices.getDetailsOfInvoiceTablet2();

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
        Thread.sleep(6000);
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
            if (extractedNumbers.size() >= 1) {
                discount = extractedNumbers.get(0);
                TotalPriceInvoice = extractedNumbers.get(1);
            } else {
                discount = "0"; // Assign a default value if extraction fails
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
                double expectedTotalNum = Double.parseDouble(cleanedTotalPrice);
                double actualTotalNum = Double.parseDouble(extractedTotal);
                System.out.println("expectedTotalNum: " + expectedTotalNum);
                System.out.println("actualTotalNum: " + actualTotalNum);
                Assert.assertEquals(expectedTotalNum, actualTotalNum, "Total values do not match.");
                System.out.println("TotalPrice is equal to the total price number in invoices screen.");

                double expectedDiscountNumber = Double.parseDouble(discount);
                double actualDiscountNumber = Double.parseDouble(discountAmount);
                System.out.println("expectedDiscountNumber: " + expectedDiscountNumber);
                System.out.println("actualDiscountNumber: " + actualDiscountNumber);
                Assert.assertEquals(expectedDiscountNumber, actualDiscountNumber, "Discount values do not match.");
                System.out.println("Discount Number in cart is equal to the Discount number in invoices screen.");

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
        invoices.hideKeyboard();
        System.out.println("Invoice Small Tax Added Successfully");
    }

    @Test(priority = 7)
    @Description("This test attempts to A4 NonTax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void A4NonTaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException, TesseractException {
        invoices = new InvoicesTablet();
        invoices.clickOnSettings();
        invoices.clickOnPrinting();
        invoices.clickOnLargeNonTaxInvoice();
        invoices.clickOnSubmitButton();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("هواوي 23");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        invoices.clearFieldsTablet();
        invoices.sendKeysToSearchProductTablet("قرنفل مسمار");
        invoices.hideKeyboard();
        invoices.clickOnProductSecondTablet();
        invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over product.");
        invoices.clickOnEditProductTablet();
        invoices.sendKeysToDiscountTablet("100.00");
        invoices.hideKeyboard();
        String DiscountProductAmount = invoices.getDiscountAmountTablet();
        //Assert.assertEquals("500.00", DiscountProductAmount);
        System.out.println("Discount Amount Is: " + DiscountProductAmount);
        Allure.addAttachment("Test Output", "text/plain", "Discount Amount Is: " + invoices.getDiscountAmountTablet());
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.clickOnSubmitButtonTablet();
        invoices.hideKeyboard();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        invoices.hideKeyboard();

        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX = 135;
        int cropY = 688;
        int cropWidth = 508;
        int cropHeight = 111;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

        // Save the cropped image to a new file
        File screenshotFile = new File("CartData.png");
        ImageIO.write(croppedImg, "png", screenshotFile);

        System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        extractedText = tesseract.doOCR(screenshotFile);
        System.out.println("Extracted Text:\n" + extractedText);
        // Process the extracted text
        TextData textData = extractTextData(extractedText);

        // Output the variables
        System.out.println("الإجمالى : " + textData.total);
        System.out.println("الخصم : " + textData.discount);
        System.out.println("الضريبة : " + textData.tax);


        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButtonTablet();
        Thread.sleep(6000);
        // Capture the screenshot and save it to a file
        File screenshotA4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgA4 = ImageIO.read(screenshotA4);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXA4 = 170;
        int cropYA4 = 1080;
        int cropWidthA4 = 344;
        int cropHeightA4 = 78;
        // Crop the image
        BufferedImage croppedImgA4 = fullImgA4.getSubimage(cropXA4, cropYA4, cropWidthA4, cropHeightA4);

        // Save the cropped image to a new file
        File screenshotFileA4 = new File("A4NonTaxInvoice.png");
        ImageIO.write(croppedImgA4, "png", screenshotFileA4);

        System.out.println("Cropped screenshot saved: " + screenshotFileA4.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractA4 = new Tesseract();
        tesseractA4.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractA4.setLanguage("Arabic"); // Set the language to Arabic
        String extractedTextA4;
        extractedTextA4 = tesseractA4.doOCR(screenshotFileA4);
        System.out.println(extractedTextA4);

        // Process the extracted text to remove "SAR" and extract values
        InvoiceDataNonTax invoiceData = extractInvoiceDataNonTax(extractedTextA4);

        // Output the variables
        System.out.println("المجموع قبل الخصم: " + invoiceData.TotalPreDiscount);
        System.out.println("مجموع الخصومات: " + invoiceData.discountsNonTax);
        System.out.println("إجمالى المبلغ المستحق: " + invoiceData.totalDueAfterDiscount);

        Assert.assertEquals(invoiceData.discountsNonTax, textData.discount);
        System.out.println("total discount in cart equal to total discount in invoice");
        Assert.assertEquals(invoiceData.totalDueAfterDiscount, textData.total);
        System.out.println("total price in cart equal to total price in invoice");
        invoices.navigateBack();
        invoices.hideKeyboard();
        invoices.goToInvoicesTablet();
        Thread.sleep(2000);
        String TotalPriceInvoice = invoices.getTotalInvoicePriceTablet();
        String TotalPriceInvoice2 = TotalPriceInvoice.replaceAll("SAR", "").replaceAll("[^0-9.]", "").trim();
        TotalPriceInvoice2 = removeDecimalDigits(TotalPriceInvoice2);
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الفواتير: " + TotalPriceInvoice2);
        Assert.assertEquals(TotalPriceInvoice2, textData.total);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Cart");
        Assert.assertEquals(TotalPriceInvoice2, invoiceData.totalDueAfterDiscount);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Receipt");
        invoices.navigateBack();
        invoices.hideKeyboard();
        System.out.println("Invoice A4 NonTax Added Successfully");
    }

    @Test(priority = 8)
    @Description("This test attempts to A4 NonTax Invoice with discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void A4NonTaxInvoiceWithDiscountOverInvoiceLevel() throws InterruptedException, IOException, TesseractException {
        invoices = new InvoicesTablet();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProductTablet("هواوي 23");
        invoices.hideKeyboard();
        invoices.clickOnProductFirstTablet();
        invoices.clearFieldsTablet();
        invoices.sendKeysToSearchProductTablet("قرنفل مسمار");
        invoices.hideKeyboard();
        invoices.clickOnProductSecondTablet();
        invoices.clearFieldsTablet();
        Allure.step("verify to Do discount over invoice level.");
        //invoices.clickOnEditProductTablet();
        invoices.clickOnDiscountButton();
        invoices.SendKeysToDiscountField("200.00");
        invoices.hideKeyboard();
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.clickOnSubmitButtonTablet();
        invoices.hideKeyboard();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        invoices.hideKeyboard();

        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX = 135;
        int cropY = 688;
        int cropWidth = 508;
        int cropHeight = 111;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

        // Save the cropped image to a new file
        File screenshotFile = new File("CartData.png");
        ImageIO.write(croppedImg, "png", screenshotFile);

        System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        extractedText = tesseract.doOCR(screenshotFile);
        System.out.println("Extracted Text:\n" + extractedText);
        // Process the extracted text
        TextData textData = extractTextData(extractedText);

        // Output the variables
        System.out.println("الإجمالى : " + textData.total);
        System.out.println("الخصم : " + textData.discount);
        System.out.println("الضريبة : " + textData.tax);


        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButtonTablet();
        Thread.sleep(6000);
        // Capture the screenshot and save it to a file
        File screenshotA4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgA4 = ImageIO.read(screenshotA4);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXA4 = 170;
        int cropYA4 = 1080;
        int cropWidthA4 = 344;
        int cropHeightA4 = 78;
        // Crop the image
        BufferedImage croppedImgA4 = fullImgA4.getSubimage(cropXA4, cropYA4, cropWidthA4, cropHeightA4);

        // Save the cropped image to a new file
        File screenshotFileA4 = new File("A4NonTaxInvoice.png");
        ImageIO.write(croppedImgA4, "png", screenshotFileA4);

        System.out.println("Cropped screenshot saved: " + screenshotFileA4.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractA4 = new Tesseract();
        tesseractA4.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractA4.setLanguage("Arabic"); // Set the language to Arabic
        String extractedTextA4;
        extractedTextA4 = tesseractA4.doOCR(screenshotFileA4);
        System.out.println(extractedTextA4);

        // Process the extracted text to remove "SAR" and extract values
        InvoiceDataNonTax invoiceData = extractInvoiceDataNonTax(extractedTextA4);

        // Output the variables
        System.out.println("المجموع قبل الخصم: " + invoiceData.TotalPreDiscount);
        System.out.println("مجموع الخصومات: " + invoiceData.discountsNonTax);
        System.out.println("إجمالى المبلغ المستحق: " + invoiceData.totalDueAfterDiscount);

        Assert.assertEquals(invoiceData.discountsNonTax, textData.discount);
        System.out.println("total discount in cart equal to total discount in invoice");
        Assert.assertEquals(invoiceData.totalDueAfterDiscount, textData.total);
        System.out.println("total price in cart equal to total price in invoice");
        invoices.navigateBack();
        invoices.hideKeyboard();
        invoices.goToInvoicesTablet();
        Thread.sleep(2000);
        String TotalPriceInvoice = invoices.getTotalInvoicePriceTablet();
        String TotalPriceInvoice2 = TotalPriceInvoice.replaceAll("SAR", "").replaceAll("[^0-9.]", "").trim();
        TotalPriceInvoice2 = removeDecimalDigits(TotalPriceInvoice2);
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الفواتير: " + TotalPriceInvoice2);
        Assert.assertEquals(TotalPriceInvoice2, textData.total);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Cart");
        Assert.assertEquals(TotalPriceInvoice2, invoiceData.totalDueAfterDiscount);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Receipt");
        invoices.navigateBack();
        invoices.hideKeyboard();
        System.out.println("Invoice A4 NonTax Added Successfully");
    }

    // Class to hold the extracted text data
    private static class TextData {
        String total;
        String discount;
        String tax;
    }

    // Class to hold the extracted invoice data
    private static class InvoiceData {
        String preDiscount;
        String discounts;
        String taxableTotal;
        String tax;
        String totalDue;
    }

    // Class to hold the extracted invoice data
    static class InvoiceDataNonTax {
        String TotalPreDiscount;
        String discountsNonTax;
        String totalDueAfterDiscount;
    }

}

