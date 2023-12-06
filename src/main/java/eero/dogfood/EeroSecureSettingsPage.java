package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EeroSecureSettingsPage {

	AndroidDriver driver;

	public EeroSecureSettingsPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton")
	private WebElement backBtnElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.eero.android.dogfood:id/label\" and @text=\"Advanced Security\"]")
	private WebElement advanceSecuritytogglElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.eero.android.dogfood:id/label\" and @text=\"Ad Blocking\"]")
	private WebElement adBlockElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.eero.android.dogfood:id/title\" and @text=\"eero Internet Backup\"]")
	private WebElement eeroBackupElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.eero.android.dogfood:id/title\" and @text=\"Content Filters\"]")
	private WebElement contentFilterElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.eero.android.dogfood:id/title\" and @text=\"Block apps\"]")
	private WebElement blockAppsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.eero.android.dogfood:id/title\" and @text=\"Block & Allow Sites\"]")
	private WebElement blockAndAllowSitesElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/scans_card")
	private WebElement scancardElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/threats_card")
	private WebElement threatblocksElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/ads_card")
	private WebElement adsCardElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/filters_card")
	private WebElement filterscardElement;

	public void clickAdvanceSecurity() throws InterruptedException {

		// TODO Auto-generated method stub
		advanceSecuritytogglElement.click();
		Thread.sleep(3000);
	}

	public void clickAdBlock() throws InterruptedException {
		// TODO Auto-generated method stub
		adBlockElement.click();
		Thread.sleep(2000);

	}

	public void clickInternetBackup() throws InterruptedException {
		// TODO Auto-generated method stub
		eeroBackupElement.click();
		Thread.sleep(2000);
	}

	public void clickBackBtn() {
		backBtnElement.click();

	}

	public void clickcontentFilter() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Content Filters\").instance(0))"));
		contentFilterElement.click();

	}

	public void clickBlockApps() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Block apps\").instance(0))"));
		blockAppsElement.click();

	}

	public void clickBlockandAllowSites() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Block & Allow Sites\").instance(0))"));
		blockAndAllowSitesElement.click();
	}

}
