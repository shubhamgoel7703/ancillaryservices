package com.accenture.ancillary;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AncillarySauceLabs {
	static WebDriver driver;
	public String FF="firefox";
	public String CH="chrome";
	public String IE= "ie";

	@BeforeClass 

	public void loadURL() throws Exception
	{
		driver = utility.setup("sauce");
		driver.get("http://52.76.153.228:8080/fortune-web/web/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(priority = 1)

	public void Booking() throws IOException, InterruptedException
	{

		utility.GetObject("id","datepicker").sendKeys(utility.GetTimeStamp("MM/dd/yyyy"));
		utility.GetObject("id","datepicker1").sendKeys(utility.DateAddDays(utility.GetTimeStamp("MM/dd/yyyy"), "MM/dd/yyyy",5, Calendar.DATE));
		Select sel = new Select(utility.GetObject("id", "destination"));
		sel.selectByValue("New York");
		utility.GetObject("id", "searchButton").click();
		utility.GetObject("xpath", "html/body/div[3]/div[1]/div/div[2]/div/div/form/input[4]").click();
		utility.GetObject("id","userName").sendKeys("Chris David");
		utility.GetObject("id","email").sendKeys("david.fortune@gmail.com");
		utility.GetObject("id","phone").sendKeys("9987675436");
		utility.GetObject("id","quantity").clear();
		utility.GetObject("id","quantity").sendKeys("2");
		utility.GetObject("id", "confirmation").click();
		
		driver.getPageSource().contains("Thank you. Your reservation is now confirmed.");
		
		Thread.sleep(5000);

		//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("C:\\Desktop\\BookingScrrenshot.jpg"));
		}

	@Test(priority = 2)

	public void sellAncillaryService() throws InterruptedException
	{
		utility.GetObject("xpath", "//*[@id='travelInfo']/div[2]/div/div[1]/div[1]/div[2]").click();
		utility.GetObject("xpath", "//*[@id='hotelServices']/div[1]/div/div[1]/div/input").click();
		utility.GetObject("xpath", "html/body/section[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[3]/div[3]/input").clear();
		utility.GetObject("xpath", "html/body/section[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[3]/div[3]/input").sendKeys(utility.GetTimeStamp("MM/dd/yyyy"));
		utility.GetObject("xpath", "//*[@id='hotelServices']/div[1]/div/div[1]/div/div[3]/input[3]").click();
		utility.GetObject("xpath", "//*[@id='cart']/i").click();
		utility.GetObject("id", "confirmResButton").click();
		driver.getPageSource().contains("Thank you. Your reservation is now updated with the services.");

		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		utility.GetObject("xpath", "html/body/section[1]/div/div/div[1]/div[2]/a/input").click();
		
		driver.getPageSource().contains("Additional Services Booked");
	//	driver.getPageSource().contains("You have saved $1.75 by booking additional services through our website");
		
		Thread.sleep(5000);
		
		//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("C:\\Desktop\\AdditionalServicesScreenShot.jpg"));
		}

	@AfterTest()

	public void closeBrowser() {
		//	driver.quit();	
	}
}
