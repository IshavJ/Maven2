package IdunnoRandom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class demo_test {

    public WebDriver driver;

    @Parameters({"browser","URL"})
    @BeforeClass
    public void startup(String bname,String link){
        if(bname.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
        }
        else if(bname.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        driver.get(link);
        System.out.println("Setup has completed...");
    }

    @Test
    public void loading(){
        System.out.println("loading");
    }

    //Data entry point with @dataprovider method...
    //Same as parameter tag in the xml file...
    @DataProvider
    public Object[][] getdata(){
        return new Object[][]{
            {"My Store"},{"Your Store"}
        };
    }

    @Test(priority = 1,dataProvider ="getdata")
    public void textverify(String data){
        System.out.println("System1 starts processing");
        String val = driver.findElement(By.xpath("//a[normalize-space()='Your Store']")).getText();
        //Softassertion..
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(val.equals(data),"Tested Here");
        //HardAssertion..
        //Assert.assertEquals(val,data);
        System.out.println("Text verification(Via SoftAssertion's assert.True) on chrome Over..");
    }
    //till here..

    @Test(priority = 3,dataProvider ="getdata")
    public void textverify1(String data){
        System.out.println("System1 starts processing");
        String val = driver.findElement(By.xpath("//a[normalize-space()='Your Store']")).getText();
        //Softassertion..
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(val.equals(data),"Tested Here");
        //HardAssertion..
        //Assert.assertEquals(val,data);
        System.out.println("Text verification(Via Soft Assertion with Assert.false) on chrome Over..");
    }

    @Test(priority = 4,dataProvider ="getdata")
    public void textverify2(String data){
        System.out.println("System1 starts processing");
        String val = driver.findElement(By.xpath("//a[normalize-space()='Your Store']")).getText();
        //HardAssertion..
        Assert.assertEquals(val,data);
        System.out.println("Text verification(Via assertEquals) on chrome Over..");
    }

    @Test(priority = 2,dataProvider ="getdata")
    public void textverify3(String data){
        System.out.println("System1 starts processing");
        String val = driver.findElement(By.xpath("//a[normalize-space()='Your Store']")).getText();
        //HardAssertion..
        Assert.assertNotEquals(val,data);
        System.out.println("Text verification(Via assertNotEquals) on chrome Over..");
    }


    @AfterClass
    public void terminated(){
        driver.quit();
        System.out.println("System Terminated..");
    }
}
