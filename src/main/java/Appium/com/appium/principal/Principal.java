package Appium.com.appium.principal;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import Appium.com.appium.utilities.Configuration;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import io.appium.java_client.MobileBy;

public class Principal extends Configuration {

	final static Logger logger = Logger.getLogger(Principal.class);

	public static void main(String[] args) {
		try {
			// testOne();
			// testTwo();
			// testThreeWithGestures();
			// testFourthWithSwipe();
			// testFifthWithScrolling();
			// testSixthWithDragAndDrop();
			// testSeventh_OpenBrowser();
			// testEight_CheckPage();
			// testNineth_ScrollView();
			// testTenth_CheckIcommerce();
			// testEleventh_CheckToast();
			// testTwelveth_CheckInList();
			// testThirteenth_CheckPageAndList();
			// testFourteenth_CheckPageBrowser();
			// testFifteenth_checkAlert();
			testSixTeenth_scrollView();
			testSeventieth_checkIncrementTest();
			testEightteenth_clickOnDataPicker();
		} catch (MalformedURLException e) {
			logger.error(e);
		}
	}

	private static void testOne() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Capabilities.properties");
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
		AndroidDriver<AndroidElement> driver = initConfiguration("Capabilities.properties");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	}

	private static void testThreeWithGestures() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Capabilities.properties");
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
		AndroidDriver<AndroidElement> driver = initConfiguration("Capabilities.properties");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text= '2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		TouchAction t = new TouchAction(driver);
		WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second))
				.release().perform();
	}

	private static void testFifthWithScrolling() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Capabilities.properties");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Views']").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"ScrollBars\"));");
	}

	private static void testSixthWithDragAndDrop() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Capabilities.properties");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementsByClassName("android.widget.Button").get(0).click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text= 'Drag and Drop']").click();
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
		TouchAction t = new TouchAction(driver);
		t.longPress(element(source)).moveTo(element(destination)).release().perform();
	}

	private static void testSeventh_OpenBrowser() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Browser.properties");
		driver.get("https://www.facebook.com/");
		driver.findElementByXPath("//*[@id='m_login_email']").sendKeys("Alejandro");
		driver.findElementByName("pass").sendKeys("PREUBA");
		driver.findElementByXPath("//button[@value='Log In']").click();
	}

	private static void testEight_CheckPage() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Browser.properties");
		driver.get("https://m.cricbuzz.com");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());
	}

	private static void testNineth_ScrollView() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Browser.properties");
		driver.get("https://m.cricbuzz.com");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0,480)", "");
	}

	private static void testTenth_CheckIcommerce() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Icommerce.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}

	private static void testEleventh_CheckToast() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Icommerce.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toastMessage);
		Assert.assertEquals("Please enter your name", toastMessage);
	}

	private static void testTwelveth_CheckInList() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Icommerce.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (text.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals("Jordan 6 Rings", lastpageText);
	}

	private static void testThirteenth_CheckPageAndList() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Icommerce.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum = 0;
		for (int i = 0; i < count; i++) {
			String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			double amount = getAmount(amount1);
			sum = sum + amount;// 280.97+116.97
		}
		System.out.println(sum + "sum of products");
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total = total.substring(1);
		double totalValue = Double.parseDouble(total);
		System.out.println(totalValue + "Total value of products");
		Assert.assertEquals(sum, totalValue);
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}

	private static void testFourteenth_CheckPageBrowser() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = initConfiguration("Icommerce.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		// Mobile Gestures
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);
		Set<String> contexts = driver.getContextHandles();
		for (String contextName : contexts) {
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("hello");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}

	private static void testFifteenth_checkAlert() throws MalformedURLException {
		IOSDriver<IOSElement> driver = initConfigurationMac("CapabilitiesMac.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElement(By.xpath("//*[@value='Text Entry']")).click();
		driver.findElementByClassName("XCUIElementTypeOther").sendKeys("Hello");
		driver.findElementByName("OK").click();
	}

	private static void testSixTeenth_scrollView() throws MalformedURLException {
		IOSDriver<IOSElement> driver = initConfigurationMac("CapabilitiesMac.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int h1 = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int h2 = screenHeightEnd.intValue();
		new TouchAction(driver).press(PointOption.point(0, h1))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600))).moveTo(PointOption.point(0, h2))
				.release().perform();
		driver.findElementByAccessibilityId("Steppers").click();
	}

	private static void testSeventieth_checkIncrementTest() throws MalformedURLException {
		IOSDriver<IOSElement> driver = initConfigurationMac("CapabilitiesMac.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int h1 = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int h2 = screenHeightEnd.intValue();
		new TouchAction(driver).press(PointOption.point(0, h1))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600))).moveTo(PointOption.point(0, h2))
				.release().perform();
		driver.findElementByAccessibilityId("Steppers").click();
		driver.findElementByAccessibilityId("Steppers").click();
		driver.findElementByAccessibilityId("Increment").click();
		driver.findElementByAccessibilityId("Increment").click();
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(2).getText());
		driver.findElementByAccessibilityId("Decrement").click();
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
	}

	private static void testEightteenth_clickOnDataPicker() throws MalformedURLException {
		IOSDriver<IOSElement> driver = initConfigurationMac("CapabilitiesMac.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int h1 = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int h2 = screenHeightEnd.intValue();
		new TouchAction(driver).press(PointOption.point(0, h1))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600))).moveTo(PointOption.point(0, h2))
				.release().perform();
		driver.findElementByAccessibilityId("Picker View").click();
		driver.findElementByName("Green color component value").sendKeys("220");
		driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
		driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");
	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);
		return amount2value;
	}
}
