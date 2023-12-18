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

	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_name")
	private WebElement wifiNameElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_password")
	private WebElement wifiPasswordElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/save")
	private WebElement saveBtnElement;

	public void clickaddWifi() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(addWifiNetworkElement)).click();
	}

	public void addBusinessSSID() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(addBusinessnet)).click();
	}

	public void addIOTSSID() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(addBusinessnet)).click();
	}

	public void enterssidName(String ssidname) throws InterruptedException {
		wifiNameElement.sendKeys(ssidname);
	}

	public void enterssidpassword(String ssidpassowrd) {
		wifiPasswordElement.sendKeys(ssidpassowrd);
	}

	public void clickSave() {
		saveBtnElement.click();

	}

}
