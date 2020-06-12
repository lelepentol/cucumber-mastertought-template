package featurelib;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidSetup {
	public AndroidDriver driver;
	public WebDriverWait wait;
//	//Elements
//	String secondNewJob = "//android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
//			"android.widget.RelativeLayout/android.widget.ImageView";
	
	public void set_up()    {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 2 API 28");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		caps.setCapability("skipUnlock","true");
//		caps.setCapability("appPackage", "com.test.dishisit");
//		caps.setCapability("appActivity","host.exp.exponent.MainActivity");
		caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity","com.android.calculator2.Calculator");
		caps.setCapability("noReset","false");
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}
