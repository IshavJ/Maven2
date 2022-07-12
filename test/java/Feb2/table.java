package Feb2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class table {
    public WebDriver driver;
    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("C:\\Users\\hello world\\Downloads\\WbTable.html");
        driver.manage().window().maximize();
    }
    @Test(priority = 1,enabled = false)
    public void rows(){
        System.out.println(driver.findElement(By.xpath("/html/body/table/tbody/tr")).getText());
    }
    @Test(priority = 2,enabled = true)
    public void allVal(){
        List<WebElement> row = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/th"));
        int a = row.size(); int b =columns.size();
        System.out.println(a); System.out.println(b);
        for(int i = 3;i<=a;i++){
            for(int j=1;j<=b;j++){
                System.out.println(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText());
            }
        }
    }
    @AfterSuite
    public void term() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
