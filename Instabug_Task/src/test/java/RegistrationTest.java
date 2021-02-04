import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegistrationTest {

    public WebDriver driver ;
    //This function Setup Chrome browser and navigate to url and maximize browser
    @BeforeTest
    public void Setup() {
        System.setProperty("webdriver.chrome.driver",utils.CHROME_LOCATION);
        driver = new ChromeDriver();
        driver.get(utils.BASE_URL);
        driver.manage().window().maximize();
    }
    //This testcase register user but from inside code to test with functions are performing correctly
    @Test
    public void Register_new_user_valid() throws IOException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.ClickOnCreateButton();
        registrationPage.SetFirstname();
        registrationPage.SetLastname();
        registrationPage.SetEmail();
        registrationPage.SetConfirmEmail();
        registrationPage.SetPassword();
        registrationPage.SetDate();
        registrationPage.SetGender();
        registrationPage.ClickOnSignUpButton();
    }
    //This testcase register a valid user by using excel data
    @Test
    public void Register_new_user_valid_using_excel() throws IOException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.ClickOnCreateButton();
        registrationPage.ReadExcelAndRegister();
        registrationPage.SetDate();
        registrationPage.SetGender();
        registrationPage.ClickOnSignUpButton();
    }
    //This function close browser
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
