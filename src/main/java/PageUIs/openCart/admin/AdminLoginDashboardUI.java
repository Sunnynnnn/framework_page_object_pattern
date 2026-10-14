package PageUIs.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminLoginDashboardUI extends BasePage {
   public static final String CLOSED_BUTTON_POPUP = "xpath=//button[@class='close']";
   public static final String CUSTOMER_PAGE = "//li[@id= 'menu-customer']";
   public static final String CUSTOMER_LINK = "//a[not(@class = 'parent') and contains(string(),'Customers')]";
}
