package com.accenture.ancillary;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AncillaryErrorScenario {
	static WebDriver driver;
	public String FF="firefox";
	public String CH="chrome";
	public String IE= "ie";

	@BeforeClass 

	public void Login() throws Exception
	{
		driver = utility.setup(CH);
		driver.get("file:///C:/Users/diksha.sharma/Desktop/fortune-web%20(1)/fortune-web/web/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(priority = 1)

	public void InvalidBookingCredentials() throws IOException
	{

		utility.GetObject("id","datepicker").sendKeys(utility.GetTimeStamp("MM/dd/yyyy"));
		utility.GetObject("id","datepicker1").sendKeys(utility.DateAddDays(utility.GetTimeStamp("MM/dd/yyyy"), "MM/dd/yyyy",5, Calendar.DATE));

		Select sel = new Select(utility.GetObject("id", "destination"));
		sel.selectByValue("New York");
		utility.GetObject("id", "searchButton").click();

		utility.GetObject("css", "input[value='Book Now']").click();
		utility.GetObject("id","userName").sendKeys("Chris David");
		utility.GetObject("id","email").sendKeys("david.fortune");
		utility.GetObject("id","phone").sendKeys("9987675436");
		utility.GetObject("id","quantity").clear();
		utility.GetObject("id","quantity").sendKeys("2");
		utility.GetObject("id", "confirmation").click();

		String errorrMessage = utility.GetObject("id", "errorContent").getText();

		Assert.assertTrue("Text not found!", errorrMessage.contains("Please enter valid information"));
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Desktop\\booking.jpg"));

	}

	@Test(priority = 2)

	public void closeBrowser() {
		driver.quit();
	}
}