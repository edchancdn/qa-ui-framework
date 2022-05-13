package ui.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.framework.config.Config;
import ui.framework.drivermanager.DriverManager;

public class HomeTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testName() {
        Assert.assertTrue( Config.getProperties(null).equals("chrome"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testBlank() {
        Assert.assertTrue( Config.getProperties("").equals("chrome"));
    }

    @Test()
    public void testNullKey() {
        Assert.assertNull( Config.getProperties("data"));
    }

    @Test
    public void testBroswer() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://pragra.io");
        Assert.assertNotNull(driver);
        driver.quit();

    }
}
