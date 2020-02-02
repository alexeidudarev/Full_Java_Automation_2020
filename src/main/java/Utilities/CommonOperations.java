package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class CommonOperations extends Base {
    @BeforeClass
    public void startSession(){
        String platform = "web";
        if (platform.equalsIgnoreCase("web")){
            System.out.println("chrome driver init");
            initBrowser("chrome");
        }else if (platform.equalsIgnoreCase("mobile")){
            //initMobile();
        }else{
            throw  new RuntimeException("invalid platform name");
        }
        System.out.println("page objects init");
        //initialisation of page objects
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //initialisation of objects
        webDriverWait = new WebDriverWait(driver,10);
        actions = new Actions(driver);
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
