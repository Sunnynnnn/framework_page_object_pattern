package PageUIs.gofile;

public class HomePageUI {
    public static final String LOADING_ICON = "CSS=div.animate-spin";
    public static final String UPLOADING_ICON ="css=svg.animate-spin";
    public static final String STATUS_UPLOAD_SUCCESS="css=div.pointer-events-auto[role='status']";
    public static final String IS_FILE_UPLOADED = "xpath=//div[@data-type='file']//p[contains(@class,'text-white') and text()='%s']";
    public static final String HOME_SIDEBAR = "xpath=//nav[@aria-label='Main']//span[text()='Home']/parent::a";
    public static final String POPUP_UPLOAD_SUCCESS = "xpath=//div[@role='dialog']//h2[text()='Upload complete']";
    public static final String OPEN_FOLDER_BUTTON = "xpath=//button[contains(string(),'Open folder')]";
}
