package com.qa.opencart.basetest;
import java.util.Properties;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected ResultsPage resultsPage;
	protected RegistrationPage registrationPage;
	
	protected Properties prop;

	protected SoftAssert softAssert;
	
	
	@Parameters({"browser", "browserversion"})
	
	
	@BeforeTest
	public void setup(String browserName, String browserVersion) {
		df = new DriverFactory();
		prop = df.initProp();
		
			if(browserName!=null) {
				prop.setProperty("browser", browserName);
				prop.setProperty("browserversion", browserVersion);

			}
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
