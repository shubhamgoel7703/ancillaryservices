package com.accenture.ancillary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

public class utility {
	static WebDriver driver;

	@Parameters("browser")

	public static WebDriver setup(String browser) throws Exception{

		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("chrome")){

			String Path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\a.srinivasa.murthy\\git\\ancillaryservices\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("ie")){
			//driver = new InternetExplorerDriver();

			//	  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			//	  capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			//	  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//	  capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			//	  capabilities.setCapability("allow-blocked-content", true);
			//	  capabilities.setCapability("allowBlockedContent", true);
			//	  capabilities.setCapability("Allow blocked content", true);
			String Path1 = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", Path1+"/IEDriverServer.exe");
			//			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			//			cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			//			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			//			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//			cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			//			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//			cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			//			cap.setCapability("Allow blocked content", true);
			//          cap.setCapability(CapabilityType.);
			//          cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			//          cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);

			driver = new InternetExplorerDriver();

		}

		else{
			throw new Exception("Browser is not correct");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static By GetBy(String locatorType, String locator){
		try{
			switch(locatorType.toUpperCase()){
			case "ID":
				return By.id(locator);
			case "NAME":
				return By.name(locator);
			case "XPATH":
				return By.xpath(locator);
			case "CLASSNAME":
				return By.className(locator);
			case "LINKTEXT":
				return By.linkText(locator);
			case "PARTIALLINKTEXT":
				return By.partialLinkText(locator);
			case "TAGNAME":
				return By.tagName(locator);
			case "CSS":
				return By.cssSelector(locator);
			default:
			}
		}catch(Exception e){
		}
		return null;
	}

	public static WebElement GetObject(String objectType, String objectValue) {
		try{
			return driver.findElement(GetBy(objectType, objectValue));
		}catch(Exception e ){

		}
		return null;
	}
	public static String GetTimeStamp(String DateFormat) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
		String formattedDate = sdf.format(date);
		date = null;
		sdf = null;
		return formattedDate;
	}

	public static String DateAddDays(String InputDateString,String InputDateFormat,int NoOfDays,int IntervalType){

		try{

			DateFormat formatter = new SimpleDateFormat(InputDateFormat);
			Date InputDate = (Date)formatter.parse(InputDateString);
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(InputDate); 
			cal.add(IntervalType,NoOfDays);
			return formatter.format(cal.getTime());

		}catch (Exception e) {
			return null; 

		}
	}
}