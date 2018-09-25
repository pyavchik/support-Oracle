import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest {
    private WebDriver driver;
    private By signupBtn = By.cssSelector(ta(   "signupBtn"));
    private By createAccountBtn = By.cssSelector(ta(   "createAccountBtn"));
    private By emailFld = By.cssSelector(ta(   "emailFld"));
    private By passFld = By.cssSelector(ta(   "passFld"));
    private By retypePassFld = By.cssSelector(ta(   "retypePassFld"));
    private By countryDropDwn = By.cssSelector(ta(   "countryDropDwn"));
    //private By uruguaycountryBtn = By.cssSelector(ta(   "uruguaycountryBtn"));
    private By nameFld = By.cssSelector(ta(   "nameFld"));
    private By lastNameFld = By.cssSelector(ta(   "lastNameFld"));
    private By jobTitleFld = By.cssSelector(ta(   "jobTitleFld"));
    private By phoneNumberFld = By.cssSelector(ta(   "phoneNumberFld"));
    //private By email = byTa("ta:loinPage:emailField");

    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() throws InterruptedException {
        driver.get("https://support.oracle.com");

        driver.findElement(signupBtn).click();
        driver.findElement(createAccountBtn).click();
        driver.findElement(emailFld).sendKeys("email@email.com");
        driver.findElement(passFld).sendKeys("Pa$sw0rd");
        driver.findElement(retypePassFld).sendKeys("Pa$sw0rd");

        WebElement element = driver.findElement(By.id("country::content"));
        Select sel = new Select(element);
        Thread.sleep(2000);
		    sel.selectByValue("AT");

        driver.findElement(nameFld).sendKeys("name");
        driver.findElement(lastNameFld).sendKeys("lastNameFld");
        driver.findElement(jobTitleFld).sendKeys("jobTitleFld");
        driver.findElement(phoneNumberFld).sendKeys("380639977874");
        Thread.sleep(10000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
