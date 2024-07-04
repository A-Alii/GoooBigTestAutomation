package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Invoices extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='السماح بإعادة الطباعة']")
    MobileElement check2;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement NonTaxORTax;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement SettingsTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة ضريبية']")
    MobileElement NonTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitCheck;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3' and @content-desc='فاتورة صغيرة مبسطة']")
    MobileElement chooseInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة غير ضريبية']")
    MobileElement Tax;
    @AndroidFindBy(xpath = "//android.view.View[@index='3' and @content-desc='فاتورة A4']")
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
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, '  الطباعة')]")
    MobileElement PrintingTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index='4']")
    List<MobileElement> check2Tablet;

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
        NonTaxORTax.click();
        NonTax.click();
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


    // Tablet Testing
    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    List<MobileElement> check1Tablet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoiceSelectorTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='فاتورة ضريبية']")
    MobileElement selectTaxInvoiceTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitTablet;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
    MobileElement searchbarTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'10000\n" +
            "باقة رمضان ')]")
    MobileElement addToCartFirstTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index = '1']")
    List<MobileElement> EditProductTablet;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
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
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إدارة الدوام']")
    MobileElement manageShift;
    @AndroidFindBy(xpath = "//android.view.View[@index='14']")
    MobileElement TotalPayment;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'كاش Cash')]")
    MobileElement cashPayment;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الطباعة المباشرة']")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'الطباعة المباشرة')]")
    private MobileElement directPrintingCheckbox;

    public void smallNonTaxInvoice() throws InterruptedException {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        Thread.sleep(3000);
        checkbox1();
        check2.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }

    public void checkbox1() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(directPrintingCheckbox));
            directPrintingCheckbox.click();
            System.out.println("Successfully clicked on 'الطباعة المباشرة' checkbox");
        } catch (Exception e) {
            System.err.println("Failed to click on 'الطباعة المباشرة' checkbox: " + e.getMessage());
            throw e;
        }
    }

    public void NavigateToSettingsTablet() {
        SettingsTablet.click();
        PrintingTablet.click();
    }

    public void checkPrintingSettingsTablet() {
        check1Tablet.get(2).click();
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
        EditProductTablet.get(1).click();
    }

    public void sendKeysToDiscountTablet(String discount) {
        discountFieldTablet.click();
        discountFieldTablet.clear();
        discountFieldTablet2.click();
        discountFieldTablet2.sendKeys(discount);
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

    public void clickOnManageShift() {
        manageShift.click();
    }

    public String getTotalPayment() {
        return TotalPayment.getAttribute("content-desc");
    }

    public String scroll() {
        MobileElement element;
        // Replace "android.view.View" with your actual class name and "10" with the desired index
        element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                        + "new UiSelector().className(\"android.view.View\").index(15))"));
        // Get the content-desc attribute of the element
        String contentDesc = element.getAttribute("content-desc");

        return contentDesc;
    }

    public String getCahPayment() {
        return cashPayment.getAttribute("content-desc");
    }




}
