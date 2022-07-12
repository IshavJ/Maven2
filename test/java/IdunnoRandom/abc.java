package IdunnoRandom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class abc {
    public WebDriver driver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.get("https://www.orangehrm.com/");
        //will maximize the size.
        driver.manage().window().maximize();
        //implicit will work over the whole code and is defined in one piece of code...
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void main(){
        driver.findElement(By.className("nav-logo")).click();
    }

    @Test(enabled = false,priority = 1)
    public void Lang(){
        driver.findElement(By.linkText("ES")).click();
        driver.navigate().back();
        System.out.println("Language Feature Tested..");
    }

    @Test(enabled = true,priority = 1)
    public void EmailSet(){
        //driver.findElement(By.id("myText")).sendKeys("abc@gmail.com");
        driver.findElement(By.className("home-tril-email-btn")).click();
        driver.findElement(By.id("Form_submitForm_subdomain")).sendKeys("hardeep007");
        driver.findElement(By.id("Form_submitForm_Name")).sendKeys("abcD");
        driver.findElement(By.id("Form_submitForm_Email")).sendKeys("abc@com.com");
        driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("1234567890");
        driver.findElement(By.id("Form_submitForm_Country")).sendKeys("america");
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']")).click();
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        System.out.println("Language Feature Tested..");
    }

    @Test
    public void LearnMore(){
        driver.findElement(By.xpath("//button[text()='Learn More']")).click();
    }

    @AfterSuite
    public void termi() {
        driver.quit();
        System.out.println("The End...");
    }
}
