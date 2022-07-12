package Feb4.RegistrationFunc;

import Feb4.loginFun.pomPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class RegMain {
    public Reg_pom p;
    public WebDriver d;
    public Boolean s;
    public reg_page pf;

    @BeforeSuite
    public void set() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
        d.get("https://demo.opencart.com/index.php?route=account/register");
        p = new Reg_pom(d);
        pf = PageFactory.initElements(d, reg_page.class);
        d.manage().window().maximize();
    }

    @Test(enabled = false)
    public void tstWithPOM() throws InterruptedException {
        p.enterf("abc");
        p.enterl("khan");
        p.entermail("abckhan@com.com");
        p.entercont("123456");
        p.enterpass("abckhan");
        p.entercpass("abckhan");
        p.enterchck();
        p.enterok();
        Thread.sleep(1000);
        System.out.println("Added the values 😁 ..");
    }

    @Test
    public void tstWithPageFact() throws InterruptedException {
        pf.enterf("abc");
        pf.enterl("khan");
        pf.entermail("abckhan@com.com");
        pf.entercont("123456");
        pf.enterpass("abckhan");
        pf.entercpass("abckhan");
        pf.enterchck();
        pf.enterok();
        Boolean x = pf.pop.isDisplayed();
        if(x){
            System.out.println("error occured");
        }
        else{
            System.out.println("Added the values 😁 ..");
        }
        Thread.sleep(1000);
    }

    @AfterSuite
    public void over() throws InterruptedException {
        Thread.sleep(1000);
        d.quit();
    }
}
