package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreensForTablet.ShiftStartTablet;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
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

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_ShiftStartTablet extends TestBase {
    ShiftStartTablet shiftStart;
    String StartingShift = "5000.0";

    // Tablet Testing
    @Test(priority = 1)
    @Description("This test attempts to verify click on Apply without enter Box Fund Start.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void clickOnApplyWithoutEnterBoxFundStart() throws InterruptedException {
        shiftStart = new ShiftStartTablet();
        Allure.step("verify to enter Empty Data To Box Fund");
        shiftStart.clickOnManageShift();
        shiftStart.SendKeysToBoxTablet(" ");
        Allure.step("verify to select delivery from");
        shiftStart.clickOnDeliveryFirstTablet();
        Allure.step("verify to click on Apply Button");
        shiftStart.ClickOnApplyButtonTablet();
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        System.out.println("من فضلك ادخل رصيد الصندوق");
        Allure.step("verify to clear fields");
        shiftStart.clearFieldsTablet();
    }

    @Test(priority = 2)
    @Description("This test attempts to verify click on Apply with valid data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyClickOnApplyWithValidData() throws InterruptedException {
        shiftStart = new ShiftStartTablet();
        Allure.step("verify to enter a valid data to Box Fund");
        shiftStart.SendKeysToBoxTablet(StartingShift);
        Allure.step("verify to select delivery from");
        shiftStart.clickOnDeliveryFirstTablet();
        Allure.step("verify to click on Apply Button");
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        shiftStart.ClickOnApplyButtonTablet();
        System.out.println("Shift Started Successfully");
    }

    @Test(priority = 3)
    @Description("This test attempts to verify The Number of Starting Shift.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyNumberOfStartingShift() throws InterruptedException, IOException, TesseractException {
        shiftStart = new ShiftStartTablet();
        shiftStart.clickOnManageShift();
        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX = 1795;
        int cropY = 347;
        int cropWidth = 145;
        int cropHeight = 55;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

        // Save the cropped image to a new file
        File screenshotFile = new File("NumberOfStartingShift.png");
        ImageIO.write(croppedImg, "png", screenshotFile);

        System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng"); // Set the language to Arabic
        String extractedText;
        extractedText = tesseract.doOCR(screenshotFile);
        String NumberOfStartingShift = extractedText.replaceAll("[^0-9.]", "");
        System.out.println("Number Of Products In Invoice: " + NumberOfStartingShift);
        Assert.assertEquals(NumberOfStartingShift, StartingShift, "The Number of Start Shift in the Mange Shift screen does not match the Number of Starting Shift in the field.");
        shiftStart.navigateBack();
    }
}
