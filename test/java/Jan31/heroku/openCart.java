package Jan31.heroku;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import java.util.List;

public class openCart {
    public WebDriver driver;
    String url = "https://demo.opencart.com";

    @Test
    public void OpenCartStuff() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        driver.get(url);
//        WebElement x = driver.findElement(By.xpath("//p[text()='\n" +
//                "Intel Core 2 Duo processor\n" +
//                "Powered by an Intel Core 2 Duo processor at speeds up to 2.1..']"));
//        System.out.println(x.getText());
//        List<WebElement> y = driver.findElements(By.tagName("p"));
        List<WebElement> y = driver.findElements(By.xpath("//p[1]"));
        for(WebElement z:y){
            System.out.println(z.getText());
        }
        driver.quit();
    }
}
