package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
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
    /**
     * Initializes WebDriver(driver), ExtentTest(logger) and WebDriverWait object
     * 
     * @param reportName
     *            Name of extent report that will be created after the execution of the test
     * 
     * @return void
     */
	public void setup(String reportName) {
		logger = report.createTest(reportName);
		WebDriverManager.chromedriver().setup();
		logger.generateLog(Status.INFO, "Chrome launched with bonigracia");
		/*
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "/src/main/java/utilities/drivers/chromedriver.exe");
		 */
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}

	@AfterMethod
	public void tearDown() {
		report.flush();
		driver.quit();
	}
}
