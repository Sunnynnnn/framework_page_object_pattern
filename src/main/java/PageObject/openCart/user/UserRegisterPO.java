package PageObject.openCart.user;

import PageUIs.openCart.user.UserRegisterUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class UserRegisterPO extends BasePage {
    WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstName(String firstName) {
        waitElementVisible(driver, UserRegisterUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastName(String lastName) {
        waitElementVisible(driver, UserRegisterUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterUI.LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailAdress(String emailAdress) {
        waitElementVisible(driver, UserRegisterUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterUI.EMAIL_TEXTBOX, emailAdress);
    }

    public void enterToTeleNumber(String teleNumber) {
        waitElementVisible(driver, UserRegisterUI.TELENUMBER_TEXTBOX);
        sendkeyToElement(driver, UserRegisterUI.TELENUMBER_TEXTBOX, teleNumber);
    }

    public void enterToPassword(String passWord) {
        waitElementVisible(driver, UserRegisterUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterUI.PASSWORD_TEXTBOX, passWord);
    }

    public void enterToConfirmPass(String ConfirmPassWord) {
        waitElementVisible(driver, UserRegisterUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterUI.CONFIRM_PASSWORD_TEXTBOX, ConfirmPassWord);
    }

    public void acceptPrivacyCheckbox() {
        waitElementVisible(driver, UserRegisterUI.POLICY_CHECKBOX);
        clickToElement(driver, UserRegisterUI.POLICY_CHECKBOX);
    }

    public void clickToContinueButton() {
        waitElementVisible(driver, UserRegisterUI.CONTINUE_BUTTON_REGISTER);
        clickToElement(driver, UserRegisterUI.CONTINUE_BUTTON_REGISTER);
    }

    public boolean isSuccessMessageDisplayed() {
        waitElementVisible(driver, UserRegisterUI.CREATED_ACCOUNT_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, UserRegisterUI.CREATED_ACCOUNT_SUCCESS_MESSAGE);
    }
}
