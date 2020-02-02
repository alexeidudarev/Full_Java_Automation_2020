package Utilities;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static LoginPage grafanaLoginPage;
    public static MainPage grafanaMainPage;

}
