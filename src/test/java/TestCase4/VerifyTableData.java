package TestCase4;

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

import Pages4.OmayoHomepage;

public class VerifyTableData {
	WebDriver driver;
	OmayoHomepage omayoHomepage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		omayoHomepage = new OmayoHomepage(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyTableData() {
		
		List<String> expecetdata = new ArrayList<>();
		expecetdata = Arrays.asList("Kishore", "22", "Delhi", "Manish", "25", "Pune", "Praveen", "29", "Bangalore",
				"Dheepthi", "31", "Mumbai");
		assertTrue(omayoHomepage.tabledata().equals(expecetdata));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
