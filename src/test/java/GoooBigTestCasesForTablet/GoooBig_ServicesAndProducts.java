package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigScreensForTablet.ServicesAndProducts;
import io.qameta.allure.Allure;
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

public class GoooBig_ServicesAndProducts extends TestBase {

    ServicesAndProducts servicesAndProducts;

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

    @Test(priority = 1)
    public void TwoServicesAndTwoProducts() throws InterruptedException, IOException, TesseractException {
        servicesAndProducts = new ServicesAndProducts();
        servicesAndProducts.clickOnSettings();
        servicesAndProducts.clickOnPresentation();
        servicesAndProducts.clickOnProductAndCategories();
        servicesAndProducts.clickOnProductsAndCategoriesAndServices();
        servicesAndProducts.clickOnSaveButton();
        Thread.sleep(3000);
        servicesAndProducts.hideKeyboard();
        Allure.step("verify to search for a product and add it in cart.");
        servicesAndProducts.sendKeysToSearchProductTablet("هواوي 23");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnProductFirstTablet();
        servicesAndProducts.clearFieldsTablet();
        servicesAndProducts.sendKeysToSearchProductTablet("قرنفل مسمار");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnProductSecondTablet();
        servicesAndProducts.clearFieldsTablet();
        servicesAndProducts.hideKeyboard();
        Allure.step("verify to Add Service.");
        servicesAndProducts.clickOnServices();
        Thread.sleep(2000);
        servicesAndProducts.SendKeysToServiceName("زبادى");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.SendKeysToServicePrice("200.00");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnSaveButton();
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.SendKeysToServiceName("لحم");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.SendKeysToServicePrice("500.00");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnSaveButton();
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnRemoveService();
        Thread.sleep(2000);
        servicesAndProducts.clickOnProducts();
        Thread.sleep(2000);
        servicesAndProducts.hideKeyboard();
        Allure.step("verify to Do discount over invoice level.");
        //invoices.clickOnEditProductTablet();
        servicesAndProducts.clickOnDiscountButton();
        servicesAndProducts.SendKeysToDiscountField("200.00");
        servicesAndProducts.hideKeyboard();
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        servicesAndProducts.clickOnSaveButton();
        servicesAndProducts.hideKeyboard();
        Thread.sleep(3000);
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
        servicesAndProducts.hideKeyboard();

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


        servicesAndProducts.clickOnSettings();
        servicesAndProducts.clickOnPrintingTablet();
        servicesAndProducts.clickOnLargeNonTaxInvoiceServices();
        servicesAndProducts.clickOnSaveButton();
        Thread.sleep(2000);
        servicesAndProducts.hideKeyboard();
        Allure.step("verify to do payment and print the invoice.");
        servicesAndProducts.clickOnCashButtonTablet();
        Thread.sleep(10000);
        // Capture the screenshot and save it to a file
        File screenshotA4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgA4 = ImageIO.read(screenshotA4);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXA4 = 171;
        int cropYA4 = 1203;
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
        servicesAndProducts.navigateBack();
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.goToInvoicesTablet();
        Thread.sleep(2000);
        String TotalPriceInvoice = servicesAndProducts.getTotalInvoicePriceTablet();
        String TotalPriceInvoice2 = TotalPriceInvoice.replaceAll("SAR", "").replaceAll("[^0-9.]", "").trim();
        TotalPriceInvoice2 = removeDecimalDigits(TotalPriceInvoice2);
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الفواتير: " + TotalPriceInvoice2);
        Assert.assertEquals(TotalPriceInvoice2, textData.total);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Cart");
        Assert.assertEquals(TotalPriceInvoice2, invoiceData.totalDueAfterDiscount);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Receipt");
        servicesAndProducts.clickOnReprint();
        Thread.sleep(10000);
        servicesAndProducts.navigateBack();
        servicesAndProducts.hideKeyboard();
        System.out.println("Invoice A4 NonTax with Services Added Successfully");
    }

    @Test(priority = 2)
    public void OneServiceAndTwoProducts() throws InterruptedException, IOException, TesseractException {
        servicesAndProducts = new ServicesAndProducts();
        Allure.step("verify to search for a product and add it in cart.");
        servicesAndProducts.sendKeysToSearchProductTablet("هواوي 23");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnProductFirstTablet();
        servicesAndProducts.clearFieldsTablet();
        servicesAndProducts.sendKeysToSearchProductTablet("قرنفل مسمار");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnProductSecondTablet();
        servicesAndProducts.clearFieldsTablet();
        servicesAndProducts.hideKeyboard();
        Allure.step("verify to Add Service.");
        servicesAndProducts.clickOnServices();
        Thread.sleep(2000);
        servicesAndProducts.SendKeysToServiceName("زبادى");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.SendKeysToServicePrice("200.00");
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnSaveButton();
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.clickOnRemoveService();
        Thread.sleep(2000);
        servicesAndProducts.clickOnProducts();
        Thread.sleep(2000);
        servicesAndProducts.hideKeyboard();
        Allure.step("verify to get data like price and Tax an total price of the invoice.");
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
        servicesAndProducts.clickOnCashButtonTablet();
        Thread.sleep(10000);
        // Capture the screenshot and save it to a file
        File screenshotA4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImgA4 = ImageIO.read(screenshotA4);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropXA4 = 160;
        int cropYA4 = 1071;
        int cropWidthA4 = 368;
        int cropHeightA4 = 85;
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
        servicesAndProducts.navigateBack();
        servicesAndProducts.hideKeyboard();
        servicesAndProducts.goToInvoicesTablet();
        Thread.sleep(2000);
        String TotalPriceInvoice = servicesAndProducts.getTotalInvoicePriceTablet();
        String TotalPriceInvoice2 = TotalPriceInvoice.replaceAll("SAR", "").replaceAll("[^0-9.]", "").trim();
        TotalPriceInvoice2 = removeDecimalDigits(TotalPriceInvoice2);
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الفواتير: " + TotalPriceInvoice2);
        Assert.assertEquals(TotalPriceInvoice2, textData.total);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Cart");
        Assert.assertEquals(TotalPriceInvoice2, invoiceData.totalDueAfterDiscount);
        System.out.println("Total Price in Invoices Screen is equal to Total Price in Receipt");
        servicesAndProducts.clickOnReprint();
        Thread.sleep(10000);
        servicesAndProducts.navigateBack();
        servicesAndProducts.hideKeyboard();
        System.out.println("Invoice A4 NonTax with Services Added Successfully");
    }

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
