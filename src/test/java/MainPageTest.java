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

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
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
    
    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (! result.isSuccess()) {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
            String name = format.format(date)+".png";

            try {
                FileUtils.copyFile(screen,new File("/home/evgeniy/Pictures/dev_mato"+name));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        driver.quit();
    }


}
