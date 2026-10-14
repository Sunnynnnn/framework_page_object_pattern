package PageUIs.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class UserRegisterUI extends BasePage {
    public static String FIRSTNAME_TEXTBOX = "//input[@name='firstname']";
    public static String LASTNAME_TEXTBOX = "//input[@name='lastname']";
    public static String EMAIL_TEXTBOX = "//input[@name='email']";
    public static String TELENUMBER_TEXTBOX = "//input[@name='telephone']";
    public static String PASSWORD_TEXTBOX = "//input[@name='password']";
    public static String CONFIRM_PASSWORD_TEXTBOX = "//input[@name='confirm']";
    public static String POLICY_CHECKBOX = "//input[@name='agree']";
    public static String CONTINUE_BUTTON_REGISTER = "//input[@value='Continue']";

    public static final String LOGOUT_LINK = "//a[text()='Logout']";


    public static final String CONTINUE_BUTTON = "//a[text()='Continue']";
    public static final String CREATED_ACCOUNT_SUCCESS_MESSAGE = "//div[@id='common-success']//h1";
}
