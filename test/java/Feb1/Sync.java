package Feb1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Sync {
    public WebDriver driver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.get("https://the-internet.herokuapp.com");
        //will maximize the size.
        driver.manage().window().maximize();
        //implicit will work over the whole code and is defined in one piece of code...
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Dynamic Loading")).click();
    }

    @Test(enabled = true,priority = 1)
    public void stctwt() throws InterruptedException {
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        Thread.sleep(6000);
        System.out.println(driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText());
        System.out.println("Done testing with Static Wait...");
        driver.navigate().back();
    }

    @Test(enabled = true,dependsOnMethods = {"stctwt"})
    public void impliwt(){
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        System.out.println(driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText());
        System.out.println("Done testing with Implicit Wait...");
        driver.navigate().back();
    }

    @Test(enabled = true,dependsOnMethods = {"impliwt"})
    public void explwt(){
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //WebDriverWait is used to perform explicitWait , is formed into object and takes driver and time as arguments.
        WebDriverWait wt = new WebDriverWait(driver,15);
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        System.out.println(driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText());
        System.out.println("Done testing with Explicit Wait...");
        driver.navigate().back();
    }

    @AfterSuite
    public void termi() {
        driver.quit();
        System.out.println("The End...");
    }
}