package onliner.pageObject.pages;

import framework.elements.CheckBox;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TVPage extends BaseOnlinerPage {

    private static final String PAGE_LOCATOR = "//div[@class='catalog-form__filter-part catalog-form__filter-part_1 js-container']";
    private static final String MANUFACTURE = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[2]/div[2]/div[9]/div/div/div[2]/div[1]/ul/li[2]/label/div/div[1]";
    private static final String PRICE = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[2]/div[2]/div[10]/div/div/div[2]/div[2]/div/div[2]/input";
    private static final String DIAGONAL = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[2]/div[2]/div[15]/div/div[2]/div[2]/div[2]/div/div[1]/div/select";
    private static final String DIAGONAL1 = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[2]/div[2]/div[15]/div/div[2]/div[2]/div[2]/div/div[2]/div/select";
    private static final String SCREEN_RESOLUTION = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[2]/div[2]/div[16]/div/div[2]/div[2]/div/ul/li[3]/label";

    public TVPage() {
        super(By.xpath(PAGE_LOCATOR), "'Filter' Page");
    }

    @Step("Chose manufacture")
    public void selectManufacture() {
        CheckBox manufacture = new CheckBox((By.xpath((MANUFACTURE))));
        manufacture.scrollIntoView();
        manufacture.clickJS();
    }

    @Step("Chose price")
    public void setPrice() {
        TextBox price = new TextBox((By.xpath(String.format(PRICE))));
        price.sendKeys("2000");
    }

    @Step("Chose first diagonal")
    public void setDiagonal() {
        TextBox diagonal = new TextBox((By.xpath(String.format(DIAGONAL))));
        diagonal.scrollIntoView();
        diagonal.sendKeys("40");
    }

    @Step("Chose second diagonal")
    public void setDiagonal1() {
        TextBox diagonal1 = new TextBox((By.xpath(String.format(DIAGONAL1))));
        diagonal1.scrollIntoView();
        diagonal1.sendKeys("50");
    }

    @Step("Chose screen resolution")
    public void selectScreenResolution() {
        CheckBox screen = new CheckBox((By.xpath(String.format(SCREEN_RESOLUTION))));
        screen.click();
    }
}