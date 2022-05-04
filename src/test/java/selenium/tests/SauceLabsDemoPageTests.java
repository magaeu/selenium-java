package selenium.tests;

import org.junit.Test;
import selenium.pages.SauceLabsDemoPage;

public class SauceLabsDemoPageTests extends BaseTest {

    @Test
    public void openDemoPageTest() {
        SauceLabsDemoPage sauceLabsDemoPage = new SauceLabsDemoPage(driver);
        sauceLabsDemoPage.goToDemoPage();
    }
}
