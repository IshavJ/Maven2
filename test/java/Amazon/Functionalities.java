package Amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Functionalities {
    public WebDriver driver;
    public Boolean b;
    public WebDriverWait ww;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void login() {
        driver.findElement(By.name("email")).sendKeys("jnagalishav@gmail.com");
        try {
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.xpath("//div[@class='a-box-inner a-alert-container']")).isDisplayed();
        } catch (Throwable t) {
            System.out.println("Invalid Email");
            t.printStackTrace();
        }
        driver.findElement(By.name("password")).sendKeys("jnagalish@v1024");
        driver.findElement(By.id("signInSubmit")).click();
    }

    public void searching(String z) throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(z);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//span[text()='" + z + "']")).click();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.findElement(By.id("add-to-cart-button")).click();
            }
        }
    }

    @Test(priority = 2)
    public void item1() throws InterruptedException {
        String phone = "Artis UQC100 QC3.0 Quick Wall Charger Adapter/BIS Certified/Indian Plug with Type C Cable(Black)";
        searching(phone);
        //driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();
    }

    @Test(priority = 3)
    public void item2() throws InterruptedException {
        String hphone = "boAt Airdopes 141 True Wireless Earbuds with 42H Playtime, Beast Mode(Low Latency Upto 80ms) for Gaming, ENx Tech, ASAP Charge, IWP, IPX4 Water Resistance, Smooth Touch Controls(Bold Black)";
        searching(hphone);
        driver.findElement(By.xpath("//span[@id='attachSiNoCoverage-announce']")).click();
    }

//    @AfterSuite
//    public void termi() {
//        driver.quit();
//    }
}

