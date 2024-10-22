package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	@FindBy(id="input-email")
	WebElement input_email;
	@FindBy(id="input-password")
	WebElement input_password;
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement btn_login;
	
	public void setEmail(String email) {
		input_email.sendKeys(email);
	}
	public void setPassword(String password) {
		input_password.sendKeys(password);
	}
	public void clickLogin() {
		btn_login.click();
	}
}
