package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PingToolsPage {

	AndroidDriver driver;

	public PingToolsPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	public WebElement tabBarElement;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"Ping\"]")
	public WebElement pingElement;
	@AndroidFindBy(xpath = "//android.widget.ToggleButton[@text=\"PING\"]")
	public WebElement pingBtnElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Unknown Host google.com\"]")
	public WebElement errorMsgElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"From 192.168.16.1\"]")
	public WebElement PING_FROM_GATEWAY;

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}

	public String internetStatuscheck() {
		try {
			if (PING_FROM_GATEWAY.isDisplayed()) {

				System.out.println("Device is not online");

				return "device offline";
			} else {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(errorMsgElement));
			}
			return "device offline";
		} catch (Exception e) {
			System.out.println("Device is online");
			return "device online";
		}
	}

}
