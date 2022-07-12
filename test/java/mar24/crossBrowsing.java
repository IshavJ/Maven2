package mar24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossBrowsing {
    WebDriver driver;
    @Parameters({"bro","url"})
    @Test
    public void launch(String b,String u) throws InterruptedException {
        if(b.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
        }
        else if(b.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
             driver = new OperaDriver();
        }
        driver.get(u);
        Thread.sleep(1000);
        System.out.println("Done Cross Browsing .. ");

        String title = "Your Store";
        String atitle = driver.getTitle().toString();
        if(atitle.equals(title)){
            System.out.println("Text verified");
        }
        else{
            System.out.println("Text doesn't matched");
        }

        Assert.assertEquals(title,atitle);

        driver.quit();
    }

}
