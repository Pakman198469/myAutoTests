package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleh_Hutyrchyk on 1/8/2018.
 */
public class BasePage {
    WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    /*public void waitUntilClickable(TypifiedElement element) {
        waitUntilClickable(element.getWrappedElement());
    }*/

    public void waitUntilClickable(WebElement element) {
        wait
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(1, TimeUnit.SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
