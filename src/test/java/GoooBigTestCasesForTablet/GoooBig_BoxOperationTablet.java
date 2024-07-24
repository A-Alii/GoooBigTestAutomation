package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigScreensForTablet.BoxOperation;
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

public class GoooBig_BoxOperationTablet extends TestBase {

    public String DepositAmount = "5000.0";
    public String NumberOfStartingManageShift;
    public String DepositNumber;
    BoxOperation boxOperation;

    @Test(priority = 1)
    public void depositTestCase() throws InterruptedException, IOException, TesseractException {
        boxOperation = new BoxOperation();
        boxOperation.clickOnManageShift();
        Thread.sleep(2000);
        // Capture the screenshot and save it to a file
        File screenshotManageShift = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshotManageShift);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX2 = 1785;
        int cropY2 = 515;
        int cropWidth2 = 160;
        int cropHeight2 = 55;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX2, cropY2, cropWidth2, cropHeight2);
        // Save the cropped image to a new file
        File screenshotFileManageShift = new File("depositScreenShot.png");
        ImageIO.write(croppedImg, "png", screenshotFileManageShift);
        System.out.println("Cropped screenshot saved: " + screenshotFileManageShift.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractManageShift = new Tesseract();
        tesseractManageShift.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractManageShift.setLanguage("eng"); // Set the language to Arabic
        String extractedTextMangeShift;
        extractedTextMangeShift = tesseractManageShift.doOCR(screenshotFileManageShift);
        NumberOfStartingManageShift = extractedTextMangeShift.replaceAll("[^0-9.]", "");
        System.out.println("Number Of deposit In Manage Shift: " + NumberOfStartingManageShift);
        boxOperation.navigateBack();
        boxOperation.clickOnTransactions();
        Thread.sleep(1000);
        boxOperation.clickOnWithdrawOrDeposit();
    }

    @Test(priority = 2)
    public void verifyToDoTransactionWithoutSelectAnything() {
        BoxOperation boxOperation = new BoxOperation();
        boxOperation.clickOnSubmit();
        Assert.assertTrue(boxOperation.isErrorPresent(), "Please select at least one transaction type");
    }

    @Test(priority = 3)
    public void verifyToDoTransactionWithSendingAmount() {
        BoxOperation boxOperation = new BoxOperation();
        boxOperation.sendKeysToAmount("5000.00");
        boxOperation.clickOnSubmit();
        Assert.assertTrue(boxOperation.isErrorPresent(), "Please select at least one transaction type");
    }

    @Test(priority = 4)
    public void verifyToDoTransactionWithSelectEmployee() throws InterruptedException {
        BoxOperation boxOperation = new BoxOperation();
        boxOperation.clearAmount();
        boxOperation.clickOnSelectDropDown();
        Thread.sleep(1000);
        boxOperation.clickOnSelectDropDownText();
        boxOperation.clickOnSubmit();
        Assert.assertTrue(boxOperation.isError2Present(), "Please select at least one transaction type");
    }

    @Test(priority = 5)
    public void verifyToDoTransactionWithValidData() throws InterruptedException, IOException, TesseractException {
        BoxOperation boxOperation = new BoxOperation();
        boxOperation.sendKeysToAmount(DepositAmount);
        boxOperation.clickOnSelectDropDown();
        Thread.sleep(1000);
        boxOperation.clickOnSelectDropDownText();
        boxOperation.clickOnSubmit();
        System.out.println("Transaction Successfully Done!");
        Thread.sleep(6000);
        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File("DepositInvoice.png");
        FileUtils.copyFile(screenshot, screenshotFile);
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        try {
            extractedText = tesseract.doOCR(screenshotFile);
            extractedText = extractedText.replace("عlدي|", "إيداع");
            System.out.println("Extracted Text: " + extractedText);
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
                } else if (line.contains("إلى")) {
                    to = line.replaceAll(".*إلى\\s*", "").trim();
                }
            }

            // Format the output
            String formattedOutput = String.format("إيداع : %s\nمن : %s\nإلى : %s", deposit, from, to);
            /*System.out.println("deposit: " + deposit);
            System.out.println("from: " + from);
            System.out.println("to: " + to);*/

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
        boxOperation.navigateBack();
        boxOperation.clickOnManageShift();
        Thread.sleep(2000);
        // Capture the screenshot and save it to a file
        File screenshotManageShift = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshotManageShift);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX2 = 1785;
        int cropY2 = 515;
        int cropWidth2 = 160;
        int cropHeight2 = 55;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX2, cropY2, cropWidth2, cropHeight2);
        // Save the cropped image to a new file
        File screenshotFileManageShift = new File("depositScreenShot.png");
        ImageIO.write(croppedImg, "png", screenshotFileManageShift);
        System.out.println("Cropped screenshot saved: " + screenshotFileManageShift.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractManageShift = new Tesseract();
        tesseractManageShift.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractManageShift.setLanguage("eng"); // Set the language to Arabic
        String extractedTextMangeShift;
        extractedTextMangeShift = tesseractManageShift.doOCR(screenshotFileManageShift);
        DepositNumber = extractedTextMangeShift.replaceAll("[^0-9.]", "");
        System.out.println("Number Of deposit In Manage Shift: " + DepositNumber);

        double DepositAmountDouble = Double.parseDouble(DepositAmount);
        System.out.println("Deposit Amount In Manage Shift: " + DepositAmountDouble);
        double NumberOfStartingManageShiftDouble = Double.parseDouble(NumberOfStartingManageShift);
        System.out.println("Number Of Starting Manage Shift: " + NumberOfStartingManageShiftDouble);
        double DepositNumberDouble = Double.parseDouble(DepositNumber);
        System.out.println("Deposit Number: " + DepositNumberDouble);
        double DepositAmountInField = DepositAmountDouble + NumberOfStartingManageShiftDouble;
        System.out.println("Deposit Amount In Field: " + DepositAmountInField);
        Assert.assertEquals(DepositAmountInField, DepositNumberDouble, "Deposit Amount In Field is not equal to Deposit Amount In Manage Shift");
        boxOperation.navigateBack();
    }

}
