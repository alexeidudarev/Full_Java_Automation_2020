package Extensions;

import Utilities.CommonOperations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static  org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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
    @Step("Verifying element visually")
    public static void checkElementVisually(WebElement imageElement,String expectedImageName){
        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File(getData("ImageRepo")+expectedImageName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error reading image file");
        }
        imageScreenShot = new AShot().takeScreenshot(driver,imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = imgDiff.makeDiff(expectedImage,actualImage);
        assertFalse(diff.hasDiff(),"images are not the same");

    }
}
