package ui.oranghrm.user;

import PageObject.orangeHRM.PageObject.AddEmployeePageObject;
import PageObject.orangeHRM.PageObject.DardboardPageObject;
import PageObject.orangeHRM.PageObject.EmployeeListPageObject;
import PageObject.orangeHRM.PageObject.LoginPageObject;
import PageObject.orangeHRM.editNavigation.*;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_04_Page_Object_Pattern extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DardboardPageObject dardboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private String employeeID, adminUsername, adminPassword, employeeFirstName, employeeLastName;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void beforeClass(String appUrl, String browserName) {
        driver = getBrowserDriver(appUrl, browserName);
        loginPage = new LoginPageObject(driver);

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

        dardboardPage = new DardboardPageObject(driver);
        Assert.assertTrue(dardboardPage.isLoadingSpinnerDisappear(driver));
        dardboardPage.clickToPIMModule();

        employeeListPage = new EmployeeListPageObject(driver);
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        employeeListPage.clickToAddEployeeBtn();

        addEmployeePage = new AddEmployeePageObject(driver);
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        addEmployeePage.enterToFirtnameTextbox(employeeFirstName);
        addEmployeePage.enterToLastnameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveBtn();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        personalDetailPage = new PersonalDetailPageObject(driver);
        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));

        Assert.assertEquals(personalDetailPage.getFirstnameTextboxValue(), employeeFirstName);
        Assert.assertEquals(personalDetailPage.getLastnameTextboxValue(), employeeLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDValue(), employeeID);
    }

    @Test
    public void Employee_02_EditEmployee() {

    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
