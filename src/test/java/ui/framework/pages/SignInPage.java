package ui.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = ".signin>button")
    private WebElement submitBtn;


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SignInPage typeEmail(String email){
        this.email.sendKeys(email);
        return this;
    }

    public SignInPage typePassword(String pass){
        this.password.sendKeys(pass);
        return this;
    }

    public void clickSignIn(){
        this.submitBtn.click();
    }

    public SignInPage clearForm(){
        this.email.clear();
        this.password.clear();
        return this;
    }
}
