package Utilities;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Base {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Actions actions;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;


    public static LoginPage grafanaLoginPage;
    public static MainPage grafanaMainPage;
    public static LeftSideMenuPage grafanaSideMenu;
    public static AdminServerMenuPage grafanaAdminMenu;
    public static ServerAdminMainPage grafanaAdminMainPage;
    public static AddNewUserPage grafanaAddNewUserPage;
    public static EditUserPage grafanaEditUserPage;

}
