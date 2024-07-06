package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigScreensForTablet.UploadInvoiceForClientTablet;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class GoooBig_UploadInvoiceForClientTablet extends TestBase {
    public String numberOnly = "";
    public int totalPostPaid = 0;
    public String numberOnlyPostPaid = "";
    public int amountPostPaid = 0;
    public int amountLast;
    UploadInvoiceForClientTablet uploadInvoiceForClient;
    private String test = "";
    private String test1 = "";

    @Test(priority = 1)
    @Description("This test attempts to select Invoice type.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyToSelectInvoiceType() throws InterruptedException {
        uploadInvoiceForClient = new UploadInvoiceForClientTablet();
        uploadInvoiceForClient.clickOnSettings();
        uploadInvoiceForClient.clickOnPrinting();
        Thread.sleep(3000);
        uploadInvoiceForClient.clickOnTaxInvoice();
        uploadInvoiceForClient.clickOnSubmitButton();
    }

    @Test(priority = 2)
    @Description("This test attempts to Navigate To Cart Without Products.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyToNavigateToCartWithoutProducts() throws InterruptedException {
        uploadInvoiceForClient = new UploadInvoiceForClientTablet();
        uploadInvoiceForClient.hideKeyboard();
        uploadInvoiceForClient.clickOnCashButton();
        Thread.sleep(1000);
        System.out.println("There is no products in cart.");
    }

    @Test(priority = 3)
    @Description("This test attempts to verify Select Category And Department And Product.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyToSelectCategoryAndDepartmentAndProduct() throws InterruptedException {
        uploadInvoiceForClient = new UploadInvoiceForClientTablet();
        uploadInvoiceForClient.clickOnCategory();
        uploadInvoiceForClient.clickOnDepartment();
        uploadInvoiceForClient.clickOnIphoneProduct();
        uploadInvoiceForClient.clickOnAllProducts();
        System.out.println("Cart contains a products");
    }

    @Test(priority = 4)
    @Description("This test attempts to select client for invoice.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyToSelectClientForInvoice() throws InterruptedException {
        uploadInvoiceForClient = new UploadInvoiceForClientTablet();
        Allure.step("select client for invoice.");
        uploadInvoiceForClient.clickOnNext();
        Thread.sleep(1000);
        uploadInvoiceForClient.clickOnSelectClient();
        Thread.sleep(2000);
        uploadInvoiceForClient.sendKeysToSearchClient("Yousef");
        uploadInvoiceForClient.selectClientName();
        Thread.sleep(1000);
        uploadInvoiceForClient.clickOnDebits();
        Thread.sleep(4000);
        String clientAmount = uploadInvoiceForClient.getDebitsAmount();
        System.out.println(clientAmount);

        // Define the pattern for extracting numbers
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(clientAmount);

        // Find and print the numerical part
        if (matcher.find()) {
            numberOnly = matcher.group();
            test = numberOnly.replaceAll("\\..*$", "");
            System.out.println("total number of postpaid invoices for client: " + test); // Output: 66000.0
        }

        amountPostPaid = Integer.parseInt(test);
        System.out.println("Integer Number is: " + amountPostPaid);
        uploadInvoiceForClient.navigateBack();
        uploadInvoiceForClient.hideKeyboard();
        uploadInvoiceForClient.clickOnClients();
        uploadInvoiceForClient.clickOnSelectButton();
        uploadInvoiceForClient.clickOnPostPaidOption();
        Allure.step("click on PostPaid Button.");
        uploadInvoiceForClient.clickOnPostPaidInvoice();
        Thread.sleep(4000);
        Allure.addAttachment("Screenshot for invoice", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        Thread.sleep(2000);
        uploadInvoiceForClient.navigateBack();
        uploadInvoiceForClient.clickOnUploadInvoice();
        Assert.assertTrue(uploadInvoiceForClient.isSuccessUpload(), "Invoice is not uploaded");
        System.out.println("Invoice is uploaded");
    }

    @Test(priority = 5)
    @Description("This test attempts to Update Clients from Update Screen.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyToUpdateClients() throws InterruptedException {
        uploadInvoiceForClient = new UploadInvoiceForClientTablet();
        uploadInvoiceForClient.clickOnInvoicesScreen();
        String invoiceAmount = uploadInvoiceForClient.getInvoiceAmount();
        int endIndex = invoiceAmount.indexOf('.');
        String invoiceNumberOnly = invoiceAmount.substring(0, endIndex);
        System.out.println("Invoice Amount Is: " + invoiceNumberOnly);
        amountLast = Integer.parseInt(invoiceNumberOnly);
        System.out.println("Integer Number of Invoice is: " + amountLast);
        uploadInvoiceForClient.navigateBack();
        uploadInvoiceForClient.hideKeyboard();
        uploadInvoiceForClient.clickOnClientsButton();
        Thread.sleep(2000);
        uploadInvoiceForClient.sendKeysToSearchClient("Yousef");
        uploadInvoiceForClient.selectClientName();
        uploadInvoiceForClient.clickOnDebits();
        Thread.sleep(3000);
        String clientAmountLast = uploadInvoiceForClient.getDebitsAmount();
        System.out.println(clientAmountLast);
        // Define the pattern for extracting numbers
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(clientAmountLast);

        // Find and print the numerical part
        if (matcher.find()) {
            numberOnlyPostPaid = matcher.group();
            test1 = numberOnlyPostPaid.replaceAll("\\..*$", "");
            System.out.println("All Postpaid Amount: " + test1);
        }


        totalPostPaid = Integer.parseInt(test1);
        System.out.println("Integer Number of Total Postpaid amount is: " + totalPostPaid);

        int finalAmount = amountPostPaid + amountLast;
        System.out.println("sum of postpaid amount and invoice amount: " + finalAmount);

        Assert.assertEquals(totalPostPaid, finalAmount);
        System.out.println("total amount of postpaid of client is equal");

        /*uploadInvoiceForClient.navigateBack();
        uploadInvoiceForClient.navigateBack();
        uploadInvoiceForClient.hideKeyboard();*/
    }

    @Test(priority = 6)
    @Description("This test attempts to Update Clients from Update Screen.")
    @Severity(CRITICAL)
    @Owner("Ahmed Ali")
    public void verifyToPayAnAmount() throws InterruptedException, IOException {
        uploadInvoiceForClient = new UploadInvoiceForClientTablet();
        Thread.sleep(4000);
        String ClientName = uploadInvoiceForClient.getClientNameInPaymentScreen();
        System.out.println("Client Name is: " + ClientName);
        double totalAmount = Double.parseDouble(uploadInvoiceForClient.getTotalAmountOfPaymentScreen());
        System.out.println("Total Amount is: " + totalAmount);
        double RemainingAmount = Double.parseDouble(uploadInvoiceForClient.getRemainingAmountOfPaymentScreen());
        System.out.println("Remaining Amount is: " + RemainingAmount);
        String amountToPay = "500.0";
        uploadInvoiceForClient.sendKeysToPayAmountForClient(amountToPay);
        uploadInvoiceForClient.hideKeyboard();
        double amountPaid = Double.parseDouble(uploadInvoiceForClient.getPayAmountForClient());
        double amountToPayAfter = Double.parseDouble(amountToPay);
        Assert.assertEquals(amountPaid, amountToPayAfter);
        System.out.println("Amount to Pay is: " + amountPaid);
        uploadInvoiceForClient.clickOnSubmitButtonForPayment();
        Thread.sleep(15000);
        // Capture the screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File("Payment-Receipt.png");
        FileUtils.copyFile(screenshot, screenshotFile);
        // Use Tesseract to extract text from the image
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("Arabic"); // Set the language to Arabic
        String extractedText;
        try {
            extractedText = tesseract.doOCR(screenshotFile);
            //extractedText = extractedText.replace("عlدي|", "إيداع");
            // Extract required information
            String deposit = "";
            String from = "";
            String to = "";

            String[] lines = extractedText.split("\n");
            for (String line : lines) {
                if (line.contains("سند قبض")) {
                    deposit = line.replaceAll("[^0-9.]", "").trim();
                } else if (line.contains("من")) {
                    from = line.replaceAll(".*من\\s*", "").trim();
                    // Attempt to correct common OCR errors in Arabic names
                    //from = correctArabicName(from);
                } else if (line.contains("إلى")) {
                    to = line.replaceAll(".*إلى\\s*", "").trim();
                }
            }

            // Format the output
            String formattedOutput = String.format("سند قبض : %s\nمن : %s\nإلى : %s", deposit, from, to);
            System.out.println("deposit: " + deposit);
            System.out.println("from: " + from);
            System.out.println("to: " + to);

            System.out.println("----------------------------------");
            System.out.println("البيانات المطلوبة من الفاتورة");
            System.out.println("----------------------------------");
            System.out.println(formattedOutput);

            Allure.addAttachment("Formatted Invoice Data", "text/plain", formattedOutput);

        } catch (TesseractException e) {
            e.printStackTrace();
            System.out.println("Error while extracting text from image: " + e.getMessage());
        }
        Allure.addAttachment("Screenshot for Receipt of Payment", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        uploadInvoiceForClient.navigateBack();
        uploadInvoiceForClient.clickOnResetButtonForPayment();
        Thread.sleep(3000);
        double Remaining = RemainingAmount - amountToPayAfter;
        System.out.println("Remaining Amount is: " + Remaining);
        double RemainingAmountAfterPrinting = Double.parseDouble(uploadInvoiceForClient.getRemainingAmountOfPaymentScreen2());
        System.out.println("Remaining Amount After Printing is: " + RemainingAmountAfterPrinting);
        Assert.assertEquals(Remaining, RemainingAmountAfterPrinting);
        System.out.println("Remaining Amount is: " + RemainingAmountAfterPrinting);
        System.out.println("Remaining Amount is equal to Total Amount");
        uploadInvoiceForClient.navigateBack();
        uploadInvoiceForClient.navigateBack();
        uploadInvoiceForClient.navigateBack();
    }
}
