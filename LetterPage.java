import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends BasePage {
    @FindBy(xpath = "//span[@class='gD']")
    private WebElement firstEmail;

    public String getFirstEmail() {
        return firstEmail.getAttribute("email");
    }
}
