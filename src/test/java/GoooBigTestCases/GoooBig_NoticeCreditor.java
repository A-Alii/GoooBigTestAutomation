package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.NoticeCreditorScreen;
import io.qameta.allure.*;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_NoticeCreditor extends TestBase {
    NoticeCreditorScreen noticeCreditorScreen;
    String FilterNoticeCreditorNumberFirst;
    String FilterNoticeCreditorNumberSecond;

    @Test(priority = 1)
    @Description("This test attempts to Navigate to Make Notice Creditor invoice.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void testcase1() throws InterruptedException, IOException, TesseractException {
        noticeCreditorScreen = new NoticeCreditorScreen();
        //noticeCreditorScreen.NavigateToCashierProduct();
        /*Thread.sleep(3000);
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
        noticeCreditorScreen.navigateBack();*/
        //noticeCreditorScreen.NavigateToCashierProduct();
        Allure.step("verify to Navigate to End Shift to check the price of notice creditor was added successfully to his box.");
        noticeCreditorScreen.NavigateToEndShift();

        try {
            // Capture the screenshot and save it to a file
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Read the screenshot image file
            BufferedImage fullImg = ImageIO.read(screenshot);

            // Define the crop area (these coordinates should be adjusted based on your image)
            int cropX = 0;
            int cropY = 275;
            int cropWidth = 500;
            int cropHeight = 240;

            // Crop the image
            BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

            // Save the cropped image to a new file
            File screenshotFile = new File("EndShift_cropped_screenshot.png");
            ImageIO.write(croppedImg, "png", screenshotFile);

            System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
            // Use Tesseract to extract text from the image
            ITesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
            tesseract.setLanguage("Arabic"); // Set the language to Arabic
            String extractedText;
            extractedText = tesseract.doOCR(screenshotFile);
            FilterNoticeCreditorNumberFirst = extractedText.replaceAll("[^0-9.]", "");
            System.out.println("Notice Creditor Number: " + FilterNoticeCreditorNumberFirst);
        } catch (IOException e) {
            System.out.println("An error occurred while processing the screenshot: " + e.getMessage());
        }

        //Thread.sleep(2000);
        noticeCreditorScreen.navigateBack();
        noticeCreditorScreen.navigateBack();
        noticeCreditorScreen.hideKeyboard();
        //System.out.println("Notice Creditor Transaction Done Successfully.");
    }

    @Test(priority = 2)
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

    @Test(priority = 3)
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

    @Test(priority = 4)
    @Description("This test attempts to Edit product from cart for Notice Creditor Invoice.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyEditeProductFromNoticeCreditorInvoice() throws InterruptedException {
        step3();
    }

    @Test(priority = 5)
    @Description("This test attempts to Navigate to Make Notice Creditor invoice.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToCreateANoticeCreditorInvoice() throws InterruptedException, IOException, TesseractException {
        noticeCreditorScreen = new NoticeCreditorScreen();
        //noticeCreditorScreen.NavigateToCashierProduct();
        //Thread.sleep(3000);
        Allure.step("click on Next Button.");
        noticeCreditorScreen.clickOnNextBasket();
        System.out.println("بيانات الفاتورة الموجودة فى السلة");
        System.out.println("----------------------------------");
        String details = noticeCreditorScreen.getDetailsOfInvoice();
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
        System.out.println("----------------------------------");
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

        try {
            // Capture the screenshot and save it to a file
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Read the screenshot image file
            BufferedImage fullImg = ImageIO.read(screenshot);

            // Define the crop area (these coordinates should be adjusted based on your image)
            int cropX = 0;
            int cropY = 275;
            int cropWidth = 500;
            int cropHeight = 240;

            // Crop the image
            BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

            // Save the cropped image to a new file
            File screenshotFile = new File("EndShift_cropped_screenshot.png");
            ImageIO.write(croppedImg, "png", screenshotFile);

            System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
            // Use Tesseract to extract text from the image
            ITesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
            tesseract.setLanguage("Arabic"); // Set the language to Arabic
            String extractedText;
            extractedText = tesseract.doOCR(screenshotFile);
            FilterNoticeCreditorNumberSecond = extractedText.replaceAll("[^0-9.]", "");
            System.out.println("Notice Creditor Number: " + FilterNoticeCreditorNumberSecond);

            if (numbers.size() >= 3) {
                String firstNumber = numbers.get(0);
                String secondNumber = numbers.get(1);
                String thirdNumber = numbers.get(2);

                System.out.println("إجمالى الضريبة(السلة) : " + firstNumber);
                System.out.println("الخصم(السلة) : " + secondNumber);
                System.out.println("المجموع بعد الخصم(السلة) : " + thirdNumber);

                // Convert strings to BigDecimal for comparison
                BigDecimal NoticeCreditorNumberFirst = new BigDecimal(FilterNoticeCreditorNumberFirst).setScale(2, RoundingMode.HALF_UP);
                BigDecimal TotalAmountInCart = new BigDecimal(thirdNumber).setScale(2, RoundingMode.HALF_UP);
                BigDecimal NoticeCreditorNumberSecond = new BigDecimal(FilterNoticeCreditorNumberSecond).setScale(2, RoundingMode.HALF_UP);

                int NoticeCreditorNumberFirstInt = NoticeCreditorNumberFirst.intValue();
                int TotalAmountInCartInt = TotalAmountInCart.intValue();
                int NoticeCreditorNumberSecondInt = NoticeCreditorNumberSecond.intValue();
                int FilterNoticeCreditorNumberSum = NoticeCreditorNumberFirstInt + TotalAmountInCartInt;
                System.out.println("FilterNoticeCreditorNumberSum:  " + FilterNoticeCreditorNumberSum);
                Assert.assertEquals(FilterNoticeCreditorNumberSum, NoticeCreditorNumberSecondInt);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while processing the screenshot: " + e.getMessage());
        }

        //Thread.sleep(2000);
        noticeCreditorScreen.navigateBack();
        noticeCreditorScreen.navigateBack();
        noticeCreditorScreen.hideKeyboard();
        //System.out.println("Notice Creditor Transaction Done Successfully.");
    }


}
