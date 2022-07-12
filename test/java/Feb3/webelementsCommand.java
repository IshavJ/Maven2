package Feb3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class webelementsCommand {
    public WebDriver x;
    public WebElement y;
    public TakesScreenshot m;
    @BeforeSuite
    public void set() {
        WebDriverManager.chromedriver().setup();
        x = new ChromeDriver();
        x.get("https://www.google.com");
        x.manage().window().maximize();
    }
    @Test(priority = 1)
    public void getattribute(){
        String attri = x.findElement(By.xpath("//img[@class='lnXdpd']")).getAttribute("alt");
        System.out.println(attri);
    }
    @Test(priority = 2)
    public void getCssSel(){
        String attri = x.findElement(By.xpath("//img[@class='lnXdpd']")).getCssValue("width");
        System.out.println(attri);
    }
    @Test(priority = 3)
    public void getText(){
        String attri = x.findElement(By.xpath("//div[text()='Google offered in:  ']")).getText();
        System.out.println(attri);
    }
    @Test(priority = 4)
    public void gettagName(){
        String attri = x.findElement(By.xpath("//div[text()='Google offered in:  ']")).getTagName();
        System.out.println(attri);
    }
    @Test(priority = 5)
    public void getScreenShot() throws IOException {
        try{
            x.findElement(By.xpath("//div[text(='Google offered in:  ']"));
        }
        catch(Throwable t){
            m=((TakesScreenshot) x);
            File f = m.getScreenshotAs(OutputType.FILE);
//        D:\Maven2\src\test\java\Feb3
            FileUtils.copyFile(f,new File(System.getProperty("user.div")+"//src//test//java//google-sample.png"));
//        WebElement z = x.findElement(By.xpath("//div[text()='Google offered in:  ']"));
        }
    }
    @AfterSuite
    public void over() throws InterruptedException {
        Thread.sleep(1000);
        x.quit();
    }
}
