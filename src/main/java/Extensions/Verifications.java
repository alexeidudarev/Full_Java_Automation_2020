package Extensions;

import Utilities.CommonOperations;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Verifications extends CommonOperations {
    public static void assertTextInElement(WebElement element, String expValue){
        Assert.assertEquals(element.getText(),expValue);
    }
}
