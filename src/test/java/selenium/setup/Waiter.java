package selenium.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiter {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    private final WebDriverWait wait;

    public Waiter(WebDriver driver) {
        this.wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }


    public WebElement untilIsVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> untilAllIsVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> untilAllIsPresent(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void untilIsNotPresent(By locator, String attribute, String value) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.attributeContains(locator, attribute, value))));
    }
}
