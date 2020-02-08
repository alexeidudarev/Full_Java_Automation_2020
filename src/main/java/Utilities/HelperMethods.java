package Utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class HelperMethods extends CommonOperations {
    public static void takeElementScreenShot(WebElement imageElement,String imageName){
        imageScreenShot = new AShot().takeScreenshot(driver,imageElement);
        try {
            ImageIO.write(imageScreenShot.getImage(),"png", new File(getData("ImageRepo")+imageName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error getting while writing image");
        }

    }
}
