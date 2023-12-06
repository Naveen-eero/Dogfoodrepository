package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
	@AndroidFindBy(id = "android:id/button1")
	private WebElement okBtnElement;

	public void clickHome() throws InterruptedException {
		homeBtnElement.click();
		Thread.sleep(3000);
	}

	public void clickSettings() throws InterruptedException {
		settingBtn.click();
		Thread.sleep(3000);
	}

	public void clickDiscover() throws InterruptedException {
		discoverBtnElement.click();
		Thread.sleep(3000);

	}

	public void clickActivity() throws InterruptedException {
		activityBtnElement.click();
		Thread.sleep(3000);
	}

	void clickAddBtn() throws InterruptedException {
		addMarkElement.click();
		Thread.sleep(1000);

	}

	void clickInternet() throws InterruptedException {
		internetElement.click();
		Thread.sleep(1000);
	}

	public void clickaddDevice() throws InterruptedException {
		addDeviceElement.click();
		Thread.sleep(3000);
	}

	public void clickaddprofile() throws InterruptedException {
		addProfilElement.click();
		Thread.sleep(3000);
	}

	public void clickaddnetwork() throws InterruptedException {
		addNetworkElement.click();
		Thread.sleep(3000);
	}

	public void clickaddorreplcenode() throws InterruptedException {
		addorreplacElement.click();
		Thread.sleep(3000);
	}

	public void clickinviteguest() throws InterruptedException {
		inviteGuestElement.click();
		Thread.sleep(3000);
	}

	public void clickAddnetworkAdm() throws InterruptedException {
		addNetworkAdminElement.click();
		Thread.sleep(3000);
	}

	public void clickProfileBtn() {
		profileBtnElement.click();

	}

	public void clickOkBtn() {
		if (alertElement.isDisplayed()) {
			okBtnElement.click();
		}

	}

}
