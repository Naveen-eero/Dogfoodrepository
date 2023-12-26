package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class clientConnectPage {
	AndroidDriver driver;

	public clientConnectPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Network & internet\"]")
	private WebElement netWorkElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Internet\"]")
	private WebElement interElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Naveen\"]")
	private WebElement networkNameElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Business network\"]")
	private WebElement businessnetworkssidElement;

	@AndroidFindBy(id = "com.android.settings:id/password")
	private WebElement passwordElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IP address\"]/following-sibling::android.widget.TextView")
	private WebElement ipaddressofclient;

	public void clickNetwork() throws InterruptedException {
		netWorkElement.click();
	}

	public void clickInternet() {
		interElement.click();

	}

	public void connectToMain() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(networkNameElement)).click();

	}

	public void connectToBusiness() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(businessnetworkssidElement)).click();

	}

	public void enterPassword(String password) throws InterruptedException {
		try {
			passwordElement.sendKeys(password);
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			connectToBusiness();
		} catch (Exception e) {
			// TODO: handle exception
			connectToBusiness();

		}
	}

	public void getClientIp() throws InterruptedException {

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Ip address\").instance(0))"));
		String ipaddr = ipaddressofclient.getText();
		System.out.println("Ip Address of client device is " + ipaddr);
	}

	public void checkNetworkAvailability(String networkName) {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Naveen\"]"));

	}
}
