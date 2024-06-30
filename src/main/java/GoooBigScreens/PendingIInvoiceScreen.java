package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PendingIInvoiceScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement NonTaxORTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة ضريبية']")
    MobileElement NonTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitCheck;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement searchbar;
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '0']")
    MobileElement addToCart;
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '1']")
    MobileElement addToCart1;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    MobileElement BasketButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    MobileElement NextButton;
    @AndroidFindBy(xpath = "//android.view.View[@index = '1']")
    MobileElement InvoicePending;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '0']")
    MobileElement EditProduct;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    MobileElement discountField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    MobileElement plusIcon;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='تعليق']")
    MobileElement Hold;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement Invoices;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]")
    MobileElement detailsOfInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    MobileElement TotalPendingInvoicePrice;

    public void smallNonTaxInvoicePendingInvoice() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }

    public void sendKeysToSearchProduct(String ProductName) {
        searchbar.click();
        searchbar.sendKeys(ProductName);
    }

    public void clickOnClearSearch() {
        clearFields();
    }

    public void clearFields() {
        searchbar.clear();
    }

    public void clickOnProduct() {
        addToCart.click();
    }

    public void clickOnProduct1() {
        addToCart1.click();
    }

    public void goToCart() {
        BasketButton.click();
    }

    public void clickOnNextBasket() {
        NextButton.click();
    }

    public void clickOnInvoicePending() {
        InvoicePending.click();
    }

    public void clickOnEditProduct() {
        EditProduct.click();
    }

    public void sendKeysToDiscount(String discount) {
        discountField.click();
        discountField.clear();
        discountField.sendKeys(discount);
        hideKeyboard();
    }

    public String getDiscountAmount() {
        return discountField.getText();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void clickOnHoldInvoice() {
        plusIcon.click();
        Hold.click();
    }

    public void clickOnCashier() {
        Cashier.click();
    }

    public void goToInvoices() {
        hamburgerMenu.click();
        Invoices.click();
    }

    public String getDetailsOfInvoice() {
        return detailsOfInvoice.getAttribute("content-desc");
    }

    public String getTotalPendingInvoicePrice() {
        return TotalPendingInvoicePrice.getAttribute("content-desc");
    }
}
