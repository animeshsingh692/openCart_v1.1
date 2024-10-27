package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_RF_002 extends BaseClass{
	
	String expected_err_msg_firstName = "First Name must be between 1 and 32 characters!";
	String expected_err_msg_lastName = "Last Name must be between 1 and 32 characters!";
	String expected_err_msg_email = "E-Mail Address does not appear to be valid!";
	String expected_err_msg_telephone = "Telephone must be between 3 and 32 characters!";
	String expected_err_msg_password = "Password must be between 4 and 20 characters!";
	String expected_err_msg_confirmPassword = "Password confirmation does not match password!";
	String expected_err_msg_privacyPolicy = "Warning: You must agree to the Privacy Policy!";
	
	@Test(groups= {"Master"})
	public void verify_mandatory_fields_err() {
		
		try {
			HomePage hp = new HomePage(driver, wait);
			hp.clickMyAccount();
			hp.clickRegister();
			
			RegistrationPage rp = new RegistrationPage(driver, wait);
		
	//		Reset all the input fields to blank
			rp.setFirstName("");
			rp.setLastName("");
			rp.setEmail("");
			rp.setTelephone("");
			rp.setPassword("");
			rp.setConfirmPassword(randomString(4,8)); //Set Confirm Password Value with a different value than password field	
			rp.clickContinueBtn();
			
	//		Validations
			as = new SoftAssert();
			String actual_err_msg_firstName = rp.getDangerTextFirstName();
			String actual_err_msg_lastName = rp.getDangerTextLastName();
			String actual_err_msg_email = rp.getDangerTextEmail();
			String actual_err_msg_telephone = rp.getDangerTextTelephone();
			String actual_err_msg_password = rp.getDangerTextPassword();
			String actual_err_msg_confirmPassword = rp.getDangerTextConfirmPassword();
			String actual_err_msg_privacyPolicy = rp.getAlertTextAgreeCheckbox();
			logger.info("<-----Validating Confirmation message----->");
			as.assertTrue(actual_err_msg_firstName.contains(expected_err_msg_firstName));
			as.assertTrue(actual_err_msg_lastName.contains(expected_err_msg_password));
			as.assertTrue(actual_err_msg_email.contains(expected_err_msg_email));
			as.assertTrue(actual_err_msg_telephone.contains(expected_err_msg_telephone));
			as.assertTrue(actual_err_msg_password.contains(expected_err_msg_password));
			as.assertTrue(actual_err_msg_confirmPassword.contains(expected_err_msg_confirmPassword));
			as.assertTrue(actual_err_msg_privacyPolicy.contains(expected_err_msg_privacyPolicy));
		}
		catch (AssertionError ae) {
	        logger.error("Test Failed due to assertion failure");
	        logger.debug("Debug Logs");
	    } catch (Exception e) {
	        logger.error("Test Failed due to an unexpected exception");
	    }finally {
	        logger.info("<-----Completed Test TC001_AccountRegristrationTest----->");
	    }
	}
}
