package SanityTests;

import Extensions.UIActions;
import Extensions.Verifications;
import Utilities.CommonOperations;
import WorkFlows.WebFlows;
import org.testng.annotations.Test;

public class GrafanaTest extends CommonOperations {
    @Test
    public void loginTest(){
        WebFlows.login("admin","admin");
        Verifications.assertTextInElement(grafanaMainPage.txt_mainHeader,"Home Dashboard");
    }
    @Test
    public void verifyDefaultUserExist(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        Verifications.assertCountOfElements(grafanaAdminPage.user_instances_rows,1);

    }
    @Test
    public void verifyAddOneNewUser(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        UIActions.click(grafanaAdminPage.btn_new_user);
        WebFlows.addNewUser("Alex","alex@gmai.com","cook","1234");
        Verifications.assertCountOfElements(grafanaAdminPage.user_instances_rows,2);

    }
}
