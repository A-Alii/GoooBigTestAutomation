package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class BranchesAndWarehousesTablet extends TestBase {

    // Tablet Testing
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='اختر الفرع']")
    MobileElement Warehouse;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'مستودع') and contains(@index, '0')]")
    MobileElement SelectFromWarehousesList;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    List<MobileElement> WarehouseName;

    public void clickOnWarehouse() {
        Warehouse.click();
    }

    public void selectFromListWarehouse() {
        SelectFromWarehousesList.click();
    }

    public String getWarehouseName() {
        return WarehouseName.get(1).getAttribute("content-desc");
    }

}
