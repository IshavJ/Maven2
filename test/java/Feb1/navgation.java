package Feb1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class navgation {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        driver.get("https://the-internet.herokuapp.com");
        //will maximize the size.
        driver.manage().window().fullscreen();
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("CoronaBoss");
        Thread.sleep(3000);
        driver.findElement(By.name("btnK")).click();
        driver.navigate().back();
        driver.quit();
    }
}
