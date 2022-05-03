package selenium.pages;

import org.openqa.selenium.WebDriver;
import selenium.setup.Waiter;

public class BasePage {

    public WebDriver driver;
    public Waiter wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waiter(driver);
    }

}
