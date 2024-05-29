package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddClientScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.EditText[index='0']")
    MobileElement clientName;
    @AndroidFindBy(xpath = "//android.widget.EditText[index='1']")
    MobileElement clientPhone;
    @AndroidFindBy(xpath = "//android.widget.EditText[index='2']")
    MobileElement clientEmail;
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement addClientButton;
    public void sendKeysToFields(String Name, String Phone, String Email){
        clientName.click();
        clientName.sendKeys(Name);
        clientPhone.click();
        clientPhone.sendKeys(Phone);
        clientEmail.click();
        clientEmail.sendKeys(Email);
        addClientButton.click();
    }
    public boolean getNavbarText(){
        return clientName.isDisplayed();
    }
}
