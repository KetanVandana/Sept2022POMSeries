package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.AppConstants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void loginPageGetCurrentURL() {
		String url = loginPage.getLoginPageCurrentURL();
		Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	

	@Test(priority=3)
	public void forgetPasswordLinkExistTest() {
		boolean result = loginPage.isForgetPasswordLinkExist();
		Assert.assertTrue(result);
	}

	@Test(priority=4)
	public void doLoginTest() {
	  accountPage =	loginPage.doLogin("vandana0927@gmail.com", "Automation");
	  Assert.assertTrue(accountPage.isLogoutLinkExist());
	}
}

