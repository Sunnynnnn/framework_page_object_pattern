package PageObject.orangeHRM.editNavigation;

import PageObject.PageGeneratorGeneric;
import PageUIs.orangeHRM.editNavigation.EditNavigatorPageUI;
import core.BasePage;
import org.openqa.selenium.WebDriver;

public class EditNavigatorPageObject extends BasePage {
    WebDriver driver;

    public EditNavigatorPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public JobDetailPageObject jobDetailPage(){
        waitElementVisible(driver, EditNavigatorPageUI.JOB_DETAIL_LINK);
        clickToElement(driver, EditNavigatorPageUI.JOB_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(JobDetailPageObject.class, driver);
    }
    public PersonalDetailPageObject personalDetailPage(WebDriver driver) {
        waitElementVisible(driver, EditNavigatorPageUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EditNavigatorPageUI.PERSONAL_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(PersonalDetailPageObject.class, driver);
    }
    public DependentDetailPageObject dependentDetailPage(WebDriver driver) {
        waitElementVisible(driver, EditNavigatorPageUI.DEPENDENT_DETAIL_LINK);
        clickToElement(driver, EditNavigatorPageUI.DEPENDENT_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(DependentDetailPageObject.class, driver);
    }
    public ContactDetailPageObject contactDetailPage(WebDriver driver) {
        //wait
        //Hàm là static là thuộc class > có thể gọi trực tiếp
        waitElementVisible(driver, EditNavigatorPageUI.CONTACT_DETAIL_LINK);
        //click
        clickToElement(driver, EditNavigatorPageUI.CONTACT_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(ContactDetailPageObject.class, driver);
    }

    //Cach 2: 1 ham cho 10 page
    public void openEditNavigatorPageName(String pageName){
        waitElementVisible(driver, EditNavigatorPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, EditNavigatorPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
    }
}
