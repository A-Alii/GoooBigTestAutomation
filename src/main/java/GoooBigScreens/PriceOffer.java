package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PriceOffer extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement hamburgerMenu;
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
    public void smallNonTaxInvoiceDisplayPrice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        NonTax.click();
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
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '6']")
    MobileElement DisplayPrice;
    public void clickOnDisplayPriceButton(){
        DisplayPrice.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@index = '2']")
    MobileElement InvoiceDisplayPrice;
    public void clickOnInvoiceDisplayPrice(){
        InvoiceDisplayPrice.click();
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
    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    MobileElement TotalInvoicePrice;
    public String getTotalInvoicePrice(){
        return TotalInvoicePrice.getAttribute("content-desc");
    }
}
