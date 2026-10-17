package PageObject.jqueryscript;

import PageUIs.jqueryscript.HomePageUI;
import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void clickToActionByCountryName(String countryName, String action) {
        waitElementClickable(driver, HomePageUI.DYNAMIC_ACTION_BY_COUNTRY_NAME, countryName, action);
        clickToElement(driver, HomePageUI.DYNAMIC_ACTION_BY_COUNTRY_NAME, countryName, action);
    }

    public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String value) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        int columnIndex = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        waitElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, value, rowIndex, String.valueOf(columnIndex));
    }

    public void clickToLoadDataButton() {
        waitElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void selectToDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String valueSelect) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        int columnIndex = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        waitElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, valueSelect, rowIndex, String.valueOf(columnIndex));
    }

    public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        int columnIndex = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        waitElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        clickToElement(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
    }

    public List<String> getColumnAllValueByColumnNumber(String columnName) {
        List<WebElement> allPage = getListElement(driver, HomePageUI.ALL_PAGE_NUMBER);
        List<String> allValueByColumnName = new ArrayList<String>();

        waitElementVisible(driver, HomePageUI.DYNAMIC_COLUMN_NAME, columnName);
        int columnIndex = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_NAME, columnName) + 1;

        for(WebElement page : allPage){
            page.click();
            List<WebElement> columnAllValueElement = getListElement(driver, HomePageUI.DYNAMIC_INDEX_BY_COLUMN_NAME, String.valueOf(columnIndex));
            for(WebElement value : columnAllValueElement){
                allValueByColumnName.add(value.getText());
            }
        }
        return allValueByColumnName;
    }

    public void actionToRowByIndex(String rowIndex, String action) {
        waitElementClickable(driver, HomePageUI.DYNAMIC_ACTION_BUTTON, rowIndex, action);
        clickToElement(driver, HomePageUI.DYNAMIC_ACTION_BUTTON, rowIndex, action);
    }
}
