package PageObject.orangeHRM.editNavigation;

import org.openqa.selenium.WebDriver;

public class JobDetailPageObject extends EditNavigatorPageObject {
    private WebDriver driver;

    public JobDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
