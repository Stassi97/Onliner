package onliner.pageObject.pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;

public class ComparePage extends BasePage {
    private static final String PAGE_LOCATOR = "//div[@class='catalog-form__offers-list' and text()='Products']";
    private static final List<String> PRODUCTS_LIST = getDriver().findElements(By.xpath("//div[@class='catalog-form__description catalog-form__description_primary catalog-form__description_base-additional catalog-form__description_font-weight_semibold catalog-form__description_condensed-other']"))
            .stream().map(e-> e.getText()).collect(Collectors.toList());

    private static final String ITEM = "//a[@class='catalog-form__link catalog-form__link_primary-additional catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor']";
    private static final String PRICE = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[2]/div[2]/div[12]/div/div/div[2]/div[2]/div/div[2]/input";

    private static final String DIAGONAL = "//div/div[3]/div[3]/div/div/div[1]";
    private static final String RESOLUTION = "//*[@id=\"container\"]/div/div/div/div/div[2]/div[1]/div/div/div[3]/div/div[2]/div[2]/div[18]/div/div[2]/div[2]/div/ul/li[3]/label/div/div[2]/div";
    public static String productName;
    private WebElement productItem;
    public static double price;
    public static int diagonal;
    public static String resolution;


    public ComparePage() {
        super(By.xpath(PAGE_LOCATOR),"'Products' Page");
    }

    public WebElement productSelection() { //метод, который ищет элемент на странице
        Random random = new Random();
        int i = random.nextInt(1, PRODUCTS_LIST.size()) - 1; //-1 для того, чтобы НЕ ВЫЙТИ за пределы массива. i-индекс
        productName = PRODUCTS_LIST.get(i);
        System.out.println("ProductName of Products"+productName);
        return productItem = getDriver().findElement(By.xpath(String.format(ITEM, productName))); //любой продукт из списка продуктов (В Item вставляет productName)
    }

    public double getProductPrice() { //цена зависит от наименования товара
        WebElement productPrice = getDriver().findElement(By.xpath(String.format(PRICE, productName)));
        String textPrice = productPrice.getText();
        String partPriceText = textPrice.replace("&nbsp", " ");
        System.out.println(Double.parseDouble(partPriceText));
        return price = Double.parseDouble(partPriceText); //преобразовали string в double
    }

    public void getDiagonal() {
        WebElement diagonal = getDriver().findElement(By.xpath(String.format(DIAGONAL, productName)));
        String textDiagonal = diagonal.getDomProperty("43");
    }

    public void getResolution() {
        WebElement resolution = getDriver().findElement(By.xpath(String.format(RESOLUTION, productName)));
        String textResolution = resolution.getDomProperty("1920x1080 (Full HD)");
    }
}