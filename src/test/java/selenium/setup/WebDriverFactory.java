package selenium.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverFactory {

    private static final Map<BrowserType, Supplier<WebDriver>> driverMap = new HashMap<>();
//    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
//    private static final String CHROME_DRIVER_PATH = "src/test/resources/drivers/chromedriver";
//    private static final String FIREFOX_DRIVER = "webdriver.firefox.driver";
//    private static final String FIREFOX_DRIVER_PATH = "src/test/resources/drivers/geckdriver";

    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        WebDriverManager.chromedriver().setup();
//        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
//        ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("--start-maximized");
//        return new ChromeDriver(chromeOptions);
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    static {
        driverMap.put(BrowserType.CHROME, chromeDriverSupplier);
        driverMap.put(BrowserType.FIREFOX, firefoxDriverSupplier);
    }

    public static WebDriver getDriver(BrowserType type){
        return driverMap.get(type).get();
    }
}
