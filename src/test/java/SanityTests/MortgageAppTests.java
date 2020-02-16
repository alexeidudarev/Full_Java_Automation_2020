package SanityTests;

import Extensions.Verifications;
import Utilities.CommonOperations;
import WorkFlows.MobileFlow;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class MortgageAppTests extends CommonOperations {
    @Test(description = "Verify Calculating mortgage")
    @Description("Test description : Adding values to required field at main activity")
    public void mortgageCalculating(){
        MobileFlow.calculateMortgage("1000","3","4");
        Verifications.assertTextInElement(mortgageMobileAppMainActivity.txt_term,"30.03");
    }
}
