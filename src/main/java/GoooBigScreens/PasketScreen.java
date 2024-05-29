package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PasketScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    MobileElement editIcon;
    public void clickOnEditIcon(){
        editIcon.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    MobileElement discountField;
    public void sendKeysToDiscount(String discount){
        discountField.click();
        discountField.clear();
        discountField.sendKeys(discount);
        hideKeyboard();
    }
    public String getDiscountAmount(){
        return discountField.getText();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitButton;
    public void clickOnSubmitButton(){
        submitButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    MobileElement plusIcon;
    public void clickOnPlusIcon(){
        plusIcon.click();
        plusIcon.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='التالي']")
    MobileElement nextButton;
    public void clickOnNextButton(){
        nextButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement searchbar;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='كاش']")
    MobileElement cashInvoice;
    public void clickOnCashInvoice(){
        cashInvoice.click();
    }
    public void afterNavigate(){
        searchbar.clear();
        hideKeyboard();
    }
}