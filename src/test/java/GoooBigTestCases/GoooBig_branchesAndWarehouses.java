package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.BranchesAndWarehouses;
import GoooBigScreens.HomeScreen;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_branchesAndWarehouses extends TestBase {
    BranchesAndWarehouses branchesAndWarehouses;

    @Test(priority = 1)
    @Description("This test attempts to verify Select Warehouse.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifySelectWarehouse() throws InterruptedException {
        branchesAndWarehouses = new BranchesAndWarehouses();
        Allure.step("verify to click on cashier option.");
        branchesAndWarehouses.clickOnCashier();
        Allure.step("verify to select valid warehouse from list.");
        branchesAndWarehouses.selectOptionFromList();
        Allure.step("verify to click on Apply button.");
        Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        branchesAndWarehouses.clickOnApply();
        System.out.println("TEST CASE DONE SUCCESSFULLY");

    }
}
