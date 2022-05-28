package ui.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class InformationPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "company")
    private WebElement company;
    @FindBy(id = "first_name")
    private WebElement first_name;
    @FindBy(id = "last_name")
    private WebElement last_name;
    @FindBy(id = "employee_count")
    private WebElement employee_count;
    @FindBy(id = "phone")
    private WebElement phone;
    @FindBy(id = "country")
    private WebElement country;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(id = "city")
    private WebElement zip;
    @FindBy(id = "description")
    private WebElement description;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    public InformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public InformationPage type_email(String email) {
        this.email.sendKeys(email);
       // wait.until(ExpectedConditions.elementToBeClickable(By.id(email)));
        return this;
    }

    public InformationPage typeCompany(String company) {
        this.company.sendKeys(company);
        return this;
    }

    public InformationPage typeFirstName(String first_name) {
        this.first_name.sendKeys(first_name);
        return this;
    }

    public InformationPage typeLastName(String last_name) {
        this.last_name.sendKeys(last_name);
        return this;
    }

    public InformationPage employee_count() throws InterruptedException {
       dropDown(employee_count,"51-250");
       Thread.sleep(2000);
        //wait.until(ExpectedConditions.elementToBeClickable(employee_count));
        return new InformationPage(driver);
    }

    public InformationPage typePhone(String phone) {
        this.phone.sendKeys(phone);
        return this;
    }

    public InformationPage selectCountry() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("country")));
        dropDown(country,"Canada");
        Thread.sleep(2000);
        return new InformationPage(driver);
    }

    public InformationPage selectState() throws InterruptedException {
        dropDown(state,"Alberta");
        Thread.sleep(2000);
        return new InformationPage(driver);
    }

    public InformationPage typeZip(String zip) {
        this.zip.sendKeys(zip);
        return this;
    }

    public InformationPage typeDescription(String description) throws InterruptedException {
        this.description.sendKeys(description);
        Thread.sleep(2000);
        return this;
    }

    public void dropDown(WebElement element, String value) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(value);
    }

}
