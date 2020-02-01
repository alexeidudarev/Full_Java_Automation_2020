package Extensions;

import Utilities.CommonOperations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UIActions extends CommonOperations {
    public static void click(WebElement element){
        element.click();
    }
    public static void updateText(WebElement element,String text){
        element.sendKeys(text);
    }
    public static void updateDropDownText(WebElement element,String text){
        Select value = new Select(element);
        value.selectByVisibleText(text);
    }

}
