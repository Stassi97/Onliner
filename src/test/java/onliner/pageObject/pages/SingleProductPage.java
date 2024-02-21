package onliner.pageObject.pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static framework.Browser.getDriver;

public class SingleProductPage extends BasePage { //выбрали один товар

    private static final String PAGE_LOCATOR = "//div[@class='inventory_details_name large_size' and text()='%s']";
    private static final WebElement PRODUCT_ITEM = getDriver().findElement(By.xpath("//div[@class='inventory_details_name large_size']"));
    private static final String PRICE_ITEM = "//div[@class='catalog-form__description catalog-form__description_huge-additional catalog-form__description_font-weight_bold catalog-form__description_condensed-other catalog-form__description_primary']";
    private static final WebElement DIAGONAL_ITEM = getDriver().findElement(By.xpath("//div/div[3]/div[3]/div/div/div[1]"));
    private static final WebElement RESOLUTION_ITEM = getDriver().findElement(By.xpath("//div/div[3]/div[3]/div/div/div[1]"));

    String productItem;
    double priceItem; //переменная для цены
    int diagonalItem;
    String resolutionItem;

    public SingleProductPage() {
        super(By.xpath(String.format(PAGE_LOCATOR, ComparePage.productName)),"Single Product Page: " +ComparePage.productName);
    }
    public void getProductItem() { //достали текст в переменную (название товара)
        productItem = PRODUCT_ITEM.getText();
    }

    public double getPriceItem() {
        WebElement productPrice = getDriver().findElement(By.xpath(String.format(PRICE_ITEM, productItem)));
        String textPrice = productPrice.getText();
        String partPriceText = textPrice.replace("$", "");
        System.out.println(Double.parseDouble(partPriceText));
        return priceItem = Double.parseDouble(partPriceText); //преобразовали string в double
    }

    public void getdiagonalItem() {
        diagonalItem = Integer.parseInt(DIAGONAL_ITEM.getText());
    }

    public void getResolutionItem() {
        resolutionItem = String.valueOf(Integer.parseInt(RESOLUTION_ITEM.getText()));
    }

    public void itemValidation() {
        getProductItem();
        if(productItem.contains(ComparePage.productName)) {
            System.out.println("Items are equal");
        } else {
            System.out.println("Items are not equal");
        }
    }

    public void priceItemValidation() {
        getPriceItem();
        if (priceItem < ComparePage.price) {
            System.out.println("Price is correct");
        }
        else {
            System.out.println("Price is not correct");
        }
    }

    public void diagonalItemValidation() {
        getdiagonalItem();
        if (diagonalItem > 40 & diagonalItem < 50) {
            System.out.println("Diagonal is correct");
        }
        else {
            System.out.println("Diagonal is not correct");
        }
    }
    public void itemResolutionValidation() {
        getProductItem();
        if(resolutionItem.equals((ComparePage.resolution))) {
            System.out.println("Resolutions are equal");
        } else {
            System.out.println("Resolutions are not equal");
        }
    }
}