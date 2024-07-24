package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrganizationPreparationTablet extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
    MobileElement UserName;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement Password;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    MobileElement OrgId;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"تجهيز\"]")
    MobileElement PrepareButton;

    public void clickOnPrepareButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        // Scroll to the element
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".scrollIntoView(new UiSelector().description(\"تجهيز\").instance(0));");

        // Locate the element
        MobileElement PrepareButton = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"تجهيز\"]");

        // Wait until the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(PrepareButton));

        // Click the element
        PrepareButton.click();
    }

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
        hideKeyboard();
        UserName.sendKeys(Name);
        driver.hideKeyboard();
        Password.click();
        hideKeyboard();
        Password.sendKeys(Pass);
        driver.hideKeyboard();
        OrgId.click();
        driver.hideKeyboard();
        OrgId.sendKeys(Id);
        driver.hideKeyboard();
        clickOnPrepareButton();
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(Login));
        Login.click();
    }
}
