package PageObject.openCart.user;

import PageObject.PageGeneratorGeneric;
import PageUIs.openCart.user.UserHomeUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class UserHomePO extends BasePage {
    WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPO clickToRegisterLink() {
        waitElementVisible(driver, UserHomeUI.REGISTER_LINK);
        clickToElement(driver, UserHomeUI.REGISTER_LINK);
        return PageGeneratorGeneric.getPage(UserRegisterPO.class, driver);
    }
}
