package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Invoices extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;
    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    MobileElement check1;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement check2;
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
        check1.click();
        check2.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='13']")
    MobileElement chooseInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة غير ضريبية']")
    MobileElement Tax;
    public void SmallTaxInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        Tax.click();
        submitCheck.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement A4;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement A4NonTax;
    public void A4Invoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        A4.click();
        submitCheck.click();
    }
    public void A4InvoiceNonTax(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        A4NonTax.click();
        submitCheck.click();
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
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '0']")
    MobileElement addToCartFirst;
    public void clickOnProductFirst(){
        addToCartFirst.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    MobileElement BasketButton ;
    public  void goToCart(){
        BasketButton.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    MobileElement NextButton;
    public void clickOnNextBasket(){
        NextButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '8']")
    MobileElement CashButton;
    public void clickOnCashButton(){
        CashButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '0']")
    MobileElement EditProduct;
    public void clickOnEditProduct(){
        EditProduct.click();
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
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;
    public void clickOnCashier(){
        Cashier.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='4']")
    MobileElement DiscountButton;
    public void clickOnDiscountButton(){
        DiscountButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement discountInvoiceField;
    public void sendKeysToInvoiceDiscount(String discount){
        discountInvoiceField.click();
        discountInvoiceField.clear();
        discountInvoiceField.sendKeys(discount);
        hideKeyboard();
    }
    public void clickOnSubmitButtonInvoice(){
        submitButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement Invoices;
    public void goToInvoices(){
        hamburgerMenu.click();
        Invoices.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]")
    MobileElement detailsOfInvoice;
    public String getDetailsOfInvoice(){
        return detailsOfInvoice.getAttribute("content-desc");
    }
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement TotalInvoicePrice;
    public String getTotalInvoicePrice(){
        return TotalInvoicePrice.getAttribute("content-desc");
    }
}
