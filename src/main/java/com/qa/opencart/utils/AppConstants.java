package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_FRACTION_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static final String Account_PAGE_TITLE = "My Account";
	public static final String Account_PAGE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/account";
	public static final List<String> EXPECTED_ACCOUNT_HEADER_LIST = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
	
	public static final String SEARCH_PAGE_FRACTION_TITLE = "Search - ";
	public static final CharSequence ACCOUNT_REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "register";
}

