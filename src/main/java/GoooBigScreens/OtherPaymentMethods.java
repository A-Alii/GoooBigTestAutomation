package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class OtherPaymentMethods extends TestBase {

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
    @AndroidFindBy(xpath = "//android.view.View[@index = '9']")
    MobileElement otherPaymentMethodButton;
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
    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    MobileElement product1;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
    MobileElement productAgain;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= '\u202Bيجب أن يكون المجموع يساوى مبلغ الفاتورة\u202C']")
    MobileElement popUp;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إضافة']")
    MobileElement addPaymentMethod;
    @AndroidFindBy(xpath = "//android.view.View[@index = '21']")
    MobileElement deliveryTime;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='OK']")
    MobileElement Ok;
    @AndroidFindBy(xpath = "//android.view.View[@index='21' or contains(@content-desc,'M')]")
    MobileElement dateAfter;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='23']")
    MobileElement employeeName;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement selectEmployee;
    @AndroidFindBy(xpath = "//android.view.View[@index='25']")
    MobileElement TaxNumber;
    @AndroidFindBy(xpath = "//android.view.View[@index='33']")
    MobileElement InvoiceTotal;
    @AndroidFindBy(xpath = "//android.view.View[@index='31']")
    MobileElement Discount;

    public OtherPaymentMethods() {
        // Initialize page factory and WebDriverWait
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickOnFirstElement() {
        product1.click();
    }

    public void clickOnFirstElementAgain() {
        productAgain.click();
    }

    public void smallNonTaxInvoice() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        check1.click();
        check2.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@index= '6']")
    MobileElement Amount;


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

    public void clickOnOtherPaymentMethodButton() {
        otherPaymentMethodButton.click();
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

    public WebElement scroll() {
        WebElement element;
        element = driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\"تأكيد العملية\"))"));
        return element;
    }

    public void clickOnConfirmTransaction() {
        WebElement element = scroll();
        element.click(); // Click on the scrolled element
    }

    public boolean isPopUpPresent() {
        return popUp.isDisplayed();
    }
    @AndroidFindBy(xpath = "//android.view.View[@index= '3']")
    MobileElement ResidualAmount;
    public String getAmount() {
        return Amount.getAttribute("content-desc");
    }
    @AndroidFindBy(xpath = "//android.view.View[@index= '0']")
    MobileElement SurplusAmount;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index= '15']")
    MobileElement InvoiceTotalAmountInPaymentScreen;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index= '14']")
    MobileElement PaymentMethod;
    @AndroidFindBy(xpath = "//android.view.View[@index= '2']")
    MobileElement PaymentMethod1;

    public void smallNonTaxInvoiceForOtherPaymentMethod() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        check1.click();
        check2.click();
        NonTaxORTax.click();
        NonTax.click();
        chooseInvoice.click();
        A4.click();
        submitCheck.click();
    }

    public String getResidualAmount() {
        return ResidualAmount.getAttribute("content-desc");
    }

    public String getSurplusAmount() {
        return SurplusAmount.getAttribute("content-desc");
    }

    public String getInvoiceTotalAmountInPaymentScreen() {
        return InvoiceTotalAmountInPaymentScreen.getAttribute("text");
    }

    public void sendKeysToInvoiceTotalAmountInPaymentScreen(String amount) {
        InvoiceTotalAmountInPaymentScreen.click();
        InvoiceTotalAmountInPaymentScreen.clear();
        InvoiceTotalAmountInPaymentScreen.sendKeys(amount);
        hideKeyboard();
    }

    public void clickOnPaymentMethod() {
        PaymentMethod.click();
    }

    public void clickOnPaymentMethod1() {
        PaymentMethod1.click();
    }

    public void clickOnAddPaymentMethod() {
        addPaymentMethod.click();
    }

    public void clickOnDeliveryTime() {
        deliveryTime.click();
    }

    public void clickOnOk() {
        Ok.click();
    }

    public void clickOnOkAgain() {
        Ok.click();
    }

    public String getInvoiceDate() {
        return dateAfter.getAttribute("content-desc");
    }

    public void clickOnEmployeeName() {
        employeeName.click();
        selectEmployee.click();
    }

    public String getEmployeeName() {
        return employeeName.getAttribute("content-desc");
    }

    public String getTaxNumber() {
        return TaxNumber.getAttribute("content-desc");
    }

    public String getInvoiceTotal() {
        return InvoiceTotal.getAttribute("content-desc");
    }

    public String getDiscountNumber() {
        return Discount.getAttribute("content-desc");
    }


}


