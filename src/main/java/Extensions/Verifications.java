package Extensions;

import Utilities.CommonOperations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static  org.testng.Assert.assertEquals;

public class Verifications extends CommonOperations {
    @Step("Verify text in element")
    public static void assertTextInElement(WebElement element, String expValue){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(),expValue);
    }
    @Step("Assert number of elements in list")
    public static void assertCountOfElements(List<WebElement> elements, int expValue){
        webDriverWait.until(ExpectedConditions.visibilityOf(elements.get(elements.size()-1)));
        assertEquals(elements.size(),expValue);
    }
    @Step("Get elements count from teh list")
    public static int getElemetsCount(List<WebElement> elements){
        webDriverWait.until(ExpectedConditions.visibilityOf(elements.get(elements.size()-1)));
        int size = elements.size();
        return size;
    }
    @Step("Verify if element is appear on the screen")
    public static boolean ifElementExist(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed()){
            return true;
        }
        return false;
    }
}
