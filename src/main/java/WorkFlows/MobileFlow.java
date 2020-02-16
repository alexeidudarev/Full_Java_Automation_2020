package WorkFlows;

import Extensions.UIActions;
import Utilities.CommonOperations;
import io.qameta.allure.Step;

public class MobileFlow extends CommonOperations {

    @Step("Fill form and calculate mortgage")
    public static void calculateMortgage(String amount, String term ,String rate){
        UIActions.updateText(mortgageMobileAppMainActivity.txt_amount,amount);
        UIActions.updateText(mortgageMobileAppMainActivity.txt_rate,term);
        UIActions.updateText(mortgageMobileAppMainActivity.txt_rate,rate);
        UIActions.click(mortgageMobileAppMainActivity.btn_calculate);

    }
}
