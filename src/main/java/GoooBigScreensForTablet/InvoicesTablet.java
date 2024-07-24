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
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'1500\n" +
            "هواوي 23 ')]")
    MobileElement addToCartFirstTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'1000\n" +
            "قرنفل مسمار ')]")
    MobileElement addToCartSecondTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = '1.000']")
    MobileElement EditProductTablet;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
    MobileElement discountFieldTablet;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement discountFieldTablet2;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'اسم الصنف\n" +
            "العدد\n" +
            "السعر\n" +
            "الإجمالى\n" +
            "العدد\n" +
            "2\n" +
            "الكمية\n" +
            "2\n" +
            "الضريبة\n" +
            "313.04\n" +
            "الخصم\n" +
            "100.00\n" +
            "الإجمالى\n" +
            "2400.00')]")
    MobileElement detailsOfInvoiceTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'اسم الصنف\n" +
            "العدد\n" +
            "السعر\n" +
            "الإجمالى\n" +
            "العدد\n" +
            "2\n" +
            "الكمية\n" +
            "2\n" +
            "الضريبة\n" +
            "300.00\n" +
            "الخصم\n" +
            "200.00\n" +
            "الإجمالى\n" +
            "2300.00')]")
    MobileElement detailsOfInvoiceTablet2;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'كاش']")
    MobileElement CashButtonTablet;
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

    public void clickOnProductSecondTablet() {
        addToCartSecondTablet.click();
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
        hideKeyboard();
        discountFieldTablet.clear();
        hideKeyboard();
        discountFieldTablet.sendKeys(discount);
        hideKeyboard();
    }

    public String getDiscountAmountTablet() {
        return discountFieldTablet.getText();
    }

    public String getDetailsOfInvoiceTablet() {
        return detailsOfInvoiceTablet.getAttribute("content-desc");
    }

    public String getDetailsOfInvoiceTablet2() {
        return detailsOfInvoiceTablet2.getAttribute("content-desc");
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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='خصم']")
    MobileElement discountButton;

    public void clickOnDiscountButton() {
        discountButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement discountField;

    public void SendKeysToDiscountField(String discount) {
        discountField.click();
        hideKeyboard();
        discountField.clear();
        hideKeyboard();
        discountField.sendKeys(discount);
        hideKeyboard();
    }
}
