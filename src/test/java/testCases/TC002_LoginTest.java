package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Master", "Sanity"})
	public void verify_login() {
		HomePage hp = new HomePage(driver, wait);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver, wait);
		lp.setEmail(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		AccountPage ap = new AccountPage(driver, wait);
		SoftAssert as = new SoftAssert();
		as.assertTrue(ap.isMyAccountHeaderDisplayed());
		as.assertAll();
		ap.clickLogoutBtn();
	}
}
