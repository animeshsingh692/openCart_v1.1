package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegristrationTest extends BaseClass{
	String fname = randomString(4,8).toUpperCase();
	String lname = randomString(4,7).toUpperCase();
	String email = randomString(4,8) + "@email.com";
	String password = randomAlphaNumeric() + "@#";
	String phone = randomNumeric(10);
	String subscribeRadioBtnChoice = "yes";
	
	@Test(groups={"Master", "Regression"})
	public void verify_account_registration() throws InterruptedException {
		try {
			logger.info("<-----Starting Test TC001_AccountRegristrationTest----->");
			
			HomePage hp = new HomePage(driver, wait);
			hp.clickMyAccount();
			hp.clickRegister();
			
			RegistrationPage rp = new RegistrationPage(driver, wait);
			rp.setFirstName(fname);
			rp.setLastName(lname);
			rp.setEmail(email);
			rp.setTelephone(phone);
			rp.setPassword(password);
			rp.setConfirmPassword(password);
			rp.clickSubscribeRadioBtn(subscribeRadioBtnChoice);
			rp.clickAgreeCheckbox();
			
			logger.info("<-----All the input fields are filled with the relevant data----->");
			logger.info("<-----Clicking Continue button----->");
			rp.clickContinueBtn();
			
			String actual_confirmation_message = rp.getConfirmationMessage();
			String expected_confirmation_message = "Your Account Has Been Created!";
			
			logger.info("<-----Validating Confirmation message----->");
			as = new SoftAssert();
			as.assertEquals(actual_confirmation_message, expected_confirmation_message);
			as.assertAll();
		}catch (AssertionError ae) {
	        logger.error("Test Failed due to assertion failure");
	        logger.debug("Debug Logs");
	        throw ae;
	    } catch (Exception e) {
	        logger.error("Test Failed due to an unexpected exception");
	    }finally {
	        logger.info("<-----Completed Test TC001_AccountRegristrationTest----->");
	    }
	}
}
