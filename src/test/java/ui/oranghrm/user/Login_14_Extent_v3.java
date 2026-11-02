package ui.oranghrm.user;

import PageObject.PageGeneratorGeneric;
import PageObject.orangeHRM.PageObject.AddEmployeePageObject;
import PageObject.orangeHRM.PageObject.DardboardPageObject;
import PageObject.orangeHRM.PageObject.EmployeeListPageObject;
import PageObject.orangeHRM.PageObject.LoginPageObject;
import PageObject.orangeHRM.editNavigation.ContactDetailPageObject;
import PageObject.orangeHRM.editNavigation.DependentDetailPageObject;
import PageObject.orangeHRM.editNavigation.JobDetailPageObject;
import PageObject.orangeHRM.editNavigation.PersonalDetailPageObject;
import com.relevantcodes.extentreports.LogStatus;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;

public class Login_14_Extent_v3 extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DardboardPageObject dardboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPageObject contactDetailPage;
    private JobDetailPageObject jobDetailPage;
    private DependentDetailPageObject dependentDetailPage;
    private String employeeID, adminUsername, adminPassword, employeeFirstName, employeeLastName;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void beforeClass(String appUrl, String browserName) {
        driver = getBrowserDriver(appUrl, browserName);
        loginPage = PageGeneratorGeneric.getPage(LoginPageObject.class, driver);

        adminUsername = "autotest";
        adminPassword = "Auto222$$$";
        employeeFirstName = "John";
        employeeLastName = "Terry_1";
    }

    @Test
    public void Employee_01_CreateNewEmployee(Method method) {
        ExtentManager.startTest(method.getName(), "Employee_01_CreateNewEmployee");
        ExtentManager.getTest().log(LogStatus.INFO, "NewEmployee - STEP 01: Enter to username and password with info " + adminUsername +"/" + adminPassword);

        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        loginPage.clickLoginbtn();
        loginPage.sleepInSecond(3);
        takeScreenshot();
        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee - STEP 02: Navigation to Darboard page");

        dardboardPage = PageGeneratorGeneric.getPage(DardboardPageObject.class, driver);
        verifyTrue(dardboardPage.isLoadingSpinnerDisappear(driver));

        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee - STEP 03: Navigation to Employee Search page");
        dardboardPage.clickToPIMModule();
        employeeListPage = PageGeneratorGeneric.getPage(EmployeeListPageObject.class, driver);
        verifyTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        employeeListPage.clickToAddEployeeBtn();
        takeScreenshot();

        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee - STEP 04: Navigation to AddEmployee page");
        addEmployeePage = PageGeneratorGeneric.getPage(AddEmployeePageObject.class, driver);
        verifyTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee - STEP 05: Add new employee");
        addEmployeePage.enterToFirtnameTextbox(employeeFirstName);
        addEmployeePage.enterToLastnameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveBtn();
        verifyTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee - STEP 06: Navigation to personalDetail page");
        personalDetailPage = PageGeneratorGeneric.getPage(PersonalDetailPageObject.class, driver);
        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));

        ExtentManager.getTest().log(LogStatus.INFO,"NewEmployee - STEP 07: Assert information");
        verifyEquals(personalDetailPage.getFirstnameTextboxValue(), employeeLastName);
//        verifyEquals(personalDetailPage.getLastnameTextboxValue(), employeeFirstName);
//        verifyEquals(personalDetailPage.getEmployeeIDValue(), employeeID);

        ExtentManager.endTest();
    }

    @Test(enabled = false)
    public void Employee_02_Switch_Page() {
        //Tu personal qua contact
        contactDetailPage = personalDetailPage.contactDetailPage(driver);

        //Tu contact qua job
        jobDetailPage = contactDetailPage.jobDetailPage(driver);

        //Tu job qua dependent
        dependentDetailPage = jobDetailPage.dependentDetailPage(driver);

        //Tu dependent qua personal
        personalDetailPage = dependentDetailPage.personalDetailPage(driver);

        //Tu personal qua job
        jobDetailPage = personalDetailPage.jobDetailPage(driver);
    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
