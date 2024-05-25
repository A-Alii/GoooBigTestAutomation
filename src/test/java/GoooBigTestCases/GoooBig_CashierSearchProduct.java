package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.CashierScreen;
import org.testng.annotations.Test;

public class GoooBig_CashierSearchProduct extends TestBase {
    CashierScreen cashierScreen;

    @Test(priority = 1)
    public void testcase1() {
        cashierScreen = new CashierScreen(driver);
        cashierScreen.ClickOnCashier();
        cashierScreen.clickOnHamburger();
        cashierScreen.clickOnSettings();
        cashierScreen.clickOnPrintingSettings();
        cashierScreen.clickOnCheckPrinting();
        cashierScreen.navigateBack();
        cashierScreen.navigateBack();
        cashierScreen.sendKeysToSearchProduct("ايفون");
        cashierScreen.hideKeyboard();
        cashierScreen.clickOnClearSearch();
        cashierScreen.hideKeyboard();
    }

    @Test(priority = 2)
    public void testcase2() throws InterruptedException {
        cashierScreen = new CashierScreen(driver);
        cashierScreen.clickOnCartEmpty();
        Thread.sleep(3000);
        System.out.println("There is no products in cart.");
    }

    @Test(priority = 3)
    public void testcase3(){
        cashierScreen = new CashierScreen(driver);
        cashierScreen.clickOnPhoneCategory();
        cashierScreen.clickOnAppleDepartment();
        cashierScreen.clickOnShowAllProducts();
        cashierScreen.sendKeysToSearchProduct("13");
        cashierScreen.hideKeyboard();
        cashierScreen.AddToCart();
        cashierScreen.goToCart();
        System.out.println("Cart contains a products");
    }


    @Test(priority = 4)
    public void testcase4(){
        cashierScreen = new CashierScreen(driver);
        cashierScreen.clickOnDeleteAllProducts();
        cashierScreen.hideKeyboard();
        cashierScreen.clearFields();
        cashierScreen.hideKeyboard();
    }

    @Test(priority = 5)
    public void testcase5(){
        cashierScreen = new CashierScreen(driver);
        cashierScreen.sendKeysToSearchProduct("باقة رمضان");
        cashierScreen.hideKeyboard();
        cashierScreen.AddToCart();
        cashierScreen.goToCart();
        System.out.println("Cart contains a products");
    }

}