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
	@FindBy(xpath = "//input[@id='input-firstname']//following-sibling::div[@class='text-danger']")
	WebElement txt_danger_firstName;
	@FindBy(xpath = "//input[@id=\"input-lastname\"]")
	WebElement input_lastName;
	@FindBy(xpath = "//input[@id='input-lastname']//following-sibling::div[@class='text-danger']")
	WebElement txt_danger_lastName;
	@FindBy(xpath = "//input[@id=\"input-email\"]")
	WebElement input_email;
	@FindBy(xpath = "//input[@id='input-email']//following-sibling::div[@class='text-danger']")
	WebElement txt_danger_email;
	@FindBy(xpath = "//input[@id=\"input-telephone\"]")
	WebElement input_telephone;
	@FindBy(xpath = "//input[@id='input-telephone']//following-sibling::div[@class='text-danger']")
	WebElement txt_danger_telephone;
	@FindBy(xpath = "//input[@id=\"input-password\"]")
	WebElement input_password;
	@FindBy(xpath = "//input[@id='input-password']//following-sibling::div[@class='text-danger']")
	WebElement txt_danger_password;
	@FindBy(xpath = "//input[@id=\"input-confirm\"]")
	WebElement input_confirmPassword;
	@FindBy(xpath = "//input[@id='input-confirm']//following-sibling::div[@class='text-danger']")
	WebElement txt_danger_confirmPassword;
	@FindBy(name = "newsletter")
	List<WebElement> radio_subscribe;
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement btn_continue;
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement msg_confirmation;
	@FindBy(name="agree")
	WebElement checkbox_privacyPolicy;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement txt_alert_privacyPolicy;
	
	public void setFirstName(String fname) {
		input_firstName.sendKeys(fname);
	}
	public String getDangerTextFirstName() {
		String danger_txt = wait.until(ExpectedConditions.visibilityOf(txt_danger_firstName)).getText();
		return danger_txt;
	}
	public void setLastName(String lname) {
		input_lastName.sendKeys(lname);
	}
	public String getDangerTextLastName() {
		String danger_txt = wait.until(ExpectedConditions.visibilityOf(txt_danger_lastName)).getText();
		return danger_txt;
	}
	public void setEmail(String email) {
		input_email.sendKeys(email);
	}
	public String getDangerTextEmail() {
		String danger_txt = wait.until(ExpectedConditions.visibilityOf(txt_danger_email)).getText();
		return danger_txt;
	}
	public void setTelephone(String telephone) {
		input_telephone.sendKeys(telephone);
	}
	public String getDangerTextTelephone() {
		String danger_txt = wait.until(ExpectedConditions.visibilityOf(txt_danger_telephone)).getText();
		return danger_txt;
	}
	public void setPassword(String password) {
		input_password.sendKeys(password);
	}
	public String getDangerTextPassword() {
		String danger_txt = wait.until(ExpectedConditions.visibilityOf(txt_danger_password)).getText();
		return danger_txt;
	}
	public void setConfirmPassword(String password) {
		input_confirmPassword.sendKeys(password);
	}
	public String getDangerTextConfirmPassword() {
		String danger_txt = wait.until(ExpectedConditions.visibilityOf(txt_danger_confirmPassword)).getText();
		return danger_txt;
	}
	public void clickSubscribeRadioBtn(String choice) {
		if(choice == "yes") radio_subscribe.get(0).click();
		else radio_subscribe.get(1).click();
	}
	public void clickAgreeCheckbox() {
		checkbox_privacyPolicy.click();
	}
	public String getAlertTextAgreeCheckbox() {
		String alert_txt = wait.until(ExpectedConditions.visibilityOf(txt_alert_privacyPolicy )).getText();
		return alert_txt;
	}
	public void clickContinueBtn() {
		btn_continue.click();
	}
	public String getConfirmationMessage(){
		String txt_msg_confirmation = wait.until(ExpectedConditions.visibilityOf(msg_confirmation)).getText();
		return txt_msg_confirmation;
	}
}
