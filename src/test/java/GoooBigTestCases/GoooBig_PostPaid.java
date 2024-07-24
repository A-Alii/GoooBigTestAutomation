package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.PostPaidScreen;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_PostPaid extends TestBase {
    PostPaidScreen postPaidScreen;

    @Test(priority = 1)
    @Description("This test attempts to Small Tax Invoice with discount over Product level")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void CreateAnPostPaidInvoice() throws InterruptedException, TesseractException, IOException {
        postPaidScreen = new PostPaidScreen();
        Allure.step("Select Invoice Type..");
        postPaidScreen.smallNonTaxInvoice();
        postPaidScreen.navigateBack();
        postPaidScreen.navigateBack();
        Allure.step("verify to search for a product and add it in cart.");
        postPaidScreen.sendKeysToSearchProduct("iphone 13");
        postPaidScreen.hideKeyboard();
        postPaidScreen.clickOnProduct();
        postPaidScreen.clickOnClearSearch();
        Allure.step("verify to search for a product and add it in cart.");
        postPaidScreen.sendKeysToSearchProduct("Galaxy 0999");
        postPaidScreen.hideKeyboard();
        postPaidScreen.clickOnProduct1();
        postPaidScreen.clickOnClearSearch();
        postPaidScreen.hideKeyboard();
        Allure.step("Navigate to cart screen.");
        postPaidScreen.goToCart();
        Thread.sleep(2000);
        Allure.step("verify to make a discount over any product.");
        postPaidScreen.clickOnEditProduct();
        postPaidScreen.sendKeysToDiscount("500");
        Allure.step("Navigate to Next Cart Screen.");
        postPaidScreen.clickOnNextBasket();
        Allure.step("select client for invoice.");
        postPaidScreen.clickOnNoticeCreditorButton();
        Thread.sleep(1000);
        postPaidScreen.clickOnSelectClientForInvoice();
        Thread.sleep(2000);
        postPaidScreen.selectClientName();
        Thread.sleep(1000);
        postPaidScreen.clickOnSelection();
        postPaidScreen.navigateBack();
        Allure.step("click on PostPaid Button.");
        postPaidScreen.clickOnPostPaidButton();
        postPaidScreen.clickOnConfirmationButton();
        Thread.sleep(4000);
        Allure.addAttachment("Screenshot for invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        postPaidScreen.navigateBack();
        postPaidScreen.clickOnCahier();
        postPaidScreen.hideKeyboard();
    }
}
