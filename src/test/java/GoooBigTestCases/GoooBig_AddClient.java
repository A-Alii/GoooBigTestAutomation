package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.AddClientScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoooBig_AddClient extends TestBase {

    AddClientScreen addClientScreen;

    @Test(priority = 1)
    public void testcase1(){
        addClientScreen = new AddClientScreen();
        Assert.assertEquals(addClientScreen.getNavbarText(), "إختيار عميل", "an error nothing to get");
        addClientScreen.sendKeysToFields(" "," ", " ");
    }

    @Test(priority = 2)
    public void testcase2(){
        addClientScreen = new AddClientScreen();
        addClientScreen.sendKeysToFields("Ahmed Ali", "010039107", "ahmedali@gmail.com");
    }
}
