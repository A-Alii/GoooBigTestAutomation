package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.AddClientScreen;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class GoooBig_AddClient extends TestBase {
    static boolean previousTestFailed = false;
    AddClientScreen addClientScreen;

    @Test(priority = 1)
    @Description("This test attempts to verify the header of clients screen is Displayed.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void NavigateToClientsScreen() {
        addClientScreen = new AddClientScreen();
        addClientScreen.clickClientsOption();
        Allure.step("Click on Clients option");
        Assert.assertTrue(addClientScreen.isHeaderDisplayed(), "Header is not displayed");
    }

    @Test(priority = 2)
    @Description("This test attempts to verify the add client screen is displayed.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void NavigateToAddClientScreen() {
        addClientScreen = new AddClientScreen();
        addClientScreen.clickAddClientButton();
        Allure.step("Click on Add Client Button and check screen is displayed");
        Assert.assertTrue(addClientScreen.isAddClientHeaderDisplay(), "Add Client Screen is not displayed");
    }

    /*@Test(priority = 3)
    @Description("This test attempts to Verify Click On Cancel Button.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyClickOnCancelButton() {
        addClientScreen = new AddClientScreen();
        Allure.step("Click on Cancel Button.");
        addClientScreen.clickCancelButton();
        Allure.step("Verify Cancel Button Redirect To Clients Screen");
        try {
            Assert.assertTrue(addClientScreen.isHeaderDisplayed(), "Cancel Button Doesn't Work");
        } catch (Exception e) {
            Assert.fail("Cancel Button Doesn't Work");
            addClientScreen.navigateBack();
        }
    }*/

   /* @Test(priority = 4)
    @Description("This test attempts to Verify Click On Add Client Button With Empty Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyClickOnAddClientButtonWithoutData() {
        addClientScreen = new AddClientScreen();
        addClientScreen.clickAddClientButton();
        Allure.step("Click on Add Client Button without any data.");
        addClientScreen.clickApplyButton();
        try {
            Assert.assertTrue(addClientScreen.isPopUpDisplayed(), "after click on Apply button an client added without any data.");
        } catch (Exception e) {
            Assert.fail("after click on Apply button an client added without any data.");
            addClientScreen.clickAddClientButton();
        }
    }

    @Test(priority = 5)
    @Description("This test attempts to Verify Add Client With Name Only.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithNameOnly() {
        addClientScreen = new AddClientScreen();
        addClientScreen.sendKeysToNameField("Yousef");
        addClientScreen.hideKeyboard();
        addClientScreen.clickApplyButton();
        try {
            Assert.assertTrue(addClientScreen.isPopUpDisplayedAfterAddClient(), "after click on Apply button an client added with Name Only.");
        } catch (Exception e) {
            Assert.fail("after click on Apply button an client added with Name Only.");
            addClientScreen.clickAddClientButton();
        }
    }

    @Test(priority = 6)
    @Description("This test attempts to Verify Add Client With Phone Only.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithPhoneOnly() {
        addClientScreen = new AddClientScreen();
        addClientScreen.clearNameField();
        addClientScreen.hideKeyboard();
        addClientScreen.sendKeysToPhoneField("012589745623");
        addClientScreen.hideKeyboard();
        addClientScreen.clickApplyButton();
        try {
            Assert.assertTrue(addClientScreen.isPopUpDisplayed(), "after click on Apply button an client added with Phone Only.");
        } catch (Exception e) {
            //Assert.fail("after click on Apply button an client added with Phone Only.");
            addClientScreen.clickAddClientButton();
        }
    }

    @Test(priority = 7)
    @Description("This test attempts to Verify Add Client With Space Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithSpace() {
        try {
            addClientScreen = new AddClientScreen();
            addClientScreen.sendKeysToNameField(" ");
            addClientScreen.hideKeyboard();
            addClientScreen.clearPhoneField();
            addClientScreen.sendKeysToPhoneField(" ");
            addClientScreen.hideKeyboard();
            addClientScreen.sendKeysToEmailField(" ");
            addClientScreen.hideKeyboard();
            addClientScreen.sendKeysToTaxNumberField(" ");
            addClientScreen.hideKeyboard();
            addClientScreen.clickApplyButton();
            // Verify popup is displayed
            Assert.assertTrue(addClientScreen.isPopUpDisplayed(), "After clicking on Apply button, a client added with Spaces data.");
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
            addClientScreen.clickAddClientButton();
        }
        try {
            addClientScreen = new AddClientScreen();
            addClientScreen.clearNameField();
            addClientScreen.sendKeysToNameField("Test");
            addClientScreen.hideKeyboard();
            addClientScreen.clearPhoneField();
            addClientScreen.sendKeysToPhoneField("Hello");
            addClientScreen.hideKeyboard();
            addClientScreen.clearEmailField();
            addClientScreen.sendKeysToEmailField("Test@gmail.com");
            addClientScreen.hideKeyboard();
            addClientScreen.clearTaxNumberField();
            addClientScreen.sendKeysToTaxNumberField("33333");
            addClientScreen.hideKeyboard();
            addClientScreen.clickApplyButton();
            Assert.assertTrue(addClientScreen.isPopUpDisplayed(), "After clicking on Apply button, a client added with string data for phone.");
            previousTestFailed = false; // Test passed
        } catch (AssertionError | Exception e) {
            previousTestFailed = true; // Test failed
            throw e;
        }

    }

    @Test(priority = 9)
    @Description("This test attempts to Verify Add Client With Valid Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithValidData() {
        if (previousTestFailed) {
            // Print the error message from the previous test
            System.out.println("after click on Apply button an client added with String Data For Phone.");
            addClientScreen.clickAddClientButton();
        }
        addClientScreen = new AddClientScreen();
        addClientScreen.sendKeysToNameField("Yousef");
        addClientScreen.hideKeyboard();
        String ClientName = addClientScreen.getClientName();
        System.out.println("Client Name is " + ClientName);
        addClientScreen.sendKeysToPhoneField("012589745623");
        addClientScreen.hideKeyboard();
        addClientScreen.sendKeysToEmailField("Yousef@gmail.com");
        addClientScreen.hideKeyboard();
        addClientScreen.sendKeysToTaxNumberField("55555");
        addClientScreen.hideKeyboard();
        addClientScreen.clickApplyButton();
        Assert.assertTrue(addClientScreen.isHeaderDisplayed(), "after click on Apply button client doesn't added successfully.");
        System.out.println("Client Name was added in Table is: " + addClientScreen.getClientNameFromTable());
        Assert.assertEquals(ClientName, addClientScreen.getClientNameFromTable(), "after click on Apply button client doesn't added successfully and not matched.");
        addClientScreen.clickAddClientButton();
    }*/

    @Test(priority = 10)
    @Description("This test attempts to Verify Add Client With Valid Same Previous Data.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void VerifyToAddClientWithValidSameData() {
        try {
            addClientScreen = new AddClientScreen();
            addClientScreen.sendKeysToNameField("Yousef");
            addClientScreen.hideKeyboard();
            String ClientName = addClientScreen.getClientName();
            System.out.println("Client Name is " + ClientName);
            addClientScreen.sendKeysToPhoneField("012589745623");
            addClientScreen.hideKeyboard();
            addClientScreen.sendKeysToEmailField("Yousef@gmail.com");
            addClientScreen.hideKeyboard();
            addClientScreen.sendKeysToTaxNumberField("55555");
            addClientScreen.hideKeyboard();
            addClientScreen.clickApplyButton();
            Assert.assertTrue(addClientScreen.isPopUpDisplayedAfterAddSameClient(), "after click on Apply button Same client added successfully.");
            addClientScreen.navigateBack();
            addClientScreen.navigateBack();
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
                addClientScreen = new AddClientScreen();
                // Generate random client name
                String clientName = generateRandomString();
                addClientScreen.sendKeysToNameField(clientName);
                addClientScreen.hideKeyboard();
                // Generate random phone number
                String phoneNumber = generateRandomPhoneNumber();
                addClientScreen.sendKeysToPhoneField(phoneNumber);
                addClientScreen.hideKeyboard();
                // Generate random email
                String email = generateRandomEmail();
                addClientScreen.sendKeysToEmailField(email);
                addClientScreen.hideKeyboard();
                // Generate random tax number
                String taxNumber = generateRandomTaxNumber();
                addClientScreen.sendKeysToTaxNumberField(taxNumber);
                addClientScreen.hideKeyboard();
                addClientScreen.clickApplyButton();
                //Assert.assertTrue(addClientScreen.isHeaderDisplayed(), "after click on Apply button client doesn't added successfully.");
                //System.out.println("Client Name was added in Table is: " + addClientScreen.getClientNameFromTable());
                //Assert.assertEquals(clientName, addClientScreen.getClientNameFromTable(), "after click on Apply button client doesn't added successfully and not matched.");
                addClientScreen.clickAddClientButton();
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
