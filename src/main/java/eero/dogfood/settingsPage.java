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
	public WebElement settingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Transfer Network\"]")
	public WebElement transferNetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Switch network\"]")
	public WebElement switchnetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add a network\"]")
	public WebElement addnetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cancel\"]")
	public WebElement cancelbtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/account_item_row_container")
	public WebElement accountSettingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Wifi name & password\"]")
	public WebElement wifinamePasswordElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Guest Network\" or  @text=\"Guest network\"]")
	public WebElement guestNetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Network settings\"]")
	public WebElement networkSettingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Network users\"]")
	public WebElement networkUsersElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Nickname and timezone\"]")
	public WebElement nicknamElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Notifications\"]")
	public WebElement notificationElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Software version\"]")
	public WebElement softwareversionElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Appearance\"]")
	public WebElement appearanceeElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Troubleshooting\"]")
	public WebElement troubleshootingElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Legal\"]")
	public WebElement legalElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Debug settings\"]")
	public WebElement debugsettingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Wifi network details\"]")
	public WebElement WifiNetworkDetails;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Multi SSID\"]")
	public WebElement MultiSsid;

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
		addnetworkElement.click();

	}

	void clickcancelbtn() {
		cancelbtnElement.click();
	}

	void clickAccount() {
		accountSettingsElement.click();

	}

	void clickWifiName() {
		// TODO Auto-generated method stub
		wifinamePasswordElement.click();
	}

	public void clickGuestconf() throws InterruptedException {
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

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}

}
