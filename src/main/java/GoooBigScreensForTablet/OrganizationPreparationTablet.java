package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrganizationPreparationTablet extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
    MobileElement UserName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement Password;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    MobileElement OrgId;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"تجهيز\"]")
    MobileElement PrepareButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"دخول\"]")
    MobileElement Login;
    @AndroidFindBy(xpath = "//android.view.View[@index='31']")
    MobileElement ProductsNumberShow;

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    MobileElement ErrorDisplay1;

    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement ErrorDisplay2;
    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    MobileElement ErrorDisplay3;

    public boolean isErrorUserNameDisplayed1() {
        return ErrorDisplay1.isDisplayed();
    }

    public boolean isErrorUserNameDisplayed2() {
        return ErrorDisplay2.isDisplayed();
    }

    public boolean isErrorUserNameDisplayed3() {
        return ErrorDisplay3.isDisplayed();
    }

    public boolean isErrorUserNameDisplayed4() {
        return UserName.isDisplayed();
    }

    public void fillPrepareOrg(String Name, String Pass, String Id) {
        UserName.click();
        UserName.sendKeys(Name);
        driver.hideKeyboard();
        Password.click();
        Password.sendKeys(Pass);
        driver.hideKeyboard();
        OrgId.click();
        driver.hideKeyboard();
        OrgId.sendKeys(Id);
        driver.hideKeyboard();
        PrepareButton.click();
    }

    public boolean isProductsNumberDisplay() {
        return ProductsNumberShow.isDisplayed();
    }

    public void clearFields() {
        // Clear data from each field
        UserName.click();
        UserName.clear();
        driver.hideKeyboard();
        Password.click();
        Password.clear();
        driver.hideKeyboard();
        OrgId.click();
        driver.hideKeyboard();
        OrgId.clear();
        driver.hideKeyboard();
    }

    public void clickLoginButton() {
        Login.click();
    }
}
