import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Regression extends Pilot {

	public Regression() throws MalformedURLException {
		// TODO Auto-generated constructor stub
		this.runFlow();
	}

	public void runFlow() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities("real");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Check for institute code
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='LIL4Teachers']").click();
		if (driver.findElements(By.xpath("//android.widget.EditText[@text='Enter school code']")).size() > 0) {
			driver.findElementByXPath("//android.widget.EditText[@text='Enter school code']").sendKeys("demodemo");
			driver.findElementByXPath("//" + EnvConfig.button + "[@text='Proceed']").click();
			System.out.println("Institute Code Pop-up--FOUND");
		} else {
			System.out.println("Institute Code Pop-up--NOT FOUND!!");
		}
		if (driver.findElements(By.xpath("//" + EnvConfig.view + "[@resource-id='android:id/message']")).size() > 0) {
			System.out.println("School Code is Wrong validation--FOUND");
		} else {
			System.out.println("School Code is Wrong validation--NOT FOUND!!");
		}
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='EXIT']").click();
		driver.findElementByXPath("//" + EnvConfig.view + "[@text='LIL4Teachers']").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter school code']")
				.sendKeys(EnvConfig.Institutecode);
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='Proceed']").click();

		// Navigate welcome Screen
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='NEXT']").click();
		driver.findElementByXPath("//" + EnvConfig.button + "[@text='GET STARTED']").click();

		// Enabled Mobile Permissions
		if (driver.findElements(By.xpath("//" + EnvConfig.button + "[@text='WHILE USING THE APP']")).size() > 0) {
			driver.findElementByXPath("//" + EnvConfig.button + "[@text='WHILE USING THE APP']").click();
			driver.findElementByXPath("//" + EnvConfig.button + "[@text='ALLOW']").click();
			driver.findElementByXPath("//" + EnvConfig.button + "[@text='ALLOW']").click();
		} else {
			System.out.println("Device Permissions--Already Given!");
		}

	}
}
