package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class dhcpNatConfPage {
	AndroidDriver driver;

	public dhcpNatConfPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bridge\"]")
	public WebElement BridgeModeCheck;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Automatic\"]")
	public WebElement AutomaticCheckBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/save_button")
	public WebElement savebtnElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"REBOOT\"]")
	public WebElement rebootBtnElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Manual IP\"]")
	public WebElement manualIpOptionElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"10.0.0.0\"]")
	public WebElement manualIpaddress;

	public void selectBridge() throws InterruptedException {
		BridgeModeCheck.click();
	}

	public void clickSave() throws InterruptedException {
		savebtnElement.click();
	}

	public void clickReboot() throws InterruptedException {
		rebootBtnElement.click();

	}

	public void selectManualIpoption() {
		manualIpOptionElement.click();
	}

	public void selectManulaIpaddr(String manualip) {
		String xpath_locator = String
				.format("//android.widget.TextView[contains(@text," + "\"" + "" + manualip + "\")]");
		WebElement ele = driver.findElement(AppiumBy.xpath(xpath_locator));
		ele.click();
	}

	public void selectAutomatic() {
		AutomaticCheckBtn.click();
	}
}
