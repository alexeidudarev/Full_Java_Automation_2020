package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminServerMenuPage {
    @FindBy(how = How.CSS , using = "a[href='/admin/users']")
    public WebElement link_users_page;

    @FindBy(how = How.CSS , using = "a[href='/admin/orgs']")
    public WebElement link_orgs_page;

    @FindBy(how = How.CSS , using = "a[href='/admin/settings']")
    public WebElement link_settings_page;

    @FindBy(how = How.CSS , using = "a[href='/admin/stats']")
    public WebElement link_stats_page;
}
