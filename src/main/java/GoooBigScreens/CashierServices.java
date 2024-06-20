package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class CashierServices extends TestBase {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادت العرض' or @index='3']")
    MobileElement presentationSettings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='منتجات وأصناف']")
    MobileElement presentationStyle;
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
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='13']")
    MobileElement chooseInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة غير ضريبية']")
    MobileElement Tax;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement A4;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement A4NonTax;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement searchbar;
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '0']")
    MobileElement addToCart;
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '1']")
    MobileElement addToCart1;
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '0']")
    MobileElement addToCartFirst;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    MobileElement BasketButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    MobileElement NextButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '8']")
    MobileElement CashButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '0']")
    MobileElement EditProduct;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    MobileElement discountField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='خدمات فقط']")
    MobileElement cashierServices;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
    List<MobileElement> ServiceName;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bيجب كتابة وصف للخدمة أولا\u202C']")
    MobileElement error;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'الخدمات') or @index='2']")
    MobileElement services;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]")
    MobileElement detailsOfInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement TotalInvoicePrice;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement Invoices;

    public CashierServices() {
        super();
    }

    public void clickOnCashier() {
        Cashier.click();
    }

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void clickOnSettings() {
        settings.click();
    }

    public void clickOnPrintingSettings() {
        printingSettings.click();
    }

    public void smallNonTaxInvoice() {
        check1.click();
        check2.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }

    public void clickOnPresentationSettings() {
        presentationSettings.click();
    }

    public void clickOnPresentationStyle() {
        presentationStyle.click();
    }

    public void clickOnCashierServices() {
        cashierServices.click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void sendKeysToServiceName(String name) {
        ServiceName.get(0).click();
        ServiceName.get(0).clear();
        ServiceName.get(0).sendKeys(name);
    }

    public void sendKeysToPriceOfService(int price) {
        ServiceName.get(1).click();
        ServiceName.get(1).clear();
        ServiceName.get(1).sendKeys(String.valueOf(price));
    }

    public boolean isErrorDisplayed() {
        return error.isDisplayed();
    }

    public void clickOnBasketButton() {
        BasketButton.click();
    }

    public void clickOnServices() {
        services.click();
    }

    public void clickOnNextButton() {
        NextButton.click();
    }

    public void clickOnCashButton() {
        CashButton.click();
    }

    public String getDetailsOfInvoice() {
        return detailsOfInvoice.getAttribute("content-desc");
    }

    public void goToInvoices() {
        hamburgerMenu.click();
        Invoices.click();
    }

    public String getTotalInvoicePrice() {
        return TotalInvoicePrice.getAttribute("content-desc");
    }
}
