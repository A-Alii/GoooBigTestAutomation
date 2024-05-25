package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.Invoices;
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

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_Invoices extends TestBase {
    Invoices invoices;

    /*@Test(priority = 1)
    @Description("This test attempts to Small Tax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallTaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException, TesseractException {
        invoices = new Invoices(driver);
        Allure.step("verify to select Invoice Type.");
        invoices.smallNonTaxInvoice();
        invoices.navigate();
        invoices.navigate();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("باقة رمضان");
        invoices.hideKeyboard();
        invoices.clickOnProductFirst();
        invoices.clickOnClearSearch();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("Galaxy 0999");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("Galaxy 10");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        invoices.hideKeyboard();
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.goToCart();
        Thread.sleep(3000);
        Allure.step("verify to Do discount over product.");
        invoices.clickOnEditProduct();
        invoices.sendKeysToDiscount("500.000");
        String DiscountProductAmount = invoices.getDiscountAmount();
        System.out.println("Discount Amount Is: " + DiscountProductAmount);
        Allure.addAttachment("Test Output", "text/plain", "Discount Amount Is: " + invoices.getDiscountAmount());
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        invoices.clickOnSubmitButton();
        invoices.clickOnNextBasket();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        String details = invoices.getDetailsOfInvoice();

        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;
        String text = " " + "إجمالى الضريبة";
        String lastText = "";
        List<String> numbers = new ArrayList<>();

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
                String number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                numbers.add(number);
                lastText = text;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        // Print the last text and number
        if (!lastText.isEmpty()) {
            System.out.println(lastText + numbers.get(numbers.size() - 1));
            Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + lastText + numbers.get(numbers.size() - 1));
        }
        System.out.println("----------------------------------------");
        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButton();
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
            System.out.println("Extracted Text: \n" + extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "الخصم",
                    "الاجمالى الخاضع للضريبة",
                    "مجموع ضريبة القيمة المضافة",
                    "إجمالى المبلغ المستحق"
            };

            for (String line : lines) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Remove intermediate numbers
                        line = line.replaceAll("\\s+\\d+/\\d+\\s+", " ");
                        line = line.replaceAll("\\s+\\d+\\s+", " ");
                        filteredText.append(line).append("\n");
                        break;
                    }
                }
            }

            // Remove the unwanted line if it appears in the filtered text
            String result = filteredText.toString().replaceAll("السعر يشمل ضريبة القيمة المضافة \\d+\\s*", "").trim();

            System.out.println("Filtered Text: \n" + result);
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);


            // Extract values by key
            String discountAmount = extractValueByKey(result, "الخصم");
            String totalTaxAmount = extractValueByKey(result, "مجموع ضريبة القيمة المضافة");
            String totalAmount = extractValueByKey(result, "إجمالى المبلغ المستحق");

            // Accessing the first, second, and third numbers
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("First Number: " + firstNumber);
                System.out.println("Second Number: " + secondNumber);
                System.out.println("Third Number: " + thirdNumber);

                // Convert strings to BigDecimal for comparison
                BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal expectedTotalTax = new BigDecimal(totalTaxAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalTax = new BigDecimal(firstNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal expectedTotalAmount = new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalAmount = new BigDecimal(thirdNumber).setScale(2, BigDecimal.ROUND_HALF_UP);

                // Assertions
                Allure.step("Assert Total Tax Amount in cart with Total Tax Amount in invoice.");
                Assert.assertEquals(expectedTotalTax, actualTotalTax);
                Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                Assert.assertEquals(expectedDiscount, actualDiscount);
                Allure.step("Assert Total Amount in cart with Total Amount in invoice.");
                Assert.assertEquals(expectedTotalAmount, actualTotalAmount);
            } else {
                System.out.println("Not enough numbers extracted to perform assertions.");
            }


        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }


        Allure.addAttachment("Screenshot for invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        invoices.navigate();
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");
        invoices.goToInvoices();
        Thread.sleep(3000);
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        String TotalPrice = invoices.getTotalInvoicePrice();
        System.out.println(TotalPrice);

        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number

        System.out.println("last Number Equals To: " + numbers.get(numbers.size() - 1));

        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() - 1));
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        invoices.navigate();
        invoices.hideKeyboard();
        System.out.println("Invoice Small Tax Added Successfully");
    }
    // Method to extract value by key from the filtered invoice text

    @Test(priority = 2)
    @Description("This test attempts to Small Non Tax Invoice With Discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallTaxInvoiceWithDiscountOverInvoiceLevel() throws InterruptedException, IOException {
        invoices = new Invoices(driver);
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("iphone 13");
        invoices.hideKeyboard();
        invoices.clickOnProductFirst();
        invoices.clickOnClearSearch();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("Galaxy 10");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        invoices.hideKeyboard();
        invoices.goToCart();
        invoices.clickOnNextBasket();
        invoices.clickOnDiscountButton();
        Allure.step("verify to Do discount over invoice level.");
        invoices.sendKeysToInvoiceDiscount("1000");
        invoices.clickOnSubmitButtonInvoice();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        String details = invoices.getDetailsOfInvoice();
        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;
        String text = " " + "إجمالى الضريبة";
        String lastText = "";
        List<String> numbers = new ArrayList<>();

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
                String number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                numbers.add(number);
                lastText = text;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        // Print the last text and number
        if (!lastText.isEmpty()) {
            System.out.println(lastText + numbers.get(numbers.size() - 1));
            Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + lastText + numbers.get(numbers.size() - 1));
        }
        System.out.println("----------------------------------------");
        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButton();
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
            System.out.println("Extracted Text: \n" + extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "الخصم",
                    "الاجمالى الخاضع للضريبة",
                    "مجموع ضريبة القيمة المضافة",
                    "إجمالى المبلغ المستحق"
            };

            for (String line : lines) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Remove intermediate numbers
                        line = line.replaceAll("\\s+\\d+/\\d+\\s+", " ");
                        line = line.replaceAll("\\s+\\d+\\s+", " ");
                        filteredText.append(line).append("\n");
                        break;
                    }
                }
            }

            // Remove the unwanted line if it appears in the filtered text
            String result = filteredText.toString().replaceAll("السعر يشمل ضريبة القيمة المضافة \\d+\\s*", "").trim();

            System.out.println("Filtered Text: \n" + result);
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);


            // Extract values by key
            String discountAmount = extractValueByKey(result, "الخصم");
            String totalTaxAmount = extractValueByKey(result, "مجموع ضريبة القيمة المضافة");
            String totalAmount = extractValueByKey(result, "إجمالى المبلغ المستحق");

            // Accessing the first, second, and third numbers
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("First Number: " + firstNumber);
                System.out.println("Second Number: " + secondNumber);
                System.out.println("Third Number: " + thirdNumber);

                // Convert strings to BigDecimal for comparison
                BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal expectedTotalTax = new BigDecimal(totalTaxAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalTax = new BigDecimal(firstNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal expectedTotalAmount = new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalAmount = new BigDecimal(thirdNumber).setScale(2, BigDecimal.ROUND_HALF_UP);

                // Assertions
                Allure.step("Assert Total Tax Amount in cart with Total Tax Amount in invoice.");
                Assert.assertEquals(expectedTotalTax, actualTotalTax);
                Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                Assert.assertEquals(expectedDiscount, actualDiscount);
                Allure.step("Assert Total Amount in cart with Total Amount in invoice.");
                Assert.assertEquals(expectedTotalAmount, actualTotalAmount);
            } else {
                System.out.println("Not enough numbers extracted to perform assertions.");
            }



        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }


        Allure.addAttachment("Screenshot for invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        Thread.sleep(2000);
        invoices.navigate();
        invoices.goToInvoices();
        Thread.sleep(3000);
        String TotalPrice = invoices.getTotalInvoicePrice();
        System.out.println(TotalPrice);
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");
        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number

        System.out.println("last Number Equals To: " + numbers.get(numbers.size() -1));

        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() -1));
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        invoices.navigate();
        invoices.hideKeyboard();
        System.out.println("Invoice Small Non Tax Added Successfully");
    }

*/
    @Test(priority = 3)
    @Description("This test attempts to A4 Tax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void A4TaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException {
        invoices = new Invoices(driver);
        invoices.A4Invoice();
        invoices.navigate();
        invoices.navigate();
        Allure.step("verify to add product to cart");
        invoices.sendKeysToSearchProduct("Galaxy 10");
        invoices.hideKeyboard();
        invoices.clickOnProduct();
        invoices.clickOnClearSearch();
        invoices.hideKeyboard();
        invoices.goToCart();
        Thread.sleep(3000);
        invoices.clickOnEditProduct();
        invoices.sendKeysToDiscount("750");
        System.out.println("Discount Amount Is: " + invoices.getDiscountAmount());
        invoices.clickOnSubmitButton();
        invoices.clickOnNextBasket();
        Thread.sleep(3000);
        String details = invoices.getDetailsOfInvoice();
        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;
        String text = " " + "إجمالى الضريبة";
        String lastText = "";
        List<String> numbers = new ArrayList<>();

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
                String number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                numbers.add(number);
                lastText = text;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        // Print the last text and number
        if (!lastText.isEmpty()) {
            System.out.println(lastText + numbers.get(numbers.size() - 1));
            Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + lastText + numbers.get(numbers.size() - 1));
        }
        System.out.println("----------------------------------------");
        invoices.clickOnCashButton();
        Thread.sleep(4000);

        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File("invoice_screenshot-A4.png");
        try {
            FileUtils.copyFile(screenshot, screenshotFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic

        String extractedText;
        try {
            extractedText = tesseract.doOCR(screenshotFile);
            System.out.println("Extracted Text: \n" + extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "الاجمالى",
                    "مجموع الخصومات",
                    "إجمالى المبلغ المستحق"
            };

            Pattern arabicAndNumbersPattern = Pattern.compile("[\\p{InArabic}\\d.,:]+");

            for (String line : lines) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Extract only Arabic text and numbers
                        matcher = arabicAndNumbersPattern.matcher(line);
                        StringBuilder cleanedLine = new StringBuilder();
                        while (matcher.find()) {
                            cleanedLine.append(matcher.group()).append(" ");
                        }
                        filteredText.append(cleanedLine.toString().trim()).append("\n");
                        break;
                    }
                }
            }
            // Remove the unwanted line if it appears in the filtered text
            String result = filteredText.toString().replaceAll("طريقة الدفع \\d+\\s*", "").trim();

            System.out.println("Filtered Text: \n" + result);
            System.out.println("******************************");
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);

            // Extract values by key
            String totalAmount = extractValueByKeyA4(result, "الاجمالى");
            System.out.println( "totalAmount: " + totalAmount);
            String discountAmount = extractValueByKeyA4(result, "مجموع الخصومات");
            System.out.println("discountAmount: " + discountAmount);
            String totalAmountAfterDiscount = extractValueByKeyA4(result, "إجمالى المبلغ المستحق");
            System.out.println("totalAmountAfterDiscount: " + totalAmountAfterDiscount);
            //String totalAmountBeforeDiscount = discountAmount + totalAmountAfterDiscount;

            // Check if extracted values are valid
            if (discountAmount == null || totalAmountAfterDiscount == null) {
                System.out.println("Error: One of the extracted values is null.");
                return;
            }

            BigDecimal totalAmountBeforeDiscount = new BigDecimal(totalAmountAfterDiscount).add(new BigDecimal(discountAmount));
            System.out.println("totalAmountBeforeDiscount: " + totalAmountBeforeDiscount);
            // Accessing the numbers
            //ArrayList<String> numbers = new ArrayList<>();
            Pattern numberPattern = Pattern.compile("\\d+(?:\\.\\d+)?");
            Matcher numberMatcher = numberPattern.matcher(result);
            while (numberMatcher.find()) {
                numbers.add(numberMatcher.group().replace(",", ""));
            }

            // Assertions
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("إجمالى الضريبة: " + firstNumber);
                System.out.println("الخصم: " + secondNumber);
                System.out.println("المجموع بعد الخصم: " + thirdNumber);

                try {
                    BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal expectedAmountAfterDiscount = new BigDecimal(totalAmountAfterDiscount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal actualAmountAfterDiscount = new BigDecimal(thirdNumber).setScale(2, BigDecimal.ROUND_HALF_UP);

                    // Assertions
                    //Allure.step("Assert Total Amount Before Discount in cart with Total Amount Before Discount in invoice.");
                    //Assert.assertEquals(expectedTotalAmountBeforeDiscount, actualTotalAmountBeforeDiscount);
                    Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                    Assert.assertEquals(expectedDiscount, actualDiscount);
                    Allure.step("Assert Total Amount After Discount in cart with Total Amount After Discount in invoice.");
                    Assert.assertEquals(expectedAmountAfterDiscount, actualAmountAfterDiscount);

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("Not enough numbers extracted to perform assertions.");
            }

        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }

        Allure.addAttachment("Screenshot for Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        invoices.navigate();
        invoices.goToInvoices();
        Thread.sleep(3000);
        String TotalPrice = invoices.getTotalInvoicePrice();
        System.out.println(TotalPrice);
        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number
        // Compare TotalPrice with the last extracted number

        System.out.println("last Number Equals To: " + numbers.get(numbers.size() -1));

        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() -1));
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        invoices.navigate();
        invoices.hideKeyboard();
        System.out.println("A4Invoice Added Successfully");
    }

    @Test(priority = 4)
    @Description("This test attempts to A4 Invoice with discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void A4TaxInvoiceWithDiscountOverInvoiceLevel() throws InterruptedException {
        invoices = new Invoices(driver);
        Thread.sleep(3000);
        invoices.sendKeysToSearchProduct("Galaxy 0999");
        invoices.hideKeyboard();
        invoices.clickOnProduct();
        invoices.clickOnClearSearch();
        invoices.sendKeysToSearchProduct("Galaxy 10");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        invoices.hideKeyboard();
        invoices.goToCart();
        invoices.clickOnNextBasket();
        Thread.sleep(3000);
        invoices.clickOnDiscountButton();
        invoices.sendKeysToInvoiceDiscount("4000.00");
        invoices.clickOnSubmitButtonInvoice();
        Thread.sleep(3000);
        String details = invoices.getDetailsOfInvoice();
        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;
        String text = " " + "إجمالى الضريبة";
        String lastText = "";
        List<String> numbers = new ArrayList<>();

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
                String number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                numbers.add(number);
                lastText = text;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        // Print the last text and number
        if (!lastText.isEmpty()) {
            System.out.println(lastText + numbers.get(numbers.size() - 1));
            Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + lastText + numbers.get(numbers.size() - 1));
        }
        System.out.println("----------------------------------------");
        invoices.clickOnCashButton();
        Thread.sleep(4000);

        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File("invoice_screenshot-A4.png");
        try {
            FileUtils.copyFile(screenshot, screenshotFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic

        String extractedText;
        try {
            extractedText = tesseract.doOCR(screenshotFile);
            System.out.println("Extracted Text: \n" + extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "الاجمالى",
                    "مجموع الخصومات",
                    "إجمالى المبلغ المستحق"
            };

            Pattern arabicAndNumbersPattern = Pattern.compile("[\\p{InArabic}\\d.,:]+");

            for (String line : lines) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Extract only Arabic text and numbers
                        matcher = arabicAndNumbersPattern.matcher(line);
                        StringBuilder cleanedLine = new StringBuilder();
                        while (matcher.find()) {
                            cleanedLine.append(matcher.group()).append(" ");
                        }
                        filteredText.append(cleanedLine.toString().trim()).append("\n");
                        break;
                    }
                }
            }
            // Remove the unwanted line if it appears in the filtered text
            String result = filteredText.toString().replaceAll("طريقة الدفع \\d+\\s*", "").trim();

            System.out.println("Filtered Text: \n" + result);
            System.out.println("******************************");
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);

            // Extract values by key
            String totalAmount = extractValueByKeyA4(result, "الاجمالى");
            System.out.println( "totalAmount: " + totalAmount);
            String discountAmount = extractValueByKeyA4(result, "مجموع الخصومات");
            System.out.println("discountAmount: " + discountAmount);
            String totalAmountAfterDiscount = extractValueByKeyA4(result, "إجمالى المبلغ المستحق");
            System.out.println("totalAmountAfterDiscount: " + totalAmountAfterDiscount);
            //String totalAmountBeforeDiscount = discountAmount + totalAmountAfterDiscount;

            // Check if extracted values are valid
            if (discountAmount == null || totalAmountAfterDiscount == null) {
                System.out.println("Error: One of the extracted values is null.");
                return;
            }

            BigDecimal totalAmountBeforeDiscount = new BigDecimal(totalAmountAfterDiscount).add(new BigDecimal(discountAmount));
            System.out.println("totalAmountBeforeDiscount: " + totalAmountBeforeDiscount);
            // Accessing the numbers
            //ArrayList<String> numbers = new ArrayList<>();
            Pattern numberPattern = Pattern.compile("\\d+(?:\\.\\d+)?");
            Matcher numberMatcher = numberPattern.matcher(result);
            while (numberMatcher.find()) {
                numbers.add(numberMatcher.group().replace(",", ""));
            }

            // Assertions
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("إجمالى الضريبة: " + firstNumber);
                System.out.println("الخصم: " + secondNumber);
                System.out.println("المجموع بعد الخصم: " + thirdNumber);

                try {
                    // Convert strings to BigDecimal for comparison
                    //BigDecimal expectedTotalAmountBeforeDiscount = new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    //BigDecimal actualTotalAmountBeforeDiscount = totalAmountBeforeDiscount.setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal expectedAmountAfterDiscount = new BigDecimal(totalAmountAfterDiscount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal actualAmountAfterDiscount = new BigDecimal(thirdNumber).setScale(2, BigDecimal.ROUND_HALF_UP);

                    // Assertions
                    //Allure.step("Assert Total Amount Before Discount in cart with Total Amount Before Discount in invoice.");
                    //Assert.assertEquals(expectedTotalAmountBeforeDiscount, actualTotalAmountBeforeDiscount);
                    Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                    Assert.assertEquals(expectedDiscount, actualDiscount);
                    Allure.step("Assert Total Amount After Discount in cart with Total Amount After Discount in invoice.");
                    Assert.assertEquals(expectedAmountAfterDiscount, actualAmountAfterDiscount);

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("Not enough numbers extracted to perform assertions.");
            }

        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }

        Allure.addAttachment("Screenshot for Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        invoices.navigate();
        invoices.goToInvoices();
        Thread.sleep(3000);
        String TotalPrice = invoices.getTotalInvoicePrice();
        System.out.println(TotalPrice);
        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number
        // Compare TotalPrice with the last extracted number

        System.out.println("last Number Equals To: " + numbers.get(numbers.size() -1));

        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() -1));

            BigDecimal expectedTotalPriceValue = new BigDecimal(totalPriceValue).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal actualLastNumberValue = new BigDecimal(lastNumberValue).setScale(2, BigDecimal.ROUND_HALF_UP);

            Assert.assertEquals(expectedTotalPriceValue, actualLastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        invoices.navigate();
        invoices.hideKeyboard();
        System.out.println("A4Invoice with discount over invoice level Added Successfully");
    }



    @Test(priority = 5)
    @Description("This test attempts to Small Non Tax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmalNonTaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException {
        invoices = new Invoices(driver);
        Allure.step("verify to select Invoice Type.");
        invoices.SmallTaxInvoice();
        invoices.navigate();
        invoices.navigate();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("Galaxy 10");
        invoices.hideKeyboard();
        invoices.clickOnProduct();
        invoices.clickOnClearSearch();
        invoices.hideKeyboard();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.goToCart();
        Thread.sleep(3000);
        Allure.step("verify to Do discount over product.");
        invoices.clickOnEditProduct();
        invoices.sendKeysToDiscount("500.00");
        System.out.println("Discount Amount Is: " + invoices.getDiscountAmount());
        Allure.addAttachment("Test Output", "text/plain", "Discount Amount Is: " + invoices.getDiscountAmount());
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.clickOnSubmitButton();
        invoices.clickOnNextBasket();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        String details = invoices.getDetailsOfInvoice();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;
        String text = " " + "إجمالى الضريبة";
        String lastText = "";
        List<String> numbers = new ArrayList<>();

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
                String number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                numbers.add(number);
                lastText = text;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        // Print the last text and number
        if (!lastText.isEmpty()) {
            System.out.println(lastText + numbers.get(numbers.size() - 1));
            Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + lastText + numbers.get(numbers.size() - 1));
        }
        System.out.println("----------------------------------------");
        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButton();
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
            System.out.println("Extracted Text: \n" + extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "الخصم",
                    "إجمالى المبلغ المستحق"
            };

            for (String line : lines) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Remove intermediate numbers
                        line = line.replaceAll("\\s+\\d+/\\d+\\s+", " ");
                        line = line.replaceAll("\\s+\\d+\\s+", " ");
                        filteredText.append(line).append("\n");
                        break;
                    }
                }
            }

            // Remove the unwanted line if it appears in the filtered text
            String result = filteredText.toString().replaceAll("كاش \\d+\\s*", "").trim();

            System.out.println("Filtered Text: \n" + result);
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);


            // Extract values by key
            String discountAmount = extractValueByKey(result, "الخصم");
            String totalAmount = extractValueByKey(result, "إجمالى المبلغ المستحق");

            // Accessing the first, second, and third numbers
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("First Number: " + firstNumber);
                System.out.println("Second Number: " + secondNumber);
                System.out.println("Third Number: " + thirdNumber);

                // Convert strings to BigDecimal for comparison
                /*BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, BigDecimal.ROUND_HALF_UP);*/
                BigDecimal expectedTotalAmount = new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalAmount = new BigDecimal(thirdNumber).setScale(2, BigDecimal.ROUND_HALF_UP);

                // Assertions
                /*Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                Assert.assertEquals(expectedDiscount, actualDiscount);*/
                Allure.step("Assert Total Amount in cart with Total Amount in invoice.");
                Assert.assertEquals(expectedTotalAmount, actualTotalAmount);
            } else {
                System.out.println("Not enough numbers extracted to perform assertions.");
            }


        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }

        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        invoices.navigate();
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");
        invoices.goToInvoices();
        Thread.sleep(3000);
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        String TotalPrice = invoices.getTotalInvoicePrice();
        System.out.println(TotalPrice);
        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number

        System.out.println("last Number Equals To: " + numbers.get(numbers.size() - 1));

        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() - 1));
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        invoices.navigate();
        invoices.hideKeyboard();
        System.out.println("Invoice Small Non Tax Added Successfully");
    }

    @Test(priority = 6)
    @Description("This test attempts to Small Non Tax Invoice With Discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void SmallNonTaxInvoiceWithDiscountOverInvoiceLevel() throws InterruptedException, IOException {
        invoices = new Invoices(driver);
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("Galaxy 0999");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("Galaxy 10");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        invoices.hideKeyboard();
        invoices.goToCart();
        invoices.clickOnNextBasket();
        invoices.clickOnDiscountButton();
        Allure.step("verify to Do discount over invoice level.");
        invoices.sendKeysToInvoiceDiscount("200.00");
        invoices.clickOnSubmitButtonInvoice();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        String details = invoices.getDetailsOfInvoice();
        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;
        String text = " " + "إجمالى الضريبة";
        String lastText = "";
        List<String> numbers = new ArrayList<>();

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
                String number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                numbers.add(number);
                lastText = text;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        // Print the last text and number
        if (!lastText.isEmpty()) {
            System.out.println(lastText + numbers.get(numbers.size() - 1));
            Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + lastText + numbers.get(numbers.size() - 1));
        }
        System.out.println("----------------------------------------");
        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButton();
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
            System.out.println("Extracted Text: \n" + extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "الخصم",
                    "الاجمالى الخاضع للضريبة",
                    "مجموع ضريبة القيمة المضافة",
                    "إجمالى المبلغ المستحق"
            };

            for (String line : lines) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Remove intermediate numbers
                        line = line.replaceAll("\\s+\\d+/\\d+\\s+", " ");
                        line = line.replaceAll("\\s+\\d+\\s+", " ");
                        filteredText.append(line).append("\n");
                        break;
                    }
                }
            }

            // Remove the unwanted line if it appears in the filtered text
            String result = filteredText.toString().replaceAll("السعر يشمل ضريبة القيمة المضافة \\d+\\s*", "").trim();

            System.out.println("Filtered Text: \n" + result);
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);


            // Extract values by key
            String discountAmount = extractValueByKey(result, "الخصم");
            String totalTaxAmount = extractValueByKey(result, "مجموع ضريبة القيمة المضافة");
            String totalAmount = extractValueByKey(result, "إجمالى المبلغ المستحق");

            // Accessing the first, second, and third numbers
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("First Number: " + firstNumber);
                System.out.println("Second Number: " + secondNumber);
                System.out.println("Third Number: " + thirdNumber);

                // Convert strings to BigDecimal for comparison
                /*BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal expectedTotalTax = new BigDecimal(totalTaxAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalTax = new BigDecimal(firstNumber).setScale(2, BigDecimal.ROUND_HALF_UP);*/
                BigDecimal expectedTotalAmount = new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalAmount = new BigDecimal(thirdNumber).setScale(2, BigDecimal.ROUND_HALF_UP);

                // Assertions
                /*Allure.step("Assert Total Tax Amount in cart with Total Tax Amount in invoice.");
                Assert.assertEquals(expectedTotalTax, actualTotalTax);
                Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                Assert.assertEquals(expectedDiscount, actualDiscount);*/
                Allure.step("Assert Total Amount in cart with Total Amount in invoice.");
                Assert.assertEquals(expectedTotalAmount, actualTotalAmount);
            } else {
                System.out.println("Not enough numbers extracted to perform assertions.");
            }


        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }

        Allure.addAttachment("Screenshot for Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        invoices.navigate();
        invoices.goToInvoices();
        Thread.sleep(3000);
        String TotalPrice = invoices.getTotalInvoicePrice();
        System.out.println(TotalPrice);
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");
        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number

        System.out.println("last Number Equals To: " + numbers.get(numbers.size() - 1));

        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() - 1));
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        invoices.navigate();
        invoices.hideKeyboard();
        System.out.println("Invoice Small Non Tax Added Successfully");
    }


    @Test(priority = 7)
    @Description("This test attempts to A4 Non Tax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void A4NonTaxInvoiceWithDiscountOverProductLevel() throws InterruptedException, IOException {
        invoices = new Invoices(driver);
        Allure.step("verify to select Invoice Type.");
        invoices.A4InvoiceNonTax();
        invoices.navigate();
        invoices.navigate();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("Galaxy 10");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        invoices.hideKeyboard();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.goToCart();
        Thread.sleep(3000);
        Allure.step("verify to Do discount over product.");
        invoices.clickOnEditProduct();
        invoices.sendKeysToDiscount("500.00");
        System.out.println("Discount Amount Is: " + invoices.getDiscountAmount());
        Allure.addAttachment("Test Output", "text/plain", "Discount Amount Is: " + invoices.getDiscountAmount());
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        invoices.clickOnSubmitButton();
        invoices.clickOnNextBasket();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        String details = invoices.getDetailsOfInvoice();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;
        String text = " " + "إجمالى الضريبة";
        String lastText = "";
        List<String> numbers = new ArrayList<>();

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
                String number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                numbers.add(number);
                lastText = text;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        // Print the last text and number
        if (!lastText.isEmpty()) {
            System.out.println(lastText + numbers.get(numbers.size() - 1));
            Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + lastText + numbers.get(numbers.size() - 1));
        }
        System.out.println("----------------------------------------");
        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButton();
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
            System.out.println("Extracted Text: \n" + extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "الخصم",
                    "إجمالى المبلغ المستحق"
            };

            for (String line : lines) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Remove intermediate numbers
                        line = line.replaceAll("\\s+\\d+/\\d+\\s+", " ");
                        line = line.replaceAll("\\s+\\d+\\s+", " ");
                        filteredText.append(line).append("\n");
                        break;
                    }
                }
            }

            // Remove the unwanted line if it appears in the filtered text
            String result = filteredText.toString().replaceAll("السعر يشمل ضريبة القيمة المضافة \\d+\\s*", "").trim();

            System.out.println("Filtered Text: \n" + result);
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);


            // Extract values by key
            String discountAmount = extractValueByKey(result, "الخصم");
            String totalAmount = extractValueByKey(result, "إجمالى المبلغ المستحق");

            // Accessing the first, second, and third numbers
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("First Number: " + firstNumber);
                System.out.println("Second Number: " + secondNumber);
                System.out.println("Third Number: " + thirdNumber);

                // Convert strings to BigDecimal for comparison
                /*BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal expectedTotalTax = new BigDecimal(totalTaxAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalTax = new BigDecimal(firstNumber).setScale(2, BigDecimal.ROUND_HALF_UP);*/
                BigDecimal expectedTotalAmount = new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal actualTotalAmount = new BigDecimal(thirdNumber).setScale(2, BigDecimal.ROUND_HALF_UP);

                // Assertions
                /*Allure.step("Assert Total Tax Amount in cart with Total Tax Amount in invoice.");
                Assert.assertEquals(expectedTotalTax, actualTotalTax);
                Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                Assert.assertEquals(expectedDiscount, actualDiscount);*/
                Allure.step("Assert Total Amount in cart with Total Amount in invoice.");
                Assert.assertEquals(expectedTotalAmount, actualTotalAmount);
            } else {
                System.out.println("Not enough numbers extracted to perform assertions.");
            }


        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }

        Allure.addAttachment("Screenshot for Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        invoices.navigate();
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");
        invoices.goToInvoices();
        Thread.sleep(3000);
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        String TotalPrice = invoices.getTotalInvoicePrice();
        System.out.println(TotalPrice);
        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number

        System.out.println("last Number Equals To: " + numbers.get(numbers.size() - 1));

        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() - 1));
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        invoices.navigate();
        invoices.hideKeyboard();
        System.out.println("Invoice Small Non Tax Added Successfully");
    }

    @Test(priority = 8)
    @Description("This test attempts to A4 Non Tax Invoice With Discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void A4NonTaxInvoiceWithDiscountOverInvoiceLevel() throws InterruptedException {
        invoices = new Invoices(driver);
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("باقة رمضان");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        Allure.step("verify to search for a product and add it in cart.");
        invoices.sendKeysToSearchProduct("ايفون 15");
        invoices.hideKeyboard();
        invoices.clickOnProduct1();
        invoices.clickOnClearSearch();
        invoices.hideKeyboard();
        invoices.goToCart();
        invoices.clickOnNextBasket();
        invoices.clickOnDiscountButton();
        Allure.step("verify to Do discount over invoice level.");
        invoices.sendKeysToInvoiceDiscount("300.00");
        invoices.clickOnSubmitButtonInvoice();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        String details = invoices.getDetailsOfInvoice();
        System.out.println("----------------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Skip initial texts if needed
        boolean skipInitialTexts = true;
        String text = " " + "إجمالى الضريبة";
        String lastText = "";
        List<String> numbers = new ArrayList<>();

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
                String number = group.substring(group.indexOf("SR") + 3); // Extract the number after "SR"
                numbers.add(number);
                lastText = text;
                System.out.println(text + number);
                Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + number);
            } else {
                text = group;
            }
        }
        // Print the last text and number
        if (!lastText.isEmpty()) {
            System.out.println(lastText + numbers.get(numbers.size() - 1));
            Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + lastText + numbers.get(numbers.size() - 1));
        }
        System.out.println("----------------------------------------");
        Allure.step("verify to do payment and print the invoice.");
        invoices.clickOnCashButton();
        Thread.sleep(4000);

        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File("invoice_screenshot-A4.png");
        try {
            FileUtils.copyFile(screenshot, screenshotFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic

        String extractedText;
        try {
            extractedText = tesseract.doOCR(screenshotFile);
            System.out.println("Extracted Text: \n" + extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);

            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "الاجمالى",
                    "مجموع الخصومات",
                    "إجمالى المبلغ المستحق"
            };

            Pattern arabicAndNumbersPattern = Pattern.compile("[\\p{InArabic}\\d.,:]+");

            for (String line : lines) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        // Extract only Arabic text and numbers
                        matcher = arabicAndNumbersPattern.matcher(line);
                        StringBuilder cleanedLine = new StringBuilder();
                        while (matcher.find()) {
                            cleanedLine.append(matcher.group()).append(" ");
                        }
                        filteredText.append(cleanedLine.toString().trim()).append("\n");
                        break;
                    }
                }
            }
            // Remove the unwanted line if it appears in the filtered text
            String result = filteredText.toString().replaceAll("طريقة الدفع \\d+\\s*", "").trim();

            System.out.println("Filtered Text: \n" + result);
            System.out.println("******************************");
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);

            // Extract values by key
            String totalAmount = extractValueByKeyA4(result, "الاجمالى");
            System.out.println( "totalAmount: " + totalAmount);
            String discountAmount = extractValueByKeyA4(result, "مجموع الخصومات");
            System.out.println("discountAmount: " + discountAmount);
            String totalAmountAfterDiscount = extractValueByKeyA4(result, "إجمالى المبلغ المستحق");
            System.out.println("totalAmountAfterDiscount: " + totalAmountAfterDiscount);
            //String totalAmountBeforeDiscount = discountAmount + totalAmountAfterDiscount;

            // Check if extracted values are valid
            if (discountAmount == null || totalAmountAfterDiscount == null) {
                System.out.println("Error: One of the extracted values is null.");
                return;
            }

            BigDecimal totalAmountBeforeDiscount = new BigDecimal(totalAmountAfterDiscount).add(new BigDecimal(discountAmount));
            System.out.println("totalAmountBeforeDiscount: " + totalAmountBeforeDiscount);
            // Accessing the numbers
            //ArrayList<String> numbers = new ArrayList<>();
            Pattern numberPattern = Pattern.compile("\\d+(?:\\.\\d+)?");
            Matcher numberMatcher = numberPattern.matcher(result);
            while (numberMatcher.find()) {
                numbers.add(numberMatcher.group().replace(",", ""));
            }

            // Assertions
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("إجمالى الضريبة: " + firstNumber);
                System.out.println("الخصم: " + secondNumber);
                System.out.println("المجموع بعد الخصم: " + thirdNumber);

                try {
                    // Convert strings to BigDecimal for comparison
                    //BigDecimal expectedTotalAmountBeforeDiscount = new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    //BigDecimal actualTotalAmountBeforeDiscount = totalAmountBeforeDiscount.setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal expectedAmountAfterDiscount = new BigDecimal(totalAmountAfterDiscount).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal actualAmountAfterDiscount = new BigDecimal(thirdNumber).setScale(2, BigDecimal.ROUND_HALF_UP);

                    // Assertions
                    //Allure.step("Assert Total Amount Before Discount in cart with Total Amount Before Discount in invoice.");
                    //Assert.assertEquals(expectedTotalAmountBeforeDiscount, actualTotalAmountBeforeDiscount);
                    Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                    Assert.assertEquals(expectedDiscount, actualDiscount);
                    Allure.step("Assert Total Amount After Discount in cart with Total Amount After Discount in invoice.");
                    Assert.assertEquals(expectedAmountAfterDiscount, actualAmountAfterDiscount);

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("Not enough numbers extracted to perform assertions.");
            }

        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }

        Allure.addAttachment("Screenshot for Invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        invoices.navigate();
        invoices.goToInvoices();
        Thread.sleep(3000);
        String TotalPrice = invoices.getTotalInvoicePrice();
        System.out.println(TotalPrice);
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");
        System.out.println("********************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number

        System.out.println("last Number Equals To: " + numbers.get(numbers.size() - 1));

        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() - 1));
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in invoices screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }
        System.out.println("********************************************");
        invoices.navigate();
        invoices.hideKeyboard();
        System.out.println("Invoice Small Non Tax Added Successfully");
    }
}