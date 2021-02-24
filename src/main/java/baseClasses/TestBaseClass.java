package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentReportManager;

public class TestBaseClass {
	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	public static WebDriverWait wait;

	/*
	 * public TestBaseClass() { System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir") +
	 * "/src/main/java/utilities/drivers/chromedriver.exe"); driver = new
	 * ChromeDriver(); driver.manage().window().maximize(); wait = new
	 * WebDriverWait(driver, 10); }
	 */
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/java/utilities/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}

	@AfterMethod
	public void tearDown() {
		report.flush();
		driver.close();
	}
}
