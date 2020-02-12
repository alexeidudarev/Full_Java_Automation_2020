package Utilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOperations extends Base {
    @BeforeClass
    public void startSession(){
        String platform = getData("PlatformType");
        if (platform.equalsIgnoreCase("web")){
            System.out.println("chrome driver init");
            initBrowser(getData("BrowserName"));
        }else if (platform.equalsIgnoreCase("mobile")){
            initMobile();
        }else{
            throw  new RuntimeException("invalid platform name");
        }
        System.out.println("page objects init");
        //initialisation of page objects
        PageManager.init();
    }



    public static String getData(String nodeName){
        File file;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try{
            file =  new File("./configurationFile/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

        }catch(Exception e){
            System.out.println("Getting error while reading  xml file :"+e);
        }finally{
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }

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
        driver.get(getData("Url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        //initialisation of objects
        webDriverWait = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        actions = new Actions(driver);
    }

    private void initMobile()  {
        dc.setCapability(MobileCapabilityType.UDID,getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getData("AppActivity"));
        try {
            driver = new RemoteWebDriver(new URL(getData("Url")),dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Cant connect to Appium server ");
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS );
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
