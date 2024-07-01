package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreens.OrganizationPreparation;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_Preparation extends TestBase {
    OrganizationPreparation organizationPreparation;

    @Test(priority = 1)
        @Description("This test attempts to prepare organization using an Empty Data UserId and a password and OrganizeId.")
        @Severity(CRITICAL)
        @Owner("Ahmed Ali")
        public void prepareOrganizationUsingAnEmptyData() throws IOException, InterruptedException {
            organizationPreparation = new OrganizationPreparation();
            Allure.step("Enter With Empty Data");
            organizationPreparation.fillPrepareOrg("", "", "");
            //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            Allure.step("Assert Error Validation Display");
            Assert.assertTrue(organizationPreparation.isErrorUserNameDisplayed1(), "Error UserName Message is not displayed.");
            System.out.println("Error UserName Message is displayed.");
            Allure.step("Clear Fields");
            organizationPreparation.clearFields();
            //takeScreenshot("Test Step 1");
        }


        @Test(priority = 2)
        @Description("This test attempts to prepare organization using UserId and an Empty Data for password and OrganizeId.")
        @Severity(CRITICAL)
        @Owner("Ahmed Ali")
        public void prepareOrganizationUsingUserIdAndAnEmptyData() throws InterruptedException {
            organizationPreparation = new OrganizationPreparation();
            Allure.step("Enter With Empty Data For Password and OrganizationId and invalid data for userId");
            organizationPreparation.fillPrepareOrg("0000", "", "");
            //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            Allure.step("Assert Error Validation Display");
            Assert.assertTrue(organizationPreparation.isErrorUserNameDisplayed2(), "Error UserName Message is not displayed.");
            System.out.println("Error UserName Message is displayed.");
            Allure.step("Clear Fields");
            organizationPreparation.clearFields();
        }

        @Test(priority = 3)
        @Description("This test attempts to prepare organization using UserId, password and an Empty Data for OrganizeId.")
        @Severity(CRITICAL)
        @Owner("Ahmed Ali")
        public void prepareOrganizationUsingUserIdPasswordAndAnEmptyData() throws InterruptedException {
            organizationPreparation = new OrganizationPreparation();
            Allure.step("Enter With Empty Data For Password and invalid data for userId, Password");
            organizationPreparation.fillPrepareOrg("0000", "1222", "");
            //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            Allure.step("Assert Error Validation Display");
            Assert.assertTrue(organizationPreparation.isErrorUserNameDisplayed3(), "Error UserName Message is not displayed.");
            System.out.println("Error UserName Message is displayed.");
            Allure.step("Clear Fields");
            organizationPreparation.clearFields();
        }

        @Test(priority = 4)
        @Description("This test attempts to prepare organization using Invalid Data UserId, password and OrganizeId.")
        @Severity(CRITICAL)
        @Owner("Ahmed Ali")
        public void prepareOrganizationUsingInvalidData() throws InterruptedException {
            organizationPreparation = new OrganizationPreparation();
            Allure.step("Enter With invalid data for userId, Password, OrganizationId");
            organizationPreparation.fillPrepareOrg("0000", "1222", "1766");
            //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            Allure.step("Assert Error Validation Display");
            Assert.assertTrue(organizationPreparation.isErrorUserNameDisplayed4(), "Login element is not displayed.");
            System.out.println("PopUp Error Message is displayed to tell user data you entered are invalid.");
            Allure.addAttachment("Test Output", "text/plain", "Text in the field is: " + "PopUp Error Message is displayed to tell user data you entered are invalid");
        }
    @Test(priority = 5)
    @Description("This test attempts to prepare organization using valid Data UserId, password and OrganizeId.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void prepareOrganizationUsingValidData() throws IOException, InterruptedException {
        organizationPreparation = new OrganizationPreparation();
        Allure.step("Enter Valid Data");
        organizationPreparation.clearFields();
        organizationPreparation.fillPrepareOrg("0583", "4657", "1266");
        //Thread.sleep(2000);
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.step("Assertion Validation correct.");
        Assert.assertTrue(organizationPreparation.isProductsNumberDisplay(), "Products Number element is not displayed.");
        System.out.println("Preparation Successfully Done.....");
        Allure.addAttachment("Test Output", "text/plain", "Text in the field is: " + "Preparation Successfully Done.");
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    @Description("This test attempts to redirect to Login Screen.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void redirectToLoginScreenAfterPrepareOrganization() throws IOException, InterruptedException {
        organizationPreparation = new OrganizationPreparation();
        Allure.step("Navigate to Login screen");
        organizationPreparation.clickLoginButton();
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.addAttachment("Test Output", "text/plain", "Text in the field is: " + "Preparation Successfully Done and redirect to Login Screen Successfully.");
    }
}
