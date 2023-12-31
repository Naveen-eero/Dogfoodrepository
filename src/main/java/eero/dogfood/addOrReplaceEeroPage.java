package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class addOrReplaceEeroPage {
	AndroidDriver driver;

	public addOrReplaceEeroPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/next_button")
	private WebElement startNetworkCreationElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/primary_button")
	private WebElement addEeroBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/text_button")
	private WebElement replaceEeroBtnElement;
	@AndroidFindBy(xpath = "//android.widget.ImageButton")
	private WebElement closeBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/setup_confirmation_next_button")
	private WebElement lookForGreenElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/button_next")
	private WebElement arrowBtn;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Finish setup\"]")
	private WebElement finishSetupBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/skip_button")
	private WebElement skipBtnElement;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.eero.android.dogfood:id/toolbarView\"]/android.widget.ImageButton")
	private WebElement backbtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/network_name_edit_text")
	private WebElement networkNamElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/network_password_edit_text")
	private WebElement networkPasswordElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Set Up Using a Serial Number\"]")
	private WebElement setupusingSerial;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/zero_day_update_primary_button")
	private WebElement installNowBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/zero_day_update_secondary_button")
	private WebElement mayBeLaterBtn;

	public void clickAddeero() {
		addEeroBtnElement.click();
	}

	public void replaceEero() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(replaceEeroBtnElement)).click();
	}

	public void clickArrowBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(arrowBtn)).click();
	}

	public void clickSkip() {
		skipBtnElement.click();
	}

	public void clickBack() {
		backbtnElement.click();

	}

	public void clickClose() {
		closeBtnElement.click();

	}

	public void startNetworkCreate() {
		startNetworkCreationElement.click();
	}

	public void enterNetworkName(String networkName) {

		networkNamElement.sendKeys(networkName);

	}

	public void setNetworkPassword(String networkPassword) {
		networkPasswordElement.sendKeys(networkPassword);

	}

	public void addAnotherEero() {
		replaceEeroBtnElement.click();
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
}
