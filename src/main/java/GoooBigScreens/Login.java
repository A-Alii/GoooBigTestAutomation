package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Login extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
    MobileElement UserName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement Password;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تسجيل الدخول']")
    MobileElement LoginButton;

    public String getText() {
        return LoginButton.getAttribute("content-desc");
    }

    public void fillLoginScreen(String Name, String Pass) {
        UserName.click();
        UserName.sendKeys(Name);
        driver.hideKeyboard();
        Password.click();
        Password.sendKeys(Pass);
        driver.hideKeyboard();
        LoginButton.click();
    }

    public void clearFields() {
        // Clear data from each field
        UserName.click();
        UserName.clear();
        Password.click();
        Password.clear();
    }

    public void clickLoginButton() {
        LoginButton.click();
    }
}
