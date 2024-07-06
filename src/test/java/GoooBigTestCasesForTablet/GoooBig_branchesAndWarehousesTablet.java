package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreensForTablet.BranchesAndWarehousesTablet;
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
public class GoooBig_branchesAndWarehousesTablet extends TestBase {
    BranchesAndWarehousesTablet branchesAndWarehouses;

    @Test(priority = 1)
    @Description("This test attempts to verify Select Warehouse.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifySelectWarehouse() throws InterruptedException, TesseractException, IOException {
        branchesAndWarehouses = new BranchesAndWarehousesTablet();
        Allure.step("verify to click on cashier option.");
        branchesAndWarehouses.clickOnWarehouse();
        Allure.step("verify to select valid warehouse from list.");
        branchesAndWarehouses.selectFromListWarehouse();
        String WarehouseNameInField = branchesAndWarehouses.getWarehouseName();
        System.out.println("Warehouse Name is: " + WarehouseNameInField);
        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Read the screenshot image file
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Define the crop area (these coordinates should be adjusted based on your image)
        int cropX = 1502;
        int cropY = 202;
        int cropWidth = 332;
        int cropHeight = 53;
        // Crop the image
        BufferedImage croppedImg = fullImg.getSubimage(cropX, cropY, cropWidth, cropHeight);

        // Save the cropped image to a new file
        File screenshotFile = new File("WarehouseNameInHomeScreen.png");
        ImageIO.write(croppedImg, "png", screenshotFile);

        System.out.println("Cropped screenshot saved: " + screenshotFile.getAbsolutePath());
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        extractedText = tesseract.doOCR(screenshotFile);
        System.out.println("Extracted Text: " + extractedText);
        String warehouseNameInHomeScreen = extractedText.replaceAll("[^\\p{InArabic}\\s]", "");
        warehouseNameInHomeScreen = warehouseNameInHomeScreen.trim();
        System.out.println("Name Of Warehouse In Invoice: " + warehouseNameInHomeScreen);
        Assert.assertEquals(warehouseNameInHomeScreen, WarehouseNameInField, "The warehouse name in the home screen does not contain the warehouse name in the field.");
        Allure.step("verify to click on Apply button.");
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println("TEST CASE DONE SUCCESSFULLY");
    }
}
