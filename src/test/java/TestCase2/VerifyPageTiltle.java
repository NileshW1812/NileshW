package TestCase2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages2.HomePageOmayo;

public class VerifyPageTiltle {
	WebDriver driver;
	HomePageOmayo homepageomayo;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepageomayo = new HomePageOmayo(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyPageTitle2() {

		System.out.println(homepageomayo.getPageTitle());
		assertEquals(homepageomayo.getPageTitle().getText(), "omayo (QAFox.com)");
	}

	@Test(priority = 0, groups = { "sanity" }, enabled = true)
	public void verifyPageTitle3() {

		System.out.println(homepageomayo.getPageTitle());
		assertNotEquals(homepageomayo.getPageTitle().getText(), "omayo (QAFox.co)");
	}

	@Test(priority = -2, groups = { "sanity" }, enabled = true)
	public void verifyRadidioButton() {

		assertTrue(homepageomayo.getBikeRadioButton().isEnabled());
		assertTrue(homepageomayo.getBikeRadioButton().isDisplayed());
		assertFalse(homepageomayo.getBikeRadioButton().isSelected());

	}

	@Test(priority = 5, groups = { "sanity" }, enabled = true)
	public void verifyIfarme() {

		assertTrue(homepageomayo.getIframe().isEnabled());
		assertFalse(homepageomayo.getIframe().isSelected());

	}

	@Test(priority = 10, groups = { "sanity" }, enabled = true)
	public void verifyIfarmetext() {

		homepageomayo.getText().click();
		homepageomayo.getText().sendKeys("This is my text");
	}

	@Test(priority = 2, groups = { "sanity" }, enabled = true)
	public void verifyDropDown() {

		HomePageOmayo.selectDropdown2(homepageomayo.getOlderdrop1(), "doc 3");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
