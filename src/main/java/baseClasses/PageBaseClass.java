package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.Status;

import pageClasses.LandingPage;

public class PageBaseClass extends TestBaseClass {
	public PageBaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage openApplicationURL() {
		driver.get("https://www.spicejet.com/");
		logger.log(Status.INFO, "URL launched");
		try {
			// String title = driver.getTitle().trim();
			Assert.assertEquals(driver.getTitle().trim(),
					"SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		} catch (AssertionError e) {
			logger.log(Status.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		} /*
			 * finally { logger.log(Status.FAIL, "Failed"); Assert.fail(); }
			 */

		LandingPage landingPage = new LandingPage(driver);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
}
