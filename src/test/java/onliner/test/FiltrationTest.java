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

        FiltersPage filtersPage = new FiltersPage();
        filtersPage.setManufacture();
        filtersPage.setPrice();
        filtersPage.setDiagonal();
        filtersPage.setDiagonal1();
        filtersPage.setScreenResolution();

//        ComparePage comparePage = new ComparePage(); //если все, что ниже закомментить, то нормально будет работать
//        comparePage.getDiagonal();
//        comparePage.getProductPrice();
//        comparePage.getResolution();
//        comparePage.productSelection();
//
//        SingleProductPage singleProductPage = new SingleProductPage();
//        singleProductPage.itemValidation();
//        singleProductPage.diagonalItemValidation();
//        singleProductPage.itemResolutionValidation();
//        singleProductPage.priceItemValidation();
    }
}