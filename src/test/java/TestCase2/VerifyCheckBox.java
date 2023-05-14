package TestCase2;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages.HomePage;
import pages2.DemoqaCheckbox;

public class VerifyCheckBox {
	WebDriver driver;
	DemoqaCheckbox demoqacheckbox;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqacheckbox = new DemoqaCheckbox(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyPageTitle() throws IOException {
		
		driver.findElement(By.xpath("//button[@title='Toggle']")).click();
		driver.findElement(By.xpath("//input[@id='tree-node-desktop']")).click();

		
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
