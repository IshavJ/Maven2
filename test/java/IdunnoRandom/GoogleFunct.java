package IdunnoRandom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleFunct {
        public static void main(String args[]) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");  //Getting URL..

            //Identification of OBJECT...
            //'send keys 'send values in the field mentioned here...
            driver.findElement(By.name("q")).sendKeys("testing{Enter}");
            Thread.sleep(5000);
//            driver.findElement(By.name("btnK")).click();
            //driver.quit();

        }
    }

