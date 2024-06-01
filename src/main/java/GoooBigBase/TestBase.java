package GoooBigBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestBase {
    protected static AndroidDriver<MobileElement> driver;
    protected FileInputStream inputStream;
    protected Properties prop;

    public TestBase(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Parameters({"deviceName", "platformName", "platformVersion"})
    @BeforeSuite
    public void beforeClass(String deviceName, String platformName, String platformVersion) throws IOException {
        File propFile = new File("src\\main\\java\\GoooBigResources\\config.properties");
        inputStream = new FileInputStream(propFile);
        prop = new Properties();
        prop.load(inputStream);
        File androidApp = new File(prop.getProperty("androidAppPath"));
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
        caps.setCapability(MobileCapabilityType.APP, androidApp.getAbsolutePath());
        driver = new AndroidDriver<MobileElement>(new URL(prop.getProperty("appiumServerLink")), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public String extractValueByKey(String text, String key) {
        String value = "";
        String[] lines = text.split("\n");
        for (String line : lines) {
            if (line.contains(key)) {
                // Extract the value by removing any non-numeric characters
                value = line.replaceAll("[^0-9.]", "");
                break;
            }
        }
        return value;
    }

    public static String extractValueByKeyA4(String text, String key) {
        Pattern pattern = Pattern.compile(key + "\\s*:\\s*([\\d.,]+)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1).replace(",", "").replaceAll("\\s+", "");
        }
        return null;
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

}
