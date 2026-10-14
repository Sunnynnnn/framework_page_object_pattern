package PageObject.orangeHRM.editNavigation;

import PageUIs.orangeHRM.editNavigation.PersonalDetailPageUI;
import org.openqa.selenium.WebDriver;

public class PersonalDetailPageObject extends EditNavigatorPageObject {
    private WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstnameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.FIRSTNAME_TEXTBOX);
        return getElementProperty(driver, PersonalDetailPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastnameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.LASTNAME_TEXTBOX);
        return getElementProperty(driver, PersonalDetailPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getEmployeeIDValue() {
        waitElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementProperty(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }
}
