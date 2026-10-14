package PageUIs.jqueryscript;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_NUMBER = "XPATH=//a[@class='qgrd-pagination-page-link' and text() = '%s']";
    public static final String DYNAMIC_PAGE_ACTIVE_NUMBER = "XPATH=//a[@class='qgrd-pagination-page-link active' and text() = '%s']";
    public static final String DYNAMIC_TEXTBOX_SEARCH = "XPATH=//div[text() = '%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_PAGE_INFOR = "XPATH=//td[@data-key = 'females' and text()= '%s']" +
            "/following-sibling::td[@data-key = 'country' and text()= '%s']" +
            "/following-sibling::td[@data-key = 'males' and text()= '%s']" +
            "/following-sibling::td[@data-key = 'total' and text()= '%s']";



    //td[@data-key = 'females' and text()= '384187']/following-sibling::td[@data-key = 'country' and text()= 'Afghanistan']
    // /following-sibling::td[@data-key = 'males' and text()= '407124']
    // /following-sibling::td[@data-key = 'total' and text()= '791312']
}



