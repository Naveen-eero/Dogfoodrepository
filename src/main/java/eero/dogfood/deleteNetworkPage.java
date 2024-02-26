package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class deleteNetworkPage {
	AndroidDriver driver;

	public deleteNetworkPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"Next\"]")
	public WebElement NextBtn;

	@AndroidFindBy(id = "android.widget.ImageButton")
	public WebElement backBtnElement;

	@AndroidFindBy(xpath = "//android.widget.Button[@test=\"CANCEL\"]")
	public WebElement cancelBtnElement;

	@AndroidFindBy(xpath = "//android.widget.Textview[@text=\"DELETE NETWORK\" or @text=\"Delete network\"]")
	public WebElement deleteConfirmationElement;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"DELETE NETWORK\" or @text=\"Delete network\"]")
	public WebElement deleteConfirmationBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Keep subscription\"]")
	public WebElement keepSubscription;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cancel subscription\"]")
	public WebElement cancelSubscription;

	public void clickNext() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(NextBtn)).click();
		} catch (Exception e) {
			// TODO: handle exception
			deleteConfirmationElement.click();
		}

	}

	public void confirmDelete() {
		try {
			deleteConfirmationElement.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void keepsubscription() {
		try {
			keepSubscription.click();
		} catch (Exception e) {
			// TODO: handle exception

		}
	}

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}

}
