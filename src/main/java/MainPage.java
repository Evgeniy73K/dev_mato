import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By accountDropDownList = By.xpath("//a[@class=\"ac-title\"]");
    private By singInButtonPopup = By.xpath("//a[@class=\"cm-dialog-opener cm-dialog-auto-size ty-btn ty-btn__secondary\"]");
    private By registerButton = By.xpath("//a[@class=\"ty-btn ty-btn__primary\"]");
    private By singInButton = By.xpath("//a[text()=\"Sign in\"]");

    public void accountDropDownListClick() {
        driver.findElement(accountDropDownList).click();
    }




}
