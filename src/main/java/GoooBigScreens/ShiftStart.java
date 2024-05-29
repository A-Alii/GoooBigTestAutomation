package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ShiftStart extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    MobileElement BoxProfit;
    public void SendKeysToBox(String profit){
        BoxProfit.click();
        BoxProfit.sendKeys(profit);
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='4']")
    MobileElement deliveryFrom;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement Name2;
    public void clickOnDeliveryFirst(){
        deliveryFrom.click();
        Name2.click();
    }
    public void clearFields() {
        // Clear data from each field
        BoxProfit.click();
        BoxProfit.clear();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بدء الدوام']")
    MobileElement ApplyButton;
    public void ClickOnApplyButton(){
        ApplyButton.click();
    }
}
