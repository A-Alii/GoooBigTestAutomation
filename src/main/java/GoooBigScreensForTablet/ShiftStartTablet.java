package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ShiftStartTablet extends TestBase {

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    MobileElement BoxProfitTablet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement deliveryFromTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement Name2Tablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بدء الدوام']")
    MobileElement ApplyButtonTablet;
    // Tablet Testing
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إدارة الدوام']")
    MobileElement manageShift;

    public void clickOnManageShift() {
        manageShift.click();
    }

    public void SendKeysToBoxTablet(String profit) {
        BoxProfitTablet.click();
        BoxProfitTablet.sendKeys(profit);
    }

    public void clickOnDeliveryFirstTablet() {
        deliveryFromTablet.click();
        Name2Tablet.click();
    }

    public void ClickOnApplyButtonTablet() {
        ApplyButtonTablet.click();
    }

    public void clearFieldsTablet() {
        // Clear data from each field
        BoxProfitTablet.click();
        BoxProfitTablet.clear();
    }

}
