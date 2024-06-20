package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class Invoices extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;


    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    List<MobileElement> check1;

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    List<MobileElement> getCheck1;


    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement check2;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement NonTaxORTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة ضريبية']")
    MobileElement NonTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
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
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='4']")
    MobileElement DiscountButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement discountInvoiceField;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement Invoices;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]")
    MobileElement detailsOfInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement TotalInvoicePrice;

    public void smallNonTaxInvoice() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
    }

    public void checkbox1() {
        MobileElement element = check1.get(1);
        List<MobileElement> innerElements = element.findElements(By.xpath("//android.view.View[@index='0']"));
        innerElements.get(0).click();
    }

    public void checkbox2() {
        check2.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }

    public void SmallTaxInvoice() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        Tax.click();
        submitCheck.click();
    }

    public void A4Invoice() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        A4.click();
        submitCheck.click();
    }

    public void A4InvoiceNonTax() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        A4NonTax.click();
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

    public void clickOnProductFirst() {
        addToCartFirst.click();
    }

    public void goToCart() {
        BasketButton.click();
    }

    public void clickOnNextBasket() {
        NextButton.click();
    }

    public void clickOnCashButton() {
        CashButton.click();
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

    public void clickOnCashier() {
        Cashier.click();
    }

    public void clickOnDiscountButton() {
        DiscountButton.click();
    }

    public void sendKeysToInvoiceDiscount(String discount) {
        discountInvoiceField.click();
        discountInvoiceField.clear();
        discountInvoiceField.sendKeys(discount);
        hideKeyboard();
    }

    public void clickOnSubmitButtonInvoice() {
        submitButton.click();
    }

    public void goToInvoices() {
        hamburgerMenu.click();
        Invoices.click();
    }

    public String getDetailsOfInvoice() {
        return detailsOfInvoice.getAttribute("content-desc");
    }

    public String getTotalInvoicePrice() {
        return TotalInvoicePrice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='عرض جميع المنتجات']")
    MobileElement AllProducts;

    public void clickOnAllProducts() {
        AllProducts.click();
    }
}
