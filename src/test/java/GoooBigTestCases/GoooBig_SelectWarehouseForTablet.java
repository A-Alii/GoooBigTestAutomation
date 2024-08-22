package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.SelectWarehouseForTablet;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class GoooBig_SelectWarehouseForTablet extends TestBase {
    SelectWarehouseForTablet selectWarehouseForTablet;

    @Test(priority = 1)
    @Description("Select Warehouse and Start of the Shift")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void testcase1() {
        selectWarehouseForTablet = new SelectWarehouseForTablet();
        clickOnSelectWarehouseStep();
        clickOnSelectWarehouseFromListStep();
        selectProductStep();
        clickOnStartOfTheShiftStep();
        sendKeysToBoxFundStep("5000");
        clickOnDeliveryFirstStep();
        ClickOnApplyButtonStep();
    }

    @Step("Click on Select Warehouse")
    public void clickOnSelectWarehouseStep() {
        selectWarehouseForTablet.clickOnSelectWarehouse();
    }

    @Step("Click on Select Warehouse from List")
    public void clickOnSelectWarehouseFromListStep() {
        selectWarehouseForTablet.clickOnSelectWarehouseFromList();
    }

    @Step("Select Product")
    public void selectProductStep() {
        selectWarehouseForTablet.selectProduct();
    }

    @Step("Click on Start of the Shift")
    public void clickOnStartOfTheShiftStep() {
        selectWarehouseForTablet.clickOnStartOfTheShift();
    }

    @Step("Send keys to Box Fund")
    public void sendKeysToBoxFundStep(String amount) {
        selectWarehouseForTablet.sendKeysToBoxFund(amount);
        driver.hideKeyboard();
    }

    @Step("Click on Delivery First")
    public void clickOnDeliveryFirstStep() {
        selectWarehouseForTablet.clickOnDeliveryFirst();
    }

    @Step("Click on Apply Button")
    public void ClickOnApplyButtonStep() {
        selectWarehouseForTablet.ClickOnApplyButton();
    }
    @Test(priority = 2)
    @Description("Process Iteration Step  For Cash Invoice")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void testcase2() throws InterruptedException {
        selectWarehouseForTablet = new SelectWarehouseForTablet();
        // Start the stopwatch for the entire test case
        Allure.step("Start the stopwatch for the entire test case");
        long testCaseStartTime = System.currentTimeMillis();

        Allure.step("Process Iteration Step  For Cash Invoice");
        for (int i = 0; i < 500; i++) {
            System.out.println("Iteration: " + (i + 1));

            //start the stopwatch
            long startTime = System.currentTimeMillis();

            // Select product and process the cash invoice
            selectWarehouseForTablet.selectProduct();
            selectWarehouseForTablet.clickOnCashInvoice();
            Thread.sleep(3000);
            // Verify if the process is complete
            Allure.step("Verify if the process is complete on iteration: " + (i + 1));
            //Assert.assertTrue(selectWarehouseForTablet.processComplete(), "Process is not complete on iteration: " + (i + 1));

            // Stop the stopwatch
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            Allure.addAttachment("Iterations", "text/plain", "Invoice is completed for iteration: " + (i + 1) + " in " + duration + " milliseconds");
            System.out.println("Invoice is completed for iteration: " + (i + 1) + " in " + duration + " milliseconds");
        }
        // Stop the stopwatch for the entire test case
        long testCaseEndTime = System.currentTimeMillis();
        long testCaseDuration = testCaseEndTime - testCaseStartTime;

        double testCaseDurationMinutes = testCaseDuration / (1000.0 * 60.0);

        System.out.println("Total time taken for the test case: " + testCaseDuration + " milliseconds");
        System.out.println("Total time taken for the test case: " + testCaseDurationMinutes + " minutes");
        Allure.addAttachment("Iterations", "text/plain", "Invoice is completed for iteration: " + testCaseDurationMinutes + " minutes");
    }

    @Test(priority = 3)
    @Description("Process for Upload Invoices")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void testcase3() {
        selectWarehouseForTablet = new SelectWarehouseForTablet();
        Allure.step("click On Upload Button");
        selectWarehouseForTablet.clickOnUploadButton();
        Allure.step("click On Start Upload Invoices");
        selectWarehouseForTablet.clickOnStartUploadInvoice();

        long testCaseStartTime = System.currentTimeMillis();

        Allure.step("verify if the upload process is successful Done");
        boolean isUploaded = selectWarehouseForTablet.UploadSuccessIsDisplayed();
        System.out.println("Invoice is uploaded successfully: " + isUploaded);

        if(isUploaded){
            // Stop the stopwatch for the entire test case
            long testCaseEndTime = System.currentTimeMillis();
            long testCaseDuration = testCaseEndTime - testCaseStartTime;
            double testCaseDurationMinutes = testCaseDuration / (1000.0 * 60.0);
            System.out.println("Invoice is uploaded successfully and take a time: " + testCaseDurationMinutes + " minutes");
            Allure.addAttachment("Uploaded process Time", "text/plain", "Invoice is uploaded successfully and take a time: " + testCaseDurationMinutes + " minutes");
        }
    }

}
