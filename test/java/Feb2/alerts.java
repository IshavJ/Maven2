package Feb2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class alerts {
    public WebDriver driver;
    public WebDriver m;
    public WebElement x;
    @BeforeSuite(enabled = true)
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
    }
    @Test(enabled = false)
    public void jsnormal() throws InterruptedException {
        x = driver.findElement(By.linkText("JavaScript Alerts"));
        x.click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
    @Test(enabled = false)
    public void jsConfirm()throws InterruptedException{
        x = driver.findElement(By.linkText("JavaScript Alerts"));
        x.click();
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
    }
    @Test(enabled = false)
    public void jsConfirm1()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        m = new ChromeDriver();
        m.get("C:\\Users\\hello world\\Downloads\\Confirmation.html");
        m.manage().window().maximize();
        m.findElement(By.xpath("//button[text()='Click on me']")).click();
        Thread.sleep(1000);
        //System.out.println();
        //m.switchTo().alert().getText();
        System.out.println(m.switchTo().alert().getText());
        //driver.switchTo().alert().accept();
        m.switchTo().alert().dismiss();
    }
    @Test(enabled = false)
    public void jsPrompt()throws InterruptedException{
        x = driver.findElement(By.linkText("JavaScript Alerts"));
        x.click();
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("Oye Nigga");
        System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
    }
    @Test(enabled = true)
    public void basicAuth() throws InterruptedException {
        x = driver.findElement(By.linkText("Basic Auth"));
        x.click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("admin");
//        driver.switchTo().alert().sendKeys("admin");
        driver.switchTo().alert().accept();
    }
    @AfterSuite
    public void term() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
