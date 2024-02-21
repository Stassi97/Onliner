package onliner.pageObject.pages;

import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NavigationPage extends BaseOnlinerPage{

    private static final String PAGE_LOCATOR = "//div[@class='g-middle']";
    private static final String NAV_MENU_ITEM = "//span[@class='b-main-navigation__text' and text()='%s']";
    private static final String ELECTRONICS = "//li[@data-id='1']";
    private static final String TV_AND_VIDEO = "//*[@id=\"container\"]/div/div/div/div/div[1]/div[4]/div/div[2]/div[1]/div/div[2]/div[1]";
    private static final String TV = "//a[@href='https://catalog.onliner.by/tv']";

    public NavigationPage() {
        super(By.xpath(String.format(PAGE_LOCATOR)), "'Navigation' Page");
    }

    @Step("Chose Catalog")
    public static void mainMenuNavigation(String item) {
        Label lblNavMenuSection = new Label(By.xpath(String.format(NAV_MENU_ITEM, item)));
        lblNavMenuSection.clickAndWait();
    }

    @Step("Chose Electronics")
    public static void electronicsNavigateTo(String item) {
        Label electronics = new Label(By.xpath(String.format(ELECTRONICS, item)));
        electronics.clickAndWait();
    }

    @Step("Chose TV and video")
    public static void navigateToSabMenu(String item) {
        TextBox tvAndVideo = new TextBox(By.xpath(String.format(TV_AND_VIDEO, item)));
        tvAndVideo.moveAndClickByAction();
    }

    @Step("Chose TV")
    public static void tvNavigate(String item) {
        Label tv = new Label(By.xpath(String.format(TV, item)));
        tv.moveAndClickByAction();
    }
}