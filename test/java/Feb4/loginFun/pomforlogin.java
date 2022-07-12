package Feb4.loginFun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pomforlogin {
    public WebDriver driver;
    By email = By.name("email");
    By pass = By.name("password");
    By login = By.xpath("//input[@value='Login']");
    //Constructor...
    public pomforlogin(WebDriver driver){
        this.driver=driver;
        WebDriverManager.chromedriver().setup();
    }

    public void enterEmail(String mail){
        driver.findElement(email).sendKeys(mail);
    }
    public void enterPass(String word){
        driver.findElement(pass).sendKeys(word);
    }
    public void Login(){
        driver.findElement(login).click();
    }
}
