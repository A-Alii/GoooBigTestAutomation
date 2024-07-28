package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigScreensForTablet.NoticeCreditorTablet;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GoooBig_NoticeCreditorTablet extends TestBase {

    NoticeCreditorTablet noticeCreditorTablet;

    private static GoooBig_InvoicesTablet.InvoiceDataNonTax extractInvoiceDataNonTax(String extractedText) {
        // Split the text by new lines
        String[] lines = extractedText.split("\n");
        GoooBig_InvoicesTablet.InvoiceDataNonTax invoiceData = new GoooBig_InvoicesTablet.InvoiceDataNonTax();

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

    private static String removeDecimalDigits(String value) {
        if (value.contains(".")) {
            return value.split("\\.")[0];
        }
        return value;
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

    @Test(priority = 1)
    public void noticeCreditorTablet() throws InterruptedException, IOException, TesseractException {
        noticeCreditorTablet = new NoticeCreditorTablet();
        noticeCreditorTablet.clickOnManageShift();
        Thread.sleep(2000);
        // Capture the screenshot and save it to a file
        File screenshotA4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgA4 = ImageIO.read(screenshotA4);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXA4 = 990;
        int cropYA4 = 375;
        int cropWidthA4 = 187;
        int cropHeightA4 = 60;
        // Crop the image
        BufferedImage croppedImgA4 = fullImgA4.getSubimage(cropXA4, cropYA4, cropWidthA4, cropHeightA4);

        // Save the cropped image to a new file
        File screenshotFileA4 = new File("NoticeCreditor.png");
        ImageIO.write(croppedImgA4, "png", screenshotFileA4);

        System.out.println("Cropped screenshot saved: " + screenshotFileA4.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractA4 = new Tesseract();
        tesseractA4.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractA4.setLanguage("Arabic"); // Set the language to Arabic
        String extractedTextA4;
        extractedTextA4 = tesseractA4.doOCR(screenshotFileA4);
        extractedTextA4 = extractedTextA4.replaceAll("[^0-9.]", "").trim();
        double extractedTextA4Double = Double.parseDouble(extractedTextA4);
        System.out.println(extractedTextA4);
        noticeCreditorTablet.navigateBack();
        noticeCreditorTablet.hideKeyboard();
        noticeCreditorTablet.goToInvoicesTablet();
        Thread.sleep(2000);
        String InvoiceId = noticeCreditorTablet.getInvoiceIdNumber();
        System.out.println("Invoice Id Number Is:" + InvoiceId);
        String TotalInvoiceAmount = noticeCreditorTablet.getTotalInvoicePriceTablet();
        TotalInvoiceAmount = TotalInvoiceAmount.replaceAll("SAR", " ").replaceAll("[^0-9.]", "").trim();
        TotalInvoiceAmount = removeDecimalDigits(TotalInvoiceAmount);
        double TotalInvoiceAmountDouble = Double.parseDouble(TotalInvoiceAmount);
        System.out.println("Total Invoice Amount Is:" + TotalInvoiceAmount);
        noticeCreditorTablet.clickOnNoticeCreditor();
        Thread.sleep(4000);
        noticeCreditorTablet.hideKeyboard();
        noticeCreditorTablet.clickOnProduct();
        Assert.assertTrue(noticeCreditorTablet.isAlertDisplayed());
        System.out.println("Can't edit the invoice");

        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX = 133;
        int cropY = 752;
        int cropWidth = 128;
        int cropHeight = 39;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

        // Save the cropped image to a new file
        File screenshotFile = new File("totalInvoicePrice.png");
        ImageIO.write(croppedImg, "png", screenshotFile);

        System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        extractedText = tesseract.doOCR(screenshotFile);
        extractedText = extractedText.replaceAll("[^0-9.]", "").trim();
        extractedText = removeDecimalDigits(extractedText);
        System.out.println(extractedText);
        Assert.assertEquals(extractedText, TotalInvoiceAmount, "Not Equal");
        noticeCreditorTablet.clickOnNoticeCreditorButton();
        Thread.sleep(2000);

        // Capture the screenshot and save it to a file
        File screenshotId = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgId = ImageIO.read(screenshotId);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXId = 853;
        int cropYId = 224;
        int cropWidthId = 407;
        int cropHeightId = 65;
        // Crop the image
        BufferedImage croppedImgId = fullImgId.getSubimage(cropXId, cropYId, cropWidthId, cropHeightId);

        // Save the cropped image to a new file
        File screenshotFileId = new File("A4NonTaxInvoiceId.png");
        ImageIO.write(croppedImgId, "png", screenshotFileId);

        System.out.println("Cropped screenshot saved: " + screenshotFileId.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractId = new Tesseract();
        tesseractId.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractId.setLanguage("eng"); // Set the language to Arabic
        String extractedTextId;
        extractedTextId = tesseractId.doOCR(screenshotFileId);
        System.out.println(extractedTextId);
        //Assert.assertEquals(extractedTextId, InvoiceId, "Not Equal");
        noticeCreditorTablet.clickOnAddButton();
        Thread.sleep(1000);
        noticeCreditorTablet.clickOnConfirmButton();
        Thread.sleep(6000);

        // Capture the screenshot and save it to a file
        File screenshotReceipt = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgReceipt = ImageIO.read(screenshotReceipt);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXReceipt = 170;
        int cropYReceipt = 1080;
        int cropWidthReceipt = 344;
        int cropHeightReceipt = 78;
        // Crop the image
        BufferedImage croppedImgReceipt = fullImgReceipt.getSubimage(cropXReceipt, cropYReceipt, cropWidthReceipt, cropHeightReceipt);

        // Save the cropped image to a new file
        File screenshotFileReceipt = new File("A4NonTaxInvoiceReceipt.png");
        ImageIO.write(croppedImgReceipt, "png", screenshotFileReceipt);

        System.out.println("Cropped screenshot saved: " + screenshotFileReceipt.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractReceipt = new Tesseract();
        tesseractReceipt.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractReceipt.setLanguage("Arabic"); // Set the language to Arabic
        String extractedTextReceipt;
        extractedTextReceipt = tesseractReceipt.doOCR(screenshotFileReceipt);
        System.out.println(extractedTextReceipt);

        // Process the extracted text to remove "SAR" and extract values
        GoooBig_InvoicesTablet.InvoiceDataNonTax invoiceData = extractInvoiceDataNonTax(extractedTextReceipt);

        // Output the variables
        System.out.println("المجموع قبل الخصم: " + invoiceData.TotalPreDiscount);
        System.out.println("مجموع الخصومات: " + invoiceData.discountsNonTax);
        System.out.println("إجمالى المبلغ المستحق: " + invoiceData.totalDueAfterDiscount);

        Assert.assertEquals(invoiceData.totalDueAfterDiscount, TotalInvoiceAmount);
        System.out.println("total price in cart equal to total price in invoice");
        noticeCreditorTablet.navigateBack();
        noticeCreditorTablet.hideKeyboard();
        noticeCreditorTablet.clickOnManageShift();
        Thread.sleep(2000);
        // Capture the screenshot and save it to a file
        File screenshotA4ManageShift = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgA4ManageShift = ImageIO.read(screenshotA4ManageShift);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXA4ManageShift = 990;
        int cropYA4ManageShift = 375;
        int cropWidthA4ManageShift = 187;
        int cropHeightA4ManageShift = 60;
        // Crop the image
        BufferedImage croppedImgA4ManageShift = fullImgA4ManageShift.getSubimage(cropXA4ManageShift, cropYA4ManageShift, cropWidthA4ManageShift, cropHeightA4ManageShift);

        // Save the cropped image to a new file
        File screenshotFileA4ManageShift = new File("NoticeCreditorManageShift.png");
        ImageIO.write(croppedImgA4ManageShift, "png", screenshotFileA4ManageShift);

        System.out.println("Cropped screenshot saved: " + screenshotFileA4ManageShift.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseractA4ManageShift = new Tesseract();
        tesseractA4ManageShift.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseractA4.setLanguage("Arabic"); // Set the language to Arabic
        String extractedTextA4ManageShift;
        extractedTextA4ManageShift = tesseractA4ManageShift.doOCR(screenshotFileA4ManageShift);
        extractedTextA4ManageShift = extractedTextA4ManageShift.replaceAll("[^0-9.]", "").trim();
        System.out.println(extractedTextA4ManageShift);
        double extractedTextA4ManageShiftDouble = Double.parseDouble(extractedTextA4ManageShift);
        System.out.println("Total Notice Creditor: " + extractedTextA4ManageShiftDouble);
        double TotalNoticeCreditor = extractedTextA4Double + TotalInvoiceAmountDouble;
        System.out.println("Total Notice Creditor: " + TotalNoticeCreditor);
        Assert.assertEquals(extractedTextA4ManageShiftDouble, TotalNoticeCreditor, "Not Equal");
        System.out.println("Notice Creditor Done Successfully");
        noticeCreditorTablet.navigateBack();
        noticeCreditorTablet.hideKeyboard();
    }

    // Class to hold the extracted invoice data
    private static class InvoiceDataNonTax {
        String TotalPreDiscount;
        String discountsNonTax;
        String totalDueAfterDiscount;
    }

}
