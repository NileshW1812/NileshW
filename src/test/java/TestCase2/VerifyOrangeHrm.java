package TestCase2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages2.OrangeHrm;

public class VerifyOrangeHrm {
	WebDriver driver;
	OrangeHrm orangehrm;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		orangehrm = new OrangeHrm(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyOrangeHmsusernametext() {
		orangehrm.getUsernametext().sendKeys("Admin");
		orangehrm.getPasswordtext().sendKeys("12345");

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyTextField() {
		boolean a = orangehrm.getUsernametext().isEnabled();
		boolean a1 = orangehrm.getUsernametext().isDisplayed();
		boolean a2 = orangehrm.getUsernametext().isSelected();

		System.out.println("is Enabled: " + a);
		System.out.println("is Displayed: " + a1);
		System.out.println("is Selected: " + a2);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
