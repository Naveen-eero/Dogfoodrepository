package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NetworkSettingsPage {

	AndroidDriver driver;

	public NetworkSettingsPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"DHCP & NAT\"]")
	private WebElement DHCPNATBtnElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"WAN IP address\"]/following-sibling::android.widget.TextView")
	private WebElement wanIpAddressElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Gateway eero IP address\"]/following-sibling::android.widget.TextView ")
	private WebElement gateWayIpElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IPv6\"]")
	private WebElement ipv6Element;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ISP Settings\"]")
	private WebElement iSPsettingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Reservation & port forwarding\"]")
	private WebElement reservationElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"DNS\"]")
	private WebElement dNSElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"UPnP\"]")
	private WebElement uPNPElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Client steering\"]")
	private WebElement clientSteeringElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Thread\"]")
	private WebElement threadElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Restart network\"]")
	private WebElement restartNetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[ @text=\"Delete network\"]")
	private WebElement deleteNetworkElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Restart network\"]")
	private WebElement restartNetworkBtn;

	public void getWanIp() {
		String wanIpaddressString = wanIpAddressElement.getText();
		System.out.println("network wan ip is " + wanIpaddressString);
	}

	public void getGatewayIp() {
		String gatewayIpString = gateWayIpElement.getText();
		System.out.println("Gateway ip is " + gatewayIpString);

	}

	public void clickIpv6() {
		ipv6Element.click();
	}

	public void ClickIspSettings() {
		iSPsettingsElement.click();
	}

	public void clickReservation() {
		reservationElement.click();

	}

	public void clickDns() {
		dNSElement.click();

	}

	public void clickUpnp() {
		uPNPElement.click();

	}

	public void clckClientSteering() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Client steering\").instance(0))"));
		clientSteeringElement.click();
	}

	public void clickThread() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Thread\").instance(0))"));
		threadElement.click();

	}

	public void clickDhcpNat() throws InterruptedException {
		DHCPNATBtnElement.click();
	}

	public void restartNetwork() throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Restart network\").instance(0))"));
		restartNetworkElement.click();
	}

	public void clickRestartBtn() throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Restart network\").instance(0))"));
		restartNetworkBtn.click();
		Thread.sleep(10000);
	}

	public void deleteNetwork() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Delete network\").instance(0))"));
		deleteNetworkElement.click();
	}

}
