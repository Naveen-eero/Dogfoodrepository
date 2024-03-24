package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditMainNetworkPage {
	AndroidDriver driver;

	public EditMainNetworkPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Wifi network name\"]/following-sibling::android.widget.EditText")
	public WebElement networkName;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Wifi network password\"]/following-sibling::android.widget.EditText")
	public WebElement password;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_name")
	public WebElement mainNetWorkNameElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_password")
	public WebElement mainNetworkPasswordElement;

	public String getMainNetworkName() {
		String mainnetworknameString = mainNetWorkNameElement.getText();
		System.out.println(mainnetworknameString);
		return mainnetworknameString;

	}

	public String getNetworkName() {
		String networknameString = networkName.getText();
		System.out.println(networknameString);
		return networknameString;

	}

	public String getMainNetworkPassword() {
		String mainnetworkpassword = mainNetworkPasswordElement.getText();
		System.out.println(mainnetworkpassword);
		return mainnetworkpassword;

	}

	public String getNetworkPassword() {
		String networkpassword = password.getText();
		System.out.println(networkpassword);
		return networkpassword;

	}
}
