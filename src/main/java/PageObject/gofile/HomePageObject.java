package PageObject.gofile;

import PageUIs.gofile.HomePageUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoadingIconDisappear() {
        return waitElementInvisible(driver, HomePageUI.LOADING_ICON);
    }

    public boolean isUploadingIconDisappear() {
        return waitListElementInvisible(driver, HomePageUI.UPLOADING_ICON);
    }

    public boolean isStatusUploadSuccessDisappear() {
        return waitListElementInvisible(driver, HomePageUI.STATUS_UPLOAD_SUCCESS);
    }

    public boolean isFileLoadedSuccess(String...fileNames) {
        waitElementVisible(driver, HomePageUI.IS_FILE_UPLOADED, fileNames);
        return isElementDisplayed(driver, HomePageUI.IS_FILE_UPLOADED, fileNames);
    }

    public boolean isPopupUploadSuccessDisplay() {
        waitElementVisible(driver, HomePageUI.POPUP_UPLOAD_SUCCESS);
        return isElementDisplayed(driver, HomePageUI.POPUP_UPLOAD_SUCCESS);
    }

    public void clickToHomeSideBar() {
        waitElementVisible(driver, HomePageUI.HOME_SIDEBAR);
        clickToElement(driver, HomePageUI.HOME_SIDEBAR);
    }

    public void clickToOpenFolderButton() {
        waitElementClickable(driver, HomePageUI.OPEN_FOLDER_BUTTON);
        clickToElement(driver, HomePageUI.OPEN_FOLDER_BUTTON);
    }
}
