import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.rmi.Remote;

import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) throws MalformedURLException {

        /*WebDriver driver;
        String nodeURL = " http://192.168.0.248:4444";
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS); */

        //ChromeOptions options = new ChromeOptions();
        //driver = new RemoteWebDriver(new URL(nodeURL),cap);
        //TEST GIT

        System.setProperty("webdriver.chrome.driver", "/Users/beren/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage();
        formPage.submitForm(driver);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.waitForAlertBanner(driver);

        assertEquals("The form was successfully submitted!", confirmationPage.getAlertBannerText(driver));

        //driver.quit();
    }
}
