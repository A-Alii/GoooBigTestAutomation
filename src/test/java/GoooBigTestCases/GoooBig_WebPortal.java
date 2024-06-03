package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.WebPortal;
import org.testng.annotations.Test;

public class GoooBig_WebPortal extends TestBase {
    WebPortal webPortal;

    @Test(priority = 1)
    public void verifyWebPortal() throws InterruptedException {
        webPortal = new WebPortal();
        webPortal.clickOnWebPortal();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void verifyLogin() throws InterruptedException {
        webPortal.enterCredentials("0583", "4657");
        webPortal.clickLoginButton();
        webPortal.clickProductManagement();
        webPortal.clickHamburgerMenu();
        webPortal.clickProductFirst();
        Thread.sleep(2000);

        webPortal.scroll();
        Thread.sleep(1000);
        webPortal.clickOnSaveFieldsCheckBox();
        webPortal.scrollUpToText();
        Thread.sleep(1000);
        webPortal.clickOnListIcons1();
        /*webPortal.addNewProduct("calculator", "calc", 1583, 1583);
        webPortal.clickSaveButton();*/
    }
}
