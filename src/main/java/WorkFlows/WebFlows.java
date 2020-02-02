package WorkFlows;

import Extensions.UIActions;
import Utilities.CommonOperations;

public class WebFlows extends CommonOperations {
    public static void login(String user, String pass){

        UIActions.updateText(grafanaLoginPage.txt_userName,user);
        UIActions.updateText(grafanaLoginPage.txt_password,pass);
        UIActions.click(grafanaLoginPage.btn_login);
        UIActions.click(grafanaLoginPage.btn_skip);

    }
    public static void addNewUser(String name,String email,String user, String pass){

        UIActions.updateText(grafanaAddNewUserPage.txt_name,name);
        UIActions.updateText(grafanaAddNewUserPage.txt_email,email);
        UIActions.updateText(grafanaAddNewUserPage.txt_username,user);
        UIActions.updateText(grafanaAddNewUserPage.txt_password,pass);
        UIActions.click(grafanaAddNewUserPage.btn_create);
    }
}
