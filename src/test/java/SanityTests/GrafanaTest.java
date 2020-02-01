package SanityTests;

import Utilities.CommonOperations;
import WorkFlows.WebFlows;
import org.testng.annotations.Test;

public class GrafanaTest extends CommonOperations {
    @Test
    public void loginTest(){
        WebFlows.login("admin","admin");
    }
}
