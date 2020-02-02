package Utilities;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import org.openqa.selenium.support.PageFactory;

public class PageManager extends Base {
    public static void init(){
        grafanaLoginPage = PageFactory.initElements(driver, LoginPage.class);
        grafanaMainPage = PageFactory.initElements(driver, MainPage.class);
    }
}
