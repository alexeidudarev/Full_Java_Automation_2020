package Extensions;

import Utilities.CommonOperations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UIActions extends CommonOperations {
    public static void click(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public static void updateText(WebElement element,String text){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
    public static void updateDropDownText(WebElement element,String text){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        Select value = new Select(element);
        value.selectByVisibleText(text);
    }
    public static void mouseHoverAction(WebElement element1,WebElement element2){
        actions.moveToElement(element1).moveToElement(element2).click().build().perform();
    }

}
