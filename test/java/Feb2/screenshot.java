package Feb2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class screenshot {
//    public static WebDriver driver;
//    public static void main(String args[]) throws IOException, InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        try{
//            driver = new ChromeDriver();
//            driver.get("https://l.com");
//        }
//        catch (Throwable t){
//            driver.manage().window().maximize();
//            TakesScreenshot st = ((TakesScreenshot) driver);
//            //Currently stored inside the ram...
//            File f = st.getScreenshotAs(OutputType.FILE);
//            //Now to particular folder..
//            FileUtils.copyFile(f, new File("D:\\Maven2\\googleScreenExp.png"));
//            Thread.sleep(1000);
//            driver.quit();
//        }
//    }
    public WebDriver driver;
    @BeforeSuite
    public void set(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void rldl() throws IOException, InterruptedException {
        try {
            driver.get("https://heheadasdaddasdjahdjhs.com");
        }
        catch(Throwable t){
            driver.manage().window().maximize();
            TakesScreenshot st = ((TakesScreenshot) driver);
            //Currently stored inside the ram...
            File f = st.getScreenshotAs(OutputType.FILE);
            //Now to particular folder..
            FileUtils.copyFile(f, new File("D:\\Maven2\\googleScreenExp1.png"));
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
