package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddClientScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء']")
    MobileElement clientsOption;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء']")
    MobileElement headerDisplay;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إختيار عميل']")
    MobileElement addClientButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار عميل']")
    MobileElement addClientHeaderDisplay;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bيجب اضافة اسم العميل\u202C']")
    MobileElement popUp;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bيجب اضافة جوال العميل\u202C']")
    MobileElement popUpError;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bهذا العميل موجود بالفعل\u202C']")
    MobileElement popUpClient;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
    MobileElement clientName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement clientPhone;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    MobileElement clientEmail;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    MobileElement taxNumber;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إلغاء']")
    MobileElement cancelButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement applyButton;
    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    MobileElement clientNameInTable;

    public void clickClientsOption() {
        clientsOption.click();
    }

    public boolean isHeaderDisplayed() {
        return headerDisplay.isDisplayed();
    }

    public void clickAddClientButton() {
        addClientButton.click();
    }

    public boolean isAddClientHeaderDisplay() {
        return addClientHeaderDisplay.isDisplayed();
    }

    public boolean isPopUpDisplayed() {
        return popUp.isDisplayed();
    }

    public boolean isPopUpDisplayedAfterAddClient() {
        return popUpError.isDisplayed();
    }

    public boolean isPopUpDisplayedAfterAddSameClient() {
        return popUpClient.isDisplayed();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickApplyButton() {
        applyButton.click();
    }

    public void sendKeysToNameField(String Name) {
        clientName.click();
        clientName.sendKeys(Name);
    }

    public void clearNameField() {
        clientName.click();
        clientName.clear();
    }

    public void sendKeysToPhoneField(String phone) {
        clientPhone.click();
        clientPhone.sendKeys(phone);
    }

    public void clearPhoneField() {
        clientPhone.click();
        clientPhone.clear();
    }

    public void sendKeysToEmailField(String email) {
        clientEmail.click();
        clientEmail.sendKeys(email);
    }

    public void clearEmailField() {
        clientEmail.click();
        clientEmail.clear();
    }

    public void sendKeysToTaxNumberField(String tax) {
        taxNumber.click();
        taxNumber.sendKeys(tax);
    }

    public void clearTaxNumberField() {
        taxNumber.click();
        taxNumber.clear();
    }

    public String getClientName() {
        return clientName.getAttribute("text");
    }

    public String getClientNameFromTable() {
        return clientNameInTable.getAttribute("content-desc");
    }

}
