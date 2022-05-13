package ui.framework.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import ui.framework.config.Config;

public class DriverManager {
    private static DriverManager instance = null;
    private WebDriver driver;

    private DriverManager(){
        String browser = Config.getProperties("browser.name");
        if(browser.equalsIgnoreCase(Browsers.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else  if(browser.equalsIgnoreCase(Browsers.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else  if(browser.equalsIgnoreCase(Browsers.SAFARI)) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

    }

    public synchronized static WebDriver getDriver() {
        if(instance == null) {
            instance = new DriverManager();
        }
        return instance.driver;
    }
}
