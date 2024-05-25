package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddClientScreen extends TestBase {

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
        addClientButton.click();
    }


}
