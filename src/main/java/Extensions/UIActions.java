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
        element.sendKeys(text);
    }
    public static void updateDropDownText(WebElement element,String text){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        Select value = new Select(element);
        value.selectByVisibleText(text);
    }

}
