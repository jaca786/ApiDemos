package screenHelper;

import base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static utils.CommonUtils.scrollDown;
import static utils.CommonUtils.swipeToElement;

public class ViewPage extends ScreenBase {

    public ViewPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='android:id/list']")
    private WebElement viewPageLists;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\"]")
    private List<WebElement> viewPageOptions;

    @AndroidFindBy(xpath = "android.view.ViewGroup[@resource-id=\"android:id/action_bar\"]")
    private WebElement actionBarHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Chronometer\"]")
    private WebElement chronometerCTA;

    public void validatePageHeader() {
        Assert.assertTrue(viewPageLists.isDisplayed(), "Page list section should be displayed");
        Assert.assertTrue(actionBarHeader.getText().equals("API Demos"),
                "Header of the viewPage screen should be API Demos and found is :-> " + actionBarHeader.getText());
    }

    public void validateViewPageCTAOptions() {
        List viewPageOptionList = Arrays.asList("Animation", "Auto Complete", "Buttons", "Chronometer", "Controls", "Custom", "Date Widgets", "Drag and Drop", "Expandable Lists", "Focus", "Gallery", "Game Controller Input", "Grid", "Hover Events", "ImageButton",
                "ImageSwitcher", "ImageView", "Layout Animation", "Layouts", "Lists", "Picker", "Popup Menu", "Progress Bar", "Radio Group", "Rating Bar", "Rotating Button", "ScrollBars", "Search View", "Secure View", "Search View", "Secure View", "Seek Bar", "Spinner",
                "Splitting Touches across Views", "Switches", "System UI Visibility", "Tabs", "TextClock", "TextFields", "TextSwitcher", "Visibility", "WebView", "WebView2", "WebView3");

        for (int i = 0; i < viewPageOptions.size(); i++) {
            scrollDown();
            swipeToElement(viewPageOptions.get(i));
            Assert.assertTrue(viewPageOptions.get(i).getText().equals(viewPageOptionList.get(i)),
                    "Expected option is:-> " + viewPageOptionList.get(i));
        }
    }

    public void clickChronometerCTA() {
        swipeToElement(chronometerCTA);
        chronometerCTA.click();
    }

}
