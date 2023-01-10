package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenBase {

    public static AndroidDriver driver;
    public static WebDriverWait wait;

    public ScreenBase(AndroidDriver driver) {
        this.driver = driver;
        loadElement();
    }

    public void loadElement() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitForElement(long duration, String locator) {
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }
}
