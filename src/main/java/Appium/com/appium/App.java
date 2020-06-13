package Appium.com.appium;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;


public class App 
{
    public static void main( String[] args )
    {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_One_API_29");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "Nexus_One_API_29");
    }
}
