package PageObject.openCart.admin;

import PageObject.PageGeneratorGeneric;
import PageUIs.openCart.admin.AdminLoginDashboardUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminLoginDashboardPO extends BasePage {
    WebDriver driver;

    public AdminLoginDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public void closedPopup(WebDriver driver) {
        waitElementVisible(driver, AdminLoginDashboardUI.CLOSED_BUTTON_POPUP);
        clickToElement(driver, AdminLoginDashboardUI.CLOSED_BUTTON_POPUP);
    }

    public AdminCustomerPO openCustomerPage() {
        waitElementVisible(driver, AdminLoginDashboardUI.CUSTOMER_PAGE);
        clickToElement(driver, AdminLoginDashboardUI.CUSTOMER_PAGE);
        waitElementVisible(driver, AdminLoginDashboardUI.CUSTOMER_LINK);
        clickToElement(driver, AdminLoginDashboardUI.CUSTOMER_LINK);
        return PageGeneratorGeneric.getPage(AdminCustomerPO.class, driver);
    }

//    public AdminCustomerPO openCustomerPage() {
//    }
}
