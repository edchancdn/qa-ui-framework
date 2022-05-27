package ui.framework.pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    private WebDriver driver;

    @FindBy(id = "btnSolutions")
    @CacheLookup
    private WebElement solution;

    @FindBy(css = "#first-col-nav ul >li:nth-child(1)")
    private WebElement meetingLink;

    @FindBy(css = "#navbar .signin>a")
    private WebElement signIn;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MeetingPage clickMeetinLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(solution).pause(1000).moveToElement(meetingLink).build().perform();
        return new MeetingPage(driver);
    }

    public SignInPage clickSignIn(){
        this.signIn.click();
        return new SignInPage(driver);
    }

}
