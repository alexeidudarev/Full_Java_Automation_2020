package Utilities;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Actions actions;

    public static LoginPage grafanaLoginPage;
    public static MainPage grafanaMainPage;
    public static LeftSideMenuPage grafanaSideMenu;
    public static AdminServerMenuPage grafanaAdminMenu;
    public static ServerAdminMainPage grafanaAdminPage;
    public static AddNewUserPage grafanaAddNewUserPage;

}
