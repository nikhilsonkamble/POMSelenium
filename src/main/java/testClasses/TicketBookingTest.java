package testClasses;

import java.util.TreeMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClasses.PageBaseClass;
import baseClasses.TestBaseClass;
import pageClasses.FlightsListPage;
import pageClasses.LandingPage;
import utilities.TestDataProvider;

public class TicketBookingTest extends TestBaseClass {
	PageBaseClass pageBaseClass;
	LandingPage landingPage;
	FlightsListPage flightsListPage;

	@Test(dataProvider = "getCheckFlightsData", priority = 1)
	public void checkFlights(TreeMap<String, String> testData) {
		openBrowser();
		logger = report.createTest("Flight check Test");
		pageBaseClass = new PageBaseClass(driver);
		landingPage = pageBaseClass.openApplicationURL();
		landingPage.clickDeparturecity();
		landingPage.enterDepartureCity(testData.get("FromCity"));
		landingPage.enterArrivalCity(testData.get("ToCity"));
		landingPage.enterDepartDate(testData.get("DepartDate"));
//		landingPage.enterReturnDate(testData.get("ReturnDate"));
		flightsListPage = landingPage.clickSearchFlightButton();
		flightsListPage.checkPageLoading();
	}

	@DataProvider
	public Object[][] getCheckFlightsData() {
		return TestDataProvider.getTestData("SpiceJet.xlsx", "Booking", "FlightCheck");
	}

	@Test(priority = 2, enabled = false)
	public void testTestCase() {
		openBrowser();
		logger = report.createTest("test Test case");
		pageBaseClass = new PageBaseClass(driver);
		landingPage = pageBaseClass.openApplicationURL();
		landingPage.clickDeparturecity();
		landingPage.enterDepartureCity("London");
	}
}
