package ui.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.framework.config.Config;
import ui.framework.data.ArbitProvider;
import ui.framework.data.LoginProvider;
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

    @Test(enabled = false)
    public void testBroswer() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://pragra.io");
        Assert.assertNotNull(driver);
        driver.quit();

    }
    @Test(dataProvider = "arbit", dataProviderClass = ArbitProvider.class)
    public void testLoginData(String user, String pass) {
        System.out.println("user = " + user);
        System.out.println("pass = " + pass);
    }
}
