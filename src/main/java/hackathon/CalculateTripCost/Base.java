package hackathon.CalculateTripCost;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	public void invokeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			// open url with selenium
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  //read project path dynamically
					+ "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")
						+ "\\src\\test\\resources\\drivers\\operadriver.exe");
			driver = new OperaDriver();
		}

		driver.manage().window().maximize();
		// apply implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// System.out.println(System.getProperty("user.dir"));

		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\ObjectRepository\\projectConfig.properties");
				prop.load(file);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void openURL(String websiteURLKey) {
		driver.get(prop.getProperty(websiteURLKey));

	}

	public void close() {
		driver.close();

	}

	public void quitBrowser() {
		driver.quit();

	}

	public void enterText(String xpathKey, String data) {
		getElement(xpathKey).sendKeys(data);
		
		//driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);

	}

	public void click(String xpathKey) {
		getElement(xpathKey).click();
		
		//driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();

	}
	
	public void getData(String xpathKey) {
		String price = getElement(xpathKey).getText();
		System.out.println(price);
		
	}
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		
		if(locatorKey.endsWith("_id")){
			element = driver.findElement(By.id(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_xpath")){
			element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		}
		else if(locatorKey.endsWith("_css")){
			element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
		}
		
		
		return element;
	}
	

}
