package Feb2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Heroku2 {
    public WebDriver driver;
    @BeforeSuite
    public void set(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().fullscreen();
    }
//    @Test
//    public void wstuff() throws InterruptedException {
//        driver.findElement(By.linkText("WYSIWYG Editor")).click();
//        Thread.sleep(2000);
//        System.out.println(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']//p")).getText());
////        driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
////        Thread.sleep(1000);
////        driver.findElement(By.xpath("//p")).sendKeys("Ishavinder Singh");
////        driver.findElement(By.xpath("//span[text()='File']")).click();
////        Thread.sleep(1000);
////        driver.findElement(By.xpath("//div[text()='New document']")).click();
////        //driver.findElement(By.xpath("//body[@aria-label='Rich Text Area. Press ALT-0 for help.']")).sendKeys("Ishavinder Singh");
////        System.out.println(driver.findElement(By.tagName("p")).getText());
//    }
    @Test
    public void notif() throws InterruptedException {
        driver.findElement(By.linkText("Notification Messages")).click();
        driver.findElement(By.linkText("Click here")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Click here")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='flash notice']")).getText());
    }

    @AfterSuite
    public void term() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
