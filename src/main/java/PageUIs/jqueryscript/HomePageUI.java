package PageUIs.jqueryscript;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_NUMBER = "XPATH=//a[@class='qgrd-pagination-page-link' and text() = '%s']";
    public static final String DYNAMIC_PAGE_ACTIVE_NUMBER = "XPATH=//a[@class='qgrd-pagination-page-link active' and text() = '%s']";
    public static final String DYNAMIC_TEXTBOX_SEARCH = "XPATH=//div[text() = '%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_PAGE_INFOR = "XPATH=//td[@data-key = 'females' and text()= '%s']" +
            "/following-sibling::td[@data-key = 'country' and text()= '%s']" +
            "/following-sibling::td[@data-key = 'males' and text()= '%s']" +
            "/following-sibling::td[@data-key = 'total' and text()= '%s']";
    public static final String DYNAMIC_ACTION_BY_COUNTRY_NAME = "XPATH=//td[text()='%s']/preceding-sibling::td[contains(@class,'actions')]" +
            "/button[contains(@class,'%s')]";

    public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "Xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "Xpath=//tr[%s]/td[%s]/input";
    public static final String LOAD_DATA_BUTTON = "XPATH=//button[@id='load']";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX  = "Xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX  = "XPATH=//tr[%s]/td[%s]//input";
    public static final String DYNAMIC_ACTION_BUTTON = "XPATH=//tr[%s]/td[contains(@id, 'rowButton')]//button[contains(@title,'%s')]";
    public static final String ALL_PAGE_NUMBER = "XPATH=//ul[contains(@class,'pagination')]/li";
    public static final String DYNAMIC_INDEX_BY_COLUMN_NAME = "XPATH=//td[%s]";
    public static final String DYNAMIC_COLUMN_NAME = "Xpath=//div[text() = '%s']/ancestor::th/preceding-sibling::th";
}



