package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PinnedWarehouseTablet extends TestBase {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement Settings;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='  الفرع']")
    MobileElement warehouses;

    public void clickOnSettings() {
        Settings.click();
    }

    public void clickOnWarehouses() {
        warehouses.click();
    }

}
