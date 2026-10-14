package ui.oranghrm.user;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Login_02_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private String appUrl;
    private BasePage basePage;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void beforeClass(String appUrl, String browserName){
        this.appUrl = appUrl;
        driver = getBrowserDriver(appUrl, browserName);
        basePage = BasePage.getInstance();
    }
}
