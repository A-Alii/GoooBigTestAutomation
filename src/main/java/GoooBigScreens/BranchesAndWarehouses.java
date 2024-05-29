package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BranchesAndWarehouses extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;
    public void clickOnCashier(){
        Cashier.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement Apply;
    public void clickOnApply(){
        Apply.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='اختر الفرع']")
    MobileElement BranchesAndWarehouses;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'مستودع') and contains(@index, '0')]")
    MobileElement SelectWarehouse;
    public void selectOptionFromList(){
        BranchesAndWarehouses.click();
        SelectWarehouse.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement WarehouseNameInBranches;
    public String getBranchName(){
        return WarehouseNameInBranches.getAttribute("content-desc");
    }
}
