package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class internetStatusPage {

	AndroidDriver driver;

	public internetStatusPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/internetStatusTextView")
	private WebElement internetstatElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"eero Internet Backup\"]")
	private WebElement backupEnablElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Download\"]/following-sibling::android.widget.TextView")
	private WebElement downloadSpeedElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Upload\"]/following-sibling::android.widget.TextView")
	private WebElement uploadSpeedElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Updated\"]/following-sibling::android.widget.TextView")
	private WebElement updatedElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/runSpeedTestButton")
	private WebElement runspeedTestBtnElement;

	void clickbackup() throws InterruptedException {
		backupEnablElement.click();
		Thread.sleep(1000);
	}

	void getDownloadSpeed() {
		String downloadspeedString = downloadSpeedElement.getText();
		System.out.println("Downloadspeed of network is " + downloadspeedString);
	}

	void getUploadSpeed() {
		String uploadSpeedString = uploadSpeedElement.getText();
		System.out.println("UploadSpeed of network is " + uploadSpeedString);
	}

	void getUpdatedTime() {
		String updatedTimeString = updatedElement.getText();
		System.out.println("Updated time of speed test " + updatedTimeString);
	}

	void runSpeedTest() {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Run speed test\").instance(0))"));
		runspeedTestBtnElement.click();
	}
}
