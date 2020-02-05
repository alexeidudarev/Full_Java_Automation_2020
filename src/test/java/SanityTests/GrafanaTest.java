package SanityTests;
//run next command in terminal od ide to see reports - >>> allure serve allure-results
import Extensions.UIActions;
import Extensions.Verifications;
import Utilities.CommonOperations;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class GrafanaTest extends CommonOperations {
    @Test(description = "Login to Grafana")
    @Description("Test description : Login to Grafana Web Application")
    public void loginTest(){
        WebFlows.login("admin","admin");
        Verifications.assertTextInElement(grafanaMainPage.txt_mainHeader,"Home Dashboard");
    }
    @Test(description = "Verify default user exist")
    @Description("Test description : Verifying that default user exist when grafana used first time")
    public void verifyDefaultUserExist(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        Verifications.assertCountOfElements(grafanaAdminMainPage.user_instances_rows,1);

    }
    @Test(description = "Verify adding new user")
    @Description("Test description : Verify adding new user ability iss working as expected")
    public void verifyAddOneNewUser(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        int before = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        WebFlows.addNewUser("Alex","alex@gmai.com","cook","1234");
        int after = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        Assert.assertEquals(before+1,after);
        //Verifications.assertCountOfElements(grafanaAdminMainPage.user_instances_rows,2);

    }
    @Test(description = "Verify deleting one user")
    @Description("Test description : Verify adding and than deleting one user")
    public void deleteExistingUser(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        int before = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        WebFlows.addNewUser("Alex","alex@gmai.com","cook","1234");
        int after = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        WebFlows.removeOneLastExistingUser();
        Assert.assertEquals(before+1,after);

    }
    @Test(description = "Verify deleting last user")
    @Description("Test description :Verify deleting last user is working as expected")
    public void deleteLastUser(){
        WebFlows.login("admin","admin");
        UIActions.mouseHoverAction(grafanaSideMenu.btn_server_admin,grafanaAdminMenu.link_users_page);
        int before = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        WebFlows.removeOneLastExistingUser();
        int after = Verifications.getElemetsCount(grafanaAdminMainPage.user_instances_rows);
        Assert.assertEquals(before-1,after);

    }
}
