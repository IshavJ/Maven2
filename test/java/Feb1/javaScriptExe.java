package Feb1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

public class javaScriptExe {
    public WebDriver driver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.get("https://the-internet.herokuapp.com");
        //will maximize the size.
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void scrollDown() throws InterruptedException {
        Thread.sleep(7000);
        //Added the particular class for the required task..
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        System.out.println("Done Scrolling to down");
    }
    @Test(priority = 2,dependsOnMethods = {"scrollDown"})
    public void scrollTop() throws InterruptedException {
        Thread.sleep(7000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        System.out.println("Done Scrolling to top");
    }
    @Test(priority = 3)
    public void OpeningGoog() throws InterruptedException {
        Thread.sleep(7000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://www.google.com'");
        System.out.println("Done with New window..");
    }
    @AfterClass
    public void termi(){
        driver.quit();
        System.out.println("The End..");
    }
}