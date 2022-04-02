package TestsAnketa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class WebDriverSettings {


    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static WebElement element;

    @BeforeSuite
    public void setUp () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);


    }

    @AfterSuite
    public void getDown () {
        driver.quit();
    }

}
