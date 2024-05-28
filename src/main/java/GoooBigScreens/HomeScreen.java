package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends TestBase {
    private AppiumDriver driver;
    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }
    public void navigate(){
        driver.navigate().back();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    private MobileElement Logo;
    public boolean isLogoDisplay(){
        return Logo.isDisplayed();
    }

    public void NavigateBack(){
        driver.navigate().back();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إدارة التشغيل']")
    private MobileElement RunManage;
    public void clickOnRunManage(){
        RunManage.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='خدمات أخرى']")
    private MobileElement AnotherServices;
    public void clickOnAnotherServices(){
        AnotherServices.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العمليات اليومية']")
    private MobileElement DailyTransactions;
    public void clickOnDailyTransactions(){
        DailyTransactions.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement HamburgerMenu;
    public void clickOnHamburgerMenu(){
        HamburgerMenu.click();
    }
    /*@AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement Warehouse;

    public String getTextOfElement() {
            return Warehouse.getText();
    }*/
    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement elementWithContentDesc;
    public boolean isWordPresentInContentDesc() {
        String contentDesc = elementWithContentDesc.getAttribute("content-desc");
        return contentDesc.contains("الرياض");
    }

    public void BackForward(){
        driver.navigate().back();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private MobileElement searchBar;
    public void sendKeysAndPressEnterSearchBar(String search){
        searchBar.click();
        searchBar.sendKeys(search);
        //searchBar.sendKeys(Keys.ENTER);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء']")
    private MobileElement Categories;
    public boolean isClientsExist(){
        return Categories.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الفروع']")
    private MobileElement WarehousesOption;
    public void NavigateToWarehouses(){
        WarehousesOption.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement WarehouseName;
    public String getTextOfWarehouseName() {
        return WarehouseName.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private MobileElement warehouse;
    public String getTextOfWarehouseInHomeScreen(){
        return warehouse.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, ')') and contains(@index, '0')]")
    private MobileElement WarehouseInHamburgerMenu;
    public String getTextOfWarehouseInHamburgerMenu(){
        return WarehouseInHamburgerMenu.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    private MobileElement cancelIcon;
    public void clickOnCancelIcon(){
        cancelIcon.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private MobileElement UpdateSection;
    public boolean UpdateSectionIsDisplay(){
        return UpdateSection.isDisplayed();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='8']")
    private MobileElement favoriteIcon;
    public void clickOnFavoriteIcon(){
        favoriteIcon.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    private MobileElement categoriesIcon;
    public void clickOnCategoriesIcon(){
        categoriesIcon.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='المزيد']")
    private MobileElement moreIcon;
    public void clickOnMoreIcon(){
        moreIcon.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='7']")
    private MobileElement homeIcon;
    public void clickOnHomeIcon(){
        homeIcon.click();
    }

}
