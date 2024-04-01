package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BrowserScreen {
	AndroidDriver driver;

	public BrowserScreen(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.android.chrome:id/menu_button")
	public WebElement menuElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"New Incognito tab\"]")
	public WebElement incognitotabElement;

	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	public WebElement urlbarElement;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search or type URL\" or @text=\"Ask me anything…\"]")
	public WebElement searchBarElement;

	@AndroidFindBy(id = "com.microsoft.emmx:id/tab_center_button")
	public WebElement edgeBrowerTabsElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"InPrivate\"]")
	public WebElement edgeBrowserPrivateTabElement;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"New tab\"]")
	public WebElement newtabElement;

	@AndroidFindBy(id = "com.microsoft.emmx:id/edge_bottom_bar_plus_button")
	public WebElement edgeAddNewTabElement;

	@AndroidFindBy(id = "com.microsoft.emmx:id/new_tab_button")
	public WebElement addIncogElement;

	@AndroidFindBy(id = "org.mozilla.firefox:id/privateBrowsingButton")
	public WebElement firefoxIncognitoElement;

	@AndroidFindBy(id = "org.mozilla.firefox:id/counter_box")
	public WebElement firefoxNewTabElement;

	@AndroidFindBy(id = "org.mozilla.firefox:id/new_tab_button")
	public WebElement firefoxaddnewIncogElement;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Search or enter address\"]")
	public WebElement firefoxSearchElement;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search or enter address\"]")
	public WebElement firefoxSearchBoxElement;

	@AndroidFindBy(xpath = "//android.widget.Image[@text=\"Google\"]")
	public WebElement googlePageElement;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Private tabs\"]")
	public WebElement PRIVATE_TAB;

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)).click();

	}

	public void enterUrl(WebElement ele, String urlString) {
		try {
			ele.click();
			ele.sendKeys(urlString);
		} catch (Exception e) {
			// TODO: handle exception
			firefoxSearchBoxElement.sendKeys(urlString);
		}
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
}
