package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.SelectWarehouseForTablet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoooBig_SelectWarehouseForTablet extends TestBase {
    SelectWarehouseForTablet selectWarehouseForTablet;

    @Test(priority = 1)
    public void testcase1() {
        selectWarehouseForTablet = new SelectWarehouseForTablet();
        selectWarehouseForTablet.clickOnSelectWarehouse();
        selectWarehouseForTablet.clickOnSelectWarehouseFromList();
        selectWarehouseForTablet.selectProduct();
        selectWarehouseForTablet.clickOnStartOfTheShift();
        selectWarehouseForTablet.sendKeysToBoxFund("5000");
        driver.hideKeyboard();
        selectWarehouseForTablet.clickOnDeliveryFirst();
        selectWarehouseForTablet.ClickOnApplyButton();
    }

    @Test(priority = 2)
    public void testcase2() {
        selectWarehouseForTablet = new SelectWarehouseForTablet();

        // Start the stopwatch for the entire test case
        long testCaseStartTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration: " + (i + 1));

            //start the stopwatch
            long startTime = System.currentTimeMillis();

            // Select product and process the cash invoice
            selectWarehouseForTablet.selectProduct();
            selectWarehouseForTablet.clickOnCashInvoice();

            // Verify if the process is complete
            Assert.assertTrue(selectWarehouseForTablet.processComplete(), "Process is not complete on iteration: " + (i + 1));

            // Stop the stopwatch
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("Invoice is completed for iteration: " + (i + 1) + " in " + duration + " milliseconds");
        }
        // Stop the stopwatch for the entire test case
        long testCaseEndTime = System.currentTimeMillis();
        long testCaseDuration = testCaseEndTime - testCaseStartTime;

        double testCaseDurationMinutes = testCaseDuration / (1000.0 * 60.0);

        System.out.println("Total time taken for the test case: " + testCaseDuration + " milliseconds");
        System.out.println("Total time taken for the test case: " + testCaseDurationMinutes + " minutes");
    }

}
