package selenium.tests;

import org.junit.Test;
import selenium.pages.LoginPage;
import selenium.pages.ProductsPage;

import static junit.framework.TestCase.assertTrue;

public class LoginPageTests extends BaseTest {

    @Test
    public void openPageTest() {
        LoginPage sauceLabsPage = new LoginPage(driver);
        sauceLabsPage.goToSauceLabsPage();
    }

    @Test
    public void loginWithValidCredentials() {
        LoginPage sauceLabsPage = new LoginPage(driver);
        sauceLabsPage.goToSauceLabsPage();
        sauceLabsPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(driver).isLoaded());
    }
}
