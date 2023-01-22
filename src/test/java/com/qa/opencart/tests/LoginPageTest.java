package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("User Strory 101- Design Login page shopping application")
@Story("US-101: Create Login Page functionality for login page")
public class LoginPageTest extends BaseTest {
	@Description("Login Page Title Test")
	@Severity(SeverityLevel.TRIVIAL)
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Login Page URL Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void loginPageGetCurrentURL() {
		String url = loginPage.getLoginPageCurrentURL();
		Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	

	@Description("Forget password Lint Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void forgetPasswordLinkExistTest() {
		boolean result = loginPage.isForgetPasswordLinkExist();
		Assert.assertTrue(result);
	}

	
	@Description("Login Page Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4)
	public void doLoginTest() {
	  accountPage =	loginPage.doLogin("vandana0927@gmail.com", "Automation");
	  Assert.assertTrue(accountPage.isLogoutLinkExist());
	}
}

