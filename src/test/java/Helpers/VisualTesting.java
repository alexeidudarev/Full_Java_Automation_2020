package Helpers;

import Utilities.CommonOperations;
import Utilities.HelperMethods;
import WorkFlows.WebFlows;
import org.testng.annotations.Test;

public class VisualTesting extends CommonOperations {

    @Test
    public void createScreenShot(){
        WebFlows.login("admin","admin");
        HelperMethods.takeElementScreenShot(grafanaSideMenu.img_avatar,"grafanaAvatar");
    }
}
