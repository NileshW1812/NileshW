package TestCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages.HomePage;

public class VerifyOmayoBlogHomePgae {
	WebDriver driver;
	HomePage homepage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepage = new HomePage(driver);

	}

	@Test(priority = 1, groups = { "e2e" }, enabled = true)
	public void verifyOmayoHomePage() {

//Verify user is on omayo home page	
//		assertEquals(homepage.getPageTitle().getText(), "omayo (QAFox.com)");

//		String value = "doc 1";

//Verify that value is selected from dropdown
//		Utility2.selectValueFromDropdown(homepage.getDropdown(), "doc 1");

//		assertEquals(homepage.getValueSelectedInDropdown(), value);

//Make sure Image is displayed at left upperside
//		assertTrue(homepage.getCollegeImage().isDisplayed());

//Verify table Data
		List<String> expectedTableData = new ArrayList<String>();
//		expectedTableData.add(value)

		expectedTableData = Arrays.asList("Kishore", "22", "Delhi", "Manish", "25", "Pune", "Praveen", "29",
				"Bangalore", "Dheepthi", "31", "Mumbai");
		assertTrue(homepage.getTableData().equals(expectedTableData));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
