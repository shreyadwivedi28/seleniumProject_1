package hackathon.CalculateTripCost;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentReportManager;

public class test extends Base{
	
	
	@Test(priority=0)
	public void test1() {
		
		
		logger = report.createTest("Holiday Home Test");
				
		logger.log(Status.INFO, "Initializing the browser");
		invokeBrowser("chrome");
		logger.log(Status.INFO, "Opening the Website");
		openURL("websiteURL");
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		
//		options.addArguments("--disable-notifications");
//
//		WebDriver driver = new ChromeDriver(options);
//		driver.get("https://www.makemytrip.com/");
		logger.log(Status.INFO, "Clicking on Villas&more button");
		click("hotelHome_xpath");
		click("hotelHome_xpath");
		
		//click("extra_css");
		click("extra_xpath");
		
		logger.log(Status.INFO, "Entering the location");
		enterText("searchLocation_xpath", "Nairobi");
		click("selectLocation_xpath");
		
		logger.log(Status.INFO, "Selecting the check-in and checkout date");
		click("checkIn_xpath");
		click("Date_xpath");
		
		click("checkOut_xpath");
		
		logger.log(Status.INFO, "Selecting the number of adults");
		click("selectNoOfPeople_xpath");
		click("noOfPeople_xpath");
		click("apply_xpath");
		
		click("search_xpath");
		logger.log(Status.INFO, "Sorting according to traveller rating");
		click("sort_css");
		click("rating_xpath");
		logger.log(Status.INFO, "Applying Elevator/Lift filter");
		click("showmore_xpath");
		click("lift_xpath");
		
		logger.log(Status.INFO, "Displaying Hotel Name and price");
		System.out.println("************************************");
		System.out.println("1st Hotel name");
		getData("hotel1_xpath");
		System.out.println("1st Hotel price per night");
		getData("price1_xpath");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(price);
		System.out.println("2nd Hotel name");
		getData("hotel2_xpath");
		System.out.println("2nd Hotel price per night");
		getData("price2_xpath");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("3rd Hotel name");
		getData("hotel3_xpath");
		System.out.println("3rd Hotel price per night");
		getData("price3_xpath");
		System.out.println("************************************");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(Status.PASS, "Test executed successfully");
		close();
		
	}
	  @Test(priority=1)
	public void test2() {
		
		
		logger = report.createTest("Cruise Test");
				
		logger.log(Status.INFO, "Initializing the browser");
		invokeBrowser("chrome");
		logger.log(Status.INFO, "Opening the Website");
		openURL("websiteURL");
		//click("cross_xpath");
		click("hotelHome_xpath");
		click("hotelHome_xpath");
		
		logger.log(Status.INFO, "Selecting Cruise");
		click("cruise_xpath");
		click("cruise_xpath");
		
		
		click("clickhere_xpath");
		
//		click("cruiseLine_xpath");
//		click("selectCL_xpath");
//		click("applyCL_xpath");
		
//		click("cruiseShipe_xpath");
//		click("selectCS_xpath");
//		click("applyCS_xpath");
		
		click("showDetails_xpath");
		click("shipFacts_css");
		logger.log(Status.INFO, "Displaying Crew Details");
		getData("crew_xpath");
		
		logger.log(Status.PASS, "Test executed successfully");
		close();
	}
	
	
	@AfterTest
	public void endReport() {
		report.flush();
	}

}
