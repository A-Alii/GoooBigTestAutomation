package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    MobileElement Logo;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إدارة التشغيل']")
    MobileElement RunManage;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='خدمات أخرى']")
    MobileElement AnotherServices;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العمليات اليومية']")
    MobileElement DailyTransactions;
    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    MobileElement HamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement searchBar;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='العملاء']")
    MobileElement Categories;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الفروع']")
    MobileElement WarehousesOption;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement WarehouseName;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement warehouse;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, ')') and contains(@index, '0')]")
    MobileElement WarehouseInHamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    MobileElement cancelIcon;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement UpdateSection;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='8']")
    MobileElement favoriteIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    MobileElement categoriesIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='المزيد']")
    MobileElement moreIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='7']")
    MobileElement homeIcon;

    public boolean isLogoDisplay() {
        return Logo.isDisplayed();
    }

    public void NavigateBack() {
        driver.navigate().back();
    }

    public void clickOnRunManage() {
        RunManage.click();
    }

    public void clickOnAnotherServices() {
        AnotherServices.click();
    }

    public void clickOnDailyTransactions() {
        DailyTransactions.click();
    }

    public void clickOnHamburgerMenu() {
        HamburgerMenu.click();
    }

    public void sendKeysAndPressEnterSearchBar(String search) {
        searchBar.click();
        searchBar.sendKeys(search);
        //searchBar.sendKeys(Keys.ENTER);
    }

    public void clearSearchBar() {
        searchBar.click();
        searchBar.clear();
    }

    public boolean isClientsExist() {
        return Categories.isDisplayed();
    }

    public void NavigateToWarehouses() {
        WarehousesOption.click();
    }

    public String getTextOfWarehouseName() {
        return WarehouseName.getAttribute("content-desc");
    }

    public String getTextOfWarehouseInHomeScreen() {
        return warehouse.getAttribute("content-desc");
    }

    public String getTextOfWarehouseInHamburgerMenu() {
        return WarehouseInHamburgerMenu.getAttribute("content-desc");
    }

    public void clickOnCancelIcon() {
        cancelIcon.click();
    }

    public boolean UpdateSectionIsDisplay() {
        return UpdateSection.isDisplayed();
    }

    public void clickOnFavoriteIcon() {
        favoriteIcon.click();
    }

    public void clickOnCategoriesIcon() {
        categoriesIcon.click();
    }

    public void clickOnMoreIcon() {
        moreIcon.click();
    }

    public void clickOnHomeIcon() {
        homeIcon.click();
    }
}
