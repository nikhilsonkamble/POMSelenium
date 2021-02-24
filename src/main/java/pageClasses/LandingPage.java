package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='header']//a[@title='SpiceJet']")
	public WebElement spicejet_logo;
	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
	public WebElement departureCity_input;
	@FindBy(id = "ctl00_mainContent_ddl_destinationStation1_CTXT")
	public WebElement arrivalCity_input;
	@FindBy(xpath = "//li[@class='livecl city_selected']")
	public WebElement arrivalCitySelected_li;
	@FindBy(name = "ctl00$mainContent$view_date1")
	public WebElement departDate_input;
	@FindBy(name = "ctl00$mainContent$view_date2")
	public WebElement returnDate_input;
	@FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")
	public WebElement currentDateDep_a;
	@FindBy(xpath = "//a[@class='ui-state-default ui-state-active']")
	public WebElement currentDateArri_a;

	@FindBy(id = "ctl00_mainContent_btn_FindFlights")
	public WebElement findFlights_button;

	public void clickDeparturecity() {
		departureCity_input.click();
		logger.log(Status.INFO, "Departure city input box clicked");
	}

	public void enterDepartureCity(String city) {
		departureCity_input.sendKeys(city);
		logger.log(Status.INFO, "Entered city name " + city + " in departureCity_input");
	}

	public void enterArrivalCity(String city) {
		arrivalCity_input.sendKeys(city);
		wait.until(ExpectedConditions.elementToBeClickable(arrivalCitySelected_li));
		arrivalCitySelected_li.click();
		logger.log(Status.INFO, "Entered city name " + city + " in arrivalCity_input");
	}

	public void enterDepartDate(String string) {
		departDate_input.click();
		wait.until(ExpectedConditions.elementToBeClickable(currentDateDep_a));
		currentDateDep_a.click();
		logger.log(Status.INFO, "Departure date selected from calendar");
	}

	public void enterReturnDate(String string) {
		returnDate_input.click();
		currentDateArri_a.click();
		logger.log(Status.INFO, "Return date selected from calendar");
	}

	public FlightsListPage clickSearchFlightButton() {
		findFlights_button.click();
		logger.log(Status.INFO, "Find flights button clicked");
		return PageFactory.initElements(driver, FlightsListPage.class);
	}

}
