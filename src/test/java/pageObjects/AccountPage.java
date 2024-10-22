package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage{
	public AccountPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txt_myAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_logout;
	
	public boolean isMyAccountHeaderDisplayed() {
		try {
			return wait.until(ExpectedConditions.visibilityOf(txt_myAccount)).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogoutBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_logout)).click();
	}
}
