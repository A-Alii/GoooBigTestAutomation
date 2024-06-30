package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BoxOperation extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='عمليات الصندوق']")
    MobileElement boxOperation;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إنهاء الدوام']")
    MobileElement endShift;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement Invoices;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='عمليات الصندوق']")
    MobileElement boxOperationVisible;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    MobileElement TransactionType;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement withdraw;
    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    MobileElement deposit;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement amountTransaction;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement employeeName;
    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    MobileElement employeesChoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement applyTransaction;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement TotalBox;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إلغاء']")
    MobileElement cancelButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    MobileElement logoDisplay;
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
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '8']")
    MobileElement CashButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '0']")
    MobileElement EditProduct;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    MobileElement discountField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement submitButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='4']")
    MobileElement DiscountButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement discountInvoiceField;

    public void goToBoxOperation() {
        hamburgerMenu.click();
        boxOperation.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    public void goToInvoices() {
        hamburgerMenu.click();
        Invoices.click();
    }

    public void goToEndShift() {
        hamburgerMenu.click();
        endShift.click();
    }

    public void isBoxOperationScreenDisplay() {
        boxOperationVisible.isDisplayed();
    }

    public void clickOnWithdraw() {
        TransactionType.click();
        withdraw.click();
    }

    public void clickOnDeposit() {
        TransactionType.click();
        deposit.click();
    }

    public void clickOnEmployee() {
        employeeName.click();
        employeesChoice.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;

    public void setSubmitButton() {
        submitButton.click();
    }

    public void selectDepositTransactionType() {
        clickOnDeposit();
    }


    public String getAmountTotalBox() {
        return TotalBox.getText();
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }

    public boolean logoIsDisplay() {
        return logoDisplay.isDisplayed();
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

    public void selectWithdrawTransactionType() {
        clickOnWithdraw();
    }

    public void clickApplyTransaction() {
        applyTransaction.click();
    }

    public void sendKeysToBoxOperation2(String amount) {
        amountTransaction.click();
        amountTransaction.sendKeys(amount);
    }

    public void CheckPrinting() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
    }

    public void navigateToCashier() {
        Cashier.click();
    }


}
