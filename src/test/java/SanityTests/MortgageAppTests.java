package SanityTests;

import Extensions.Verifications;
import Utilities.CommonOperations;
import WorkFlows.MobileFlow;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.Listeners.class)
public class MortgageAppTests extends CommonOperations {
    @Test(description = "Verify Calculating mortgage")
    @Description("Test description : Adding values to required field at main activity")
    public void mortgageCalculating(){
        MobileFlow.calculateMortgage("1000","3","4");
        Verifications.assertTextInElement(mortgageMobileAppMainActivity.txt_repayment,"£30.03");
    }
    @Test(description = "Verify Calculating mortgage")
    @Description("Test description : Adding values to required fields at main activity ,expected value is £30.03")
    public void mortgageCalculatingNegative(){
        MobileFlow.calculateMortgage("1000","3","4");
        Verifications.assertTextInElement(mortgageMobileAppMainActivity.txt_repayment,"£50.03");
    }
}
