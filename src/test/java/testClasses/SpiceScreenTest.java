package testClasses;

import org.testng.annotations.Test;

import baseClasses.PageBaseClass;
import baseClasses.TestBaseClass;
import baseClasses.TopMenuClass;
import pageClasses.LandingPage;
import pageClasses.SpiceScreenPage;

public class SpiceScreenTest extends TestBaseClass {

	PageBaseClass pageBaseClass;
	LandingPage landingPage;
	TopMenuClass topMenu;
	SpiceScreenPage spiceScreenPage;;;

	@Test
	public void openFacebookPage() {
		openBrowser();
		logger = report.createTest("Opening Facebook Page from SpiceJet landing page");
		pageBaseClass = new PageBaseClass(driver);
		landingPage = pageBaseClass.openApplicationURL();
		topMenu = landingPage.getTopMenu();
		spiceScreenPage = topMenu.clickSpiceScreenLink();
		spiceScreenPage.clickFaceboofFooterImage();
	}
}
