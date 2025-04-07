package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

/**
 * Test Case: Login with Valid Credentials
 * 
 * Steps: 
 1) Navigate to the application URL 
 2) Navigate to the Login page from the Home page 
 3) Perform login with valid credentials 
 4) Verify login by checking the presence of the 'My Account' page
 */

public class TC2_Login extends BaseClass {

	@Test(groups = { "Sanity", "Master" },priority = 1)
	public void testLoginWithValidCredentials() {

		// 1) Navigate to the application URL
		String applicationUrl = properties.getProperty("appURL");
		driver.get(applicationUrl);
		logger.info("Navigated to application URL: " + applicationUrl);

		// 2) Navigate to the Login page from the Home page
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		logger.info("Clicked on 'My Account' link.");

		LoginPage loginPage = homePage.clickLogin();
		logger.info("Clicked on 'Login' link, navigating to the Login Page.");

		// 3) Perform login with valid credentials
		logger.info("Entering user login credentials...");
		String userEmail = properties.getProperty("email");
		loginPage.setEmail(userEmail);
		logger.info("Entered email: " + userEmail);

		String userPassword = properties.getProperty("password");
		loginPage.setPassword(userPassword);
		logger.info("Entered password.");

		loginPage.clickLogin();
		logger.info("Clicked on the 'Login' button.");

		// 4) Verify login by checking the presence of the 'My Account' page
		MyAccountPage myAccountPage = new MyAccountPage(driver);

		logger.info("Verifying if the 'My Account' page is displayed...");
		boolean isMyAccountPageDisplayed = myAccountPage.isMyAccountPageExists();

		Assert.assertTrue(isMyAccountPageDisplayed, "Login failed: MyAccount page not displayed");
		logger.info("Login successful. 'My Account' page is displayed.");
		
		myAccountPage.clickLogout();
		logger.info("Clicked On 'Logout' button");
	}
	
	/*
	 * Verify Login with invalid credentials (wrong password).
	 * 
	 * "1.Click on " My Account "
	 * 2.Click on Login Page. 
	 * 3.Enter a Invalid email.
	 * 4.Enter the Invalid password. 
	 * 5.Click on ""Login."
	 */

	@Test(groups = "Master",priority = 2)
	public void VerifyLoginWithInvalidCredentials() {
		
				// 1) Navigate to the application URL
				String applicationUrl = properties.getProperty("appURL");
				driver.get(applicationUrl);
				logger.info("Navigated to application URL: " + applicationUrl);

				// 2) Navigate to the Login page from the Home page
				HomePage homePage = new HomePage(driver);
				homePage.clickMyAccount();
				logger.info("Clicked on 'My Account' link.");

				LoginPage loginPage = homePage.clickLogin();
				logger.info("Clicked on 'Login' link, navigating to the Login Page.");

				// 3) Perform login with Invalid credentials
				logger.info("Entering user login credentials...");
				String userEmail = properties.getProperty("InvalidEmail");
				loginPage.setEmail(userEmail);
				logger.info("Entered email: " + userEmail);

				String userPassword = properties.getProperty("InvalidPwd");
				loginPage.setPassword(userPassword);
				logger.info("Entered password.");

				loginPage.clickLogin();
				logger.info("Clicked on the 'Login' button.");
				
				// 4) Verify Error Message is Displayed 
				
				logger.info("Verifying Warning Message is displayed...");
				String WarningMsg = properties.getProperty("Act_WarningMsg");
				String Exp_message = loginPage.isWarningMessage();
				
				if(WarningMsg.equals(Exp_message)) {
					Assert.assertTrue(true,"Warning Message is displayed");
					logger.info("Warning message is displayed");
				}else {
					Assert.assertTrue(false,"Warning Message is not displayed");
					logger.info("Warning message is not displayed");
				}
		}
	
	/*Verify login with a non-registered email.
	 * "1.Click on"" My Account ""
2.Click on Login Page.
3.Enter a non-registered email.
4.Enter the non-registered password.
5.Click on ""Login""."
	 */
	
	@Test(groups = "Master",priority = 3)
	public void VerifyLoginWithNonRegisterEmail(){
		
		// 1) Navigate to the application URL
		String applicationUrl = properties.getProperty("appURL");
		driver.get(applicationUrl);
		logger.info("Navigated to application URL: " + applicationUrl);

		// 2) Navigate to the Login page from the Home page
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		logger.info("Clicked on 'My Account' link.");

		LoginPage loginPage = homePage.clickLogin();
		logger.info("Clicked on 'Login' link, navigating to the Login Page.");

		// 3) Perform login with Invalid credentials
		logger.info("Entering user login credentials...");
		String userEmail = properties.getProperty("New_Email");
		loginPage.setEmail(userEmail);
		logger.info("Entered New email: " + userEmail);

		String userPassword = properties.getProperty("new_Pwd");
		loginPage.setPassword(userPassword);
		logger.info("Entered New password.");

		loginPage.clickLogin();
		logger.info("Clicked on the 'Login' button.");
		
		// 4) Verify Error Message is Displayed 
		
		logger.info("Verifying Warning Message is displayed...");
		String WarningMsg = properties.getProperty("Act_WarningMsg");
		String Exp_message = loginPage.isWarningMessage();
		
		if(WarningMsg.equals(Exp_message)) {
			Assert.assertTrue(true,"Warning Message is displayed");
			logger.info("Warning message is displayed");
		}else {
			Assert.assertTrue(false,"Warning Message is not displayed");
			logger.info("Warning message is not displayed");
		}
		
	}
	
	/*Verify Login with invalid password.
	 * "1.Click on"" My Account ""
2.Click on Login Page.
2.Enter a valid email.
3.Enter the invalid password.
4.Click on ""Login""."
	 */
	
	@Test(groups = "Master",priority = 4)
	public void VerifyLoginWithInvalidPassword() {
		
		// 1) Navigate to the application URL
				String applicationUrl = properties.getProperty("appURL");
				driver.get(applicationUrl);
				logger.info("Navigated to application URL: " + applicationUrl);

				// 2) Navigate to the Login page from the Home page
				HomePage homePage = new HomePage(driver);
				homePage.clickMyAccount();
				logger.info("Clicked on 'My Account' link.");

				LoginPage loginPage = homePage.clickLogin();
				logger.info("Clicked on 'Login' link, navigating to the Login Page.");

				// 3) Perform login with Invalid credentials
				logger.info("Entering user login credentials...");
				String userEmail = properties.getProperty("Email");
				loginPage.setEmail(userEmail);
				logger.info("Entered New email: " + userEmail);

				String userPassword = properties.getProperty("Invalid_Pwd");
				loginPage.setPassword(userPassword);
				logger.info("Entered New password.");

				loginPage.clickLogin();
				logger.info("Clicked on the 'Login' button.");
				
				// 4) Verify Error Message is Displayed 
				
				logger.info("Verifying Warning Message is displayed...");
				String WarningMsg = properties.getProperty("Act_WarningMsg");
				String Exp_message = loginPage.isWarningMessage();
				
				if(WarningMsg.equals(Exp_message)) {
					Assert.assertTrue(true,"Warning Message is displayed");
					logger.info("Warning message is displayed");
				}else {
					Assert.assertTrue(false,"Warning Message is not displayed");
					logger.info("Warning message is not displayed");
				}
		
		
	}
	
	
	
	
	
	}

