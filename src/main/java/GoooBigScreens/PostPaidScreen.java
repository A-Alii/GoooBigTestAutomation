package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PostPaidScreen extends TestBase {
    private AppiumDriver driver;
    public PostPaidScreen(AppiumDriver driver) {
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
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    private MobileElement Invoices;
    public void NavigateToInvoices(){
        hamburgerMenu.click();
        Invoices.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    private MobileElement BasketButton;
    public  void goToCart(){
        BasketButton.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    private MobileElement NextButton;
    public void clickOnNextBasket(){
        NextButton.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]")
    private MobileElement detailsOfInvoice;
    public String getDetailsOfInvoice(){
        return detailsOfInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إشعار دائن']")
    private MobileElement NoticeCreditorButton;
    public void clickOnNoticeCreditorButton(){
        NoticeCreditorButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='آجل']")
    private MobileElement PostPaidButton;
    public void clickOnPostPaidButton(){
        PostPaidButton.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,' تأكيد العملية') or contains(@index,'30')]")
    //android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]
    private MobileElement Confirmation;
    public void clickOnConfirmationButton(){
        Confirmation.click();
    }
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
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }

    public void smallNonTaxInvoicePostPaid(){
        hamburgerMenu.click();
        settings.click();
        check1.click();
        check2.click();
        printingSettings.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"إختيار عميل\"]")
    private MobileElement selectClient;
    @AndroidFindBy(xpath = "//android.view.View[contains(@index,'5') or contains(@content-desc,'teatnew')]")
    private MobileElement clickOnClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار']")
    private MobileElement clickOnSelectionButton;
    public void clickOnSelectClientForInvoice(){
        selectClient.click();
    }
    public void selectClientName(){
        clickOnClient.click();
    }
    public void clickOnSelection(){
        clickOnSelectionButton.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    private MobileElement cashier;
    public void NavigateToCashierProduct(){
        cashier.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,' 10') or contains(@index,'0')]")
    private MobileElement product1;
    //contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='اضف الى السلة']")
    private MobileElement addProduct;
    public void selectFirstProduct(){
        product1.click();
        addProduct.click();
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


    @AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
    private MobileElement addAnotherProduct;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private MobileElement minusAnotherProduct;
    public void selectFirstProductAgain(){
        addAnotherProduct.click();
    }
    public WebElement scrollProduct2() {
        WebElement element = driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\"باقة رمضان\"))"));
        return element;
    }
    public void selectSecondProduct(){
        WebElement element = scrollProduct2();
        element.click();
        addProduct.click();
    }
    public void selectSecondProductAgain(){
        addAnotherProduct.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'شاورما لحم') or contains(@content-desc,'15')]")
    private MobileElement product2;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index = '0']")
    private MobileElement EditProduct;
    public void clickOnEditProduct(){
        EditProduct.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    private MobileElement discountField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    private MobileElement submitButton;
    public void sendKeysToDiscount(String discount){
        discountField.click();
        discountField.clear();
        discountField.sendKeys(discount);
        hideKeyboard();
        submitButton.click();
    }
}
