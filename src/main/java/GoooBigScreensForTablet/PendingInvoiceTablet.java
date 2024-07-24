package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PendingInvoiceTablet extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='4000\n" +
            "Galaxy 0999 ']")
    MobileElement product1;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='4500\n" +
            "ايفون 13 iphone 13']")
    MobileElement product2;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='خصم']")
    MobileElement DiscountButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement discount;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement apply;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='اسم الصنف\n" +
            "العدد\n" +
            "السعر\n" +
            "الإجمالى\n" +
            "العدد\n" +
            "2\n" +
            "الكمية\n" +
            "2\n" +
            "الضريبة\n" +
            "1043.48\n" +
            "الخصم\n" +
            "500.00\n" +
            "الإجمالى\n" +
            "8000.00']")
    MobileElement detailsOfInvoiceTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تعليق']")
    MobileElement pendingButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement invoicesScreen;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الفواتير المعلقة\n" +
            " ']")
    MobileElement pendingInvoices;
    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    MobileElement TotalInvoicePriceTablet;

    public void clickProduct1() {
        product1.click();
    }

    public void clickProduct2() {
        product2.click();
    }

    public void clickDiscountButton() {
        DiscountButton.click();
    }

    public void setDiscount(String discount) {
        this.discount.click();
        this.discount.clear();
        this.discount.sendKeys(discount);
        hideKeyboard();
    }

    public void clickApply() {
        apply.click();
    }

    public String getDetailsOfInvoiceTablet() {
        return detailsOfInvoiceTablet.getAttribute("content-desc");
    }

    public void clickPendingButton() {
        pendingButton.click();
    }

    public void clickInvoicesScreen() {
        invoicesScreen.click();
    }

    public void clickPendingInvoices() {
        pendingInvoices.click();
    }

    public String getTotalInvoicePriceTablet() {
        return TotalInvoicePriceTablet.getAttribute("content-desc");
    }


}
