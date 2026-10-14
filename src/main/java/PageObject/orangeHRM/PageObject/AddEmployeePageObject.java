package PageObject.orangeHRM.PageObject;

import PageUIs.orangeHRM.PageUIs.AddEmployeePageUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageObject extends BasePage {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirtnameTextbox(String firstName) {
        waitElementVisible(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastnameTextbox(String lastName) {
        waitElementVisible(driver, AddEmployeePageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePageUI.LASTNAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementProperty(driver,AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void clickToSaveBtn() {
        waitElementClickable(driver, AddEmployeePageUI.ADD_BUTTON);
        clickToElement(driver, AddEmployeePageUI.ADD_BUTTON);
    }
}
