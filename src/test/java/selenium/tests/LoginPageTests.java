package selenium.tests;

import org.junit.Test;
import selenium.pages.LoginPage;
import selenium.pages.ProductsPage;

import static junit.framework.TestCase.assertTrue;

public class LoginPageTests extends BaseTest {

    @Test
    public void openPageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToSauceLabsPage();
    }

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = goToLoginPage();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(new ProductsPage(driver).isLoaded());
    }

    private LoginPage goToLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToSauceLabsPage();
        return loginPage;
    }
}
