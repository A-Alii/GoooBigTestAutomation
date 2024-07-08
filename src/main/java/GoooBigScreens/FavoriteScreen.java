package GoooBigScreens;

import GoooBigBase.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class FavoriteScreen extends TestBase {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    List<MobileElement> favoriteIcon;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='المفضلة']")
    MobileElement favorite;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='كاشير خدمات']")
    MobileElement favoriteCategory;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='الرئيسية']")
    MobileElement Home;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='لم يتم إضافة عناصر إلى المفضلة بعد']")
    MobileElement NoFavorites;

    public void clickOnFavoriteIcon(int index) {
        favoriteIcon.get(index).click();
    }

    public void clickOnFavoriteScreen() {
        favorite.click();
    }

    public boolean isFavoriteCategorySelectedDisplayed() {
        return favoriteCategory.isDisplayed();
    }

    public void clickOnHome() {
        Home.click();
    }

    public boolean isNoFavoritesDisplayed() {
        return NoFavorites.isDisplayed();
    }

    public String getNoFavoritesText() {
        return NoFavorites.getAttribute("Content-desc");
    }
}
