package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

import io.qameta.allure.Step;

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
	
	@Step("Clicking on register page")
	public RegistrationPage doClicRegisterPage() {
		eleUtil.doClick(registrationLocator);
		return new RegistrationPage(driver);
	}
	
	@Step("Getting login page title")
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
	}

	@Step("Getting login page url")
	public String getLoginPageCurrentURL() {
		return eleUtil.waitForUrlContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	@Step("Forget password link exist or not")
	public boolean isForgetPasswordLinkExist() {
		return eleUtil.doIsDisplayed(forgetPassLocator);
		
	}
	
	@Step("login with user UserName: {0} and Password: {1}")
	public AccountPage doLogin(String userName, String password) {
		eleUtil.doSendKeys(emailLocator, userName);
		eleUtil.doSendKeys(passLocator, password);
		eleUtil.doClick(loginLocator);
	
		return new AccountPage(driver);
	}
	
	
	
}
