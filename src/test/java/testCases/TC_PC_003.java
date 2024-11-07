package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparisonPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_003 extends BaseClass{
	@Test
	public void verify_navigating_to_product_compare_page_from_search_results() {
		HomePage hp = new HomePage(driver, wait);
		hp.setTxtSearch(" ");
		hp.clickBtnSearch();
		
		SearchPage sp = new SearchPage(driver, wait);
		sp.clickProductCompareLink();
		ProductComparisonPage pc = new ProductComparisonPage(driver, wait);
		boolean status = pc.getHeaderDisplayedStatus();
		
		Assert.assertEquals(status, true);
	}
}
