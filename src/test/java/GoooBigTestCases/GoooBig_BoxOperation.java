package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.BoxOperation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoooBig_BoxOperation extends TestBase {
    BoxOperation boxOperation;
    String amount = "5000.0";

    @Test(priority = 1)
    public void testcase1() {
        boxOperation = new BoxOperation();
        boxOperation.goToBoxOperation();
        boxOperation.isBoxOperationScreenDisplay();
        System.out.println("Box Operation Screen Is Displayed.");
    }

    @Test(priority = 2)
    public void testcase2() {
        boxOperation = new BoxOperation();
        boxOperation.sendKeysToBoxOperation1();
        System.out.println("Please select an employee and enter an amount you wanted!!!!!");
    }

    @Test(priority = 3)
    public void testcase3() throws InterruptedException {
        boxOperation = new BoxOperation();
        boxOperation.sendKeysToBoxOperation2(" ");
        System.out.println("Please enter an amount you wanted!!!!!");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void testcase4() throws InterruptedException {
        boxOperation = new BoxOperation();
        Thread.sleep(1000);
        boxOperation.sendKeysToBoxOperation3(amount);
        System.out.println("Transaction Successfully Done!");
        Thread.sleep(6000);
        boxOperation.navigateBack();
    }

    @Test(priority = 5)
    public void testcase5() {
        boxOperation = new BoxOperation();
        boxOperation.goToEndShift();
        System.out.println("Deposit Amount Is: " + boxOperation.getAmountTotalBox());
        boxOperation.clickOnCancelButton();
        Assert.assertTrue(boxOperation.logoIsDisplay(), "Logo Not Display");
        System.out.println("You Are In Cashier Products Screen");

    }

    @Test(priority = 6)
    public void cashInvoice() throws InterruptedException {
        boxOperation = new BoxOperation();
        boxOperation.sendKeysToSearchProduct("iphone 13");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct();
        boxOperation.clickOnClearSearch();
        boxOperation.sendKeysToSearchProduct("Galaxy 0999");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct1();
        boxOperation.clickOnClearSearch();
        boxOperation.sendKeysToSearchProduct("Galaxy 10");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct1();
        boxOperation.clickOnClearSearch();
        boxOperation.hideKeyboard();
        boxOperation.goToCart();
        boxOperation.clickOnNextBasket();
        boxOperation.clickOnCashButton();
        Thread.sleep(6000);
        boxOperation.navigateBack();
        boxOperation.goToInvoices();
        Thread.sleep(3000);
        boxOperation.navigateBack();
        System.out.println("Invoice Added Successfully");
    }

    @Test(priority = 7)
    public void cashInvoiceWithProductDiscount() throws InterruptedException {
        boxOperation = new BoxOperation();
        boxOperation.sendKeysToSearchProduct("iphone 13");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct();
        boxOperation.clickOnClearSearch();
        boxOperation.sendKeysToSearchProduct("Galaxy 0999");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct1();
        boxOperation.clickOnClearSearch();
        boxOperation.sendKeysToSearchProduct("Galaxy 10");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct1();
        boxOperation.clickOnClearSearch();
        boxOperation.hideKeyboard();
        boxOperation.goToCart();
        boxOperation.clickOnEditProduct();
        boxOperation.sendKeysToDiscount("500");
        System.out.println("Discount Amount Is: " + boxOperation.getDiscountAmount());
        boxOperation.clickOnSubmitButton();
        boxOperation.clickOnNextBasket();
        boxOperation.clickOnCashButton();
        Thread.sleep(6000);
        boxOperation.navigateBack();
        boxOperation.goToInvoices();
        Thread.sleep(3000);
        boxOperation.navigateBack();
        System.out.println("Invoice Added Successfully");
    }

    @Test(priority = 8)
    public void cashInvoiceWithInvoiceDiscount() throws InterruptedException {
        boxOperation = new BoxOperation();
        boxOperation.sendKeysToSearchProduct("iphone 13");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct();
        boxOperation.clickOnClearSearch();
        boxOperation.sendKeysToSearchProduct("Galaxy 0999");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct1();
        boxOperation.clickOnClearSearch();
        boxOperation.sendKeysToSearchProduct("Galaxy 10");
        boxOperation.hideKeyboard();
        boxOperation.clickOnProduct1();
        boxOperation.clickOnClearSearch();
        boxOperation.hideKeyboard();
        boxOperation.goToCart();
        boxOperation.clickOnNextBasket();
        boxOperation.clickOnDiscountButton();
        boxOperation.sendKeysToInvoiceDiscount("500");
        boxOperation.clickOnSubmitButtonInvoice();
        boxOperation.clickOnCashButton();
        Thread.sleep(6000);
        boxOperation.navigateBack();
        boxOperation.goToInvoices();
        Thread.sleep(3000);
        boxOperation.navigateBack();
        System.out.println("Invoice Added Successfully");
    }
}
