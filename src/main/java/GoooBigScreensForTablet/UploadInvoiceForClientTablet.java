package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadInvoiceForClientTablet extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.view.View[@index='1' and @content-desc='  الطباعة']")
    MobileElement Printing;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoiceDropDown;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='فاتورة ضريبية']")
    MobileElement TaxInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement SubmitButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='كاش']")
    MobileElement CashButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='التصنيفات']")
    MobileElement Category;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الجوالات']")
    MobileElement PhoneCategory;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Appel']")
    MobileElement Apple;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='2000\n" +
            "ايفون 14 ']")
    MobileElement iPhone;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='عرض جميع المنتجات']")
    MobileElement AllProducts;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='2000.00']")
    MobileElement NavigateNext;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إختيار عميل']")
    MobileElement SelectClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Yousef']")
    MobileElement clientName;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='مديونيات العملاء\n" +
            " ']")
    MobileElement Debits;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='دفع مبلغ']")
    MobileElement PayAmount;
    @AndroidFindBy(xpath = "//android.view.View[@index='5']")
    MobileElement TotalDebitsAmount;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء\n" +
            " ']")
    MobileElement Clients;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار']")
    MobileElement selectButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='27' and @content-desc='Cash نقدي']")
    MobileElement cashButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Credit آجل']")
    MobileElement PostPaidOption;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement PostPaidInvoice;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='رفع البيانات']")
    MobileElement uploadInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بدء الرفع']")
    MobileElement StartUploadInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202B تم الرفع بنجاح\u202C']")
    MobileElement successUpload;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='تحديث البيانات']")
    MobileElement UpdateOption;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء' and @index='8']")
    MobileElement checkClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تحديث' and @index='13']")
    MobileElement updateButton;
    // Tablet Testing
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='اختر الفرع']")
    MobileElement Warehouse;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'مستودع') and contains(@index, '0')]")
    MobileElement SelectFromWarehousesList;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement invoicesScreen;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement InvoiceAmount;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='العملاء']")
    MobileElement ClientsButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement searchClient;

    public void clickOnSettings() {
        settings.click();
    }

    public void clickOnPrinting() {
        Printing.click();
    }

    public void clickOnTaxInvoice() {
        TaxInvoiceDropDown.click();
        TaxInvoice.click();
    }

    public void clickOnSubmitButton() {
        SubmitButton.click();
    }

    public void clickOnCashButton() {
        CashButton.click();
    }

    public void clickOnCategory() {
        Category.click();
        PhoneCategory.click();
    }

    public void clickOnDepartment() {
        Apple.click();
    }

    public void clickOnIphoneProduct() {
        iPhone.click();
    }

    public void clickOnAllProducts() {
        AllProducts.click();
    }

    public void clickOnNext() {
        NavigateNext.click();
    }

    public void clickOnSelectClient() {
        SelectClient.click();
    }

    public void selectClientName() {
        clientName.click();
    }

    public void clickOnDebits() {
        Debits.click();
        PayAmount.click();
    }

    public String getDebitsAmount() {
        return TotalDebitsAmount.getText();
    }

    public void clickOnClients() {
        Clients.click();
    }

    public void clickOnSelectButton() {
        selectButton.click();
    }

    public void clickOnPostPaidOption() {
        cashButton.click();
        PostPaidOption.click();
    }

    public void clickOnPostPaidInvoice() {
        PostPaidInvoice.click();
    }

    public void clickOnUploadInvoice() {
        uploadInvoice.click();
        StartUploadInvoice.click();
    }

    public boolean isSuccessUpload() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // wait for up to 10 seconds
        try {
            wait.until(ExpectedConditions.visibilityOf(successUpload));
            return successUpload.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void updateClients() throws InterruptedException {
        UpdateOption.click();
        Thread.sleep(2000);
        checkClient.click();
        updateButton.click();
    }

    public void selectFromListWarehouse() {
        Warehouse.click();
        SelectFromWarehousesList.click();
    }

    public void clickOnInvoicesScreen() {
        invoicesScreen.click();
    }

    public String getInvoiceAmount() {
        return InvoiceAmount.getAttribute("content-desc");
    }

    public void clickOnClientsButton() {
        ClientsButton.click();
    }

    public void sendKeysToSearchClient(String name) {
        searchClient.click();
        searchClient.sendKeys(name);
        driver.hideKeyboard();
    }

    public void clearSearchClient() {
        searchClient.click();
        searchClient.clear();
    }


}
