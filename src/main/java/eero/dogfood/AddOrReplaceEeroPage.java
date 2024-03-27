package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddOrReplaceEeroPage {
	AndroidDriver driver;

	public AddOrReplaceEeroPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/next_button")
	public WebElement START_NETWORK_CREATION;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/primary_button")
	public WebElement ADD_EERO_BUTTON;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/text_button")
	public WebElement replaceEeroBtnElement;
	@AndroidFindBy(xpath = "//android.widget.ImageButton")
	public WebElement closeBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/setup_confirmation_next_button")
	public WebElement lookForGreenElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/button_next")
	public WebElement arrowBtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Finish setup\"]")
	public WebElement finishSetupBtn;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.eero.android.dogfood:id/toolbarView\"]/android.widget.ImageButton")
	public WebElement backbtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/network_name_edit_text")
	public WebElement networkNamElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/network_password_edit_text")
	public WebElement networkPasswordElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Set Up Using a Serial Number\"]")
	public WebElement setupusingSerial;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/zero_day_update_primary_button")
	public WebElement installNowBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/zero_day_update_secondary_button")
	public WebElement mayBeLaterBtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Internet settings\"]")
	public WebElement internetSettingsElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"WAN type\"]")
	public WebElement wantypElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Static IP\"]")
	public WebElement staticipElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IP address\"]/following-sibling::android.widget.EditText")
	public WebElement staticIpAddr;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Subnet mask\"]/following-sibling::android.widget.EditText")
	public WebElement subnet;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Router IP\"]/following-sibling::android.widget.EditText")
	public WebElement RouterIp;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Apply\"]")
	public WebElement applyBtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Save settings\"]")
	public WebElement saveBtn;

	public void replaceEero() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(replaceEeroBtnElement)).click();
	}

	public void enterNetworkName(String networkName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(networkNamElement)).sendKeys(networkName);

	}

	public void setNetworkPassword(String networkPassword) {
		networkPasswordElement.sendKeys(networkPassword);

	}

	public void addLeaf() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(lookForGreenElement)).click();

	}

	public void clickFinishSetup() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(finishSetupBtn)).click();

	}

	public void clickInstallNow() {
		try {
			installNowBtn.click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No updates required");
		}

	}

	public void clickMaybeLater() {
		try {
			mayBeLaterBtn.click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No updates required");
		}
	}

	public void clickInternetSettings() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.visibilityOf(internetSettingsElement)).click();
	}

	public void enterStaticIpdetails(String staticip, String Subnetaddr, String routerString) {
		staticIpAddr.sendKeys(staticip);
		subnet.sendKeys(Subnetaddr);
		RouterIp.sendKeys(routerString);

	}

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}
}
