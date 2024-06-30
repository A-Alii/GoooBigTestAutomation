package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.BoxOperation;
import io.qameta.allure.Allure;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class GoooBig_BoxOperation extends TestBase {
    BoxOperation boxOperation;
    String amount = "500.0";
    String DepositNumber = "";

    private static String correctArabicName(String name) {
        // Add more corrections as needed
        return name.replace("عبدالرح", "عبدالرحمن")
                .replace("محم", "محمد")
                .replace("عل", "علي");
    }

/*    @Test(priority = 2)
    public void DepositTransactionWithoutAmount() {
        boxOperation = new BoxOperation();
        boxOperation.selectDepositTransactionType();
        boxOperation.clickApplyTransaction();
        System.out.println("Please select an employee and enter an amount you wanted!!!!!");
    }

    @Test(priority = 3)
    public void WithdrawTransactionWithNullAmount() throws InterruptedException {
        boxOperation = new BoxOperation();
        boxOperation.selectWithdrawTransactionType();
        boxOperation.sendKeysToBoxOperation2(" ");
        boxOperation.clickOnEmployee();
        System.out.println("Please enter an amount you wanted!!!!!");
        Thread.sleep(2000);
    }*/

    @Test(priority = 1)
    public void NavigateToBoxOperations() throws InterruptedException {
        boxOperation = new BoxOperation();
        boxOperation.navigateToCashier();
        boxOperation.goToBoxOperation();
        boxOperation.isBoxOperationScreenDisplay();
        System.out.println("Box Operation Screen Is Displayed.");
    }

    @Test(priority = 4)
    public void testcase4() throws InterruptedException, IOException {
        boxOperation = new BoxOperation();
        Thread.sleep(1000);
        boxOperation.selectDepositTransactionType();
        boxOperation.sendKeysToBoxOperation2(amount);
        boxOperation.clickOnEmployee();
        boxOperation.clickApplyTransaction();
        System.out.println("Transaction Successfully Done!");
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
            extractedText = extractedText.replace("عlدي|", "إيداع");

            // Extract required information
            String deposit = "";
            String from = "";
            String to = "";

            String[] lines = extractedText.split("\n");
            for (String line : lines) {
                if (line.contains("إيداع")) {
                    deposit = line.replaceAll("[^0-9.]", "").trim();
                } else if (line.contains("من")) {
                    from = line.replaceAll(".*من\\s*", "").trim();
                    // Attempt to correct common OCR errors in Arabic names
                    //from = correctArabicName(from);
                } else if (line.contains("إلى")) {
                    to = line.replaceAll(".*إلى\\s*", "").trim();
                }
            }

            // Format the output
            String formattedOutput = String.format("إيداع : %s\nمن : %s\nإلى : %s", deposit, from, to);
            System.out.println("deposit: " + deposit);
            System.out.println("from: " + from);
            System.out.println("to: " + to);

            System.out.println("----------------------------------");
            System.out.println("البيانات المطلوبة من الفاتورة");
            System.out.println("----------------------------------");
            System.out.println(formattedOutput);

            Allure.addAttachment("Formatted Invoice Data", "text/plain", formattedOutput);

        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        boxOperation.navigateBack();
        boxOperation.goToEndShift();
        try {
            // Capture the screenshot and save it to a file
            File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Read the screenshot image file
            BufferedImage fullImg = ImageIO.read(screenshot1);

            // Define the crop area (these coordinates should be adjusted based on your image)
            int cropX = 830;
            int cropY = 660;
            int cropWidth = 200;
            int cropHeight = 50;

            // Crop the image
            BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

            // Save the cropped image to a new file
            File screenshotFile1 = new File("Deposit_cropped_screenshot.png");
            ImageIO.write(croppedImg, "png", screenshotFile1);

            System.out.println("Cropped screenshot saved: " + screenshotFile1.getAbsolutePath());
            // Use Tesseract to extract text from the image
            String extractedText1 = tesseract.doOCR(screenshotFile1);
            DepositNumber = extractedText1.replaceAll("[^0-9.]", "");
            System.out.println("Deposit Number: " + DepositNumber);
        } catch (IOException | TesseractException e) {
            System.out.println("An error occurred while processing the screenshot: " + e.getMessage());
        }
        Assert.assertEquals(DepositNumber, amount);
        System.out.println("Deposit Number Enter By Cashier is equal to the amount of Deposit In Box Operation");
        boxOperation.clickOnCancelButton();
        Assert.assertTrue(boxOperation.logoIsDisplay(), "Logo Not Display");
        boxOperation.navigateBack();
        boxOperation.hideKeyboard();
        boxOperation.navigateBack();
        boxOperation.navigateBack();
    }

}
