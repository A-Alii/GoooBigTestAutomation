package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class InvoicesTablet extends TestBase {

    // Tablet Testing
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement SettingsTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, '  الطباعة')]")
    MobileElement PrintingTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    List<MobileElement> check1Tablet;
    @AndroidFindBy(xpath = "//android.view.View[@index='4']")
    List<MobileElement> check2Tablet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoiceSelectorTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='فاتورة ضريبية']")
    MobileElement selectTaxInvoiceTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitTablet;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    MobileElement searchbarTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'10000\n" +
            "باقة رمضان ')]")
    MobileElement addToCartFirstTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = '1.000']")
    MobileElement EditProductTablet;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='500.0']")
    MobileElement discountFieldTablet;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement discountFieldTablet2;
    @AndroidFindBy(xpath = "//android.view.View[@index='15' or contains(@content-desc,'اسم الصنف\n" +
            "العدد\n" +
            "السعر\n" +
            "الإجمالى\n" +
            "العدد\n" +
            "1\n" +
            "الكمية\n" +
            "1\n" +
            "الضريبة\n" +
            "1239.13\n" +
            "الخصم\n" +
            "500.00\n" +
            "الإجمالى\n" +
            "9500.00')]")
    MobileElement detailsOfInvoiceTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index = '6']")
    List<MobileElement> CashButtonTablet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement InvoicesTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement TotalInvoicePriceTablet;

    public void NavigateToSettingsTablet() {
        SettingsTablet.click();
        PrintingTablet.click();
    }

    public void checkPrintingSettingsTablet() {
        check1Tablet.get(1).click();
        check2Tablet.get(1).click();
    }

    public void smallNonTaxInvoiceTablet() {
        TaxInvoiceSelectorTablet.click();
        selectTaxInvoiceTablet.click();
    }

    public void clickOnSubmitButtonTablet() {
        submitTablet.click();
    }

    public void sendKeysToSearchProductTablet(String ProductName) {
        searchbarTablet.click();
        searchbarTablet.sendKeys(ProductName);
    }

    public void clickOnProductFirstTablet() {
        addToCartFirstTablet.click();
    }

    public void clearFieldsTablet() {
        searchbarTablet.click();
        searchbarTablet.clear();
        driver.hideKeyboard();
    }

    public void clickOnEditProductTablet() {
        EditProductTablet.click();
    }

    public void sendKeysToDiscountTablet(String discount) {
        discountFieldTablet.click();
        discountFieldTablet.clear();
        discountFieldTablet2.sendKeys(discount);
        driver.hideKeyboard();
    }

    public String getDiscountAmountTablet() {
        return discountFieldTablet.getText();
    }

    public String getDetailsOfInvoiceTablet() {
        return detailsOfInvoiceTablet.getAttribute("content-desc");
    }

    public void clickOnCashButtonTablet() {
        CashButtonTablet.get(1).click();
    }

    public void goToInvoicesTablet() {
        InvoicesTablet.click();
    }

    public String getTotalInvoicePriceTablet() {
        return TotalInvoicePriceTablet.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.view.View[@index='1' and @content-desc='  الطباعة']")
    MobileElement Printing;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoiceDropDown;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement SubmitButton;

    public void clickOnSettings() {
        settings.click();
    }

    public void clickOnPrinting() {
        Printing.click();
    }

    public void clickOnTaxInvoice() {
        TaxInvoiceDropDown.click();
        TaxInvoice.click();
    }

    public void clickOnSubmitButton() {
        SubmitButton.click();
    }

}
