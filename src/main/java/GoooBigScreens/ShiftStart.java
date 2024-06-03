package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ShiftStart extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    MobileElement BoxProfit;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='4']")
    MobileElement deliveryFrom;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement Name2;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بدء الدوام']")
    MobileElement ApplyButton;

    public void SendKeysToBox(String profit) {
        BoxProfit.click();
        BoxProfit.sendKeys(profit);
    }

    public void clickOnDeliveryFirst() {
        deliveryFrom.click();
        Name2.click();
    }

    public void clearFields() {
        // Clear data from each field
        BoxProfit.click();
        BoxProfit.clear();
    }

    public void ClickOnApplyButton() {
        ApplyButton.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement Navbar;
    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement Name1;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='مناوباتي']")
    private MobileElement Shifts;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    private MobileElement Cashier;

    public String navbarIsVisible() {
        return Navbar.getText();
    }

    public void clickOnDeliveryFrom() {
        deliveryFrom.click();
        Name1.click();
        deliveryFrom.click();
        Name2.click();
    }

    public void ClickOnShifts() {
        Shifts.click();
    }

    public void ClickOnCashier() {
        Cashier.click();
    }

}
