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
	public WebElement netWorkElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Internet\"]")
	public WebElement interElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Naveen\"]")
	public WebElement networkNameElement;

	@AndroidFindBy(id = "com.android.settings:id/password")
	public WebElement passwordElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IP address\"]/following-sibling::android.widget.TextView")
	public WebElement ipaddressofclient;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"IOT network\"]")
	public WebElement IOTSSIDsubA;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Disconnect\"]")
	public WebElement disconnectElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Connect\"]")
	public WebElement connectelement;

	public void clickNetwork() throws InterruptedException {
		try {
			netWorkElement.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickInternet() {
		try {
			interElement.click();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void connectToNetwork(String networkName) throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ networkName + "\").instance(0))"))
				.click();
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

	public void clickOnwifidetails(String networkName) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		String xpath_locator = String.format("//android.widget.ImageView[@content-desc=" + "\"" + "" + networkName
				+ " network details" + "\"or @content-desc=\"Settings\"]");
		WebElement wifidetailsElement = driver.findElement(By.xpath(xpath_locator));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(wifidetailsElement)).click();
	}

	public void connectToNetworkwithserial(String networkName, String serialNum) throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ networkName + " - " + serialNum + "\").instance(0))"))
				.click();
	}

	public void clickElement(WebElement element) {
		element.click();
	}

}
