package Extensions;

import Utilities.CommonOperations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static  org.testng.Assert.assertEquals;

public class Verifications extends CommonOperations {
    public static void assertTextInElement(WebElement element, String expValue){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(),expValue);
    }
    public static void assertCountOfElements(List<WebElement> elements, int expValue){
        webDriverWait.until(ExpectedConditions.visibilityOf(elements.get(elements.size()-1)));
        assertEquals(elements.size(),expValue);
    }
}
