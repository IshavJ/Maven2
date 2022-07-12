package Feb1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class mouseControls {
    public WebDriver driver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.get("https://www.amazon.in");
        //will maximize the size.
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void mouseOver() throws InterruptedException {
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        WebElement x = driver.findElement(By.linkText("Mobiles"));
        act.moveToElement(x).build().perform();
        System.out.println("Done MoveOver...");
    }
    @Test(priority = 2)
    public void mouseClick(){
        Actions act = new Actions(driver);
        WebElement x = driver.findElement(By.linkText("Mobiles"));
        act.click(x).perform();
        System.out.println("Done with click part...");
    }
    @Test(priority = 3)
    public void moseClick2(){
        Actions act = new Actions(driver);
        WebElement x = driver.findElement(By.xpath("//span[@id='CardInstancehAkI99VoA8mb6YrOqc4SnQ'or text()='boAt Bassheads 100 in Ear Wired Earphones with Mic(Black)']"));
        act.doubleClick(x).perform();
        System.out.println("Done with Doubleclick part...");
    }
    @AfterSuite
    public void termi(){
        driver.quit();
        System.out.println("The End...");
    }
}
