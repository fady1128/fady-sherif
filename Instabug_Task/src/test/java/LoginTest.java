import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    public WebDriver driver ;
    String expected = "Welcome to Facebook, Mark";
    //This function Setup Chrome browser and navigate to url and maximize browser
    @BeforeTest
    public void Setup() {
        System.setProperty("webdriver.chrome.driver",utils.CHROME_LOCATION);
        driver = new ChromeDriver();
        driver.get(utils.BASE_URL);
        driver.manage().window().maximize();
    }
    //This testcase login a valid user by using excel data
    @Test
    public void Login_new_user_valid_using_excel() throws IOException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ReadExcelAndLogin();
        loginPage.ClickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginText(),expected);
    }
    //This function close browser
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
