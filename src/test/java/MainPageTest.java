import junit.framework.TestResult;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runners.model.TestClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class MainPageTest extends Settings{

    @Test
    public void checkRegisterButton(){
        mainPage.accountDropDownListClick();
        RegisterPage registerPage = mainPage.registerPage();
        String heading = registerPage.geth1();
        Assert.assertEquals("Register for a new account", heading);
    }

    @Test
    public void possitiveRegistrationTest() {
        mainPage.accountDropDownListClick();
        RegisterPage registerPage = mainPage.registerPage();
        registerPage.typeFields("Evgeniy", "Karabaev", "+79051839298", "test@yandex.ru", "123456");
        registerPage.submitForm();
        String succesRegistation = registerPage.successfullyPage();
        Assert.assertEquals("Successfully registered", succesRegistation);

    }

    @Test
    public void emptyFormRegistationTest() {
        mainPage.accountDropDownListClick();
        RegisterPage registerPage = mainPage.registerPage();
        registerPage.submitForm();
        String heading = registerPage.geth1();
        Assert.assertEquals("Register for a new account", heading);
        String phoneError = registerPage.requiredPhone();
        Assert.assertEquals("The Phone field is mandatory.", phoneError);
        String emailError = registerPage.requiredEmail();
        Assert.assertEquals("The E-mail field is mandatory.", emailError);
        String password1Error = registerPage.requiredPassword1();
        Assert.assertEquals("The Password field is mandatory.", password1Error);
        String password2Error = registerPage.requiredPassword2();
        Assert.assertEquals("The Confirm passwordrrr field is mandatory.", password2Error);




    }
    
}
