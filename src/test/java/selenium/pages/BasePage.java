package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import seucesar.tests.setup.Waiter;
import seucesar.tests.utils.Constants;
import seucesar.tests.utils.Locators;

public class BasePage {

    protected WebDriver driver;
    protected Waiter wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waiter(driver);
    }

}
