package Feb4.loginFun;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pomPageFactory {
    @FindBy(name="email")
    public WebElement email;
    @FindBy(name="password")
    public WebElement pass;
    @FindBy(xpath="//input[@value='Login']")
    public WebElement login;

    public void enterEmail(String mail){
        email.sendKeys(mail);
    }
    public void enterPass(String word){
        pass.sendKeys(word);
    }
    public void Login(){
        login.click();
    }
}
