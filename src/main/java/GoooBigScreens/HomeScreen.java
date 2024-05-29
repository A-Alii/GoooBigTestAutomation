package GoooBigScreens;
import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    MobileElement Logo;
    public boolean isLogoDisplay(){
        return Logo.isDisplayed();
    }
    public void NavigateBack(){
        driver.navigate().back();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إدارة التشغيل']")
    MobileElement RunManage;
    public void clickOnRunManage(){
        RunManage.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='خدمات أخرى']")
    MobileElement AnotherServices;
    public void clickOnAnotherServices(){
        AnotherServices.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العمليات اليومية']")
    MobileElement DailyTransactions;
    public void clickOnDailyTransactions(){
        DailyTransactions.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement HamburgerMenu;
    public void clickOnHamburgerMenu(){
        HamburgerMenu.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement searchBar;
    public void sendKeysAndPressEnterSearchBar(String search){
        searchBar.click();
        searchBar.sendKeys(search);
        //searchBar.sendKeys(Keys.ENTER);
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء']")
    MobileElement Categories;
    public boolean isClientsExist(){
        return Categories.isDisplayed();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الفروع']")
    MobileElement WarehousesOption;
    public void NavigateToWarehouses(){
        WarehousesOption.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement WarehouseName;
    public String getTextOfWarehouseName() {
        return WarehouseName.getAttribute("content-desc");
    }
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement warehouse;
    public String getTextOfWarehouseInHomeScreen(){
        return warehouse.getAttribute("content-desc");
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, ')') and contains(@index, '0')]")
    MobileElement WarehouseInHamburgerMenu;
    public String getTextOfWarehouseInHamburgerMenu(){
        return WarehouseInHamburgerMenu.getAttribute("content-desc");
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    MobileElement cancelIcon;
    public void clickOnCancelIcon(){
        cancelIcon.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement UpdateSection;
    public boolean UpdateSectionIsDisplay(){
        return UpdateSection.isDisplayed();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='8']")
    MobileElement favoriteIcon;
    public void clickOnFavoriteIcon(){
        favoriteIcon.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement categoriesIcon;
    public void clickOnCategoriesIcon(){
        categoriesIcon.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='المزيد']")
    MobileElement moreIcon;
    public void clickOnMoreIcon(){
        moreIcon.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='7']")
    MobileElement homeIcon;
    public void clickOnHomeIcon(){
        homeIcon.click();
    }
}
