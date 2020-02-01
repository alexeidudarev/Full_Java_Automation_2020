package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CommonOperations extends Base {
    @BeforeClass
    public void startSession(){
        String platform = "web";
        if (platform.equalsIgnoreCase("web")){
            initBrowser("Browser type");
        }else if (platform.equalsIgnoreCase("mobile")){
            //initMobile();
        }else{
            throw  new RuntimeException("invalid platform name");
        }
        PageManager.init();
    }

    private static void initBrowser(String browser_type) {
        if(browser_type.equalsIgnoreCase("chrome")){
            driver = initChromeDriver();
        }else if (browser_type.equalsIgnoreCase("firefox")){
            driver = initFFDriver();
        }else if (browser_type.equalsIgnoreCase("ie")){
            driver = initIEDriver();
        }else{
            throw  new RuntimeException("invalid browser name stated");
        }
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
    }

    private static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver  = new InternetExplorerDriver();
        return driver;
    }

    private static WebDriver initFFDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver  = new FirefoxDriver();
        return driver;
    }

    private static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();
        return driver;
    }

    @AfterClass
    public void finishSession(){
        if (driver != null){
            driver.quit();
        }
    }

}
