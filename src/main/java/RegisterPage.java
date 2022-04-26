import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstNameField = By.xpath("//input[@id=\"elm_6\"]");
    By lastNameField = By.xpath("//input[@id=\"elm_7\"]");
    By PhoneField = By.xpath("//input[@id=\"elm_9\"]");
    By emailField = By.xpath("//input[@id=\"email\"]");
    By passwordField = By.xpath("//input[@id=\"password1\"]");
    By confirmPasswordField = By.xpath("//input[@id=\"password2\"]");
    By registerButton = By.xpath("//button[@class=\"ty-btn__secondary ty-btn\"]");
    By namePage = By.xpath("//h1");

    public RegisterPage typeFields(String name, String last, String phone, String email, String password) {

        driver.findElement(firstNameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(last);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        return this;

    }

    public void submitForm() {
        driver.findElement(registerButton).click();
    }

    public String geth1() {
        return driver.findElement(namePage).getText();
    }
}

