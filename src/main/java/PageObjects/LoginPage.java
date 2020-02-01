package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.NAME , using = "user")
    public WebElement txt_userName;

    @FindBy(how = How.NAME , using = "password")
    public WebElement txt_password;

    @FindBy(how = How.CSS, using = "button[type='submit']")
    public WebElement btn_login;

    @FindBy(how = How.NAME , using = "a[class='btn btn-link']")
    public WebElement btn_skip;
}
