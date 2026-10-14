package core;

import PageObject.PageGeneratorGeneric;
import PageObject.openCart.admin.AdminLoginPO;
import PageObject.openCart.user.UserHomePO;
import PageObject.orangeHRM.editNavigation.*;
import PageUIs.BasePageUI;
import PageUIs.openCart.user.UserRegisterUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public static BasePage getInstance(){
        return new BasePage();
    }
    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String...dynamicValues) {
        getElement(driver, castRestParameter(locator, dynamicValues)).click();
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String...dynamicValues) {
        return getElement(driver, castRestParameter(locator, dynamicValues)).getText();
    }

    public void openPageUrl(WebDriver driver, String pageurl) {
        driver.get(pageurl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public Alert waitAlertPresent(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }
    public void acceptToAlert(WebDriver driver){
        waitAlertPresent(driver).accept();
    }
    public void cancelToAlert(WebDriver driver){
        waitAlertPresent(driver).dismiss();
    }
    public String getTextAlert(WebDriver driver){
        return waitAlertPresent(driver).getText();
    }
    public void sendkeyToAlert(WebDriver driver, String valueAlert){
        waitAlertPresent(driver).sendKeys(valueAlert);
    }


    public void swithToWindowID(WebDriver driver, String windowID){
        Set<String> allWindows = driver.getWindowHandles();
        for(String window:allWindows){
            if(!window.equals(windowID)){
                driver.switchTo().window(window);
                break;
            }
        }
    }
    public void swittchToWindowByTitle(WebDriver driver, String expectTitle){
        Set<String> allWindows = driver.getWindowHandles();
        for(String window : allWindows){
            driver.switchTo().window(window);
            String pageTitle = driver.getTitle();
            if(pageTitle.equals(expectTitle)){
                break;
            }
        }
        sleepInSecond(2);
    }
    public void sleepInSecond(int timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendkeyToElement(WebDriver driver, String locator, String keyTosend){
        getElement(driver, locator).sendKeys(keyTosend);
    }

    public void sendkeyToElement(WebDriver driver, String locator, CharSequence keyTosend, String...dynamicValues){
        getElement(driver, castRestParameter(locator, dynamicValues)).sendKeys(keyTosend);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String valueItem){
        new Select(getElement(driver, locator))
                .selectByVisibleText(valueItem);
    }
    public String getSelectedItemInDropdow(WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }
    public boolean isDropdowMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).isMultiple();
    }
    public List<WebElement> getListElement(WebDriver driver, String locator){
       return driver.findElements(getByLocator(locator));
    }
    public void selectItemInSelectableDropdown(WebDriver driver, String parentLocator, String childLocator, String textItem){
        clickToElement(driver, parentLocator);
        sleepInSecond(1);
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
        List<WebElement> allItems = getListElement(driver, childLocator);
        for(WebElement item : allItems){
            if(item.getText().trim().equals(textItem)){
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName){
        return getElement(driver, locator).getDomAttribute(attributeName);
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String...values){
        return getElement(driver, castRestParameter(locator, values)).getDomAttribute(attributeName);
    }

    public String getElementProperty(WebDriver driver, String locator, String propertyName){
        return getElement(driver, locator).getDomProperty(propertyName);
    }
    public String getElementProperty(WebDriver driver, String locator, String propertyName, String...values){
        return getElement(driver, castRestParameter(locator, values)).getDomProperty(propertyName);
    }

    public String getElementCss(WebDriver driver, String locator, String propertyname){
        return getElement(driver, locator).getCssValue(propertyname);
    }
    public String getHexaByRGBA(String rgbaColor){
       return Color.fromString(rgbaColor).asHex().toUpperCase();
    }
    public int getListElementNumber(WebDriver driver, String locator){
        return getListElement(driver, locator).size();
    }
    public void checkToCheckbox(WebDriver driver, String locator){
        if(!isElementSelected(driver, locator)){
            clickToElement(driver, locator);
        }
    }
    public void uncheckToCheckbox(WebDriver driver, String locator){
        if(isElementSelected(driver, locator)){
            clickToElement(driver, locator);
        }
    }
    public boolean isElementDisplayed(WebDriver driver, String locator){
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String...dynamicValues){
        return getElement(driver, castRestParameter(locator, dynamicValues)).isDisplayed();
    }
    public boolean isElementSelected(WebDriver driver, String locator){
        return getElement(driver, locator).isSelected();
    }
    public boolean isElementSelected(WebDriver driver, String locator, String...values){
        return getElement(driver, castRestParameter(locator, values)).isSelected();
    }
    public boolean isElementEnabled(WebDriver driver, String locator){
        return getElement(driver, locator).isEnabled();
    }
    public void switchToFrame(WebDriver driver, String locator){
        driver.switchTo().frame(getElement(driver, locator));
    }
    public void switchDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    public void doubleClick(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }
    public void rightClic(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }
    public void moveToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }
    public void dragAndDrop(WebDriver driver, String sourceLocator, String sourceTarget){
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, sourceTarget)).perform();
    }
    public void sendkeyBoardToElement(WebDriver driver, String locator, String keys){
        new Actions(driver).sendKeys(getElement(driver, locator), keys).perform();
    }
    public Object executeForBrowser(WebDriver driver, String javaScript){
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }
    public void scrollToBottomPage(WebDriver driver, String locator){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeigh)");
    }
    public void hitLightElement(WebDriver driver, String locator){
        WebElement element = getElement(driver, locator);
        String orginalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]",element,"border: 4px solid red; border");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("argument[0].setAttribute('style', arguments[1])", element,orginalStyle);
    }
    public void clickToElementJS(WebDriver driver, String locator){
        ((JavascriptExecutor) driver).executeScript("argument[0].click();",getElement(driver, locator));
        sleepInSecond(3);
    }
    public void getElementTextByJS(WebDriver driver, String locator){
        ((JavascriptExecutor) driver).executeScript("argument[0].textContent();",getElement(driver, locator));
        sleepInSecond(3);
    }
    public void scollToElementOnTop(WebDriver driver, String locator){
        ((JavascriptExecutor) driver).executeScript("argument[0].scollInToView(true);",getElement(driver, locator));
    }
    public void scollToElementOnDown(WebDriver driver, String locator){
        ((JavascriptExecutor) driver).executeScript("argument[0].scollInToView(false);",getElement(driver, locator));
    }
    public String getAttributeInDOM(WebDriver driver, String locator, String attributeName){
        return (String) ((JavascriptExecutor) driver).executeScript("return argument[0].getAttribute('" + attributeName + "');",getElement(driver, locator));
    }
    public String getElementValidateMessage(WebDriver driver, String locator, String attributeName){
       return (String) ((JavascriptExecutor) driver).executeScript("return argument[0].validationMessage",getElement(driver, locator));
    }
    public Boolean isImageLoaded(WebDriver driver, String locator) {
        return (Boolean) ((JavascriptExecutor) driver)
                .executeScript(
                        "return arguments[0].complete && " +
                                "typeof arguments[0].naturalWidth != 'undefined' && " +
                                "arguments[0].naturalWidth > 0",
                        getElement(driver, locator)
                );
    }

    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public WebElement waitElementVisible(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public WebElement waitElementVisible(WebDriver driver, String locator, String...dynamicValues){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castRestParameter(locator, dynamicValues))));
    }
    public List<WebElement> waitListElementVisible(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }
    public Boolean waitElementSelected(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }
    public void waitElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitElementClickable(WebDriver driver, String locator, String...dynamicValues){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, dynamicValues))));
    }
    public Boolean waitElementInvisible(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public Boolean waitElementInvisible(WebDriver driver, String locator, String...dynamicValues){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator, dynamicValues))));
    }
    public Boolean waitListElementInvisible(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));
    }
    public Boolean waitListElementInvisible(WebDriver driver, String locator, String...values){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, castRestParameter(locator, values))));
    }
    public WebElement waitElementPresence(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }
    public List<WebElement> waitListElementPresence(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public boolean isLoadingSpinnerDisappear(WebDriver driver){
         return waitListElementInvisible(driver, BasePageUI.SPINNER_ICON);
    }

    public JobDetailPageObject jobDetailPage(WebDriver driver){
        waitElementVisible(driver, BasePageUI.JOB_DETAIL_LINK);
        clickToElement(driver, BasePageUI.JOB_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(JobDetailPageObject.class, driver);
    }
    public PersonalDetailPageObject personalDetailPage(WebDriver driver) {
        waitElementVisible(driver, BasePageUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, BasePageUI.PERSONAL_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(PersonalDetailPageObject.class, driver);
    }
    public DependentDetailPageObject dependentDetailPage(WebDriver driver) {
        waitElementVisible(driver, BasePageUI.DEPENDENT_DETAIL_LINK);
        clickToElement(driver, BasePageUI.DEPENDENT_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(DependentDetailPageObject.class, driver);
    }
    public ContactDetailPageObject contactDetailPage(WebDriver driver) {
        //wait
        //Hàm là static là thuộc class > có thể gọi trực tiếp
        waitElementVisible(driver, BasePageUI.CONTACT_DETAIL_LINK);
        //click
        clickToElement(driver, BasePageUI.CONTACT_DETAIL_LINK);
        return PageGeneratorGeneric.getPage(ContactDetailPageObject.class, driver);
    }

    //Open Cart
    public void clickToMyAccountLink(WebDriver driver) {
        waitElementVisible(driver, BasePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, BasePageUI.MY_ACCOUNT_LINK);
    }

    public UserHomePO clickToLogoutLinkUserSite(WebDriver driver) {
        waitElementVisible(driver, UserRegisterUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterUI.LOGOUT_LINK);
        waitElementVisible(driver, UserRegisterUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterUI.CONTINUE_BUTTON);
        return  PageGeneratorGeneric.getPage(UserHomePO.class, driver);
    }

    public AdminLoginPO openAdminSite(WebDriver driver, String adminUrl) {
        openPageUrl(driver, adminUrl);
        return PageGeneratorGeneric.getPage(AdminLoginPO.class, driver);
    }


    public UserHomePO openUserSite(WebDriver driver, String userUrl) {
        openPageUrl(driver, userUrl);
        return PageGeneratorGeneric.getPage(UserHomePO.class, driver);
    }

    public AdminLoginPO clickToLogoutLink(WebDriver driver) {
        waitElementVisible(driver, BasePageUI.ADMIN_LOGOUT_BUTTON);
        clickToElement(driver, BasePageUI.ADMIN_LOGOUT_BUTTON);
        return PageGeneratorGeneric.getPage(AdminLoginPO.class, driver);
    }

    public void clickToMyAccountLinkFooter(WebDriver driver) {
        waitElementVisible(driver, BasePageUI.MY_ACCOUNT_LINK_FOOTER);
        clickToElement(driver, BasePageUI.MY_ACCOUNT_LINK_FOOTER);
    }

    public void openUrlByNewTAB(WebDriver driver, String adminUrl) {
        driver.switchTo().newWindow(WindowType.TAB).get(adminUrl);
    }

    public String getCurrentWindowID(WebDriver driver){
        return driver.getWindowHandle();
    }

    public By getByLocator(String locatorType){
        System.out.println("locatorType = " + locatorType);
        if(locatorType == null || locatorType.isEmpty()){
            throw new IllegalArgumentException("locator type cannot be null or empty.");
        }

        String[] locatorArr = locatorType.split("=", 2);
        String locatorValue = locatorArr[1].trim();

        System.out.println("locator prefix:" + locatorType);

        switch (locatorArr[0].toLowerCase().trim()){
            case "id":
                return By.id(locatorValue);
            case "class":
                return By.className(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "css":
                return By.cssSelector(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            default:
                throw new IllegalArgumentException("locator is not supported");
        }
    }

    public String castRestParameter(String locator, String...values){
        locator = String.format(locator, (Object[]) values);
        return locator;
    }
}




















