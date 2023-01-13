package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

public class AccountPage {

	private WebDriver driver;
	
	private ElementUtil eleUtil;
	
	private By searchlocator = By.xpath("//input[@name='search']");
	private By searchBtnLocator = By.xpath("//button[@class='btn btn-default btn-lg']");
	private By logoutLinkLocator = By.linkText("Logout");
	private By accPageHeaderLocator = By.tagName("h2");	
	private By productsLocator = By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccPageTitle() {
		return eleUtil.waitForTitleContains(AppConstants.Account_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public String getAccPageCurrentURL() {
		return eleUtil.waitForUrlIs(AppConstants.Account_PAGE_URL,TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.doIsDisplayed(logoutLinkLocator);
	}
	
	public List<String> accountPageHeaderDisplayed() {
		List<WebElement>  accPageHeaderList = eleUtil.getElements(accPageHeaderLocator);
		List<String> accPageHeaderStrList =  new ArrayList<String>();
		for(WebElement e: accPageHeaderList) {
			String headerText = e.getText();
			accPageHeaderStrList.add(headerText);
			System.out.println(headerText);
		}
		return accPageHeaderStrList;
	}
	
	public ResultsPage accPageItemSearch(String item) {
		eleUtil.doSendKeys(searchlocator, item);
		eleUtil.doClick(searchBtnLocator);
		
		return new ResultsPage(driver);
		
	}
}
