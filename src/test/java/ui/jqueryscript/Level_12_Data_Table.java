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

import java.util.List;

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
        public void Table_01_Paging(){
            //1. Mo ra 1 trang bat ky dua vao so trang truyen vao
            homePage.openPageByNumber("3");
            Assert.assertTrue(homePage.isPageActiveByNumber("3"));

            homePage.openPageByNumber("6");
            Assert.assertTrue(homePage.isPageActiveByNumber("6"));
            //2. Search bat ky text box nao dua vao ten cot
            //3. Verify bat ky thong tin cua country nao
            //4. Co the xoa/edit bat ky thong tin country nao dua vao ten country
        }
        @Test(enabled = false)
        public void Table_02_Search_Action(){
            //2. Search bat ky text box nao dua vao ten cot
            homePage.enterToHearderTextboxByName("Females", "12253515");
            homePage.sleepInSecond(1);
            Assert.assertTrue(homePage.isPageInfoDisplayed("12253515", "AFRICA", "12599691", "24853148"));

            //action
            homePage.clickToActionByCountryName("AFRICA", "edit");
            homePage.sleepInSecond(3);
        }

        @Test(enabled = false)
        public void TC_03_Index(){
            homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
            homePage.clickToLoadDataButton();
            homePage.sleepInSecond(1);
            homePage.enterToTextboxByColumnNameAndRowIndex("Company", "2", "Hello");
            homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Hi");
            homePage.selectToDropdownByColumnNameAndRowIndex("Country", "2", "United Kingdom");
            homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
            homePage.actionToRowByIndex("2", "Move Down");
            homePage.sleepInSecond(2);
        }

        @Test()
        public void TC_04_Get_All_Values(){
            homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
            homePage.sleepInSecond(3);
            List<String> countryActualValue = homePage.getColumnAllValueByColumnNumber("Country");
            System.out.println(countryActualValue.size());
        }

        @AfterClass
        public void afterClass(){

            driver.quit();
        }
    }

}
