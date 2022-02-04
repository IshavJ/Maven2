package Feb4.loginFun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginFunctionality_viaPOM {
    public pomforlogin p;
    public WebDriver d;
    public Boolean s;
    public pomPageFactory pf;

    @BeforeSuite
    public void set() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
        d.get("https://demo.opencart.com/index.php?route=account/login");
        p = new pomforlogin(d);
        pf = PageFactory.initElements(d, pomPageFactory.class);
        d.manage().window().maximize();
    }

    @Test(enabled = false)
    public void tstWithPOM() throws InterruptedException {
        p.enterEmail("yellowW@gmail.com");
        p.enterPass("1234");
        p.Login();
        Thread.sleep(1000);
        Boolean s = d.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed();
        if (s) {
            System.out.println("Case Failed..");
        } else {
            System.out.println("Case Passed 😄..");
        }
    }

    @Test
    public void tstWithPageFun() throws InterruptedException {
        pf.enterEmail("yellowW@gmail.com");
        pf.enterPass("1234");
        pf.Login();
        Thread.sleep(1000);
        try{
            s = pf.pop.isDisplayed();
        }
        catch (Throwable t){
            if (s) {
                System.out.println("Case Failed..");
            } else {
                System.out.println("Case Passed 😄..");
            }
        }
    }

    @AfterSuite
    public void over() throws InterruptedException {
        Thread.sleep(1000);
        d.quit();
    }
}
