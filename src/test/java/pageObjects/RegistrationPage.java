package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{
	public RegistrationPage(WebDriver driver, WebDriverWait wait){
		super(driver, wait);
	}
	
	@FindBy(xpath = "//input[@id=\"input-firstname\"]")
	WebElement input_firstName;
	@FindBy(xpath = "//input[@id=\"input-lastname\"]")
	WebElement input_lastName;
	@FindBy(xpath = "//input[@id=\"input-email\"]")
	WebElement input_email;
	@FindBy(xpath = "//input[@id=\"input-telephone\"]")
	WebElement input_telephone;
	@FindBy(xpath = "//input[@id=\"input-password\"]")
	WebElement input_password;
	@FindBy(xpath = "//input[@id=\"input-confirm\"]")
	WebElement input_confirmPassword;
	@FindBy(name = "newsletter")
	List<WebElement> radio_subscribe;
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement btn_continue;
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement msg_confirmation;
	@FindBy(name="agree")
	WebElement checkbox_privacy_policy;
	
	public void setFirstName(String fname) {
		input_firstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		input_lastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		input_email.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		input_telephone.sendKeys(telephone);
	}
	public void setPassword(String password) {
		input_password.sendKeys(password);
	}
	public void setConfirmPasswordclick(String password) {
		input_confirmPassword.sendKeys(password);
	}
	public void clickSubscribeRadioBtn(String choice) {
		if(choice == "yes") radio_subscribe.get(0).click();
		else radio_subscribe.get(1).click();
	}
	public void clickContinueBtn() {
		btn_continue.click();
	}
	public void clickAgreeCheckbox() {
		checkbox_privacy_policy.click();
	}
	public String getConfirmationMessage(){
		String txt_msg_confirmation = wait.until(ExpectedConditions.visibilityOf(msg_confirmation)).getText();
		return txt_msg_confirmation;
	}
}
