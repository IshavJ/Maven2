package jan21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;

public class auto_reg {
    public WebDriver driver;
    public void webwork(String a, String b, String c, String d, String e, String g) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Continue")).click();
        //Entered new Page..
        driver.findElement(By.name("firstname")).sendKeys(a);
        driver.findElement(By.name("lastname")).sendKeys(b);
        driver.findElement(By.name("email")).sendKeys(c);
        driver.findElement(By.name("telephone")).sendKeys(d);
        driver.findElement(By.name("password")).sendKeys(e);
        driver.findElement(By.name("confirm")).sendKeys(g);
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.quit();
    }

    public void login(String a, String b) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.findElement(By.linkText("My Account")).click();
        //Entered new Page..
        driver.findElement(By.name("email")).sendKeys(a);
        driver.findElement(By.name("password")).sendKeys(b);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.quit();
    }

    public static void main(String args[]) throws IOException {
        auto_reg ar = new auto_reg();
        //File creation..
        File f = new File("./reg_code.txt");
        f.createNewFile();
        //Adding details..
        FileWriter fw = new FileWriter("./reg_code.txt");
        fw.write("Ishav\n");fw.write("Jnagal\n");
        fw.write("hehe@gmail.com\n");fw.write("1234567890\n");
        fw.write("1234\n");fw.write("1234");
        fw.close();
        //Reading data...
        FileReader fr = new FileReader("./reg_code.txt");
        BufferedReader br = new BufferedReader(fr);
        String a = br.readLine();String b = br.readLine();
        String c = br.readLine();String d = br.readLine();
        String e = br.readLine();String g = br.readLine();
        br.close();
        ar.webwork(a,b,c,d,e,g);
        ar.login(c,e);
    }
}