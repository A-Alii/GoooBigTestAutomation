package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebPortal extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    AndroidElement sideBar;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Portal']")
    AndroidElement portal;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
    List<AndroidElement> editTextElements;
    // Optionally, you can add a method to click on the login button if needed
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Login - دخول']")
    AndroidElement loginButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uE687\n" +
            "إدارة المنتجات']")
    AndroidElement productManagement;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uE68E']")
    AndroidElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='المنتجات']")
    AndroidElement productList;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Galaxy0333']")
    AndroidElement productFirst;
    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text='الاحتفاظ بالحقول']")
    AndroidElement saveFields;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'إضافة') and @index='0']")
    AndroidElement addButton1;
    @AndroidFindBy(xpath = "//android.view.View[contains(@text,'حفظ إلغاء إضافة السجل السابق السجل التالي بحث تفريغ طباعة')]")
    List<AndroidElement> listIcons;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
    List<AndroidElement> editTextElementsProduct;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='حفظ']")
    AndroidElement saveButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='إغلاق :)']")
    AndroidElement cancelButton;

    public WebPortal() {
        // Initialize page factory and WebDriverWait
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickOnWebPortal() {
        sideBar.click();
        portal.click();
    }

    // Method to enter username and password
    public void enterCredentials(String username, String password) {
        //waitForLoginButton();
        if (editTextElements.size() >= 2) {
            editTextElements.get(0).sendKeys(username);  // First element for username
            editTextElements.get(1).click();
            editTextElements.get(1).sendKeys(password);  // Second element for password
        } else {
            System.out.println("Not enough elements found for username and password fields.");
        }
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickProductManagement() {
        productManagement.click();
    }

    public void clickHamburgerMenu() {
        hamburgerMenu.click();
        productList.click();
    }

    public void clickProductFirst() {
        productFirst.click();
    }

    public void scroll() {
        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".scrollForward().scrollIntoView(new UiSelector()" +
                                ".textContains(\"الاحتفاظ بالحقول\"))"));
    }

    public void clickOnSaveFieldsCheckBox() {
        saveFields.click();
    }

    public void scrollUpToText() {
        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                                ".scrollBackward().scrollIntoView(new UiSelector()" +
                                ".textContains(\"إضافة\"))"));
    }

    public void clickAddButton1() {
        addButton1.click();
    }

    public void clickOnListIcons() {
        int size = listIcons.size();
        System.out.println(size);
    }

    public void clickOnListIcons1() {
        if (!listIcons.isEmpty() && listIcons.size() > 0) {
            List<AndroidElement> firstElement = new ArrayList<>();
            firstElement.add(listIcons.get(0));

            // Do something with the first element list, for example, click on the elements
            for (AndroidElement element : firstElement) {
                System.out.println(element);
            }
        } else {
            System.out.println("The list of icons is empty.");
            // Handle the case where the list is empty
        }
    }

    // Method to enter username and password
    public void addNewProduct(String productNameAr, String productNameEn, int Number, int Barcode) {
        //waitForLoginButton();
        if (editTextElementsProduct.size() >= 4) {
            editTextElementsProduct.get(0).click();
            editTextElementsProduct.get(0).clear();
            editTextElementsProduct.get(0).sendKeys(productNameAr);  // First element for username
            editTextElementsProduct.get(1).click();
            editTextElementsProduct.get(1).clear();
            editTextElementsProduct.get(1).sendKeys(productNameEn);  // Second element for password
            editTextElementsProduct.get(2).click();
            editTextElementsProduct.get(2).clear();
            editTextElementsProduct.get(2).sendKeys(String.valueOf(Number));  // Third element for Number
            editTextElementsProduct.get(3).click();
            editTextElementsProduct.get(3).clear();
            editTextElementsProduct.get(3).sendKeys(String.valueOf(Barcode));  // Fourth element for Barcode
        } else {
            System.out.println("Not enough elements found for username and password fields.");
        }
    }

    public void clickSaveButton() {
        saveButton.click();
        cancelButton.click();
    }

}
