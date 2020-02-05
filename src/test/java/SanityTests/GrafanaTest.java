package SanityTests;

import Extensions.UIActions;
import Extensions.Verifications;
import Utilities.CommonOperations;
import WorkFlows.WebFlows;
import org.testng.Assert;
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
        Verifications.assertCountOfElements(grafanaAdminMainPage.user_instances_rows,1);

    }
    @Test
    public void verifyAddOneNewUser(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        int before = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        WebFlows.addNewUser("Alex","alex@gmai.com","cook","1234");
        int after = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        Assert.assertEquals(before+1,after);
        //Verifications.assertCountOfElements(grafanaAdminMainPage.user_instances_rows,2);

    }
    @Test
    public void deleteExistingUser(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        int before = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        WebFlows.addNewUser("Alex","alex@gmai.com","cook","1234");
        int after = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        WebFlows.removeOneLastExistingUser();
        Assert.assertEquals(before+1,after);

    }
    @Test
    public void deleteLastUser(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        int before = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        WebFlows.removeOneLastExistingUser();
        int after = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        Assert.assertEquals(before-1,after);

    }
}
