package ui.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactSalesPage {

    WebDriver driver;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "company")
    private WebElement companyName;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "employee_count")
    private WebElement employeeCount;

    @FindBy(id = "phone")
    private WebElement phoneNumber;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement stateProvince;

    @FindBy(id = "city")
    private WebElement headqueartersZip;

    @FindBy(id = "description")
    private WebElement additionalInformation;

    @FindBy(css = "button[type='submit'] span")
    private WebElement submit;

    public ContactSalesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearForm() {
        email.clear();
        companyName.clear();
        firstName.clear();
        lastName.clear();
    }

    public ContactSalesPage typeEmail(String input){
        this.email.sendKeys(input);
        return this;
    }

    public ContactSalesPage typeCompanyName(String input){
        this.companyName.sendKeys(input);
        return this;
    }

    public ContactSalesPage typeFirstName(String input){
        this.firstName.sendKeys(input);
        return this;
    }

    public ContactSalesPage typeLastname(String input){
        this.lastName.sendKeys(input);
        return this;
    }




}
