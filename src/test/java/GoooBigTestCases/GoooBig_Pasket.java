package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.PasketScreen;
import org.testng.annotations.Test;

public class GoooBig_Pasket extends TestBase {
    PasketScreen pasketScreen;

    @Test(priority = 1)
    public void testcase1() {
        pasketScreen = new PasketScreen();
        pasketScreen.clickOnEditIcon();
        pasketScreen.sendKeysToDiscount("400");
        System.out.println("Discount Amount Is: " + pasketScreen.getDiscountAmount());
        //System.out.println(pasketScreen.getDiscountAmount());
        pasketScreen.clickOnSubmitButton();
    }

    @Test(priority = 2)
    public void testcase2() {
        pasketScreen = new PasketScreen();
        pasketScreen.clickOnPlusIcon();
        pasketScreen.clickOnNextButton();
    }

    @Test(priority = 3)
    public void testcase3() throws InterruptedException {
        pasketScreen = new PasketScreen();
        pasketScreen.clickOnCashInvoice();
        //pasketScreen.clickOnJustOnInvoice();
        Thread.sleep(6000);
        pasketScreen.navigateBack();
        pasketScreen.afterNavigate();
    }
}
