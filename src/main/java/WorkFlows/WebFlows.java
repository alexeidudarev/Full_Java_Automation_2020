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
}
