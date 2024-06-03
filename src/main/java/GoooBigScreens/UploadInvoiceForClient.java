package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UploadInvoiceForClient extends TestBase {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'مديونيات العملاء') or @index= '1']")
    MobileElement clickOnClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء']")
    MobileElement clients;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement searchbar;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= '0\n" +
            "السلة\n" +
            "0.00 SR']")
    MobileElement CartEmpty;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='التصنيفات']")
    MobileElement Categories;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement ApplyCategory;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الأقسام']")
    MobileElement Department;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc='لابتوب']")
    MobileElement AppleDepartment;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement ApplyDepartment;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='رفع البيانات']")
    MobileElement uploadInvoiceOption;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='تحديث البيانات']")
    MobileElement UpdateOption;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء']")
    MobileElement checkClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تحديث']")
    MobileElement updateButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bجاري تحديث البيانات\u202C']")
    MobileElement loadingUpdate;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بدء الرفع']")
    MobileElement StartUploadInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202B تم الرفع بنجاح\u202C']")
    MobileElement successUpload;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    @AndroidFindBy(xpath = "//android.view.View[@index='14']")
    MobileElement submitCheck;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    MobileElement addToCart;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
    MobileElement addToCartTwice;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    MobileElement Cart;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إفراغ السلة']")
    MobileElement deleteAllProducts;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إفراغ السلة']")
    MobileElement confirmDeleteAllProducts;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='11']")
    MobileElement NonTaxORTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= 'فاتورة ضريبية']")
    MobileElement NonTax;
    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    MobileElement check1;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement check2;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    MobileElement product1;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc = 'التالي']")
    MobileElement NextButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إشعار دائن']")
    MobileElement NoticeCreditorButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='آجل']")
    MobileElement PostPaidButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,' تأكيد العملية') or contains(@index,'30')]")
    MobileElement Confirmation;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"إختيار عميل\"]")
    MobileElement selectClient;
    @AndroidFindBy(xpath = "//android.view.View[@index= '6' or contains(@content-desc,'abcdefghijklmnopqrstuvwxYyz')]")
    MobileElement clickOnClient1;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'العملاء') and @index='0']")
    MobileElement clickOnClientP;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'مديونيات العملاء') or @index= '2']")
    MobileElement clickOnClientt;
    public UploadInvoiceForClient() {
        // Initialize page factory and WebDriverWait
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='دفع مبلغ']")
    MobileElement Payment;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'إجمالى الرصيد')]")
    MobileElement Amount;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار']")
    MobileElement clickOnSelectionButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement invoices;
    // or contains(@content-desc,'SR')
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement invoiceAmount;

    public void clickOnClientsOption() {
        clients.click();
    }

    public void clickOnUploadInvoice() {
        hamburgerMenu.click();
        uploadInvoiceOption.click();
        StartUploadInvoice.click();
    }

    public void updateClients() {
        UpdateOption.click();
        checkClient.click();
        updateButton.click();
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

    public boolean isLoadingUpdateDisplay() {
        return loadingUpdate.isDisplayed();
    }

    public void clickOnClientFirst() {
        clickOnClient1.click();
    }

    public void clickOnClientPanel() {
        clickOnClientP.click();
    }

    public void clickOnPayment() {
        Payment.click();
    }

    public String getAmount() {
        return Amount.getAttribute("content-desc");
    }

    public void ClickOnCashier() {
        Cashier.click();
    }

    public void sendKeysToSearchProduct(String ProductName) {
        searchbar.click();
        searchbar.sendKeys(ProductName);
    }

    public void clickOnClearSearch() {
        clearFields();
    }

    public void clearFields() {
        searchbar.clear();
    }

    public void clickOnCartEmpty() {
        CartEmpty.click();
    }

    public WebElement scroll() {
        WebElement element;
        element = driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\"كمبيوتر\"))"));
        return element;
    }

    public void clickOnPhoneCategory() {
        Categories.click();
        WebElement element = scroll();
        element.click(); // Click on the scrolled element
        ApplyCategory.click();
    }

    public void clickOnAppleDepartment() {
        Department.click();
        AppleDepartment.click();
        ApplyDepartment.click();
    }

    public void goToCart() {
        Cart.click();
    }

    public void clickOnDeleteAllProducts() {
        deleteAllProducts.click();
        confirmDeleteAllProducts.click();
    }

    public void clickOnInvoices() {
        hamburgerMenu.click();
        invoices.click();
    }

    public String getInvoiceAmount() {
        return invoiceAmount.getAttribute("content-desc");
    }

    public void smallNonTaxInvoice() {
        hamburgerMenu.click();
        settings.click();
        printingSettings.click();
        check1.click();
        check2.click();
        NonTaxORTax.click();
        NonTax.click();
        submitCheck.click();
    }

    public void clickOnProduct1() {
        product1.click();
    }

    public void clickOnNextBasket() {
        NextButton.click();
    }

    public void clickOnSelectClientForInvoice() {
        selectClient.click();
    }

    public void clickOnPostPaidButton() {
        PostPaidButton.click();
    }

    public void clickOnConfirmationButton() {
        Confirmation.click();
    }

    public void selectClientName() {
        clickOnClientt.click();
    }

    public void clickOnSelection() {
        clickOnSelectionButton.click();
    }

    public void clickOnNoticeCreditorButton() {
        NoticeCreditorButton.click();
    }


}
