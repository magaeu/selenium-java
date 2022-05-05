package selenium.pages;

import org.openqa.selenium.WebDriver;
import selenium.setup.Waiter;

public class BasePage {

    protected WebDriver driver;
    protected Waiter wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new Waiter(driver);
    }

}
