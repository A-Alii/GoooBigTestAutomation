package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigScreensForTablet.AddClientTablet;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class GoooBig_AddClientTablet extends TestBase {
    static boolean previousTestFailed = false;
    AddClientTablet addClientTablet;

    @Test(priority = 1)
    @Description("This test attempts to verify the header of clients screen is Displayed.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void NavigateToClientsScreen() {
        addClientTablet = new AddClientTablet();
        addClientTablet.clickOnClientsButton();
        Allure.step("Click on Clients option");
        //Assert.assertTrue(addClient.isHeaderDisplayed(), "Header is not displayed");
    }

    @Test(priority = 2)
    @Description("This test attempts to verify the add client screen is displayed.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void NavigateToaddClient() {
        addClientTablet = new AddClientTablet();
        addClientTablet.clickOnAddNewClientButton();
        Allure.step("Click on Add Client Button and check screen is displayed");
        //ظAssert.assertTrue(addClient.isAddClientHeaderDisplay(), "Add Client Screen is not displayed");
    }

    @Test(priority = 3)
    @Description("This test attempts to Verify Click On Cancel Button.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyClickOnCancelButton() {
        addClientTablet = new AddClientTablet();
        Allure.step("Click on Cancel Button.");
        addClientTablet.clickCancelButton();
        Allure.step("Verify Cancel Button Redirect To Clients Screen");
        try {
            Assert.assertTrue(addClientTablet.isClientsScreenDisplayed(), "Cancel Button Doesn't Work");
        } catch (Exception e) {
            Assert.fail("Cancel Button Doesn't Work");
            addClientTablet.navigateBack();
        }
    }

    @Test(priority = 4)
    @Description("This test attempts to Verify Click On Add Client Button With Empty Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyClickOnAddClientButtonWithoutData() {
        addClientTablet = new AddClientTablet();
        addClientTablet.clickOnAddNewClientButton();
        Allure.step("Click on Add Client Button without any data.");
        addClientTablet.clickOnSubmitButton();
        try {
            Assert.assertTrue(addClientTablet.isPopUpDisplayed(), "after click on Apply button an client added without any data.");
        } catch (Exception e) {
            Assert.fail("after click on Apply button an client added without any data.");
            addClientTablet.clickOnAddNewClientButton();
        }
    }

    @Test(priority = 5)
    @Description("This test attempts to Verify Add Client With Name Only.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithNameOnly() {
        addClientTablet = new AddClientTablet();
        addClientTablet.fillClientName("Yousef");
        addClientTablet.hideKeyboard();
        addClientTablet.clickOnSubmitButton();
        try {
            Assert.assertTrue(addClientTablet.isPopUpDisplayedAfterAddClient(), "after click on Apply button an client added with Name Only.");
        } catch (Exception e) {
            Assert.fail("after click on Apply button an client added with Name Only.");
            addClientTablet.clickOnAddNewClientButton();
        }
    }

    @Test(priority = 6)
    @Description("This test attempts to Verify Add Client With Phone Only.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithPhoneOnly() {
        addClientTablet = new AddClientTablet();
        addClientTablet.clearName();
        addClientTablet.hideKeyboard();
        addClientTablet.fillClientPhone("012589745623");
        addClientTablet.hideKeyboard();
        addClientTablet.clickOnSubmitButton();
        try {
            Assert.assertTrue(addClientTablet.isPopUpDisplayed(), "after click on Apply button an client added with Phone Only.");
        } catch (Exception e) {
            //Assert.fail("after click on Apply button an client added with Phone Only.");
            addClientTablet.clickOnAddNewClientButton();
        }
    }

    @Test(priority = 7)
    @Description("This test attempts to Verify Add Client With Space Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithSpace() {
        try {
            addClientTablet = new AddClientTablet();
            addClientTablet.fillClientName(" ");
            addClientTablet.hideKeyboard();
            addClientTablet.clearPhone();
            addClientTablet.fillClientPhone(" ");
            addClientTablet.hideKeyboard();
            addClientTablet.fillClientEmail(" ");
            addClientTablet.hideKeyboard();
            addClientTablet.scrollToElement(" ");
            addClientTablet.hideKeyboard();
            addClientTablet.clickOnSubmitButton();
            // Verify popup is displayed
            Assert.assertTrue(addClientTablet.isPopUpDisplayedAfterAddClient(), "After clicking on Apply button, a client added with Spaces data.");
            previousTestFailed = false; // Test passed
        } catch (AssertionError | Exception e) {
            previousTestFailed = true; // Test failed
            throw e;
        }
    }

    @Test(priority = 8)
    @Description("This test attempts to Verify Add Client With invalid Phone Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithInvalidPhoneData() {
        if (previousTestFailed) {
            // Print the error message from the previous test
            System.out.println("After clicking on Apply button, a client added with string data for phone.");
            addClientTablet.clickOnAddNewClientButton();
        }
        try {
            addClientTablet = new AddClientTablet();
            addClientTablet.clearName();
            addClientTablet.fillClientName("Test1");
            addClientTablet.hideKeyboard();
            addClientTablet.clearPhone();
            addClientTablet.fillClientPhone("Hello0");
            addClientTablet.hideKeyboard();
            addClientTablet.clearEmail();
            addClientTablet.fillClientEmail("Test1@gmail.com");
            addClientTablet.hideKeyboard();
            addClientTablet.clearTax();
            addClientTablet.scrollToElement("33333");
            addClientTablet.hideKeyboard();
            addClientTablet.clickOnSubmitButton();
            Assert.assertTrue(addClientTablet.isPopUpDisplayedAfterAddClient(), "After clicking on Apply button, a client added with string data for phone.");
            previousTestFailed = false; // Test passed
        } catch (AssertionError | Exception e) {
            previousTestFailed = true; // Test failed
            throw e;
        }
    }

    /*@Test(priority = 9)
    @Description("This test attempts to Verify Add Client With Valid Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithValidData() {
        if (previousTestFailed) {
            // Print the error message from the previous test
            System.out.println("after click on Apply button an client added with String Data For Phone.");
            addClientTablet.clickOnAddNewClientButton();
        }
        addClientTablet = new AddClientTablet();
        addClientTablet.clearName();
        addClientTablet.fillClientName("Yousef");
        addClientTablet.hideKeyboard();
        String ClientName = addClientTablet.getClientName();
        System.out.println("Client Name is " + ClientName);
        addClientTablet.clearPhone();
        addClientTablet.fillClientPhone("012589745623");
        addClientTablet.hideKeyboard();
        addClientTablet.clearEmail();
        addClientTablet.fillClientEmail("Yousef@gmail.com");
        addClientTablet.hideKeyboard();
        addClientTablet.clearTax();
        addClientTablet.scrollToElement("55555");
        addClientTablet.hideKeyboard();
        addClientTablet.clickOnSubmitButton();
        //Assert.assertTrue(addClientTablet.isHeaderDisplayed(), "after click on Apply button client doesn't added successfully.");
        //System.out.println("Client Name was added in Table is: " + addClientTablet.getClientNameFromTable());
        //Assert.assertEquals(ClientName, addClientTablet.getClientNameFromTable(), "after click on Apply button client doesn't added successfully and not matched.");
        addClientTablet.clickOnAddNewClientButton();
    }*/

    @Test(priority = 10)
    @Description("This test attempts to Verify Add Client With Valid Same Previous Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithValidSameData() {
        try {
            if (previousTestFailed) {
                // Print the error message from the previous test
                System.out.println("after click on Apply button an client added with String Data For Phone.");
                addClientTablet.clickOnAddNewClientButton();
            }
            addClientTablet = new AddClientTablet();
            addClientTablet.clickCancelButton();
            addClientTablet.clickOnAddNewClientButton();
            addClientTablet.fillClientName("Yousef");
            addClientTablet.hideKeyboard();
            String ClientName = addClientTablet.getClientName();
            System.out.println("Client Name is " + ClientName);
            addClientTablet.fillClientPhone("012589745623");
            addClientTablet.hideKeyboard();
            addClientTablet.fillClientEmail("Yousef@gmail.com");
            addClientTablet.hideKeyboard();
            addClientTablet.scrollToElement("55555");
            addClientTablet.hideKeyboard();
            addClientTablet.clickOnSubmitButton();
            Assert.assertTrue(addClientTablet.isPopUpDisplayedAfterAddSameClient(), "after click on Apply button Same client added successfully.");
            addClientTablet.navigateBack();
            addClientTablet.navigateBack();
            addClientTablet.hideKeyboard();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Random Clients
    /*@Test(priority = 9)
    @Description("This test attempts to Verify Add Client With Valid Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddMultipleClientsWithValidData() {
        for (int i = 1; i <= 10; i++) {
                addClient = new addClient();
                // Generate random client name
                String clientName = generateRandomString();
                addClient.sendKeysToNameField(clientName);
                addClient.hideKeyboard();
                // Generate random phone number
                String phoneNumber = generateRandomPhoneNumber();
                addClient.sendKeysToPhoneField(phoneNumber);
                addClient.hideKeyboard();
                // Generate random email
                String email = generateRandomEmail();
                addClient.sendKeysToEmailField(email);
                addClient.hideKeyboard();
                // Generate random tax number
                String taxNumber = generateRandomTaxNumber();
                addClient.sendKeysToTaxNumberField(taxNumber);
                addClient.hideKeyboard();
                addClient.clickApplyButton();
                //Assert.assertTrue(addClient.isHeaderDisplayed(), "after click on Apply button client doesn't added successfully.");
                //System.out.println("Client Name was added in Table is: " + addClient.getClientNameFromTable());
                //Assert.assertEquals(clientName, addClient.getClientNameFromTable(), "after click on Apply button client doesn't added successfully and not matched.");
                addClient.clickAddClientButton();
        }
    }

    // Method to generate a random string of given length
    private String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(8);
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Method to generate a random phone number
    private String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("0"); // Assuming the phone number starts with 0
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    // Method to generate a random email
    private String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        sb.append("@example.com"); // Assuming the email domain is example.com
        return sb.toString();
    }

    // Method to generate a random tax number
    private String generateRandomTaxNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }*/

}
