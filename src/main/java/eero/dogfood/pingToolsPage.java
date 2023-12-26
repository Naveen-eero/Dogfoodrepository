package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class pingToolsPage {
	AndroidDriver driver;

	public pingToolsPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
	private WebElement tabBarElement;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"Ping\"]")
	private WebElement pingElement;
	@AndroidFindBy(xpath = "//android.widget.ToggleButton[@text=\"PING\"]")
	private WebElement pingBtnElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Unknown Host google.com\"]")
	private WebElement errorMsgElement;

	public void clickTabBar() {
		tabBarElement.click();
	}

	public void selectPingFromOptions() {
		pingElement.click();
	}

	public void clickPingBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(pingBtnElement)).click();
	}

	public void internetStatuscheck() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(errorMsgElement)).click();
			System.out.println("Device is not online");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Device is online");
		}
	}

}
