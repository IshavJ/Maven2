package Feb3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class exception {
    public WebDriver x;
    public WebElement y;
    @BeforeSuite
    public void set() {
        WebDriverManager.chromedriver().setup();
        x = new ChromeDriver();
        x.get("https://www.google.com");
        x.manage().window().maximize();
    }
    @Test
    public void StaleEle(){
        try{
            y = x.findElement(By.name("q"));
            y.sendKeys("Facebook");
            x.navigate().refresh();
            String s = x.findElement(By.name("q")).getText();
            System.out.println(s);
        }
        catch(Throwable t){
            System.out.println("Error Occured");
            t.printStackTrace();
        }
    }
    @Test
    public void ElementNotInt(){
        try{
            x.findElement(By.xpath("//div[text()='Google offered in:  ']")).sendKeys("lol");
        }
        catch (Throwable t){
            System.out.println("Error Occurred..");
            t.printStackTrace();
        }
    }
    @Test
    public void invalidSelector(){
        try{
            x.findElement(By.xpath("//span'lol'")).click();
        }
        catch(Throwable t){
            System.out.println("Error Occurred");
            t.printStackTrace();
        }
    }
    @Test
    public void alertRel(){
        try{
            x.switchTo().alert();
        }
        catch(Throwable t){
            System.out.println("Error Occurred");
            t.printStackTrace();
        }
    }
    @Test
    public void windowExp(){
        try{
            x.switchTo().window("helloWorld");
        }
        catch(Throwable t){
            System.out.println("Error Occurred");
            t.printStackTrace();
        }
    }
    @Test
    public void elementVisible(){
        try{
            x.switchTo().window("helloWorld");
        }
        catch(Throwable t){
            System.out.println("Error Occurred");
            t.printStackTrace();
        }
    }
    @AfterSuite
    public void over() throws InterruptedException {
        Thread.sleep(1000);
        x.quit();
        try{
            x.findElement(By.name("q")).click();
        }
        catch (Throwable t){
            System.out.println("Error Occurred");
            t.printStackTrace();
        }
    }
}
