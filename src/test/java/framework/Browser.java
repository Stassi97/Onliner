package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Browser {
    public static Browser instance;
    public static WebDriver driver;

    public static Browser getInstance() {
        if (instance == null) {
            driver = DriverFactory.getDriver();
            driver.manage().timeouts().implicitlyWait(PropertyReader.getIntProperty("timeout"), TimeUnit.SECONDS); //неявное ожидание драйвера 10сек
        } else{
            System.err.println("Driver doesn't instance!");
        }
        return instance = new Browser(); //
    }

    public static void windowMaximize() {
        driver.manage().window().maximize();
    }

    public static void navigateTo(String url) { //метод перехода по сслыке
        driver.get(url);
    }

    public static void close() { //метод закрытия браузера
        driver.quit();
        instance = null;
        System.out.println("Driver has been closed.");
    }

    public static void waitForPageLoad() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyReader.getIntProperty("page.load.timeout"))); //на протяжении 20сек обращается к документу и проверяет статус
        wait.until(driver->executor.executeScript("return document.readyState").equals("complete")); //wait until явное ожидание

    }

    public static void waitForPageContentLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyReader.getIntProperty("page.load.timeout")));
        wait.until(driver -> {
            Long initialContentHeight = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            ExpectedCondition<Boolean> contentLoadFinished = webDriver -> {
                Long currentContentHeight = (Long) ((JavascriptExecutor) webDriver).executeScript("return document.body.scrollHeight");
                if (!currentContentHeight.equals(initialContentHeight)) {
                    return false; // Содержимое все еще загружается
                }
                // Проверяем наличие jQuery на странице
                Boolean jQueryLoaded = (Boolean) ((JavascriptExecutor) webDriver).executeScript("return (typeof jQuery != 'undefined')");
                if (!jQueryLoaded) {
                    return true; // Прекращаем ожидание, если jQuery не загружен
                }
                // Проверяем завершение всех активных запросов jQuery
                Long activeRequests = (Long) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active");
                return activeRequests.equals(0L);
            };
            return contentLoadFinished.apply(driver);
        });
    }

    public static void waitForPageLoadNEW() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyReader.getIntProperty("page.load.timeout")));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }



    public static WebDriver getDriver() {
        return driver;
    }
}
