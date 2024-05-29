package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OrganizationPreparation extends TestBase {
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

    public void fillPrepareOrg(String Name, String Pass, String Id) {
        UserName.click();
        UserName.sendKeys(Name);
        Password.click();
        Password.sendKeys(Pass);
        OrgId.click();
        OrgId.sendKeys(Id);
        PrepareButton.click();
    }

    public boolean isProductsNumberDisplay() {
        return ProductsNumberShow.isDisplayed();
    }

    public void clearFields() {
        // Clear data from each field
        UserName.click();
        UserName.clear();
        Password.click();
        Password.clear();
        OrgId.click();
        OrgId.clear();
    }

    public void clickLoginButton() {
        Login.click();
    }
}
