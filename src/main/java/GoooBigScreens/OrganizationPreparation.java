package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPreparation extends TestBase {
    @AndroidFindBy (xpath = "//android.widget.EditText[@index='0']")
    private MobileElement UserName;
    @AndroidFindBy (xpath = "//android.widget.EditText[@index='1']")
    private MobileElement Password;
    @AndroidFindBy (xpath = "//android.widget.EditText[@index='2']")
    private MobileElement OrgId;
    @AndroidFindBy (xpath = "//android.view.View[@content-desc=\"تجهيز\"]")
    private MobileElement PrepareButton;

    @AndroidFindBy (xpath = "//android.widget.ImageView[@content-desc=\"دخول\"]")
    private MobileElement Login;

    @AndroidFindBy (xpath = "//android.view.View[@index='31']")
    private  MobileElement ProductsNumberShow;

    @AndroidFindBy (xpath = "//android.view.View[@index='0']")
    private MobileElement ErrorDisplay1;

    @AndroidFindBy (xpath = "//android.view.View[@index='1']")
    private MobileElement ErrorDisplay2;
    @AndroidFindBy (xpath = "//android.view.View[@index='0']")
    private MobileElement ErrorDisplay3;

    public void fillPrepareOrg(String Name, String Pass, String Id){
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
    public void clearFields() {
        // Clear data from each field
        UserName.click();
        UserName.clear();
        Password.click();
        Password.clear();
        OrgId.click();
        OrgId.clear();
    }

    public void clickLoginButton(){
        Login.click();
    }



}
