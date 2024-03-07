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

public class HomePage {
	AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/home")
	public WebElement homeBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/settings")
	public WebElement settingBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/discover")
	public WebElement discoverBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/activity")
	public WebElement activityBtnElement;
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Open the add menu\"]")
	public WebElement addMarkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Internet\"]")
	public WebElement internetElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_device")
	public WebElement addDeviceElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_profile")
	public WebElement addProfilElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_network")
	public WebElement addNetworkElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_eero_device")
	public WebElement addorreplacElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/invite_guest")
	public WebElement inviteGuestElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_network_admin")
	public WebElement addNetworkAdminElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_profile_button")
	public WebElement profileBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/alertTitle")
	public WebElement alertElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"JOIN\"]")
	public WebElement JoinoryesBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/status_button")
	public WebElement statusBtnElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Residential']")
	public WebElement residentialNetwork;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
	public WebElement businessNetworkoptElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Community']")
	public WebElement communityElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Next\"]")
	public WebElement nextBtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Start\"]")
	public WebElement startBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/business_name_input")
	public WebElement businessNameElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/business_name_secondary_setup")
	public WebElement guidedSetupElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Quick setup\"]")
	public WebElement quickSetupElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Link to customer\"]")
	public WebElement LinkToCustomer;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Close button\"]")
	public WebElement closeIcon;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Start Setup\" or @text= \"Create network\"]")
	public WebElement startSetupElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Skip\"]")
	public WebElement skipElement;
	@AndroidFindBy(xpath = "//*[(@resource-id='com.eero.android.dogfood:id/header_list')]//android.view.ViewGroup[1]")
	public WebElement gatewayElement;
	@AndroidFindBy(xpath = "//*[(@resource-id='com.eero.android.dogfood:id/header_list')]//android.view.ViewGroup[2]")
	public WebElement wiredLeafElement;
	@AndroidFindBy(xpath = "//*[(@resource-id='com.eero.android.dogfood:id/header_list')]//android.view.ViewGroup[3]")
	public WebElement wirelessleafElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Device information\"]")
	public WebElement deviceInfo;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Serial number\"]/following-sibling::android.widget.TextView[1]")
	public WebElement serialNumElement;

	public void clickStartSetup() throws InterruptedException {
		// Click on start setup button
		try {
			startSetupElement.click();
		} catch (Exception e) {
			settingBtn.click();
			settingsPage settingsPage = new settingsPage(driver);
			settingsPage.clicksettingsmenu();
			settingsPage.clickAddNewNetwork();

		}
	}

	public void clickJoinBtn() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOf(JoinoryesBtn)).click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Network update not required");
			Thread.sleep(30000);

		}
	}

	public String getInternetStatus() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(160));
		wait.until(ExpectedConditions.textToBePresentInElement(statusBtnElement, "Online"));
		Thread.sleep(10000);
		String intstat = statusBtnElement.getText();
		return intstat;
	}

	public void clickNext() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOf(nextBtn)).click();
		} catch (Exception e) {

		}
	}

	public void EnterBusinessName(String businessname) {
		businessNameElement.sendKeys(businessname);
	}

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}

	public String getSerial() {
		String nodeserial = serialNumElement.getText();
		System.out.println(nodeserial.substring(nodeserial.length() - 4));
		return (nodeserial.substring(nodeserial.length() - 4));

	}

	public void clickDeviceInfo() {
		WebElement ele = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Device information\").instance(0))"));
		deviceInfo.click();
	}
}
