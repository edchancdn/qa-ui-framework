package ui.framework.testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.framework.data.LoginProvider;
import ui.framework.drivermanager.DriverManager;
import ui.framework.pages.BillingPage;
import ui.framework.pages.InformationPage;
import ui.framework.pages.MenuPage;
import ui.framework.pages.SignInPage;
import ui.framework.util.Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ZoomHomeTest {
    //private By pribyBtnId = By.cssSelector("#onetrust-close-btn-container>button");
    WebDriver driver ;
    WebDriverWait wait;
    //FluentWait<WebDriver> wait;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://zoom.us");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         wait=new WebDriverWait(driver,Duration.ofSeconds(10));
       // wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1))
               // .ignoring(NoSuchElementException.class);

    }

    @Test(enabled = false)
    public void testCookies() {
        WebElement difference = driver.findElement(By.id("Difference"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", difference);

        driver.findElement(By.className("btn_accept_ck")).click();
        WebElement cta__demo__btn = driver.findElement(By.className("cta__demo__btn"));
        wait.until(ExpectedConditions.elementToBeClickable(cta__demo__btn)).click();

        //driver.findElement(By.id("skdhdhjhd"));
    }

    @Test
    public void testInvisility(){
        //signupfree
        By signBtnId = By.id("signupfree");
        ((JavascriptExecutor) driver).executeScript("setTimeout(function(){$('#signupfree').hide()},5000)");
        WebElement element = driver.findElement(signBtnId);
        wait.until(ExpectedConditions.invisibilityOf(element));
        Assert.assertFalse(element.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("setTimeout(function(){$('#signupfree').show()},5000)");
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("setTimeout(function(){ $('ul[aria-label=\"meetings\"]').append('<li id=\"atin\"><button>Hello</button></li>');},15000)");
        WebElement atin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#atin>button")));
        Assert.assertEquals(atin.getText(),"Hello");
    }


    @Test(dataProvider = "loginProvider", dataProviderClass = LoginProvider.class)
    public void testPageObject(String user, String pass) throws InterruptedException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickMeetinLink();
        SignInPage signInPage = menuPage.clickSignIn();
        signInPage.typeEmail(user).typePassword(pass);
        Thread.sleep(5000);
        signInPage.clearForm();


    }

    @Test
    public void testPageObject1() throws InterruptedException {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickMeetinLink();
        menuPage.clickOnPlans();
        menuPage.clickContactSales().type_email("sukhi@gmail.com").typeCompany("xyz").typeFirstName("sukhvinder")
                .typeLastName("kaur").employee_count().typePhone("7801020267")
                .selectCountry().selectState().typeZip("23476555").typeDescription("hello");

        menuPage.clickResources();
        //menuPage.clickOnJoin();
        menuPage.clickById().typeMeetingId("123456789").clickSubmit().testAlert();

        menuPage.clickSignIn().typeEmail("atin@pragra.com").typePassword("P@ssw0rd90").clickSignIn();


        Utils.captureScreenShot(driver,"PageObjectTest", true);
        Utils.captureScreenShot(driver,"PageObjectTest", false);



    }

    @Test(enabled = false)
    public void testAlert() {
        ((JavascriptExecutor) driver).executeScript("setTimeout(function(){alert('hello')},5000)");
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("alert.getText() = " + alert.getText());
        alert.dismiss();

    }

    @AfterMethod
    public void tearDown() {
        try {

            Thread.sleep(5000);
        } catch (InterruptedException e) {
           // throw new RuntimeException(e);
        }
        DriverManager.quitDriver();
    }
}
