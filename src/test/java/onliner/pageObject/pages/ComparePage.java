package onliner.pageObject.pages;

import framework.BasePage;
import framework.elements.CheckBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static framework.Browser.getDriver;

public class ComparePage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='catalog-form__filter-part catalog-form__filter-part_2']";
    private static final String ITEM_NAME = "//a[@class='catalog-form__link catalog-form__link_primary-additional catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor']";
    private static final String FILTER_ITEM_NAME = "//div[@class='button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag' and text()='Samsung']";
    private static final String ITEM_PRICE = "//a[@class='catalog-form__link catalog-form__link_nodecor catalog-form__link_primary-additional catalog-form__link_huge-additional catalog-form__link_font-weight_bold']";
    private static final String ITEM_PRICE_SALE = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div[2]/a/span[2]";
    private static final String ITEM_DIAGONAL_RESOLUTION = "(//div[@class=\"button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag\"])[3]";
    private static final String ELEMENT_DIAGONAL_RESOLUTION = "(//div[@class=\"catalog-form__description catalog-form__description_primary catalog-form__description_small-additional catalog-form__description_bullet catalog-form__description_condensed\"])[1]";
    private static final String DIAGONAL_RESOLUTION = "//div/div[3]/div[3]/div/div/div[1]";
    private static final String FILTER_ITEM_RESOLUTION = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[1]/div/div[1]/div/div/div[4]/div/text()";
    private static final String PRICE_ITEM = "//div/div[3]/div[3]/div/div/div[2]";
    private static final String PRICE_FILTER = "//div/div[3]/div[3]/div/div/div[3]";
    String diagonalItem;
    String resolutionItem;

    public ComparePage() {
        super(By.xpath(PAGE_LOCATOR),"'Check Product filtration' Page");
    }

    @Step("Check manufacture")
    public void compareProductItem() {
        String itemName = getDriver().findElement(By.xpath(ITEM_NAME)).getText();
        String filterName = getDriver().findElement(By.xpath(FILTER_ITEM_NAME)).getText();
        if (itemName.contains(filterName)) {
            System.out.println("Name is correct");
        } else {
            System.out.println("Name is not correct");
        }
    }

    @Step("Check diagonal")
    public void compareDiagonalItem() {
        String headDiagonalItem = getDriver().findElement(By.xpath(ITEM_DIAGONAL_RESOLUTION)).getText(); // предположим 40-50
        String elementDiagonalItem = getDriver().findElement(By.xpath(ELEMENT_DIAGONAL_RESOLUTION)).getText(); // предположим 43
        String[] range = headDiagonalItem.replace("\"", "").split("-");
        String rangeDiagonal = elementDiagonalItem.split("\"")[0];

        double minDiagonal = Double.parseDouble(range[0]);
        double maxDiagonal = Double.parseDouble(range[1]);
        double diagonalItem = Double.parseDouble(rangeDiagonal);
        if (diagonalItem >= minDiagonal && diagonalItem <= maxDiagonal) {
            System.out.println("Diagonal is correct");
        } else {
            System.out.println("Diagonal is not correct");
        }
    }

    @Step("Check screen resolution")
    public void compareResolutionItem() {
        resolutionItem = getDriver().findElement(By.xpath(DIAGONAL_RESOLUTION)).getText();
        if (resolutionItem.contains(FILTER_ITEM_RESOLUTION)) {
            System.out.println("Screen resolution is correct");
        } else {
            System.out.println("Screen resolution is not correct");
        }
    }

    @Step("Check price (without sale)")
    public void comparePriceItem() {
        String priceItemString = getDriver().findElement(By.xpath(PRICE_ITEM)).getText();
        int priceItem = Integer.parseInt(priceItemString);
        String priceFilterString = getDriver().findElement(By.xpath(PRICE_FILTER)).getText();
        int priceFilter = Integer.parseInt(priceFilterString);
        if (priceItem < priceFilter) {
            System.out.println("Price is correct");
        } else {
            System.out.println("Price is not correct");
        }
    }

    @Step("Check price (with sale - first TV)")
    public void comparePriceItemSale() {
        String priceItemSaleString = getDriver().findElement(By.xpath(ITEM_PRICE_SALE)).getText();
        int priceItemSale = Integer.parseInt(priceItemSaleString);
        String priceFilterString = getDriver().findElement(By.xpath(PRICE_FILTER)).getText();
        int priceFilter = Integer.parseInt(priceFilterString);
        if (priceItemSale < priceFilter) {
            System.out.println("Price sale 1 is correct");
        } else {
            System.out.println("Price is not correct");
        }
    }
}