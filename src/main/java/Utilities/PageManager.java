package Utilities;

import PageObjects.LoginPage;
import org.openqa.selenium.support.PageFactory;

public class PageManager extends Base {
    public static void init(){
        System.out.println("login page element init");
        grafanaLoginPage = PageFactory.initElements(driver, LoginPage.class);
    }
}
