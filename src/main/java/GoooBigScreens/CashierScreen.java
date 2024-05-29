package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CashierScreen extends TestBase{
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='الكاشير']")
    MobileElement Cashier;
    public void ClickOnCashier(){
        Cashier.click();
    }
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    MobileElement searchbar;
    public void sendKeysToSearchProduct(String ProductName){
        searchbar.click();
        searchbar.sendKeys(ProductName);
    }
    public void clickOnClearSearch(){
        clearFields();
    }
    public void clearFields() {
        searchbar.clear();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc= '0\n" +
            "السلة\n" +
            "0.00 SR']")
     MobileElement CartEmpty;
    public void clickOnCartEmpty(){
        CartEmpty.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='التصنيفات']")
    MobileElement Categories;
    public WebElement scroll() {
        WebElement element;
        element = driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\"كمبيوتر\"))"));
        return element;
    }
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement ApplyCategory;
    public void clickOnPhoneCategory(){
        Categories.click();
        WebElement element = scroll();
        element.click(); // Click on the scrolled element
        ApplyCategory.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الأقسام']")
    MobileElement Department;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@content-desc='لابتوب']")
    MobileElement AppleDepartment;
    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    MobileElement ApplyDepartment;
    public void clickOnAppleDepartment(){
        Department.click();
        AppleDepartment.click();
        ApplyDepartment.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='عرض جميع المنتجات']")
    MobileElement allProducts;
    public void clickOnShowAllProducts(){
        allProducts.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    MobileElement hamburgerMenu;
    public void clickOnHamburger(){
        hamburgerMenu.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الإعدادات']")
    MobileElement settings;
    public void clickOnSettings(){
        settings.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    MobileElement check1;
    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement check2;
    @AndroidFindBy(xpath = "//android.view.View[@index='14']")
    MobileElement submitCheck;
    public void clickOnCheckPrinting(){
        check1.click();
        check2.click();
        submitCheck.click();
    }
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إعدادات الطباعة']")
    MobileElement printingSettings;
    public void clickOnPrintingSettings(){
        printingSettings.click();
    }
    @AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
    MobileElement addToCart;
    @AndroidFindBy(xpath = "//android.widget.Button[@index='1']")
    MobileElement addToCartTwice;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'السلة') or contains(@content-desc,'9000 SR')]")
    MobileElement Cart;
    public void AddToCart(){
        addToCart.click();
        addToCartTwice.click();
        hideKeyboard();
    }
    public  void goToCart(){
        Cart.click();
    }
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إفراغ السلة']")
    MobileElement deleteAllProducts;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='إفراغ السلة']")
    MobileElement confirmDeleteAllProducts;
    public void clickOnDeleteAllProducts(){
        deleteAllProducts.click();
        confirmDeleteAllProducts.click();
    }
}
