package Feb3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginVal_via_Prop {
    public WebDriver x;
    public Properties prop;
    public String user;
    public String pass;
    public String url;

    @BeforeSuite
    public void set() throws IOException {
        WebDriverManager.chromedriver().setup();
        x=new ChromeDriver();
        prop = new Properties();
        FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Feb3//tstdta.properties");
        prop.load(f);
        url = prop.getProperty("url1");
        x.get(url);
    }
    @Test(priority = 1)
    public void val_login(){
        x.findElement(By.linkText("My Account")).click();
        x.findElement(By.linkText("Login")).click();
        user = prop.getProperty("user");
        pass = prop.getProperty("pass");
        x.findElement(By.name("email")).sendKeys(user);
        x.findElement(By.name("password")).sendKeys(pass);
    }
    @Test(priority = 2,dependsOnMethods = {"val_login"})
    public void otherValData(){
        System.out.println(x.findElement(By.name("email")).getAttribute("value"));
        System.out.println(x.findElement(By.name("password")).getAttribute("value"));
    }
    @Test(priority = 3,dependsOnMethods = {"otherValData"})
    public void tstdataconf(){
        if(user.equals(x.findElement(By.name("email")).getAttribute("value"))&&
                pass.equals(x.findElement(By.name("password")).getAttribute("value"))){
            System.out.println("TestCase Passed..");
        }
        else{
            System.out.println("One or Both Failed..");
        }
    }
    @Test(priority = 4)
    public void confirm() throws InterruptedException {
        Thread.sleep(2000);
        x.findElement(By.xpath("//input[@value='Login']")).click();
    }
    @AfterSuite
    public void over() throws InterruptedException {
        Thread.sleep(1000);
        x.quit();
    }
}
