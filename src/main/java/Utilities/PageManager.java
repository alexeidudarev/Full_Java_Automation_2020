package Utilities;

import PageObjects.*;
import org.openqa.selenium.support.PageFactory;

public class PageManager extends Base {
    public static void init(){
        grafanaLoginPage = PageFactory.initElements(driver, LoginPage.class);
        grafanaMainPage = PageFactory.initElements(driver, MainPage.class);
        grafanaSideMenu = PageFactory.initElements(driver, LeftSideMenuPage.class);
        grafanaAdminMenu = PageFactory.initElements(driver, AdminServerMenuPage.class);
        grafanaAdminMainPage = PageFactory.initElements(driver, ServerAdminMainPage.class);
        grafanaAddNewUserPage = PageFactory.initElements(driver, AddNewUserPage.class);
        grafanaEditUserPage = PageFactory.initElements(driver, EditUserPage.class);

    }
}
