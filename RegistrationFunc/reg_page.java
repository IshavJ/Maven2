package Feb4.RegistrationFunc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class reg_page {
    @FindBy(name="firstname")
    public WebElement fname;
    @FindBy(name="lastname")
    public WebElement lname;
    @FindBy(name="email")
    public WebElement Email;
    @FindBy(name="telephone")
    public WebElement Contact;
    @FindBy(name="password")
    public WebElement Pass;
    @FindBy(name="confirm")
    public WebElement cpass;
    @FindBy(name="agree")
    public WebElement check;
    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement ok;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement pop;

    public void enterf(String fn){
        fname.sendKeys(fn);
    }
    public void enterl(String ln){
        lname.sendKeys(ln);
    }
    public void entermail(String email){
        Email.sendKeys(email);
    }
    public void entercont(String c){
        Contact.sendKeys(c);
    }
    public void enterpass(String word){
        Pass.sendKeys(word);
    }
    public void entercpass(String cp){
        cpass.sendKeys(cp);
    }
    public void enterchck(){
        check.click();
    }
    public void enterok(){
        ok.click();
    }
}
