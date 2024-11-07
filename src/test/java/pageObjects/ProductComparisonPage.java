package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductComparisonPage extends BasePage{
	public ProductComparisonPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.wait = wait;
	}
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement text_header;
	
	public boolean getHeaderDisplayedStatus() {
		return wait.until(ExpectedConditions.visibilityOf(text_header)).getText().equals("Product Comparison") ? true : false;
	}
}
