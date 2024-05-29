package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BranchesAndWarehouses extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement Apply;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='اختر الفرع']")
    MobileElement BranchesAndWarehouses;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'مستودع') and contains(@index, '0')]")
    MobileElement SelectWarehouse;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
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
}
