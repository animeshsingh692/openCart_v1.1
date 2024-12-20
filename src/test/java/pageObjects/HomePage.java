package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver, WebDriverWait wait){
		super(driver, wait);
	}
	
	@FindBy(xpath="//span[normalize-space()=\"My Account\"]")
	WebElement link_myAccount;
	
	@FindBy(xpath="//a[normalize-space()=\"Register\"]")
	WebElement link_register;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[normalize-space()=\"Login\"]")
	WebElement link_login;
	
	@FindBy(name="search")
	WebElement txt_search;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btn_search;
	
	public void clickMyAccount() {
		link_myAccount.click();
	}
	
	public void clickRegister() {
		link_register.click();
	}
	
	public void clickLogin() {
		link_login.click();
	}
	
	public void setTxtSearch(String text) {
		txt_search.sendKeys(text);
	}
	
	public void clickBtnSearch() {
		btn_search.click();
	}
}
