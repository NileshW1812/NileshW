package TestCase2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages.HomePage;
import pages2.HomePageOmayo;

public class VerifyApplicationHomePage {
	WebDriver driver;
	HomePageOmayo homepageomayo;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepageomayo = new HomePageOmayo(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyPageTitle() {
		driver.getTitle();
		assertEquals(homepageomayo.getPageTitle().getText(), "omayo (QAFox.com)");
	}

	@Test(priority = 0, groups = { "sanity" }, enabled = true)

	public void verifyRadioButtonBehavoiurs() throws IOException {

		assertTrue(homepageomayo.getBikeRadioButton().isEnabled());
		assertTrue(homepageomayo.getBicycleRadioButton().isEnabled());
		assertTrue(homepageomayo.getCarRadioButton().isEnabled());

//		assertFalse(homepageomayo.getBikeRadioButton().isSelected());
//		assertFalse(homepageomayo.getBicycleRadioButton().isSelected());
//		assertFalse(homepageomayo.getCarRadioButton().isSelected());

		assertTrue(homepageomayo.getBikeRadioButton().isDisplayed());
		assertTrue(homepageomayo.getBicycleRadioButton().isDisplayed());
		assertTrue(homepageomayo.getCarRadioButton().isDisplayed());

	}

	@Test(priority = 0, groups = { "sanity" }, enabled = true)

	public void verifyCheckBox() {

//		assertFalse(homepageomayo.getPenCheckbox().isSelected());
//		assertFalse(homepageomayo.getBookCheckbox().isSelected());
//		assertFalse(homepageomayo.getLaptopCheckbox().isSelected());
//		assertFalse(homepageomayo.getBagCheckbox().isSelected());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
