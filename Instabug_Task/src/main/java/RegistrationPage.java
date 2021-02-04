import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    WebDriver driver;
    WebDriverWait wait;
    Select selectDL;
    WebElement _createNewAccountButton;
    WebElement _firstname;
    WebElement _lastname;
    WebElement _email;
    WebElement _confirmEmail;
    WebElement _password;
    WebElement _day;
    WebElement _month;
    WebElement _year;
    WebElement _male;
    WebElement _signUpButton;

    //Class constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    //This function is to set Firstname in Sign Up Popup
    public void SetFirstname() {
        _firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
        _firstname.sendKeys("test");
    }
    //This function is to set Lastname in Sign Up Popup
    public void SetLastname() {
        _lastname = driver.findElement(By.name("lastname"));
        _lastname.sendKeys("test");
    }
    //This function is to Click on Create Account Button
    public void ClickOnCreateButton() {
        _createNewAccountButton = driver.findElement(By.id("u_0_2"));
        _createNewAccountButton.click();
    }
    //This function is to set Email in Sign Up Popup
    public void SetEmail() {
        _email= driver.findElement(By.name("reg_email__"));
        _email.sendKeys("test@test.com");
    }
    //This function is to set ConfirmEmail in Sign Up Popup
    public void SetConfirmEmail() {
        _confirmEmail= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));
        _confirmEmail.sendKeys("test@test.com");
    }
    //This function is to set Password in Sign Up Popup
    public void SetPassword() {
        _password= driver.findElement(By.id("password_step_input"));
        _password.sendKeys("test1234");
    }
    //This function is to set Date in Sign Up Popup
    public void SetDate() {
        _day = driver.findElement(By.name("birthday_day"));
        selectDL = new Select(_day);
        selectDL.selectByValue("10");
        _month = driver.findElement(By.name("birthday_month"));
        selectDL = new Select(_month);
        selectDL.selectByValue("12");
        _year = driver.findElement(By.name("birthday_year"));
        selectDL = new Select(_year);
        selectDL.selectByValue("1992");
    }
    //This function is to set Gender in Sign Up Popup
    public void SetGender() {
        _male = driver.findElement(By.xpath("//input[@value='2']"));
        _male.click();
    }
    //This function is to Click on Sign Up Button
    public void ClickOnSignUpButton() {
        _signUpButton = driver.findElement(By.name("websubmit"));
        _signUpButton.click();
    }
    //This function mainly reads data from Excel and send these data to WebElements
    public void ReadExcelAndRegister() throws IOException {
        //Create an object of File class to open xls file
        File file = new File(utils.EXCEL_PATH);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        //creating workbook instance that refers to .xls file
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        //creating a Sheet object
        HSSFSheet sheet = wb.getSheet("User_Data");
        //get all rows in the sheet
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        _firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
        _lastname = driver.findElement(By.name("lastname"));
        _email = driver.findElement(By.name("reg_email__"));
        _password = driver.findElement(By.id("password_step_input"));
        _day = driver.findElement(By.name("birthday_day"));
        _month = driver.findElement(By.name("birthday_month"));
        _year = driver.findElement(By.name("birthday_year"));
            for (int i = 1; i <= rowCount; i++) {
                //Enter the values read from Excel in _firstname,_lastname,_email,_confirmEmail,_password
                _firstname.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
                _lastname.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
                _email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
                _confirmEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));
                _confirmEmail.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
                _password.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
                HSSFCell cell = sheet.getRow(i).createCell(5);
                cell.setCellValue("Entered");
            }
            FileOutputStream outputStream = new FileOutputStream(utils.EXCEL_PATH);
            wb.write(outputStream);
        }
}