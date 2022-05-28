package ui.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingPage {
    WebDriver driver;
    @FindBy(id = "tab-monthly")
    private WebElement billmonthly;

    @FindBy(id = "meeting2")
    private WebElement pro;

    public BillingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void payMonthly() throws InterruptedException {

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
        Thread.sleep(5000);
        this.billmonthly.click();

        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",pro);

        Thread.sleep(5000);


    }


}
