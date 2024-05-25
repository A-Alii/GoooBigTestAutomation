package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BoxOperation extends TestBase {
    private AppiumDriver driver;

    public BoxOperation(AppiumDriver driver) {
        this.driver = driver;
    }
    public void navigateBack() {
        driver.navigate().back();
    }
    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='عمليات الصندوق']")
    private MobileElement boxOperation;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إنهاء الدوام']")
    private MobileElement endShift;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    private MobileElement Invoices;
    public void goToBoxOperation(){
        hamburgerMenu.click();
        boxOperation.click();
    }
    public void goToInvoices(){
        hamburgerMenu.click();
        Invoices.click();
    }
    public void goToEndShift(){
        hamburgerMenu.click();
        endShift.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='عمليات الصندوق']")
    private MobileElement boxOperationVisible;
    public boolean isBoxOperationScreenDisplay(){
        return boxOperationVisible.isDisplayed();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    private MobileElement TransactionType;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement withdraw;
    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement deposit;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private MobileElement amountTransaction;
    public String getAmountQuantity(){
        return amountTransaction.getText();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement employeeName;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement employeesChoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    private MobileElement applyTransaction;
    public void clickOnWithdraw(){
        TransactionType.click();
        withdraw.click();
    }
    public void clickOnDeposit(){
        TransactionType.click();
        deposit.click();
    }
    public void clickOnEmployee(){
        employeeName.click();
        employeesChoice.click();
    }
    public void sendKeysToBoxOperation1(){
        clickOnDeposit();
        applyTransaction.click();
    }
    public void sendKeysToBoxOperation2(String amount){
        clickOnWithdraw();
        amountTransaction.click();
        amountTransaction.sendKeys(amount);
        clickOnEmployee();
        applyTransaction.click();
    }
    public void sendKeysToBoxOperation3(String amount){
        clickOnDeposit();
        amountTransaction.click();
        amountTransaction.clear();
        amountTransaction.sendKeys(amount);
        clickOnEmployee();
        applyTransaction.click();
    }
    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private MobileElement JustOnce;
    public void clickOnJustOnce(){
        JustOnce.click();
    }


    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    private MobileElement withdrawField;
    public String getAmountWithdraw(){
        return withdrawField.getText();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    private MobileElement TotalBox;
    public String getAmountTotalBox(){
        return TotalBox.getText();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إلغاء']")
    private MobileElement cancelButton;

    public void clickOnCancelButton(){
        cancelButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    private MobileElement logoDisplay;
    public boolean logoIsDisplay(){
        return logoDisplay.isDisplayed();
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



}
