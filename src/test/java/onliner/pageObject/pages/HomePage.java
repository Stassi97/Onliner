package onliner.pageObject.pages;

import framework.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BaseOnlinerPage {

    private static final String PAGE_LOCATOR = "//img[@class='onliner_logo']";
    public HomePage() {
        super(By.xpath(PAGE_LOCATOR), "'Onliner' Page");
    }
}
