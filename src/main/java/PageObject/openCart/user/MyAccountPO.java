package PageObject.openCart.user;

import PageUIs.openCart.user.MyAccountUI;
import PageUIs.openCart.user.UserRegisterUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class MyAccountPO extends BasePage {
    WebDriver driver;

    public MyAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyAccountPageDisplayed() {
        waitElementVisible(driver, MyAccountUI.MYACCOUNT_PAGE_TITLE);
        return isElementDisplayed(driver, MyAccountUI.MYACCOUNT_PAGE_TITLE);
    }
}
