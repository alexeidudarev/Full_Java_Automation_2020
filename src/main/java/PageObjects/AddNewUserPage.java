package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AddNewUserPage {
    @FindBy(how = How.CSS , using = "input[ng-model='user.name']")
    public WebElement txt_name;
    @FindBy(how = How.CSS , using = "input[ng-model='user.email']")
    public WebElement txt_email;
    @FindBy(how = How.CSS , using = "input[ng-model='user.login']")
    public WebElement txt_username;
    @FindBy(how = How.CSS , using = "input[ng-model='user.password']")
    public WebElement txt_password;
    @FindBy(how = How.CSS , using = "button[type='submit']")
    public WebElement btn_create;
    //div[class='alert-title']
    @FindBy(how = How.CSS , using = "div[class='alert-title']")
    public WebElement error_user_exist;


}
