package base;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import screenHelper.ChronometerPage;
import screenHelper.HomePage;
import screenHelper.ViewPage;
import utils.AppiumServer;
import utils.CommonUtils;

import java.io.IOException;

public class BaseTest {

    public static AndroidDriver driver;
    public static HomePage homePage;
    public static ViewPage viewPage;
    public static ChronometerPage chronometerPage;

    @BeforeSuite
    public void setup() throws IOException {
        AppiumServer.stop();
        AppiumServer.start();

        if (driver == null) {
            CommonUtils.loadConfigProp("config.properties");
            CommonUtils.setCapabilities();
            driver = CommonUtils.getDriver();
            homePage = new HomePage(driver);
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        AppiumServer.stop();
    }

}
