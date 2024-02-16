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
	public WebElement businessnetworkssidElement;

	@AndroidFindBy(id = "com.android.settings:id/password")
	private WebElement passwordElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Naveen Guest\"]")
	private WebElement guestnetworkElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IP address\"]/following-sibling::android.widget.TextView")
	private WebElement ipaddressofclient;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IOT network\"]")
	private WebElement IOTSSIDsubA;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"subnet B ssid as iot\"]")
	private WebElement iOTSUBBElement;

	public void clickNetwork() throws InterruptedException {
		netWorkElement.click();
	}

	public void clickInternet() {
		interElement.click();

	}

	public void connectToNetwork(String networkName) throws InterruptedException {
		Thread.sleep(20000);
		String xpath_locator = String.format("//android.widget.TextView[@text=" + "\"" + "" + networkName + "\"]");

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ networkName + "\").instance(0))"))
				.click();
	}

	public void connectToBusiness() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(businessnetworkssidElement)).click();

	}

	public void connectToIotSubnetA() throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"IOT network\").instance(0))"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(IOTSSIDsubA)).click();

	}

	public void connectToIotSubnetB() throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"subnet B ssid as iot\").instance(0))"));
		iOTSUBBElement.click();

	}

	public void enterPassword(String password) throws InterruptedException {
		try {
			passwordElement.sendKeys(password);
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		} catch (Exception e) {
			// TODO: handle exception

		}
	}

	public String getClientIp() throws InterruptedException {

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Ip address\").instance(0))"));
		String ipaddr = ipaddressofclient.getText();
		System.out.println("Ip Address of client device is " + ipaddr);
		return ipaddr;
	}

	public void checkNetworkAvailability(String networkName) {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Naveen\"]"));

	}

	public void enterPasswordforIOTA(String password) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			passwordElement.sendKeys(password);
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			connectToIotSubnetA();
		} catch (Exception e) {
			// TODO: handle exception
			connectToIotSubnetA();
		}
	}

	public void enterPasswordforIOTB(String password) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			passwordElement.sendKeys(password);
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			connectToIotSubnetB();
		} catch (Exception e) {
			// TODO: handle exception
			connectToIotSubnetB();

		}
	}
}
