package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonUtils {
    private static Properties properties = new Properties();
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private static URL serverUrl;
    private static AndroidDriver driver;
    public static int EXPLICIT_WAIT_TIME;
    public static int IMPLICIT_WAIT_TIME;
    public static int DEFAULT_WAIT_TIME;
    public static String BASE_PKG;
    public static String APP_ACTIVITY;
    public static String APPIUM_PORT;
    public static String PLATFORM_NAME;
    public static String PLATFORM_VERSION;
    public static String DEVICE_NAME;
    public static String AUTOMATION_NAME;

    public static void loadConfigProp(String propertyFileName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/" + propertyFileName);
        properties.load(fis);
        EXPLICIT_WAIT_TIME = Integer.parseInt(properties.getProperty("explicit.wait"));
        IMPLICIT_WAIT_TIME = Integer.parseInt(properties.getProperty("implicit.wait"));
        DEFAULT_WAIT_TIME = Integer.parseInt(properties.getProperty("default.wait"));
        APPIUM_PORT = properties.getProperty("appium.server.port");
        AUTOMATION_NAME = properties.getProperty("automationName");
        PLATFORM_NAME = properties.getProperty("platform.name");
        PLATFORM_VERSION = properties.getProperty("platform.version");
        DEVICE_NAME = properties.getProperty("device.name");
    }

    public static void setCapabilities() {
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, CommonUtils.PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CommonUtils.PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CommonUtils.DEVICE_NAME);
        desiredCapabilities.setCapability("appActivity", CommonUtils.APP_ACTIVITY);
        desiredCapabilities.setCapability("appPackage", CommonUtils.BASE_PKG);
        desiredCapabilities.setCapability("automationName", CommonUtils.AUTOMATION_NAME);
    }

    public static AndroidDriver getDriver() throws MalformedURLException {
        serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
        driver = new AndroidDriver(serverUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static boolean isFound(Integer timeInSec, WebElement element) {
        try {
            Long timeOut = Long.valueOf(timeInSec);
            driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
            if (driver.findElement((By) element).isDisplayed()) {
                driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static void swipeToElement(WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollDown() {
        Dimension dimension = driver.manage().window().getSize();

        new TouchAction(driver)
                .press(PointOption.point(0, ((Double) (dimension.getHeight() * 0.5)).intValue()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, ((Double) (dimension.getHeight() * 0.2)).intValue()))
                .release()
                .perform();
    }
}
