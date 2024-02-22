package onliner.pageObject.baseComponents;

import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static framework.Browser.getDriver;

public class Header {
    private static final String NAV_MENU_ITEM = "//span[@class='b-main-navigation__text' and text()='%s']";

    public void mainMenuNavigation(String item) {
        Label lblNavMenuSection = new Label(By.xpath(String.format(NAV_MENU_ITEM, item)));
        lblNavMenuSection.clickAndWait();
    }
}