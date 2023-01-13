package com.qa.opencart.driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static String highlight;
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is : " + browserName);

		highlight = prop.getProperty("highlight");

		optionsManager = new OptionsManager(prop);
		
		switch (browserName) {
		case "chrome":
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
				break;
		case "firefox":
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;
		case "edge":
			tlDriver.set(new EdgeDriver());
			break;
		case "safari":
			tlDriver.set(new SafariDriver());
			break;
		default:
			System.out.println("Please pass the right browser...");
			break;
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}
	
	//get the local thread copy of the driver
		public synchronized static WebDriver getDriver() {
			return tlDriver.get();
		}
	
	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	/**
	 * take screenshot
	 */
//	public static String getScreenshot() {
////		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
////		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
////		File destination = new File(path);
////		try {
////			FileHandler.copy(srcFile, destination);
////			
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		return path;
//
//	}
}
