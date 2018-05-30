import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailPage extends BasePage {

    @FindBy(xpath = "//div[text()='НАПИСАТЬ']")
    private WebElement writeButton;
    @FindBy(xpath = "//div[@aria-label='Тело письма']")
    private WebElement textField;
//        @FindBy(xpath = ".//div[text()='Получатели']")
    @FindBy(className = "vO")
    private WebElement adress;
    @FindBy(name = "subjectbox")
    private WebElement theme;
    @FindBy(xpath = "//div[text()='Отправить']")
    private WebElement send;
    @FindBy(xpath = "//*[@class='yW']/span")
    private List<WebElement> emailList;

    public void sendMessage(String email) {
        writeButton.click();
        theme.sendKeys("test");
        textField.sendKeys("testMessage");
        adress.sendKeys(email);
        send.click();
    }

    public LetterPage checkEmail(WebDriver driver) {
        emailList.get(0).click();
        return PageFactory.initElements(driver, LetterPage.class);
    }

}
