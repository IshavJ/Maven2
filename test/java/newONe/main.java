package newONe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class main {
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
    }

    @Test(priority = 1,enabled = false)
    public void logo() {
        String logo = driver.findElement(By.className("logo")).getAttribute("alt");
        System.out.println(logo);
        if (logo.equalsIgnoreCase("ParaBank")) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case Failed");
        }
    }

//    @Test(priority = 2)
//    public void reg(){
//        driver.findElement(By.linkText("Register")).click();
//        driver.findElement(By.name("customer.firstName")).sendKeys("Ishav");
//        driver.findElement(By.name("customer.lastName")).sendKeys("Jnagal");
//        driver.findElement(By.name("customer.address.street")).sendKeys("abc Nagar");
//        driver.findElement(By.name("customer.username")).sendKeys("IshavJ");
//        driver.findElement(By.name("customer.password")).sendKeys("abc123");
//        driver.findElement(By.name("repeatedPassword")).sendKeys("abc123");
//        driver.findElement(By.className("button")).click();
//    }

    public void logout() {
        driver.findElement(By.linkText("Log Out")).click();
    }

    @Test(priority = 3,enabled = false)
    public void loginLogout() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("IshavJ");
        driver.findElement(By.name("password")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(1000);
        String login = driver.findElement(By.className("smallText")).getText();
        if (login.equalsIgnoreCase("welcome test user")) {
            System.out.println("User Logged in ... Test case Passed");
        } else {
            System.out.println("Case Failed");
        }
        logout();
    }

    @Test(priority = 4,enabled = false)
    public void admin() {
        driver.findElement(By.linkText("Admin Page")).click();
        driver.findElement(By.xpath("//button[@value='INIT']")).click();
        try {
            if (driver.findElement(By.xpath("//input[@value='Startup']")).isDisplayed()) {
                driver.findElement(By.xpath("//input[@value='Startup']")).click();
            }
        } catch (Throwable t) {
            driver.findElement(By.xpath("//input[@value='Shutdown']")).click();
        }
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
    }

    @Test(priority = 5,enabled = false)
    public void AboutUs() {
        driver.findElement(By.linkText("About Us")).click();
        String context = driver.findElement(By.xpath("//div[@id='rightPanel']")).getText();
        System.out.println(context);
    }

    @Test(priority = 6)
    public void services() {
        driver.findElement(By.linkText("Services")).click();
        List<WebElement> table = driver.findElements(By.xpath("//*[@id='rightPanel']/table[1]"));
        for (WebElement row : table) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Print the contents of each cell
            for (WebElement cell : cells) {

                System.out.println(cell.getText());
            }
        }
    }

    @AfterSuite
    public void termi() {
        driver.quit();
    }
}