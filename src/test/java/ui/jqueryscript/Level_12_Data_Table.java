package ui.jqueryscript;

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

public class Level_12_Data_Table {

    public class Level_09_Switch_Url extends BaseTest {

        private WebDriver driver;
        private HomePageObject homePage;

        @Parameters({"url", "browser"})
        @BeforeClass
        public void beforeClass(String url, String browserName){
            driver = getBrowserDriver(url, browserName);
            homePage = PageGeneratorGeneric.getPage(HomePageObject.class, driver);
        }

        @Test(enabled = false)
        public void Table_01(){
            //1. Mo ra 1 trang bat ky dua vao so trang truyen vao
            homePage.openPageByNumber("3");
            Assert.assertTrue(homePage.isPageActiveByNumber("3"));

            homePage.openPageByNumber("6");
            Assert.assertTrue(homePage.isPageActiveByNumber("6"));
            //2. Search bat ky text box nao dua vao ten cot
            //3. Verify bat ky thong tin cua country nao
            //4. Co the xoa/edit bat ky thong tin country nao dua vao ten country
        }
        @Test
        public void Table_02(){
            //2. Search bat ky text box nao dua vao ten cot
            homePage.enterToHearderTextboxByName("Females", "12253515");
            homePage.sleepInSecond(1);
            Assert.assertTrue(homePage.isPageInfoDisplayed("12253515", "AFRICA", "12599691", "24853148"));
            homePage.refreshPage(driver);
            homePage.sleepInSecond(2);

            homePage.enterToHearderTextboxByName("Country", "Angola");
            homePage.sleepInSecond(1);
            Assert.assertTrue(homePage.isPageInfoDisplayed("276880", "Angola", "276472", "553353"));
        }

        @AfterClass
        public void afterClass(){
        driver.quit();
        }
    }

}
