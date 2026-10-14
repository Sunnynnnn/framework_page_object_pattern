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
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_10_By_Locator extends BaseTest {
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
    public void Employee_01_CreateNewEmployee() {
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        loginPage.clickLoginbtn();
        loginPage.sleepInSecond(3);

        dardboardPage = PageGeneratorGeneric.getPage(DardboardPageObject.class, driver);
        Assert.assertTrue(dardboardPage.isLoadingSpinnerDisappear(driver));
        dardboardPage.clickToPIMModule();

        employeeListPage = PageGeneratorGeneric.getPage(EmployeeListPageObject.class, driver);
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        employeeListPage.clickToAddEployeeBtn();

        addEmployeePage = PageGeneratorGeneric.getPage(AddEmployeePageObject.class, driver);
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        addEmployeePage.enterToFirtnameTextbox(employeeFirstName);
        addEmployeePage.enterToLastnameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveBtn();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        personalDetailPage = PageGeneratorGeneric.getPage(PersonalDetailPageObject.class, driver);
        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));

        Assert.assertEquals(personalDetailPage.getFirstnameTextboxValue(), employeeFirstName);
        Assert.assertEquals(personalDetailPage.getLastnameTextboxValue(), employeeLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDValue(), employeeID);
    }

    @Test
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
