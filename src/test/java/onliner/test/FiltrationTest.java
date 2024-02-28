package onliner.test;

import framework.BaseTest;
import io.qameta.allure.Description;
import onliner.pageObject.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FiltrationTest extends BaseTest {

    @Test
    @Description("Onliner description")
    @Parameters({"manufacturer", "resolution", "priceTo", "diagonalFrom", "diagonalTo"})

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

        ComparePage compare = new ComparePage();
        compare.compareProductItem();
        compare.compareDiagonalItem();
        compare.compareResolutionItem();
        compare.comparePriceItem();
        compare.comparePriceItemSale();
        softAssert.assertAll();
    }
}