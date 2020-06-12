package featurelib;

import static org.testng.Assert.assertEquals;

import io.appium.java_client.MobileElement;

public class CalFeatureLibrary {
	AndroidSetup setup = new AndroidSetup();
	
	public void open_calculator() {
		setup.set_up();
	}
	
	public void calculateNumber() {
		MobileElement el1 = (MobileElement) setup.driver.findElementById("com.android.calculator2:id/digit_1");
		el1.click();
		MobileElement el2 = (MobileElement) setup.driver.findElementById("com.android.calculator2:id/op_add");

		el2.click();
		MobileElement el3 = (MobileElement) setup.driver.findElementById("com.android.calculator2:id/digit_2");
		el3.click();
		MobileElement el4 = (MobileElement) setup.driver.findElementByAccessibilityId("equals");
		el4.click();
	}
	
	public void resultNumber() {
		MobileElement hasil = (MobileElement) setup.driver.findElementById("com.android.calculator2:id/result");
    	assertEquals(hasil.getText(),"3");
	}
}
