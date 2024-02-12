package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private WebElement homeBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/settings")
	private WebElement settingBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/discover")
	private WebElement discoverBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/activity")
	private WebElement activityBtnElement;
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Open the add menu\"]")
	private WebElement addMarkElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Internet\"]")
	private WebElement internetElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_device")
	private WebElement addDeviceElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_profile")
	private WebElement addProfilElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_network")
	private WebElement addNetworkElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_eero_device")
	private WebElement addorreplacElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/invite_guest")
	private WebElement inviteGuestElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_network_admin")
	private WebElement addNetworkAdminElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/add_profile_button")
	private WebElement profileBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/alertTitle")
	private WebElement alertElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"JOIN\"]")
	private WebElement JoinoryesBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/status_button")
	private WebElement statusBtnElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Residential']")
	private WebElement residentialNetwork;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
	private WebElement businessNetworkoptElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Community']")
	private WebElement communityElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Next\"]")
	private WebElement nextBtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Start\"]")
	private WebElement startBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/business_name_input")
	private WebElement businessNameElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/business_name_secondary_setup")
	private WebElement guidedSetupElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Quick setup\"]")
	private WebElement quickSetupElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Link to customer\"]")
	private WebElement LinkToCustomer;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Close button\"]")
	private WebElement closeIcon;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Start Setup\" or @text= \"Create network\"]")
	private WebElement startSetupElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Skip\"]")
	private WebElement skipElement;

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

	public void clickHome() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(homeBtnElement)).click();
		Thread.sleep(10000);

	}

	public void clickSettings() throws InterruptedException {
		settingBtn.click();
	}

	public void clickDiscover() throws InterruptedException {
		discoverBtnElement.click();

	}

	public void clickActivity() throws InterruptedException {
		activityBtnElement.click();
	}

	void clickInternet() throws InterruptedException {
		internetElement.click();
	}

	public void clickaddDevice() throws InterruptedException {
		addDeviceElement.click();
	}

	public void clickaddprofile() throws InterruptedException {
		addProfilElement.click();
	}

	public void clickaddnetwork() throws InterruptedException {
		addNetworkElement.click();
	}

	public void clickaddorreplcenode() throws InterruptedException {
		addorreplacElement.click();
	}

	public void clickinviteguest() throws InterruptedException {
		inviteGuestElement.click();
	}

	public void clickAddnetworkAdm() throws InterruptedException {
		addNetworkAdminElement.click();
	}

	public void clickProfileBtn() {
		profileBtnElement.click();

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

	public void selectResidential() {
		residentialNetwork.click();

	}

	public void selectBusiness() {
		businessNetworkoptElement.click();
	}

	public void selectCommunity() {
		communityElement.click();

	}

	public void clickNext() {
		try {
			nextBtn.click();
		} catch (Exception e) {

		}
	}

	public void EnterBusinessName(String businessname) {
		businessNameElement.sendKeys(businessname);
	}

	public void clickQuickSetup() {
		quickSetupElement.click();
	}

	public void clickGuidedSetup() {
		guidedSetupElement.click();
	}

	public void clickLinkToCustmer() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(LinkToCustomer)).click();
	}

	public void clickCloseIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(closeIcon)).click();
	}

	public void clickStartBtn() {
		startBtn.click();

	}

	public void clickSkip() {
		skipElement.click();
	}
}
