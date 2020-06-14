package Appium.com.appium.principal;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import Appium.com.appium.utilities.Configuration;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Principal extends Configuration {

	final static Logger logger = Logger.getLogger(Principal.class);
	
	public static void main(String[] args) {
		try {
			 testOne();
			 testTwo();
			 testThreeWithGestures();
		} catch (MalformedURLException e) {
			logger.error(e);
		}
	}
	
	private static void testOne() throws MalformedURLException {
		 AndroidDriver<AndroidElement>  driver= initConfiguration();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.findElementsByClassName("android.widget.Button").get(0).click();
		 driver.findElementByXPath("//android.widget.TextView[@text= 'Preference']").click();
		 driver.findElementByXPath("//android.widget.TextView[@text= '3. Preference dependencies']").click();
		 driver.findElementById("android:id/checkbox").click();
		 driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		 driver.findElementByClassName("android.widget.EditText").sendKeys("prueba");
		 driver.findElementsByClassName("android.widget.Button").get(1).click();
	}
	
	private static void testTwo() throws MalformedURLException {
		AndroidDriver<AndroidElement>  driver= initConfiguration();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size()); 
	}
	
	private static void testThreeWithGestures() throws MalformedURLException {
		AndroidDriver<AndroidElement>  driver= initConfiguration();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Views']").click();
		TouchAction t=new TouchAction(driver);
		WebElement expandList= driver.findElementByXPath("//android.widget.TextView[@text= 'Expandable Lists']");
		t.tap(tapOptions().withElement(element(expandList))).perform();
	}
}
