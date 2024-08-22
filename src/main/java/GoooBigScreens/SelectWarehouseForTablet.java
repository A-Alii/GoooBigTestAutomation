package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectWarehouseForTablet extends TestBase {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='اختر الفرع']")
    MobileElement selectWarehouse;

    /*MobileElement selectWarehouseFromList
            = driver.findElement(
                    MobileBy.xpath(
                            "//android.view.View[contains(@content-desc, 'تجريبي') and contains(@index, '0')]"));
*/


    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'تجريبي') and contains(@index, '0')]")
    MobileElement selectWarehouseFromList;
    @AndroidFindBy(xpath = "//android.view.View[@index='0' and contains(@content-desc, '0')]")
    MobileElement selectProduct;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بداية دوام']")
    MobileElement startOfTheShift;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    MobileElement BoxFund;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement delivery;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement Name2;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بدء الدوام']")
    MobileElement ApplyButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='كاش']")
    MobileElement cashInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تعليق']")
    MobileElement pendingInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bمن فضلك اختر طابعة\u202C']")
    MobileElement processComplete;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='رفع البيانات']")
    MobileElement UploadButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='بدء الرفع']")
    MobileElement StartUploadInvoice;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202B تم الرفع بنجاح\u202C']")
    MobileElement UploadSuccess;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bتم بنجاح\u202C']")
    MobileElement DoneSuccessfully;

    public void clickOnSelectWarehouse() {
        selectWarehouse.click();
    }

    public void clickOnSelectWarehouseFromList() {
        selectWarehouseFromList.click();
    }

    public void selectProduct() {
        selectProduct.click();
    }

    public void clickOnStartOfTheShift() {
        startOfTheShift.click();
    }

    public void sendKeysToBoxFund(String box) {
        BoxFund.click();
        BoxFund.sendKeys(box);
    }

    public void clickOnDeliveryFirst() {
        delivery.click();
        Name2.click();
    }

    public void ClickOnApplyButton() {
        ApplyButton.click();
    }

    public void clickOnCashInvoice() {
        cashInvoice.click();
    }

    public void clickOnPendingInvoice() {
        pendingInvoice.click();
    }

    public boolean processComplete() {
        WebDriverWait wait = new WebDriverWait(driver, 5); // wait for up to 5 seconds
        try {
            wait.until(ExpectedConditions.visibilityOf(processComplete));
            return processComplete.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean DonePendingInvoiceComplete() {
        WebDriverWait wait = new WebDriverWait(driver, 5); // wait for up to 5 seconds
        try {
            wait.until(ExpectedConditions.visibilityOf(DoneSuccessfully));
            return DoneSuccessfully.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnUploadButton() {
        UploadButton.click();
    }

    public void clickOnStartUploadInvoice() {
        StartUploadInvoice.click();
    }

    public boolean UploadSuccessIsDisplayed() {
        FluentWait<AndroidDriver<MobileElement>> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(500000000)) // Maximum wait time of 10 seconds
                .pollingEvery(Duration.ofSeconds(2)) // Check for element every 2 seconds
                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException
        try {
            wait.until(ExpectedConditions.visibilityOf(UploadSuccess));
            return UploadSuccess.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


}
