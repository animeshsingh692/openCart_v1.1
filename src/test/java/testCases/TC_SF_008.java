package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparisonPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_008 extends BaseClass{
	
	@Test
	public void verify_navigating_to_productCompare_from_search() {
		HomePage hp = new HomePage(driver, wait);
		hp.setTxtSearch("iMac");
		SearchPage sp = new SearchPage(driver, wait);
		sp.clickCompareBtn();
		sp.clickComparisonPageLink();
		ProductComparisonPage pc = new ProductComparisonPage(driver, wait);
		boolean header_status = pc.getHeaderDisplayedStatus();
		Assert.assertEquals(header_status, true);
	}
}
