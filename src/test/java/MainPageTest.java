import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://dev.cart-power.com/vnavolykin/mato.uz/?store_access_key=key_value");
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkRegisterButton(){
        mainPage.accountDropDownListClick();
        RegisterPage registerPage = mainPage.registerPage();
        String heading = registerPage.geth1();
        Assert.assertEquals("Register for a new account", heading);

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
