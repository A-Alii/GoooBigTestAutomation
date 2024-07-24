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

    public void clickOnPayAmount() {
        PayAmount.click();
    }
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

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
    MobileElement Allow;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']")
    MobileElement Allow2;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Print to PDF']")
    MobileElement PrintToPdf2;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement RemainingAmountOfPaymentScreen2;

    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement RemainingAmountOfPaymentScreen3;

    public String getRemainingAmountOfPaymentScreen3() {
        return RemainingAmountOfPaymentScreen3.getText();
    }
    public void clickOnPrinting() {
        Printing.click();
    }

    public void clickOnTaxInvoice() {
        TaxInvoiceDropDown.click();
        TaxInvoice.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إدارة الدوام']")
    MobileElement manageShift;

    public void clickOnAllow() {
        Allow.click();
    }

    public void clickOnAllow2() {
        Allow2.click();
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

    public void clickOnPrintToPdf() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        // Scroll to the element
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".scrollIntoView(new UiSelector().description(\"Print to PDF\").instance(0));");

        // Locate the element
        MobileElement PrintToPdf = (MobileElement) driver.findElementByXPath("//android.widget.ImageView[@content-desc='Print to PDF']");

        // Wait until the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(PrintToPdf));

        // Click the element
        PrintToPdf.click();
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

    // Pay Amount For Client
    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    MobileElement clientNameInPaymentScreen;

    public String getClientNameInPaymentScreen() {
        return clientNameInPaymentScreen.getText();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='5']")
    MobileElement TotalAmountOfPaymentScreen;

    public String getTotalAmountOfPaymentScreen() {
        return TotalAmountOfPaymentScreen.getText();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement RemainingAmountOfPaymentScreen;

    public String getRemainingAmountOfPaymentScreen() {
        return RemainingAmountOfPaymentScreen.getText();
    }

    public void clickOnPrintToPdf2() {
        PrintToPdf2.click();
    }

    public String getRemainingAmountOfPaymentScreen2() {
        return RemainingAmountOfPaymentScreen2.getText();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='11']")
    MobileElement PayAmountForClient;

    public void sendKeysToPayAmountForClient(String payAmount) {
        PayAmountForClient.click();
        driver.hideKeyboard();
        PayAmountForClient.sendKeys(payAmount);
        driver.hideKeyboard();
    }

    public String getPayAmountForClient() {
        return PayAmountForClient.getText();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='16']")
    MobileElement DetailsField;

    public void sendKeysToDetailsField(String details) {
        DetailsField.click();
        driver.hideKeyboard();
        DetailsField.sendKeys(details);
        driver.hideKeyboard();
    }

    public String getDetailsField() {
        return DetailsField.getText();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إعادة حساب']")
    MobileElement ResetButtonForPayment;

    public void clickOnResetButtonForPayment() {
        ResetButtonForPayment.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement SubmitButtonForPayment;

    public void clickOnSubmitButtonForPayment() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        // Scroll to the element
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".scrollIntoView(new UiSelector().description(\"تنفيذ\").instance(0));");

        // Locate the element
        MobileElement submitButtonForPayment = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc='تنفيذ']");

        // Wait until the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonForPayment));

        // Click the element
        submitButtonForPayment.click();
    }

    public boolean isSuccessUpload() {
        WebDriverWait wait = new WebDriverWait(driver, 20); // wait for up to 10 seconds
        try {
            wait.until(ExpectedConditions.visibilityOf(successUpload));
            return successUpload.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnManageShift() {
        manageShift.click();
    }


}
