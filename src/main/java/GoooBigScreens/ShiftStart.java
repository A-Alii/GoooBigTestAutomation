package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriverException;

public class ShiftStart extends TestBase {

    private AppiumDriver driver;

    public ShiftStart(AppiumDriver driver) {
        this.driver = driver;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement Navbar;



    public String navbarIsVisible(){
       return Navbar.getText();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    private MobileElement BoxProfit;
    public void SendKeysToBox(String profit){
        BoxProfit.click();
        BoxProfit.sendKeys(profit);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='4']")
    private MobileElement deliveryFrom;
    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement Name1;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement Name2;
    public void clickOnDeliveryFirst(){
        deliveryFrom.click();
        Name2.click();
    }
    public void clickOnDeliveryFrom(){
        deliveryFrom.click();
        Name1.click();
        deliveryFrom.click();
        Name2.click();
    }

    public void clearFields() {
        // Clear data from each field
        BoxProfit.click();
        BoxProfit.clear();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بدء الدوام']")
    private MobileElement ApplyButton;
    public void ClickOnApplyButton(){
        ApplyButton.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='مناوباتي']")
    private MobileElement Shifts;
    public void ClickOnShifts(){
        Shifts.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    private MobileElement Cashier;
    public void ClickOnCashier(){
        Cashier.click();
    }




}
