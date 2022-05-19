package ui.framework.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import ui.framework.config.Config;

public class DriverManager {
    private static DriverManager instance = null;
    private WebDriver driver;
    private static Logger logger = LogManager.getLogger();

    private DriverManager() {
        String browser = Config.getProperties("browser.name");
        if (browser.equalsIgnoreCase(Browsers.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            try {
                driver = new FirefoxDriver();
            } catch (Exception ex) {
                logger.fatal("Creating Firefox instance, msg: {}", ex.getMessage());
                throw (ex);
            }
        } else if (browser.equalsIgnoreCase(Browsers.SAFARI)) {
            WebDriverManager.safaridriver().setup();
            try {
                driver = new SafariDriver();
            } catch (Exception ex) {
                logger.fatal("Creating Safari instance, msg: {}", ex.getMessage());
                throw (ex);
            }
        } else {
            WebDriverManager.chromedriver().setup();
            try {
                driver = new ChromeDriver();
            } catch (Exception ex) {
                logger.fatal("Creating Chrome instance, msg: {}", ex.getMessage());
                throw (ex);
            }
        }
    }

    public synchronized static WebDriver getDriver() {
        if(instance == null) {
            instance = new DriverManager();
        }
        return instance.driver;
    }
}
