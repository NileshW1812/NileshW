package TestCase3;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.DemoQaElement;

public class VerifyTextBox {
	WebDriver driver;
	DemoQaElement demoqaelement;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqaelement = new DemoQaElement(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyUsernameText() {
		assertTrue(demoqaelement.getUsernametext().isEnabled());
		assertTrue(demoqaelement.getUsernametext().isDisplayed());

	}

	@Test(priority = 5, groups = { "sanity" }, enabled = true)
	public void verifySendKeyInUsernameText() {
		demoqaelement.getUsernametext().click();
		demoqaelement.getUsernametext().sendKeys("Nilesh1001");

	}

	@Test(priority = 10, groups = { "sanity" }, enabled = true)
	public void verifyEmailText() {

		assertTrue(demoqaelement.getEmailText().isEnabled());
		assertTrue(demoqaelement.getEmailText().isDisplayed());
	}

	@Test(priority = 8, groups = { "sanity" }, enabled = true)
	public void verifySendKeyEmailText1() {
		demoqaelement.getEmailText().click();
		demoqaelement.getEmailText().sendKeys("nrw@email.com");

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyCurrentAddressText() {

		assertTrue(demoqaelement.getCurrentaddress().isEnabled());
		assertTrue(demoqaelement.getCurrentaddress().isDisplayed());
	}

	@Test(priority = 4, groups = { "sanity" }, enabled = true)
	public void verifySendKeyCurrentAddressText() {

		demoqaelement.getCurrentaddress().click();
		demoqaelement.getCurrentaddress().sendKeys("Nanded Phata pune");

	}

	@Test(priority = -2, groups = { "sanity" }, enabled = true)
	public void verifyPermanentAddressText() {

		assertTrue(demoqaelement.getPermanentaddress().isEnabled());
		assertTrue(demoqaelement.getPermanentaddress().isDisplayed());
	}

	@Test(priority = -3, groups = { "sanity" }, enabled = true)
	public void verifySendKeyPermanentAddressText() {

//		demoqaelement.getPermanentaddress().click();
		demoqaelement.getPermanentaddress().sendKeys("Sutala b.k");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
