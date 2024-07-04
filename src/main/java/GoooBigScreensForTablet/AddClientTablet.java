package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddClientTablet extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='العملاء']")
    MobileElement ClientsButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إضافة عميل جديد']")
    MobileElement AddNewClientButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement ClientName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    MobileElement ClientEmail;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
    MobileElement ClientPhone;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='8']")
    MobileElement ClientTax;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement SubmitButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bهذا العميل موجود بالفعل\u202C']")
    MobileElement popUpClient;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إلغاء']")
    MobileElement cancelButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء\n" +
            " ']")
    MobileElement clientHeader;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bاسم العميل مطلوب\u202C']")
    MobileElement popUp;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bرقم الهاتف مطلوب\u202C']")
    MobileElement popUp2;

    public void clickOnClientsButton() {
        ClientsButton.click();
    }

    public void clickOnAddNewClientButton() {
        AddNewClientButton.click();
    }

    public void fillClientName(String name) {
        ClientName.click();
        ClientName.sendKeys(name);
    }

    public String getClientName() {
        return ClientName.getText();
    }

    public void fillClientEmail(String email) {
        ClientEmail.click();
        driver.hideKeyboard();
        ClientEmail.sendKeys(email);
    }

    public void fillClientPhone(String phone) {
        ClientPhone.click();
        driver.hideKeyboard();
        ClientPhone.sendKeys(phone);
    }

    public void scrollToElement(String tax) {
        ClientTax.click();
        driver.hideKeyboard();
        ClientTax.sendKeys(tax);
    }

    public void clickOnSubmitButton() {
        SubmitButton.click();
    }

    public boolean isPopUpDisplayedAfterAddSameClient() {
        return popUpClient.isDisplayed();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public boolean isClientsScreenDisplayed() {
        return clientHeader.isDisplayed();
    }

    public boolean isPopUpDisplayed() {
        return popUp.isDisplayed();
    }

    public boolean isPopUpDisplayedAfterAddClient() {
        return popUp2.isDisplayed();
    }

    public void clearName() {
        ClientName.click();
        ClientName.clear();
    }

    public void clearPhone() {
        ClientPhone.click();
        ClientPhone.clear();
    }

    public void clearEmail() {
        ClientEmail.click();
        ClientEmail.clear();
    }

    public void clearTax() {
        ClientTax.click();
        ClientTax.clear();
    }

}

