package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CaptivePortalPage {
	AndroidDriver driver;

	public CaptivePortalPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Guest Wi-Fi\"]")
	public WebElement captiveportalnetworkElement;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Next\"]")
	public WebElement NEXT_BUTTON;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Connect\"]")
	public WebElement connectBtnElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You're connected\"]")
	public WebElement guestNetworkSuccessElement;

	@AndroidFindBy(id = "com.android.chrome:id/toolbar_hairline")
	public WebElement incognitoElement;

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}

	public void guestSuccess() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(guestNetworkSuccessElement));

	}

	public void captivePortalPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(captiveportalnetworkElement)).getText();

	}
}
