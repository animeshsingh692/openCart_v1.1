package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_006 extends BaseClass{
	
	@Test(dataProvider="category")
	public void verify_search_by_category(String value, String expectation) {
		HomePage hp = new HomePage(driver, wait);
		hp.clickBtnSearch();
		
		SearchPage sp = new SearchPage(driver, wait);
		sp.setSearchCriteriaInput("iMac");
		sp.setSearchCriteriaCategory(value);
		sp.clickSearchBtn();
		String products_displayed = sp.getProductsDisplayedStatus();
		
		Assert.assertEquals(products_displayed, expectation);	
	}
	
	@DataProvider(name="category")
	String[][] categoryData(){
		String[][] data = {
				{"27", "true"}, //27 is value for option Mac
				{"57", "false"} //57 is value for option Tablets
		};
		return data;
	}
}
