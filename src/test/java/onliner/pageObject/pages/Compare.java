package onliner.pageObject.pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static framework.Browser.getDriver;

public class Compare extends BasePage {

    private static final String PAGE_LOCATOR = "//div[@class='catalog-form__filter-part catalog-form__filter-part_2']";
    private static final WebElement ITEM_NAME = getDriver().findElement(By.xpath("//a[@class='catalog-form__link catalog-form__link_primary-additional catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor']"));
    private static final WebElement FILTER_ITEM_NAME = getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[1]/div/div[1]/div/div/div[1]/div"));
    String nameItem;
    String filterName;
    private static final String ITEM_PRICE = "//a[@class='catalog-form__link catalog-form__link_nodecor catalog-form__link_primary-additional catalog-form__link_huge-additional catalog-form__link_font-weight_bold']";
    private static final WebElement ITEM_DIAGONAL_RESOLUTION = getDriver().findElement(By.xpath("//div/div[3]/div[3]/div/div/div[1]"));
    private static final WebElement FILTER_ITEM_RESOLUTION = getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[3]/div[1]/div/div[1]/div/div/div[4]/div"));
    String diagonalItem;
    String resolutionItem;
    String filterResolution;

    public Compare() {
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
        filterResolution = FILTER_ITEM_RESOLUTION.getText();
        if (resolutionItem.contains(filterResolution)) {
            System.out.println("Resolution is correct");
        }
        else {
            System.out.println("Resolution is not correct");
        }
    }
}