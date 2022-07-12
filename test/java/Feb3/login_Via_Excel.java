package Feb3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class login_Via_Excel {
    public WebDriver x;
    public XSSFWorkbook w;
    public XSSFSheet s;
    public String test, user, pass;
    public FileInputStream f;
    public FileOutputStream op;

    @BeforeSuite
    public void set() {
        WebDriverManager.chromedriver().setup();
        x = new ChromeDriver();
        x.get("https://demo.opencart.com/");
        x.findElement(By.linkText("My Account")).click();
        x.findElement(By.linkText("Login")).click();
    }

    @BeforeSuite
    public void excelSet() throws IOException {
        f = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//Feb3//tstdta1.xlsx");
        w = new XSSFWorkbook(f);
        s = w.getSheetAt(0);
        System.out.println(test = s.getRow(1).getCell(0).toString());
        System.out.println(user = s.getRow(1).getCell(1).toString());
        System.out.println(pass = s.getRow(1).getCell(2).toString());
    }

    @Test(priority = 1)
    public void testMain() throws InterruptedException, IOException {
        if (test.equals("tc1")) {
            x.findElement(By.name("email")).sendKeys(user);
            x.findElement(By.name("password")).sendKeys(pass);
            x.findElement(By.xpath("//input[@value='Login']")).click();
            Thread.sleep(1000);
            boolean b = x.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed();
            if(b){
                System.out.println("Successfully implemented...");
                s.getRow(1).getCell(3).setCellValue("Login Functionality implemented with invalid password...");
                op = new FileOutputStream(System.getProperty("user.dir") + "//src//test//java//Feb3//tstdta1.xlsx");
                w.write(op);
                op.close();
            }
            else{
                System.out.println("Task Failed Successfully");
            }
        } else {
            System.out.println("Following testCase not found...");
            s.getRow(1).getCell(3).setCellValue("Failed : Login Functionality implemented with invalid password...");
            op = new FileOutputStream(System.getProperty("user.dir") + "//src//test//java//Feb3//tstdta1.xlsx");
            w.write(op);
            op.close();
        }
    }
//    @Test(priority = 2,dependsOnMethods = {"testMain"})
//    public void addingStat() throws IOException {
//        s.getRow(1).getCell(3).setCellValue("Login Functionality implemented with invalid password...");
//        op = new FileOutputStream(System.getProperty("user.dir") + "//src//test//java//Feb3//tstdta1.xlsx");
//        w.write(op);
//        op.close();
//    }
    @AfterSuite
    public void over() throws InterruptedException {
        Thread.sleep(1000);
        x.quit();
    }
}
