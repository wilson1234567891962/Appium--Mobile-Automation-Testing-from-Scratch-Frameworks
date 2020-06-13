package Appium.com.appium.utilities;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Configuration {

	final static Logger logger = Logger.getLogger(Configuration.class);

	public static AndroidDriver<AndroidElement> initConfiguration() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = null;
		try (InputStream input = Configuration.class
				.getResourceAsStream("/com/appium/app/properties/Capabilities.properties")) {
			Properties properties = new Properties();
			properties.load(input);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,  properties.getProperty("capabilities.device.name"));
			cap.setCapability(MobileCapabilityType.APP,  properties.getProperty("capabilities.app.path"));
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("capabilities.app.test"));
			driver = new AndroidDriver<>(new URL(properties.getProperty("capabilities.server.path")), cap);
		} catch (IOException ex) {
			logger.error(ex);
		}
		return driver;
	}
}
