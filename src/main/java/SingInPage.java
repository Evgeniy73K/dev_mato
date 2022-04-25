import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingInPage {
    private WebDriver driver;

    public SingInPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.xpath("//input[@id=\"login_main_login\"]");
    By passwordField = By.xpath("//input[@id=\"psw_main_login\"]");
    By singInButton = By.xpath("//div[@class=\"buttons-container clearfix\"]//button");
    By heading = By.xpath("//h1");
    public SingInPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SingInPage typePassword(String password) {
        driver.findElement(emailField).sendKeys(password);
        return this;
    }

    public SingInPage singIn(String email, String password){
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(singInButton).click();
        return new SingInPage(driver);
    }

    public SingInPage getHeading() {
        String h1 = driver.findElement(heading).getText();
        return new SingInPage(driver);
    }
}
