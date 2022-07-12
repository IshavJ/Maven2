package Feb1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandling {
    public WebDriver driver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.get("https://the-internet.herokuapp.com");
        //will maximize the size.
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Multiple Windows")).click();
    }

    @Test(enabled = true,priority = 1)
    public void winHandle() {
        driver.findElement(By.linkText("Click Here")).click();
        //using function to get the current window...
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        //To get the multiple Windows...
        Set<String> child = driver.getWindowHandles();
        //To interate through multiple windows..
        Iterator<String> i = child.iterator();
        while(i.hasNext()){
            if(parent!=i.next()){
                driver.switchTo().window(i.next());
                System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
                driver.switchTo().window(parent);
            }
        }
        System.out.println("Done testing with WindowHandling...");
        driver.navigate().back();
    }
}
