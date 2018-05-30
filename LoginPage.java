import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "identifierId")
    private WebElement loginInput;
    @FindBy(id = "identifierNext")
    private WebElement loginNext;
    @FindBy(name = "password")
    private WebElement passInput;
    @FindBy(id = "passwordNext")
    private WebElement passNext;


    public void login(WebDriver driver, String email, String pass) {
        loginInput.sendKeys(email);
        loginNext.click();
        wait(driver, passInput);
        passInput.sendKeys(pass);
        passNext.click();
    }

}
