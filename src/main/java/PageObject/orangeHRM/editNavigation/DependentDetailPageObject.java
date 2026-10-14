package PageObject.orangeHRM.editNavigation;

import org.openqa.selenium.WebDriver;

public class DependentDetailPageObject extends EditNavigatorPageObject {
    private WebDriver driver;

    public DependentDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
