package GoooBigTestCases;

import GoooBigBase.TestBase;
import GoooBigScreens.FavoriteScreen;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

public class GoooBig_Favorite extends TestBase {

    FavoriteScreen favoriteScreen;

    @Test(priority = 1)
    @Description("Verify favorite Icon")
    @Owner("Ahmed Ali")
    @Severity(SeverityLevel.CRITICAL)
    public void verify_favorite_Icon() {
        favoriteScreen = new FavoriteScreen();
        favoriteScreen.clickOnFavoriteIcon(1);
    }

    @Test(priority = 2)
    @Description("Verify favorite screen")
    @Owner("Ahmed Ali")
    @Severity(SeverityLevel.CRITICAL)
    public void verify_favorite_screen() {
        favoriteScreen = new FavoriteScreen();
        favoriteScreen.clickOnFavoriteScreen();
        Assert.assertTrue(favoriteScreen.isFavoriteCategorySelectedDisplayed());
        Allure.addAttachment("Favorite Screen", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        favoriteScreen.clickOnFavoriteIcon(0);
        favoriteScreen.clickOnHome();
        favoriteScreen.clickOnFavoriteScreen();
        Assert.assertTrue(favoriteScreen.isNoFavoritesDisplayed());
        System.out.println(favoriteScreen.getNoFavoritesText());
        Allure.addAttachment("No Favorites", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        favoriteScreen.clickOnHome();
    }
}
