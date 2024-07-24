package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class BranchesAndWarehouses extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement Apply;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='اختر الفرع']")
    MobileElement BranchesAndWarehouses;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'مستودع') and contains(@index, '0')]")
    MobileElement SelectWarehouse;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='5']")
    MobileElement WarehouseNameInBranches;
    public void clickOnCashier() {
        Cashier.click();
    }
    public void clickOnApply() {
        Apply.click();
    }
    public void selectOptionFromList() {
        BranchesAndWarehouses.click();
        SelectWarehouse.click();
    }
    public String getBranchName() {
        return WarehouseNameInBranches.getAttribute("content-desc");
    }


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
