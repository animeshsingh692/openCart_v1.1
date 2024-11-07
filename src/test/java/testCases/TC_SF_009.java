package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_009 extends BaseClass{
	
	@Test
	public void verify_sort_button() {
		HomePage hp = new HomePage(driver, wait);
		hp.setTxtSearch("mac");
		hp.clickBtnSearch();
		
		SearchPage sp = new SearchPage(driver, wait);
		sp.setSortButton("Name (Z - A)");
		
		String first_product = sp.getFirstProduct();
		String last_product = sp.getLastProduct();
		
		if(first_product.equals("MacBook Pro") && last_product.equals("iMac")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}	
	}
}
