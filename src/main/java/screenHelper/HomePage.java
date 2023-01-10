package screenHelper;

import base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class HomePage extends ScreenBase {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/text1\"]")
    private List<WebElement> homePageOptions;

    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id='android:id/list']")
    private WebElement homePageLists;

    @AndroidFindBy(xpath = "android.view.ViewGroup[@resource-id=\"android:id/action_bar\"]")
    private WebElement actionBarHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"View\"]")
    private WebElement viewCTA;


    public void validatePageHeader() {
        Assert.assertTrue(homePageLists.isDisplayed(), "Page list section should be displayed");
        Assert.assertTrue(actionBarHeader.getText().equals("API Demos"),
                "Header of the homepage screen should be API Demos and found is :-> " + actionBarHeader.getText());
    }

    public void validateHomePageCTAOptions() {
        List homePageOptionList = Arrays.asList("Access'ibility", "Accessibility", "Animation", "App", "Content", "Graphics", "Media", "NFC", "OS", "Preference", "Text", "Views");

        for (int i = 0; i < homePageOptions.size(); i++) {
            Assert.assertTrue(homePageOptions.get(i).getText().equals(homePageOptionList.get(i)),
                    "Expected option is:-> " + homePageOptionList.get(i));
        }
    }

    public void clickViewCTA() {
        viewCTA.click();
    }

}
