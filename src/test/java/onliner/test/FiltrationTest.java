package onliner.test;

import framework.BaseTest;
import io.qameta.allure.Description;
import onliner.pageObject.pages.*;
import org.testng.annotations.Test;

public class FiltrationTest extends BaseTest {

    @Test
    @Description("Onliner description")
    public void checkFiltration() {
        HomePage homePage = new HomePage();

        NavigationPage.mainMenuNavigation("Каталог");
        NavigationPage.electronicsNavigateTo("Электроника");
        NavigationPage.navigateToSabMenu("Телевизоры и видео"); // видео
        NavigationPage.tvNavigate("Телевизоры");

        TVPage filtersPage = new TVPage();
        filtersPage.selectManufacture();
        filtersPage.setPrice();
        filtersPage.setDiagonal();
        filtersPage.setDiagonal1();
        filtersPage.selectScreenResolution();

        Compare compare = new Compare();
        compare.compareProductItem();
        compare.compareDiagonalItem();
        compare.compareResolutionItem();

    }
}