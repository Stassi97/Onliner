package onliner.pageObject.pages;

import framework.BasePage;
import framework.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static framework.Browser.getDriver;

public class ComparePage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='catalog-form__filter-part catalog-form__filter-part_2']";
    private static final String ITEM_NAME = "//a[@class='catalog-form__link catalog-form__link_primary-additional catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor']";
    private static final String FILTER_ITEM_NAME = "//div[@class='button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag' and text()='Samsung']";
    private static final String ITEM_PRICE = "//a[@class='catalog-form__link catalog-form__link_nodecor catalog-form__link_primary-additional catalog-form__link_huge-additional catalog-form__link_font-weight_bold']";
    private static final String ITEM_PRICE_SALE = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div[2]/a/span[2]";
    private static final String FILTER_DIAGONAL_RESOLUTION = "(//div[@class=\"button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag\"])[3]";
    private static final String ITEM_DIAGONAL_RESOLUTION = "(//div[@class=\"catalog-form__description catalog-form__description_primary catalog-form__description_small-additional catalog-form__description_bullet catalog-form__description_condensed\"])[1]";
    private static final String DIAGONAL_RESOLUTION = "(//div[@class=\"catalog-form__description catalog-form__description_primary catalog-form__description_small-additional catalog-form__description_bullet catalog-form__description_condensed\"])[1]";
    private static final String FILTER_ITEM_RESOLUTION = "(//div[@class=\"button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag\"])[4]";
    private static final String PRICE_ITEM = "//div[@class=\"catalog-form__description catalog-form__description_huge-additional catalog-form__description_font-weight_bold catalog-form__description_condensed-other catalog-form__description_primary\"]";
    private static final String PRICE_FILTER = "(//div[@class=\"button-style button-style_either button-style_small catalog-form__button catalog-form__button_tag\"])[2]";

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
            Browser.waitForPageLoad();
            String headDiagonalItem = getDriver().findElement(By.xpath(FILTER_DIAGONAL_RESOLUTION)).getText(); // предположим 40-50
            String elementDiagonalItem = getDriver().findElement(By.xpath(ITEM_DIAGONAL_RESOLUTION)).getText(); // предположим 43
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
        String resolutionItem = getDriver().findElement(By.xpath(DIAGONAL_RESOLUTION)).getText();
        String filterResolution = getDriver().findElement(By.xpath(FILTER_ITEM_RESOLUTION)).getText();
        if (resolutionItem.contains(filterResolution)) {
            System.out.println("Screen resolution is correct");
        } else {
            System.out.println("Screen resolution is not correct");
        }
    }

    @Step("Check price (without sale)")
    public void comparePriceItem() {
        String priceItemString = getDriver().findElement(By.xpath(PRICE_ITEM)).getText();
        String priceFilterString = getDriver().findElement(By.xpath(PRICE_FILTER)).getText();
        double priceItem = extractNumberFromString(priceItemString);
        double priceFilter = extractNumberFromString(priceFilterString);
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
            System.out.println("Price sale is correct");
        } else {
            System.out.println("Price is not correct");
        }
    }

    private double extractNumberFromString(String str) { // Метод для извлечения числа из строки
        Pattern pattern = Pattern.compile("\\d+(,\\d+)?");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String number = matcher.group();
            return Double.parseDouble(number.replace(',', '.'));
        } else {
            throw new IllegalArgumentException("Не удалось извлечь число из строки: " + str);
        }
    }
}