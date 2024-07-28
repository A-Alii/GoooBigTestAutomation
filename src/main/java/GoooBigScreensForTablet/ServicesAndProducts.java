package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ServicesAndProducts extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement SettingsTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, '  الطباعة')]")
    MobileElement PrintingTablet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoiceSelectorTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='فاتورة ضريبية']")
    MobileElement selectTaxInvoiceTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='فاتورة غير ضريبية']")
    MobileElement NonTaxInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='  العرض']")
    MobileElement Presentation;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='منتجات وأصناف']")
    MobileElement ProductAndCategories;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='منتجات وأصناف وخدمات']")
    MobileElement ProductsAndCategoriesAndServices;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement SaveButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    MobileElement searchbarTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'1500\n" +
            "هواوي 23 ')]")
    MobileElement addToCartFirstTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'1000\n" +
            "قرنفل مسمار ')]")
    MobileElement addToCartSecondTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'كاش']")
    MobileElement CashButtonTablet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement InvoicesTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement TotalInvoicePriceTablet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.view.View[@index='1' and @content-desc='  الطباعة']")
    MobileElement Printing;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoiceDropDown;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoice;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement NonTaxInvoiceDropDown;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة صغيرة مبسطة']")
    MobileElement smallNonTaxInvoice;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة مبيعات غير ضريبية']")
    MobileElement A4NonTaxInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='فاتورة مبيعات غير ضريبية']")
    MobileElement largeNonTaxInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement SubmitButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='خصم']")
    MobileElement discountButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement discountField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الخدمات']")
    MobileElement services;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='المنتجات ']")
    MobileElement products;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement serviceName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement servicePrice;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    List<MobileElement> RemoveService;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    MobileElement reprint;

    public void clickOnSettings() {
        SettingsTablet.click();
    }

    public void clickOnPrintingTablet() {
        PrintingTablet.click();
    }

    public void clickOnPresentation() {
        Presentation.click();
    }

    public void clickOnProductAndCategories() {
        ProductAndCategories.click();
    }

    public void clickOnProductsAndCategoriesAndServices() {
        ProductsAndCategoriesAndServices.click();
    }

    public void clickOnSaveButton() {
        SaveButton.click();
    }

    public void sendKeysToSearchProductTablet(String ProductName) {
        searchbarTablet.click();
        searchbarTablet.sendKeys(ProductName);
    }

    public void clickOnProductFirstTablet() {
        addToCartFirstTablet.click();
    }

    public void clickOnProductSecondTablet() {
        addToCartSecondTablet.click();
    }

    public void clearFieldsTablet() {
        searchbarTablet.click();
        searchbarTablet.clear();
        driver.hideKeyboard();
    }

    public void clickOnCashButtonTablet() {
        CashButtonTablet.click();
    }

    public void goToInvoicesTablet() {
        InvoicesTablet.click();
    }

    public String getTotalInvoicePriceTablet() {
        return TotalInvoicePriceTablet.getAttribute("content-desc");
    }

    public void clickOnLargeNonTaxInvoice() {
        TaxInvoiceDropDown.click();
        NonTaxInvoice.click();
        smallNonTaxInvoice.click();
        largeNonTaxInvoice.click();
    }

    public void clickOnLargeNonTaxInvoiceServices() {
        A4NonTaxInvoice.click();
        largeNonTaxInvoice.click();
    }

    public void clickOnTaxInvoice() {
        TaxInvoiceDropDown.click();
        TaxInvoice.click();
    }

    public void clickOnNonTaxInvoice() {
        NonTaxInvoiceDropDown.click();
        NonTaxInvoice.click();
    }

    public void clickOnSubmitButton() {
        SubmitButton.click();
    }

    public void clickOnDiscountButton() {
        discountButton.click();
    }

    public void SendKeysToDiscountField(String discount) {
        discountField.click();
        hideKeyboard();
        discountField.clear();
        hideKeyboard();
        discountField.sendKeys(discount);
        hideKeyboard();
    }

    public void clickOnServices() {
        services.click();
    }

    public void clickOnProducts() {
        products.click();
    }

    public void SendKeysToServiceName(String serviceName) {
        this.serviceName.click();
        hideKeyboard();
        this.serviceName.sendKeys(serviceName);
        hideKeyboard();
    }

    public void SendKeysToServicePrice(String servicePrice) {
        this.servicePrice.click();
        hideKeyboard();
        this.servicePrice.sendKeys(servicePrice);
        hideKeyboard();
    }

    public void clickOnRemoveService() {
        RemoveService.get(2).click();
    }

    public void clickOnReprint() {
        reprint.click();
    }
}
