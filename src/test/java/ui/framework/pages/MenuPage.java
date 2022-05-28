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
    private Actions actions ;

    @FindBy(id = "btnSolutions")
    @CacheLookup
    private WebElement solution;

    @FindBy(css = "#first-col-nav ul >li:nth-child(1)")
    private WebElement meetingLink;

    @FindBy(className ="top-pricing")
    private WebElement plans;


    @FindBy(xpath = "//a[contains(text(),'Contact Sales')]")
    private WebElement contactSales;

    @FindBy(id = "btnResources")
    private WebElement resources;

    @FindBy(id ="btnJoinMeeting")
    private WebElement join;
    @FindBy(xpath = "//a[text()='Join by Meeting ID']")
    private WebElement joinById;


    @FindBy(css = "#navbar .signin>a")
    private WebElement signIn;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.actions=new Actions(driver);
    }

    public MeetingPage clickMeetinLink(){
        actions.moveToElement(solution).pause(1000).moveToElement(meetingLink).build().perform();
        return new MeetingPage(driver);
    }

    public BillingPage clickOnPlans()
    {
        this.plans.click();
        return new BillingPage(driver);
    }
    public InformationPage clickContactSales(){
        this.contactSales.click();
        return new InformationPage(driver);

    }
    public MenuPage clickResources(){
        this.resources.click();
       // actions.moveToElement(resources).build().perform();
        return new MenuPage(driver);
    }
//    public Join clickOnJoin(){
//        this.join.click();
//        return new Join(driver);
//
//    }
    public JoinMeeting clickById()
    {
        this.join.click();
        this.joinById.click();
        return new JoinMeeting(driver);
    }

    public SignInPage clickSignIn(){
        this.signIn.click();
        return new SignInPage(driver);
    }

}
