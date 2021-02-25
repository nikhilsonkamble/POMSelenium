package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import pageClasses.SpiceScreenPage;

public class TopMenuClass extends PageBaseClass {

	public TopMenuClass(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li[@id='SpecialAssistanceToPLink']/a")
	public WebElement spiceClub_link;
	@FindBy(xpath = "//li[@id='spicescreen']/a")
	public WebElement spiceScreen_link;

	public void clickspiceClubLink() {
		spiceClub_link.click();
		logger.log(Status.INFO, "Spice Club menu link clicked");
	}

	public SpiceScreenPage clickSpiceScreenLink() {
		spiceScreen_link.click();
		logger.log(Status.INFO, "Spice screen menu link clicked");
		return PageFactory.initElements(driver, SpiceScreenPage.class);
	}
}
