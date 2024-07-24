package GoooBigScreensForTablet;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BoxOperation extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إدارة الدوام']")
    MobileElement manageShift;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='عمليات']")
    MobileElement Transactions;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='سحب / ايداع']")
    MobileElement WithdrawOrDeposit;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    MobileElement amount;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='5']")
    MobileElement selectDropDown;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='GoooBig']")
    MobileElement selectDropDownText;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='تنفيذ']")
    MobileElement Submit;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bيرجى اختيار موظف\u202C']")
    MobileElement error;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='\u202Bمن فضلك ادخل المبلغ\u202C']")
    MobileElement error2;

    public void clickOnManageShift() {
        manageShift.click();
    }

    public void clickOnTransactions() {
        Transactions.click();
    }

    public void clickOnWithdrawOrDeposit() {
        WithdrawOrDeposit.click();
    }

    public void sendKeysToAmount(String amountt) {
        amount.click();
        hideKeyboard();
        amount.sendKeys(amountt);
        hideKeyboard();
    }

    public void clickOnSelectDropDown() {
        selectDropDown.click();
    }

    public void clearAmount() {
        amount.click();
        hideKeyboard();
        amount.clear();
    }

    public void clickOnSelectDropDownText() {
        selectDropDownText.click();
    }

    public void clickOnSubmit() {
        Submit.click();
    }

    public boolean isErrorPresent() {
        return error.isDisplayed();
    }

    public boolean isError2Present() {
        return error2.isDisplayed();
    }


}
