package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class PriceOffer extends TestBase {

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    MobileElement searchbarTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'10000\n" +
            "باقة رمضان ')]")
    MobileElement addToCartFirstTablet;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'2000\n" +
            "ايفون 12 ')]")
    MobileElement addToCartSecondTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = '1.000']")
    List<MobileElement> EditProductTablet;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
    MobileElement discountFieldTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement applyDiscountTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='اسم الصنف\n" +
            "العدد\n" +
            "السعر\n" +
            "الإجمالى\n" +
            "العدد\n" +
            "2\n" +
            "الكمية\n" +
            "2\n" +
            "الضريبة\n" +
            "1500.00\n" +
            "الخصم\n" +
            "500.00\n" +
            "الإجمالى\n" +
            "11500.00']")
    MobileElement detailsOfInvoiceTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='11500.00']")
    MobileElement NextScreen;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='طريقة التوصيل']")
    MobileElement DeliveryMethod;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='هنقرستيشن']")
    MobileElement DeliveryMethod1;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إضافة']")
    MobileElement AddToCart;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='عرض سعر']")
    MobileElement PriceOfferButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement invoicesScreen;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='عروض الأسعار\n" +
            " ']")
    MobileElement pendingInvoices;
    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    MobileElement TotalInvoicePriceTablet;

    public void sendKeysToSearchProductTablet(String ProductName) {
        searchbarTablet.click();
        searchbarTablet.sendKeys(ProductName);
    }

    public void clearSearchProductTablet() {
        searchbarTablet.click();
        searchbarTablet.clear();
        hideKeyboard();
    }

    public void clickOnProductFirstTablet() {
        addToCartFirstTablet.click();
    }

    public void clickOnProductSecondTablet() {
        addToCartSecondTablet.click();
    }

    public void clickOnEditProductTablet() {
        EditProductTablet.get(1).click();
    }

    public void sendKeysToDiscountTablet(String discount) {
        discountFieldTablet.click();
        hideKeyboard();
        discountFieldTablet.clear();
        hideKeyboard();
        discountFieldTablet.sendKeys(discount);
        hideKeyboard();
        applyDiscountTablet.click();
    }

    public String getDetailsOfInvoiceTablet() {
        return detailsOfInvoiceTablet.getAttribute("content-desc");
    }

    public void clickOnNextScreen() {
        NextScreen.click();
    }

    public void clickOnDeliveryMethod() {
        DeliveryMethod.click();
        DeliveryMethod1.click();
    }

    public void clickOnAddToCart() {
        AddToCart.click();
    }

    public void clickOnPriceOfferButton() {
        PriceOfferButton.click();
    }

    public void clickInvoicesScreen() {
        invoicesScreen.click();
    }

    public void clickPriceOfferInvoices() {
        pendingInvoices.click();
    }

    public String getTotalInvoicePriceTablet() {
        return TotalInvoicePriceTablet.getAttribute("content-desc");
    }
}
