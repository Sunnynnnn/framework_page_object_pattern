package ui.oranghrm.user;

import PageObject.PageGeneratorGeneric;
import PageObject.orangeHRM.PageObject.*;
import PageObject.orangeHRM.editNavigation.*;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_08_Page_Navigator extends BaseTest {
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

    @Test()
    public void Employee_03_Dynamic_link() {
        //Tu personal qua contact
        personalDetailPage.openEditNavigatorPageName("Contact Details");
        contactDetailPage = PageGeneratorGeneric.getPage(ContactDetailPageObject.class, driver);

                //Tu contact qua job
        contactDetailPage.openEditNavigatorPageName("Job");
        jobDetailPage = PageGeneratorGeneric.getPage(JobDetailPageObject.class, driver);

                //Tu job qua dependent
        jobDetailPage.openEditNavigatorPageName("Dependents");
        dependentDetailPage = PageGeneratorGeneric.getPage(DependentDetailPageObject.class, driver);

                //Tu dependent qua personal
       dependentDetailPage.openEditNavigatorPageName("Personal Details");
       personalDetailPage = PageGeneratorGeneric.getPage(PersonalDetailPageObject.class, driver);

                //Tu personal qua job
        personalDetailPage.openEditNavigatorPageName("Job");
        jobDetailPage = PageGeneratorGeneric.getPage(JobDetailPageObject.class, driver);
    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
