package selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.utils.Messages;

import static junit.framework.TestCase.assertTrue;

public class LoginPage extends BasePage {

    private static final String SAUCELABS_URL = "https://www.saucedemo.com";
    private static final String PAGE_TITLE = "Swag Labs";
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToSauceLabsPage() {
        driver.get(SAUCELABS_URL);
        assertTrue(Messages.DEMO_PAGE_ERROR,
                driver.getTitle().contains(PAGE_TITLE));
    }

    public void login(String userName, String password) {
        getUserNameField().sendKeys(userName);
        getPasswordField().sendKeys(password);
        getSubmitButton().submit();
    }

    private WebElement getUserNameField() {
        return driver.findElement(By.id("user-name"));
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    private WebElement getSubmitButton() {
        return driver.findElement(By.className("btn_action"));
    }
}
