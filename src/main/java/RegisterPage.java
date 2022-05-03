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
    By namaRegPage = By.xpath("//h1");
    By phoneError = By.xpath("//span[@id=\"elm_9_error_message\"]");
    By emailError = By.xpath("//span[@id=\"email_error_message\"]");
    By password1Error = By.xpath("//span[@id=\"password1_error_message\"]");
    By password2Error = By.xpath("//span[@id=\"password2_error_message\"]");



    public RegisterPage typeFields(String name, String last, String phone, String email, String password) {

        driver.findElement(firstNameField).sendKeys(name);
        driver.findElement(lastNameField).sendKeys(last);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(PhoneField).sendKeys(phone);
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

    public String successfullyPage() {
        return driver.findElement(namaRegPage).getText();
    }

    public String requiredPhone() {
        return driver.findElement(phoneError).getText();

    }

    public String requiredEmail() {
        return driver.findElement(emailError).getText();

    }

    public String requiredPassword1() {
        return  driver.findElement(password1Error).getText();

    }

    public String requiredPassword2() {
        return  driver.findElement(password2Error).getText();

    }

}

