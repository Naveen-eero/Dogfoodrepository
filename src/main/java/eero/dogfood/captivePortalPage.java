package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class captivePortalPage {
	AndroidDriver driver;

	public captivePortalPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Guest Wi-Fi\"]")
	public WebElement captiveportalnetworkElement;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Next\"]")
	private WebElement nextBtnElement;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Connect\"]")
	private WebElement connectBtnElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You're connected\"]")
	private WebElement guestNetworkSuccessElement;

	public void clickNext() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(nextBtnElement)).click();
	}

	public void clickConnect() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(connectBtnElement)).click();

	}

	public void guestSuccess() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(guestNetworkSuccessElement));

	}
}
