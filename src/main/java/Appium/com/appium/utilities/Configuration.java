package Appium.com.appium.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Configuration {

	final static Logger logger = Logger.getLogger(Configuration.class);

	public static AndroidDriver<AndroidElement> initConfiguration(String namePath) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = null;
		try (InputStream input = Configuration.class
				.getResourceAsStream("/com/appium/app/properties/" +namePath )) {
			Properties properties = new Properties();
			properties.load(input);
			DesiredCapabilities cap = new DesiredCapabilities();
			for(String key : properties.stringPropertyNames()) {
				if(!key.equals("capabilities.server.path")) {
					String value = properties.getProperty(key);
					cap.setCapability(key, value);	
				}
			}
			driver = new AndroidDriver<>(new URL(properties.getProperty("capabilities.server.path")), cap);
			
		} catch (IOException ex) {
			logger.error(ex);
		}
		return driver;
	}
	
	public static IOSDriver<IOSElement> initConfigurationMac(String namePath) throws MalformedURLException {
		IOSDriver<IOSElement> driver = null;
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(new File("").getAbsolutePath());
		stringBuilder.append("/resources/com/appium/app/properties/");
		stringBuilder.append(namePath);
		try (InputStream input =  new FileInputStream(new File(stringBuilder.toString()))) {
			Properties properties = new Properties();
			properties.load(input);
			DesiredCapabilities cap = new DesiredCapabilities();
			for(String key : properties.stringPropertyNames()) {
				if(!key.equals("capabilities.server.path")) {
					String value = properties.getProperty(key);
					cap.setCapability(key, value);	
				}
			}
			driver = new IOSDriver<IOSElement>(new URL(properties.getProperty("capabilities.server.path")), cap);
			
		} catch (IOException ex) {
			logger.error(ex);
		}
		return driver;
	}
	
}
