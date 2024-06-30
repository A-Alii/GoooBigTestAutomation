package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NoticeCreditorScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement Invoices;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إشعار دائن']")
    MobileElement NoticeCreditorIcon;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    MobileElement BasketButton;

    public boolean isBasketButtonVisible() {
        return BasketButton.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='حذف']")
    MobileElement RemoveProductIcon;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    MobileElement NextButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'ختيار عميل') or contains(@content-desc,'SR')]")
    MobileElement detailsOfInvoice;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إشعار دائن']")
    MobileElement NoticeCreditorButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"إختيار عميل\"]")
    MobileElement selectClient;
    @AndroidFindBy(xpath = "//android.view.View[contains(@index,'5') or contains(@content-desc,'teatnew')]")
    MobileElement clickOnClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار']")
    MobileElement clickOnSelectionButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إضافة']")
    MobileElement AddTotalPrice;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='9']")
    MobileElement getPrice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تأكيد الدفع']")
    MobileElement ConfirmPayment;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement cashier;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إنهاء الدوام']")
    MobileElement EndShift;
    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    MobileElement element;

    public void NavigateToInvoices() {
        hamburgerMenu.click();
        Invoices.click();
    }

    public void clickOnNoticeCreditorIcon() {
        NoticeCreditorIcon.click();
        driver.hideKeyboard();
    }

    public void goToCart() {
        BasketButton.click();
    }

    public void clickOnRemoveProductIcon() {
        RemoveProductIcon.click();
    }

    public void clickOnEditProductIcon() {
        RemoveProductIcon.click();
    }

    public void clickOnNextBasket() {
        NextButton.click();
    }

    public String getDetailsOfInvoice() {
        return detailsOfInvoice.getAttribute("content-desc");
    }

    public void clickOnNoticeCreditorButton() {
        NoticeCreditorButton.click();
    }

    public void clickOnSelectClientForInvoice() {
        selectClient.click();
    }

    public void selectClientName() {
        clickOnClient.click();
    }

    public void clickOnSelection() {
        clickOnSelectionButton.click();
    }

    public void clickOnAddTotalPriceOfInvoice() {
        AddTotalPrice.click();
    }

    public String getPriceAfterAddTotalPrice() {
        return getPrice.getAttribute("text");
    }

    public void clickOnConfirmationPaymentButton() {
        ConfirmPayment.click();
    }

    public void NavigateToCashierProduct() {
        cashier.click();
    }

    public void NavigateToEndShift() {
        hamburgerMenu.click();
        EndShift.click();
    }

    public String getElement() {
        return element.getText();
    }
}
