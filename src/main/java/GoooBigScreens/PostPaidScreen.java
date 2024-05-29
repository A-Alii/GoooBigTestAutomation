package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PostPaidScreen extends TestBase {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    MobileElement BasketButton;
    public  void goToCart(){
        BasketButton.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    MobileElement NextButton;
    public void clickOnNextBasket(){
        NextButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إشعار دائن']")
    MobileElement NoticeCreditorButton;
    public void clickOnNoticeCreditorButton(){
        NoticeCreditorButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='آجل']")
    MobileElement PostPaidButton;
    public void clickOnPostPaidButton(){
        PostPaidButton.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,' تأكيد العملية') or contains(@index,'30')]")
    MobileElement Confirmation;
    public void clickOnConfirmationButton(){
        Confirmation.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='11']")
    MobileElement NonTaxORTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة ضريبية']")
    MobileElement NonTax;
    @AndroidFindBy(xpath = "//android.view.View[@index='14']")
    MobileElement submitCheck;
    public void smallNonTaxInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"إختيار عميل\"]")
    MobileElement selectClient;
    @AndroidFindBy(xpath = "//android.view.View[contains(@index,'5') or contains(@content-desc,'teatnew')]")
    MobileElement clickOnClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار']")
    MobileElement clickOnSelectionButton;
    public void clickOnSelectClientForInvoice(){
        selectClient.click();
    }
    public void selectClientName(){
        clickOnClient.click();
    }
    public void clickOnSelection(){
        clickOnSelectionButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement searchbar;
    public void sendKeysToSearchProduct(String ProductName){
        searchbar.click();
        searchbar.sendKeys(ProductName);
    }
    public void clickOnClearSearch(){
        clearFields();
    }
    public void clearFields() {
        searchbar.clear();
    }
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '0']")
    MobileElement addToCart;
    public void clickOnProduct(){
        addToCart.click();
    }
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '1']")
    MobileElement addToCart1;
    public void clickOnProduct1(){
        addToCart1.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '0']")
    MobileElement EditProduct;
    public void clickOnEditProduct(){
        EditProduct.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    MobileElement discountField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitButton;
    public void sendKeysToDiscount(String discount){
        discountField.click();
        discountField.clear();
        discountField.sendKeys(discount);
        hideKeyboard();
        submitButton.click();
    }
}
