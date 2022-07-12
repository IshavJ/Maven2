package Jan31.heroku;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.XmlAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import javax.swing.*;
import java.util.List;

public class auto {
    public WebDriver driver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.get("https://the-internet.herokuapp.com");
        //will maximize the size.
        driver.manage().window().maximize();
    }

//    @Test(enabled = true)
//    public void chckbutton(){
//        driver.findElement(By.linkText("Add/Remove Elements")).click();
//        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
////      driver.findElement(By.linkText("Add/Remove Element")).click();
//        driver.findElement(By.className("added-manually")).click();
//        System.out.println("Done testing with the button...");
//        driver.navigate().back();
//    }
//
//    @Test(enabled = true)
//    public void chckinput(){
//        driver.findElement(By.linkText("Inputs")).click();
//        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234");
//        System.out.println("Done testing inputField...");
//        driver.navigate().back();
//    }
//
//    @Test
//    public void chckboxes(){
//        driver.findElement(By.linkText("Checkboxes")).click();
//        //One method of performing the test on the checkboxes...
//        List<WebElement> x = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        //Other way..
//        WebElement y = driver.findElement(By.xpath("//input[@type='checkbox']"));
//        y.click();
//        System.out.println("Done testing chckboxes...");
//        driver.navigate().back();
//    }
//
//    @Test
//    public void chckAuth(){
//        driver.findElement(By.linkText("Basic Auth")).click();
////        //One method of performing the test on the checkboxes...
////        List<WebElement> x = driver.findElements(By.xpath("//input[@type='checkbox']"));
////        //Other way..
////        WebElement y = driver.findElement(By.xpath("//input[@type='checkbox']"));
////        y.click();
////        System.out.println("Done testing chckboxes...");
//        System.out.println("Basic authontication done..");
//        driver.navigate().back();
//    }
//
//    @Test
//    public void chckdropdwn(){
//        driver.findElement(By.linkText("Dropdown")).click();
//        Select s = new Select(driver.findElement(By.id("dropdown")));
//        //will select the 2nd element present in the menu including the non-selectable text.
//        s.selectByIndex(1);
//        s.selectByVisibleText("Option 1");
//        System.out.println("Done testing Dropdown...");
//        driver.navigate().back();
//    }

//    @Test
//    public void chckcontxtmenu(){
//        WebElement x =  driver.findElement(By.linkText("Context Menu"));
//        x.click();
//        Actions a = new Actions(driver);
//        WebElement y = driver.findElement(By.id("hot-spot"));
//        try{a.contextClick(y).perform();}
//        catch (Exception e){
//            System.out.println("Alert Occurs");
//        }
//        System.out.println("Done testing Dropdown...");
//        driver.navigate().back();
//    }

//    @Test
//    public void chckBrokenImg(){
//        driver.findElement(By.linkText("Broken Images")).click();
//        List <WebElement> x  =  driver.findElements(By.tagName("img"));
//        for(WebElement i : x){
//            System.out.println(i.getAttribute("src"));
//    System.out.println(i.getSize());
//            System.out.println(i.getText());
//        }
//    }

//    @Test
//    public void chckdispEle() {
//        driver.findElement(By.linkText("Disappearing Elements")).click();
////        List<WebElement> x = driver.findElements(By.tagName("ul"));
////        for (WebElement i : x) {
////            i.click();
////            driver.navigate().back();
////        }
//        driver.findElement(By.linkText("Home")).click();
//        driver.navigate().back();
//        driver.findElement(By.linkText("About")).click();
//        driver.navigate().back();
//        System.out.println("Done with Display Element");
//    }

//    @Test
//    public void chckdynmic() {
//        driver.findElement(By.linkText("Dynamic Content")).click();
//        driver.findElement(By.linkText("click here")).click();
//        driver.navigate().back();
//        System.out.println("Done with Dynamic Content");
//    }

//    @Test
//    public void chckDynamicControls() throws InterruptedException {
//        driver.findElement(By.linkText("Dynamic Controls")).click();
//        driver.findElement(By.xpath("//button[@type='button']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.linkText("Add")).click();
////        driver.findElement(By.linkText("Enable")).click();
////        Thread.sleep(700);
////        driver.findElement(By.linkText("Disable")).click();
////        driver.navigate().back();
//        System.out.println("Done with Display Element");
//    }

//    @Test
//    public void chckEntryAdd(){
//        driver.findElement(By.linkText("Entry Ad")).click();
//        driver.findElement(By.id("restart-ad")).click();
//        driver.findElement(By.tagName("p")).click();
//        System.out.println("Done with the ad Part..");
//        driver.navigate().back();
//    }

//    @Test
//    public void chckFloatingMenu() {
//        driver.findElement(By.linkText("Floating Menu")).click();
//        List<WebElement> y = driver.findElements(By.tagName("li"));
//        for (WebElement z : y) {
//            z.click();
//            driver.navigate().back();
//        }
//        driver.navigate().back();
//        System.out.println("Done with the ad Part..");
//    }

//    @AfterSuite
//    public void termi() {
//        driver.quit();
//        System.out.println("The End...");
//    }
}
