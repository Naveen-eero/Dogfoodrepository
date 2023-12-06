package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class dhcpNatConf {
	AndroidDriver driver;

	public dhcpNatConf(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.eero.android.dogfood:id/label\" and @text=\"Bridge\"]")
	private WebElement BridgeModeCheck;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/save_button")
	private WebElement savebtnElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"REBOOT\"]")
	private WebElement rebootBtnElement;

	public void selectBridge() throws InterruptedException {
		BridgeModeCheck.click();
		Thread.sleep(1000);
	}

	public void clickSave() throws InterruptedException {
		savebtnElement.click();
		Thread.sleep(1000);
	}

	public void clickReboot() throws InterruptedException {
		rebootBtnElement.click();
		Thread.sleep(1000);

	}

}
