package com.qa.opencart.tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.AppConstants;


public class AccountPageTest extends BaseTest{
	
		
	@BeforeClass
	public void accSetup() {
		accountPage = loginPage.doLogin("vandana0927@gmail.com", "Automation");
	}

	@Test(priority = 1)
	public void accPageTitleTest() {
		String accTitle = accountPage.getAccPageTitle();
		Assert.assertEquals(accTitle, AppConstants.Account_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void accPageCurrentURLTest() {
		String accPageCurrentUrl = accountPage.getAccPageCurrentURL();
		Assert.assertEquals(accPageCurrentUrl, AppConstants.Account_PAGE_URL);
	}
	
	@Test(priority = 3)
	private void accPageLogoutLinkTest() {
		Assert.assertTrue(accountPage.isLogoutLinkExist());
	}

	@Test(priority = 4)
	public void accPageHeaderDisplay() {
		List<String> accPageHeaderList = accountPage.accountPageHeaderDisplayed();
		Assert.assertEquals(accPageHeaderList, AppConstants.EXPECTED_ACCOUNT_HEADER_LIST);

	}
	
	@DataProvider
	public Object[][] searchProductList() {
		return new Object[][] {
			{"Macbook"},
			{"Imac"},
			{"Samsung"},
			{"Iphone"}
		};
	}
	
	@Test(priority = 5, dataProvider = "searchProductList")
	public void accPageSearchItemTest(String product) throws InterruptedException {
		resultsPage = accountPage.accPageItemSearch(product);
		
		String actualTitle = resultsPage.getSearchPageTitle(product);
		Assert.assertEquals(actualTitle, AppConstants.SEARCH_PAGE_FRACTION_TITLE + product);

	}
	
	
	
}
