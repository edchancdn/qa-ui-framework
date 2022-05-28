package ui.framework.pages;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class JoinMeeting {
    WebDriver driver;
    WebDriverWait wait;
    //private WebElement joinById;
    @FindBy(css = "#join-form label+input")
    private WebElement meetindID;
    @FindBy(id = "btnSubmit")
    private WebElement submit;


    public JoinMeeting(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public JoinMeeting typeMeetingId(String meetindID) throws InterruptedException {
         Thread.sleep(5000);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#join-form label+input")));
        this.meetindID.sendKeys(meetindID);
        return this;
    }
    public JoinMeeting clickSubmit() throws InterruptedException {
        Thread.sleep(5000);
        this.submit.click();
        return this;
    }


    public void testAlert() {
        //Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
            }
}
