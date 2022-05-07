package ui.framework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.framework.config.Config;

public class HomeTest {
    @Test
    public void testName() {

        Assert.assertTrue( Config.getProperties("browser.name").equals("chrome"));
    }
}
