package GoooBigListener;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class OCRHelper {

    public static String extractTextFromScreenshot(AppiumDriver<MobileElement> driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Path to the tessdata directory

        try {
            // Save the screenshot to a file
            Files.copy(screenshot.toPath(), Paths.get("screenshot.png"));
            // Perform OCR on the screenshot file
            return tesseract.doOCR(new File("screenshot.png"));
        } catch (IOException | TesseractException e) {
            e.printStackTrace();
            return null;
        }
    }

}
