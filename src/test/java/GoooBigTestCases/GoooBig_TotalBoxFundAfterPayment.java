package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.TotalBoxFundAfterPayment;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

public class GoooBig_TotalBoxFundAfterPayment extends TestBase {
    TotalBoxFundAfterPayment totalBoxFundAfterPayment;
    public double TotalBoxFund;

    @Test(priority = 1)
    @Description("Total Box Fund After Payment")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ahmed Ali")
    public void getTotalBoxFundAfterPayment() throws IOException, TesseractException, InterruptedException {
        totalBoxFundAfterPayment = new TotalBoxFundAfterPayment();
        totalBoxFundAfterPayment.clickOnInvoices();
        Double firstInvoice = Double.parseDouble(totalBoxFundAfterPayment.getFirstInvoice().replaceAll("[^0-9.]", ""));
        System.out.println("First Invoice: " + firstInvoice);
        Double secondInvoice = Double.parseDouble(totalBoxFundAfterPayment.getSecondInvoice().replaceAll("[^0-9.]", ""));
        System.out.println("Second Invoice: " + secondInvoice);
        Double thirdInvoice = Double.parseDouble(totalBoxFundAfterPayment.getThirdInvoice().replaceAll("[^0-9.]", ""));
        System.out.println("Third Invoice: " + thirdInvoice);
        Double fourthInvoice = Double.parseDouble(totalBoxFundAfterPayment.getFourthInvoice().replaceAll("[^0-9.]", ""));
        System.out.println("Fourth Invoice: " + fourthInvoice);
        Double fifthInvoice = Double.parseDouble(totalBoxFundAfterPayment.getFifthInvoice().replaceAll("[^0-9.]", ""));
        System.out.println("Fifth Invoice: " + fifthInvoice);
        Double sixthInvoice = Double.parseDouble(totalBoxFundAfterPayment.getSexInvoice().replaceAll("[^0-9.]", ""));
        System.out.println("Sixth Invoice: " + sixthInvoice);
        Double seventhInvoice = Double.parseDouble(totalBoxFundAfterPayment.getSevenInvoice().replaceAll("[^0-9.]", ""));
        System.out.println("Seventh Invoice: " + seventhInvoice);
        Double eighthInvoice = Double.parseDouble(totalBoxFundAfterPayment.getEightInvoice().replaceAll("[^0-9.]", ""));
        System.out.println("Eighth Invoice: " + eighthInvoice);
        double TotalBoxFundAfterPayment = firstInvoice + secondInvoice + thirdInvoice + fourthInvoice + fifthInvoice + sixthInvoice + seventhInvoice + eighthInvoice;
        System.out.println("Total Box Fund After Payment: " + TotalBoxFundAfterPayment);
        totalBoxFundAfterPayment.navigateBack();
        totalBoxFundAfterPayment.hideKeyboard();
        totalBoxFundAfterPayment.clickOnHamburgerMenu();
        totalBoxFundAfterPayment.clickOnEndShift();
        double getOpenBoxTotalAfterShift = Double.parseDouble(totalBoxFundAfterPayment.getOpenBoxTotal().replaceAll("[^0-9.]", ""));
        double TotalBoxFundAfterPaymentAfterShift = Double.parseDouble(totalBoxFundAfterPayment.getTotalBox().replaceAll("[^0-9.]", ""));
        System.out.println("Total Box Fund After Payment After Shift: " + TotalBoxFundAfterPaymentAfterShift);
        Assert.assertEquals(TotalBoxFundAfterPayment, TotalBoxFundAfterPaymentAfterShift);
        System.out.println("Total Box Fund in Invoices screen is equal to Total Box Fund After Payment in End Shift screen");
        double TotalBoxFundAllInEndShift = getOpenBoxTotalAfterShift + TotalBoxFundAfterPaymentAfterShift;
        System.out.println("Total Box Fund All In End Shift: " + TotalBoxFundAllInEndShift);
        Thread.sleep(2000);
        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX = 816;
        int cropY = 1326;
        int cropWidth = 214;
        int cropHeight = 87;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);
        // Save the cropped image to a new file
        File screenshotFile = new File("TotalBoxFundinEndShift.png");
        ImageIO.write(croppedImg, "png", screenshotFile);

        System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng"); // Set the language to Arabic
        String extractedText;
        extractedText = tesseract.doOCR(screenshotFile);
        TotalBoxFund = Double.parseDouble(extractedText.replaceAll("[^0-9.]", ""));
        System.out.println("Total Box Fund in End Shift: " + TotalBoxFund);
        Assert.assertEquals(TotalBoxFund, TotalBoxFundAllInEndShift);
        System.out.println("Total Box Fund in End Shift is equal to Total Box Fund in End Shift");
        totalBoxFundAfterPayment.navigateBack();
        totalBoxFundAfterPayment.navigateBack();
        totalBoxFundAfterPayment.hideKeyboard();
    }
}
