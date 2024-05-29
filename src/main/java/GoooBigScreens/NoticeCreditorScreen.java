package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NoticeCreditorScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement Invoices;
    public void NavigateToInvoices(){
        hamburgerMenu.click();
        Invoices.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إشعار دائن']")
    MobileElement NoticeCreditorIcon;
    public void clickOnNoticeCreditorIcon(){
        NoticeCreditorIcon.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    MobileElement BasketButton;
    public  void goToCart(){
        BasketButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='حذف']")
    MobileElement RemoveProductIcon;
    public void clickOnRemoveProductIcon(){
        RemoveProductIcon.click();
    }
    public void clickOnEditProductIcon(){
        RemoveProductIcon.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    MobileElement NextButton;
    public void clickOnNextBasket(){
        NextButton.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]")
    MobileElement detailsOfInvoice;
    public String getDetailsOfInvoice(){
        return detailsOfInvoice.getAttribute("content-desc");
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إشعار دائن']")
    MobileElement NoticeCreditorButton;
    public void clickOnNoticeCreditorButton(){
        NoticeCreditorButton.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"إختيار عميل\"]")
    MobileElement selectClient;
    @AndroidFindBy(xpath = "//android.view.View[contains(@index,'5') or contains(@content-desc,'teatnew')]")
    MobileElement clickOnClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار']")
    MobileElement clickOnSelectionButton;
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
    MobileElement AddTotalPrice;
    public void clickOnAddTotalPriceOfInvoice(){
        AddTotalPrice.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='9']")
    MobileElement getPrice;
    public String getPriceAfterAddTotalPrice(){
        return getPrice.getAttribute("text");
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تأكيد الدفع']")
    MobileElement ConfirmPayment;
    public void clickOnConfirmationPaymentButton(){
        ConfirmPayment.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement cashier;
    public void NavigateToCashierProduct(){
        cashier.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إنهاء الدوام']")
    MobileElement EndShift;
    public void NavigateToEndShift(){
        hamburgerMenu.click();
        EndShift.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    MobileElement element;
    public String getElement(){
        return element.getText();
    }
}
