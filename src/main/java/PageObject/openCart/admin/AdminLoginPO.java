package PageObject.openCart.admin;

import PageObject.PageGeneratorGeneric;
import PageUIs.openCart.admin.AdminLoginUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminLoginPO extends BasePage {
    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsername(String adminUsername) {
        waitElementVisible(driver, AdminLoginUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, AdminLoginUI.USERNAME_TEXTBOX, adminUsername);
    }

    public void enterToPassword(String adminPassword) {
        waitElementVisible(driver, AdminLoginUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginUI.PASSWORD_TEXTBOX, adminPassword);
    }

    public AdminLoginDashboardPO clickToLoginButton() {
        waitElementVisible(driver, AdminLoginUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginUI.LOGIN_BUTTON);
        return PageGeneratorGeneric.getPage(AdminLoginDashboardPO.class, driver);
    }
}
