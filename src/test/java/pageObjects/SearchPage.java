package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{
	public SearchPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	@FindBy(id="input-sort")
	WebElement btn_sortButton;
	@FindBy(xpath="//div[@class='product-thumb']//h4//a")
	List<WebElement> list_products;
	@FindBy(xpath="//div[@id='content']//input[@name='search']")
	WebElement txt_searchCriteriaInput;
	@FindBy(name="category_id")
	WebElement dd_searchCriteriaCategory;
	@FindBy(id="button-search")
	WebElement btn_search;
	@FindBy(xpath="//p[normalize-space()='There is no product that matches the search criteria.']")
	WebElement no_products;
	@FindBy(xpath="//div[@class='caption']//a[normalize-space()='iMac']")
	WebElement available_product;
	@FindBy(xpath="//button[contains(@onclick, 'compare')]")
	WebElement btn_compare;
	@FindBy(xpath="//a[normalize-space()='product comparison']")
	WebElement link_comparison_page;
	@FindBy(xpath="//a[@id=\"compare-total\"]")
	WebElement link_product_compare;
	
	public void setSortButton(String option) {
		Select select = new Select(btn_sortButton);
		select.selectByVisibleText(option);
	}
	public String getFirstProduct() {
		return list_products.get(0).getText();
	}
	public String getLastProduct() {
		int size = list_products.size();
		return list_products.get(size-1).getText();
	}
	public void setSearchCriteriaInput(String text) {
		txt_searchCriteriaInput.clear();
		txt_searchCriteriaInput.sendKeys(text);
	}
	public void setSearchCriteriaCategory(String option) {
		Select select = new Select(dd_searchCriteriaCategory);
		select.selectByValue(option);
	}	
	public void clickSearchBtn() {
		btn_search.click();
	}
	public String getProductsDisplayedStatus() {
		try {
			return available_product.getText() == "iMac" ? "true" : "false";
		}catch(Exception e) {
			return "false";
		}
	}
	public void clickCompareBtn() {
		btn_compare.click();
	}
	public void clickComparisonPageLink() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", link_comparison_page);
	}
	public void clickProductCompareLink() {
		link_product_compare.click();
	}
}
