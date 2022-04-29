package selenium.tests;

public class SauceLabsDemoPageTests extends BaseTest {

    @Test
    public void openDemoPageTest() {
        SauceLabsDemoPage sauceLabsDemoPage = goToDemoPage();

        assertTrue(Messages.TRIVAGO_PAGE_ERROR,
                sauceLabsDemoPage.isLoaded());
    }
}
