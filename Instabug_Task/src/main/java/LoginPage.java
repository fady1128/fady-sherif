import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    WebElement _email;
    WebElement _password;
    WebElement _loginButton;
    WebElement _LoginText;

    //Class constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    //This function mainly reads data from Excel and send these data to WebElements
    public void ReadExcelAndLogin() throws IOException{
        File file = new File(utils.EXCEL_PATH);
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheet("Login_Users");
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        _email = driver.findElement(By.xpath("//input[@id='email']"));
        _password = driver.findElement((By.xpath("//input[@id='pass']")));
        for (int i = 1; i <= rowCount; i++) {
            _email.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
            _password.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
            HSSFCell cell = sheet.getRow(i).createCell(2);
            cell.setCellValue("Entered");
        }
        FileOutputStream outputStream = new FileOutputStream(utils.EXCEL_PATH);
        wb.write(outputStream);
    }
    //This function is to Click on Login Button
    public void ClickOnLoginButton(){
        _loginButton = driver.findElement(By.xpath("//button[@id='u_0_b']"));
        _loginButton.click();
    }
    //This function gets Login Text after successfull Login
    public String getLoginText(){
        _LoginText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql rrkovp55 a8c37x1j keod5gw0 nxhoafnm aigsh9s9 qg6bub1s fe6kdd0r mau55g9w c8b282yb iv3no6db o0t2es00 f530mmz5 hnhda86s oo9gr5id']")));
         return  _LoginText.getText();
    }
}
