package IdunnoRandom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo1_test {
    @Test(groups = "methods")
    public void m1(){
        System.out.println("Method First Processing....");
    }

    @Test(groups = {"methods","law"})
    public void m2(){
        System.out.println("Method Second Processing with Law....");
    }

    @Test(groups = "methods")
    public void m3(){
        System.out.println("Method Third Processing....");
    }

    @Test(groups = "laws")
    public void l1(){
        System.out.println("Law First Processing....");
    }

    @Test(groups = {"laws","methods"})
    public void l2(){
        System.out.println("Law Second Processing with Methods..");
    }

    @Test(groups = "laws")
    public void l3(){
        System.out.println("Law Third Processing..");
    }

    //@Parameters({"URL"})
    @Test
    public void clickverify(){
        WebDriverManager.operadriver().setup();
        WebDriver driver = new OperaDriver();
        driver.get("https://demo.opencart.com/");
        System.out.println("System2 starts processing");
        driver.findElement(By.xpath("//span[@class='caret']")).click();
        driver.findElement(By.linkText("Login")).click();
        boolean x = driver.findElement(By.linkText("Login")).isDisplayed();
        Assert.assertTrue(x);
        System.out.println("Login Test Case Passed");
        driver.quit();
    }
}
