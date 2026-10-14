package PageObject.orangeHRM.PageObject;

import PageUIs.orangeHRM.PageUIs.EmployeeListPageUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class EmployeeListPageObject extends BasePage {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddEployeeBtn() {
        waitElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
        clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
    }
}
