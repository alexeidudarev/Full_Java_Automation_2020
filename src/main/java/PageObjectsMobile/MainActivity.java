package PageObjectsMobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainActivity {
    @FindBy(how = How.ID , using = "etAmount")
    public WebElement txt_amount;
}
