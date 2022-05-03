package selenium.pages;

import org.openqa.selenium.WebDriver;
import selenium.utils.Messages;

import static junit.framework.TestCase.assertTrue;

public class SauceLabsDemoPage extends BasePage {

    private static final String SAUCELABS_DEMO_URL = "http://www.saucedemo.com";
    private static final String DEMO_TITLE = "Swag Labs";
    public SauceLabsDemoPage(WebDriver driver) {
        super(driver);
    }

    public void goToDemoPage() {
        driver.get(SAUCELABS_DEMO_URL);
        assertTrue(Messages.DEMO_PAGE_ERROR,
                driver.getTitle().contains(DEMO_TITLE));
    }
}
