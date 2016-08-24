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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AncillaryBookingTest {
	static WebDriver driver;
	public String FF="firefox";
	public String CH="chrome";
	public String IE= "ie";

	@BeforeClass 

	public void loadURL() throws Exception
	{

		driver = utility.setup(FF);
		driver.get("http://52.76.153.228:8080/fortune-web/web/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(priority = 1)

	public void Booking() throws IOException
	{

		utility.GetObject("id","datepicker").sendKeys(utility.GetTimeStamp("MM/dd/yyyy"));
		utility.GetObject("id","datepicker1").sendKeys(utility.DateAddDays(utility.GetTimeStamp("MM/dd/yyyy"), "MM/dd/yyyy",5, Calendar.DATE));

		//	utility.GetObject("id","datepicker").sendKeys(utility.DateAddDays(utility.GetTimeStamp("MM/dd/yyyy"), "MM/dd/yyyy",4, Calendar.MONTH));
		//	utility.GetObject("id","datepicker1").sendKeys(utility.DateAddDays(utility.GetTimeStamp("MM/dd/yyyy"), "MM/dd/yyyy",5, Calendar.DATE));

		Select sel = new Select(utility.GetObject("id", "destination"));
		sel.selectByValue("New York");
		utility.GetObject("id", "searchButton").click();
		utility.GetObject("css", "input[value='Book Now']").click();
		utility.GetObject("id","userName").sendKeys("Chris David");
		utility.GetObject("id","email").sendKeys("david.fortune@gmail.com");
		utility.GetObject("id","phone").sendKeys("9987675436");
		utility.GetObject("id","quantity").clear();
		utility.GetObject("id","quantity").sendKeys("2");
		utility.GetObject("id", "confirmation").click();

		String cnfcNumber = utility.GetObject("xpath", "(//*[@id='top'])//p[2]/strong").getText();
		System.out.println("Booking confirnmation number" +cnfcNumber);
		String Isindex = "Number:";
		int StartingIndex = cnfcNumber.indexOf(Isindex);
		int EndIndex  = cnfcNumber.indexOf(".");
		String PNRNumber = cnfcNumber.substring(StartingIndex+Isindex.length(), EndIndex).trim();
		System.out.println("Confirnmation Number:"+PNRNumber);

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Desktop\\booking.jpg"));
	}

	@Test(priority = 2)

	public void sellAncillaryService()
	{
		utility.GetObject("xpath", "//*[@id='travelInfo']/div[2]/div/div[1]/div[1]/div[2]").click();
		utility.GetObject("xpath", "//*[@id='hotelServices']/div[1]/div/div[1]/div/input").click();
		utility.GetObject("xpath", "html/body/div[3]/div[1]/div/div[1]/div/div/form/input[4]").sendKeys(utility.GetTimeStamp("MM/dd/yyyy"));
		utility.GetObject("xpath", "//*[@id='hotelServices']/div[1]/div/div[1]/div/div[3]/input[3]").click();
		utility.GetObject("xpath", "//*[@id='cart']/i").click();
		utility.GetObject("xpath", "//*[@id='confirmResButton']").click();
		utility.GetObject("xpath", "//*[@id='contentAfter']/a/input").click();

	}

	@AfterTest()

	public void closeBrowser() {
		//	driver.quit();	
	}
}