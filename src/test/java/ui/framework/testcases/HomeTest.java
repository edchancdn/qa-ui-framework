package ui.framework.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.framework.config.Config;

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

}
