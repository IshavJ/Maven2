package Feb3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class pickingProp {
    public static void main(String args[]) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Properties pop = new Properties();
        FileInputStream f = new FileInputStream("D:\\Maven2\\src\\test\\java\\Feb3\\tstdta.properties");
        pop.load(f);
        //System.out.println(pop.getProperty("url"));
        String x = pop.getProperty("url");
        driver.get(x);
        FileOutputStream z = new FileOutputStream("D:\\Maven2\\src\\test\\java\\Feb3\\tstdta.properties");
        pop.setProperty("sendval1","WorldWar1");
        pop.setProperty("sendval2","WorldAtWar");
        pop.store(z,"lolz");
//        String y = pop.getProperty("sendval");
//        WebElement search = driver.findElement(By.name("q"));
//        search.sendKeys(y);
//        Thread.sleep(1000);
//        driver.findElement(By.name("btnK")).click();
//        Thread.sleep(1000);
//        String m = driver.findElement(By.xpath("//span[text()='World War II']")).getText();
//        if(m.equals("World War II")){
//            System.out.println("Test Passed");
//        }
//        else {
//            System.out.println("Failed");
//        }
        Thread.sleep(1000);
        driver.quit();
    }
}
