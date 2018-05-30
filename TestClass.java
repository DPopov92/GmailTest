import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TestClass {
    static LoginPage loginPage;
    static GmailPage gmailPage;
    static LetterPage letterPage;
    private static WebDriver driver;
    private String email = "test@gmail.com";
    private String pass = "test";
    private String url = "http://www.gmail.com";

    @BeforeClass
    public static void initial() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/geckodriver-v0.20.1-win64/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        gmailPage = PageFactory.initElements(driver, GmailPage.class);
        letterPage = PageFactory.initElements(driver, LetterPage.class);
    }


    @Test
    public void testMessage() {
        loginPage.open(driver, url);
        loginPage.login(driver, email, pass);
        gmailPage.sendMessage(email);
        driver.quit();

        initial();
        loginPage.open(driver, url);
        loginPage.login(driver, email, pass);
        gmailPage.checkEmail(driver);
        Assert.assertEquals(email, letterPage.getFirstEmail());

    }
}
