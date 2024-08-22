package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigListener.TestListener;
import GoooBigScreensForTablet.LoginTablet;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Listeners(TestListener.class)
public class GoooBig_LoginTablet extends TestBase {
    LoginTablet login;
/*    @Test(priority = 1)
    @Description("This test attempts to login to organization using an Empty Data UserId and a password.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void loginToOrganizationUsingAnEmptyData() {
        login = new LoginTablet();
        Allure.step("Enter With Empty Data");
        login.fillLoginScreen("", "");
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.step("Assert Error Validation Display");
        Assert.assertTrue(login.isErrorUserNameDisplayed1(), "Error UserName Message is not displayed.");
        System.out.println("Error UserName Message is displayed.");
        Allure.addAttachment("Test Output", "text/plain", "Text in the field is: " + "Error UserName Message in UserId and Password is displayed.");
    }

    @Test(priority = 2)
    @Description("This test attempts to Login to organization using UserId and an Empty Data for password.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void LoginToOrganizationUsingUserIdAndAnEmptyData() {
        login = new LoginTablet();
        Allure.step("Enter With Empty Data For Password and invalid data for userId");
        login.fillLoginScreen("1664", "");
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.step("Assert Error Validation Display");
        Assert.assertTrue(login.isErrorUserNameDisplayed2(), "Error Password Message is not displayed.");
        System.out.println("Error Password Message is displayed.");
        Allure.addAttachment("Test Output", "text/plain", "Text in the field is: " + "Error UserName Message in Password is displayed.");
        Allure.step("Clear Fields");
        login.clearFields();
    }

    @Test(priority = 3)
    @Description("This test attempts to Login to organization using Invalid UserId, password.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void LoginToOrganizationUsingInvalidData() {
        login = new LoginTablet();
        Allure.step("Enter With invalid data for userId, Password.");
        login.fillLoginScreen("1664", "1662");
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Allure.step("Assert Error Validation Display");
        Assert.assertTrue(login.isErrorUserNameDisplayed3(), "check field doesn't exist.");
        System.out.println("check field still exist.");
        Allure.addAttachment("Test Output", "text/plain", "Text in the field is: " + "PopUp Message Display to tell user the data you entered is invalid.");
        Allure.step("Clear Fields");
        login.clearFields();
    }

    @Test(priority = 4)
    @Description("This test attempts to Get Text")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void GetTextFromLoginScreen() throws InterruptedException {
        login = new LoginTablet();
        Thread.sleep(3000);
        Allure.step("Get Text there is in Login button.");
        login.hideKeyboard();
        String fieldText = login.getText();
        System.out.println("Text in the field is: " + fieldText);
        // Comparing strings using equals() method
        if (fieldText.equals("تسجيل الدخول")) {
            System.out.println("Successfully Done...........");
        } else {
            System.out.println("Error....................");
        }
        // Attaching the output to Allure report
        Allure.addAttachment("Test Output", "text/plain", "Text in the field is: " + fieldText);
    }*/

    @Test(priority = 5)
    @Description("This test attempts to Login to organization using valid UserId, password.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void LoginToOrganizationUsingValidData() throws InterruptedException {
        login = new LoginTablet();
        Allure.step("Enter Valid Data");
        login.clearFields();
        login.fillLoginScreen("0583", "0583");
        System.out.println("Login Successfully Done.");
        Allure.addAttachment("Test Output", "text/plain", "Text in the field is: " + "Login Done Successfully and user redirect to Home screen.");
        login.hideKeyboard();
    }
}
