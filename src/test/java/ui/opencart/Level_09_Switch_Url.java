package ui.opencart;

import PageObject.PageGeneratorGeneric;
import PageObject.jqueryscript.HomePageObject;
import PageUIs.BasePageUI;
import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_09_Switch_Url extends BaseTest {

    private WebDriver driver;

    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String url, String browserName){

    }
}
