package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class SpiceScreenPage extends PageBaseClass {

	public SpiceScreenPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='col-md-4 pl-0 pr-4 recmov'][1]")
	public WebElement movie_image;
	@FindBy(xpath = "//span[@class='facebook-footer']/a")
	public WebElement facebookFooter_a;

	public void clickFaceboofFooterImage() {
		wait.until(ExpectedConditions.elementToBeClickable(facebookFooter_a));
		facebookFooter_a.click();
		logger.log(Status.INFO, "Facebook footer link clicked");
	}
}
