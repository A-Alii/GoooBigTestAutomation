package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.OtherPaymentMethods;
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
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class GoooBig_OtherPaymentMethods extends TestBase {

    OtherPaymentMethods otherPaymentMethods;

    @Test(priority = 1)
    @Description("This test attempts to Small Non Tax Invoice With Discount over Invoice level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyOtherPaymentMethodsScreen() throws InterruptedException, IOException {
        otherPaymentMethods = new OtherPaymentMethods();
        otherPaymentMethods.smallNonTaxInvoiceForOtherPaymentMethod();
        otherPaymentMethods.navigateBack();
        otherPaymentMethods.navigateBack();
        Allure.step("verify to search for a product and add it in cart.");
        otherPaymentMethods.clickOnFirstElement();
        otherPaymentMethods.clickOnFirstElementAgain();
        otherPaymentMethods.hideKeyboard();
        otherPaymentMethods.goToCart();
        otherPaymentMethods.clickOnNextBasket();
        otherPaymentMethods.clickOnDiscountButton();
        Allure.step("verify to Do discount over invoice level.");
        otherPaymentMethods.sendKeysToInvoiceDiscount("10.00");
        otherPaymentMethods.clickOnSubmitButtonInvoice();
        Thread.sleep(3000);
    }


    @Test(priority = 2)
    @Description("")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void testcase2() throws InterruptedException, IOException {
        otherPaymentMethods = new OtherPaymentMethods();
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        String details = otherPaymentMethods.getDetailsOfInvoice();
        System.out.println("البيانات الموجوده فى السلة");
        System.out.println("-------------------------");
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
        System.out.println("*****************************************************");
        System.out.println("البيانات الموجوده فى صفحة الدفع فى الاعلى");
        String AmountPayment = otherPaymentMethods.getAmount();
        System.out.println("المبلغ: " + AmountPayment);
        String ResidualAmountPayment = otherPaymentMethods.getResidualAmount();
        System.out.println("المتبقى: " + ResidualAmountPayment);
        String getSurplusAmountPayment = otherPaymentMethods.getSurplusAmount();
        System.out.println("الفائض: " + getSurplusAmountPayment);
        String TotalNumberInPaymentScreen = otherPaymentMethods.getInvoiceTotalAmountInPaymentScreen();
        System.out.println("سعر الفاتورة الموجود فى التيكست فيلد: " + TotalNumberInPaymentScreen);
        System.out.println("*****************************************************");
        Allure.step("Assert AmountPayment in top screen with AmountPayment in text field.");
        Assert.assertEquals(TotalNumberInPaymentScreen, AmountPayment);
        System.out.println("Assert AmountPayment in top screen with AmountPayment in text field Done Successfully.");

        System.out.println("-------------------------");
        Allure.step("verify to do payment and print the invoice.");
        otherPaymentMethods.clickOnOtherPaymentMethodButton();
        otherPaymentMethods.clickOnConfirmTransaction();
        Assert.assertTrue(otherPaymentMethods.isPopUpPresent());
        System.out.println("Can't do payment transaction without doing the payment method.");
        Allure.step("send value to the text field for Invoice Amount");
        otherPaymentMethods.sendKeysToInvoiceTotalAmountInPaymentScreen("10");
        otherPaymentMethods.clickOnAddPaymentMethod();
        Thread.sleep(2000);
        Allure.step("Assert the ResidualAmountPayment in the top screen with ResidualAmountPayment in text field.");
        String expected = otherPaymentMethods.getInvoiceTotalAmountInPaymentScreen();
        Assert.assertEquals(expected, otherPaymentMethods.getResidualAmount());
        System.out.println("Assert ResidualAmountPayment in the top screen with ResidualAmountPayment in text field Done Successfully.");
        Allure.step("Select Payment Methods");
        otherPaymentMethods.clickOnPaymentMethod();
        otherPaymentMethods.clickOnPaymentMethod1();
        otherPaymentMethods.clickOnAddPaymentMethod();
        Allure.step("Assert AmountPayment in top screen with AmountPayment in text field.");
        Assert.assertEquals(TotalNumberInPaymentScreen, AmountPayment);
        System.out.println("Assert AmountPayment in top screen with AmountPayment in text field Done Successfully.");
        otherPaymentMethods.clickOnDeliveryTime();
        otherPaymentMethods.clickOnOk();
        otherPaymentMethods.clickOnOkAgain();
        String invoiceDate = otherPaymentMethods.getInvoiceDate();
        System.out.println("تاريخ الفاتورة: " + invoiceDate);
        otherPaymentMethods.clickOnEmployeeName();
        String EmployeeName = otherPaymentMethods.getEmployeeName();
        System.out.println("الاسم الموظف: " + EmployeeName);
        String getTaxNumber = otherPaymentMethods.getTaxNumber();
        System.out.println("رقم الضريبة المستحقة الموجود فى صفحة الدفع: " + getTaxNumber);
        String getTaxNumberInPaymentScreen = getTaxNumber.replaceAll("[^0-9.]", "");
        String getInvoiceTotal = otherPaymentMethods.getInvoiceTotal();
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الدفع: " + getInvoiceTotal);
        String getDiscountNumber = otherPaymentMethods.getDiscountNumber();
        System.out.println("إجمالى الخصم الموجود فى صفحة الدفع: " + getDiscountNumber);
        System.out.println("*****************************************************");
        otherPaymentMethods.clickOnConfirmTransaction();
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
            System.out.println("بيانات الفاتورة كلها");
            System.out.println("--------------------");
            System.out.println(extractedText);
            Allure.addAttachment("Extracted Invoice Text", "text/plain", extractedText);
            // Filter the extracted text
            String[] lines = extractedText.split("\n");
            StringBuilder filteredText = new StringBuilder();

            // Patterns to match the lines of interest
            String[] keywords = {
                    "المجموع قبل الخصم",
                    "إجمالى المبلغ المستحق",
                    "مجموع الخصومات",
                    "إجمالى المبلغ المستحق",
                    "مجموع ضريبة القيمة المضافة"
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
            System.out.println("البيانات المطلوبة من الفاتورة");
            System.out.println("-----------------------------");
            System.out.println(result);
            Allure.addAttachment("Filtered Invoice Text", "text/plain", result);
            System.out.println("******************************");
            // Extract values by key
            System.out.println("استخراج القيمة بأستخدام المفتاح الخاص بها من الفاتورة");
            System.out.println("----------------------------------------------------");
            String TotalBeforeDiscount = extractValueByKeyA4(result, "المجموع قبل الخصم");
            System.out.println("المجموع قبل الخصم(الفاتورة) : " + TotalBeforeDiscount);
            String discountAmount = extractValueByKeyA4(result, "مجموع الخصومات");
            System.out.println("الخصم(الفاتورة) : " + discountAmount);
            String TotalAmountTaxAdded = extractValueByKeyA4(result, "مجموع ضريبة القيمة المضافة");
            System.out.println("مجموع ضريبة القيمة المضافة(الفاتورة) : " + TotalAmountTaxAdded);
            String totalAmount = extractValueByKeyA4(result, "إجمالى المبلغ المستحق");
            System.out.println("إجمالى المبلغ المستحق(الفاتورة) : " + totalAmount);
            String totalAmountAfterDiscount = extractValueByKeyA4(result, "إجمالى المبلغ المستحق");
            System.out.println("الأجمالى بعد الخصم(الفاتورة) : " + totalAmountAfterDiscount);
            //String totalAmountBeforeDiscount = discountAmount + totalAmountAfterDiscount;

            // Check if extracted values are valid
            if (discountAmount == null || totalAmountAfterDiscount == null) {
                System.out.println("Error: One of the extracted values is null.");
                return;
            }

            BigDecimal totalAmountBeforeDiscount = new BigDecimal(TotalBeforeDiscount);
            System.out.println("الأجمالى قبل الخصم(الفاتورة) : " + totalAmountBeforeDiscount);
            // Accessing the numbers
            //ArrayList<String> numbers = new ArrayList<>();
            Pattern numberPattern = Pattern.compile("\\d+(?:\\.\\d+)?");
            Matcher numberMatcher = numberPattern.matcher(result);
            while (numberMatcher.find()) {
                numbers.add(numberMatcher.group().replace(",", ""));
            }
            System.out.println("----------------------------------------------------");
            System.out.println("استخراج القيمة بأستخدام المفتاح الخاص بها من السلة");
            System.out.println("----------------------------------------------------");
            // Assertions
            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("إجمالى الضريبة(السلة) : " + firstNumber);
                System.out.println("الخصم(السلة) : " + secondNumber);
                System.out.println("المجموع بعد الخصم(السلة) : " + thirdNumber);

                try {
                    BigDecimal expectedTaxNumber = new BigDecimal(getTaxNumberInPaymentScreen).setScale(2, RoundingMode.HALF_UP);
                    BigDecimal actualTaxNumber = new BigDecimal(firstNumber).setScale(2, RoundingMode.HALF_UP);
                    BigDecimal expectedDiscount = new BigDecimal(discountAmount).setScale(2, RoundingMode.HALF_UP);
                    BigDecimal actualDiscount = new BigDecimal(secondNumber).setScale(2, RoundingMode.HALF_UP);
                    BigDecimal expectedAmountAfterDiscount = new BigDecimal(totalAmountAfterDiscount).setScale(2, RoundingMode.HALF_UP);
                    BigDecimal actualAmountAfterDiscount = new BigDecimal(thirdNumber).setScale(2, RoundingMode.HALF_UP);

                    // Assertions
                    Allure.step("Assert Total Tax Number in Other Payment Methods Screen with Total Tax Number in cart screen.");
                    Assert.assertEquals(expectedTaxNumber, actualTaxNumber);
                    System.out.println("Assert Total Tax Number in Other Payment Methods Screen with Total Tax Number in cart screen Done Successfully.");
                    Allure.step("Assert Total Discount Amount in cart with Total Discount Amount in invoice.");
                    Assert.assertEquals(expectedDiscount, actualDiscount);
                    System.out.println("Assert Total Discount Amount in cart with Total Discount Amount in invoice Done Successfully.");
                    Allure.step("Assert Total Amount After Discount in cart with Total Amount After Discount in invoice.");
                    Assert.assertEquals(expectedAmountAfterDiscount, actualAmountAfterDiscount);
                    System.out.println("Assert Total Amount After Discount in cart with Total Amount After Discount in invoice Done Successfully.");
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

        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        otherPaymentMethods.navigateBack();
        otherPaymentMethods.clickOnCashier();
        Allure.step("verify to Navigate to Invoice to compare total price in the screen with total price in the cart.");
        otherPaymentMethods.goToInvoices();
        Thread.sleep(3000);
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println("********************************************");
        String TotalPrice = otherPaymentMethods.getTotalInvoicePrice();

        // getTaxNumber - getInvoiceTotal - getDiscountNumber  payment screen


        String getInvoiceTotalInPaymentScreen = getInvoiceTotal.replaceAll("[^0-9.]", "");
        String TotalPriceInInvoicesScreen = TotalPrice.replaceAll("[^0-9.]", "");
        System.out.println("إجمالى سعر الفاتوره فى السلة : " + numbers.get(numbers.size() - 1));
        System.out.println("إجمالى سعر الفاتوره فى صفحة الدفع : " + getInvoiceTotalInPaymentScreen);
        System.out.println("أجمالى سعر الفاتورة فى صفحة الفواتير : " + TotalPriceInInvoicesScreen);
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");
        // Compare TotalPrice with the last extracted number


        if (!numbers.isEmpty()) {
            double totalPriceValue = Double.parseDouble(cleanedTotalPrice);
            double lastNumberValue = Double.parseDouble(numbers.get(numbers.size() - 1));
            double getTotalPrice = Double.parseDouble(getInvoiceTotalInPaymentScreen);
            Assert.assertEquals(totalPriceValue, lastNumberValue); // Specify a delta value for double comparison
            System.out.println("TotalPrice is equal to the total Price number in invoices screen.");
            Assert.assertEquals(getTotalPrice, totalPriceValue);
            System.out.println("TotalPrice in Other Payment Methods Screen is equal to the total Price number in receipt.");
            Allure.addAttachment("Test Output", "text/plain", "Assertion Result is: " + "TotalPrice is equal to the total Price number in otherPaymentMethods screen.");
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }

        System.out.println("********************************************");
        otherPaymentMethods.navigateBack();
        otherPaymentMethods.hideKeyboard();
        System.out.println("Invoice Small Non Tax Added Successfully");
    }

}
