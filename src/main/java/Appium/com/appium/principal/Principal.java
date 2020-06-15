package Appium.com.appium.principal;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import Appium.com.appium.utilities.Configuration;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Principal extends Configuration {

	final static Logger logger = Logger.getLogger(Principal.class);

	public static void main(String[] args) {
		try {

			testFourthWithSwipe();
		} catch (MalformedURLException e) {
			logger.error(e);
		}
	}

	private static void testOne() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration();
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
		AndroidDriver<AndroidElement> driver = initConfiguration();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	}

	private static void testThreeWithGestures() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Views']").click();
		TouchAction t = new TouchAction(driver);
		WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text= 'Expandable Lists']");
		t.tap(tapOptions().withElement(element(expandList))).perform();
		driver.findElementByXPath("//android.widget.TextView[@text= '1. Custom Adapter']").click();
		WebElement people = driver.findElementByXPath("//android.widget.TextView[@text= 'People Names']");
		t.longPress(longPressOptions().withElement(element(people)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
	}

	private static void testFourthWithSwipe() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text= '2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		TouchAction t = new TouchAction(driver);
		// long press //on element// 2 sec// move to another element and you release
		WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second))
				.release().perform();
	}
}
