package selenium.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import selenium.setup.BrowserType;
import selenium.setup.WebDriverFactory;

public class BaseTest {

    WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver == null) {
            return;
        }
        driver.close();
        driver.quit();
    }
}
