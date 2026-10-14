package PageObject.jqueryscript;

import PageUIs.jqueryscript.HomePageUI;
import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
    }

    public boolean isPageActiveByNumber(String pageNumber) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_PAGE_ACTIVE_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_PAGE_ACTIVE_NUMBER, pageNumber);
    }

    public void enterToHearderTextboxByName(String hearderName, String values) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_SEARCH, hearderName);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_SEARCH, values, hearderName);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_SEARCH, Keys.ENTER, hearderName);
    }

    public boolean isPageInfoDisplayed(String females, String country, String males, String total) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_PAGE_INFOR, females, country, males, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_PAGE_INFOR, females, country, males, total);
    }
}
