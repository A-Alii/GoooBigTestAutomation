package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CashierScreen extends TestBase{
    private AppiumDriver driver;

    public CashierScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    private MobileElement Cashier;
    public void ClickOnCashier(){
        Cashier.click();
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private MobileElement searchbar;
    public void sendKeysToSearchProduct(String ProductName){
        searchbar.click();
        searchbar.sendKeys(ProductName);
    }
    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement clearSearch;
    public void clickOnClearSearch(){
        clearFields();
    }
    public void clearFields() {
        searchbar.clear();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= '0\n" +
            "السلة\n" +
            "0.00 SR']")
    private MobileElement CartEmpty;
    public void clickOnCartEmpty(){
        CartEmpty.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='التصنيفات']")
    private MobileElement Categories;


    public WebElement scroll() {
        WebElement element = driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\"كمبيوتر\"))"));
        return element;
    }

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc='الجوالات']")
    private MobileElement PhonesCategory;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private MobileElement ApplyCategory;
    public void clickOnPhoneCategory(){
        Categories.click();
        WebElement element = scroll();
        element.click(); // Click on the scrolled element
        ApplyCategory.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الأقسام']")
    private MobileElement Department;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc='لابتوب']")
    private MobileElement AppleDepartment;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private MobileElement ApplyDepartment;
    public void clickOnAppleDepartment(){
        Department.click();
        AppleDepartment.click();
        ApplyDepartment.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='عرض جميع المنتجات']")
    private MobileElement allProducts;
    public void clickOnShowAllProducts(){
        allProducts.click();
    }
    public void navigateBack() {
        driver.navigate().back();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement hamburgerMenu;
    public void clickOnHamburger(){
        hamburgerMenu.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    private MobileElement settings;
    public void clickOnSettings(){
        settings.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    private MobileElement check1;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    private MobileElement check2;
    @AndroidFindBy(xpath = "//android.view.View[@index='14']")
    private MobileElement submitCheck;
    public void clickOnCheckPrinting(){
        check1.click();
        check2.click();
        submitCheck.click();
    }


    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    private MobileElement printingSettings;
    public void clickOnPrintingSettings(){
        printingSettings.click();
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    private MobileElement addToCart;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
    private MobileElement addToCartTwice;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    private MobileElement Cart;
    public void AddToCart(){
        addToCart.click();
        addToCartTwice.click();
        hideKeyboard();
    }
    public  void goToCart(){
        Cart.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إفراغ السلة']")
    private MobileElement deleteAllProducts;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إفراغ السلة']")
    private MobileElement confirmDeleteAllProducts;
    public void clickOnDeleteAllProducts(){
        deleteAllProducts.click();
        confirmDeleteAllProducts.click();
    }
}
