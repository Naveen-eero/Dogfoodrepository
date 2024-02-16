package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class multiSsidPage {
	AndroidDriver driver;

	public multiSsidPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Add wifi network\"]")
	private WebElement addWifiNetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add business wifi network\"]")
	private WebElement addBusinessnet;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add IoT wifi network\"]")
	private WebElement addIotNetwork;
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout[@index='0']")
	private WebElement guestNetworkElement;
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout[@index='1']")
	public WebElement subnetAElement;
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout[@index='2']")
	public WebElement subnetBElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_name")
	private WebElement wifiNameElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_password")
	private WebElement wifiPasswordElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/save")
	private WebElement saveBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/basic_switch")
	private WebElement toggleElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"DISABLE\"]")
	private WebElement confirmDisablElement;
	@AndroidFindBy(id = "//android.widget.Button[@text=\\\"CANCEL\\\"]")
	private WebElement cancelDisablElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/delete_wifi")
	private WebElement deleteWifiElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"DELETE\"]")
	private WebElement confirmDelete;
	@AndroidFindBy(xpath = "//*[@text=\"Enable captive portal\"]")
	public WebElement enableCaptivePortalElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bandwidth limit\"]")
	public WebElement bandwidthElement;

	public void clickaddWifi() {
		try {
			addWifiNetworkElement.click();
		} catch (Exception e) {

		}
	}

	public void addBusinessSSID() {
		try {
			addBusinessnet.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addIOTSSID() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(addIotNetwork)).click();
	}

	public void enterssidName(String ssidname) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(wifiNameElement));
		wifiNameElement.sendKeys(ssidname);
	}

	public void enterssidpassword(String ssidpassowrd) throws InterruptedException {
		wifiPasswordElement.sendKeys(ssidpassowrd);
	}

	public void clickSave() throws InterruptedException {
		saveBtnElement.click();
	}

	public void clickGuest() {
		// TODO Auto-generated method stub
		guestNetworkElement.click();
	}

	public void clickSubnetA() {
		subnetAElement.click();
	}

	public void clickSubB() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(subnetBElement)).click();
	}

	public void clickEnableToggle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(toggleElement)).click();
	}

	public void clickconfirm() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(confirmDisablElement)).click();
	}

	public void deleteWifi() {
		deleteWifiElement.click();
	}

	public void clickDelete() throws InterruptedException {
		confirmDelete.click();
		Thread.sleep(20000);
	}

	public void enableBandwith() {
		bandwidthElement.click();
	}

	public void clickEnableCaptivePortal() {
		enableCaptivePortalElement.click();
	}

	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		// TODO: handle exception
	}
}
