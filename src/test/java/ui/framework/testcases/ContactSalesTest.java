package ui.framework.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.framework.data.ContactSalesProvider;
import ui.framework.drivermanager.DriverManager;
import ui.framework.listeners.ScreenshotListener;
import ui.framework.pages.ContactSalesPage;
import ui.framework.report.HtmlReport;

import java.time.Duration;

@Listeners(ScreenshotListener.class)
public class ContactSalesTest {

    WebDriver driver ;
    WebDriverWait wait;
    ExtentTest report;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        report = HtmlReport.createTest("Contact Sales Test");
        driver.get("https://explore.zoom.us/en/contactsales/");
    }

    @Test(dataProvider = "contactSalesProvider", dataProviderClass = ContactSalesProvider.class)
    public void testContactSales(String firstName, String lastName, String company, String email) throws InterruptedException {
        ContactSalesPage contactSalesPage = new ContactSalesPage(driver);

        contactSalesPage.typeEmail(email).typeCompanyName(company).typeFirstName(firstName).typeLastname(lastName);
        report.log(Status.PASS, "Contact Sales Entry Succeeded");
        Thread.sleep(4000);
        contactSalesPage.clearForm();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        HtmlReport.flushReports();
    }
}
