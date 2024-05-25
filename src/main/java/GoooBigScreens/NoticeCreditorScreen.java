package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.aspectj.weaver.ast.Not;

public class NoticeCreditorScreen extends TestBase {

    private AppiumDriver driver;
    public NoticeCreditorScreen(AppiumDriver driver) {
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
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إشعار دائن']")
    private MobileElement NoticeCreditorIcon;
    public void clickOnNoticeCreditorIcon(){
        NoticeCreditorIcon.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    private MobileElement BasketButton;
    public  void goToCart(){
        BasketButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='حذف']")
    private MobileElement RemoveProductIcon;
    public void clickOnRemoveProductIcon(){
        RemoveProductIcon.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='تعديل']")
    private MobileElement EditProductIcon;
    public void clickOnEditProductIcon(){
        RemoveProductIcon.click();
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
    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    private MobileElement InvoiceNumber;
    public String getInvoiceNumber(){
        return InvoiceNumber.getAttribute("content-desc");
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
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إضافة']")
    private MobileElement AddTotalPrice;
    public void clickOnAddTotalPriceOfInvoice(){
        AddTotalPrice.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='9']")
    private MobileElement getPrice;
    public String getPriceAfterAddTotalPrice(){
        return getPrice.getAttribute("text");
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تأكيد الدفع']")
    private MobileElement ConfirmPayment;
    public void clickOnConfirmationPaymentButton(){
        ConfirmPayment.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    private MobileElement cashier;
    public void NavigateToCashierProduct(){
        cashier.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إنهاء الدوام']")
    private MobileElement EndShift;
    public void NavigateToEndShift(){
        hamburgerMenu.click();
        EndShift.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement element;
    public String getElement(){
        return element.getText();
    }
}
