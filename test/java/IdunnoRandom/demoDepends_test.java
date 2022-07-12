package IdunnoRandom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class demoDepends_test {
    public WebDriver driver;

    @Parameters({"browser","URL"})
    @BeforeClass
    public void begin(String name , String link){
        if(name.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get(link);
        System.out.println("Setup Processing just finished..");
    }

    @Test
    public void add(){
        System.out.println("Addition function..");
    }

    @Test(dependsOnMethods = {"add"})
    public void multi(){
        System.out.println("Working if addition occurs");
    }

    @AfterClass
    public void ending(){
        driver.quit();
        System.out.println("Ending of Program..");
    }
}
