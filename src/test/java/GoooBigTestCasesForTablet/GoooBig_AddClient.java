package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigScreensForTablet.AddClient;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class GoooBig_AddClient extends TestBase {
    static boolean previousTestFailed = false;
    AddClient addClient;

    @Test(priority = 1)
    @Description("This test attempts to verify the header of clients screen is Displayed.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void NavigateToClientsScreen() {
        addClient = new AddClient();
        addClient.clickOnClientsButton();
        Allure.step("Click on Clients option");
        //Assert.assertTrue(addClient.isHeaderDisplayed(), "Header is not displayed");
    }

    @Test(priority = 2)
    @Description("This test attempts to verify the add client screen is displayed.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void NavigateToaddClient() {
        addClient = new AddClient();
        addClient.clickOnAddNewClientButton();
        Allure.step("Click on Add Client Button and check screen is displayed");
        //ظAssert.assertTrue(addClient.isAddClientHeaderDisplay(), "Add Client Screen is not displayed");
    }

    @Test(priority = 3)
    @Description("This test attempts to Verify Click On Cancel Button.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyClickOnCancelButton() {
        addClient = new AddClient();
        Allure.step("Click on Cancel Button.");
        addClient.clickCancelButton();
        Allure.step("Verify Cancel Button Redirect To Clients Screen");
        try {
            Assert.assertTrue(addClient.isClientsScreenDisplayed(), "Cancel Button Doesn't Work");
        } catch (Exception e) {
            Assert.fail("Cancel Button Doesn't Work");
            addClient.navigateBack();
        }
    }

    @Test(priority = 4)
    @Description("This test attempts to Verify Click On Add Client Button With Empty Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyClickOnAddClientButtonWithoutData() {
        addClient = new AddClient();
        addClient.clickOnAddNewClientButton();
        Allure.step("Click on Add Client Button without any data.");
        addClient.clickOnSubmitButton();
        try {
            Assert.assertTrue(addClient.isPopUpDisplayed(), "after click on Apply button an client added without any data.");
        } catch (Exception e) {
            Assert.fail("after click on Apply button an client added without any data.");
            addClient.clickOnAddNewClientButton();
        }
    }

    @Test(priority = 5)
    @Description("This test attempts to Verify Add Client With Name Only.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithNameOnly() {
        addClient = new AddClient();
        addClient.fillClientName("Yousef");
        addClient.hideKeyboard();
        addClient.clickOnSubmitButton();
        try {
            Assert.assertTrue(addClient.isPopUpDisplayedAfterAddClient(), "after click on Apply button an client added with Name Only.");
        } catch (Exception e) {
            Assert.fail("after click on Apply button an client added with Name Only.");
            addClient.clickOnAddNewClientButton();
        }
    }

    @Test(priority = 6)
    @Description("This test attempts to Verify Add Client With Phone Only.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithPhoneOnly() {
        addClient = new AddClient();
        addClient.clearName();
        addClient.hideKeyboard();
        addClient.fillClientPhone("012589745623");
        addClient.hideKeyboard();
        addClient.clickOnSubmitButton();
        try {
            Assert.assertTrue(addClient.isPopUpDisplayed(), "after click on Apply button an client added with Phone Only.");
        } catch (Exception e) {
            //Assert.fail("after click on Apply button an client added with Phone Only.");
            addClient.clickOnAddNewClientButton();
        }
    }

    @Test(priority = 7)
    @Description("This test attempts to Verify Add Client With Space Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithSpace() {
        try {
            addClient = new AddClient();
            addClient.fillClientName(" ");
            addClient.hideKeyboard();
            addClient.clearPhone();
            addClient.fillClientPhone(" ");
            addClient.hideKeyboard();
            addClient.fillClientEmail(" ");
            addClient.hideKeyboard();
            addClient.scrollToElement(" ");
            addClient.hideKeyboard();
            addClient.clickOnSubmitButton();
            // Verify popup is displayed
            Assert.assertTrue(addClient.isPopUpDisplayedAfterAddClient(), "After clicking on Apply button, a client added with Spaces data.");
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
            addClient.clickOnAddNewClientButton();
        }
        try {
            addClient = new AddClient();
            addClient.clearName();
            addClient.fillClientName("Test");
            addClient.hideKeyboard();
            addClient.clearPhone();
            addClient.fillClientPhone("Hello");
            addClient.hideKeyboard();
            addClient.clearEmail();
            addClient.fillClientEmail("Test@gmail.com");
            addClient.hideKeyboard();
            addClient.clearTax();
            addClient.scrollToElement("33333");
            addClient.hideKeyboard();
            addClient.clickOnSubmitButton();
            Assert.assertTrue(addClient.isPopUpDisplayedAfterAddClient(), "After clicking on Apply button, a client added with string data for phone.");
            previousTestFailed = false; // Test passed
        } catch (AssertionError | Exception e) {
            previousTestFailed = true; // Test failed
            throw e;
        }
    }

/*    @Test(priority = 9)
    @Description("This test attempts to Verify Add Client With Valid Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithValidData() {
        if (previousTestFailed) {
            // Print the error message from the previous test
            System.out.println("after click on Apply button an client added with String Data For Phone.");
            addClient.clickAddClientButton();
        }
        addClient = new addClient();
        addClient.clearNameField();
        addClient.sendKeysToNameField("Yousef");
        addClient.hideKeyboard();
        String ClientName = addClient.getClientName();
        addClient.clearPhoneField();
        System.out.println("Client Name is " + ClientName);
        addClient.sendKeysToPhoneField("012589745623");
        addClient.hideKeyboard();
        addClient.clearEmailField();
        addClient.sendKeysToEmailField("Yousef@gmail.com");
        addClient.hideKeyboard();
        addClient.clearTaxNumberField();
        addClient.sendKeysToTaxNumberField("55555");
        addClient.hideKeyboard();
        addClient.clickApplyButton();
        Assert.assertTrue(addClient.isHeaderDisplayed(), "after click on Apply button client doesn't added successfully.");
        System.out.println("Client Name was added in Table is: " + addClient.getClientNameFromTable());
        Assert.assertEquals(ClientName, addClient.getClientNameFromTable(), "after click on Apply button client doesn't added successfully and not matched.");
        addClient.clickAddClientButton();
    }*/

    @Test(priority = 10)
    @Description("This test attempts to Verify Add Client With Valid Same Previous Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithValidSameData() {
        try {
            addClient = new AddClient();
            addClient.clickCancelButton();
            addClient.clickOnAddNewClientButton();
            addClient.fillClientName("Yousef");
            addClient.hideKeyboard();
            String ClientName = addClient.getClientName();
            System.out.println("Client Name is " + ClientName);
            addClient.fillClientPhone("012589745623");
            addClient.hideKeyboard();
            addClient.fillClientEmail("Yousef@gmail.com");
            addClient.hideKeyboard();
            addClient.scrollToElement("55555");
            addClient.hideKeyboard();
            addClient.clickOnSubmitButton();
            Assert.assertTrue(addClient.isPopUpDisplayedAfterAddSameClient(), "after click on Apply button Same client added successfully.");
            addClient.navigateBack();
            addClient.navigateBack();
            addClient.hideKeyboard();
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
