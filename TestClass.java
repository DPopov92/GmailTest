import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TestClass {
    private static WebDriver driver;
    private String email = "lolmage92@gmail.com";
    private String pass = "476159831asd";
    private String url = "http://www.gmail.com";

    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
    LetterPage letterPage = PageFactory.initElements(driver, LetterPage.class);

    @BeforeClass
    public static void initialDriver() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/geckodriver-v0.20.1-win64/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    @Test
    public void testMessage() {
        loginPage.open(driver, url);
        loginPage.login(driver, email, pass);
        gmailPage.sendMessage(email);
        driver.quit();

        initialDriver();
        loginPage.open(driver,url);
        loginPage.login(driver,email,pass);
        gmailPage.checkEmail(driver);
        Assert.assertEquals(email, letterPage.getFirstEmail());

    }
}
