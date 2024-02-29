package onliner.pageObject.pages;

import framework.Browser;
import framework.elements.CheckBox;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TVPage extends BaseOnlinerPage {

    private static final String PAGE_LOCATOR = "//div[@class='catalog-form__filter-part catalog-form__filter-part_1 js-container']";
    private static final String MANUFACTURE = "//div[@class='catalog-form__checkbox-sign' and text()='Samsung']";
    private static final String PRICE = "//input[@placeholder='до' and @class='input-style input-style_primary input-style_small catalog-form__input catalog-form__input_width_full']";
    private static final String DIAGONAL = "(//select[@class='input-style__real'])[1]";
    private static final String DIAGONAL1 = "(//select[@class='input-style__real'])[2]";
    private static final String SCREEN_RESOLUTION = "//div[@class = 'catalog-form__checkbox-sign' and contains(text(),\"1920x1080\")]";

    public TVPage() {
        super(By.xpath(PAGE_LOCATOR), "'Filter TV' Page");
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
        price.sendKeys(String.valueOf(Keys.ENTER));
    }

    @Step("Chose first diagonal")
    public void setDiagonal()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TextBox diagonal = new TextBox((By.xpath(String.format(DIAGONAL))));
        diagonal.scrollIntoView();
        diagonal.clickJS();
        diagonal.sendKeys("40");
    }

    @Step("Chose second diagonal")
    public void setDiagonal1() {
        TextBox diagonal1 = new TextBox((By.xpath(String.format(DIAGONAL1))));
        diagonal1.sendKeys("50");
    }

    @Step("Chose screen resolution")
    public void selectScreenResolution() {
        CheckBox screen = new CheckBox((By.xpath(String.format(SCREEN_RESOLUTION))));
        screen.clickJS();
    }
}