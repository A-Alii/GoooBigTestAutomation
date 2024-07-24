package GoooBigTestCasesForTablet;

import GoooBigBase.TestBase;
import GoooBigScreensForTablet.PendingInvoiceTablet;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoooBig_PendingInvoiceTablet extends TestBase {

    public String discount = "500.00";
    PendingInvoiceTablet pendingInvoiceTablet;

    @Test(priority = 1)
    public void verify_PendingInvoiceTablet() throws InterruptedException {
        pendingInvoiceTablet = new PendingInvoiceTablet();
        pendingInvoiceTablet.clickProduct1();
        pendingInvoiceTablet.clickProduct2();
        pendingInvoiceTablet.clickDiscountButton();
        pendingInvoiceTablet.setDiscount(discount);
        pendingInvoiceTablet.clickApply();
        String details = pendingInvoiceTablet.getDetailsOfInvoiceTablet();
        System.out.println(details);
        System.out.println("بيانات الفاتورة الموجودة فى السلة");
        System.out.println("----------------------------------");
        // Define the regular expression pattern to match text and numbers
        Pattern pattern = Pattern.compile("([\\p{InArabic}\\s]+)|(SR \\d+\\.\\d+|\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(details);

        // Define the set of keywords we are interested in
        Set<String> keywords = new HashSet<>(Arrays.asList("الضريبة", "الخصم", "الإجمالى"));

        // Iterate through the matches and print the text and number
        String text = "";
        List<String> numbers = new ArrayList<>();

        while (matcher.find()) {
            String group = matcher.group().trim();
            if (keywords.contains(group)) {
                text = group;
            } else if (group.matches("\\d+\\.\\d+")) {
                if (keywords.contains(text)) {
                    numbers.add(group);
                    System.out.println(text + ": " + group);
                    Allure.addAttachment("Test Output", "text/plain", "Invoice Details Are: " + text + ": " + group);
                }
            }
        }
        System.out.println("----------------------------------");
        pendingInvoiceTablet.clickPendingButton();
        pendingInvoiceTablet.clickInvoicesScreen();
        pendingInvoiceTablet.clickPendingInvoices();
        Thread.sleep(3000);
        //Allure.addAttachment("Screenshot for result", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        String TotalPrice = pendingInvoiceTablet.getTotalInvoicePriceTablet();
        System.out.println("إجمالى الفاتورة الموجود فى صفحة الفواتير: " + TotalPrice);
        System.out.println("*****************************************************");
        // Remove non-numeric characters from TotalPrice
        String cleanedTotalPrice = TotalPrice.replaceAll("[^0-9.]", "");

        // Compare TotalPrice with the last extracted number
        if (numbers.size() >= 3) {
            String extractedTax = numbers.get(0);
            String extractedDiscount = numbers.get(1);
            String extractedTotal = numbers.get(2);
            System.out.println("إجمالى الضريبة(السلة) : " + extractedTax);
            System.out.println("الخصم(السلة) : " + extractedDiscount);
            System.out.println("المجموع(السلة) : " + extractedTotal);
            try {
                double expectedTotalNum = Double.parseDouble(cleanedTotalPrice);
                double actualTotalNum = Double.parseDouble(extractedTotal);
                System.out.println("expectedTotalNum: " + expectedTotalNum);
                System.out.println("actualTotalNum: " + actualTotalNum);
                Assert.assertEquals(expectedTotalNum, actualTotalNum, "Total values do not match.");
                System.out.println("TotalPrice is equal to the total price number in invoices screen.");
                Allure.addAttachment("Test Output", "text/plain", "Assertion Result: TotalPrice is equal to the total price number in invoices screen.");
            } catch (NumberFormatException e) {
                System.err.println("Error parsing numeric values: " + e.getMessage());
            }
        } else {
            System.out.println("No number extracted from details to compare with TotalPrice.");
        }

        System.out.println("********************************************");
        pendingInvoiceTablet.navigateBack();
    }
}
