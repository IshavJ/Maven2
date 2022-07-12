package Feb4.RegistrationFunc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reg_pom {
    public WebDriver driver;

    By fname = By.name("firstname");
    By lname = By.name("lastname");
    By mail = By.name("email");
    By contact = By.name("telephone");
    By pass = By.name("password");
    By cpass = By.name("confirm");
    By check = By.name("agree");
    By ok = By.xpath("//input[@value='Continue']");

    public Reg_pom(WebDriver driver){
        this.driver=driver;
        WebDriverManager.chromedriver().setup();
    }

    public void enterf(String fn){
        driver.findElement(fname).sendKeys(fn);
    }
    public void enterl(String ln){
        driver.findElement(lname).sendKeys(ln);
    }
    public void entermail(String email){
        driver.findElement(mail).sendKeys(email);
    }
    public void entercont(String c){
        driver.findElement(contact).sendKeys(c);
    }
    public void enterpass(String word){
        driver.findElement(pass).sendKeys(word);
    }
    public void entercpass(String cp){
        driver.findElement(cpass).sendKeys(cp);
    }
    public void enterchck(){
        driver.findElement(check).click();
    }
    public void enterok(){
        driver.findElement(ok).click();
    }
}
