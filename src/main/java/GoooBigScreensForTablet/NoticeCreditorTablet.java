package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NoticeCreditorTablet extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إدارة الدوام']")
    MobileElement ManageShift;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement InvoicesTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    MobileElement InvoiceIdNumber;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement TotalInvoicePriceTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إشعار دائن']")
    MobileElement NoticeCreditor;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='قرنفل مسمار ']")
    MobileElement Product;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bلايمكن التعديل على فاتورة سابقة\u202C']")
    MobileElement alert;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إشعار دائن']")
    MobileElement NoticeCreditorButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إضافة']")
    MobileElement AddButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تأكيد الدفع']")
    MobileElement ConfirmButton;

    public void clickOnManageShift() {
        ManageShift.click();
    }

    public void goToInvoicesTablet() {
        InvoicesTablet.click();
    }

    public String getInvoiceIdNumber() {
        return InvoiceIdNumber.getAttribute("content-desc");
    }

    public String getTotalInvoicePriceTablet() {
        return TotalInvoicePriceTablet.getAttribute("content-desc");
    }

    public void clickOnNoticeCreditor() {
        NoticeCreditor.click();
    }

    public void clickOnProduct() {
        Product.click();
    }

    public boolean isAlertDisplayed() {
        return alert.isDisplayed();
    }

    public void clickOnNoticeCreditorButton() {
        NoticeCreditorButton.click();
    }

    public void clickOnAddButton() {
        AddButton.click();
    }

    public void clickOnConfirmButton() {
        ConfirmButton.click();
    }

}
