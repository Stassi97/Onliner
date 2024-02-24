package onliner.pageObject.pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static framework.Browser.getDriver;

public class ComparePage extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='catalog-form__filter-part catalog-form__filter-part_2']";
    private static final WebElement ITEM_NAME = getDriver().findElement(By.xpath("//a[@class='catalog-form__link catalog-form__link_primary-additional catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor']"));
    private static final WebElement FILTER_ITEM_NAME = getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[1]/div/div[1]/div/div/div[1]/div"));
    String nameItem;
    String filterName;
    private static final String ITEM_PRICE = "//a[@class='catalog-form__link catalog-form__link_nodecor catalog-form__link_primary-additional catalog-form__link_huge-additional catalog-form__link_font-weight_bold']";
    private static final String ITEM_PRICE_SALE_1 = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div[2]/a/span[2]";
    private static final String ITEM_PRICE_SALE_2 = "/*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[2]/div/div[2]/div/div/div[2]/div[2]/a/span[2]";
    double priceItem;
    double priceItemSale1;
    double priceItemSale2;
    int filterPrice = 2000;
    double priceFilter = (double)filterPrice;
    private static final WebElement ITEM_DIAGONAL_RESOLUTION = getDriver().findElement(By.xpath("//div/div[3]/div[3]/div/div/div[1]"));
    private static final String FILTER_ITEM_RESOLUTION = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[1]/div/div[1]/div/div/div[4]/div/text()";
    String diagonalItem;
    String resolutionItem;

    public ComparePage() {
        super(By.xpath(PAGE_LOCATOR),"'Product' Page");
    }

    public void compareProductItem() {
        nameItem = ITEM_NAME.getText();
        filterName = FILTER_ITEM_NAME.getText();
        if (nameItem.contains(filterName)) {
            System.out.println("Name is correct");
        }
        else {
            System.out.println("Name is not correct");
        }
    }

    public void compareDiagonalItem() {
        diagonalItem = ITEM_DIAGONAL_RESOLUTION.getText();
        if (diagonalItem.contains("43\"")) {
            System.out.println("Diagonal is correct");
        }
        else {
            System.out.println("Diagonal is not correct");
        }
    }

    public void compareResolutionItem() {
        resolutionItem = ITEM_DIAGONAL_RESOLUTION.getText();
        if (resolutionItem.contains(FILTER_ITEM_RESOLUTION)) {
            System.out.println("Resolution is correct");
        }
        else {
            System.out.println("Resolution is not correct");
        }
    }

    public double PriceItem() {
        WebElement productPrice = getDriver().findElement(By.xpath(String.format(ITEM_PRICE)));
        String textPrice = productPrice.getText();
        String partPriceText = textPrice.replace("&nbsp", "");
        System.out.println(Double.parseDouble(partPriceText));
        return priceItem = Double.parseDouble(partPriceText); //преобразовали string в double
    }

    public double PriceItemSale1() {
        WebElement productPrice = getDriver().findElement(By.xpath(String.format(ITEM_PRICE_SALE_1)));
        String textPrice = productPrice.getText();
        String partPriceText = textPrice.replace("&nbsp;", "");
        System.out.println(Double.parseDouble(partPriceText));
        return priceItemSale1 = Double.parseDouble(partPriceText); //преобразовали string в double
    }

    public double PriceItemSale2() {
        WebElement productPrice = getDriver().findElement(By.xpath(String.format(ITEM_PRICE_SALE_2)));
        String textPrice = productPrice.getText();
        String partPriceText = textPrice.replace("&nbsp;", "");
        System.out.println(Double.parseDouble(partPriceText));
        return priceItemSale2 = Double.parseDouble(partPriceText); //преобразовали string в double
    }

    public void comparePriceItem() {
        if(priceItem<priceFilter) {
            System.out.println("Price is correct");
        }
        else {
            System.out.println("Price is not correct");
        }
    }

    public void comparePriceItemSale1() {
        if(priceItemSale1<priceFilter) {
            System.out.println("Price sale 1 is correct");
        }
        else {
            System.out.println("Price is not correct");
        }
    }

    public void comparePriceItemSale2() {
        if(priceItemSale2<priceFilter) {
            System.out.println("Price sale 2 is correct");
        }
        else {
            System.out.println("Price is not correct");
        }
    }
}