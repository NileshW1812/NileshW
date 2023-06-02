package TestCase3;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import Pages3.DropablePage;

public class VerifyGetCssValue {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyGetCssValue() {

		WebElement button = driver.findElement(By.id("btnLogin"));
		System.out.println("Get font-size: " + button.getCssValue("font-size"));
		System.out.println("Get color: " + button.getCssValue("color"));
		System.out.println("Get background: " + button.getCssValue("background"));
		System.out.println("Get font-family: " + button.getCssValue("font-family"));
		System.out.println("Get font-weight: " + button.getCssValue("font-weight"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
