package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditUserPage {
    @FindBy(how = How.CSS , using = "button[ng-click='deleteUser(user)']")
    public WebElement btn_delete_user;
    @FindBy(how = How.CSS , using = "button[ng-show='onConfirm']")
    public WebElement btn_confirm_delete_user;
}
