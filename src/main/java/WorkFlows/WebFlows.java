package WorkFlows;

import Extensions.UIActions;
import Extensions.Verifications;
import Utilities.CommonOperations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class WebFlows extends CommonOperations {
    @Step("Login Grafana flow")
    public static void login(String user, String pass){

        UIActions.updateText(grafanaLoginPage.txt_userName,user);
        UIActions.updateText(grafanaLoginPage.txt_password,pass);
        UIActions.click(grafanaLoginPage.btn_login);
        UIActions.click(grafanaLoginPage.btn_skip);

    }
    @Step("Create New User Grafana flow")
    public static void addNewUser(String name,String email,String user, String pass){
        UIActions.click(grafanaAdminMainPage.btn_new_user);
        UIActions.updateText(grafanaAddNewUserPage.txt_name,name);
        UIActions.updateText(grafanaAddNewUserPage.txt_email,email);
        UIActions.updateText(grafanaAddNewUserPage.txt_username,user);
        UIActions.updateText(grafanaAddNewUserPage.txt_password,pass);
        UIActions.click(grafanaAddNewUserPage.btn_create);
        if(Verifications.ifElementExist(grafanaAddNewUserPage.error_user_exist)){
            Random ran = new Random();
            int num = ran.nextInt(100);
            UIActions.updateText(grafanaAddNewUserPage.txt_name,String.format("%s-%s",name,num));
            UIActions.updateText(grafanaAddNewUserPage.txt_email,String.format("%s%s",num,email));
            UIActions.updateText(grafanaAddNewUserPage.txt_username,String.format("%s-%s",user,num));
            UIActions.updateText(grafanaAddNewUserPage.txt_password,String.format("%s-%s",pass,num));
            UIActions.click(grafanaAddNewUserPage.btn_create);
        }
    }
    @Step("Delete one Last existing user")
    public static void removeOneLastExistingUser(){
        List<WebElement> elements = grafanaAdminMainPage.user_instances_rows;
        int count = Verifications.getElemetsCount(elements);
        if (count > 1) {
            UIActions.click(grafanaAdminMainPage.user_instances_rows.get(elements.size() -1));
            UIActions.click(grafanaEditUserPage.btn_delete_user);
            UIActions.click(grafanaEditUserPage.btn_confirm_delete_user);
        }
    }
}
