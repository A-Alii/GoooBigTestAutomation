package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PriceOffer extends TestBase {

    private AppiumDriver driver;
    public PriceOffer(AppiumDriver driver) {
        this.driver = driver;
    }
    public void hideKeyboard() {
        driver.hideKeyboard();
    }
    public void navigate(){
        driver.navigate().back();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    private MobileElement settings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    private MobileElement printingSettings;
    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    private MobileElement check1;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    private MobileElement check2;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='11']")
    private MobileElement NonTaxORTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة ضريبية']")
    private MobileElement NonTax;
    @AndroidFindBy(xpath = "//android.view.View[@index='14']")
    private MobileElement submitCheck;
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

    public void smallNonTaxInvoicePendingInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }
    public void smallNonTaxInvoiceDisplayPrice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }

    public void smallTaxInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='13']")
    private MobileElement chooseInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement translateSmallNonTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة غير ضريبية']")
    private MobileElement Tax;

    public void SmallTaxInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        NonTaxORTax.click();
        Tax.click();
        submitCheck.click();
    }
    public void TranslateSmallNonTaxInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        translateSmallNonTax.click();
        submitCheck.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement SmallSimplified;
    public void SmallSimplifiedInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        SmallSimplified.click();
        submitCheck.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private MobileElement A4;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private MobileElement A4NonTax;
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

    @AndroidFindBy(xpath = "//android.view.View[@index='4']")
    private MobileElement A4InvoiceWithout;
    public void A4InvoiceWithoutHeader(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        A4InvoiceWithout.click();
        submitCheck.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='5']")
    private MobileElement A4Folded;
    public void A4FoldedInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        A4Folded.click();
        submitCheck.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    private MobileElement SummarizedA4;
    public void SummarizedA4Invoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        SummarizedA4.click();
        submitCheck.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    private MobileElement SummarizedA4InvoiceWithout;
    public void SummarizedA4InvoiceWithoutHeader(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        SummarizedA4InvoiceWithout.click();
        submitCheck.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    private MobileElement DotMatrixPrinter;
    public void DotMatrixPrinterInvoice(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        DotMatrixPrinter.click();
        submitCheck.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='9']")
    private MobileElement DotMatrixPrinterWithout;
    public void DotMatrixPrinterInvoiceWithoutHeader(){
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        chooseInvoice.click();
        DotMatrixPrinterWithout.click();
        submitCheck.click();
    }


    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private MobileElement searchbar;
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
    private MobileElement addToCart;
    public void clickOnProduct(){
        addToCart.click();
    }
    @AndroidFindBy(xpath = "//android.widget.Button[@index = '1']")
    private MobileElement addToCart1;
    public void clickOnProduct1(){
        addToCart1.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    private MobileElement BasketButton ;
    public  void goToCart(){
        BasketButton.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    private MobileElement NextButton;
    public void clickOnNextBasket(){
        NextButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '8']")
    private MobileElement CashButton;
    public void clickOnCashButton(){
        CashButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '6']")
    private MobileElement DisplayPrice;
    public void clickOnDisplayPriceButton(){
        DisplayPrice.click();
    }


    @AndroidFindBy(xpath = "//android.view.View[@index = '2']")
    private MobileElement InvoiceDisplayPrice;
    public void clickOnInvoiceDisplayPrice(){
        InvoiceDisplayPrice.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@index = '1']")
    private MobileElement InvoicePending;
    public void clickOnInvoicePending(){
        InvoicePending.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '0']")
    private MobileElement EditProduct;
    public void clickOnEditProduct(){
        EditProduct.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    private MobileElement discountField;
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
    private MobileElement submitButton;
    public void clickOnSubmitButton(){
        submitButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private MobileElement plusIcon;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='تعليق']")
    private MobileElement Hold;

    public void clickOnHoldInvoice(){
        plusIcon.click();
        Hold.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    private MobileElement Cashier;
    public void clickOnCashier(){
        Cashier.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='4']")
    private MobileElement DiscountButton;
    public void clickOnDiscountButton(){
        DiscountButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    private MobileElement discountInvoiceField;
    public void sendKeysToInvoiceDiscount(String discount){
        discountInvoiceField.click();
        discountInvoiceField.clear();
        discountInvoiceField.sendKeys(discount);
        hideKeyboard();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    private MobileElement InvoiceSubmitButton;
    public void clickOnSubmitButtonInvoice(){
        submitButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    private MobileElement Invoices;
    public void goToInvoices(){
        hamburgerMenu.click();
        Invoices.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]")
    private MobileElement detailsOfInvoice;
    public String getDetailsOfInvoice(){
        return detailsOfInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    private MobileElement TotalInvoicePrice;
    public String getTotalInvoicePrice(){
        return TotalInvoicePrice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    private MobileElement TotalPendingInvoicePrice;
    public String getTotalPendingInvoicePrice(){
        return TotalPendingInvoicePrice.getAttribute("content-desc");
    }


}
