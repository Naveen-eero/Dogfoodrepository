package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class settingsPage {
	AndroidDriver driver;

	public settingsPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/settings_menu")
	private WebElement settingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transfer Network\"]")
	private WebElement transferNetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Switch network\"]")
	private WebElement switchnetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add a network\"]")
	private WebElement addnetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cancel\"]")
	private WebElement cancelbtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/account_item_row_container")
	private WebElement accountSettingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Wifi name & password\"]")
	private WebElement wifinamePasswordElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Guest Network\" or  @text=\"Guest network\"]")
	private WebElement guestNetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Network settings\"]")
	private WebElement networkSettingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Network users\"]")
	private WebElement networkUsersElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Nickname and timezone\"]")
	private WebElement nicknamElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Notifications\"]")
	private WebElement notificationElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Software version\"]")
	private WebElement softwareversionElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Appearance\"]")
	private WebElement appearanceeElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Troubleshooting\"]")
	private WebElement troubleshootingElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Legal\"]")
	private WebElement legalElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Debug settings\"]")
	private WebElement debugsettingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Wifi network details\"]")
	private WebElement WifiNetworkDetails;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Multi SSID\"]")
	private WebElement MultiSsid;

	public void clicksettingsmenu() throws InterruptedException {
		settingsElement.click();
	}

	public void clickTransferNetwork() throws InterruptedException {
		transferNetworkElement.click();
	}

	void clickSwitchNetwork() {
		switchnetworkElement.click();
	}

	void clickAddNewNetwork() {
		// TODO Auto-generated method stub
		addnetworkElement.click();

	}

	void clickcancelbtn() {
		// TODO Auto-generated method stub
		cancelbtnElement.click();
	}

	void clickAccount() {
		// TODO Auto-generated method stub
		accountSettingsElement.click();

	}

	void clickWifiName() {
		// TODO Auto-generated method stub
		wifinamePasswordElement.click();
	}

	void clickGuestconf() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(guestNetworkElement)).click();
	}

	public void clickNetworkSettings() {
		// TODO Auto-generated method stub
		networkSettingsElement.click();
	}

	public void clickNetworkUsers() {
		// TODO Auto-generated method stub
		networkUsersElement.click();
	}

	public void clickNickname() {
		// TODO Auto-generated method stub
		nicknamElement.click();
	}

	public void clickNotifications() {
		// TODO Auto-generated method stub
		notificationElement.click();
	}

	public void clickSoftwareUpd() {
		softwareversionElement.click();

	}

	public void clickApperance() {
		appearanceeElement.click();

	}

	public void clickTroubleshoot() {
		// TODO Auto-generated method stub
		troubleshootingElement.click();
	}

	public void clickLegal() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Legal\").instance(0))"));
		legalElement.click();

	}

	public void clickDebugMenu() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Debug settings\").instance(0))"));
		debugsettingsElement.click();

	}

	public void clickWifiNameAndPassword() {
		WifiNetworkDetails.click();
	}

	public void clickMultiSSID() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(MultiSsid)).click();
	}

}
