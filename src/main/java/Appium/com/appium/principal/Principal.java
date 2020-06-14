package Appium.com.appium.principal;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import Appium.com.appium.utilities.Configuration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Principal {

	final static Logger logger = Logger.getLogger(Principal.class);
	
	public static void main(String[] args) {
		try {
			 AndroidDriver<AndroidElement>  driver= Configuration.initConfiguration();
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
			 driver.findElementByXPath("//android.widget.TextView[@text= 'Preference']").click();
			 driver.findElementByXPath("//android.widget.TextView[@text= '3. Preference dependencies']").click();
				
			 driver.findElementById("android:id/checkbox").click();
			 driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		} catch (MalformedURLException e) {
			logger.error(e);
		}
	}
}
