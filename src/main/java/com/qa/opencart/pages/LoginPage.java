package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By emailLocator = By.id("input-email");
	private By passLocator = By.id("input-password");
	private By loginLocator = By.xpath("//input[@value='Login']");
	private By forgetPassLocator = By.xpath("//a[text()='Forgotten Password']");
	private By logoutLocator = By.linkText("Logout");
	private By registrationLocator = By.linkText("Register");
	
	//Initialize the drive
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	public RegistrationPage doClicRegisterPage() {
		eleUtil.doClick(registrationLocator);
		return new RegistrationPage(driver);
	}
	
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
	}

	public String getLoginPageCurrentURL() {
		return eleUtil.waitForUrlContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME_OUT);
	}
	public boolean isForgetPasswordLinkExist() {
		return eleUtil.doIsDisplayed(forgetPassLocator);
		
	}
	public AccountPage doLogin(String userName, String password) {
		eleUtil.doSendKeys(emailLocator, userName);
		eleUtil.doSendKeys(passLocator, password);
		eleUtil.doClick(loginLocator);
	
		return new AccountPage(driver);
	}
	
}
