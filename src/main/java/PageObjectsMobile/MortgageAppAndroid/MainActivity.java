package PageObjectsMobile.MortgageAppAndroid;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainActivity {
    @CacheLookup
    @FindBy(how = How.ID , using = "etAmount")
    public WebElement txt_amount;
    @CacheLookup
    @FindBy(how = How.ID , using = "etTerm")
    public WebElement txt_term;
    @CacheLookup
    @FindBy(how = How.ID , using = "etRate")
    public WebElement txt_rate;
    @CacheLookup
    @FindBy(how = How.ID , using = "btnCalculate")
    public WebElement btn_calculate;
    @CacheLookup
    @FindBy(how = How.ID , using = "tvRepayment")
    public WebElement txt_repayment;

}
