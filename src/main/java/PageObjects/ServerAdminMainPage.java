package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminMainPage {
    @FindBy(how = How.CSS , using = "tr[ng-repeat='user in ctrl.users']")
    public List<WebElement> user_instances_rows;
    @FindBy(how = How.CSS , using = "a[class='btn btn-primary']")
    public WebElement btn_new_user;
    @FindBy(how = How.XPATH , using = "//a[contains(text(),'cook')]")
    public WebElement btn_exist_user;
}
