package Extensions;

import Utilities.CommonOperations;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UIActions extends CommonOperations {
    @Step("Click on element")
    public static void click(WebElement element){
        if (!getData("PlatformType").equalsIgnoreCase("mobile")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        }
        element.click();
    }
    @Step("Send text to text field")
    public static void updateText(WebElement element,String text){
        if(getData("PlatformType").equalsIgnoreCase("web")){
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(text);
        }else{
            element.sendKeys(text);

        }

    }
    @Step("Update drop down field")
    public static void updateDropDownText(WebElement element,String text){
        if (!getData("PlatformType").equalsIgnoreCase("mobile"))
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        Select value = new Select(element);
        value.selectByVisibleText(text);
    }
    @Step("Mose hover  action to element")
    public static void mouseHoverAction(WebElement element1,WebElement element2){
        actions.moveToElement(element1).moveToElement(element2).click().build().perform();
    }

}
