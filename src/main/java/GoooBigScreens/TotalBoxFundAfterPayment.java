package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TotalBoxFundAfterPayment extends TestBase {
    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    MobileElement hamburgerMenu;

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الفواتير']")
    MobileElement Invoices;

    public void clickOnInvoices() {
        hamburgerMenu.click();
        Invoices.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement firstInvoice;

    public String getFirstInvoice() {
        return firstInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='14']")
    MobileElement secondInvoice;

    public String getSecondInvoice() {
        return secondInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='20']")
    MobileElement thirdInvoice;

    public String getThirdInvoice() {
        return thirdInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='26']")
    MobileElement fourthInvoice;

    public String getFourthInvoice() {
        return fourthInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='32']")
    MobileElement fifthInvoice;

    public String getFifthInvoice() {
        return fifthInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='38']")
    MobileElement sexInvoice;

    public String getSexInvoice() {
        return sexInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='44']")
    MobileElement sevenInvoice;

    public String getSevenInvoice() {
        return sevenInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='50']")
    MobileElement eightInvoice;

    public String getEightInvoice() {
        return eightInvoice.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='إنهاء الدوام']")
    MobileElement EndShift;

    public void clickOnEndShift() {
        EndShift.click();
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='8']")
    MobileElement OpenBoxTotal;

    public String getOpenBoxTotal() {
        return OpenBoxTotal.getAttribute("content-desc");
    }

    @AndroidFindBy(xpath = "//android.view.View[@index='13']")
    MobileElement TotalBox;

    public String getTotalBox() {
        return TotalBox.getAttribute("content-desc");
    }
}
