package Appium.com.appium.utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Configuration {
	
	public static AndroidDriver<AndroidElement> initConfiguration() throws MalformedURLException {
		File file = new File("resources");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_One_API_29");
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath() + "/com/appium/app/original.apk");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
}
