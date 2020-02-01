package WorkFlows;

import Extensions.UIActions;
import Utilities.CommonOperations;

public class WebFlows extends CommonOperations {
    public static void login(String user, String pass){
        UIActions.updateText(grafanaLoginPage.txt_userName,user);
        UIActions.updateText(grafanaLoginPage.txt_password,pass);
        UIActions.click(grafanaLoginPage.btn_login);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UIActions.click(grafanaLoginPage.btn_skip);

    }
}
