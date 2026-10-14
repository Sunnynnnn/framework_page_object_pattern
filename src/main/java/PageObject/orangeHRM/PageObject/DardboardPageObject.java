package PageObject.orangeHRM.PageObject;

import PageUIs.orangeHRM.PageUIs.DardboardPageUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class DardboardPageObject extends BasePage {
    private WebDriver driver;

    public DardboardPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToPIMModule() {
        waitElementClickable(driver, DardboardPageUI.PIM_MODULE);
        clickToElement(driver, DardboardPageUI.PIM_MODULE);
    }
}
