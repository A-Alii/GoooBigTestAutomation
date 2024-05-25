package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PasketScreen extends TestBase {
    private AppiumDriver driver;
    public PasketScreen(AppiumDriver driver) {
        this.driver = driver;
    }
    public void hideKeyboard() {
        driver.hideKeyboard();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    private MobileElement editIcon;
    public void clickOnEditIcon(){
        editIcon.click();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    private MobileElement discountField;
    public void sendKeysToDiscount(String discount){
        discountField.click();
        discountField.clear();
        discountField.sendKeys(discount);
        hideKeyboard();
    }
    public String getDiscountAmount(){
        return discountField.getText();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    private MobileElement submitButton;
    public void clickOnSubmitButton(){
        submitButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private MobileElement plusIcon;
    public void clickOnPlusIcon(){
        plusIcon.click();
        plusIcon.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='التالي']")
    private MobileElement nextButton;
    public void clickOnNextButton(){
        nextButton.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@NAF='true']")
    private MobileElement selectClient;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='5']")
    private MobileElement addNewClient;
    public void clickOnAddClientButton(){
        selectClient.click();
    }

    public void addClient(){
        addNewClient.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء']")
    private MobileElement clientOption;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='مديونيات العملاء']")
    private MobileElement clientPostOption;
    public void clickOnClientsOptions(){
        clientOption.click();
    }
    public void clickOnClientsPostOptions(){
        clientPostOption.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='دفع مبلغ']")
    private MobileElement amountPay;
    public boolean amountPayIsVisible(){
        return amountPay.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    private MobileElement invoices;
    public boolean invoicesIsVisible(){
        return invoices.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private MobileElement searchbar;
    public void sendKeysToSearchBar(String search){
        searchbar.click();
        searchbar.sendKeys(search);
        hideKeyboard();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار عميل']")
    private MobileElement clientNavbar;
    public boolean getNavbarText(){
        return clientName.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement cancelButton;
    public void clickOnCancelButton(){
        cancelButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[index='0']")
    private MobileElement clientName;
    @AndroidFindBy(xpath = "//android.widget.EditText[index='1']")
    private MobileElement clientPhone;
    @AndroidFindBy(xpath = "//android.widget.EditText[index='2']")
    private MobileElement clientEmail;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement addClientButton;

    public void sendKeysToFields(String Name, String Phone, String Email){
        clientName.click();
        clientName.sendKeys(Name);
        clientPhone.click();
        clientPhone.sendKeys(Phone);
        clientEmail.click();
        clientEmail.sendKeys();
        hideKeyboard();
        addClientButton.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إختيار']")
    private MobileElement selectButton;
    public void clickOnSelectClient(){
        selectButton.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='كاش']")
    private MobileElement cashInvoice;
    public void clickOnCashInvoice(){
        cashInvoice.click();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    /*@AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private MobileElement justOnce;
    public void clickOnJustOnInvoice(){
        justOnce.click();
    }*/

    public void afterNavigate(){
        searchbar.clear();
        hideKeyboard();
    }



}
