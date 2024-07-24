package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class addFirstProductWithAdditionTablet extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='4000\n" +
            "Galaxy 0999 ']")
    MobileElement product;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Galaxy 0999 ']")
    MobileElement productNameFirst;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Galaxy 0999 ']")
    List<MobileElement> productName;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='وسط ']")
    MobileElement addition;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='حفظ التغييرات']")
    MobileElement saveChanges;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='اسم الصنف\n" +
            "العدد\n" +
            "السعر\n" +
            "الإجمالى\n" +
            "العدد\n" +
            "2\n" +
            "الكمية\n" +
            "2\n" +
            "الضريبة\n" +
            "521.87\n" +
            "الخصم\n" +
            "0.00\n" +
            "الإجمالى\n" +
            "4001.00']")
    MobileElement detailsOfInvoiceTablet;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='اسم الصنف\n" +
            "العدد\n" +
            "السعر\n" +
            "الإجمالى\n" +
            "العدد\n" +
            "2\n" +
            "الكمية\n" +
            "3\n" +
            "الضريبة\n" +
            "1043.61\n" +
            "الخصم\n" +
            "0.00\n" +
            "الإجمالى\n" +
            "8001.00']")
    MobileElement detailsOfInvoiceTablet2;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='اسم الصنف\n" +
            "العدد\n" +
            "السعر\n" +
            "الإجمالى\n" +
            "العدد\n" +
            "2\n" +
            "الكمية\n" +
            "2\n" +
            "الضريبة\n" +
            "521.87\n" +
            "الخصم\n" +
            "0.00\n" +
            "الإجمالى\n" +
            "4001.00']")
    MobileElement detailsOfInvoiceTablet3;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='كاش']")
    MobileElement cashInvoice;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement InvoicesTablet;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement TotalInvoicePriceTablet;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    MobileElement reprint;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    List<MobileElement> delete;

    public void clickProduct() {
        product.click();
    }

    public void clickProductName() {
        productNameFirst.click();
    }

    public void clickProductName1() {
        productName.get(0).click();
    }

    public void clickProductName2() {
        productName.get(1).click();
    }

    public void clickAddition() {
        addition.click();
    }

    public void clickSaveChanges() {
        saveChanges.click();
    }

    public String getDetailsOfInvoiceTablet() {
        return detailsOfInvoiceTablet.getAttribute("content-desc");
    }

    public String getDetailsOfInvoiceTablet2() {
        return detailsOfInvoiceTablet2.getAttribute("content-desc");
    }

    public String getDetailsOfInvoiceTablet3() {
        return detailsOfInvoiceTablet3.getAttribute("content-desc");
    }

    public void clickOnCashButton() {
        cashInvoice.click();
    }

    public void goToInvoicesTablet() {
        InvoicesTablet.click();
    }

    public String getTotalInvoicePriceTablet() {
        return TotalInvoicePriceTablet.getAttribute("content-desc");
    }

    public void clickOnReprint() {
        reprint.click();
    }

    public void deleteAddition() {
        delete.get(3).click();
    }

    public void deleteProduct() {
        delete.get(2).click();
    }

}
