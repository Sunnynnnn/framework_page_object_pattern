package ui.jqueryscript;

import PageObject.PageGeneratorGeneric;
//import PageObject.jqueryscript.HomePageObject;
import PageObject.gofile.HomePageObject;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Level_13_File_Upload extends BaseTest{

        private WebDriver driver;
        private HomePageObject homePage;
        private String haGiangFile = "Ha Giang.jpg";
        private String hoiAnFile = "Hoi An.jpg";
        private String ninhBinhFile = "Ninh Binh.png";


        @Parameters({"url", "browser"})
        @BeforeClass
        public void beforeClass(String url, String browserName){
            driver = getBrowserDriver(url, browserName);
            homePage = PageGeneratorGeneric.getPage(HomePageObject.class, driver);
        }


//        @Test(enabled = false)
//        public void TC_01_Upload_Single_File(){
//            homePage.uploadMultipleFiles(driver, haGiangFile);
//            homePage.uploadMultipleFiles(driver, hoiAnFile);
//            homePage.uploadMultipleFiles(driver, ninhBinhFile);
//
//            homePage.sleepInSecond(2);
//
//            Assert.assertTrue(homePage.isFileLoadedSuccess(haGiangFile));
//            Assert.assertTrue(homePage.isFileLoadedSuccess(hoiAnFile));
//            Assert.assertTrue(homePage.isFileLoadedSuccess(ninhBinhFile));
//
//            homePage.clickActionUpload("start");
//            homePage.sleepInSecond(2);
//
//            Assert.assertTrue(homePage.isFileUploadedSuccess(haGiangFile));
//            Assert.assertTrue(homePage.isFileUploadedSuccess(hoiAnFile));
//            Assert.assertTrue(homePage.isFileUploadedSuccess(ninhBinhFile));
//        }
        @Test
        public void TC_02_Upload_Multiple_file(){
            Assert.assertTrue(homePage.isLoadingIconDisappear());
            homePage.clickToHomeSideBar();
            homePage.uploadMultipleFiles(driver, haGiangFile, hoiAnFile, ninhBinhFile);
            Assert.assertTrue(homePage.isUploadingIconDisappear());
            Assert.assertTrue(homePage.isPopupUploadSuccessDisplay());
            homePage.clickToOpenFolderButton();
            Assert.assertTrue(homePage.isFileLoadedSuccess(haGiangFile));
            Assert.assertTrue(homePage.isFileLoadedSuccess(hoiAnFile));
            Assert.assertTrue(homePage.isFileLoadedSuccess(ninhBinhFile));
        }

        @AfterClass
        public void afterClass(){

            driver.quit();
        }
}

