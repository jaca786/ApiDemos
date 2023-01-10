package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServer {

    public static AppiumDriverLocalService getInstance() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(System.getProperty("user.dir") + "/src/main/resources/logs/Appium.log"));

        return AppiumDriverLocalService.buildService(builder);
    }

    public static void start() {
        getInstance().start();
        System.out.println("Appium Server Started");
    }

    public static void stop() {
        getInstance().stop();
        System.out.println("Appium Server Stopped");

    }
}
