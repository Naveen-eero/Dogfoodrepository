package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MultiSSIDPage {
	AndroidDriver driver;

	public MultiSSIDPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/eb_add_wifi_network")
	public WebElement addWifiNetworkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add business wifi network\" or @text=\"Add business Wi-Fi network\"]")
	public WebElement addBusinessnet;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add IoT wifi network\" or @text=\"Add IoT Wi-Fi network\"]")
	public WebElement addIotNetwork;
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout[@index='0']")
	public WebElement guestNetworkElement;
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout[@index='1']")
	public WebElement SUBNET_A;
	@AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView//android.widget.FrameLayout[@index='2']")
	public WebElement SUBNET_B;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_name")
	public WebElement wifiNameElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_password")
	public WebElement wifiPasswordElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/save")
	public WebElement saveBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/basic_switch")
	public WebElement toggleElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"DISABLE\"]")
	public WebElement confirmDisablElement;
	@AndroidFindBy(id = "//android.widget.Button[@text=\\\"CANCEL\\\"]")
	public WebElement cancelDisablElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/delete_wifi")
	public WebElement DELETE_BUTTON;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"DELETE\"]")
	public WebElement DELETE_CONFIRM_BUTON;
	@AndroidFindBy(xpath = "//*[@text=\"Enable captive portal\"]")
	public WebElement enableCaptivePortalElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Bandwidth limit\"]")
	public WebElement bandwidthElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"TRY AGAIN\"]")
	public WebElement tryAgainElement;

	public void clickaddWifi() {
		try {
			addWifiNetworkElement.click();
			while (isElementVisible(addBusinessnet) == false) {
				tryAgainElement.click();
			}
		} catch (Exception e) {

		}
	}

	public void addBusinessSSID() {
		try {
			addBusinessnet.click();
			while (isElementVisible(addBusinessnet) == false) {
				tryAgainElement.click();
			}
		} catch (Exception e) {
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
		Thread.sleep(20000);
	}

	public void clickGuest() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(guestNetworkElement)).click();
	}

	public String getWifiName() {
		String wifiname = wifiNameElement.getText();
		return wifiname;
	}

	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		// TODO: handle exception
	}

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}

}
