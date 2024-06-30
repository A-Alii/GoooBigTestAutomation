package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

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

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement ErrorDisplay1;

    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement ErrorDisplay2;
    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement ErrorDisplay3;

    public boolean isErrorUserNameDisplayed1() {
        return ErrorDisplay1.isDisplayed();
    }

    public boolean isErrorUserNameDisplayed2() {
        return ErrorDisplay2.isDisplayed();
    }

    public boolean isErrorUserNameDisplayed3() {
        return ErrorDisplay3.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    List<MobileElement> checkRemember;

    public void clearFields() {
        // Clear data from each field
        UserName.click();
        UserName.clear();
        Password.click();
        Password.clear();
    }

    public void fillLoginScreen(String Name, String Pass) {
        UserName.click();
        UserName.sendKeys(Name);
        driver.hideKeyboard();
        Password.click();
        Password.sendKeys(Pass);
        driver.hideKeyboard();
        checkRemember.get(0).click();
        LoginButton.click();
    }
}
