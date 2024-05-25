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
    private MobileElement BrancheRyadh;
    public void selectOptionFromList() throws InterruptedException{
        BranchesAndWarehouses.click();
        BrancheRyadh.click();
        //System.out.println(BrancheRyadh.getText());
    }

}
