package screenHelper;

import base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ChronometerPage extends ScreenBase {

    public ChronometerPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "android.view.ViewGroup[@resource-id=\"android:id/action_bar\"]")
    private WebElement actionBarHeader;

    @AndroidFindBy(id = "io.appium.android.apis:id/chronometer")
    private WebElement chrometerTime;

    @AndroidFindBy(id = "io.appium.android.apis:id/start")
    private WebElement startCTA;

    @AndroidFindBy(id = "io.appium.android.apis:id/stop")
    private WebElement stopCta;

    @AndroidFindBy(id = "io.appium.android.apis:id/reset")
    private WebElement resetCta;

    @AndroidFindBy(id = "io.appium.android.apis:id/set_format")
    private WebElement setFormatCta;

    @AndroidFindBy(id = "io.appium.android.apis:id/clear_format")
    private WebElement clearFormatCta;

    public void validatePageHeader() {
        Assert.assertTrue(actionBarHeader.getText().equals("Views/Chronometer"),
                "Chronometer screen page header should be Views/Chronometer and found is:-> " + actionBarHeader.getText());
    }

    public void validateChronometerPageParametersnCTAOptions() {
        Assert.assertTrue(chrometerTime.isDisplayed(), "Chronometer Time format should be displayed");
        Assert.assertTrue(startCTA.isDisplayed(), "Start CTA button should be displayed");
        Assert.assertTrue(stopCta.isDisplayed(), "Stop CTA button should be displayed");
        Assert.assertTrue(resetCta.isDisplayed(), "Reset CTA button should be displayed");
        Assert.assertTrue(setFormatCta.isDisplayed(), "Set Format CTA button should be displayed");
        Assert.assertTrue(clearFormatCta.isDisplayed(), "Clear Format CTA button should be displayed");
        Assert.assertEquals(chrometerTime.getText(), "Initial format: 00:00",
                "By Default Chronometer time should be Initial format: 00:00 and found is:-> " + chrometerTime.getText());
    }

    public void validateStartStopTimeFeature() throws InterruptedException {
        startCTA.click();
        Thread.sleep(2000);
        stopCta.click();

        Assert.assertEquals(chrometerTime.getText(), "Initial format: 00:02",
                "Initial format Time should be set to Initial format: 00:02 and found is :-> " + chrometerTime.getText());
    }

    public void validateResetFeature() {
        resetCta.click();
        Assert.assertEquals(chrometerTime.getText(), "Initial format: 00:00",
                "Initial format Time should be set to Initial format: 00:00 and found is :-> " + chrometerTime.getText());
    }

}
