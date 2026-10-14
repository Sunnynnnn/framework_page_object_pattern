package ui.oranghrm.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_01_DRY {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    public void Login_01_Empty()
    {

    }
    @Test
    public void Login_02_Invalid_Username()
    {

    }
    @Test
    public void Login_03_Invalid_Password()
    {

    }

    @Test
    public void Login_04_valid_username_password()
    {

    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
