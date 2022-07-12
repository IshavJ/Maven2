package flipkart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class functionalities {
    public WebDriver driver;
    public String mail = "//input[@class='_2IX_2- VJZDxU']",
            pass="//input[@class='_2IX_2- _3mctLh VJZDxU']",log = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']",search_bar = "//input[@name='q' and @class='_3704LK']",
    check = "//button[@type = 'submit' and @class = 'L0Z3Pu']";

    public void setup(String Url){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get(Url);
    }

    public void login(String user , String Pass){
        driver.findElement(By.xpath(mail)).sendKeys(user);
        driver.findElement(By.xpath(pass)).sendKeys(Pass);
        driver.findElement(By.xpath(log)).click();
    }

    public void picking(String item){
        driver.findElement(By.xpath(search_bar)).sendKeys(item);
        driver.findElement(By.xpath(check)).click();
        driver.findElement(By.xpath("//a[@title='"+item+"' and @class='s1Q9rs']")).click();
    }

    @Test
    public void flip() throws InterruptedException {
        String url = "https://www.flipkart.com/",phone = "9115638369",
                password="jnagalish@v1024",item = "boAt Stone 350 10 W Bluetooth Speaker";

        setup(url);

        //login
        login(phone,password);

        //picking item
        Thread.sleep(1000);
        picking(item);

        //Closing window
        Thread.sleep(1000);
        //driver.close();
    }

    @Test
    public void amaz(){
        String url = "https://www.amazon.in/";
        setup(url);
        driver.close();
    }
}
