package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BranchesAndWarehouses extends TestBase {
    private AndroidDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    private MobileElement Cashier;
    public void clickOnCashier(){
        Cashier.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    private MobileElement Apply;
    public void clickOnApply(){
        Apply.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='اختر الفرع']")
    private MobileElement BranchesAndWarehouses;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'مستودع') and contains(@index, '0')]")
    private MobileElement SelectWarehouse;
    public void selectOptionFromList() throws InterruptedException{
        BranchesAndWarehouses.click();
        SelectWarehouse.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement WarehouseNameInBranches;
    public String getBranchName(){
        return WarehouseNameInBranches.getAttribute("content-desc");
    }

}
