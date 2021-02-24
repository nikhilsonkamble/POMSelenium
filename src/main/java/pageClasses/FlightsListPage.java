package pageClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class FlightsListPage extends PageBaseClass {

	public FlightsListPage(WebDriver driver) {
		super(driver);
	}

	public void checkPageLoading() {
		try {
			Assert.assertEquals(driver.getTitle(),
					"Cheap Air Tickets Online, International Flights to India, Cheap International Flight Deals | SpiceJet Airlines Nikhil");
			logger.log(Status.PASS, "Flights list page opened");
		} catch (AssertionError e) {
			logger.log(Status.FAIL, "Flights list page not opened " + e.getMessage());
			Assert.fail(e.getMessage());
			Assert.fail(e.getMessage(), e);
		}
	}
}
