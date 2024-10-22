package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"Data Driven Testing"})
	public void verify_login_ddt(String email, String password, String status) {
		logger.info("<-----Starting Test TC003_LoginTestDDT----->");
		HomePage hp = new HomePage(driver, wait);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver, wait);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		AccountPage ap = new AccountPage(driver, wait);
		SoftAssert as = new SoftAssert();
		if(status.toLowerCase().equals("valid")) {
			if(ap.isMyAccountHeaderDisplayed()) {
				ap.clickLogoutBtn();
				as.assertTrue(true);
			}else {
				as.assertTrue(false);
			}
		}
		if(status.toLowerCase().equals("invalid")) {
			if(ap.isMyAccountHeaderDisplayed()) {
				ap.clickLogoutBtn();
				as.assertTrue(false);
			}else {
				as.assertTrue(true);
			}
		}		
		as.assertAll();
		logger.info("<-----Finished Test TC003_LoginTestDDT----->");
	}
}
